package com.netcracker.unc.service;

import com.netcracker.unc.dao.PostDao;
import com.netcracker.unc.dto.PostDto;
import com.netcracker.unc.dto.mappers.PostMapper;
import com.netcracker.unc.model.Post;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    private PostDao dao;
    private PostMapper mapper = Mappers.getMapper(PostMapper.class);

    @Transactional
    public List<PostDto> getAll() {
        List<Post> posts = dao.getAllPosts();
        return posts.stream()
                .map(elem -> mapper.postToPostDto(elem))
                .collect(Collectors.toList());
    }

    @Transactional
    public List<PostDto> getAllPostsByUserId(Integer userId) {
        List<Post> posts = dao.getAllPostsByUserId(userId);
        return posts.stream()
                .map(elem -> mapper.postToPostDto(elem))
                .collect(Collectors.toList());
    }

    @Transactional
    public PostDto getPostById(Integer id) {
        Post post = dao.getPostById(id);
        return mapper.postToPostDto(post);
    }

    @Transactional
    public Integer addPost(PostDto postDto) {
        Post post = mapper.postDtoToPost(postDto);
        dao.addPost(post);
        return post.getPostId();
    }

    @Transactional
    public void updatePost(PostDto postDto) {
        Post post = mapper.postDtoToPost(postDto);
        dao.updatePost(post);
    }

    @Transactional
    public void deletePost(Integer id) {
        dao.deletePost(id);
    }
}
