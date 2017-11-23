package com.mwm.env.mybatis.dao;

import com.mwm.env.mybatis.modal.CompanyUserInfo;
import com.mwm.env.mybatis.modal.CompanyUserInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CompanyUserInfoMapper {
    int countByExample(CompanyUserInfoExample example);

    int deleteByExample(CompanyUserInfoExample example);

    int deleteByPrimaryKey(Integer companyid);

    int insert(CompanyUserInfo record);

    int insertSelective(CompanyUserInfo record);

    List<CompanyUserInfo> selectByExample(CompanyUserInfoExample example);

    CompanyUserInfo selectByPrimaryKey(Integer companyid);

    int updateByExampleSelective(@Param("record") CompanyUserInfo record, @Param("example") CompanyUserInfoExample example);

    int updateByExample(@Param("record") CompanyUserInfo record, @Param("example") CompanyUserInfoExample example);

    int updateByPrimaryKeySelective(CompanyUserInfo record);

    int updateByPrimaryKey(CompanyUserInfo record);
}