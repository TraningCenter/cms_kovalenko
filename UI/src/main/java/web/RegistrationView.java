package web;

import dto.UserDto;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class RegistrationView {

    @ManagedProperty(value = "#{loginView}")
    private LoginView loginView;
    private UserDto newUser;

    @PostConstruct
    public void init() {
        newUser = new UserDto();
    }

    public void register() {
        if (loginView.getUserService().addUser(newUser)) {
            loginView.setUser(newUser);
            loginView.login();
        } else {
            loginView.addMessage(FacesMessage.SEVERITY_ERROR, "Registration Error!", "This username is already taken");
        }
    }

    public LoginView getLoginView() {
        return loginView;
    }

    public void setLoginView(LoginView loginView) {
        this.loginView = loginView;
    }

    public UserDto getNewUser() {
        return newUser;
    }

    public void setNewUser(UserDto newUser) {
        this.newUser = newUser;
    }
}
