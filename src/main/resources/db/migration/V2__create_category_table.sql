CREATE TABLE category (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL,
    slug VARCHAR(255) NOT NULL,
    image VARCHAR(255),
    status INT NOT NULL,
    show_home INT NOT NULL
);
