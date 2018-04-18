package web;

import dto.FullPost;
import dto.UserDto;
import service.UserService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@ManagedBean
@ViewScoped
public class ProfileView {

    @EJB
    private UserService userService;

    private UserDto user;
    private List<FullPost> posts;

    @PostConstruct
    public void init() {
        user = new UserDto();
        posts = new ArrayList<>();
    }

    public void findUserById() {
        user = userService.getUserById(user.getUserId());
        posts = userService.getUserPosts(user.getUserId());
        if (posts == null) {
            posts = new ArrayList<>();
        }
    }

    public void editPersonalData() {
        if (!Objects.equals(user.getFirstName(), "") && !Objects.equals(user.getLastName(), "")) {
            userService.updateUser(user);
        }
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public List<FullPost> getPosts() {
        return posts;
    }

    public void setPosts(List<FullPost> posts) {
        this.posts = posts;
    }
}
