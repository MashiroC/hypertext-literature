package org.gameboyz.hypertext.literature.pojo.form;

import lombok.Data;

/**
 * @author: Shiina18
 * @date: 2019/6/4 20:52
 * @description:
 */
@Data
public class SliceForm {

    String sliceTitle;
    /**
     * 后驱章节id
     */
    Integer[] suffixes;

    /**
     * 前趋章节id
     */
    Integer[] prefixes;

    /**
     * 章节内容
     */
    String content;

    /**
     * 选项名
     */
    String[] choose;

}
