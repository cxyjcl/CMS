package com.dcs.dao;

import com.dcs.pojo.GradeInfo;

public interface GradeInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GradeInfo record);

    int insertSelective(GradeInfo record);

    GradeInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GradeInfo record);

    int updateByPrimaryKey(GradeInfo record);
}