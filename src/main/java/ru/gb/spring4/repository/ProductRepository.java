package ru.gb.spring4.repository;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import ru.gb.spring4.entity.Product;

@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    void init() {
        products = new ArrayList<>(List.of(
                new Product("Milk", 1L, 45.67),
                new Product("Wine", 2L, 350.68),
                new Product("Snack", 3L, 80.78),
                new Product("Car", 4L, 1_000_000.80)
        ));
    }

    public List<Product> findAll() {
        return products;
    }

    public Product findById(Long id) {
        return products.stream().
                filter(s -> s.getId().equals(id)).
                findFirst().
                orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public void deleteById(Long id) {
        products.removeIf(s -> s.getId().equals(id));
    }

    public void save(Product product) {
        products.add(product);
    }
}
