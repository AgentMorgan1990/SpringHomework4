package ru.gb.spring4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.gb.spring4.entity.Product;
import ru.gb.spring4.exceptions.ResourceNotFoundException;
import ru.gb.spring4.repository.ProductRepository;
import ru.gb.spring4.repository.specefications.ProductSpecifications;


@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }


    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }

    public Page<Product> find(Integer minPrice, Integer maxPrice, String partName, Integer page) {
        Specification<Product> spec = Specification.where(null);
        if (minPrice != null) {
            spec = spec.and(ProductSpecifications.scoreGreaterOrEqualsThan(minPrice));
        }
        if (maxPrice != null) {
            spec = spec.and(ProductSpecifications.scoreLessThanOrEqualsThan(maxPrice));
        }
        if (partName != null) {
            spec = spec.and(ProductSpecifications.nameLike(partName));
        }

        return repository.findAll(spec, PageRequest.of(page - 1, 5));
    }

    public Product save(Product product) {
        return repository.save(product);
    }


    public void deleteById(Long id) {
        repository.deleteById(id);
    }

//    public List<Product> findByPriceBetween(Integer min, Integer max) {
//        return repository.findAllByPriceBetween(min, max);
//    }

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
