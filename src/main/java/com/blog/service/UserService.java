package com.blog.service;
import com.blog.entity.User;

public interface UserService {

    User login(String name, String password); // 登录
    User reg(String name, String password); // 用户注册
//    int edit(User user); // 编辑用户个人信息
//    int delete(Integer id); // 删除用户
//    int update(Integer id); // 修改用户
//    int retrievePwd(); // 找回密码
    User getUserInfo(Integer id); // 获取用户信息

}
