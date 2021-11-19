-- DROP TABLE public.products IF EXISTS;
CREATE TABLE IF NOT EXISTS public.products (id bigserial, price int, name VARCHAR(255), PRIMARY KEY (id));
INSERT INTO public.products (name, price) VALUES ('Milk', 40), ('Beer', 50), ('Car', 100000000);