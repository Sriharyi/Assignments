CREATE TABLE customer
(
  firstname VARCHAR NOT NULL,
  lastname VARCHAR NOT NULL,
  customerid INT NOT NULL,
  street VARCHAR NOT NULL,
  city INT NOT NULL,
  zip INT NOT NULL,
  phone INT NOT NULL,
  email VARCHAR NOT NULL,
  PRIMARY KEY (customerid),
  UNIQUE (email)
);

CREATE TABLE product
(
  productid INT NOT NULL,
  quantity INT NOT NULL,
  product_type INT NOT NULL,
  PRIMARY KEY (productid),
  UNIQUE ()
);

CREATE TABLE Order
(
  Order_number INT NOT NULL,
  customername INT NOT NULL,
  to_street INT NOT NULL,
  to_state INT NOT NULL,
  to_zip INT NOT NULL,
  ship_date INT NOT NULL,
  productid INT NOT NULL,
  productid INT NOT NULL,
  customerid INT NOT NULL,
  PRIMARY KEY (Order_number),
  FOREIGN KEY (productid) REFERENCES product(productid),
  FOREIGN KEY (customerid) REFERENCES customer(customerid)
);