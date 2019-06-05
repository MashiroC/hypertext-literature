package org.gameboyz.hypertext.literature.pojo;

import lombok.Data;
import org.gameboyz.hypertext.literature.pojo.po.SlicePO;

/**
 * @author: Shiina18
 * @date: 2019/6/5 16:06
 * @description:
 */
@Data
public class Content {

    private String text;

    public Content(SlicePO slicePO) {
        this.text = slicePO.getText();
    }
}
