package com.blog.mapper;
import com.blog.entity.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface TypeMapper {
    List<Type> selectAll(); // 查询所有栏目记录集
    Type selectById(Integer id); // 按 ID 查询栏目记录
    Type selectByName(String name); // 按字段 name 查询栏目记录
    int selectCount(); // 查询栏目记录总数
    int insert(String name); // 插入栏目记录
    int updateName(String oldName,String newName); // 更新栏目记录字段 oldName 为 newName
    int deleteByName(String name); // 按字段 name 删除栏目记录

}
