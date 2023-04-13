package com.reins.bookstore.dao;

import com.reins.bookstore.entity.Book;
import com.reins.bookstore.entity.OrderForm;

import java.math.BigDecimal;
import java.util.List;

public interface OrderDao {
    void addOne(int userAuthId,BigDecimal totalPrice, String receiver, String tel, String address, List<Book> books);

    List<OrderForm> findAll(int userAuthId);

    List<OrderForm> findAll2();
}
