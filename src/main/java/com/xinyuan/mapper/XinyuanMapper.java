package com.xinyuan.mapper;

import com.xinyuan.pojo.Xinyuan;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface XinyuanMapper {

    @Select("select * from xinyuan where state = #{state}")
    List<Xinyuan> getXyItems(Long state);

    @Select("select * from xinyuan where id = #{id}")
    Xinyuan getById(Long id);

    @Update("update xinyuan set state = 1, starUser = #{userId} where id = #{itemId}")
    void starupXinyuan(Long userId, Long itemId);

    @Select("select * from xinyuan where starUser = #{userId}")
    List<Xinyuan> getXyItemsByStarUser(Long userId);


//    @Insert("insert into starup(user_id, item_id) values(#{userId}, #{itemId})")
//    void insertStarup(Long userId, Long itemId);
}
