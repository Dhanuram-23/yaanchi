package com.yaanchii.controller;

import com.yaanchii.model.Product;
import com.yaanchii.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(
            ProductService productService) {

        this.productService = productService;
    }

    @GetMapping("/{id}")
    public String viewProduct(
            @PathVariable Long id,
            Model model) {

        Product product =
                productService.getProductById(id);

        model.addAttribute("product", product);

        return "product-details";
    }
}