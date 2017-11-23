package com.mwm.env.mybatis.dao;

import com.mwm.env.mybatis.modal.AddressInfo;
import com.mwm.env.mybatis.modal.AddressInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AddressInfoMapper {
    int countByExample(AddressInfoExample example);

    int deleteByExample(AddressInfoExample example);

    int deleteByPrimaryKey(Integer addressid);

    int insert(AddressInfo record);

    int insertSelective(AddressInfo record);

    List<AddressInfo> selectByExample(AddressInfoExample example);

    AddressInfo selectByPrimaryKey(Integer addressid);

    int updateByExampleSelective(@Param("record") AddressInfo record, @Param("example") AddressInfoExample example);

    int updateByExample(@Param("record") AddressInfo record, @Param("example") AddressInfoExample example);

    int updateByPrimaryKeySelective(AddressInfo record);

    int updateByPrimaryKey(AddressInfo record);
}