package com.dcs.dao;

import com.dcs.pojo.LectureInfo;

public interface LectureInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LectureInfo record);

    int insertSelective(LectureInfo record);

    LectureInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LectureInfo record);

    int updateByPrimaryKey(LectureInfo record);
}