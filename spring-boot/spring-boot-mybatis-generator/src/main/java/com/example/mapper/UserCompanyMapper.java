package com.example.mapper;

import com.example.model.UserCompany;

public interface UserCompanyMapper {
    int deleteByPrimaryKey(String companyId);

    int insert(UserCompany record);

    int insertSelective(UserCompany record);

    UserCompany selectByPrimaryKey(String companyId);

    int updateByPrimaryKeySelective(UserCompany record);

    int updateByPrimaryKey(UserCompany record);
}