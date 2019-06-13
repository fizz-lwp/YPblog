package com.blog.mapper;
import com.blog.entity.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface BlogMapper {

    Blog selectById(Integer id); // 按 ID 查询（简单）博客记录
    int insert(Blog blog); // 插入博客记录
    int update(Blog blog); // 更新博客记录
    int deleteById(Integer id); // 按 ID 删除博客记录
    Blog selectByIdFull(Integer id); // 按 ID 查询（复杂）博客记录
    int selectCountByUserId(Integer userId); // 按字段 user_id 查询用户博客集大小
    List<Blog> selectLatestLimit6(); // 查询最新博客集
    List<Blog> selectRecommendLimit6(); // 查询推荐博客集
    List<Blog> selectHotestLimit6(); // 查询最热博客集

}
