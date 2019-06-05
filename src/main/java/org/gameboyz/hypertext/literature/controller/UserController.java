package org.gameboyz.hypertext.literature.controller;

import org.gameboyz.hypertext.literature.been.ResponseEntity;
import org.gameboyz.hypertext.literature.been.jwt.Jwt;
import org.gameboyz.hypertext.literature.been.jwt.JwtHelper;
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
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtHelper<User> jwtHelper;

    @PostMapping("/login")
    public ResponseEntity login(@Valid @RequestBody UserForm userForm) {
        User user = userService.login(userForm);
        Jwt jwt = jwtHelper.createJwt(user);
        return ResponseEntity.ok(jwt);

    }

    @PostMapping("/register")
    public ResponseEntity register(@Valid @RequestBody UserForm userForm) {
        User user = userService.register(userForm);
        Jwt jwt = jwtHelper.createJwt(user);
        return ResponseEntity.ok(jwt);
    }

}
