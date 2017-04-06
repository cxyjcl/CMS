package com.dcs.service.impl;

import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcs.constants.ListCodeEnum;
import com.dcs.dao.PojoToMapperDao;
import com.dcs.dto.ListInfoDto;
import com.dcs.pojo.ListInfo;
import com.dcs.pojo.request.Page;
import com.dcs.service.PojoToMapperService;
import com.dcs.service.UserService;
import com.dcs.service.excel.TitleService;
import com.dcs.util.StringToMap;
import com.dcs.util.TableUtils;
import com.dcs.vo.UpdateVo;

/**
 * 
 * ClassName: PojoToMapperServiceImpl
 * @author pohoulong
 * @date 2017年3月28日 下午2:09:16
 */
@Service("infoService")
public class PojoToMapperServiceImpl implements PojoToMapperService{
	
	@Autowired
	private PojoToMapperDao dao;

	@Autowired
	private UserService userService;

	public List<LinkedHashMap> selectInfo(String code,Integer infoId,Page page) throws Exception {		
    	String table = ListCodeEnum.fromCode(code).getValue();
		List<LinkedHashMap> mapList = dao.selectInfo(table,infoId,page);
		return mapList;
	}
	
	public LinkedHashMap selectCol(String code) throws Exception{
		String name = ListCodeEnum.fromCode(code).getInstance();
		Class instance= Class.forName("com.dcs.pojo."+name);
		Object obj = instance.newInstance();
		LinkedHashMap mapString = StringToMap.getData(obj.toString());
		return mapString;
	}
	
	@Override
	public int insert(String code, InputStream input,ListInfo listInfo) throws Exception{
		ListCodeEnum codeEnum = ListCodeEnum.fromCode(code);
		String value = codeEnum.getInstance();
		Class excel= Class.forName("com.dcs.service.excel.Excel"+value);
		String table = codeEnum.getValue();
		Integer max = dao.selectMax(table);
		if(max==null){
			max=0;
		}
		Integer infoId = max+1;
		Object instance = excel.newInstance();
		Method declaredMethod = excel.getMethod("upload", InputStream.class);
		ArrayList list = (ArrayList) declaredMethod.invoke(instance, input);
		//这里我不用mybatis的for循环的原因是因为里面涉及到复杂的删除动作mybatis不好做。
		for(int i =0 ; i<list.size();i++){
			HashMap<String,Object> map = (HashMap<String,Object>) BeanUtils.describe(list.get(0));
			//这里要删除一个class的原因是他在转化的时候会带上一个class键值对
			map.remove("class");
			map.remove("id");
			map = TableUtils.upToLow(map);
			map.put("info_id", infoId);
			map.put("data_status", "001");
			dao.insertInfo(table, map);
		}
		Integer id = listInfo.getCreator();
		String level = userService.selectLevel(id);
		TitleService titleService =  new TitleService();
		String title = titleService.excel(input);
		listInfo.setTitle(title);
		listInfo.setInfoId(infoId);
		listInfo.setUserLevel(level);
		Integer num = dao.insertList(listInfo);
		return num;
	}

	@Override
	public int update(String value, UpdateVo vo)
			throws Exception {
		Integer id= dao.updateInfo(value,vo);
		System.out.println(id);
		return id;
	}

	@Override
	public List<ListInfoDto> findListInfo(String value,String level,Page page, String listId) throws Exception {
		return dao.findListInfo(value,level,page, listId);
	}

	@Override
	public List<ListInfoDto> selectListInfo(Integer listId, String level,Page page)
			throws Exception {
		return dao.selectListInfo(listId, level, page);
	}

	@Override
	public int deleteList(Integer id, Integer reviser) throws Exception {
		Integer num = dao.deleteList(id,reviser);
		return num;
	}

	@Override
	public int delete(String table, int id,Integer reviser) throws Exception {
		Integer num = dao.deleteInfo(table,id,reviser);
		return num;
	}

	@Override
	public List<ListInfoDto> selectLimit() {
		return dao.selectLimit();
	}

	@Override
	public String selectTitle(String code, Integer infoId) {
		return dao.selectTitle(code,infoId);
	}
	
}
