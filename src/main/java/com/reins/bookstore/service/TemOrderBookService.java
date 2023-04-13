package com.reins.bookstore.service;

import com.reins.bookstore.entity.TemOrderBook;

import java.util.List;

public interface TemOrderBookService {
    void addTemOrderBook(int userId,int bookId);
    void deleteAll(int userAuthId);
    List<TemOrderBook> getAllTemOrderBooks(int userId);
}
