package org.gameboyz.hypertext.literature.dao;

import org.gameboyz.hypertext.literature.pojo.po.SliceRefPO;

import java.util.Set;

/**
 * @author: Shiina18
 * @date: 2019/6/5 16:11
 * @description:
 */
public interface SliceDao {
    SliceRefPO findSliceById(Integer sliceId);

    Set<SliceRefPO> findSliceByFictionId(Integer fictionId);
}
