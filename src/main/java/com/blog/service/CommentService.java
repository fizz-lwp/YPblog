package com.blog.service;
import com.blog.entity.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> getCommentsByUserId(Integer userId);

}
