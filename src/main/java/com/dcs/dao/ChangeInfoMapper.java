package com.dcs.dao;

import com.dcs.pojo.ChangeInfo;

public interface ChangeInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ChangeInfo record);

    int insertSelective(ChangeInfo record);

    ChangeInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ChangeInfo record);

    int updateByPrimaryKey(ChangeInfo record);
}