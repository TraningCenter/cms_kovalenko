package service;

import controller.ContentController;
import controller.UserController;
import dto.FullPost;
import dto.PostDto;
import dto.UserDto;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class UserService {

    @EJB
    private UserController userController;
    @EJB
    private ContentController contentController;

    public UserDto getUserById(Integer id) {
        UserDto userDto;
        try {
            userDto = userController.getUserById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return userDto;
    }

    public UserDto getUserByUsername(String username) {
        UserDto userDto;
        try {
            userDto = userController.getUserByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return userDto;
    }

    public List<FullPost> getUserPosts(Integer userId) {
        List<FullPost> posts = new ArrayList<>();
        List<PostDto> postDtos;
        try {
            postDtos = userController.getAllPostsByUserId(userId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        postDtos.forEach(elem -> posts.add(new FullPost(elem)));
        posts.forEach(elem -> {
            try {
                elem.setText(contentController.getAllByPostId(elem.getPostId()).get(0));
                if (elem.getText().getContent().length() <= 300) {
                    elem.getText().setContent(elem.getText().getContent());
                } else {
                    elem.getText().setContent(elem.getText().getContent().substring(0, 300) + "...");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return posts;
    }

    public boolean addUser(UserDto userDto) {
        try {
            return userController.addUser(userDto);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void updateUser(UserDto userDto) {
        try {
            userController.updateUser(userDto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public UserDto login(UserDto userDto) {
        try {
            return userController.login(userDto);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
