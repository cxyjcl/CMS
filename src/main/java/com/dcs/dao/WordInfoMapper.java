package com.dcs.dao;

import com.dcs.pojo.WordInfo;

public interface WordInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WordInfo record);

    int insertSelective(WordInfo record);

    WordInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WordInfo record);

    int updateByPrimaryKey(WordInfo record);
}