package com.blog;
import com.blog.entity.*;
import com.blog.mapper.BlogMapper;
import com.blog.mapper.CommentMapper;
import com.blog.mapper.ReplyMapper;
import com.blog.mapper.UserMapper;
import com.blog.service.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogApplicationTests {

    @Autowired
    UserMapper userMapper;
    @Autowired
    BlogMapper blogMapper;
    @Autowired
    ReplyMapper replyMapper;
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    UserService userService;
    @Autowired
    BlogService blogService;
    @Autowired
    TypeService typeService;
    @Autowired
    CommentService commentService;
    @Autowired
    ReplyService replyService;

    @Test
    public void test() {
        User user = new User();
        User result = userMapper.selectUser("fizz","123456");
        Role role = result.getRole();
        System.out.println(role);
    }

    @Test
    public void testUpdateUser(){
        User user = new User();
        user.setId(1);
        user.setName("Fizz");
        user.setSignature("鲨鱼！~~~~~~~~~");
        System.out.println(userMapper.update(user));
    }

    @Test
    public void testInsertBlog(){
        Blog blog = new Blog();
        Type type = new Type();
        User user = new User();
        type.setId(1);
        user.setId(1);
        blog.setType(type);
        blog.setUser(user);
        blog.setContent("helloworld");
        blogMapper.insert(blog);
    }

    @Test
    public void testSelectReply(){
        System.out.println(replyMapper.selectById(1));
    }

    @Test
    public void testSelectBlog(){
        Blog blog = blogMapper.selectByIdFull(1);
        System.out.println(blog);
        for(Comment e:blog.getCommentList()){
            System.out.println(e);
            for(Reply ee:e.getReplyList()){
                System.out.println(ee);
            }
        }
    }

    @Test
    public void testSelectCount(){
        System.out.println(blogMapper.selectCountByUserId(1));
    }

    @Test
    public void testCount(){
        System.out.println(userService.countUser());
        System.out.println(blogService.countBlog());
        System.out.println(typeService.countType());
    }

    @Test
    public void testType(){

    }

}
