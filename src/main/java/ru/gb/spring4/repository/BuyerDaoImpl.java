package ru.gb.spring4.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import org.hibernate.Session;
import ru.gb.spring4.Utils.SessionFactoryUtils;
import ru.gb.spring4.entity.Buyer;
import ru.gb.spring4.entity.Product;

@Component
public class BuyerDaoImpl implements BuyerDao {
    private final SessionFactoryUtils sessionFactoryUtils;


    public BuyerDaoImpl(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public List<Product> findById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Buyer buyer = session.get(Buyer.class, id);
            List<Product> products = buyer.getProducts();
            System.out.println(products); //todo без этой строчки выпадает ошибка lazy initialization
            session.getTransaction().commit();
            return products;
        }
    }
}
