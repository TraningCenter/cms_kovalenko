package com.netcracker.unc.dto;

public class ContentDto {

    private Integer contentId;
    private String content;
    private Integer postId;

    public ContentDto() {
    }

    public ContentDto(Integer contentId, String content, Integer postId) {
        this.contentId = contentId;
        this.content = content;
        this.postId = postId;
    }

    public ContentDto(String content, Integer postId) {
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

        ContentDto that = (ContentDto) o;

        if (contentId != null ? !contentId.equals(that.contentId) : that.contentId != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        return postId != null ? postId.equals(that.postId) : that.postId == null;
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
        final StringBuilder sb = new StringBuilder("ContentDto{");
        sb.append("contentId=").append(contentId);
        sb.append(", content='").append(content).append('\'');
        sb.append(", postId=").append(postId);
        sb.append('}');
        return sb.toString();
    }
}
