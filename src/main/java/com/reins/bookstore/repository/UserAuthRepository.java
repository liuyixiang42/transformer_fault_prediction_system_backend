package com.reins.bookstore.repository;

import com.reins.bookstore.entity.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserAuthRepository extends JpaRepository<UserAuth,Integer>{

    @Query(value = "from UserAuth where username = :username and password = :password")
    UserAuth checkUser(@Param("username") String username, @Param("password") String password);

    UserAuth findByUsername(String username);

    List<UserAuth> findByUserType(int userType);
}
