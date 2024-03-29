package com.blog.service;
import com.blog.entity.Type;
import java.util.List;

public interface TypeService {

    Type getType(String name); // 获取栏目类
    List<Type> getAllTypes(); // 返回所有栏目记录集
    Type addType(String type); // 增加栏目（重名添加失败返回null）
    void deleteType(String name); // 删除栏目（删除栏目后该栏目的文章级联删除）
    Type renameType(String oldType,String newType);	// 给栏目换名字（不允许重名）
    int countType(); // 返回栏目总数

}
