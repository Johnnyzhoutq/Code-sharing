package com.mwm.env.mybatis.dao;

import com.mwm.env.mybatis.modal.DataGoodsInfo;
import com.mwm.env.mybatis.modal.DataGoodsInfoExample;
import com.mwm.env.mybatis.modal.DataGoodsInfoWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DataGoodsInfoMapper {
    int countByExample(DataGoodsInfoExample example);

    int deleteByExample(DataGoodsInfoExample example);

    int deleteByPrimaryKey(Integer goods);

    int insert(DataGoodsInfoWithBLOBs record);

    int insertSelective(DataGoodsInfoWithBLOBs record);

    List<DataGoodsInfoWithBLOBs> selectByExampleWithBLOBs(DataGoodsInfoExample example);

    List<DataGoodsInfo> selectByExample(DataGoodsInfoExample example);

    DataGoodsInfoWithBLOBs selectByPrimaryKey(Integer goods);

    int updateByExampleSelective(@Param("record") DataGoodsInfoWithBLOBs record, @Param("example") DataGoodsInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") DataGoodsInfoWithBLOBs record, @Param("example") DataGoodsInfoExample example);

    int updateByExample(@Param("record") DataGoodsInfo record, @Param("example") DataGoodsInfoExample example);

    int updateByPrimaryKeySelective(DataGoodsInfoWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(DataGoodsInfoWithBLOBs record);

    int updateByPrimaryKey(DataGoodsInfo record);
}