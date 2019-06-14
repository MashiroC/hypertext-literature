package org.gameboyz.hypertext.literature.execptions.user;

import org.gameboyz.hypertext.literature.execptions.BaseException;

/**
 * @author: Shiina18
 * @date: 2019/6/7 10:50
 * @description:
 */
public class UsernameNotFoundException extends BaseException {
    public static final int USERNAME_NOT_FOUND_ERROR_CODE =10102;
    public static final String USERNAME_NOT_FOUND_ERROR_MESSAGE="username not found";

    public UsernameNotFoundException() {
        super(USERNAME_NOT_FOUND_ERROR_CODE,USERNAME_NOT_FOUND_ERROR_MESSAGE);
    }
}
