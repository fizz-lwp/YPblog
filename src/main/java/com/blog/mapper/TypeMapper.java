package com.blog.mapper;
import com.blog.entity.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface TypeMapper {

    List<Type> selectAll();
    Type selectById(Integer id);

}
