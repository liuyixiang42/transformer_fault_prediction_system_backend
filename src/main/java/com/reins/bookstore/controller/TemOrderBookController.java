package com.reins.bookstore.controller;

import com.reins.bookstore.entity.TemOrderBook;
import com.reins.bookstore.service.TemOrderBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TemOrderBookController {
    @Autowired
    private TemOrderBookService temOrderBookService;

    @RequestMapping("/addTemOrderBook")
    public void addTemOrderBook(@RequestParam("userAuthId") int userAuthId,@RequestParam("bookId") List<Integer>bookId){//直接减库存，前端已经做过判断
        System.out.println(bookId);
        for(int i=0;i<bookId.size();i++){
            temOrderBookService.addTemOrderBook(userAuthId,bookId.get(i));
        }
    }
    @RequestMapping("/deleteTemOrderBooks")
    public void deleteTemOrderBooks(@RequestParam("userAuthId") int userAuthId){
        System.out.println("删除全部");
        temOrderBookService.deleteAll(userAuthId);
    }
    @RequestMapping("/getTemOrderBooks")
    public List<TemOrderBook>getTemOrderBooks(@RequestParam("userAuthId") int userAuthId){
        return temOrderBookService.getAllTemOrderBooks(userAuthId);
    }
}
