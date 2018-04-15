package com.netcracker.unc.service;

import com.netcracker.unc.dto.ContentDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/applicationContext.xml"})
public class ContentServiceTest {

    @Autowired
    ContentService contentService;

    @Test
    public void addContent() {
        ContentDto contentDto = new ContentDto("content", 1);
        contentService.addContent(contentDto);
        ContentDto savedContent = contentService.getAllByPostsId(contentDto.getPostId()).get(0);
        Assert.assertNotNull(savedContent);
        Assert.assertEquals(savedContent.getContent(), contentDto.getContent());
        Assert.assertEquals(savedContent.getPostId(), contentDto.getPostId());
        Assert.assertNotNull(savedContent.getContentId());
        contentService.deleteContent(savedContent.getContentId());
    }

    @Test
    public void updateContent(){
        ContentDto contentDto = new ContentDto("content", 1);
        contentService.addContent(contentDto);
        ContentDto savedContent = contentService.getAllByPostsId(contentDto.getPostId()).get(0);
        savedContent.setContent("New text");
        contentService.updateContent(savedContent);
        savedContent = contentService.getContentById(savedContent.getContentId());
        Assert.assertEquals(savedContent.getContent(), "New text");
        contentService.deleteContent(savedContent.getContentId());
    }
}
