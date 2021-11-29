package ru.gb.spring4.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import org.hibernate.Session;
import ru.gb.spring4.Utils.SessionFactoryUtils;
import ru.gb.spring4.entity.Buyer;
import ru.gb.spring4.entity.Product;

@Component
public class ProductDaoImpl implements ProductDao {
    private final SessionFactoryUtils sessionFactoryUtils;


    public ProductDaoImpl(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public List<Buyer> findById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            List<Buyer> buyers = product.getBuyers();
            System.out.println(buyers); //todo без этой строчки выпадает ошибка lazy initialization
            session.getTransaction().commit();
            return buyers;
        }

    }
}
