package com.mwm.env.mybatis.dao;

import com.mwm.env.mybatis.modal.ProvideInfo;
import com.mwm.env.mybatis.modal.ProvideInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProvideInfoMapper {
    int countByExample(ProvideInfoExample example);

    int deleteByExample(ProvideInfoExample example);

    int deleteByPrimaryKey(Integer provideid);

    int insert(ProvideInfo record);

    int insertSelective(ProvideInfo record);

    List<ProvideInfo> selectByExample(ProvideInfoExample example);

    ProvideInfo selectByPrimaryKey(Integer provideid);

    int updateByExampleSelective(@Param("record") ProvideInfo record, @Param("example") ProvideInfoExample example);

    int updateByExample(@Param("record") ProvideInfo record, @Param("example") ProvideInfoExample example);

    int updateByPrimaryKeySelective(ProvideInfo record);

    int updateByPrimaryKey(ProvideInfo record);
}