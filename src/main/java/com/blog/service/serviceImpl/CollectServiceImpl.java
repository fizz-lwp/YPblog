package com.blog.service.serviceImpl;
import com.blog.entity.Collect;
import com.blog.mapper.CollectMapper;
import com.blog.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CollectServiceImpl implements CollectService {

    @Autowired
    CollectMapper collectMapper;

    public List<Collect> getCollectsByUserId(Integer userId){
        return collectMapper.selectByUserId(userId);
    }

}
