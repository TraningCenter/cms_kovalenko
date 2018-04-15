package com.netcracker.unc.dto.mappers;

import com.netcracker.unc.dto.ContentDto;
import com.netcracker.unc.model.Content;
import org.mapstruct.Mapper;

@Mapper
public interface ContentMapper {
    ContentDto contentToContentDto(Content content);

    Content contentDtoToContent(ContentDto contentDto);
}
