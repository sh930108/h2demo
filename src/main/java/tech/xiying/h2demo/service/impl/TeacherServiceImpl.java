package tech.xiying.h2demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.xiying.h2demo.dao.TeacherDao;
import tech.xiying.h2demo.entity.Teacher;
import tech.xiying.h2demo.service.TeacherService;

import java.util.List;

/**
 * @ClassName TeacherServiceImpl
 * @Description
 * @Author shanghao5
 * @Date 2020/12/5 14:09
 **/
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDao teacherDao;

    @Override
    public List<Teacher> getTeacherTeam() {
        List<Teacher> teacherList = teacherDao.findAllByOrderByCreatedTimeDesc();
        return teacherList;
    }
}
