package com.netcracker.unc.controller;

import com.netcracker.unc.controller.exception.BadRequestException;
import com.netcracker.unc.controller.exception.DataNotFoundException;
import com.netcracker.unc.controller.exception.InternalServerErrorException;
import com.netcracker.unc.dto.MessageDto;
import com.netcracker.unc.dto.PostDto;
import com.netcracker.unc.service.MessageService;
import com.netcracker.unc.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("posts")
public class PostController {

    @Autowired
    PostService postService;
    @Autowired
    MessageService messageService;

    @RequestMapping(value = "/{postId}", method = RequestMethod.GET)
    @ResponseBody
    public PostDto getPostById(@PathVariable("postId") Integer id) {
        if (id == null || id < 0) throw new BadRequestException();
        PostDto postDto;
        try {
            postDto = postService.getPostById(id);
        } catch (Exception e) {
            throw new InternalServerErrorException();
        }
        return postDto;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<PostDto> getAllPosts() {
        List<PostDto> posts = postService.getAll();
        if (posts == null || posts.isEmpty())
            throw new DataNotFoundException();
        return posts;
    }

    @RequestMapping(value = "/{postId}/messages", method = RequestMethod.GET)
    @ResponseBody
    public List<MessageDto> getAllMessagesByPostId(@PathVariable("postId") Integer id) {
        if (id == null || id < 0) throw new BadRequestException();
        List<MessageDto> messages = messageService.getAllMessagesByPostId(id);
        if (messages == null || messages.isEmpty())
            throw new DataNotFoundException();
        return messages;
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createPost(@RequestBody PostDto postDto) {
        if (postDto == null) throw new BadRequestException();
        postService.addPost(postDto);
    }

    @RequestMapping(value = "/{postId}", method = RequestMethod.PUT)
    public void updatePost(@PathVariable("postId") Integer id, @RequestBody PostDto postDto) {
        if (id == null || id < 0) throw new BadRequestException();
        if (postDto == null) throw new BadRequestException();
        postService.updatePost(postDto);
    }

    @RequestMapping(value = "/{postId}", method = RequestMethod.DELETE)
    public void deletePost(@PathVariable("postId") Integer id) {
        if (id == null || id < 0) throw new BadRequestException();
        postService.deletePost(id);
    }
}
