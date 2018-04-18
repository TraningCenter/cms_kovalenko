package service;

import controller.ContentController;
import dto.ContentDto;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.io.IOException;
import java.util.List;

@Stateless
public class ContentService {

    @EJB
    private ContentController contentController;

    public ContentDto getContentById(Integer id) {
        ContentDto contentDto;
        try {
            contentDto = contentController.getContentById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return contentDto;
    }


    public List<ContentDto> getAllByPostId(Integer postId) {
        List<ContentDto> contentDtos;
        try {
            contentDtos = contentController.getAllByPostId(postId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return contentDtos;
    }

    public void addContent(ContentDto contentDto) {
        try {
            contentController.addContent(contentDto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateContent(ContentDto contentDto) {
        try {
            contentController.updateContent(contentDto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
