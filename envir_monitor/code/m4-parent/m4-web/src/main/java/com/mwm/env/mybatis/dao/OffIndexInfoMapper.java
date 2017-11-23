package com.mwm.env.mybatis.dao;

import com.mwm.env.mybatis.modal.OffIndexInfo;
import com.mwm.env.mybatis.modal.OffIndexInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OffIndexInfoMapper {
    int countByExample(OffIndexInfoExample example);

    int deleteByExample(OffIndexInfoExample example);

    int deleteByPrimaryKey(Integer offindexid);

    int insert(OffIndexInfo record);

    int insertSelective(OffIndexInfo record);

    List<OffIndexInfo> selectByExample(OffIndexInfoExample example);

    OffIndexInfo selectByPrimaryKey(Integer offindexid);

    int updateByExampleSelective(@Param("record") OffIndexInfo record, @Param("example") OffIndexInfoExample example);

    int updateByExample(@Param("record") OffIndexInfo record, @Param("example") OffIndexInfoExample example);

    int updateByPrimaryKeySelective(OffIndexInfo record);

    int updateByPrimaryKey(OffIndexInfo record);
}