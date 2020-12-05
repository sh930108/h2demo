package tech.xiying.h2demo.service;

import tech.xiying.h2demo.entity.User;

import java.util.List;

/**
 * @interface UserService
 * @Description
 * @Author shanghao5
 * @Date 2020/12/5 14:06
 **/
public interface UserService {

    public List<User> findAllUser();

}
