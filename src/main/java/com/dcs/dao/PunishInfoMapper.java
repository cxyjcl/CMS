package com.dcs.dao;

import com.dcs.pojo.PunishInfo;

public interface PunishInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PunishInfo record);

    int insertSelective(PunishInfo record);

    PunishInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PunishInfo record);

    int updateByPrimaryKey(PunishInfo record);
}