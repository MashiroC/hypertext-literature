package org.gameboyz.hypertext.literature.pojo;

import lombok.Data;
import org.gameboyz.hypertext.literature.pojo.form.Choose;
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
public class Edge {

    private Integer id;
    private Integer fictionId;
    private Integer authorId;
    private String author;
    private String choose;
    private Integer fromId;
    private Integer toId;

    public Edge() {
    }


    /**
     * 添加章节时创建边调用
     *
     * @param sliceForm
     * @param user
     */
    public static Edge[] createEdges(SliceForm sliceForm, User user) {
        Choose[] prefixes = sliceForm.getPrefixes();
        Choose[] suffixes = sliceForm.getSuffixes();
        Edge[] edges = new Edge[prefixes.length + suffixes.length];
        for (int i = 0; i < prefixes.length; i++) {
//            edges[i] = new Edge(fictionId, sliceForm.getChoose(), prefixes[i].getToId(), -1);
        }
        return null;
    }

    public Edge(FictionForm fictionForm, User user) {
//        this.title = fictionForm.getName();
        this.author = user.getNickname();
    }

    /**
     * 查小说的章节地图的时候获取所有边
     * @param sliceRefPO
     * @param userPO
     */
    public Edge(SliceRefPO sliceRefPO, UserPO userPO) {
        this.choose=sliceRefPO.getChoose();
        this.fictionId=sliceRefPO.getFictionId();
        this.author=userPO.getUsername();
        this.authorId=userPO.getId();
        this.fromId=sliceRefPO.getFromId();
        this.toId=sliceRefPO.getToId();
        this.id=sliceRefPO.getId();
    }

}
