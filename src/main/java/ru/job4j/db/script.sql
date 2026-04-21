CREATE DATABASE electronic_products;

CREATE TABLE products (
                          id SERIAL PRIMARY KEY,
                          description varchar(100),
                          cost numeric
);

insert into  products(description, cost) VALUES ('PC', 100);
update products set cost = 120 where description = 'PC';
delete from products;