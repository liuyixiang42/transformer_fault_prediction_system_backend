package com.reins.bookstore.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "order_form")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
public class OrderForm {
    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    @Column(name = "total_price")
    private BigDecimal totalPrice;
    @Column(name = "receiver")
    private String receiver;
    @Column(name = "tel")
    private String tel;
    @Column(name = "address")
    private String address;
    @Column(name = "user_auth_id")
    private int userAuthId;
    @Column(name = "date")
    private Date date;


    @OneToMany(cascade =CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = OrderBook.class)
    @JoinColumn(name = "order_id")
    private Set<OrderBook> orderBooks=new HashSet<>();

}