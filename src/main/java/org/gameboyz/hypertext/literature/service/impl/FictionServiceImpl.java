package org.gameboyz.hypertext.literature.service.impl;

import com.google.gson.Gson;
import org.gameboyz.hypertext.literature.dao.FictionDao;
import org.gameboyz.hypertext.literature.dao.SliceDao;
import org.gameboyz.hypertext.literature.dao.SliceRefDao;
import org.gameboyz.hypertext.literature.dao.UserDao;
import org.gameboyz.hypertext.literature.execptions.fiction.SliceNotFoundException;
import org.gameboyz.hypertext.literature.pojo.Edge;
import org.gameboyz.hypertext.literature.pojo.Fiction;
import org.gameboyz.hypertext.literature.pojo.Slice;
import org.gameboyz.hypertext.literature.pojo.form.Choose;
import org.gameboyz.hypertext.literature.pojo.form.SliceForm;
import org.gameboyz.hypertext.literature.pojo.po.FictionPO;
import org.gameboyz.hypertext.literature.pojo.po.SlicePO;
import org.gameboyz.hypertext.literature.pojo.po.SliceRefPO;
import org.gameboyz.hypertext.literature.pojo.po.UserPO;
import org.gameboyz.hypertext.literature.service.FictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author: Shiina18
 * @date: 2019/6/5 15:40
 * @description:
 */
@Component
public class FictionServiceImpl implements FictionService {

    @Autowired
    private FictionDao fictionDao;
    @Autowired
    private SliceRefDao sliceRefDao;
    @Autowired
    private SliceDao sliceDao;
    @Autowired
    private UserDao userDao;

    /**
     * 获得所有的小说
     *
     * @return 所有的小说
     */
    @Override
    public Set<Fiction> getAllFictions() {

        Set<FictionPO> fictionPOSet = fictionDao.findAll();

        Set<Fiction> resSet = new LinkedHashSet<>();
        for (FictionPO fictionPO : fictionPOSet) {
            UserPO userPO = userDao.findUserById(fictionPO.getAuthorId());
            Fiction fiction = new Fiction(fictionPO, userPO);
            resSet.add(fiction);
        }

        return resSet;

    }

    @Override
    public Set<Edge> getFictionSlice(Integer fictionId) {

        Set<SliceRefPO> sliceRefPOSet = sliceRefDao.findSliceByFictionId(fictionId);

        Set<Edge> resSet = new LinkedHashSet<>();
        for (SliceRefPO sliceRefPO : sliceRefPOSet) {
            UserPO userPO = userDao.findUserById(sliceRefPO.getAuthorId());
            Edge edge = new Edge(sliceRefPO, userPO);
            resSet.add(edge);
        }

        return resSet;
    }

    @Override
    public Slice findContent(Integer sliceId) throws SliceNotFoundException {
        SlicePO slicePO = sliceDao.findById(sliceId);

        if (slicePO == null) {
            throw new SliceNotFoundException();
        }

        return new Slice(slicePO);
    }

    @Override
    public void addSlice(SliceForm sliceForm, Integer uid) {
        //插入新的节点
        SlicePO slicePO = new SlicePO(sliceForm, uid, sliceForm.getFictionId());
        System.out.println(new Gson().toJson(slicePO));
        sliceDao.insertNew(slicePO);

        //插入边
        Choose[] prefixes = sliceForm.getPrefixes();
        Choose[] suffixes = sliceForm.getSuffixes();

        //前驱边
        for (Choose choose : prefixes) {
            SliceRefPO edge = new SliceRefPO(choose.getText(), slicePO.getAuthorId(), slicePO.getFictionId());
            edge.setFromId(choose.getToId());
            edge.setToId(slicePO.getId());
            sliceRefDao.insertNew(edge);
        }

        //后驱边
        for (Choose choose : suffixes) {
            SliceRefPO edge = new SliceRefPO(choose.getText(), slicePO.getAuthorId(), slicePO.getFictionId());
            edge.setFromId(slicePO.getId());
            edge.setToId(choose.getToId());
            sliceRefDao.insertNew(edge);
        }

    }

    @Override
    public void addFiction(Fiction fiction, String content) {

        //插入小说
        FictionPO fictionPO = new FictionPO(fiction);
        fictionDao.insertNew(fictionPO);

        //插入序章
        SlicePO slicePO = new SlicePO(fiction.getAuthorId(), fictionPO.getId(), fiction.getName(), content);
        sliceDao.insertNew(slicePO);

        //加入小说的序章id
        fictionDao.addPrologueId(fictionPO.getId(), slicePO.getId());

    }


}
