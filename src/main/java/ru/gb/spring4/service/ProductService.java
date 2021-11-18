package ru.gb.spring4.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ru.gb.spring4.entity.Product;
import ru.gb.spring4.repository.ProductRepository;

@Service
public class ProductService {
    private ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }


    public List<Product> findAll() {
        return repository.findAll();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public void changePrice(Long id, Double delta) {
        Product product = repository.findById(id);
        double newPrice = product.getPrice();
        newPrice = newPrice + delta;
        if (newPrice<0){
            newPrice = 0;
        }
        product.setPrice(newPrice);
        repository.deleteById(id);
        repository.save(product);
    }
}
