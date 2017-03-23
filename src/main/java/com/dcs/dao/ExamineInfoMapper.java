package com.dcs.dao;

import com.dcs.pojo.ExamineInfo;

public interface ExamineInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExamineInfo record);

    int insertSelective(ExamineInfo record);

    ExamineInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExamineInfo record);

    int updateByPrimaryKey(ExamineInfo record);
}