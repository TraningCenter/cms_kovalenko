package web;

import dto.FullPost;
import dto.MessageDto;
import org.primefaces.push.EventBus;
import service.ContentService;
import service.MessageService;
import service.PostService;
import web.util.EventBusCreator;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@ManagedBean
@ViewScoped
public class PostView {

    @EJB
    private PostService postService;
    @EJB
    private MessageService messageService;
    @EJB
    private ContentService contentService;
    @EJB
    private EventBusCreator ebc;
    @ManagedProperty(value = "#{loginView}")
    private LoginView loginView;

    private FullPost post;
    private List<MessageDto> messages;
    private List<String> images;
    private String newMessage = "";


    @PostConstruct
    public void init() {
        post = new FullPost();
        messages = new ArrayList<>();
        images = new ArrayList<>();
    }

    public void findPostById() {
        post = postService.getPostById(post.getPostId());
        if (post.getPictures() != null) {
            post.getPictures().forEach(elem -> images.add(elem.getContent()));
        }
    }

    public FullPost getPost() {
        return post;
    }

    public void setPost(FullPost post) {
        this.post = post;
    }

    public void addMessage() {
        if (!Objects.equals(newMessage, "") && loginView.isLogged()) {
            MessageDto messageDto = new MessageDto();
            messageDto.setPostId(post.getPostId());
            messageDto.setUserId(loginView.getUser().getUserId());
            messageDto.setText(newMessage);
            messageService.addMessage(messageDto);
            EventBus eventBus = ebc.getEventBus();
            eventBus.publish("/chat/" + post.getPostId(), "str");
            newMessage = "";
            messages = postService.getPostMessages(post.getPostId());
        }
    }

    public List<MessageDto> getMessages() {
        messages = postService.getPostMessages(post.getPostId());
        if (messages == null) {
            messages = new ArrayList<>();
        }
        return messages;
    }

    public void editTitle() {
        if (!Objects.equals(post.getTitle(), "")) {
            postService.updatePost(post);
        }
    }

    public void editText() {
        if (!Objects.equals(post.getText().getContent(), "")) {
            contentService.updateContent(post.getText());
        }
    }

    public void setMessages(List<MessageDto> messages) {
        this.messages = messages;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public PostService getPostService() {
        return postService;
    }

    public void setPostService(PostService postService) {
        this.postService = postService;
    }

    public EventBusCreator getEbc() {
        return ebc;
    }

    public void setEbc(EventBusCreator ebc) {
        this.ebc = ebc;
    }

    public String getNewMessage() {
        return newMessage;
    }

    public void setNewMessage(String newMessage) {
        this.newMessage = newMessage;
    }

    public MessageService getMessageService() {
        return messageService;
    }

    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    public ContentService getContentService() {
        return contentService;
    }

    public void setContentService(ContentService contentService) {
        this.contentService = contentService;
    }

    public LoginView getLoginView() {
        return loginView;
    }

    public void setLoginView(LoginView loginView) {
        this.loginView = loginView;
    }
}
