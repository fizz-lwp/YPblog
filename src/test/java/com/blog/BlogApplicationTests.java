package com.blog;
import com.blog.entity.*;
import com.blog.mapper.*;
import com.blog.service.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.io.File;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;
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
    @Autowired
    TypeMapper typeMapper;
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
        User user = userMapper.selectFullById(1);
        System.out.println(user.getRegisterTime());
        System.out.println(user.getRegisterTime().getYear());
        System.out.println(user.getRegisterTime().getMonth());
        System.out.println(user.getRegisterTime().getDayOfMonth());
        System.out.println(user.getRegisterTime().getHour());
        System.out.println(user.getRegisterTime().getMinute());
        System.out.println(user.getRegisterTime().getSecond());
//        User user = new User();
//        user.setId(1);
//        user.setRegisterTime(LocalDateTime.now());
//        userMapper.update(user);
    }

    @Test
    public void testType(){
        Integer typeId = null,num = 2;
        Random random = new Random(47);
        List<Blog> blogList = blogMapper.selectRecommendBlogs(typeId); // all or 2*num ?
        List<Blog> result = new ArrayList<>(num);
        Map<Integer,Integer> booleans = new HashMap<>(num);
        int number;
        for(int i = 0;i < num;i++){
            do{
                number = random.nextInt(blogList.size());
            }while(booleans.containsKey(number));
            booleans.put(number,null);
            result.add(blogList.get(number));
        }
    }

    @Test
    public void testGetTypeByName(){
        typeMapper.selectByName("随笔");
    }

}
