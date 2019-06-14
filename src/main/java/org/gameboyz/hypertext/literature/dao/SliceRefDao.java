package org.gameboyz.hypertext.literature.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.gameboyz.hypertext.literature.pojo.po.SliceRefPO;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @author: Shiina18
 * @date: 2019/6/5 16:11
 * @description:
 */
@Mapper
@Component
public interface SliceRefDao {

    @Select("SELECT * FROM slice_ref WHERE id = #{sliceId} AND state=1")
    SliceRefPO findSliceById(Integer sliceId);

    @Select("SELECT * FROM slice_ref WHERE fiction_id = #{fictionId} AND state = 1")
    Set<SliceRefPO> findSliceByFictionId(Integer fictionId);

    @Insert("INSERT INTO slice_ref(choose,author_id,from_id,to_id,fiction_id) VALUE(#{choose},#{authorId},#{fromId},#{toId},#{fictionId})")
    void insertNew(SliceRefPO po);
}
