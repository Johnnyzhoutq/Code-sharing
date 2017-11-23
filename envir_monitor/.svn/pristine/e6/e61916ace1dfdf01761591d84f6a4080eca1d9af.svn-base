package com.mwm.env.mybatis.dao;

import com.mwm.env.mybatis.modal.CustomerSerInfo;
import com.mwm.env.mybatis.modal.CustomerSerInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerSerInfoMapper {
    int countByExample(CustomerSerInfoExample example);

    int deleteByExample(CustomerSerInfoExample example);

    int deleteByPrimaryKey(Byte serviceid);

    int insert(CustomerSerInfo record);

    int insertSelective(CustomerSerInfo record);

    List<CustomerSerInfo> selectByExample(CustomerSerInfoExample example);

    CustomerSerInfo selectByPrimaryKey(Byte serviceid);

    int updateByExampleSelective(@Param("record") CustomerSerInfo record, @Param("example") CustomerSerInfoExample example);

    int updateByExample(@Param("record") CustomerSerInfo record, @Param("example") CustomerSerInfoExample example);

    int updateByPrimaryKeySelective(CustomerSerInfo record);

    int updateByPrimaryKey(CustomerSerInfo record);
}