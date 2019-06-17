package com.blog.entity;
import java.util.ArrayList;
import java.util.List;

public class User {

    private Integer id;
    private String name;
    private String password;
    private Sex sex;
    private Integer age;
    private String email;
    private String signature;
    private String headPhoto;
    private Role role;
    private List<Blog> blogList = new ArrayList<>();
    private List<Comment> commentList = new ArrayList<>();

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", signature='" + signature + '\'' +
                ", headPhoto='" + headPhoto + '\'' +
                ", role=" + role +
                ", blogList=" + blogList +
                ", commentList=" + commentList +
                '}';
    }

    public List<Comment> getCommentList() {
        return commentList;
    }
    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
    public List<Blog> getBlogList() {
        return blogList;
    }
    public void setBlogList(List<Blog> blogList) {
        this.blogList = blogList;
    }
    public String getHeadPhoto() {
        return headPhoto;
    }
    public void setHeadPhoto(String headPhoto) {
        this.headPhoto = headPhoto;
    }
    public Sex getSex() {
        return sex;
    }
    public void setSex(Sex sex) {
        this.sex = sex;
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
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSignature() {
        return signature;
    }
    public void setSignature(String signature) {
        this.signature = signature;
    }
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }

}
