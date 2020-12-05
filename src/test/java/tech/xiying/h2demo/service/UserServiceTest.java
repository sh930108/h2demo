package tech.xiying.h2demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tech.xiying.h2demo.dao.UserDao;
import tech.xiying.h2demo.entity.User;
import tech.xiying.h2demo.init.DataInit;

import java.util.List;

/**
 * @ClassName UserServiceTest
 * @Description
 * @Author shanghao5
 * @Date 2020/12/5 14:22
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserServiceTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void testAddUser(){
        List<User> defaultUserList = DataInit.getDefaultUserList();
        userDao.saveAll(defaultUserList);
    }
}
