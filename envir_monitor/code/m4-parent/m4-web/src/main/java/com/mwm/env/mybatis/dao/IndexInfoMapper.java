package com.mwm.env.mybatis.dao;

import com.mwm.env.mybatis.modal.IndexInfo;
import com.mwm.env.mybatis.modal.IndexInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IndexInfoMapper {
    int countByExample(IndexInfoExample example);

    int deleteByExample(IndexInfoExample example);

    int deleteByPrimaryKey(Integer indexid);

    int insert(IndexInfo record);

    int insertSelective(IndexInfo record);

    List<IndexInfo> selectByExampleWithBLOBs(IndexInfoExample example);

    List<IndexInfo> selectByExample(IndexInfoExample example);

    IndexInfo selectByPrimaryKey(Integer indexid);

    int updateByExampleSelective(@Param("record") IndexInfo record, @Param("example") IndexInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") IndexInfo record, @Param("example") IndexInfoExample example);

    int updateByExample(@Param("record") IndexInfo record, @Param("example") IndexInfoExample example);

    int updateByPrimaryKeySelective(IndexInfo record);

    int updateByPrimaryKeyWithBLOBs(IndexInfo record);

    int updateByPrimaryKey(IndexInfo record);
}