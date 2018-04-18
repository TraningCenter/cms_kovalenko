package web;

import dto.ContentDto;
import dto.FullPost;
import dto.PostDto;
import org.primefaces.event.FileUploadEvent;
import service.ContentService;
import service.PostService;
import util.RootProvider;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ManagedBean
@ViewScoped
public class CreatePostView {

    @ManagedProperty(value = "#{loginView}")
    private LoginView loginView;
    @EJB
    private PostService postService;
    @EJB
    private ContentService contentService;

    private FullPost post;
    private List<String> pictures;

    @PostConstruct
    public void init() {
        post = new FullPost();
        post.setText(new ContentDto());
        pictures = new ArrayList<>();
    }

    public void create() {
        if (!loginView.isLogged()) {
            loginView.addMessage(FacesMessage.SEVERITY_ERROR, "Error!", "You are not authorized ");
            return;
        }
        post.setUser(loginView.getUser());
        PostDto savedPost = postService.addPost(post);
        post.getText().setPostId(savedPost.getPostId());
        contentService.addContent(post.getText());
        if (pictures != null) {
            pictures.forEach(elem -> contentService.addContent(new ContentDto(elem, savedPost.getPostId())));
        }
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(RootProvider.getFullRoot() + "/post?id=" + savedPost.getPostId());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handleFileUpload(FileUploadEvent event) {
        String path = FacesContext.getCurrentInstance().getExternalContext()
                .getRealPath("/");
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmssSSS" + pictures.size());
        String name = fmt.format(new Date())
                + event.getFile().getFileName().substring(
                event.getFile().getFileName().lastIndexOf('.'));
        File file = new File(path + "/resources/img/" + name);

        InputStream is = null;
        try {
            is = event.getFile().getInputstream();
            OutputStream out = new FileOutputStream(file);
            byte buf[] = new byte[1024];
            int len;
            while ((len = is.read(buf)) > 0)
                out.write(buf, 0, len);
            is.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        pictures.add(name);
    }

    public LoginView getLoginView() {
        return loginView;
    }

    public void setLoginView(LoginView loginView) {
        this.loginView = loginView;
    }

    public PostService getPostService() {
        return postService;
    }

    public void setPostService(PostService postService) {
        this.postService = postService;
    }

    public ContentService getContentService() {
        return contentService;
    }

    public void setContentService(ContentService contentService) {
        this.contentService = contentService;
    }

    public FullPost getPost() {
        return post;
    }

    public void setPost(FullPost post) {
        this.post = post;
    }

    public List<String> getPictures() {
        return pictures;
    }

    public void setPictures(List<String> pictures) {
        this.pictures = pictures;
    }
}
