package com.dcs.service.impl;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcs.constants.DataStatusEnum;
import com.dcs.constants.LevelEnum;
import com.dcs.constants.ListCodeEnum;
import com.dcs.dao.PojoToMapperDao;
import com.dcs.dto.ListInfoDto;
import com.dcs.pojo.ListInfo;
import com.dcs.pojo.WordInfo;
import com.dcs.pojo.request.Page;
import com.dcs.service.PojoToMapperService;
import com.dcs.service.UserService;
import com.dcs.service.excel.TitleService;
import com.dcs.util.InputToFile;
import com.dcs.util.JodUtils;
import com.dcs.util.StringToMap;
import com.dcs.util.TableUtils;
import com.dcs.util.XlsDataSetBeanFactory;
import com.dcs.vo.UpdateVo;

/**
 * 
 * ClassName: PojoToMapperServiceImpl
 * 
 * @author pohoulong
 * @date 2017年3月28日 下午2:09:16
 */
@Service("infoService")
public class PojoToMapperServiceImpl implements PojoToMapperService {

	@Autowired
	private PojoToMapperDao dao;

	@Autowired
	private UserService userService;

//	public OutputStream download(){
//		
//	}
	
	public List<LinkedHashMap> selectInfo(String code, Integer infoId, Page page)
			throws Exception {
		String table = ListCodeEnum.fromCode(code).getValue();
		List<LinkedHashMap> mapList = dao.selectInfo(table, infoId, page);
		return mapList;
	}

	public LinkedHashMap selectCol(String code) throws Exception {
		String name = ListCodeEnum.fromCode(code).getInstance();
		Class instance = Class.forName("com.dcs.pojo." + name);
		Object obj = instance.newInstance();
		LinkedHashMap mapString = StringToMap.getData(obj.toString());
		return mapString;
	}

	@Override
	public int insert(String code, InputStream input, ListInfo listInfo)
			throws Exception {
		ListCodeEnum codeEnum = ListCodeEnum.fromCode(code);
		String value = codeEnum.getInstance();
		String table = codeEnum.getValue();
		Integer id = listInfo.getCreator();
		String level = userService.selectLevel(id);
		if(value.equals("WordInfo")){
			Integer max = dao.selectMax(table,null);
			if (max == null) {
				max = 0;
			}
			Integer infoId = max + 1;
			WordInfo info = new WordInfo();
			info.setInfoId(infoId);
			info.setNumber(code);
			String random = infoId+UUID.randomUUID().toString();
			String url = this.getClass().getResource("/").toURI().getPath().replace("WEB-INF/classes/","temp/"+random);
			JodUtils.transform(input, url);
			info.setUrl(random+".doc");
		 	int num=dao.insertWord(info);
			listInfo.setInfoId(infoId);
			listInfo.setUserLevel(level);
			dao.insertList(listInfo);
			return num;
		} else{
			Integer max = dao.selectMax(table,DataStatusEnum.NORMAL_USED.getCode());
			if (max == null) {
				max = 0;
			}
			Integer infoId = max + 1;
			Class excel = Class.forName("com.dcs.service.excel.Excel" + value);
			Object instance = excel.newInstance();
			Method declaredMethod = excel.getMethod("upload", InputStream.class);
			LinkedList<HashMap<String, Object>> list= (LinkedList<HashMap<String, Object>>) declaredMethod.invoke(instance, input);
			TitleService titleService = new TitleService();
			String title = (String)list.getLast().get("title");
			listInfo.setTitle(title);
			listInfo.setInfoId(infoId);
			listInfo.setUserLevel(level);
			Integer num = dao.insertList(listInfo);
			//删除title
			list.removeLast();
			//添加info
			for (int i = 0; i < list.size(); i++) {
				HashMap<String, Object> map =list.get(i);
				map.put("info_id", infoId);
				map.put("data_status", "001");
				dao.insertInfo(table, map);
			}
			return num;
		}
	}

//	public int insert(String code, InputStream input, ListInfo listInfo,
//			String flag) throws Exception {
//		ListCodeEnum codeEnum = ListCodeEnum.fromCode(code);
//		String value = codeEnum.getInstance();
//		Class<? extends ListCodeEnum> beanClass = codeEnum.getClass();
//		String table = codeEnum.getValue();
//		Integer max = dao.selectMax(table);
//		if (max == null) {
//			max = 0;
//		}
//		Integer infoId = max + 1;
//		String fileName = table;
//		List createBeans = XlsDataSetBeanFactory.createBeans(fileName,
//				input, beanClass);
//		for (int i = 0; i < createBeans.size(); i++) {
//			HashMap<String, Object> map = (HashMap<String, Object>) BeanUtils
//					.describe(createBeans.get(0));
//			// 这里要删除一个class的原因是他在转化的时候会带上一个class键值对
//			map.remove("class");
//			map.remove("id");
//			map = TableUtils.upToLow(map);
//			map.put("info_id", infoId);
//			map.put("data_status", "001");
//			dao.insertInfo(table, map);
//		}
//		Integer id = listInfo.getCreator();
//		String level = userService.selectLevel(id);
//		TitleService titleService = new TitleService();
//		String title = titleService.excel(input);
//		listInfo.setTitle(title);
//		listInfo.setInfoId(infoId);
//		listInfo.setUserLevel(level);
//		Integer num = dao.insertList(listInfo);
//		return num;
//	}

	@Override
	public int update(String value, UpdateVo vo) throws Exception {
		Integer id = dao.updateInfo(value, vo);
		System.out.println(id);
		return id;
	}

	@Override
	public List<ListInfoDto> findListInfo(String value, String level,
			Page page, String listId) throws Exception {
		return dao.findListInfo(value, level, page, listId);
	}

	@Override
	public List<ListInfoDto> selectListInfo(Integer listId, String level,
			Page page) throws Exception {
		return dao.selectListInfo(listId, level, page);
	}

	@Override
	public int deleteList(Integer id, Integer reviser) throws Exception {
		Integer num = dao.deleteList(id, reviser);
		return num;
	}

	@Override
	public int delete(String table, int id, Integer reviser) throws Exception {
		Integer num = dao.deleteInfo(table, id, reviser);
		return num;
	}

	@Override
	public List<ListInfoDto> selectLimit() {
		//每个都要加个level
		List<ListInfoDto> dtoList = dao.selectLimit();
		List<ListInfoDto> newList = new ArrayList<ListInfoDto>();
		for(int i=0;i<dtoList.size();i++){
			ListInfoDto dto = dtoList.get(i);
			String level = dto.getUserLevel();
			String code = LevelEnum.fromValue(level).getCode();
			dto.setUserLevel(code);
			newList.add(dto);
		}
		return newList;
	}

	@Override
	public String selectTitle(String code, Integer infoId) {
		return dao.selectTitle(code, infoId);
	}

	@Override
	public String selectWord(String id) {
		String name = dao.selectWord(id);
		return name;
	}

	@Override
	public Integer countInfo(String table, Integer id) {
		return dao.countInfo(table, id);
	}

	@Override
	public Integer countList(Integer code, String level) {
		// TODO Auto-generated method stub
		return dao.countList(code, level);
	}
}
