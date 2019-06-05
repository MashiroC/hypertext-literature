package org.gameboyz.hypertext.literature.execptions.fiction;

import org.gameboyz.hypertext.literature.execptions.BaseException;

/**
 * @author: Shiina18
 * @date: 2019/6/5 16:14
 * @description:
 */
public class SliceNotFoundException extends BaseException {
    public static final int SLICE_NOT_FOUND_ERROR_CODE =10202;
    public static final String SLICE_NOT_FOUND_ERROR_MESSAGE ="slice not found";

    public SliceNotFoundException() {
        super(SLICE_NOT_FOUND_ERROR_CODE, SLICE_NOT_FOUND_ERROR_MESSAGE);
    }
}
