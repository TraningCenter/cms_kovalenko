package com.netcracker.unc.model;

public class Post {
    private Integer postId;
    private String title;
    private Integer userId;
    private Integer textId;
    private String picturesId;

    public Post() {
    }

    public Post(Integer postId, String title, Integer userId, Integer textId, String picturesId) {
        this.postId = postId;
        this.title = title;
        this.userId = userId;
        this.textId = textId;
        this.picturesId = picturesId;
    }

    public Post(String title, Integer userId, Integer textId, String picturesId) {
        this.title = title;
        this.userId = userId;
        this.textId = textId;
        this.picturesId = picturesId;
    }

    public Post(String title, Integer userId, Integer textId) {
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
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post post = (Post) o;

        if (postId != null ? !postId.equals(post.postId) : post.postId != null) return false;
        if (title != null ? !title.equals(post.title) : post.title != null) return false;
        if (userId != null ? !userId.equals(post.userId) : post.userId != null) return false;
        if (textId != null ? !textId.equals(post.textId) : post.textId != null) return false;
        return picturesId != null ? picturesId.equals(post.picturesId) : post.picturesId == null;
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
        final StringBuilder sb = new StringBuilder("Post{");
        sb.append("postId=").append(postId);
        sb.append(", title='").append(title).append('\'');
        sb.append(", userId=").append(userId);
        sb.append(", textId=").append(textId);
        sb.append(", picturesId='").append(picturesId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
