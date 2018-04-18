package web;

import dto.UserDto;
import service.UserService;
import util.RootProvider;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.util.Objects;

@ManagedBean
@SessionScoped
public class LoginView {

    @EJB
    private UserService userService;
    private UserDto user;
    private boolean logged = false;

    @PostConstruct
    public void init() {
        user = new UserDto();
    }

    public void login() {
        UserDto loggedUser = userService.login(user);
        if (loggedUser != null) {
            user = loggedUser;
            logged = true;
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect(RootProvider.getFullRoot() + "/profile?id=" + user.getUserId());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            addMessage(FacesMessage.SEVERITY_ERROR, "Authorization Error!", "Incorrect username or password");
        }
    }

    public void exit() {
        user = new UserDto();
        logged = false;
    }

    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesMessage message = new FacesMessage(severity, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public boolean isOwner(Integer id) {
        return logged && Objects.equals(user.getUserId(), id);
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }
}
