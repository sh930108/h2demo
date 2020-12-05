package tech.xiying.h2demo.utils;

import com.google.gson.Gson;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName RestTempleteTest
 * @Description
 * @Author shanghao5
 * @Date 2020/12/5 14:43
 **/
public class RestTempleteTest {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void testHttpRequest(){
        Gson gson = new Gson();

        /**  接口调用 *******/
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Token", "=========================");

        HttpEntity<String> entity = new HttpEntity<String>(gson.toJson(""), headers);
        try {
            ResponseEntity<String> responseEntity = restTemplate.exchange("url", HttpMethod.POST, entity, String.class);
        }catch(Exception e){
            e.printStackTrace();
        }
    }


}
