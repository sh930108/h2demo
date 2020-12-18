package tech.xiying.h2demo.config;

import io.minio.MinioClient;
import io.minio.errors.InvalidEndpointException;
import io.minio.errors.InvalidPortException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MinIoConfig
 * @Description
 * @Author shanghao5
 * @Date 2020/12/14 16:07
 **/
@Configuration
@ConditionalOnProperty(value = "minio.url")
public class MinIoConfig {

    @Value("${minio.url}")
    private String url;
    @Value("${minio.username}")
    private String username;
    @Value("${minio.password}")
    private String password;

    @Bean
    public MinioClient initMinIoClient() throws InvalidPortException, InvalidEndpointException {
        System.out.println("minIO 初始化");
        MinioClient minioClient =new MinioClient(url,username, password);
        return minioClient;
    }

}
