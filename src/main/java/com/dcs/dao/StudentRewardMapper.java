package com.dcs.dao;

import com.dcs.pojo.StudentReward;

public interface StudentRewardMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StudentReward record);

    int insertSelective(StudentReward record);

    StudentReward selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StudentReward record);

    int updateByPrimaryKey(StudentReward record);
}