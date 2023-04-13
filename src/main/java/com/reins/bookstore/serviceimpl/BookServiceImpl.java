package com.reins.bookstore.serviceimpl;

import com.reins.bookstore.dao.BookDao;
import com.reins.bookstore.entity.Book;
import com.reins.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @ClassName BookServiceImpl
 * @Description the Implement of BookService
 * @Author thunderBoy
 * @Date 2019/11/6 16:04
 */

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public Book findBookById(Integer id){
        return bookDao.findOne(id);
    }

    @Override
    public List<Book> getBooks() {
        return bookDao.getBooks();
    }

    public List<Book> getBooks2(List<Integer>bookId){
        return bookDao.getBooks2(bookId);
    }
    public void deleteBook(Integer id){
        bookDao.deleteById(id);
    }
    public void addBook( String isbn,
                  String name,
                  String type,
                  String author,
                  BigDecimal price,
                  String description,
                  Integer inventory,
                  String image){
        bookDao.addOne(isbn,name,type,author,price,description,inventory,image);
    }
    public void editBook( int bookId,String isbn,
                         String name,
                         String type,
                         String author,
                         BigDecimal price,
                         String description,
                         Integer inventory,
                         String image){
        bookDao.editOne(bookId,isbn,name,type,author,price,description,inventory,image);
    }
    public List<Book>bookCount(Date date1, Date date2){
        return bookDao.bookCount(date1,date2);
    }
}
