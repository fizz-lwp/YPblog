package com.blog.entity;
import java.time.LocalDateTime;

public class Reply {

    private Integer id;
    private User sender;
    private User receiver;
    private String content;
    private LocalDateTime publishTime;
    private Comment comment;

    @Override
    public String toString() {
        return "Reply{" +
                "id=" + id +
                ", sender=" + sender +
                ", receiver=" + receiver +
                ", content='" + content + '\'' +
                ", publishTime=" + publishTime +
                ", comment=" + comment +
                '}';
    }

    public Comment getComment() {
        return comment;
    }
    public void setComment(Comment comment) {
        this.comment = comment;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public User getSender() {
        return sender;
    }
    public void setSender(User sender) {
        this.sender = sender;
    }
    public User getReceiver() {
        return receiver;
    }
    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public LocalDateTime getPublishTime() {
        return publishTime;
    }
    public void setPublishTime(LocalDateTime publishTime) {
        this.publishTime = publishTime;
    }

}
