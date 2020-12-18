package tech.xiying.h2demo.service;

import com.google.gson.Gson;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.JedisCluster;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName RedisTest
 * @Description
 * @Author shanghao5
 * @Date 2020/12/18 10:35
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RedisTest {

//    @Autowired
//    private RedisTemplate redisTemplate;

    @Autowired
    private JedisCluster jedisCluster;

    @Test
    public void testAddUser(){
//        List<String> helloList = Arrays.asList("1","2");
//
//        redisTemplate.convertAndSend("hello",helloList);
//        List<String> result = Lists.newArrayList();
//        result = (List<String>) redisTemplate.boundValueOps("hello").get();
//        System.out.println(new Gson().toJson(result));


    }

    @Test
    public void testRedis(){
        jedisCluster.set("userName", "zhangsan");
        String userName = jedisCluster.get("userName");
        System.out.println("userName======" + userName);
    }

}
