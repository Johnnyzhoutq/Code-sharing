package com.mwm.env.mybatis.dao;

import com.mwm.env.mybatis.modal.PersonalUserInfo;
import com.mwm.env.mybatis.modal.PersonalUserInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PersonalUserInfoMapper {
    int countByExample(PersonalUserInfoExample example);

    int deleteByExample(PersonalUserInfoExample example);

    int deleteByPrimaryKey(Integer personalid);

    int insert(PersonalUserInfo record);

    int insertSelective(PersonalUserInfo record);

    List<PersonalUserInfo> selectByExample(PersonalUserInfoExample example);

    PersonalUserInfo selectByPrimaryKey(Integer personalid);

    int updateByExampleSelective(@Param("record") PersonalUserInfo record, @Param("example") PersonalUserInfoExample example);

    int updateByExample(@Param("record") PersonalUserInfo record, @Param("example") PersonalUserInfoExample example);

    int updateByPrimaryKeySelective(PersonalUserInfo record);

    int updateByPrimaryKey(PersonalUserInfo record);
}