package tech.xiying.h2demo.utils;

import io.minio.MinioClient;
import io.minio.errors.MinioException;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * minIO 存储
 *
 * @ClassName FileStorageUtil
 * @Description
 * @Author shanghao5
 * @Date 2020/12/14 15:43
 **/
public class FileStorageUtil {

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException, InvalidKeyException, XmlPullParserException {
        try {
            // 使用MinIO服务的URL，端口，Access key和Secret key创建一个MinioClient对象
            MinioClient minioClient = new MinioClient("http://192.168.175.128:9000",
                    "minioadmin", "minioadmin");

            // 检查存储桶是否已经存在
            boolean isExist = minioClient.bucketExists("file-test");
            if(isExist) {
                System.out.println("Bucket already exists.");
            } else {
                // 创建一个名为file-test的存储桶，用于存储照片的zip文件。
                minioClient.makeBucket("file-test");
            }

            // 使用putObject上传一个文件到存储桶中。
//            minioClient.putObject("file-test","token-1.7.0-SNAPSHOT.jar", "E:\\mq相关资料\\token-1.7.0-SNAPSHOT.jar");
//            System.out.println("token-1.7.0-SNAPSHOT.jar is successfully uploaded as token-1.7.0-SNAPSHOT.jar to `file-test` bucket.");
        } catch(MinioException e) {
            System.out.println("Error occurred: " + e);
        }
    }



}
