package org.gameboyz.hypertext.literature.pojo;

import lombok.Data;
import org.gameboyz.hypertext.literature.pojo.form.FictionForm;
import org.gameboyz.hypertext.literature.pojo.form.SliceForm;
import org.gameboyz.hypertext.literature.pojo.po.SliceRefPO;
import org.gameboyz.hypertext.literature.pojo.po.UserPO;

/**
 * @author: Shiina18
 * @date: 2019/6/4 20:30
 * @description:
 */
@Data
public class Slice {
    private Integer fictionId;
    private String title;
    private String author;
    private String choose;

    public Slice(Integer fictionId, SliceForm sliceForm, User user) {
        this.fictionId = fictionId;
        this.title = sliceForm.getSliceTitle();
        this.author = user.getNickname();
        this.prefixIds = sliceForm.getPrefixes();
        this.suffixIds = sliceForm.getSuffixes();
    }

    public Slice(FictionForm fictionForm, User user) {
        this.title = fictionForm.getName();
        this.author = user.getNickname();
    }

    public Slice(SliceRefPO sliceRefPO, UserPO userPO) {

    }

}
