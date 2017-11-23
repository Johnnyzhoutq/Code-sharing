package com.mwm.env.mybatis.dao;

import com.mwm.env.mybatis.modal.ChargeBackInfo;
import com.mwm.env.mybatis.modal.ChargeBackInfoExample;
import com.mwm.env.mybatis.modal.ChargeBackInfoWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChargeBackInfoMapper {
    int countByExample(ChargeBackInfoExample example);

    int deleteByExample(ChargeBackInfoExample example);

    int deleteByPrimaryKey(Integer backid);

    int insert(ChargeBackInfoWithBLOBs record);

    int insertSelective(ChargeBackInfoWithBLOBs record);

    List<ChargeBackInfoWithBLOBs> selectByExampleWithBLOBs(ChargeBackInfoExample example);

    List<ChargeBackInfo> selectByExample(ChargeBackInfoExample example);

    ChargeBackInfoWithBLOBs selectByPrimaryKey(Integer backid);

    int updateByExampleSelective(@Param("record") ChargeBackInfoWithBLOBs record, @Param("example") ChargeBackInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") ChargeBackInfoWithBLOBs record, @Param("example") ChargeBackInfoExample example);

    int updateByExample(@Param("record") ChargeBackInfo record, @Param("example") ChargeBackInfoExample example);

    int updateByPrimaryKeySelective(ChargeBackInfoWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ChargeBackInfoWithBLOBs record);

    int updateByPrimaryKey(ChargeBackInfo record);
}