package com.blog.service;
import com.blog.entity.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> getCommentsByUserId(Integer userId); // 获取评论
    int saveComment(Comment comment); // 保存评论

}
