package com.yaanchii.controller;

import com.yaanchii.model.Product;
import com.yaanchii.model.User;
import com.yaanchii.service.CartService;
import com.yaanchii.service.ProductService;
import com.yaanchii.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;
    private final ProductService productService;
    private final UserService userService;

    public CartController(
            CartService cartService,
            ProductService productService,
            UserService userService) {

        this.cartService = cartService;
        this.productService = productService;
        this.userService = userService;
    }

    @GetMapping
    public String viewCart(
            Authentication authentication,
            Model model) {

        User user = userService.findByEmail(
                authentication.getName());

        model.addAttribute(
                "cartItems",
                cartService.getCartItems(user));

        return "cart";
    }

    @PostMapping("/add/{productId}")
    public String addToCart(
            @PathVariable Long productId,
            Authentication authentication) {

        User user = userService.findByEmail(
                authentication.getName());

        Product product =
                productService.getProductById(productId);

        cartService.addToCart(user, product);

        return "redirect:/cart";
    }

    @PostMapping("/remove/{cartItemId}")
    public String removeItem(
            @PathVariable Long cartItemId) {

        cartService.removeItem(cartItemId);

        return "redirect:/cart";
    }
}