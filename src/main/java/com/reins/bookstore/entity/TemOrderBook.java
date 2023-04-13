package com.reins.bookstore.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "tem_order_book")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
public class TemOrderBook {
    @Id
    @Column(name = "tem_order_book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int temOrderBookId;
    @Column(name = "book_id")
    private int bookId;
    @Column(name = "name")
    private String name;
    @Column(name = "author")
    private String author;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "user_id")
    private int userId;
}
