package org.gameboyz.hypertext.literature.dao;

import org.gameboyz.hypertext.literature.pojo.po.UserPO;

/**
 * @author: Shiina18
 * @date: 2019/6/5 15:47
 * @description:
 */
public interface UserDao {
    UserPO findUserById(Integer authorId);
}
