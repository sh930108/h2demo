package tech.xiying.h2demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.xiying.h2demo.dao.UserDao;
import tech.xiying.h2demo.entity.User;
import tech.xiying.h2demo.service.UserService;

import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description
 * @Author shanghao5
 * @Date 2020/12/5 14:06
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAllUser() {


        return null;
    }
}
