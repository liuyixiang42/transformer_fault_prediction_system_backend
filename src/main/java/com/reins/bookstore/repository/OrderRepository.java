package com.reins.bookstore.repository;

import com.reins.bookstore.entity.OrderForm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderForm,Integer> {
    List<OrderForm> findAllByUserAuthId(int userAuthId);
}
