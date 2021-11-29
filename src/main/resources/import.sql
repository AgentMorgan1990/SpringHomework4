
DROP TABLE IF EXISTS public.products CASCADE ;
CREATE TABLE IF NOT EXISTS public.products (id bigserial, price int, name VARCHAR(255), PRIMARY KEY (id));
INSERT INTO public.products (name, price) VALUES ('Milk', 40), ('Beer', 50), ('Car', 100000000);

DROP TABLE IF EXISTS public.buyers CASCADE;
CREATE TABLE IF NOT EXISTS public.buyers (id bigserial, name VARCHAR(255), PRIMARY KEY (id));
INSERT INTO public.buyers (name) VALUES ('John'), ('Jack'), ('Alan'),('Bruce'),('Bill');

DROP TABLE IF EXISTS public.products_buyers CASCADE;
CREATE TABLE IF NOT EXISTS public.products_buyers (products_id bigint, buyers_id bigint,FOREIGN KEY (products_id) REFERENCES products(id), FOREIGN KEY (buyers_id) REFERENCES buyers(id));
INSERT INTO products_buyers (products_id, buyers_id) VALUES (1,1),(1,2),(2,2),(1,5),(2,5),(2,4),(3,4),(3,5);