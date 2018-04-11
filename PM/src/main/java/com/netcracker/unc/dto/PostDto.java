package com.netcracker.unc.dto;

import com.netcracker.unc.util.ParseUtil;

import java.util.ArrayList;

public class PostDto {
    private Integer postId;
    private String title;
    private Integer userId;
    private Integer textId;
    private String picturesId;
    private ArrayList<Integer> picturesArray;

    public PostDto() {
    }

    public PostDto(Integer postId, String title, Integer userId, Integer textId, String picturesId) {
        this.postId = postId;
        this.title = title;
        this.userId = userId;
        this.textId = textId;
        this.picturesId = picturesId;
        picturesArray = ParseUtil.parseStringArray(picturesId);
    }

    public PostDto(Integer postId, String title, Integer userId, Integer textId, ArrayList<Integer> picturesArray) {
        this.postId = postId;
        this.title = title;
        this.userId = userId;
        this.textId = textId;
        this.picturesArray = picturesArray;
        picturesId = ParseUtil.convertArrayToString(picturesArray);
    }

    public PostDto(String title, Integer userId, Integer textId, String picturesId) {
        this.title = title;
        this.userId = userId;
        this.textId = textId;
        this.picturesId = picturesId;
        picturesArray = ParseUtil.parseStringArray(picturesId);
    }

    public PostDto(String title, Integer userId, Integer textId, ArrayList<Integer> picturesArray) {
        this.title = title;
        this.userId = userId;
        this.textId = textId;
        this.picturesArray = picturesArray;
        picturesId = ParseUtil.convertArrayToString(picturesArray);
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

    public String getPicturesId() {
        return picturesId;
    }

    public void setPicturesId(String picturesId) {
        this.picturesId = picturesId;
        picturesArray = ParseUtil.parseStringArray(picturesId);
    }

    public ArrayList<Integer> getPicturesArray() {
        return picturesArray;
    }

    public void setPicturesArray(ArrayList<Integer> picturesArray) {
        this.picturesArray = picturesArray;
        picturesId = ParseUtil.convertArrayToString(picturesArray);
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
        sb.append(", picturesId='").append(picturesId).append('\'');
        sb.append(", picturesArray=").append(picturesArray);
        sb.append('}');
        return sb.toString();
    }
}
