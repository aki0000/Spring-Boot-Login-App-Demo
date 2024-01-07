DROP TABLE if EXISTS customers;

CREATE TABLE if NOT EXISTS customers (
    id serial,
    customer_id VARCHAR(10),
    customer_name VARCHAR(255),
    customer_address VARCHAR(10),
    PRIMARY KEY(id)
);