package com.reins.bookstore.dao;

import com.reins.bookstore.entity.Book;
import com.reins.bookstore.entity.OrderBook;

import java.util.List;

public interface OrderBookDao {
    List<OrderBook> getOrderBooksByOrderId(Integer orderId);
    void deleteOrderBookByOrderBookId(Integer orderBookId);
    OrderBook addOrderBook(int orderId,Book book);
}
