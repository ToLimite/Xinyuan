package com.xinyuan.mapper;

import com.xinyuan.pojo.Xinyuan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface XinyuanMapper {

    @Select("select * from xinyuan where state = #{state}")
    List<Xinyuan> getXyItems(Long state);

}
