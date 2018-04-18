package web;

import dto.FullPost;
import service.PostService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class ListView implements Serializable {

    @EJB
    private PostService postService;

    private List<FullPost> allPosts;

    @PostConstruct
    public void init() {
        allPosts = postService.getAllPosts();
        System.out.println();
    }

    public PostService getPostService() {
        return postService;
    }

    public void setPostService(PostService postService) {
        this.postService = postService;
    }

    public List<FullPost> getAllPosts() {
        return allPosts;
    }

    public void setAllPosts(List<FullPost> allPosts) {
        this.allPosts = allPosts;
    }
}
