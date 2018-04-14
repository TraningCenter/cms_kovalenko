package com.netcracker.unc.dao;

import com.netcracker.unc.model.Post;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.ArrayTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.Array;
import java.util.List;

public interface PostDao {

    @Select("select * from posts where post_id = #{id}")
    @Results(value = {
            @Result(property = "postId", column = "post_id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "textId", column = "text_id"),
            @Result(property = "picturesId", column = "pictures_id"),
            @Result(property = "dateTime", column = "date_time"),
    })
    Post getPostById(Integer id);

    @Select("select * from posts")
    @Results({
            @Result(property = "postId", column = "post_id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "textId", column = "text_id"),
            @Result(property = "picturesId", column = "pictures_id"),
            @Result(property = "dateTime", column = "date_time"),
    })
    List<Post> getAllPosts();

    @Select("select * from posts where user_id=#{userId}")
    @Results({
            @Result(property = "postId", column = "post_id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "textId", column = "text_id"),
            @Result(property = "picturesId", column = "pictures_id"),
            @Result(property = "dateTime", column = "date_time"),
    })
    List<Post> getAllPostsByUserId(Integer userId);

    @Insert("insert into posts(user_id, title, text_id, pictures_id) values(#{userId}, #{title}, #{textId}, #{picturesId}) ")
    void addPost(Post post);

    @Update("update posts set title=#{title}, text_id=#{textId}, pictures_id=#{picturesId} where post_id=#{postId}")
    void updatePost(Post post);

    @Delete("delete from posts where post_id=#{id}")
    void deletePost(Integer id);
}
