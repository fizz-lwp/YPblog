package com.blog.entity;
import java.util.ArrayList;
import java.util.List;

public class Type {

    private Integer id;
    private String name;
    private List<Blog> blogList = new ArrayList<>();

    public List<Blog> getBlogList() {
        return blogList;
    }
    public void setBlogList(List<Blog> blogList) {
        this.blogList = blogList;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
