package com.mwm.env.mybatis.dao;

import com.mwm.env.mybatis.modal.ReportInfo;
import com.mwm.env.mybatis.modal.ReportInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReportInfoMapper {
    int countByExample(ReportInfoExample example);

    int deleteByExample(ReportInfoExample example);

    int deleteByPrimaryKey(Integer reportid);

    int insert(ReportInfo record);

    int insertSelective(ReportInfo record);

    List<ReportInfo> selectByExampleWithBLOBs(ReportInfoExample example);

    List<ReportInfo> selectByExample(ReportInfoExample example);

    ReportInfo selectByPrimaryKey(Integer reportid);

    int updateByExampleSelective(@Param("record") ReportInfo record, @Param("example") ReportInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") ReportInfo record, @Param("example") ReportInfoExample example);

    int updateByExample(@Param("record") ReportInfo record, @Param("example") ReportInfoExample example);

    int updateByPrimaryKeySelective(ReportInfo record);

    int updateByPrimaryKeyWithBLOBs(ReportInfo record);

    int updateByPrimaryKey(ReportInfo record);
}