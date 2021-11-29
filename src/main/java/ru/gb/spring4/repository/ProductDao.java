package ru.gb.spring4.repository;

import java.util.List;

import ru.gb.spring4.entity.Buyer;

public interface ProductDao {

    List<Buyer> findById(Long id);

}
