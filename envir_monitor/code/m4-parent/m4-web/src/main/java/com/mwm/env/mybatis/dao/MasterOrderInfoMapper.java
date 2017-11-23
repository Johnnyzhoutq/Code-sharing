package com.mwm.env.mybatis.dao;

import com.mwm.env.mybatis.modal.MasterOrderInfo;
import com.mwm.env.mybatis.modal.MasterOrderInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MasterOrderInfoMapper {
    int countByExample(MasterOrderInfoExample example);

    int deleteByExample(MasterOrderInfoExample example);

    int deleteByPrimaryKey(Long masterid);

    int insert(MasterOrderInfo record);

    int insertSelective(MasterOrderInfo record);

    List<MasterOrderInfo> selectByExampleWithBLOBs(MasterOrderInfoExample example);

    List<MasterOrderInfo> selectByExample(MasterOrderInfoExample example);

    MasterOrderInfo selectByPrimaryKey(Long masterid);

    int updateByExampleSelective(@Param("record") MasterOrderInfo record, @Param("example") MasterOrderInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") MasterOrderInfo record, @Param("example") MasterOrderInfoExample example);

    int updateByExample(@Param("record") MasterOrderInfo record, @Param("example") MasterOrderInfoExample example);

    int updateByPrimaryKeySelective(MasterOrderInfo record);

    int updateByPrimaryKeyWithBLOBs(MasterOrderInfo record);

    int updateByPrimaryKey(MasterOrderInfo record);
}