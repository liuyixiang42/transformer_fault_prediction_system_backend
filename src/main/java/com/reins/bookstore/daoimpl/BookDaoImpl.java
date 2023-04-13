package com.reins.bookstore.daoimpl;

import com.reins.bookstore.dao.BookDao;
import com.reins.bookstore.entity.Book;
import com.reins.bookstore.entity.OrderBook;
import com.reins.bookstore.entity.OrderForm;
import com.reins.bookstore.repository.BookRepository;
import com.reins.bookstore.repository.OrderBookRepository;
import com.reins.bookstore.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @ClassName BookDaoImpl
 * @Description TODO
 * @Author thunderBoy
 * @Date 2019/11/5 20:20
 */
@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private OrderBookRepository orderBookRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Book findOne(Integer id){
        return bookRepository.getOne(id);
    }


    @Override
    public List<Book> getBooks() {
        return bookRepository.getBooks();
    }


    public void deleteById(Integer id){
        bookRepository.deleteById(id);
    }
    public void addOne(String isbn, String name, String type, String author, BigDecimal price, String description, Integer inventory, String image){
        Book book=new Book();
        book.setIsbn(isbn);
        book.setName(name);
        book.setType(type);
        book.setAuthor(author);
        book.setPrice(price);
        book.setDescription(description);
        book.setInventory(inventory);
        book.setImage(image);
        bookRepository.save(book);
    }
    public void editOne(int bookId,String isbn, String name, String type, String author, BigDecimal price, String description, Integer inventory, String image){
        Optional<Book> one=bookRepository.findById(bookId);
        Book book=one.get();
        book.setIsbn(isbn);
        book.setName(name);
        book.setType(type);
        book.setAuthor(author);
        book.setPrice(price);
        book.setDescription(description);
        book.setInventory(inventory);
        book.setImage(image);
        bookRepository.save(book);
    }
    public List<Book> getBooks2(List<Integer> bookId){
        List<Book>books=new ArrayList<>();
        for(int i=0;i<bookId.size();i++) {
            books.add(bookRepository.findById(bookId.get(i)).get());
        }
        return books;
    }
    public List<Book> bookCount(Date date1, Date date2){
        List<Book>theBooks=new ArrayList<>();
        List<OrderForm>orderForms=orderRepository.findAll();
        for(OrderForm a:orderForms){
            if((a.getDate().compareTo(date1)>=0)&&(a.getDate().compareTo(date2)<=0)){
                List<OrderBook>orderBooks=orderBookRepository.getAllByOrderId(a.getOrderId());
                for(OrderBook o:orderBooks){
                    theBooks.add(bookRepository.findById(o.getBookId()).get());
                }
            }
        }
        return theBooks;
    }
}