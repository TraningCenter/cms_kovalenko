package com.netcracker.unc.model;

import java.util.Date;

public class Message {
    private Integer messageId;
    private Integer postId;
    private Integer userId;
    private String text;
    private Date dateTime;

    public Message() {
    }

    public Message(Integer messageId, Integer postId, Integer userId, String text, Date dateTime) {
        this.messageId = messageId;
        this.postId = postId;
        this.userId = userId;
        this.text = text;
        this.dateTime = dateTime;
    }

    public Message(Integer postId, Integer userId, String text, Date dateTime) {
        this.postId = postId;
        this.userId = userId;
        this.text = text;
        this.dateTime = dateTime;
    }

    public Message(Integer postId, Integer userId, String text) {
        this.postId = postId;
        this.userId = userId;
        this.text = text;
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

        Message message = (Message) o;

        if (messageId != null ? !messageId.equals(message.messageId) : message.messageId != null) return false;
        if (postId != null ? !postId.equals(message.postId) : message.postId != null) return false;
        if (userId != null ? !userId.equals(message.userId) : message.userId != null) return false;
        if (text != null ? !text.equals(message.text) : message.text != null) return false;
        return dateTime != null ? dateTime.equals(message.dateTime) : message.dateTime == null;
    }

    @Override
    public int hashCode() {
        int result = messageId != null ? messageId.hashCode() : 0;
        result = 31 * result + (postId != null ? postId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (dateTime != null ? dateTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Message{");
        sb.append("messageId=").append(messageId);
        sb.append(", postId=").append(postId);
        sb.append(", userId=").append(userId);
        sb.append(", text='").append(text).append('\'');
        sb.append(", dateTime=").append(dateTime);
        sb.append('}');
        return sb.toString();
    }
}
