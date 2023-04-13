package com.reins.bookstore.daoimpl;

import com.reins.bookstore.dao.OrderBookDao;
import com.reins.bookstore.dao.OrderDao;
import com.reins.bookstore.entity.Book;
import com.reins.bookstore.entity.OrderBook;
import com.reins.bookstore.entity.OrderForm;
import com.reins.bookstore.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderBookDao orderBookDao;
    public void addOne(int userAuthId,BigDecimal totalPrice, String receiver, String tel, String address, List<Book> books){
        OrderForm newOrderForm=new OrderForm();
        newOrderForm.setUserAuthId(userAuthId);
        newOrderForm.setTotalPrice(totalPrice);
        newOrderForm.setReceiver(receiver);
        newOrderForm.setTel(tel);
        newOrderForm.setAddress(address);
        Date date = new Date();
        newOrderForm.setDate(date);
        OrderForm orderForm=orderRepository.save(newOrderForm);
        int orderId=orderForm.getOrderId();
        for(int i=0;i<books.size();i++){
            OrderBook orderBook=orderBookDao.addOrderBook(orderId, books.get(i));
            orderForm.getOrderBooks().add(orderBook);
        }
        orderRepository.save(orderForm);
    }
    public List<OrderForm> findAll(int userAuthId){
        return orderRepository.findAllByUserAuthId(userAuthId);
    }
    public List<OrderForm> findAll2(){return orderRepository.findAll();}
}
