package com.blog.mapper;
import com.blog.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {

    User selectUser(String name,String password);
    int update(User user); // 更新用户记录
    User selectById(Integer id); // 按 ID 查询用户记录

}
