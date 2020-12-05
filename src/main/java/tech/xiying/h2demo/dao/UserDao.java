package tech.xiying.h2demo.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import tech.xiying.h2demo.entity.User;

/**
 * @author shanghao5
 */
public interface UserDao extends PagingAndSortingRepository<User,Long> {


}
