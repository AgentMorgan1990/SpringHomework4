package ru.gb.spring4.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
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
    public Page<Product> getAllProducts(
            @RequestParam(name = "p", defaultValue = "1") Integer page,
            @RequestParam(name = "min_price", required = false) Integer minPrice,
            @RequestParam(name = "max_price", required = false) Integer maxPrice,
            @RequestParam(name = "name_part", required = false) String namePart
    ) {
        if (page < 1) {
            page = 1;
        }
        System.out.println(minPrice);
        System.out.println(maxPrice);
        System.out.println(namePart);
        System.out.println(page);
        return service.find(minPrice, maxPrice, namePart, page);


    }

    @GetMapping("/products/{id}")
    @ResponseBody
    public Optional<Product> findProduct(Long id) {
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

    @GetMapping("/products/change_price")
    @ResponseBody
    public void changeProductPrice(@RequestParam Long productId, @RequestParam Integer delta) {
        service.changePrice(productId, delta);
    }
}
