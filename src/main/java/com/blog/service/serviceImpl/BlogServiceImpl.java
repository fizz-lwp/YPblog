package com.blog.service.serviceImpl;
import com.blog.entity.Blog;
import com.blog.mapper.BlogMapper;
import com.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogMapper blogMapper;

    @Override
    public List<Blog> getLatestBlogs(){
        return blogMapper.selectLatestLimit();
    }

    @Override
    public List<Blog> getReadestBlogs(){
        return blogMapper.selectHotestLimit();
    }

    @Override
    public List<Blog> getRecommendBlogs(){
        return blogMapper.selectRecommendLimit();
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
