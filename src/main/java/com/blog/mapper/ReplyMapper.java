package com.blog.mapper;
import com.blog.entity.Reply;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ReplyMapper {

    List<Reply> selectByCommentId(Integer commentId); // 按字段 comment_id 查询回复记录集
    Reply selectById(Integer id); //

}
