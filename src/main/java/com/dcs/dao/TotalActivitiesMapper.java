package com.dcs.dao;

import com.dcs.pojo.TotalActivities;

public interface TotalActivitiesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TotalActivities record);

    int insertSelective(TotalActivities record);

    TotalActivities selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TotalActivities record);

    int updateByPrimaryKey(TotalActivities record);
}