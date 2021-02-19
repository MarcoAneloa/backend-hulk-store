INSERT INTO categories (name) VALUES('marvel');
INSERT INTO categories (name) VALUES('dc');

/* Populate tabla productos */
INSERT INTO products (name, price, stock,id_category,description,img,bestseller) VALUES('CAMISETA', 23.56, 10,2,'La desccripción es una idea','img',false);
INSERT INTO products (name, price, stock,id_category,description,img,bestseller) VALUES('CAMISETA', 45.00, 10,1,'La desccripción es una idea','img',false);
INSERT INTO products (name, price, stock,id_category,description,img,bestseller) VALUES('VASO', 5.00, 0,2,'La desccripción es una idea','img',true);
INSERT INTO products (name, price, stock,id_category,description,img,bestseller) VALUES('ESFEROS', 1.00, 10,1,'La desccripción es una idea','img',true);
INSERT INTO products (name, price, stock,id_category,description,img,bestseller) VALUES('CARRO', 23.00, 0,2,'La desccripción es una idea','img',true);
INSERT INTO products (name, price, stock,id_category,description,img,bestseller) VALUES('CUADERNO', 3.00, 10,1,'La desccripción es una idea','img',true);
