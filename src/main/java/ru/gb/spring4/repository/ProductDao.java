package ru.gb.spring4.repository;

import java.util.List;

import ru.gb.spring4.entity.Product;

public interface ProductDao {

    Product findById(Long id);

    List<Product> findAll();

    void deleteById(Long id);

    Product saveOrUpdate(Product product);
}
