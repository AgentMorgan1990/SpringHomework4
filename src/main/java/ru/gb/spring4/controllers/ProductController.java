package ru.gb.spring4.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.*;

import ru.gb.spring4.dto.ProductDto;
import ru.gb.spring4.entity.Product;
import ru.gb.spring4.service.ProductService;

@RestController
@RequestMapping("/v1/products")
public class ProductController {

    private final ProductService service;

    private ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping()
    @ResponseBody
    public List<ProductDto> findAllProducts() {
        return service.findAll().stream().map(s->new ProductDto(s)).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ProductDto findProduct(@PathVariable Long id) {
        return new ProductDto(service.findById(id).get());
    }

    @PostMapping()
    @ResponseBody
    public ProductDto addProducts(@RequestBody ProductDto productDto) {
        service.save(new Product(productDto.getId(), productDto.getName(), productDto.getPrice()));
        return productDto;
    }

    @PutMapping()
    public ProductDto updateProducts(@RequestBody ProductDto productDto) {
       Product product = service.findById(productDto.getId()).get();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        return productDto;
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void deleteProduct(@PathVariable Long id) {
        service.deleteById(id);
    }
}
