package ru.gb.spring4.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import ru.gb.spring4.entity.Product;
import ru.gb.spring4.service.ProductService;

@RestController
public class ProductController {
    private ProductController(ProductService service) {
        this.service = service;
    }

    private ProductService service;

    @GetMapping("/products")
    @ResponseBody
    public List<Product> findProduct() {
        return service.findAll();
    }

    @GetMapping("/products/change_price")
    @ResponseBody
    public void changeProductPrice(@RequestParam Long productId, @RequestParam Double delta) {
        service.changePrice(productId, delta);
    }

    @GetMapping("/products/delete/{productId}")
    @ResponseBody
    public void deleteProduct(@PathVariable Long productId) {
        service.deleteById(productId);
    }
}
