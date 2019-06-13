package com.blog.service.serviceImpl;
import com.blog.entity.Type;
import com.blog.mapper.TypeMapper;
import com.blog.service.TypeService;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    TypeMapper typeMapper;

    @Override
    public List<Type> getAllType(){
        return typeMapper.selectAll();
    }

}
