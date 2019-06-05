package org.gameboyz.hypertext.literature.execptions;

import lombok.Getter;

/**
 * @author: Shiina18
 * @date: 2019/6/5 11:35
 * @description:
 */
@Getter
public class BaseException extends Exception {


    public static final int USER_EXIST_ERROR_CODE=10102;
    public static final String USER_EXIST_ERROR_MESSAGE="username exist";

    public static final int USER_NOT_EXIST_ERROR_CODE=10103;
    public static final String USER_NOT_EXIST_ERROR_MESSAGE="username not exist";

    protected int errCode;
    protected String errMessage;

    public BaseException() {
    }

    public BaseException(int errCode, String errMessage) {
        this.errCode = errCode;
        this.errMessage = errMessage;
    }
}
