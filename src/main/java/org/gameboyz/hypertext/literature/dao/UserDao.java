package org.gameboyz.hypertext.literature.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.gameboyz.hypertext.literature.pojo.po.UserPO;
import org.springframework.stereotype.Component;

/**
 * @author: Shiina18
 * @date: 2019/6/5 15:47
 * @description:
 */
@Mapper
@Component
public interface UserDao {


    @Select("SELECT * FROM users WHERE id = #{authorId}")
    UserPO findUserById(Integer authorId);

    @Insert("INSERT INTO users(username,password) VALUE(#{username},#{password})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insertNew(UserPO userPO);

    @Select("SELECT * from users WHERE username = #{username} AND password = #{password}")
    UserPO findUserByUsernameAndPassword(UserPO userPO);

    @Select("SELECT * from users WHERE username = #{username}")
    UserPO findUserByUsername(String username);
}
