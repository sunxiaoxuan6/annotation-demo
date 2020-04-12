package com.example.mybatis.annotation.demo.mapper;

import com.example.mybatis.annotation.demo.model.Message;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface MessageMapper {

    @Select("select * from message")
    List<Message> selectAll();

    @Select("select * from message where msg_id=#{msgId}")
    Message selectById(Integer id);

    @Delete("delete from message where msg_id=#{msgId}")
    int delete(Integer id);

    @Update({"<script> ",
            "update message set ",
            "  <if test='msgText!=null'>msg_text=#{msgText},</if> ",
            "  <if test='msgSummary!=null'>msg_summary=#{msgSummary}</if> ",
            "where msg_id = #{msgId}",
            "</script>"})
    int update(Message message);

    @Update({"<script> ",
            "update message ",
            "<set>",
            "  <if test='msgText!=null'>msg_text=#{msgText},</if> ",
            "  <if test='msgSummary!=null'>msg_summary=#{msgSummary}</if> ",
            "</set>",
            "where msg_id = #{msgId}",
            "</script>"})
    int updateText(Message message);

    @Insert({"<script> ",
            "insert into message (msg_text,msg_summary) values ",
            "<foreach collection='list' item='msg' index='index' separator=','> ",
            "(#{msg.msgText},#{msg.msgSummary}) ",
            "</foreach> ",
            "</script>"})
    int batchInsert(List<Message> message);

    @Insert("insert into message(msg_text,msg_summary) " +
            "values (#{msgText},#{msgSummary})")
    int insert(Message message);
}
