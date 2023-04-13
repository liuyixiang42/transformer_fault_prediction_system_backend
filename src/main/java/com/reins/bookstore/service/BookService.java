package com.reins.bookstore.service;

import com.reins.bookstore.entity.Book;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


public interface BookService {

    Book findBookById(Integer id);

    List<Book> getBooks();

    List<Book> getBooks2(List<Integer>bookId);
    void deleteBook(Integer id);

    void addBook( String isbn,
             String name,
             String type,
             String author,
             BigDecimal price,
             String description,
            Integer inventory,
             String image);
    void editBook(int bookId,String isbn,
                  String name,
                  String type,
                  String author,
                  BigDecimal price,
                  String description,
                  Integer inventory,
                  String image);
    List<Book>bookCount(Date date1, Date date2);
}
