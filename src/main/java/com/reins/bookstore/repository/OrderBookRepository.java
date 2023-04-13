package com.reins.bookstore.repository;

import com.reins.bookstore.entity.OrderBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderBookRepository extends JpaRepository<OrderBook,Integer> {
    List<OrderBook> getAllByOrderId(Integer orderId);
}
