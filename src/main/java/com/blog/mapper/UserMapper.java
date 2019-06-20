package com.blog.mapper;
import com.blog.entity.Role;
import com.blog.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {

    User selectUser(String name,String password); // 按字段 name,password 查询用户记录
    User selectById(Integer id); // 按 ID 查询用户记录
    User selectFullById(Integer id); // 按 ID 查询用户(基本全)记录
    User selectSimpleById(Integer id); // 按 ID 查询用户（简单）记录
    int selectCount(); // 查询用户记录总数
    int insert(String name, String password, String headPhoto, Role role); // 插入用户记录
    int update(User user); // 更新用户记录
    int updateStatusUnlock(Integer id); // 按 ID 更新用户记录 status 字段为'正常'
    int updateStatusLock(Integer id); // 按 ID 更新用户记录 status 字段为'禁用'
    int delete(Integer id); // 按 ID 删除用户记录

}
