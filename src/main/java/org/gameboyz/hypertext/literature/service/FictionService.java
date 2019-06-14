package org.gameboyz.hypertext.literature.service;

import org.gameboyz.hypertext.literature.execptions.fiction.SliceNotFoundException;
import org.gameboyz.hypertext.literature.pojo.Slice;
import org.gameboyz.hypertext.literature.pojo.Fiction;
import org.gameboyz.hypertext.literature.pojo.Edge;
import org.gameboyz.hypertext.literature.pojo.form.SliceForm;

import java.util.Set;

/**
 * @author: Shiina18
 * @date: 2019/6/4 20:32
 * @description:
 */
public interface FictionService {

    Set<Fiction> getAllFictions();

    Set<Edge> getFictionSlice(Integer fictionId);

    Slice findContent(Integer sliceId) throws SliceNotFoundException;

    void addFiction(Fiction fiction, String edge);

    void addSlice(SliceForm sliceForm, Integer uid);
}
