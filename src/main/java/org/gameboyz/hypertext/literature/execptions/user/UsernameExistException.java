package org.gameboyz.hypertext.literature.execptions.user;

import org.gameboyz.hypertext.literature.execptions.BaseException;

/**
 * @author: Shiina18
 * @date: 2019/6/7 10:53
 * @description:
 */
public class UsernameExistException extends BaseException {

    public static final int USERNAME_EXIST_ERROR_CODE = 10103;
    public static final String USERNAME_EXIST_ERROR_MESSAGE = "username exist";

    public UsernameExistException() {
        super(USERNAME_EXIST_ERROR_CODE, USERNAME_EXIST_ERROR_MESSAGE);
    }

}
