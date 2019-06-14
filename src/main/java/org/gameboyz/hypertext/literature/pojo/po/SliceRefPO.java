package org.gameboyz.hypertext.literature.pojo.po;

import lombok.Data;

/**
 * @author: Shiina18
 * @date: 2019/6/5 15:36
 * @description:
 */
@Data
public class SliceRefPO {
    private Integer id;
    private String choose;
    private Integer authorId;
    private Integer fromId;
    private Integer toId;
    private Integer fictionId;
    private Integer state;

    public SliceRefPO(){}

    public SliceRefPO(String choose,Integer authorId,Integer fictionId){
        this.choose=choose;
        this.authorId=authorId;
        this.fictionId=fictionId;
    }
}
