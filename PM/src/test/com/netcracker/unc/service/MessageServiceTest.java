package com.netcracker.unc.service;

import com.netcracker.unc.dto.MessageDto;
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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/applicationContext.xml"})
public class MessageServiceTest {

    @Autowired
    MessageService messageService;
    @Autowired
    UserService userService;
    @Autowired
    PostService postService;

    private UserDto savedUser;
    private PostDto savedPost;

    @Before
    public void init() {
        UserDto user = new UserDto("Test2", "12345");
        userService.addUser(user);
        savedUser = userService.getUserByUsername("Test2");
        PostDto post = new PostDto("title", savedUser.getUserId(), 2);
        postService.addPost(post);
        savedPost = postService.getAllPostsByUserId(savedUser.getUserId()).get(0);
    }

    @After
    public void destroy() {
        postService.deletePost(savedPost.getPostId());
        userService.deleteUser(savedUser.getUserId());
    }

    @Test
    public void addMessage() {
        MessageDto messageDto = new MessageDto(savedPost.getPostId(), savedUser.getUserId(), "Test message text");
        messageService.addMessage(messageDto);
        MessageDto savedMessage = messageService.getAllMessagesByPostId(savedPost.getPostId()).get(0);
        Assert.assertEquals(savedMessage.getPostId(), savedPost.getPostId());
        Assert.assertEquals(savedMessage.getUserId(), savedUser.getUserId());
        Assert.assertNotNull(savedMessage.getDateTime());
        Assert.assertEquals(savedMessage.getText(), "Test message text");
        messageService.deleteMessage(savedMessage.getMessageId());
    }

    @Test
    public void updateMessage() {
        MessageDto messageDto = new MessageDto(savedPost.getPostId(), savedUser.getUserId(), "Test message text");
        messageService.addMessage(messageDto);
        MessageDto savedMessage = messageService.getAllMessagesByPostId(savedPost.getPostId()).get(0);
        Assert.assertEquals(savedMessage.getText(), "Test message text");
        savedMessage.setText("New text");
        messageService.updateMessage(savedMessage);
        savedMessage = messageService.getMessageById(savedMessage.getMessageId());
        Assert.assertEquals(savedMessage.getText(), "New text");
        messageService.deleteMessage(savedMessage.getMessageId());
    }
}
