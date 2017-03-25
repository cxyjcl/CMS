package com.dcs.dao;

import com.dcs.pojo.GraduateDispatch;

public interface GraduateDispatchMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GraduateDispatch record);

    int insertSelective(GraduateDispatch record);

    GraduateDispatch selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GraduateDispatch record);

    int updateByPrimaryKey(GraduateDispatch record);
}