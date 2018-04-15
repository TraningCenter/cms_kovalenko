package com.netcracker.unc.dto;

import com.netcracker.unc.util.ParseUtil;

import java.util.ArrayList;
import java.util.Date;

public class PostDto {
    private Integer postId;
    private String title;
    private UserDto user;
    private Integer textId;
    private ArrayList<Integer> picturesId;
    private Date dateTime;


    public PostDto() {
    }

    public PostDto(Integer postId, String title, UserDto user, Integer textId, ArrayList<Integer> picturesId, Date dateTime) {
        this.postId = postId;
        this.title = title;
        this.user = user;
        this.textId = textId;
        this.picturesId = picturesId;
        this.dateTime = dateTime;
    }

    public PostDto(Integer postId, String title, UserDto user, Integer textId, ArrayList<Integer> picturesId) {
        this.postId = postId;
        this.title = title;
        this.user = user;
        this.textId = textId;
        this.picturesId = picturesId;
    }

    public PostDto(String title, UserDto user, Integer textId, ArrayList<Integer> picturesId) {
        this.title = title;
        this.user = user;
        this.textId = textId;
        this.picturesId = picturesId;
    }

    public PostDto(Integer postId, String title, UserDto user, Integer textId) {
        this.postId = postId;
        this.title = title;
        this.user = user;
        this.textId = textId;
    }

    public PostDto(String title, UserDto user, Integer textId) {
        this.title = title;
        this.user = user;
        this.textId = textId;
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

    public Integer getTextId() {
        return textId;
    }

    public void setTextId(Integer textId) {
        this.textId = textId;
    }

    public ArrayList<Integer> getPicturesId() {
        return picturesId;
    }

    public void setPicturesId(ArrayList<Integer> picturesId) {
        this.picturesId = picturesId;
    }

    public void parsePicturesId(String stringArray) {
        picturesId = ParseUtil.parseStringArray(stringArray);
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostDto postDto = (PostDto) o;

        if (postId != null ? !postId.equals(postDto.postId) : postDto.postId != null) return false;
        if (title != null ? !title.equals(postDto.title) : postDto.title != null) return false;
        if (user != null ? !user.equals(postDto.user) : postDto.user != null) return false;
        if (textId != null ? !textId.equals(postDto.textId) : postDto.textId != null) return false;
        if (picturesId != null ? !picturesId.equals(postDto.picturesId) : postDto.picturesId != null) return false;
        return dateTime != null ? dateTime.equals(postDto.dateTime) : postDto.dateTime == null;
    }

    @Override
    public int hashCode() {
        int result = postId != null ? postId.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (textId != null ? textId.hashCode() : 0);
        result = 31 * result + (picturesId != null ? picturesId.hashCode() : 0);
        result = 31 * result + (dateTime != null ? dateTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PostDto{");
        sb.append("postId=").append(postId);
        sb.append(", title='").append(title).append('\'');
        sb.append(", user=").append(user);
        sb.append(", textId=").append(textId);
        sb.append(", picturesId=").append(picturesId);
        sb.append(", dateTime=").append(dateTime);
        sb.append('}');
        return sb.toString();
    }
}
