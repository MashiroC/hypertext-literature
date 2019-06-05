package org.gameboyz.hypertext.literature.dao;

import org.gameboyz.hypertext.literature.pojo.po.FictionPO;

import java.util.Set;

/**
 * @author: Shiina18
 * @date: 2019/6/5 15:41
 * @description:
 */
public interface FictionDao {
    public Set<FictionPO> findAll();
}
