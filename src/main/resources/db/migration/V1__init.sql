CREATE TABLE If NOT EXISTS products (id bigserial primary key, name varchar(255), price int);

insert into products (name, price)
values
    ('Milk', 20),
    ('Beer', 50),
    ('Wine', 300),
    ('Bread', 10),
    ('Chocolate', 40),
    ('Motorcycle', 300000),
    ('Car', 1000000),
    ('Track', 5000000),
    ('Water', 5),
    ('Snack', 20),
    ('Apple', 90),
    ('Orange', 120),
    ('Fish', 400),
    ('Chips', 50),
    ('Beef', 300),
    ('Pork', 250),
    ('Banana', 70),
    ('Pineapple', 200),
    ('Marmalade', 50),
    ('Sweet', 50);