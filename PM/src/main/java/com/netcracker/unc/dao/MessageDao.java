package com.netcracker.unc.dao;

import com.netcracker.unc.model.Message;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface MessageDao {

    @Select("select * from messages where message_id = #{id}")
    @Results(value = {
            @Result(property = "messageId", column = "message_id"),
            @Result(property = "postId", column = "post_id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "dateTime", column = "date_time"),
    })
    Message getMessageById(Integer id);

    @Select("select * from messages")
    @Results(value = {
            @Result(property = "messageId", column = "message_id"),
            @Result(property = "postId", column = "post_id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "dateTime", column = "date_time"),
    })
    List<Message> getAllMessages();

    @Select("select * from messages where post_id = #{postId}")
    @Results(value = {
            @Result(property = "messageId", column = "message_id"),
            @Result(property = "postId", column = "post_id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "dateTime", column = "date_time"),
    })
    List<Message> getAllMessagesByPostId(Integer postId);

    @Insert("insert into messages(user_id, post_id, text) values(#{userId}, #{postId}, #{text})")
    void addMessage(Message message);

    @Update("update messages set text=#{text} where message_id=#{messageId}")
    void updateMessage(Message message);

    @Delete("delete from messages where message_id=#{id}")
    void deleteMessage(Integer id);
}
