package tech.xiying.h2demo.controller;

import io.minio.MinioClient;
import io.minio.Result;
import io.minio.messages.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName MinIoDemoController
 * @Description
 * @Author shanghao5
 * @Date 2020/12/14 16:22
 **/
@RestController
public class MinIoDemoController {

//    @Autowired
//    private MinioClient minioClient;
//
//    @PostMapping(value = "/minio/add-bucket")
//    public void addBucket(HttpServletResponse response,String bucket){
//        try{
//            // 检查存储桶是否已经存在
//            boolean isExist = minioClient.bucketExists(bucket);
//            if(isExist) {
//                System.out.println("Bucket already exists.");
//            } else {
//                // 创建一个名为file-test的存储桶，用于存储照片的zip文件。
//                minioClient.makeBucket(bucket);
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//    }
//
//    @GetMapping(value = "/minio/get-objects")
//    public void getObjects(HttpServletResponse response,String bucket){
//        try {
//            // 检查'mybucket'是否存在。
//            boolean found = minioClient.bucketExists(bucket);
//            if (found) {
//                // 列出'my-bucketname'里的对象
//                Iterable<Result<Item>> myObjects = minioClient.listObjects(bucket);
//                for (Result<Item> result : myObjects) {
//                    Item item = result.get();
//                    System.out.println(item.lastModified() + ", " + item.size() + ", " + item.objectName());
//                }
//            } else {
//                System.out.println("mybucket does not exist");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @PostMapping(value = "/minio/put-object")
//    public void addMqCluster(HttpServletResponse response,String bucket,String objectName,
//                             String fileNamePath){
//        try {
//            minioClient.putObject(bucket,objectName, fileNamePath);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
}
