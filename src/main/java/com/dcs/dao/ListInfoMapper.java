package com.dcs.dao;

import com.dcs.pojo.ListInfo;

public interface ListInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ListInfo record);

    int insertSelective(ListInfo record);

    ListInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ListInfo record);

    int updateByPrimaryKey(ListInfo record);
}