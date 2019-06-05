package org.gameboyz.hypertext.literature.dao;

import org.gameboyz.hypertext.literature.pojo.po.SlicePO;

/**
 * @author: Shiina18
 * @date: 2019/6/5 16:18
 * @description:
 */
public interface ContentDao {
    SlicePO findById(Integer contentId);
}
