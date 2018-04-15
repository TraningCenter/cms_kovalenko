package dto;

import java.util.Date;

public class MessageDto {
    private Integer messageId;
    private Integer postId;
    private Integer userId;
    private String userName;
    private String text;
    private Date dateTime;

    public MessageDto() {
    }

    public MessageDto(Integer messageId, Integer postId, Integer userId, String userName, String text, Date dateTime) {
        this.messageId = messageId;
        this.postId = postId;
        this.userId = userId;
        this.userName = userName;
        this.text = text;
        this.dateTime = dateTime;
    }

    public MessageDto(Integer messageId, Integer postId, Integer userId, String text, Date dateTime) {
        this.messageId = messageId;
        this.postId = postId;
        this.userId = userId;
        this.text = text;
        this.dateTime = dateTime;
    }

    public MessageDto(Integer postId, Integer userId, String text) {
        this.postId = postId;
        this.userId = userId;
        this.text = text;
    }

    public MessageDto(Integer postId, Integer userId, String text, Date dateTime) {
        this.postId = postId;
        this.userId = userId;
        this.text = text;
        this.dateTime = dateTime;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

        MessageDto that = (MessageDto) o;

        if (messageId != null ? !messageId.equals(that.messageId) : that.messageId != null) return false;
        if (postId != null ? !postId.equals(that.postId) : that.postId != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (text != null ? !text.equals(that.text) : that.text != null) return false;
        return dateTime != null ? dateTime.equals(that.dateTime) : that.dateTime == null;
    }

    @Override
    public int hashCode() {
        int result = messageId != null ? messageId.hashCode() : 0;
        result = 31 * result + (postId != null ? postId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (dateTime != null ? dateTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MessageDto{");
        sb.append("messageId=").append(messageId);
        sb.append(", postId=").append(postId);
        sb.append(", userId=").append(userId);
        sb.append(", userName='").append(userName).append('\'');
        sb.append(", text='").append(text).append('\'');
        sb.append(", dateTime=").append(dateTime);
        sb.append('}');
        return sb.toString();
    }
}
