package com.blog.entity;
import java.sql.Timestamp;

public class Reply {

    private Integer id;
    private User sender;
    private User receiver;
    private String content;
    private Timestamp publishTime;
    private Comment comment;

    @Override
    public String toString(){
        String result = "[" + this.getId() + "," + this.getContent() + "," + this.getPublishTime() + ",";
        if(this.getSender() != null){
            result += this.getSender().getName() + ",";
        }
        else{
            result += "null,";
        }
        if(this.getReceiver() != null){
            result += this.getReceiver().getName();
        }
        else{
            result += "null,";
        }
        if(this.getComment() != null){
            result += this.getComment().getId();
        }
        else{
            result += "null";
        }
        result += "]";
        return result;
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
    public Timestamp getPublishTime() {
        return publishTime;
    }
    public void setPublishTime(Timestamp publishTime) {
        this.publishTime = publishTime;
    }

}
