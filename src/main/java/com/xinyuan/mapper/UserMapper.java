package com.xinyuan.mapper;

import com.xinyuan.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from user where phone = #{phone}")
    User getByPhone(String phone);
}
