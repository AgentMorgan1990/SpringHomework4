package ru.gb.spring4.repository;

import java.util.List;

import ru.gb.spring4.entity.Buyer;
import ru.gb.spring4.entity.Product;

public interface BuyerDao {

    List<Product> findById(Long id);

}
