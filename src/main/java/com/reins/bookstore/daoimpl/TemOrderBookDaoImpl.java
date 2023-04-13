package com.reins.bookstore.daoimpl;


import com.reins.bookstore.dao.TemOrderBookDao;
import com.reins.bookstore.entity.Book;
import com.reins.bookstore.entity.TemOrderBook;
import com.reins.bookstore.repository.BookRepository;
import com.reins.bookstore.repository.TemOrderBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TemOrderBookDaoImpl implements TemOrderBookDao {
    @Autowired
    private TemOrderBookRepository temOrderBookRepository;
    @Autowired
    private BookRepository bookRepository;

    public void addOne(int userId,Book book){
        TemOrderBook newTemOrderBook=new TemOrderBook();
        newTemOrderBook.setBookId(book.getBookId());
        newTemOrderBook.setName(book.getName());
        newTemOrderBook.setAuthor(book.getAuthor());
        newTemOrderBook.setPrice(book.getPrice());
        newTemOrderBook.setUserId(userId);
        temOrderBookRepository.save(newTemOrderBook);
        book.setInventory(book.getInventory()-1);
        bookRepository.save(book);
    }

    public void deleteAll(int userAuthId){
        temOrderBookRepository.deleteByUserId(userAuthId);
    }
    public List<TemOrderBook> getAll(int userId){
        return temOrderBookRepository.findAllByUserId(userId);
    }
}
