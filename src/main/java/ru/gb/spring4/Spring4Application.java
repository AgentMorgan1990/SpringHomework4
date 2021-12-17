package ru.gb.spring4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Spring4Application {

	public static void main(String[] args) {
		SpringApplication.run(Spring4Application.class, args);
	}


	// Домашнее задание:
	// 1. Заменить безопасность по ролям на безопасность по правам доступа
	// 2. * Сделать как роли, так и права доступа, у каждой роли свой набор прав
}
