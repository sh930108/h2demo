package tech.xiying.h2demo.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import tech.xiying.h2demo.entity.Teacher;

import java.util.List;

/**
 * @ClassName TeacherDao
 * @Description
 * @Author shanghao5
 * @Date 2020/12/5 14:08
 **/
public interface TeacherDao extends PagingAndSortingRepository<Teacher,Long> {

    /**
     *
     * @return
     */
    List<Teacher> findAllByOrderByCreatedTimeDesc();

}
