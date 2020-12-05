package tech.xiying.h2demo.init;

import org.assertj.core.util.Lists;
import tech.xiying.h2demo.entity.Teacher;
import tech.xiying.h2demo.entity.User;

import java.util.List;

/**
 * @ClassName DataInit
 * @Description
 * @Author shanghao5
 * @Date 2020/12/5 14:17
 **/
public class DataInit {

    public static List<User> getDefaultUserList(){
        Teacher teacher = Teacher.builder()
                .name("小明老师")
                .phone("13515131415")
                .build();
        List<User> userList= Lists.newArrayList();
        User user1 = User.builder()
                .name("小黑")
                .phone("13515131411")
                .teacher(teacher)
                .build();
        User user2 = User.builder()
                .name("小王")
                .phone("13515131412")
                .teacher(teacher)
                .build();
        userList.add(user1);
        userList.add(user2);
        return userList;
    }


}
