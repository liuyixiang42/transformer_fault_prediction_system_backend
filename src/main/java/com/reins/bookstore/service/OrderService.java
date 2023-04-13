package com.reins.bookstore.service;

import com.reins.bookstore.entity.OrderForm;

import java.math.BigDecimal;
import java.util.List;

public interface OrderService {
    void addOrder(int userAuthId,BigDecimal totalPrice, String receiver, String tel, String address, List<Integer> bookId);
    List<OrderForm>getAll(int userAuthId);
    List<OrderForm>getAll2();
}
