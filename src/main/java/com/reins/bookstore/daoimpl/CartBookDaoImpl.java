package com.reins.bookstore.daoimpl;

import com.reins.bookstore.dao.CartBookDao;
import com.reins.bookstore.dao.CartDao;
import com.reins.bookstore.entity.Book;
import com.reins.bookstore.entity.Cart;
import com.reins.bookstore.entity.CartBook;
import com.reins.bookstore.repository.BookRepository;
import com.reins.bookstore.repository.CartBookRepository;
import com.reins.bookstore.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CartBookDaoImpl implements CartBookDao {
    @Autowired
    private CartBookRepository cartBookRepository;
    @Autowired
    private CartRepository cartRepository;
    @Override
    public List<CartBook> getCartBooks(int userAuthId) {
        Cart cart =cartRepository.findByUserAuthId(userAuthId);
        if(cart==null)return null;
        return cartBookRepository.findAllByCartId(cart.getCartId());
    }

    @Override
    public void deleteCartBookByCartBookId(Integer cartBookId){
        cartBookRepository.deleteById(cartBookId);
    }
    @Override
    public void addCartBook(int userAuthId,Book book){
        Cart cart=cartRepository.findByUserAuthId(userAuthId);
        if(cart==null){
            cart=new Cart();
            cart.setUserAuthId(userAuthId);
        }
        cartRepository.save(cart);
        CartBook newCartBook=new CartBook();
        newCartBook.setName(book.getName());
        newCartBook.setBookId(book.getBookId());
        newCartBook.setPrice(book.getPrice());
        newCartBook.setImage(book.getImage());
        newCartBook.setCartId(cart.getCartId());
        cartBookRepository.save(newCartBook);
    }
    @Override
    public void deleteAll(int userAuthId){
        Cart cart =cartRepository.findByUserAuthId(userAuthId);
        cartBookRepository.deleteByCartId(cart.getCartId());
    }
}
