package com.blog.service.serviceImpl;
import com.blog.entity.Blog;
import com.blog.mapper.BlogMapper;
import com.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogMapper blogMapper;

    @Override
    public List<Blog> getLatestBlogs(){
        return blogMapper.selectLatestLimit4();
    }

    @Override
    public List<Blog> getReadestBlogs(){
        return blogMapper.selectHotestLimit4();
    }

    @Override
    public List<Blog> getRecommendBlogs(){
        return blogMapper.selectRecommendLimit4();
    }

    @Override
    public int editBlog(Blog blog){
        return blogMapper.insert(blog);
    }

    @Override
    public Blog getBlogById(Integer id){
        return blogMapper.selectById(id);
    }

}
