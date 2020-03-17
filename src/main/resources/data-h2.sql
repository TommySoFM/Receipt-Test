-- Product types were hard-coded in in-memory h2 database
-- It should be done in normal SQL or NoSQL database in real-world case

INSERT INTO category(product_type, product_name) VALUES('Stationary', 'book');
INSERT INTO category(product_type, product_name) VALUES('Stationary', 'pencils');
INSERT INTO category(product_type, product_name) VALUES('Food', 'potato chips');
INSERT INTO category(product_type, product_name) VALUES('Clothing', 'shirt');
