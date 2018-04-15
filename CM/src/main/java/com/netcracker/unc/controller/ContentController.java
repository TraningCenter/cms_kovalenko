package com.netcracker.unc.controller;

import com.netcracker.unc.controller.exception.BadRequestException;
import com.netcracker.unc.controller.exception.DataNotFoundException;
import com.netcracker.unc.controller.exception.InternalServerErrorException;
import com.netcracker.unc.dto.ContentDto;
import com.netcracker.unc.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("contents")
public class ContentController {

    @Autowired
    ContentService contentService;

    @RequestMapping(value = "/{contentId}", method = RequestMethod.GET)
    @ResponseBody
    public ContentDto getContentById(@PathVariable("contentId") Integer id) {
        if (id == null || id < 0) throw new BadRequestException();
        ContentDto contentDto;
        try {
            contentDto = contentService.getContentById(id);
        } catch (Exception e) {
            throw new InternalServerErrorException();
        }
        return contentDto;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<ContentDto> getAllContents() {
        List<ContentDto> contents = contentService.getAll();
        if (contents == null || contents.isEmpty())
            throw new DataNotFoundException();
        return contents;
    }

    @RequestMapping(value = "/post/{postId}", method = RequestMethod.GET)
    @ResponseBody
    public List<ContentDto> getAllByPostId(@PathVariable("postId") Integer postId) {
        if (postId == null || postId < 0) throw new BadRequestException();
        List<ContentDto> contents = contentService.getAllByPostsId(postId);
        if (contents == null || contents.isEmpty())
            throw new DataNotFoundException();
        return contents;
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createPost(@RequestBody ContentDto contentDto) {
        if (contentDto == null) throw new BadRequestException();
        contentService.addContent(contentDto);
    }

    @RequestMapping(value = "/{contentId}", method = RequestMethod.PUT)
    public void updatePost(@PathVariable("contentId") Integer id, @RequestBody ContentDto contentDto) {
        if (id == null || id < 0) throw new BadRequestException();
        if (contentDto == null) throw new BadRequestException();
        contentService.updateContent(contentDto);
    }

    @RequestMapping(value = "/{contentId}", method = RequestMethod.DELETE)
    public void deletePost(@PathVariable("contentId") Integer id) {
        if (id == null || id < 0) throw new BadRequestException();
        contentService.deleteContent(id);
    }
}
