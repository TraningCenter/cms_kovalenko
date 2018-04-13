package com.netcracker.unc.dto;

import com.netcracker.unc.model.User;
import com.netcracker.unc.util.ParseUtil;

import java.util.ArrayList;

public class PostDto {
    private Integer postId;
    private String title;
    private Integer userId;
    private Integer textId;
    private ArrayList<Integer> picturesId;

    public PostDto() {
    }

    public PostDto(Integer postId, String title, Integer userId, Integer textId, ArrayList<Integer> picturesId) {
        this.postId = postId;
        this.title = title;
        this.userId = userId;
        this.textId = textId;
        this.picturesId = picturesId;
    }

    public PostDto(String title, Integer userId, Integer textId, ArrayList<Integer> picturesId) {
        this.title = title;
        this.userId = userId;
        this.textId = textId;
        this.picturesId = picturesId;
    }

    public PostDto(Integer postId, String title, Integer userId, Integer textId) {
        this.postId = postId;
        this.title = title;
        this.userId = userId;
        this.textId = textId;
    }

    public PostDto(String title, Integer userId, Integer textId) {
        this.title = title;
        this.userId = userId;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public void parsePicturesId(String stringArray){
        picturesId = ParseUtil.parseStringArray(stringArray);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostDto postDto = (PostDto) o;

        if (postId != null ? !postId.equals(postDto.postId) : postDto.postId != null) return false;
        if (title != null ? !title.equals(postDto.title) : postDto.title != null) return false;
        if (userId != null ? !userId.equals(postDto.userId) : postDto.userId != null) return false;
        if (textId != null ? !textId.equals(postDto.textId) : postDto.textId != null) return false;
        return picturesId != null ? picturesId.equals(postDto.picturesId) : postDto.picturesId == null;
    }

    @Override
    public int hashCode() {
        int result = postId != null ? postId.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (textId != null ? textId.hashCode() : 0);
        result = 31 * result + (picturesId != null ? picturesId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PostDto{");
        sb.append("postId=").append(postId);
        sb.append(", title='").append(title).append('\'');
        sb.append(", userId=").append(userId);
        sb.append(", textId=").append(textId);
        sb.append(", picturesId=").append(picturesId);
        sb.append('}');
        return sb.toString();
    }
}
