package com.blog.service.serviceImpl;
import com.blog.entity.Reply;
import com.blog.mapper.ReplyMapper;
import com.blog.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    ReplyMapper replyMapper;

    @Override
    public int saveReply(Reply reply){
        return replyMapper.insert(reply);
    }

}
