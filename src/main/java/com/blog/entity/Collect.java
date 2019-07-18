package com.blog.entity;
import java.time.LocalDateTime;

public class Collect {

    private Integer id;
    private LocalDateTime collectTime;
    private User user;
    private Blog blog;

    @Override
    public String toString() {
        return "Collect{" +
                "id=" + id +
                ", collectTime=" + collectTime +
                ", user=" + user +
                ", blog=" + blog +
                '}';
    }

    public LocalDateTime getCollectTime() {
        return collectTime;
    }
    public void setCollectTime(LocalDateTime collectTime) {
        this.collectTime = collectTime;
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
    public Blog getBlog() {
        return blog;
    }
    public void setBlog(Blog blog) {
        this.blog = blog;
    }

}
