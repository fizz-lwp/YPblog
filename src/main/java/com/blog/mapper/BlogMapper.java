package com.blog.mapper;
import com.blog.entity.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface BlogMapper {

    Blog selectById(Integer id); // 按 ID 查询（首页）博客记录
    int insert(Blog blog); // 插入博客记录
    int update(Blog blog); // 更新博客记录
    int deleteById(Integer id); // 按 ID 删除博客记录
    Blog selectByIdFull(Integer id); // 按 ID 查询（全）博客记录
    Blog selectTest(Integer id); // test
    int selectCountByUserId(Integer userId); // 按字段 user_id 查询用户博客集大小
    List<Blog> selectLatestLimit(); // 查询部分最新博客集
    List<Blog> selectRecommendLimit(); // 查询部分推荐博客集(能力不足，尚未实现)
    List<Blog> selectHotestLimit(); // 查询部分最热博客集
    List<Blog> selectByUserId(Integer user_id); // 按字段 user_id 查询博客集

}
