package com.reins.bookstore.dao;

import com.reins.bookstore.entity.Book;
import com.reins.bookstore.entity.CartBook;

import java.util.List;

public interface CartBookDao {
    List<CartBook> getCartBooks(int userAuthId);

    void deleteCartBookByCartBookId(Integer cartBookId);
    void addCartBook(int userAuthId,Book book);

    void deleteAll(int userAuthId);
}
