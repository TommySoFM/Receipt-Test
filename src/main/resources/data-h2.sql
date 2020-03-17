-- Product types were hard-coded in in-memory h2 database
-- It should be done in normal SQL or NoSQL database in real-world case

INSERT INTO category(product_type, product_name) VALUES('stationary', 'book');
INSERT INTO category(product_type, product_name) VALUES('stationary', 'pencils');
INSERT INTO category(product_type, product_name) VALUES('food', 'potato chips');
INSERT INTO category(product_type, product_name) VALUES('clothing', 'shirt');
