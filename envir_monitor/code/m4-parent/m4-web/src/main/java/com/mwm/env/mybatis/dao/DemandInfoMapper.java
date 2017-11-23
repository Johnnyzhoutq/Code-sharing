package com.mwm.env.mybatis.dao;

import com.mwm.env.mybatis.modal.DemandInfo;
import com.mwm.env.mybatis.modal.DemandInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DemandInfoMapper {
    int countByExample(DemandInfoExample example);

    int deleteByExample(DemandInfoExample example);

    int deleteByPrimaryKey(Integer demandid);

    int insert(DemandInfo record);

    int insertSelective(DemandInfo record);

    List<DemandInfo> selectByExample(DemandInfoExample example);

    DemandInfo selectByPrimaryKey(Integer demandid);

    int updateByExampleSelective(@Param("record") DemandInfo record, @Param("example") DemandInfoExample example);

    int updateByExample(@Param("record") DemandInfo record, @Param("example") DemandInfoExample example);

    int updateByPrimaryKeySelective(DemandInfo record);

    int updateByPrimaryKey(DemandInfo record);
}