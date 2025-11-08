package com.xinyuan.mapper;

import com.xinyuan.pojo.CodeDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface CodeMapper {

    @Select("select * from code where phone = #{phone}")
    CodeDTO getByPhone(String phone);

    @Insert("insert into code (phone, code, time) values (#{phone}, #{code}, #{time})")
    void addCode(String phone, String code, long time);

    @Update("update code set code = #{code}, time = #{time} where phone = #{phone}")
    void updateCode(String phone, String code, long time);
}
