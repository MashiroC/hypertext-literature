package org.gameboyz.hypertext.literature.been;

import lombok.Getter;
import org.gameboyz.hypertext.literature.util.TimeUtil;

/**
 * @author: Shiina18
 * @date: 2019/6/4 20:44
 * @description:
 */
@Getter
public class ResponseEntity<T> {

    private static final int PARAM_ERROR_STATUS = 10001;
    private static final int SUCCESS_STATUS = 10000;

    protected int status;
    protected String timestamp;
    private T data;

    private ResponseEntity(int status) {
        this.status = status;
        this.timestamp = TimeUtil.nowTimeString();
    }

    private ResponseEntity(int status, T data) {
        this(status);
        this.data = data;
    }



    public static ResponseEntity ok() {
        return new ResponseEntity(SUCCESS_STATUS);
    }

    public static <T> ResponseEntity ok(T data) {
        ResponseEntity res = ResponseEntity.ok();
        res.data = data;
        return res;
    }

    public static ResponseEntity paramError() {
        ResponseEntity res = new ResponseEntity(PARAM_ERROR_STATUS);
        res.timestamp=TimeUtil.nowTimeString();
        return res;
    }



    public static ResponseEntity warn(int status, String message) {
        ResponseEntity responseEntity = new ResponseEntity(status);
        responseEntity.data = message;
        return responseEntity;
    }

    public static ResponseEntity paramError(String message) {
        ResponseEntity res = paramError();
        res.data=message;
        return res;
    }

    public static ResponseEntity nowHasNew() {
        return new ResponseEntity(10010,"no message new");
    }
}
