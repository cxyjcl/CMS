package com.dcs.dao;

import com.dcs.pojo.PartyBuild;

public interface PartyBuildMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PartyBuild record);

    int insertSelective(PartyBuild record);

    PartyBuild selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PartyBuild record);

    int updateByPrimaryKey(PartyBuild record);
}