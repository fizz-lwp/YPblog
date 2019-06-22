package com.blog.mapper;
import com.blog.entity.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface BlogMapper {

    List<Blog> selectBlogsOrderByPT(@Param("typeId")Integer typeId,@Param("limit")Integer num); // 获取最新博客集
    List<Blog> selectBlogsOrderByReadCount(@Param("typeId")Integer typeId,@Param("limit")Integer num); // 获取热博客集
    List<Blog> selectRecommendBlogs(@Param("typeId")Integer typeId); // 获取推荐博客集
    List<Blog> selectHotest(@Param("limit")int limit); // 查询 limit 条最热博客记录
    List<Blog> selectLatest(@Param("limit")int limit); // 查询 limit 条最新博客记录
    List<Blog> selectRecommend(@Param("limit")int limit); // 查询 limit 条推荐博客记录
    List<Blog> selectAll(); // 查询所有博客记录集
    Blog selectById(Integer id); // 按 ID 查询（首页）博客记录
    Blog selectByIdFull(Integer id); // 按 ID 查询（全）博客记录
    int selectCountByUserId(Integer userId); // 按字段 user_id 查询用户博客集大小
    List<Blog> selectByUserId(Integer userId); // 按字段 user_id 查询博客集
    int selectCount(); // 查询博客记录总数
    int insert(Blog blog); // 插入博客记录
    int update(Blog blog); // 更新博客记录
    int updateRecommend1(Integer id); // 按 ID 更新博客记录 recommend 字段为 1 推荐
    int updateRecommend0(Integer id); // 按 ID 更新博客记录 recommend 字段为 0 非推荐
    int delete(Integer id); // 按 ID 删除博客记录

}
