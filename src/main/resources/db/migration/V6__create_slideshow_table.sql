CREATE TABLE slideshows (
                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            title VARCHAR(255) NOT NULL,
                            description TEXT,
                            image_url VARCHAR(255) NOT NULL,
                            display_order INT,
                            active BOOLEAN DEFAULT true,
                            button_text VARCHAR(100),
                            button_link VARCHAR(255),
                            created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                            updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Insert some sample data (optional)
INSERT INTO slideshows (title, description, image_url, display_order, active, button_text, button_link)
VALUES
    ('Welcome Slide', 'Welcome to our website', '/uploads/slideshow/default1.jpg', 1, true, 'Learn More', '/about'),
    ('Featured Products', 'Check out our latest products', '/uploads/slideshow/default2.jpg', 2, true, 'Shop Now', '/products'),
    ('Special Offer', 'Get 20% off on all items', '/uploads/slideshow/default3.jpg', 3, true, 'View Offers', '/offers');