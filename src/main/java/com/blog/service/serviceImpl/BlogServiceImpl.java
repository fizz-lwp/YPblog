package com.blog.service.serviceImpl;
import com.blog.entity.Blog;
import com.blog.entity.Collect;
import com.blog.mapper.BlogMapper;
import com.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
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

    @Override
    public List<Blog> getListByCollectList(List<Collect> collectList){
        List<Blog> blogList = new LinkedList<>();
        for(Collect e:collectList){
            blogList.add(blogMapper.selectById(e.getBlog().getId()));
        }
        return blogList;
    }

}
