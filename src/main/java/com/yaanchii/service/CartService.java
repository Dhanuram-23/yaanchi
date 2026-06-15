package com.yaanchii.service;

import com.yaanchii.model.CartItem;
import com.yaanchii.model.Product;
import com.yaanchii.model.User;
import com.yaanchii.repository.CartItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    private final CartItemRepository cartItemRepository;

    public CartService(
            CartItemRepository cartItemRepository) {

        this.cartItemRepository = cartItemRepository;
    }

    public void addToCart(User user,
                          Product product) {

        CartItem cartItem = CartItem.builder()
                .user(user)
                .product(product)
                .quantity(1)
                .build();

        cartItemRepository.save(cartItem);
    }

    public List<CartItem> getCartItems(User user) {

        return cartItemRepository.findByUser(user);
    }

    public void removeItem(Long cartItemId) {

        cartItemRepository.deleteById(cartItemId);
    }
}