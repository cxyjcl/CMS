package com.dcs.dao;

import com.dcs.pojo.PlanConclusion;

public interface PlanConclusionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PlanConclusion record);

    int insertSelective(PlanConclusion record);

    PlanConclusion selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PlanConclusion record);

    int updateByPrimaryKey(PlanConclusion record);
}