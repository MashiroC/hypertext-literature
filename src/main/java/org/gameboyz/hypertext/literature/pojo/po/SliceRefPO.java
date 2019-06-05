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
    private String title;
    private Integer authorId;
    private Integer contentId;
    private Integer prefixId;
    private Integer suffixId;
    private Integer state;
}
