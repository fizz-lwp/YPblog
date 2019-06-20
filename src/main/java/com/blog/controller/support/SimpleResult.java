package com.blog.controller.support;
//结果封装类 用于封装到admin/admin页面的信息
public class SimpleResult {
    //用户数量
    private int userNum;
    //博客数量
    private int blogNum;
    //类型数量
    private int typeNum;

    public int getUserNum() {
        return userNum;
    }

    public void setUserNum(int userNum) {
        this.userNum = userNum;
    }

    public int getBlogNum() {
        return blogNum;
    }

    public void setBlogNum(int blogNum) {
        this.blogNum = blogNum;
    }

    public int getTypeNum() {
        return typeNum;
    }

    public void setTypeNum(int typeNum) {
        this.typeNum = typeNum;
    }
}
