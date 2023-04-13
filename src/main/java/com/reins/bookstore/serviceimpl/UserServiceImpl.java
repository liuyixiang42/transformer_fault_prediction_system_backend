package com.reins.bookstore.serviceimpl;

import com.reins.bookstore.dao.UserDao;
import com.reins.bookstore.entity.Book;
import com.reins.bookstore.entity.UserAuth;
import com.reins.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description the implement of user service
 * @Author thunderBoy
 * @Date 2019/11/7 13:16
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserAuth checkUser(String username, String password){
        return userDao.checkUser(username,password);
    }
    public UserAuth exist(String username){
        return userDao.exist(username);
    }

    public UserAuth register(String username,String password,String mail){
        return userDao.register(username,password,mail);
    }
    public List<UserAuth> getAllUser(){
        return userDao.getAll();
    }

    public void deleteUserById(int userId){
        userDao.deleteOne(userId);
    }

    public void changeBan(int userId){
        userDao.changeBan(userId);
    }

    public Boolean checkExist(String username){
        return userDao.checkExist(username);
    }

    public List<Book>count(int userId,Date date1, Date date2){return userDao.count(userId,date1,date2);}
}
