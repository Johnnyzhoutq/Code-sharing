package com.mwm.commons.mybatis.dao;

import com.mwm.commons.mybatis.modal.MwmConfigGroup;
import com.mwm.commons.mybatis.modal.MwmConfigGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MwmConfigGroupMapper {
    int countByExample(MwmConfigGroupExample example);

    int deleteByExample(MwmConfigGroupExample example);

    int deleteByPrimaryKey(Integer groupId);

    int insert(MwmConfigGroup record);

    int insertSelective(MwmConfigGroup record);

    List<MwmConfigGroup> selectByExample(MwmConfigGroupExample example);

    MwmConfigGroup selectByPrimaryKey(Integer groupId);

    int updateByExampleSelective(@Param("record") MwmConfigGroup record, @Param("example") MwmConfigGroupExample example);

    int updateByExample(@Param("record") MwmConfigGroup record, @Param("example") MwmConfigGroupExample example);

    int updateByPrimaryKeySelective(MwmConfigGroup record);

    int updateByPrimaryKey(MwmConfigGroup record);
}