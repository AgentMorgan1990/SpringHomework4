package ru.gb.spring4.service;


import java.util.List;

import org.springframework.stereotype.Service;

import ru.gb.spring4.entity.Buyer;
import ru.gb.spring4.entity.Product;
import ru.gb.spring4.repository.BuyerDao;
import ru.gb.spring4.repository.ProductDao;
import ru.gb.spring4.repository.ProductDaoImpl;

@Service
public class InformationService {
    private final ProductDao productDao;
    private final BuyerDao buyerDao;

    public InformationService(ProductDaoImpl productDao, BuyerDao buyerDao) {
        this.productDao = productDao;
        this.buyerDao = buyerDao;
    }

    public void showBuyersByProductId(Long id) {

        List<Buyer> list = productDao.findById(id);
        for (Buyer name : list) {
            System.out.println(name.getId() + " " + name.getName());
        }
    }

    public void showProductByBuyerId(Long id) {

        List<Product> list = buyerDao.findById(id);
        for (Product name : list) {
            System.out.println(name.getId() + " " + name.getName() + " " + name.getPrice());
        }
    }
}
