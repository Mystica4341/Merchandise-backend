INSERT INTO categories (category_name, description, status, created_at)
VALUES
('Keychains', 'Basic keychains', true, now()),
('Standees', '15cm standee', true, now())
ON CONFLICT (category_name) DO NOTHING;

INSERT INTO items (item_name, item_description, item_price, stock_quantity, status, created_at)
VALUES
('Naru Keychains', 'One side resin keychain', 120000, 100, true, now()),
('15cm Standee', 'Basic one side resin 15cm standee', 250000, 50, true, now())
ON CONFLICT (item_name) DO NOTHING;

INSERT INTO users (full_name, phone_number, address, username, email, password, status, created_at)
VALUES
('John Doe', '0900000001', 'HCM City', 'Dummy Address', 'john.doe@merch.local', 'password123', true, now())
ON CONFLICT (username) DO NOTHING;

INSERT INTO item_categories (item_id, category_id)
SELECT i.id, c.id
FROM items i
JOIN categories c ON c.category_name = 'Keychains'
WHERE i.item_name = 'Naru Keychains'
AND NOT EXISTS (
SELECT 1
FROM item_categories ic
WHERE ic.item_id = i.id AND ic.category_id = c.id
);