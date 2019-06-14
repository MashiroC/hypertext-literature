package org.gameboyz.hypertext.literature.pojo.dto;

import org.gameboyz.hypertext.literature.pojo.form.Choose;

/**
 * @author: Shiina18
 * @date: 2019/6/5 23:41
 * @description:
 */
public class SliceDTO {

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
