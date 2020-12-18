package tech.xiying.h2demo.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisClusterNode;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;

/**
 * @ClassName RedisConfig
 * @Description
 * @Author shanghao5
 * @Date 2020/12/18 10:41
 **/
//@Configuration
public class RedisConfig {

    @Autowired
    private RedisProperties redisProperties;

    @Bean
    JedisConnectionFactory jedisConnectionFactory(){
        JedisClientConfiguration.JedisClientConfigurationBuilder jedisClientConfiguration =
                JedisClientConfiguration.builder();
        jedisClientConfiguration.clientName("test-redis-client");
        jedisClientConfiguration.connectTimeout(redisProperties.getTimeout());
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxWaitMillis(redisProperties.getJedis().getPool().getMaxWait().toMillis());
        poolConfig.setMaxTotal(redisProperties.getJedis().getPool().getMaxActive());
        poolConfig.setMaxIdle(redisProperties.getJedis().getPool().getMaxIdle());
        poolConfig.setMinIdle(redisProperties.getJedis().getPool().getMinIdle());
        poolConfig.setBlockWhenExhausted(false);
        poolConfig.setTestOnBorrow(true);
        jedisClientConfiguration.usePooling().poolConfig(poolConfig);

        RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration();
        List<String> nodes = redisProperties.getCluster().getNodes();
        List<RedisNode> redisNodes = Lists.newArrayList();
        nodes.forEach(node->{
            List<String> stringList = Splitter.on(":").splitToList(node);
            RedisClusterNode redisClusterNode = new RedisClusterNode(stringList.get(0),Integer.valueOf(stringList.get(1)));
            redisNodes.add(redisClusterNode);
        });
        redisClusterConfiguration.setMaxRedirects(2);
        redisClusterConfiguration.setClusterNodes(redisNodes);
        redisClusterConfiguration.setPassword(redisProperties.getPassword());
        JedisConnectionFactory factory =
                new JedisConnectionFactory(redisClusterConfiguration,jedisClientConfiguration.build());
        return factory;
    }

    /**
     * retemplate相关配置
     * @param jedisConnectionFactory
     * @return
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory jedisConnectionFactory) {

        RedisTemplate<String, Object> template = new RedisTemplate<>();
        // 配置连接工厂
        template.setConnectionFactory(jedisConnectionFactory);

        //使用Jackson2JsonRedisSerializer来序列化和反序列化redis的value值（默认使用JDK的序列化方式）
        Jackson2JsonRedisSerializer jacksonSeial = new Jackson2JsonRedisSerializer(Object.class);

        ObjectMapper om = new ObjectMapper();
        // 指定要序列化的域，field,get和set,以及修饰符范围，ANY是都有包括private和public
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        // 指定序列化输入的类型，类必须是非final修饰的，final修饰的类，比如String,Integer等会跑出异常
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jacksonSeial.setObjectMapper(om);

        // 值采用json序列化
        template.setValueSerializer(jacksonSeial);
        //使用StringRedisSerializer来序列化和反序列化redis的key值
        template.setKeySerializer(new StringRedisSerializer());

        // 设置hash key 和value序列化模式
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(jacksonSeial);
        template.afterPropertiesSet();

        return template;
    }

}
