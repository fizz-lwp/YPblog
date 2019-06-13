package com.blog.entity;

public class User {

    private Integer id;
    private String name;
    private String password;
    private Sex sex;
    private Integer age;
    private String email;
    private String signature;
    private Role role;

    @Override
    public String toString(){
        return "[" + this.getId() + "," + this.getName() + "," + this.getPassword() + "," + this.getSex() + "," + this.getAge() + "," + this.getEmail() + "," + this.getSignature() + "]";
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
