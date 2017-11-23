package com.mwm.env.mybatis.dao;

import com.mwm.env.mybatis.modal.ComplaintLog;
import com.mwm.env.mybatis.modal.ComplaintLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ComplaintLogMapper {
    int countByExample(ComplaintLogExample example);

    int deleteByExample(ComplaintLogExample example);

    int deleteByPrimaryKey(Integer complaintid);

    int insert(ComplaintLog record);

    int insertSelective(ComplaintLog record);

    List<ComplaintLog> selectByExampleWithBLOBs(ComplaintLogExample example);

    List<ComplaintLog> selectByExample(ComplaintLogExample example);

    ComplaintLog selectByPrimaryKey(Integer complaintid);

    int updateByExampleSelective(@Param("record") ComplaintLog record, @Param("example") ComplaintLogExample example);

    int updateByExampleWithBLOBs(@Param("record") ComplaintLog record, @Param("example") ComplaintLogExample example);

    int updateByExample(@Param("record") ComplaintLog record, @Param("example") ComplaintLogExample example);

    int updateByPrimaryKeySelective(ComplaintLog record);

    int updateByPrimaryKeyWithBLOBs(ComplaintLog record);

    int updateByPrimaryKey(ComplaintLog record);
}