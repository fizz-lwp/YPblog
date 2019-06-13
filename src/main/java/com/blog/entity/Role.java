package com.blog.entity;

public class Role {

    private Integer id;
    private String name;

    @Override
    public String toString(){
        return "[" + this.getId() + "," + this.getName() + "]";
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
