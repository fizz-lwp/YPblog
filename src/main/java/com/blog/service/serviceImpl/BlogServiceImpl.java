package com.blog.service.serviceImpl;
import com.blog.entity.Blog;
import com.blog.entity.Collect;
import com.blog.mapper.BlogMapper;
import com.blog.service.BlogService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogMapper blogMapper;

    @Override
    public List<Blog> getBlogsOrderByPT(Integer typeId,Integer num){
        return blogMapper.selectBlogsOrderByPT(typeId,num);
    }
    @Override
    public List<Blog> getBlogsOrderByReadCount(Integer typeId,Integer num){
        return blogMapper.selectBlogsOrderByReadCount(typeId,num);
    }
    @Override
    public List<Blog> getRecommendBlogs(Integer typeId,Integer num){
        if(num == null){
            return blogMapper.selectRecommendBlogs(typeId);
        }
        else{
            Random random = new Random(47);
            List<Blog> blogList = blogMapper.selectRecommendBlogs(typeId); // all or 2*num ?
            List<Blog> result = new ArrayList<>(num);
            boolean[] booleans = new boolean[blogList.size()];
            int number;
            for(int i = 0;i < num;i++){
                do{
                    number = random.nextInt(blogList.size());
                }while(booleans[i]);
                booleans[i] = true;
                result.add(blogList.get(number));
            }
            return result;
        }
    }
    @Override
    public List<Blog> getBlogsByUserId(Integer userId){
        return blogMapper.selectByUserId(userId);
    }
    @Override
    public List<Blog> getLatestBlogs(int limit){
        return blogMapper.selectLatest(limit);
    }
    @Override
    public List<Blog> getReadestBlogs(int limit){
        return blogMapper.selectHotest(limit);
    }
    @Override
    public List<Blog> getRecommendBlogs(int limit){
        return blogMapper.selectRecommend(limit);
    }
    @Override
    public int editBlog(Blog blog){
        return blogMapper.insert(blog);
    }
    @Override
    public Blog getBlogById(Integer id){
        return blogMapper.selectByIdFull(id);
    }
    @Override
    public List<Blog> getListByCollectList(List<Collect> collectList){
        List<Blog> blogList = new LinkedList<>();
        for(Collect e:collectList){
            blogList.add(blogMapper.selectById(e.getBlog().getId()));
        }
        return blogList;
    }
    @Override
    public void deleteBlogById(int blogId){
        blogMapper.delete(blogId);
    }
    @Override
    public Blog setRecommend(int blogId){
        blogMapper.updateRecommend1(blogId);
        return blogMapper.selectById(blogId);
    }
    @Override
    public Blog setNoRecommend(int blogId){
        blogMapper.updateRecommend0(blogId);
        return blogMapper.selectById(blogId);
    }
    @Override
    public int countBlog(){
        return blogMapper.selectCount();
    }
    @Override
    public List<Blog> getAllBlogs(){
        return blogMapper.selectAll();
    }
    @Override
    public int saveBlog(Blog blog){
        return blogMapper.insert(blog);
    }

}
