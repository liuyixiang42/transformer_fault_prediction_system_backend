package com.reins.bookstore.daoimpl;

import com.reins.bookstore.constant.Constant;
import com.reins.bookstore.dao.UserDao;
import com.reins.bookstore.entity.*;
import com.reins.bookstore.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @ClassName UserDaoImpl
 * @Description the implement of user dao
 * @Author thunderBoy
 * @Date 2019/11/7 13:19
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    UserAuthRepository userAuthRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderBookRepository orderBookRepository;
    @Autowired
    BookRepository bookRepository;

    @Override
    public UserAuth checkUser(String username, String password){

        return userAuthRepository.checkUser(username,password);
    }
    public UserAuth register(String username, String password,String mail){
        UserAuth newUserAuth=new UserAuth();
        newUserAuth.setUsername(username);
        newUserAuth.setPassword(password);
        newUserAuth.setMail(mail);
        newUserAuth.setUserType(0);
        newUserAuth.setBan(0);
        return userAuthRepository.save(newUserAuth);
    }
    public UserAuth exist(String username){
        return userAuthRepository.findByUsername(username);
    }

    public List<UserAuth> getAll(){
        return userAuthRepository.findByUserType(0);
    }

    public void deleteOne(int userId){
        userAuthRepository.deleteById(userId);
    }
    public void changeBan(int userId){
        Optional<UserAuth> userAuth=userAuthRepository.findById(userId);
        if(userAuth.get().getBan()==1)userAuth.get().setBan(0);
        else userAuth.get().setBan(1);
        userAuthRepository.save(userAuth.get());
    }
    public Boolean checkExist(String username){
        if(userAuthRepository.findByUsername(username)==null){
            return false;
        }
        return true;
    }
    public List<Book> count(int userId, Date date1, Date date2){
        List<OrderForm>orderForms=orderRepository.findAllByUserAuthId(userId);
        List<Book>theBooks=new ArrayList<>();
        for(OrderForm a:orderForms){
            if((a.getDate().compareTo(date1)>=0)&&(a.getDate().compareTo(date2)<=0)){
                List<OrderBook>orderBooks=orderBookRepository.getAllByOrderId(a.getOrderId());
                for(OrderBook o:orderBooks){
                    theBooks.add(bookRepository.findById(o.getBookId()).get());
                }
            }
        }
        return theBooks;
    }
}
