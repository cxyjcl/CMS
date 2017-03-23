package com.dcs.dao;

import com.dcs.pojo.MoneyInfo;

public interface MoneyInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MoneyInfo record);

    int insertSelective(MoneyInfo record);

    MoneyInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MoneyInfo record);

    int updateByPrimaryKey(MoneyInfo record);
}