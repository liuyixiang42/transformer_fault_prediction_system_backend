package com.reins.bookstore.serviceimpl;

import com.reins.bookstore.dao.BookDao;
import com.reins.bookstore.dao.TemOrderBookDao;
import com.reins.bookstore.entity.Book;
import com.reins.bookstore.entity.TemOrderBook;
import com.reins.bookstore.service.TemOrderBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TemOrderBookServiceImpl implements TemOrderBookService {
    @Autowired
    private TemOrderBookDao temOrderBookDao;
    @Autowired
    private BookDao bookDao;
    public void addTemOrderBook(int userId,int bookId){
        Book book=bookDao.findOne(bookId);
        temOrderBookDao.addOne(userId,book);
    }
    @Transactional
    public void deleteAll(int userAuthId){
        temOrderBookDao.deleteAll(userAuthId);
    }
    public List<TemOrderBook> getAllTemOrderBooks(int userId){return temOrderBookDao.getAll(userId);}
}
