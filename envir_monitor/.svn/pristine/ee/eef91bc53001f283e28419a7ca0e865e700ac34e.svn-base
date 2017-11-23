package com.mwm.env.mybatis.dao;

import com.mwm.env.mybatis.modal.ComplaintContent;
import com.mwm.env.mybatis.modal.ComplaintContentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ComplaintContentMapper {
    int countByExample(ComplaintContentExample example);

    int deleteByExample(ComplaintContentExample example);

    int deleteByPrimaryKey(Integer contentid);

    int insert(ComplaintContent record);

    int insertSelective(ComplaintContent record);

    List<ComplaintContent> selectByExample(ComplaintContentExample example);

    ComplaintContent selectByPrimaryKey(Integer contentid);

    int updateByExampleSelective(@Param("record") ComplaintContent record, @Param("example") ComplaintContentExample example);

    int updateByExample(@Param("record") ComplaintContent record, @Param("example") ComplaintContentExample example);

    int updateByPrimaryKeySelective(ComplaintContent record);

    int updateByPrimaryKey(ComplaintContent record);
}