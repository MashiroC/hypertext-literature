package org.gameboyz.hypertext.literature.controller;

import lombok.extern.slf4j.Slf4j;
import org.gameboyz.hypertext.literature.been.ResponseEntity;
import org.gameboyz.hypertext.literature.been.jwt.Jwt;
import org.gameboyz.hypertext.literature.been.jwt.JwtHelper;
import org.gameboyz.hypertext.literature.execptions.user.PasswordErrorException;
import org.gameboyz.hypertext.literature.execptions.user.UsernameExistException;
import org.gameboyz.hypertext.literature.execptions.user.UsernameNotFoundException;
import org.gameboyz.hypertext.literature.pojo.User;
import org.gameboyz.hypertext.literature.pojo.form.UserForm;
import org.gameboyz.hypertext.literature.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author: Shiina18
 * @date: 2019/6/4 20:43
 * @description:
 */
@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtHelper<User> jwtHelper;

    @PostMapping("/login")
    public ResponseEntity login(@Valid @RequestBody UserForm userForm) throws PasswordErrorException, UsernameNotFoundException {
        log.info("user:[{}]正在登陆",userForm.getUsername());
        User user = userService.login(userForm);
        Jwt jwt = jwtHelper.createJwt(user);
        return ResponseEntity.ok(jwt.toString());

    }

    @PostMapping("/register")
    public ResponseEntity register(@Valid @RequestBody UserForm userForm) throws UsernameExistException {
        User user = userService.register(userForm);
        Jwt jwt = jwtHelper.createJwt(user);
        return ResponseEntity.ok(jwt.toString());
    }

}
