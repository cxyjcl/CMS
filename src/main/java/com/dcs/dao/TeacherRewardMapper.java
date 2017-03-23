package com.dcs.dao;

import com.dcs.pojo.TeacherReward;

public interface TeacherRewardMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TeacherReward record);

    int insertSelective(TeacherReward record);

    TeacherReward selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TeacherReward record);

    int updateByPrimaryKey(TeacherReward record);
}