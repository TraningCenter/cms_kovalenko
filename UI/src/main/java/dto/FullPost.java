package dto;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FullPost {
    private Integer postId;
    private String title;
    private UserDto user;
    private ContentDto text;
    private ArrayList<ContentDto> pictures;
    private String dateTime;

    public FullPost() {
    }

    public FullPost(Integer postId, String title, UserDto user, ContentDto text, ArrayList<ContentDto> pictures, Date dateTime) {
        this.postId = postId;
        this.title = title;
        this.user = user;
        this.text = text;
        this.pictures = pictures;
        SimpleDateFormat dt = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        this.dateTime = dt.format(dateTime);
    }

    public FullPost(PostDto postDto) {
        this.postId = postDto.getPostId();
        this.title = postDto.getTitle();
        this.user = postDto.getUser();
        SimpleDateFormat dt = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        this.dateTime = dt.format(postDto.getDateTime());
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public ContentDto getText() {
        return text;
    }

    public void setText(ContentDto text) {
        this.text = text;
    }

    public ArrayList<ContentDto> getPictures() {
        return pictures;
    }

    public void setPictures(ArrayList<ContentDto> pictures) {
        this.pictures = pictures;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        SimpleDateFormat dt = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        this.dateTime = dt.format(dateTime);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FullPost fullPost = (FullPost) o;

        if (postId != null ? !postId.equals(fullPost.postId) : fullPost.postId != null) return false;
        if (title != null ? !title.equals(fullPost.title) : fullPost.title != null) return false;
        if (user != null ? !user.equals(fullPost.user) : fullPost.user != null) return false;
        if (text != null ? !text.equals(fullPost.text) : fullPost.text != null) return false;
        if (pictures != null ? !pictures.equals(fullPost.pictures) : fullPost.pictures != null) return false;
        return dateTime != null ? dateTime.equals(fullPost.dateTime) : fullPost.dateTime == null;
    }

    @Override
    public int hashCode() {
        int result = postId != null ? postId.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (pictures != null ? pictures.hashCode() : 0);
        result = 31 * result + (dateTime != null ? dateTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FullPost{");
        sb.append("postId=").append(postId);
        sb.append(", title='").append(title).append('\'');
        sb.append(", user=").append(user);
        sb.append(", text='").append(text).append('\'');
        sb.append(", pictures=").append(pictures);
        sb.append(", dateTime=").append(dateTime);
        sb.append('}');
        return sb.toString();
    }
}
