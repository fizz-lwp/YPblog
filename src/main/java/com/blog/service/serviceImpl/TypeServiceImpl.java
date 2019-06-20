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
    public List<Type> getAllTypes(){
        return typeMapper.selectAll();
    }
    @Override
    public Type addType(String name){
        // 检查重名
        List<Type> types = typeMapper.selectAll();
        for(Type e:types){
            if(e.getName().equals(name)){
                return null;
            }
        }
        // 唯一命名，添加新栏目并返回添加记录
        typeMapper.insert(name);
        return typeMapper.selectByName(name);
    }
    @Override
    public void deleteType(String name){
        typeMapper.deleteByName(name);
    }
    @Override
    public Type renameType(String oldName,String newName){
        // 检查重名
        List<Type> types = typeMapper.selectAll();
        for(Type e:types){
            if(e.getName().equals(newName)){
                return null;
            }
        }
        // 唯一新命名，重命名
        typeMapper.updateName(oldName,newName);
        return typeMapper.selectByName(newName);
    }
    @Override
    public int countType(){
        return typeMapper.selectCount();
    }

}
