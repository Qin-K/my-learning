package com.example.mapper;

import com.example.model.FundsRecord;

public interface FundsRecordMapper {
    int deleteByPrimaryKey(Long fundsRecordId);

    int insert(FundsRecord record);

    int insertSelective(FundsRecord record);

    FundsRecord selectByPrimaryKey(Long fundsRecordId);

    int updateByPrimaryKeySelective(FundsRecord record);

    int updateByPrimaryKey(FundsRecord record);
}