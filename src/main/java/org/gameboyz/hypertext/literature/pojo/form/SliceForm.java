package org.gameboyz.hypertext.literature.pojo.form;

import lombok.Data;

/**
 * @author: Shiina18
 * @date: 2019/6/4 20:52
 * @description:
 */
@Data
public class SliceForm {

    Integer fictionId;

    String sliceTitle;
    /**
     * 后驱章节
     */
    Choose[] suffixes;

    /**
     * 前趋章节id
     */
    Choose[] prefixes;

    /**
     * 章节内容
     */
    String content;


}
