package com.reins.bookstore.service;

import com.reins.bookstore.entity.Book;
import com.reins.bookstore.entity.CartBook;

import javax.transaction.Transactional;
import java.util.List;

public interface CartBookService {
    List<CartBook> getCartBooks(int userAuthId);
    void deleteCartBookByCartBookId(Integer cartBookId);
    void addCartBook(int userAuthId,int bookId);
    void deleteAll(int userAuthId);
}
