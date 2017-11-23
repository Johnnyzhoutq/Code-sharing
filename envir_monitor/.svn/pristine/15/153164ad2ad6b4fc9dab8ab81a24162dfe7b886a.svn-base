package com.mwm.commons.mybatis.dao;

import com.mwm.commons.mybatis.modal.MwmLog;
import com.mwm.commons.mybatis.modal.MwmLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MwmLogMapper {
    int countByExample(MwmLogExample example);

    int deleteByExample(MwmLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MwmLog record);

    int insertSelective(MwmLog record);

    List<MwmLog> selectByExample(MwmLogExample example);

    MwmLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MwmLog record, @Param("example") MwmLogExample example);

    int updateByExample(@Param("record") MwmLog record, @Param("example") MwmLogExample example);

    int updateByPrimaryKeySelective(MwmLog record);

    int updateByPrimaryKey(MwmLog record);
}