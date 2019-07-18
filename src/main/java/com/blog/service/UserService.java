package com.blog.service;
import com.blog.entity.Blog;
import com.blog.entity.User;

import java.util.List;

public interface UserService {

    User login(String name, String password); // 登录
    User reg(String name, String password); // 用户注册
//    int edit(User user); // 编辑用户个人信息
//    int delete(Integer id); // 删除用户
    int updateUser(User user); // 修改用户
//    int retrievePwd(); // 找回密码
    User getUserInfo(Integer id); // 获取用户信息
    void deleteUserById(int userId); // 删除以用户
    User lockUserById(int userId); // 更新用户的status字段，设为“禁用”
    User unlockUserById(int userId); // 更新用户的status字段，设为“正常”
    int countUser(); // 返回用户总数
    List<User> getAllUsers(); // 返回所有用户记录集

}
