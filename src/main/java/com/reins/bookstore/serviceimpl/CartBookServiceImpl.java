package com.reins.bookstore.serviceimpl;

import com.reins.bookstore.dao.BookDao;
import com.reins.bookstore.dao.CartBookDao;
import com.reins.bookstore.entity.Book;
import com.reins.bookstore.entity.CartBook;
import com.reins.bookstore.service.CartBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class CartBookServiceImpl implements CartBookService {
    @Autowired
    private CartBookDao cartBookDao;
    @Autowired
    private BookDao bookDao;
    @Override
    public List<CartBook> getCartBooks(int userAuthId) {
        return cartBookDao.getCartBooks(userAuthId);
    }
    @Override
    public void deleteCartBookByCartBookId(Integer cartBookId){
        cartBookDao.deleteCartBookByCartBookId(cartBookId);
    }
    @Override
    public void addCartBook(int userAuthId,int bookId){
        Book book=bookDao.findOne(bookId);
        cartBookDao.addCartBook(userAuthId,book);
    }
    @Override
    @Transactional
    public void deleteAll(int userAuthId){
        cartBookDao.deleteAll(userAuthId);
    }
}
