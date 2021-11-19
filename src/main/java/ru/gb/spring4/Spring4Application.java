package ru.gb.spring4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ru.gb.spring4.Utils.SessionFactoryUtils;
import ru.gb.spring4.repository.ProductDao;
import ru.gb.spring4.repository.ProductDaoImpl;

@SpringBootApplication
public class Spring4Application {

	public static void main(String[] args) {SpringApplication.run(Spring4Application.class, args);}}

