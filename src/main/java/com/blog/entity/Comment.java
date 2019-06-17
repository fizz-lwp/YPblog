package com.blog.entity;
import java.sql.Timestamp;
import java.util.List;
import java.util.ArrayList;

public class Comment {

    private Integer id;
    private User user;
    private String content;
    private Timestamp publishTime;
    private Blog blog;
    private List<Reply> replyList = new ArrayList<>();

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", user=" + user +
                ", content='" + content + '\'' +
                ", publishTime=" + publishTime +
                ", blog=" + blog +
                ", replyList=" + replyList +
                '}';
    }

    public Blog getBlog() {
        return blog;
    }
    public void setBlog(Blog blog) {
        this.blog = blog;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
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
    public List<Reply> getReplyList() {
        return replyList;
    }
    public void setReplyList(List<Reply> replyList) {
        this.replyList = replyList;
    }

}
