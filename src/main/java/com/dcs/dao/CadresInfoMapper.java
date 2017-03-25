package com.dcs.dao;

import com.dcs.pojo.CadresInfo;

public interface CadresInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CadresInfo record);

    int insertSelective(CadresInfo record);

    CadresInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CadresInfo record);

    int updateByPrimaryKey(CadresInfo record);
}