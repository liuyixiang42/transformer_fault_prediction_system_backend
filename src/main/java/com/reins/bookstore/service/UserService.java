package com.reins.bookstore.service;

import com.reins.bookstore.entity.Book;
import com.reins.bookstore.entity.UserAuth;

import java.util.Date;
import java.util.List;


public interface UserService {

    UserAuth checkUser(String username, String password);

    UserAuth exist(String username);

    UserAuth register(String username,String password,String mail);

    List<UserAuth>getAllUser();

    void deleteUserById(int userId);

    void changeBan(int userId);

    Boolean checkExist(String username);

    List<Book>count(int userId,Date date1,Date date2);
}
