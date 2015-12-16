

INSERT INTO Category (id, active, creation_date, uuid, name)             VALUES (1, 1, '2015-01-01 15:22:40.997', '1', 'Mobile');
INSERT INTO Category (id, active, creation_date, uuid, name, parent_id)  VALUES (2, 1, '2015-01-01 15:22:40.997', '2', 'SmartPhone', 1);

INSERT INTO Product (id, active, creation_date, uuid, name, category_id) VALUES (1, 1, '2015-01-01 15:22:40.997', '1', 'Galaxy S', 2);
INSERT INTO Product (id, active, creation_date, uuid, name, category_id) VALUES (2, 1, '2015-01-01 15:22:40.997', '2', 'Galaxy S2', 2);
INSERT INTO Product (id, active, creation_date, uuid, name, category_id) VALUES (3, 1, '2015-01-01 15:22:40.997', '3', 'Galaxy S3', 2);
INSERT INTO Product (id, active, creation_date, uuid, name, category_id) VALUES (4, 1, '2015-01-01 15:22:40.997', '4', 'Galaxy S4', 2);
INSERT INTO Product (id, active, creation_date, uuid, name, category_id) VALUES (5, 1, '2015-01-01 15:22:40.997', '5', 'Galaxy S5', 2);
INSERT INTO Product (id, active, creation_date, uuid, name, category_id) VALUES (6, 1, '2015-01-01 15:22:40.997', '6', 'Galaxy GranDuos', 2);

INSERT INTO Customer (id, active, creation_date, uuid, name) VALUES (1, 1, '2015-01-01 15:22:40.997', '1', 'Michael Jackson');

INSERT INTO CustomerOrder (id, active, creation_date, uuid, customer_id) VALUES (1, 1, '2015-01-01 15:22:40.997', '1', 1);

INSERT INTO OrderProduct (id, active, creation_date, uuid, product_id, order_id, amount) VALUES (1, 1, '2015-01-01 15:22:40.997', '1', 1, 1, 10);

