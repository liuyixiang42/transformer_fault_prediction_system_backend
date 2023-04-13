package com.reins.bookstore.repository;

import com.reins.bookstore.entity.CartBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartBookRepository extends JpaRepository<CartBook,Integer> {
    @Override
    List<CartBook> findAll();

    List<CartBook> findAllByCartId(int cartId);

    void deleteAllByCartId(int cartId);

    void deleteByCartId(int cartId);
}
