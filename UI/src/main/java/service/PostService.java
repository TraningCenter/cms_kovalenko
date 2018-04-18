package service;

import controller.ContentController;
import controller.PostController;
import dto.ContentDto;
import dto.FullPost;
import dto.MessageDto;
import dto.PostDto;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class PostService {

    @EJB
    private PostController postController;
    @EJB
    private ContentController contentController;

    public List<FullPost> getAllPosts() {
        List<FullPost> posts = new ArrayList<>();
        List<PostDto> postDtos;
        try {
            postDtos = postController.getAllPosts();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        postDtos.forEach(elem -> posts.add(new FullPost(elem)));
        posts.forEach(elem -> {
            try {
                elem.setText(contentController.getAllByPostId(elem.getPostId()).get(0));
                if (elem.getText().getContent().length() <= 400) {
                    elem.getText().setContent(elem.getText().getContent());
                } else {
                    elem.getText().setContent(elem.getText().getContent().substring(0, 400) + "...");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return posts;
    }

    public FullPost getPostById(Integer id) {
        PostDto postDto;
        try {
            postDto = postController.getPostById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        FullPost fullPost = new FullPost(postDto);
        List<ContentDto> contentDtos = null;
        try {
            contentDtos = contentController.getAllByPostId(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (contentDtos != null && !contentDtos.isEmpty()) {
            List<ContentDto> pictures = new ArrayList<>();
            for (int i = 0; i < contentDtos.size(); i++) {
                if (i == 0) {
                    fullPost.setText(contentDtos.get(i));
                } else {
                    pictures.add(contentDtos.get(i));
                }
            }
            if (!pictures.isEmpty()) {
                fullPost.setPictures((ArrayList<ContentDto>) pictures);
            }
        }
        return fullPost;
    }

    public List<MessageDto> getPostMessages(Integer postId) {
        List<MessageDto> messageDtos;
        try {
            messageDtos = postController.getPostMessages(postId);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return messageDtos;
    }

    public PostDto addPost(FullPost fullPost) {
        PostDto postDto = new PostDto(fullPost);
        try {
            return postController.addPost(postDto);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void updatePost(FullPost fullPost) {
        PostDto postDto = new PostDto(fullPost);
        try {
            postController.updatePost(postDto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
