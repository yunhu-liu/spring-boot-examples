CREATE TABLE IF NOT EXISTS taco_order (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,  -- Use AUTO_INCREMENT for MySQL
    delivery_name VARCHAR(50) NOT NULL,
    delivery_street VARCHAR(50) NOT NULL,
    delivery_city VARCHAR(50) NOT NULL,
    delivery_state VARCHAR(2) NOT NULL,
    delivery_zip VARCHAR(10) NOT NULL,
    cc_number VARCHAR(16) NOT NULL,
    cc_expiration VARCHAR(5) NOT NULL,
    cc_cvv VARCHAR(3) NOT NULL,
    placed_at TIMESTAMP NOT NULL
);

CREATE TABLE IF NOT EXISTS taco (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,  -- Use AUTO_INCREMENT for MySQL
    name VARCHAR(50) NOT NULL,
    taco_order_id BIGINT NOT NULL,
    taco_order_key INT NOT NULL,
    created_at TIMESTAMP NOT NULL,
    FOREIGN KEY (taco_order_id) REFERENCES TACO_ORDER(id)
);

CREATE TABLE IF NOT EXISTS ingredient (
    id VARCHAR(4) PRIMARY KEY,  -- VARCHAR primary key for ingredient
    name VARCHAR(25) NOT NULL,
    type VARCHAR(10) NOT NULL
);

CREATE TABLE IF NOT EXISTS ingredient_ref (
    ingredient VARCHAR(4) NOT NULL,
    taco BIGINT NOT NULL,
    taco_key INT NOT NULL,
    FOREIGN KEY (ingredient) REFERENCES INGREDIENT(id),
    FOREIGN KEY (taco) REFERENCES TACO(id)
);

CREATE TABLE IF NOT EXISTS app_user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,  -- Auto-incremented primary key
    username VARCHAR(255) NOT NULL,        -- Username field
    password VARCHAR(255) NOT NULL,        -- Password field (store hashed passwords)
    fullname VARCHAR(255) NOT NULL,        -- Full name
    street VARCHAR(255) NOT NULL,          -- Street address
    city VARCHAR(255) NOT NULL,            -- City
    state VARCHAR(2) NOT NULL,             -- State (2-letter code)
    zip VARCHAR(10) NOT NULL,              -- ZIP code
    phone_number VARCHAR(15) NOT NULL      -- Phone number
);
