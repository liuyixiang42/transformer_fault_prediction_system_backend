package com.reins.bookstore.serviceimpl;

import com.reins.bookstore.dao.BookDao;
import com.reins.bookstore.dao.OrderDao;
import com.reins.bookstore.entity.Book;
import com.reins.bookstore.entity.OrderForm;
import com.reins.bookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private BookDao bookDao;
    public void addOrder(int userAuthId,BigDecimal totalPrice, String receiver, String tel, String address, List<Integer> bookId){
        List<Book>books=new ArrayList<>();
        for(int i=0;i<bookId.size();i++){
            books.add(bookDao.findOne(bookId.get(i)));
        }
        orderDao.addOne(userAuthId,totalPrice, receiver,  tel,  address, books);
    }
    public List<OrderForm>getAll(int userAuthId){
        return orderDao.findAll(userAuthId);
    }
    public List<OrderForm>getAll2() {
        return orderDao.findAll2();
    }
}
