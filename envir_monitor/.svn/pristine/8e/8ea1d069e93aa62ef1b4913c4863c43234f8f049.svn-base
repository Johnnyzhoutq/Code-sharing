package com.mwm.commons.mybatis.dao;

import com.mwm.commons.mybatis.modal.MwmCity;
import com.mwm.commons.mybatis.modal.MwmCityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MwmCityMapper {
    int countByExample(MwmCityExample example);

    int deleteByExample(MwmCityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MwmCity record);

    int insertSelective(MwmCity record);

    List<MwmCity> selectByExample(MwmCityExample example);

    MwmCity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MwmCity record, @Param("example") MwmCityExample example);

    int updateByExample(@Param("record") MwmCity record, @Param("example") MwmCityExample example);

    int updateByPrimaryKeySelective(MwmCity record);

    int updateByPrimaryKey(MwmCity record);
}