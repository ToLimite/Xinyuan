package com.xinyuan.mapper;

import com.xinyuan.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from user where phone = #{phone}")
    User getByPhone(String phone);

    @Insert("insert into user (name, phone, password) values (#{name}, #{phone}, #{password})")
    void add(String name, String phone, String password);
}
