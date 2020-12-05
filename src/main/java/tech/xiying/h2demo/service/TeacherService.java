package tech.xiying.h2demo.service;

import tech.xiying.h2demo.entity.Teacher;

import java.util.List;

/**
 * @interface TeacherService
 * @Description
 * @Author shanghao5
 * @Date 2020/12/5 14:09
 **/
public interface TeacherService {

    /**
     * 获取老师及所有学员
     * @return
     */
    List<Teacher> getTeacherTeam();

}
