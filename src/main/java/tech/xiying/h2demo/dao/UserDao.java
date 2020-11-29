package tech.xiying.h2demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.xiying.h2demo.entity.User;

public interface UserDao extends JpaRepository<User,Long> {



}
