package org.gameboyz.hypertext.literature.pojo;

import lombok.Data;
import org.gameboyz.hypertext.literature.pojo.po.UserPO;

/**
 * @author: Shiina18
 * @date: 2019/6/4 20:36
 * @description:
 */
@Data
public class User {
    Integer uid;
    String nickname;

    public User(UserPO userPO) {
        this.uid = userPO.getId();
        this.nickname = userPO.getUsername();
    }

    public User(Integer uid, String nickname) {
        this.uid = uid;
        this.nickname = nickname;
    }
}
