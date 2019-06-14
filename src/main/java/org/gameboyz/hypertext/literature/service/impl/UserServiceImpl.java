package org.gameboyz.hypertext.literature.service.impl;

import org.gameboyz.hypertext.literature.dao.UserDao;
import org.gameboyz.hypertext.literature.execptions.user.PasswordErrorException;
import org.gameboyz.hypertext.literature.execptions.user.UsernameExistException;
import org.gameboyz.hypertext.literature.execptions.user.UsernameNotFoundException;
import org.gameboyz.hypertext.literature.pojo.User;
import org.gameboyz.hypertext.literature.pojo.form.UserForm;
import org.gameboyz.hypertext.literature.pojo.po.UserPO;
import org.gameboyz.hypertext.literature.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: Shiina18
 * @date: 2019/6/7 10:35
 * @description:
 */
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User login(UserForm userForm) throws PasswordErrorException, UsernameNotFoundException {
        UserPO loginUser = userForm.toUserPO();
        UserPO userPO = userDao.findUserByUsernameAndPassword(loginUser);
        if (userPO == null) {
            userPO = userDao.findUserByUsername(loginUser.getUsername());
            if (userPO == null) {
                throw new UsernameNotFoundException();
            }
            throw new PasswordErrorException();
        }
        return new User(userPO);
    }

    @Override
    public User register(UserForm userForm) throws UsernameExistException {
        UserPO userPO = userForm.toUserPO();
        UserPO tmp = userDao.findUserByUsername(userPO.getUsername());
        if(tmp!=null){
            throw new UsernameExistException();
        }
        userDao.insertNew(userPO);
        return new User(userPO);
    }
}
