package com.blog.service;
import com.blog.entity.Blog;
import com.blog.entity.Collect;

import java.util.List;

public interface BlogService {

    int editBlog(Blog blog); // 编辑博客
    List<Blog> getLatestBlogs(int limit); // 获取最新博客集
    List<Blog> getReadestBlogs(int limit); // 获取最热博客集
    List<Blog> getRecommendBlogs(int limit); // 获取推荐博客集
    Blog getBlogById(Integer id); // 获取指定博客
    List<Blog> getListByCollectList(List<Collect> collectList); //
    List<Blog> getBlogsByUserId(Integer userId); //
    void deleteBlogById(int blogId); // 删除博客
    Blog setRecommend(int blogId); // 设置博客为推荐状态 recommend=1
    Blog setNoRecommend(int blogId); // 设置博客为非推荐状态 recommend=0
    int countBlog(); // 返回博客总数
    List<Blog> getAllBlogs(); // 返回所有博客记录集
    int saveBlog(Blog blog); // 保存博客记录

}
