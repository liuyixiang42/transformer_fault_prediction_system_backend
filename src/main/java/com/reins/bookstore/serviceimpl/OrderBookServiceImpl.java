package com.reins.bookstore.serviceimpl;


import com.reins.bookstore.dao.BookDao;
import com.reins.bookstore.dao.OrderBookDao;
import com.reins.bookstore.entity.Book;
import com.reins.bookstore.entity.OrderBook;
import com.reins.bookstore.service.OrderBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderBookServiceImpl implements OrderBookService {
    @Autowired
    private OrderBookDao orderBookDao;
    @Autowired
    private BookDao bookDao;
    @Override
    public List<OrderBook> getOrderBooksByOrderId(Integer orderId) {
        return orderBookDao.getOrderBooksByOrderId(orderId);
    }
    @Override
    public void deleteOrderBookByOrderBookId(Integer orderBookId){
        orderBookDao.deleteOrderBookByOrderBookId(orderBookId);
    }
    @Override
    public void addOrderBook(int orderId,int bookId){
        Book book= bookDao.findOne(bookId);
        orderBookDao.addOrderBook(orderId,book);
    }
}
