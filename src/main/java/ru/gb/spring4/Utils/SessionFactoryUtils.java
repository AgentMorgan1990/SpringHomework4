package ru.gb.spring4.Utils;

import org.springframework.stereotype.Component;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Component
public class SessionFactoryUtils {

    private final SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .buildSessionFactory();

    public Session getSession() {
        return factory.getCurrentSession();
    }
}
