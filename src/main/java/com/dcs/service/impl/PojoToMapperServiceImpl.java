package com.dcs.service.impl;

import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.dcs.dao.PojoToMapperDao;
import com.dcs.dto.ListInfoDto;
import com.dcs.pojo.ListInfo;
import com.dcs.pojo.request.Page;
import com.dcs.service.PojoToMapperService;
import com.dcs.service.excel.Excel2CadresInfo;
import com.dcs.util.TableUtils;

/**
 * 
 * ClassName: PojoToMapperServiceImpl
 * @Description: TODO
 * @author pohoulong
 * @date 2017年3月28日 下午2:09:16
 */
@Service("infoService")
public class PojoToMapperServiceImpl implements PojoToMapperService{
	
	@Autowired
	private PojoToMapperDao dao;

	public int deleteList(String value,Integer listId) throws Exception {		
		int num = dao.deleteList(listId);
		return num;
	}
	
	public int delete(String value,Integer infoId) throws Exception{
		int num = dao.deleteInfo(value, infoId);
		return num;
	}

	public HashMap selectInfo(String value,String infoId) throws Exception {		
		HashMap map = dao.selectInfo(value,infoId);
		return map;
	}
	
	@Override
	public void insert(String value, InputStream input, int id) throws Exception {
		Class excel= Class.forName("com.dcs.service.excel.Excel2"+value);
		String table = "t_cadres_info";
		Object instance = excel.newInstance();
		Method declaredMethod = excel.getMethod("excel", InputStream.class);
		ArrayList list = (ArrayList) declaredMethod.invoke(instance, input);
		System.out.println(list);
		HashMap<String,Object> map = (HashMap<String,Object>) BeanUtils.describe(list.get(0));
		//这里要删除一个class的原因是他在转化的时候会带上一个class键值对
		map.remove("class");
		map.remove("id");
		map.remove("infoId");
		System.out.println(map);
		map = TableUtils.upToLow(map);
		dao.insertInfo(table, map);
	}

	@Override
	public int update(String value, Integer divId, HashMap infoMap)
			throws Exception {
		Integer id= dao.updateInfo(value,infoMap,divId);
		return id;
	}

	@Override
	public ListInfo findListInfo(String creator,Page page, Integer listId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ListInfo> selectListInfo(Integer listId, String level,Page page)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
