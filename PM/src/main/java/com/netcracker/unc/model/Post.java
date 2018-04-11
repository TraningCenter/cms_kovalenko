package com.netcracker.unc.model;

import java.util.Arrays;
import java.util.Objects;

public class Post {
    private Integer postId;
    private Integer userId;
    private Integer textId;
    private Integer[] picturesId;

    public Post() {
    }

    public Post(Integer postId, Integer userId, Integer textId, Integer[] picturesId) {
        this.postId = postId;
        this.userId = userId;
        this.textId = textId;
        this.picturesId = picturesId;
    }

    public Post(Integer userId, Integer textId, Integer[] picturesId) {
        this.userId = userId;
        this.textId = textId;
        this.picturesId = picturesId;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
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

    public Integer[] getPicturesId() {
        return picturesId;
    }

    public void setPicturesId(Integer[] picturesId) {
        this.picturesId = picturesId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(postId, post.postId) &&
                Objects.equals(userId, post.userId) &&
                Objects.equals(textId, post.textId) &&
                Arrays.equals(picturesId, post.picturesId);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(postId, userId, textId);
        result = 31 * result + Arrays.hashCode(picturesId);
        return result;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", userId=" + userId +
                ", textId=" + textId +
                ", picturesId=" + Arrays.toString(picturesId) +
                '}';
    }
}
