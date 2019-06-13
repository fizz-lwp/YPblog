package com.blog.service;
import com.blog.entity.Blog;

import java.util.List;

public interface BlogService {

    int editBlog(Blog blog); // 编辑博客
    List<Blog> getLatestBlogs(); // 获取最新博客集
    List<Blog> getReadestBlogs(); // 获取最热博客集
    List<Blog> getRecommendBlogs(); // 获取推荐博客集
    Blog getBlogById(Integer id); // 获取指定博客

}
