package ru.gb.spring4.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import ru.gb.spring4.entity.Product;
import ru.gb.spring4.service.ProductService;

@RestController
public class ProductController {

    private final ProductService service;

    private ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/products")
    @ResponseBody
    public List<Product> findAllProducts() {
        return service.findAll();
    }

    @GetMapping("/products/{id}")
    @ResponseBody
    public Product findProduct(Long id) {
        return service.findById(id);
    }

    @PostMapping("/products/add")
    @ResponseBody
    public Product addProducts(@RequestBody Product product) {
        return service.save(product);
    }

    @GetMapping("/products/delete/{id}")
    @ResponseBody
    public void deleteProduct(@PathVariable Long id) {
        service.deleteById(id);
    }

    @GetMapping("/products/min")
    @ResponseBody
    public List<Product> findLessThanPriceValue(@RequestParam Integer min) {
        return service.findLessThanValue(min);
    }

    @GetMapping("/products/max")
    @ResponseBody
    public List<Product> findMoreThanPriceValue(@RequestParam Integer max) {
        return service.findMoreThanValue(max);
    }

    @GetMapping("/products/between")
    @ResponseBody
    public List<Product> findAllProductsBetweenPrice(@RequestParam Integer min, @RequestParam Integer max) {
        return service.findByPriceBetween(min, max);
    }

    @GetMapping("/products/change_price")
    @ResponseBody
    public void changeProductPrice(@RequestParam Long productId, @RequestParam Integer delta) {
        service.changePrice(productId, delta);
    }
}
