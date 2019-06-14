package com.blog;
import com.blog.entity.*;
import com.blog.mapper.BlogMapper;
import com.blog.mapper.ReplyMapper;
import com.blog.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogApplicationTests {

    @Autowired
    UserMapper userMapper;
    @Autowired
    BlogMapper blogMapper;
    @Autowired
    ReplyMapper replyMapper;

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
    public void testSelectLatest(){
        List<Blog> blogList = blogMapper.selectLatestLimit4();
        for(Blog e:blogList){
            System.out.println(e);
        }
    }

    @Test
    public void testSelectRecommend(){
        List<Blog> blogList = blogMapper.selectRecommendLimit4();
        for(Blog e:blogList){
            System.out.println(e);
        }
    }

    @Test
    public void testSelectHotest(){
        List<Blog> blogList = blogMapper.selectHotestLimit4();
        for(Blog e:blogList){
            System.out.println(e);
        }
    }

}
