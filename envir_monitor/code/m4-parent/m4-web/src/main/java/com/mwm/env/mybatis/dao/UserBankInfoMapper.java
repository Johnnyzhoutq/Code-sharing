package com.mwm.env.mybatis.dao;

import com.mwm.env.mybatis.modal.UserBankInfo;
import com.mwm.env.mybatis.modal.UserBankInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserBankInfoMapper {
    int countByExample(UserBankInfoExample example);

    int deleteByExample(UserBankInfoExample example);

    int deleteByPrimaryKey(Integer bankid);

    int insert(UserBankInfo record);

    int insertSelective(UserBankInfo record);

    List<UserBankInfo> selectByExample(UserBankInfoExample example);

    UserBankInfo selectByPrimaryKey(Integer bankid);

    int updateByExampleSelective(@Param("record") UserBankInfo record, @Param("example") UserBankInfoExample example);

    int updateByExample(@Param("record") UserBankInfo record, @Param("example") UserBankInfoExample example);

    int updateByPrimaryKeySelective(UserBankInfo record);

    int updateByPrimaryKey(UserBankInfo record);
}