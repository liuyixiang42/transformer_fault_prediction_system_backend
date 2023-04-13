package com.reins.bookstore.controller;

import com.reins.bookstore.entity.OrderForm;
import com.reins.bookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/addOrder")
    public void addOrder(@RequestParam("userAuthId") int userAuthId,@RequestParam("totalPrice")BigDecimal totalPrice, @RequestParam("receiver")String receiver, @RequestParam("tel")String tel, @RequestParam("address")String address, @RequestParam("bookId")List<Integer> bookId){
        orderService.addOrder(userAuthId,totalPrice,receiver,tel,address,bookId);
    }
    @RequestMapping("/getOrders")
    public List<OrderForm>getOrders(@RequestParam("userAuthId") int userAuthId){
        return orderService.getAll(userAuthId);
    }
    @RequestMapping("/getOrders2")
    public List<OrderForm>getOrders2(){
        return orderService.getAll2();
    }
}
