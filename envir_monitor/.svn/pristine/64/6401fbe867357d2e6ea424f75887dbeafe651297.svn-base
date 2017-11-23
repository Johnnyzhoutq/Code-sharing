package com.mwm.env.mybatis.dao;

import com.mwm.env.mybatis.modal.LiveChatMsg;
import com.mwm.env.mybatis.modal.LiveChatMsgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LiveChatMsgMapper {
    int countByExample(LiveChatMsgExample example);

    int deleteByExample(LiveChatMsgExample example);

    int deleteByPrimaryKey(Integer msgid);

    int insert(LiveChatMsg record);

    int insertSelective(LiveChatMsg record);

    List<LiveChatMsg> selectByExampleWithBLOBs(LiveChatMsgExample example);

    List<LiveChatMsg> selectByExample(LiveChatMsgExample example);

    LiveChatMsg selectByPrimaryKey(Integer msgid);

    int updateByExampleSelective(@Param("record") LiveChatMsg record, @Param("example") LiveChatMsgExample example);

    int updateByExampleWithBLOBs(@Param("record") LiveChatMsg record, @Param("example") LiveChatMsgExample example);

    int updateByExample(@Param("record") LiveChatMsg record, @Param("example") LiveChatMsgExample example);

    int updateByPrimaryKeySelective(LiveChatMsg record);

    int updateByPrimaryKeyWithBLOBs(LiveChatMsg record);

    int updateByPrimaryKey(LiveChatMsg record);
}