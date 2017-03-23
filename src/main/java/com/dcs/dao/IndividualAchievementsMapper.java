package com.dcs.dao;

import com.dcs.pojo.IndividualAchievements;

public interface IndividualAchievementsMapper {
    int insert(IndividualAchievements record);

    int insertSelective(IndividualAchievements record);
}