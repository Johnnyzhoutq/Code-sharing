package com.mwm.env.mybatis.dao;

import com.mwm.env.mybatis.modal.IndexTypeInfo;
import com.mwm.env.mybatis.modal.IndexTypeInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IndexTypeInfoMapper {
    int countByExample(IndexTypeInfoExample example);

    int deleteByExample(IndexTypeInfoExample example);

    int deleteByPrimaryKey(Integer indextypeid);

    int insert(IndexTypeInfo record);

    int insertSelective(IndexTypeInfo record);

    List<IndexTypeInfo> selectByExample(IndexTypeInfoExample example);

    IndexTypeInfo selectByPrimaryKey(Integer indextypeid);

    int updateByExampleSelective(@Param("record") IndexTypeInfo record, @Param("example") IndexTypeInfoExample example);

    int updateByExample(@Param("record") IndexTypeInfo record, @Param("example") IndexTypeInfoExample example);

    int updateByPrimaryKeySelective(IndexTypeInfo record);

    int updateByPrimaryKey(IndexTypeInfo record);
}