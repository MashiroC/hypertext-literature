package org.gameboyz.hypertext.literature.pojo;

import lombok.Data;
import org.gameboyz.hypertext.literature.pojo.po.SlicePO;

/**
 * @author: Shiina18
 * @date: 2019/6/5 16:06
 * @description:
 */
@Data
public class Slice {

    private Integer id;
    private String title;
    private String text;

    public Slice(SlicePO slicePO) {
        this.id = slicePO.getId();
        this.title=slicePO.getTitle();
        this.text = slicePO.getText();
    }

}
