package ru.gb.spring4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.gb.spring4.entity.Product;
import ru.gb.spring4.exceptions.ResourceNotFoundException;
import ru.gb.spring4.repository.ProductRepository;


@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }


    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product save(Product product) {
        return repository.save(product);
    }


    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public List<Product> findByPriceBetween(Integer min, Integer max) {
        return repository.findAllByPriceBetween(min, max);
    }

    @Transactional
    public void changePrice(Long id, Integer delta) {
        Product product = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found, id: " + id));
        int newPrice = product.getPrice() + delta;
        if (newPrice < 0) {
            newPrice = 0;
        }
        product.setPrice(newPrice);
    }
}
