package com.netcracker.unc.dao;

import com.netcracker.unc.model.Post;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PostDao {

    @Select("select * from posts where id = #{id}")
    Post getPostById(Integer id);

    @Select("select * from posts")
    List<Post> getAllPosts();
}
