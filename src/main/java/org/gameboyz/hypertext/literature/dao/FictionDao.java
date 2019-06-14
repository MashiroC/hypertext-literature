package org.gameboyz.hypertext.literature.dao;

import org.apache.ibatis.annotations.*;
import org.gameboyz.hypertext.literature.pojo.po.FictionPO;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @author: Shiina18
 * @date: 2019/6/5 15:41
 * @description:
 */
@Mapper
@Component
public interface FictionDao {

    @Select("SELECT * FROM fiction WHERE state=1")
    Set<FictionPO> findAll();

    @Insert("INSERT INTO fiction(name,author_id) VALUE(#{name},#{authorId})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insertNew(FictionPO fictionPO);

    /**
     * 更新一个小说的序章id（入口点id）
     * @param fictionId
     * @param sliceId
     */
    @Update("UPDATE fiction SET prologue_id = #{sliceId} WHERE id = #{fictionId}")
    void addPrologueId(@Param("fictionId") Integer fictionId, @Param("sliceId") Integer sliceId);

}
