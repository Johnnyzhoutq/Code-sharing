package com.mwm.env.mybatis.dao;

import com.mwm.env.mybatis.modal.SlaveOrderInfo;
import com.mwm.env.mybatis.modal.SlaveOrderInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SlaveOrderInfoMapper {
    int countByExample(SlaveOrderInfoExample example);

    int deleteByExample(SlaveOrderInfoExample example);

    int deleteByPrimaryKey(Long slaveid);

    int insert(SlaveOrderInfo record);

    int insertSelective(SlaveOrderInfo record);

    List<SlaveOrderInfo> selectByExampleWithBLOBs(SlaveOrderInfoExample example);

    List<SlaveOrderInfo> selectByExample(SlaveOrderInfoExample example);

    SlaveOrderInfo selectByPrimaryKey(Long slaveid);

    int updateByExampleSelective(@Param("record") SlaveOrderInfo record, @Param("example") SlaveOrderInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") SlaveOrderInfo record, @Param("example") SlaveOrderInfoExample example);

    int updateByExample(@Param("record") SlaveOrderInfo record, @Param("example") SlaveOrderInfoExample example);

    int updateByPrimaryKeySelective(SlaveOrderInfo record);

    int updateByPrimaryKeyWithBLOBs(SlaveOrderInfo record);

    int updateByPrimaryKey(SlaveOrderInfo record);
}