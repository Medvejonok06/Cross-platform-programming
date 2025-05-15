-- Додаємо нові товари
INSERT INTO products (name, description, price, stock)
VALUES
    ('Бутси червоні', 'Новинка сезону', 1699.00, 8),
    ('Футзалки чорні', 'Підходять для зали', 1299.00, 6);

-- Додаємо нову категорію
INSERT INTO categories (name) VALUES
    ('Новинка')
    ON CONFLICT (name) DO NOTHING;

-- Зв’язок товарів з категоріями (виправлені назви колонок)
INSERT INTO product_category (product_id, category_id)
SELECT p.product_id, c.category_id
FROM products p, categories c
WHERE p.name = 'Бутси червоні' AND c.name = 'Бутси'
UNION ALL
SELECT p.product_id, c.category_id
FROM products p, categories c
WHERE p.name = 'Бутси червоні' AND c.name = 'Новинка'
UNION ALL
SELECT p.product_id, c.category_id
FROM products p, categories c
WHERE p.name = 'Футзалки чорні' AND c.name = 'Футзалки';

-- Нові замовлення
INSERT INTO orders (customer_name) VALUES
                                       ('Віктор Сидоренко'),
                                       ('Ірина Петренко');

-- Товари в замовленнях (виправлені назви колонок)
INSERT INTO order_items (order_id, product_id, quantity)
SELECT o.order_id, p.product_id, 1
FROM orders o, products p
WHERE o.customer_name = 'Віктор Сидоренко' AND p.name = 'Бутси червоні'
UNION ALL
SELECT o.order_id, p.product_id, 2
FROM orders o, products p
WHERE o.customer_name = 'Ірина Петренко' AND p.name = 'Футзалки чорні';
