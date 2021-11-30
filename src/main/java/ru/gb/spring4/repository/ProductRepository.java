package ru.gb.spring4.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ru.gb.spring4.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByPriceBetween(Integer min, Integer max);


    @Query(value = """
            SELECT * FROM products
            WHERE price < ?1
            """,
            nativeQuery = true)
    List<Product> findLessThanValue(Integer min);


    @Query(value = """
            SELECT * FROM products
            WHERE price > ?1
            """,
            nativeQuery = true)
    List<Product> findMoreThanValue(Integer max);
}
