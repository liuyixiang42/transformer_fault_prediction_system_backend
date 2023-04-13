package com.reins.bookstore.controller;

import com.reins.bookstore.constant.Constant;
import com.reins.bookstore.entity.Book;
import com.reins.bookstore.entity.UserAuth;
import com.reins.bookstore.service.UserService;
import com.reins.bookstore.utils.sessionutils.SessionUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ClassName UserController
 * @Description the controller of user
 * @Author thunderBoy
 * @Date 2019/11/7 13:47
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/checkUser")
    public UserAuth checkUser(@RequestParam("username") String username,@RequestParam("password") String password){
        return userService.checkUser(username, password);
    }

    @RequestMapping("/getUsers")
    public List<UserAuth> getAllUsers(){
        return userService.getAllUser();
    }

    @RequestMapping("/deleteUser")
    public List<UserAuth> deleteUser(@RequestParam("userId")int userId ){
        userService.deleteUserById(userId);
        return userService.getAllUser();
    }
    @RequestMapping("/changeBan")
    public void changeBan(@RequestParam("userId")int userId){
        System.out.println(userId);
        userService.changeBan(userId);
    }
    @RequestMapping("/checkExist")
    public Boolean checkExist(@RequestParam("username") String username){
        return userService.checkExist(username);
    }
    @RequestMapping("/count")
    public List<Book> count(@RequestParam("userId")int userId, @RequestParam("date1") Date date1, @RequestParam("date2") Date date2){
        System.out.println(userService.count(userId,date1,date2));
        return userService.count(userId,date1,date2);
    }
}
