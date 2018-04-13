package com.netcracker.unc.dto.mappers;

import com.netcracker.unc.dto.PostDto;
import com.netcracker.unc.model.Post;
import com.netcracker.unc.util.ParseUtil;
import org.mapstruct.*;

@Mapper
public abstract class PostMapper {
    @Mappings({
            @Mapping(target = "picturesId", ignore = true)
    })
    public abstract PostDto postToPostDto(Post post);

    @Mappings({
            @Mapping(target = "picturesId", ignore = true)
    })
    public abstract Post postDtoToPost(PostDto postDto);

    @AfterMapping
    void setPicturesId(PostDto postDto, @MappingTarget Post post){
        post.setPicturesId(ParseUtil.convertArrayToString(postDto.getPicturesId()));
    }

    @AfterMapping
    void setPicturesId(Post post, @MappingTarget PostDto postDto){
        postDto.parsePicturesId(post.getPicturesId());
    }
}
