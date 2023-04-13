package com.reins.bookstore.dao;

import com.reins.bookstore.entity.Book;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface BookDao {
    Book findOne(Integer id);

    List<Book> getBooks();

    void deleteById(Integer id);

    void addOne(String isbn, String name, String type, String author, BigDecimal price, String description, Integer inventory, String image);

    List<Book> getBooks2(List<Integer> bookId);

    void editOne(int bookId,String isbn, String name, String type, String author, BigDecimal price, String description, Integer inventory, String image);

    List<Book> bookCount(Date date1, Date date2);
}
