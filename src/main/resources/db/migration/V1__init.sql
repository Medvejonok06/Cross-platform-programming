-- Таблиця товарів
CREATE TABLE products (
                          product_id SERIAL PRIMARY KEY,
                          name VARCHAR(100) NOT NULL,
                          description TEXT,
                          price NUMERIC(10,2) NOT NULL,
                          stock INT NOT NULL DEFAULT 0
);

-- Таблиця замовлень
CREATE TABLE orders (
                        order_id SERIAL PRIMARY KEY,
                        customer_name VARCHAR(100) NOT NULL,
                        order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Таблиця товарів у замовленні
CREATE TABLE order_items (
                             order_item_id SERIAL PRIMARY KEY,
                             order_id INT REFERENCES orders(order_id) ON DELETE CASCADE,
                             product_id INT REFERENCES products(product_id) ON DELETE CASCADE,
                             quantity INT NOT NULL CHECK (quantity > 0)
);

-- Таблиця категорій
CREATE TABLE categories (
                            category_id SERIAL PRIMARY KEY,
                            name VARCHAR(50) NOT NULL UNIQUE
);

-- Таблиця зв’язку: продукти ↔ категорії
CREATE TABLE product_category (
                                  product_id INT REFERENCES products(product_id) ON DELETE CASCADE,
                                  category_id INT REFERENCES categories(category_id) ON DELETE CASCADE,
                                  PRIMARY KEY (product_id, category_id)
);
