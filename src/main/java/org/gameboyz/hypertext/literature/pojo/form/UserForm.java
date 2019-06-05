package org.gameboyz.hypertext.literature.pojo.form;

import lombok.Data;

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

}
