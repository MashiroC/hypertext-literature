package org.gameboyz.hypertext.literature.pojo.po;

import lombok.Data;
import org.gameboyz.hypertext.literature.pojo.Fiction;

/**
 * @author: Shiina18
 * @date: 2019/6/5 15:34
 * @description:
 */
@Data
public class FictionPO {
    private Integer id;
    private String name;
    private Integer authorId;
    private Integer state;
    private Integer prologueId;

    public FictionPO(){}

    public FictionPO(Fiction fiction){
        this.name=fiction.getName();
        this.authorId=fiction.getAuthorId();
    }

}
