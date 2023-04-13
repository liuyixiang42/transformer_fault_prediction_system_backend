package com.reins.bookstore.repository;

import com.reins.bookstore.entity.TemOrderBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TemOrderBookRepository extends JpaRepository<TemOrderBook,Integer> {
    List<TemOrderBook> findAllByUserId(int userId);

    void deleteByUserId(int userAuthId);
}
