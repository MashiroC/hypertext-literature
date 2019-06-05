package org.gameboyz.hypertext.literature.service.impl;

import org.gameboyz.hypertext.literature.dao.ContentDao;
import org.gameboyz.hypertext.literature.dao.FictionDao;
import org.gameboyz.hypertext.literature.dao.SliceDao;
import org.gameboyz.hypertext.literature.dao.UserDao;
import org.gameboyz.hypertext.literature.execptions.fiction.SliceNotFoundException;
import org.gameboyz.hypertext.literature.pojo.Content;
import org.gameboyz.hypertext.literature.pojo.Fiction;
import org.gameboyz.hypertext.literature.pojo.Slice;
import org.gameboyz.hypertext.literature.pojo.po.SlicePO;
import org.gameboyz.hypertext.literature.pojo.po.FictionPO;
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
    private SliceDao sliceDao;
    @Autowired
    private ContentDao contentDao;

    @Autowired
    private UserDao userDao;

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
    public Set<Slice> getFictionSlice(Integer fictionId) {

        Set<SliceRefPO> sliceRefPOSet = sliceDao.findSliceByFictionId(fictionId);

        Set<Slice> resSet = new LinkedHashSet<>();
        for (SliceRefPO sliceRefPO : sliceRefPOSet) {
            UserPO userPO = userDao.findUserById(sliceRefPO.getAuthorId());
            Slice slice = new Slice(sliceRefPO, userPO);
            resSet.add(slice);
        }

        return resSet;
    }

    @Override
    public Content findContent(Integer sliceId) throws SliceNotFoundException {
        SliceRefPO sliceRefPO = sliceDao.findSliceById(sliceId);

        if (sliceRefPO == null) {
            throw new SliceNotFoundException();
        }

        SlicePO slicePO = contentDao.findById(sliceRefPO.getContentId());

        return new Content(slicePO);
    }

    @Override
    public void addSlice(Slice slice) {

    }

    @Override
    public void addArticle(Fiction fiction, Slice slice) {

    }


}
