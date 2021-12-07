package ru.gb.spring4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.gb.spring4.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
