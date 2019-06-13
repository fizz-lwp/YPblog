package com.blog.mapper;
import com.blog.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface RoleMapper {

    Role select(Integer id);

}
