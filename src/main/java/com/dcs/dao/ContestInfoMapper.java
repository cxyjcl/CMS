package com.dcs.dao;

import com.dcs.pojo.ContestInfo;

public interface ContestInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ContestInfo record);

    int insertSelective(ContestInfo record);

    ContestInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ContestInfo record);

    int updateByPrimaryKey(ContestInfo record);
}