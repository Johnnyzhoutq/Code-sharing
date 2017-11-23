package com.mwm.env.mybatis.dao;

import com.mwm.env.mybatis.modal.IndexLibraryInfo;
import com.mwm.env.mybatis.modal.IndexLibraryInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IndexLibraryInfoMapper {
    int countByExample(IndexLibraryInfoExample example);

    int deleteByExample(IndexLibraryInfoExample example);

    int deleteByPrimaryKey(Integer indexlibid);

    int insert(IndexLibraryInfo record);

    int insertSelective(IndexLibraryInfo record);

    List<IndexLibraryInfo> selectByExampleWithBLOBs(IndexLibraryInfoExample example);

    List<IndexLibraryInfo> selectByExample(IndexLibraryInfoExample example);

    IndexLibraryInfo selectByPrimaryKey(Integer indexlibid);

    int updateByExampleSelective(@Param("record") IndexLibraryInfo record, @Param("example") IndexLibraryInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") IndexLibraryInfo record, @Param("example") IndexLibraryInfoExample example);

    int updateByExample(@Param("record") IndexLibraryInfo record, @Param("example") IndexLibraryInfoExample example);

    int updateByPrimaryKeySelective(IndexLibraryInfo record);

    int updateByPrimaryKeyWithBLOBs(IndexLibraryInfo record);

    int updateByPrimaryKey(IndexLibraryInfo record);
}