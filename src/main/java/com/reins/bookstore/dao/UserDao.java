package com.reins.bookstore.dao;

import com.reins.bookstore.entity.Book;
import com.reins.bookstore.entity.UserAuth;

import java.util.Date;
import java.util.List;

public interface UserDao {

    UserAuth checkUser(String username, String password);

    UserAuth register(String username, String password,String mail);

    UserAuth exist(String username);

    List<UserAuth> getAll();

    void deleteOne(int userId);

    void changeBan(int userId);

    Boolean checkExist(String username);

    List<Book> count(int userId,Date date1, Date date2);
}
