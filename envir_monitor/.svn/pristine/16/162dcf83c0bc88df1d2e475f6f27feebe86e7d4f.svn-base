package com.mwm.env.mybatis.dao;

import com.mwm.env.mybatis.modal.GrantInfo;
import com.mwm.env.mybatis.modal.GrantInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GrantInfoMapper {
    int countByExample(GrantInfoExample example);

    int deleteByExample(GrantInfoExample example);

    int deleteByPrimaryKey(Byte grantid);

    int insert(GrantInfo record);

    int insertSelective(GrantInfo record);

    List<GrantInfo> selectByExampleWithBLOBs(GrantInfoExample example);

    List<GrantInfo> selectByExample(GrantInfoExample example);

    GrantInfo selectByPrimaryKey(Byte grantid);

    int updateByExampleSelective(@Param("record") GrantInfo record, @Param("example") GrantInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") GrantInfo record, @Param("example") GrantInfoExample example);

    int updateByExample(@Param("record") GrantInfo record, @Param("example") GrantInfoExample example);

    int updateByPrimaryKeySelective(GrantInfo record);

    int updateByPrimaryKeyWithBLOBs(GrantInfo record);

    int updateByPrimaryKey(GrantInfo record);
}