package com.mwm.commons.mybatis.dao;

import com.mwm.commons.mybatis.modal.MwmConfig;
import com.mwm.commons.mybatis.modal.MwmConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MwmConfigMapper {
    int countByExample(MwmConfigExample example);

    int deleteByExample(MwmConfigExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MwmConfig record);

    int insertSelective(MwmConfig record);

    List<MwmConfig> selectByExample(MwmConfigExample example);

    MwmConfig selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MwmConfig record, @Param("example") MwmConfigExample example);

    int updateByExample(@Param("record") MwmConfig record, @Param("example") MwmConfigExample example);

    int updateByPrimaryKeySelective(MwmConfig record);

    int updateByPrimaryKey(MwmConfig record);
}