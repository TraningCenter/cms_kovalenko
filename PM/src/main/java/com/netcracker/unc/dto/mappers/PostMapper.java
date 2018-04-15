package com.netcracker.unc.dto.mappers;

import com.netcracker.unc.dto.PostDto;
import com.netcracker.unc.dto.UserDto;
import com.netcracker.unc.model.Post;
import com.netcracker.unc.service.UserService;
import com.netcracker.unc.util.ApplicationContextProvider;
import com.netcracker.unc.util.ParseUtil;
import org.mapstruct.*;
import org.springframework.context.ApplicationContext;

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
    void setPicturesId(PostDto postDto, @MappingTarget Post post) {
        post.setPicturesId(ParseUtil.convertArrayToString(postDto.getPicturesId()));
    }

    @AfterMapping
    void setPicturesId(Post post, @MappingTarget PostDto postDto) {
        postDto.parsePicturesId(post.getPicturesId());
    }

    @AfterMapping
    void setUser(Post post, @MappingTarget PostDto postDto) {
        if (post.getPostId() != null) {
            ApplicationContext context = ApplicationContextProvider.getApplicationContext();
            UserService userService = (UserService) context.getBean("userService");
            UserDto userDto = userService.getUserById(post.getUserId());
            if (userDto != null) {
                userDto.setPassword(null);
                postDto.setUser(userDto);
            }
        }
    }

    @AfterMapping
    void setUser(PostDto postDto, @MappingTarget Post post) {
        post.setUserId(postDto.getUser().getUserId());
    }
}
