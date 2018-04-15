package web;

import controller.PostController;
import dto.PostDto;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class ListView implements Serializable {

    @Inject
    private PostController postController;

    private List<PostDto> allPosts;

    @PostConstruct
    public void init() {
        try {
            allPosts = postController.getAllPosts();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PostController getPostController() {
        return postController;
    }

    public void setPostController(PostController postController) {
        this.postController = postController;
    }

    public List<PostDto> getAllPosts() {
        return allPosts;
    }

    public void setAllPosts(List<PostDto> allPosts) {
        this.allPosts = allPosts;
    }
}
