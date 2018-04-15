package com.netcracker.unc.dto.mappers;

import com.netcracker.unc.dto.ContentDto;
import com.netcracker.unc.model.Content;
import org.junit.Assert;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

public class ContentMapperTest {

    private ContentMapper mapper = Mappers.getMapper(ContentMapper.class);

    @Test
    public void contentToContentDto() {
        Content content = new Content("Content", 2);
        ContentDto contentDto = mapper.contentToContentDto(content);
        Assert.assertEquals(content.getContent(), contentDto.getContent());
        Assert.assertEquals(content.getPostId(), contentDto.getPostId());
        Assert.assertNull(content.getContentId());
        Assert.assertNull(contentDto.getContentId());
    }

    @Test
    public void contentDtoToContent() {
        ContentDto contentDto = new ContentDto(1, "Content", 2);
        Content content = mapper.contentDtoToContent(contentDto);
        Assert.assertEquals(content.getContentId(), contentDto.getContentId());
        Assert.assertEquals(content.getContent(), contentDto.getContent());
        Assert.assertEquals(content.getPostId(), contentDto.getPostId());
    }
}
