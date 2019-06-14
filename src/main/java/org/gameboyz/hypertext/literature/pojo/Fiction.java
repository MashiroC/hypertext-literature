package org.gameboyz.hypertext.literature.pojo;

import lombok.Data;
import org.gameboyz.hypertext.literature.pojo.form.FictionForm;
import org.gameboyz.hypertext.literature.pojo.po.FictionPO;
import org.gameboyz.hypertext.literature.pojo.po.UserPO;

/**
 * @author: Shiina18
 * @date: 2019/6/4 20:24
 * @description:
 */
@Data
public class Fiction {

    private Integer id;
    private String name;
    private Integer authorId;
    private String author;
    private Integer prologurId;

    public Fiction() {
    }

    public Fiction(FictionPO fictionPO, UserPO userPO) {
        this.id = fictionPO.getId();
        this.name = fictionPO.getName();
        this.authorId = userPO.getId();
        this.author = userPO.getUsername();
        this.prologurId=fictionPO.getPrologueId();
    }

    public Fiction(FictionForm fictionForm, User user) {
        this.name = fictionForm.getName();
        this.author = user.getNickname();
        this.authorId = user.getUid();
    }
}
