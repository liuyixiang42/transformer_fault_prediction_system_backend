package com.reins.bookstore.controller;

import com.reins.bookstore.entity.Book;
import com.reins.bookstore.entity.CartBook;
import com.reins.bookstore.entity.OrderBook;
import com.reins.bookstore.service.CartBookService;
import com.reins.bookstore.service.OrderBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderBookController {
    @Autowired
    private OrderBookService orderBookService;

    @RequestMapping("/getOrderBooks")
    public List<OrderBook> getOrderBooks(@RequestParam("orderId") Integer orderId){return orderBookService.getOrderBooksByOrderId(orderId);}
    @RequestMapping("/deleteOrderBook")
    public void deleteOrderBook(@RequestParam("orderBookId") Integer orderBookId){orderBookService.deleteOrderBookByOrderBookId(orderBookId);}
    @RequestMapping("/addOrderBook")
    public void addOrderBook(@RequestParam("orderId") int orderId,@RequestParam("bookId") List<Integer>bookId){
        for(int i=0;i<bookId.size();i++){
            orderBookService.addOrderBook(orderId,bookId.get(i));
        }
    }
}
