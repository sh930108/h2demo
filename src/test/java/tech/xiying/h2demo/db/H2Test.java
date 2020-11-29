package tech.xiying.h2demo.db;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tech.xiying.h2demo.dao.UserDao;
import tech.xiying.h2demo.entity.User;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class H2Test {

    @Autowired
    private UserDao userDao;

    @Test
    public void testGetUserByName(){
        List<User> userList = userDao.findAll();
        System.out.println(userList.size());
    }

}
