package com.netcracker.unc.dto.mappers;

import com.netcracker.unc.dto.PostDto;
import com.netcracker.unc.model.Post;
import org.mapstruct.Mapper;

@Mapper
public interface PostMapper {
    PostDto postToPostDto(Post post);

    Post postDtoToPost(PostDto postDto);
}
