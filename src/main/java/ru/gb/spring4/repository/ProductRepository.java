package ru.gb.spring4.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.gb.spring4.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByPriceBetween(Integer min, Integer max);

}
