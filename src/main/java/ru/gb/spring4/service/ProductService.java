package ru.gb.spring4.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ru.gb.spring4.entity.Product;
import ru.gb.spring4.repository.ProductDaoImpl;


@Service
public class ProductService {
    private final ProductDaoImpl productDao;

    public ProductService(ProductDaoImpl productDao) {
        this.productDao = productDao;
    }


    public List<Product> findAll() {
        return productDao.findAll();
    }

    public void deleteById(Long id) {
        productDao.deleteById(id);
    }

    public void changePrice(Long id, Integer delta) {
        Product product = productDao.findById(id);
        int newPrice = product.getPrice();
        newPrice = newPrice + delta;
        if (newPrice < 0) {
            newPrice = 0;
        }
        product.setPrice(newPrice);
        productDao.saveOrUpdate(product);
    }
}
