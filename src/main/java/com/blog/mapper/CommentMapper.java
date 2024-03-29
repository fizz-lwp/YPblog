package com.blog.mapper;
import com.blog.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface CommentMapper {

    List<Comment> selectByUserId(Integer userId); // 按字段 user_id 查询评论集
    int selectCountByUserId(Integer userId); // 按字段 user_id 查询用户评论集大小
    List<Comment> selectByBlogId(Integer blogId); // 按字段 blog_id 查询评论集
    int insert(Comment comment); // 插入评论记录

}
