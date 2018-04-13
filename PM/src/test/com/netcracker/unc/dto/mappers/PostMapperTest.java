package com.netcracker.unc.dto.mappers;

import com.netcracker.unc.dto.PostDto;
import com.netcracker.unc.model.Post;
import org.junit.Assert;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;

public class PostMapperTest {

    private PostMapper mapper = Mappers.getMapper(PostMapper.class);

    @Test
    public void postToPostDto() {
        Post post = new Post(1, "title", 2, 3, "4, 5");
        PostDto postDto = mapper.postToPostDto(post);
        Assert.assertEquals(post.getPostId(), postDto.getPostId());
        Assert.assertEquals(post.getTitle(), postDto.getTitle());
        Assert.assertEquals(post.getUserId(), postDto.getUserId());
        Assert.assertEquals(post.getTextId(), postDto.getTextId());
        ArrayList<Integer> rightArray = new ArrayList<Integer>() {{
            add(4);
            add(5);
        }};
        Assert.assertTrue(postDto.getPicturesId().size()== rightArray.size());
        Assert.assertTrue(postDto.getPicturesId().equals(rightArray));

    }

    @Test
    public void postDtoToPost() {
        PostDto postDto = new PostDto(1, "title", 2, 3, new ArrayList<Integer>() {{
            add(4);
            add(5);
        }});
        Post post = mapper.postDtoToPost(postDto);
        Assert.assertEquals(post.getPostId(), postDto.getPostId());
        Assert.assertEquals(post.getTitle(), postDto.getTitle());
        Assert.assertEquals(post.getUserId(), postDto.getUserId());
        Assert.assertEquals(post.getTextId(), postDto.getTextId());
        Assert.assertEquals(post.getPicturesId(), "4, 5");
    }
}
