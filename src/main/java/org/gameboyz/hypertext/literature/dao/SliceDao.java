package org.gameboyz.hypertext.literature.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.gameboyz.hypertext.literature.pojo.po.SlicePO;
import org.springframework.stereotype.Component;

/**
 * @author: Shiina18
 * @date: 2019/6/5 16:18
 * @description:
 */
@Mapper
@Component
public interface SliceDao {

    @Select("SELECT * from slice WHERE id = #{sliceId}")
    SlicePO findById(Integer sliceId);

    @Insert("INSERT INTO slice(author_id,fiction_id,title,text) VALUE(#{authorId},#{fictionId},#{title},#{text})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insertNew(SlicePO slicePO);

}
