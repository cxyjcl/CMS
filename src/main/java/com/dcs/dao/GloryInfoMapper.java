package com.dcs.dao;

import com.dcs.pojo.GloryInfo;

public interface GloryInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GloryInfo record);

    int insertSelective(GloryInfo record);

    GloryInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GloryInfo record);

    int updateByPrimaryKey(GloryInfo record);
}