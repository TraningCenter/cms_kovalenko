package com.netcracker.unc.service;

import com.netcracker.unc.dao.ContentDao;
import com.netcracker.unc.dto.ContentDto;
import com.netcracker.unc.dto.mappers.ContentMapper;
import com.netcracker.unc.model.Content;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContentService {

    @Autowired
    private ContentDao dao;
    private ContentMapper mapper = Mappers.getMapper(ContentMapper.class);

    @Transactional
    public List<ContentDto> getAll() {
        List<Content> contents = dao.getAll();
        return contents.stream()
                .map(elem -> mapper.contentToContentDto(elem))
                .collect(Collectors.toList());
    }

    @Transactional
    public List<ContentDto> getAllByPostsId(Integer postId) {
        List<Content> contents = dao.getAllByPostId(postId);
        return contents.stream()
                .map(elem -> mapper.contentToContentDto(elem))
                .collect(Collectors.toList());
    }

    @Transactional
    public ContentDto getContentById(Integer id) {
        Content content = dao.get(id);
        return mapper.contentToContentDto(content);
    }

    @Transactional
    public void addContent(ContentDto contentDto) {
        Content content = mapper.contentDtoToContent(contentDto);
        dao.create(content);
    }

    @Transactional
    public void updateContent(ContentDto contentDto) {
        Content content = mapper.contentDtoToContent(contentDto);
        dao.update(content);
    }

    @Transactional
    public void deleteContent(Integer id) {
        dao.delete(id);
    }
}
