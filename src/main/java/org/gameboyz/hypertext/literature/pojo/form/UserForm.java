package org.gameboyz.hypertext.literature.pojo.form;

import lombok.Data;
import org.gameboyz.hypertext.literature.pojo.po.UserPO;
import org.gameboyz.hypertext.literature.util.EncryptUtil;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author: Shiina18
 * @date: 2019/6/5 11:19
 * @description:
 */
@Data
public class UserForm {

    @NotNull
    @Size(max = 15)
    String username;

    @NotNull
    @Size(max = 20)
    String password;

    public UserPO toUserPO() {
        UserPO userPO = new UserPO();
        userPO.setUsername(this.username);
        userPO.setPassword(EncryptUtil.sha256(this.password));
        return userPO;
    }
}
