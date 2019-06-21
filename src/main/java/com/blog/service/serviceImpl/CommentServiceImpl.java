package com.blog.service.serviceImpl;
import com.blog.entity.Comment;
import com.blog.mapper.CommentMapper;
import com.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentMapper commentMapper;

    @Override
    public List<Comment> getCommentsByUserId(Integer userId){
        return commentMapper.selectByUserId(userId);
    }
    @Override
    public int saveComment(Comment comment){
        return commentMapper.insert(comment);
    }

}
