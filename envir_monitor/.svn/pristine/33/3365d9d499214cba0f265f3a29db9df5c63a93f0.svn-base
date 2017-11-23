package com.mwm.env.mybatis.dao;

import com.mwm.env.mybatis.modal.MemberShipInfo;
import com.mwm.env.mybatis.modal.MemberShipInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemberShipInfoMapper {
    int countByExample(MemberShipInfoExample example);

    int deleteByExample(MemberShipInfoExample example);

    int deleteByPrimaryKey(Integer membershipid);

    int insert(MemberShipInfo record);

    int insertSelective(MemberShipInfo record);

    List<MemberShipInfo> selectByExample(MemberShipInfoExample example);

    MemberShipInfo selectByPrimaryKey(Integer membershipid);

    int updateByExampleSelective(@Param("record") MemberShipInfo record, @Param("example") MemberShipInfoExample example);

    int updateByExample(@Param("record") MemberShipInfo record, @Param("example") MemberShipInfoExample example);

    int updateByPrimaryKeySelective(MemberShipInfo record);

    int updateByPrimaryKey(MemberShipInfo record);
}