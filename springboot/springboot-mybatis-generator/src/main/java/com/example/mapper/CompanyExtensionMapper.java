package com.example.mapper;

import com.example.model.CompanyExtension;

public interface CompanyExtensionMapper {
    int deleteByPrimaryKey(String companyId);

    int insert(CompanyExtension record);

    int insertSelective(CompanyExtension record);

    CompanyExtension selectByPrimaryKey(String companyId);

    int updateByPrimaryKeySelective(CompanyExtension record);

    int updateByPrimaryKey(CompanyExtension record);
}