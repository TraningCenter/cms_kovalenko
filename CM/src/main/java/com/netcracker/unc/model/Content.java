package com.netcracker.unc.model;

import javax.persistence.*;

@Entity
@Table(name = "contents")
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "content_id")
    private Integer contentId;

    @Column(name = "content")
    private String content;

    @Column(name = "post_id")
    private Integer postId;

    public Content() {
    }

    public Content(String content, Integer postId) {
        this.content = content;
        this.postId = postId;
    }

    public Integer getContentId() {
        return contentId;
    }

    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Content content1 = (Content) o;

        if (contentId != null ? !contentId.equals(content1.contentId) : content1.contentId != null) return false;
        if (content != null ? !content.equals(content1.content) : content1.content != null) return false;
        return postId != null ? postId.equals(content1.postId) : content1.postId == null;
    }

    @Override
    public int hashCode() {
        int result = contentId != null ? contentId.hashCode() : 0;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (postId != null ? postId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Content{");
        sb.append("contentId=").append(contentId);
        sb.append(", content='").append(content).append('\'');
        sb.append(", postId=").append(postId);
        sb.append('}');
        return sb.toString();
    }
}
