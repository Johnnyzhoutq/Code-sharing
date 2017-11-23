package com.mwm.env.mybatis.dao;

import com.mwm.env.mybatis.modal.WebsiteInfo;
import com.mwm.env.mybatis.modal.WebsiteInfoExample;
import com.mwm.env.mybatis.modal.WebsiteInfoWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WebsiteInfoMapper {
    int countByExample(WebsiteInfoExample example);

    int deleteByExample(WebsiteInfoExample example);

    int deleteByPrimaryKey(Byte id);

    int insert(WebsiteInfoWithBLOBs record);

    int insertSelective(WebsiteInfoWithBLOBs record);

    List<WebsiteInfoWithBLOBs> selectByExampleWithBLOBs(WebsiteInfoExample example);

    List<WebsiteInfo> selectByExample(WebsiteInfoExample example);

    WebsiteInfoWithBLOBs selectByPrimaryKey(Byte id);

    int updateByExampleSelective(@Param("record") WebsiteInfoWithBLOBs record, @Param("example") WebsiteInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") WebsiteInfoWithBLOBs record, @Param("example") WebsiteInfoExample example);

    int updateByExample(@Param("record") WebsiteInfo record, @Param("example") WebsiteInfoExample example);

    int updateByPrimaryKeySelective(WebsiteInfoWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(WebsiteInfoWithBLOBs record);

    int updateByPrimaryKey(WebsiteInfo record);
}