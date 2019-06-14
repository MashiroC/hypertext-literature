package org.gameboyz.hypertext.literature.execptions.user;

import lombok.Getter;
import org.gameboyz.hypertext.literature.execptions.BaseException;

/**
 * @author: Shiina18
 * @date: 2019/6/5 11:31
 * @description:
 */
@Getter
public class PasswordErrorException extends BaseException {
    public static final int PASSWORD_ERROR_CODE=10101;
    public static final String PASSWORD_ERROR_MESSAGE="password error";

    public PasswordErrorException() {
        super(PASSWORD_ERROR_CODE,PASSWORD_ERROR_MESSAGE);
    }
}
