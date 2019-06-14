package org.gameboyz.hypertext.literature.pojo.po;

import lombok.Data;
import org.gameboyz.hypertext.literature.pojo.Slice;
import org.gameboyz.hypertext.literature.pojo.form.SliceForm;

/**
 * @author: Shiina18
 * @date: 2019/6/5 15:38
 * @description:
 */
@Data
public class SlicePO {
    private Integer id;
    private Integer authorId;
    private Integer fictionId;
    private String title;
    private String text;

    public SlicePO(){}

    public SlicePO(SliceForm sliceForm, Integer uid, Integer fictionId) {
        this.authorId=uid;
        this.fictionId=fictionId;
        this.title=sliceForm.getSliceTitle();
        this.text=sliceForm.getContent();
    }

    public SlicePO(Integer authorId,Integer fictionId,String title,String text){
        this.authorId=authorId;
        this.fictionId=fictionId;
        this.title=title;
        this.text=text;
    }
}
