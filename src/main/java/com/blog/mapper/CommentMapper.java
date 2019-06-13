package com.blog.mapper;
import com.blog.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface CommentMapper {

    List<Comment> selectByUserId(Integer userId); // 按字段 user_id 查询用户
    int selectCountByUserId(Integer userId); // 按字段 user_id 查询用户评论集大小

}
