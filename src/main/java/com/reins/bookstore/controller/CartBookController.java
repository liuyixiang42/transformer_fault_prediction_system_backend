package com.reins.bookstore.controller;

import com.reins.bookstore.entity.Book;
import com.reins.bookstore.entity.CartBook;
import com.reins.bookstore.service.CartBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartBookController {
    @Autowired
    private CartBookService cartBookService;

    @RequestMapping("/getCartBooks")
    public List<CartBook> getCartBooks(@RequestParam("userAuthId") int userAuthId){return cartBookService.getCartBooks(userAuthId);}

    @RequestMapping("/deleteCartBook")
    public List<CartBook> deleteCartBook(@RequestParam("userAuthId") int userAuthId,@RequestParam("cartBookId") Integer cartBookId){
        cartBookService.deleteCartBookByCartBookId(cartBookId);
        return cartBookService.getCartBooks(userAuthId);
    }
    @RequestMapping("/deleteCartBooks")
    public void deleteAllCartBooks(@RequestParam("userAuthId") int userAuthId){
        cartBookService.deleteAll(userAuthId);
    }
    @RequestMapping("/addCartBook")
    public void addCartBook(@RequestParam("userAuthId") int userAuthId,@RequestParam("bookId") int bookId){//加入购物车不用判断库存，结算需要判断，而且在前端判断
        cartBookService.addCartBook(userAuthId,bookId);
    }
}
