package org.gameboyz.hypertext.literature.service;

import org.gameboyz.hypertext.literature.execptions.fiction.SliceNotFoundException;
import org.gameboyz.hypertext.literature.pojo.Content;
import org.gameboyz.hypertext.literature.pojo.Fiction;
import org.gameboyz.hypertext.literature.pojo.Slice;

import java.util.Set;

/**
 * @author: Shiina18
 * @date: 2019/6/4 20:32
 * @description:
 */
public interface FictionService {

    Set<Fiction> getAllFictions();

    Set<Slice> getFictionSlice(Integer fictionId);

    Content findContent(Integer sliceId) throws SliceNotFoundException;

    void addSlice(Slice slice);

    void addArticle(Fiction fiction, Slice slice);

}
