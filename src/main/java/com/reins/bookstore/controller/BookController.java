package com.reins.bookstore.controller;

import com.reins.bookstore.entity.Book;
import com.reins.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.Console;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ClassName BookController
 * @Description TODO
 * @Author thunderBoy
 * @Date 2019/11/6 16:07
 */
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/getBooks")
    public List<Book> getBooks(@RequestBody Map<String, String> params) {
        return bookService.getBooks();
    }

    @RequestMapping("/getBooks2")
    public List<Book> getBooks2(@RequestParam("bookId") List<Integer> bookId) {
        return bookService.getBooks2(bookId);
    }

    @RequestMapping("/getBook")
    public Book getBook(@RequestParam("id") Integer id) {
        return bookService.findBookById(id);
    }

    @RequestMapping("/deleteBook")
    public List<Book> deleteBook(@RequestParam("bookId") Integer bookId) {
        bookService.deleteBook(bookId);
        return bookService.getBooks();
    }

    @RequestMapping("/addBook")
    public List<Book> addBook(@RequestParam("isbn") String isbn,
                              @RequestParam("name") String name,
                              @RequestParam("type") String type,
                              @RequestParam("author") String author,
                              @RequestParam("price") BigDecimal price,
                              @RequestParam("description") String description,
                              @RequestParam("inventory") Integer inventory,
                              @RequestParam("image") String image) {
        bookService.addBook(isbn, name, type, author, price, description, inventory, image);
        System.out.println("添加图书" + name);
        return bookService.getBooks();
    }

    @RequestMapping("/editBook")
    public void editBook(@RequestParam("bookId") int bookId,
                         @RequestParam("isbn") String isbn,
                         @RequestParam("name") String name,
                         @RequestParam("type") String type,
                         @RequestParam("author") String author,
                         @RequestParam("price") BigDecimal price,
                         @RequestParam("description") String description,
                         @RequestParam("inventory") Integer inventory,
                         @RequestParam("image") String image) {
        System.out.println("1232");
        bookService.editBook(bookId, isbn, name, type, author, price, description, inventory, image);
    }
    @RequestMapping("/bookCount")
    public List<Book>bookCount(@RequestParam("date1") Date date1, @RequestParam("date2") Date date2){
        return bookService.bookCount(date1,date2);
    }

}
