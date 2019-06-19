package com.blog.entity;

public class Collect {

    private Integer id;
    private User user;
    private Blog blog;

    @Override
    public String toString() {
        return "Collect{" +
                "id=" + id +
                ", user=" + user +
                ", blog=" + blog +
                '}';
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
