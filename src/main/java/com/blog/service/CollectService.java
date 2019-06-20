package com.blog.service;
import com.blog.entity.Collect;
import java.util.List;

public interface CollectService {

    List<Collect> getCollectsByUserId(Integer userId);

}
