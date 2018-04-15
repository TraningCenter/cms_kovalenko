package com.netcracker.unc.service;

import com.netcracker.unc.dto.PostDto;
import com.netcracker.unc.dto.UserDto;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/applicationContext.xml"})
public class PostServiceTest {

    @Autowired
    PostService postService;
    @Autowired
    UserService userService;

    private UserDto savedUser;

    @Before
    public void init() {
        UserDto user = new UserDto("Test2", "12345");
        userService.addUser(user);
        savedUser = userService.getUserByUsername("Test2");
    }

    @After
    public void destroy() {
        userService.deleteUser(savedUser.getUserId());
    }

    @Test
    public void addPost() {
        PostDto post = new PostDto("title", savedUser, 2);
        postService.addPost(post);
        PostDto savedPost = postService.getAllPostsByUserId(savedUser.getUserId()).get(0);
        Assert.assertNotNull(savedPost);
        Assert.assertEquals(savedPost.getTitle(), post.getTitle());
        Assert.assertEquals(savedPost.getUser().getUserId(), post.getUser().getUserId());
        Assert.assertEquals(savedPost.getTextId(), post.getTextId());
        postService.deletePost(savedPost.getPostId());
    }

    @Test
    public void updatePost() {
        PostDto post = new PostDto("title", savedUser, 2, new ArrayList<Integer>() {{
            add(1);
            add(2);
            add(3);
        }});
        postService.addPost(post);
        PostDto savedPost = postService.getAllPostsByUserId(savedUser.getUserId()).get(0);
        Assert.assertEquals(savedPost.getTitle(), "title");
        savedPost.setTitle("New title");
        postService.updatePost(savedPost);
        savedPost = postService.getPostById(savedPost.getPostId());
        Assert.assertEquals(savedPost.getTitle(), "New title");
        postService.deletePost(savedPost.getPostId());
    }
}
