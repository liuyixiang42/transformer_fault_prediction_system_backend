package com.reins.bookstore.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "cart_book")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
public class CartBook {
    @Id
    @Column(name = "cart_book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartBookId;

    @Column(name = "book_id")
    private int bookId;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "image")
    private String image;

    @Column(name = "cart_id")
    private int cartId;


    public int getCartBookId() {
        return cartBookId;
    }

    public void setCartBookId(int cartBookId) {
        this.cartBookId = cartBookId;
    }

}
