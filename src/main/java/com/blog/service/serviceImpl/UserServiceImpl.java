package com.blog.service.serviceImpl;
import com.blog.entity.Role;
import com.blog.entity.User;
import com.blog.mapper.UserMapper;
import com.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User login(String name,String password){
        return userMapper.selectUser(name,password);
    }
    @Override
    public User reg(String name,String password){
        String headPhoto = "/upload/head_photo/default_head.png";
        Role role = new Role();
        role.setId(2);
        userMapper.insert(name,password,headPhoto,role);
        User loginUser = userMapper.selectUser(name,password);
        return loginUser;
    }
    @Override
    public User getUserInfo(Integer id){
        return userMapper.selectFullById(id);
    }

}
