package com.reins.bookstore.service;

import com.reins.bookstore.entity.Book;
import com.reins.bookstore.entity.CartBook;
import com.reins.bookstore.entity.OrderBook;

import java.util.List;

public interface OrderBookService {
    List<OrderBook> getOrderBooksByOrderId(Integer orderId);
    void deleteOrderBookByOrderBookId(Integer orderBookId);
    void addOrderBook(int orderId,int bookId);
}
