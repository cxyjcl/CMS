package com.dcs.dao;

import com.dcs.pojo.CampusActivities;

public interface CampusActivitiesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CampusActivities record);

    int insertSelective(CampusActivities record);

    CampusActivities selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CampusActivities record);

    int updateByPrimaryKey(CampusActivities record);
}