package com.reins.bookstore.daoimpl;


import com.reins.bookstore.dao.OrderBookDao;
import com.reins.bookstore.entity.Book;
import com.reins.bookstore.entity.OrderBook;
import com.reins.bookstore.repository.OrderBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class OrderBookDaoImpl implements OrderBookDao {
    @Autowired
    private OrderBookRepository orderBookRepository;
    @Override
    public List<OrderBook> getOrderBooksByOrderId(Integer orderId) {
        return orderBookRepository.getAllByOrderId(orderId);
    }
    @Override
    public void deleteOrderBookByOrderBookId(Integer orderBookId){
        orderBookRepository.deleteById(orderBookId);
    }
    @Override
    public OrderBook addOrderBook(int orderId,Book book){
        OrderBook newOrderBook=new OrderBook();
        newOrderBook.setOrderId(orderId);
        newOrderBook.setBookId(book.getBookId());
        newOrderBook.setName(book.getName());
        newOrderBook.setPrice(book.getPrice());
        newOrderBook.setAuthor(book.getAuthor());
        return orderBookRepository.save(newOrderBook);
    }
}
