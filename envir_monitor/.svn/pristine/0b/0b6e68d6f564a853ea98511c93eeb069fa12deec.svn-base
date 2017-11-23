package com.mwm.env.mybatis.dao;

import com.mwm.env.mybatis.modal.DemandLibInfo;
import com.mwm.env.mybatis.modal.DemandLibInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DemandLibInfoMapper {
    int countByExample(DemandLibInfoExample example);

    int deleteByExample(DemandLibInfoExample example);

    int deleteByPrimaryKey(Integer demandlibid);

    int insert(DemandLibInfo record);

    int insertSelective(DemandLibInfo record);

    List<DemandLibInfo> selectByExample(DemandLibInfoExample example);

    DemandLibInfo selectByPrimaryKey(Integer demandlibid);

    int updateByExampleSelective(@Param("record") DemandLibInfo record, @Param("example") DemandLibInfoExample example);

    int updateByExample(@Param("record") DemandLibInfo record, @Param("example") DemandLibInfoExample example);

    int updateByPrimaryKeySelective(DemandLibInfo record);

    int updateByPrimaryKey(DemandLibInfo record);
}