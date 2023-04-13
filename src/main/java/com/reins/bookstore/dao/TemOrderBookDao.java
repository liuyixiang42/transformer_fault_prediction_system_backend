package com.reins.bookstore.dao;

import com.reins.bookstore.entity.Book;
import com.reins.bookstore.entity.TemOrderBook;

import java.util.List;

public interface TemOrderBookDao {
    void addOne(int userId,Book book);

    void deleteAll(int userAuthId);

    List<TemOrderBook> getAll(int userId);
}
