package com.example.mapper;

import com.example.model.PubParameter;

public interface PubParameterMapper {
    int deleteByPrimaryKey(Integer aprId);

    int insert(PubParameter record);

    int insertSelective(PubParameter record);

    PubParameter selectByPrimaryKey(Integer aprId);

    int updateByPrimaryKeySelective(PubParameter record);

    int updateByPrimaryKey(PubParameter record);
}