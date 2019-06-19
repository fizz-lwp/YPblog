package com.blog.mapper;
import com.blog.entity.Collect;
import com.blog.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface CollectMapper {

    List<Collect> selectByUserId(Integer userId);

}
