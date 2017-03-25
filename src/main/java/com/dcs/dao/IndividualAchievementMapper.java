package com.dcs.dao;

import com.dcs.pojo.IndividualAchievement;

public interface IndividualAchievementMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IndividualAchievement record);

    int insertSelective(IndividualAchievement record);

    IndividualAchievement selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IndividualAchievement record);

    int updateByPrimaryKey(IndividualAchievement record);
}