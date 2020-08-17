
SHOW DATABASES;
CREATE DATABASE IF NOT EXISTS hilltop_test_db;
USE hilltop_test_db;

SHOW TABLES;
SELECT * FROM products;
SELECT * FROM product_types;
SELECT * FROM categories;
SELECT * FROM sub_categories;
# DROP TABLE products;
DROP TABLE categories;

# PRODUCTS TABLE
CREATE TABLE `products` (
                            `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
                            `name` varchar(255),
                            `size` varchar(100),
                            `price_in_cents` double,
                            `in_store_count` int,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


#  PRODUCT_TYPES TABLES (broadest cats)
CREATE TABLE `product_types` (
                            `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
                            `name` varchar(255),
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


# CATEGORIES
CREATE TABLE `categories` (
                             `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
                             `name` varchar(255),
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


# SUB CATEGORIES
CREATE TABLE `sub_categories` (
                             `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
                             `name` varchar(255),
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


# MAPPING
CREATE TABLE `cats_mapping` (
                                 `products_id` int(11) unsigned NOT NULL,
                                 `product_types_id` int(11) unsigned NOT NULL,
                                 `cat_id` int(11) unsigned NOT NULL,
                                 `sub_cat_id` int(11) unsigned,
                                 FOREIGN KEY (products_id) REFERENCES products(id),
                                 FOREIGN KEY (product_types_id) REFERENCES product_types(id),
                                 FOREIGN KEY (cat_id) REFERENCES categories(id),
                                 FOREIGN KEY (sub_cat_id) REFERENCES sub_categories(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;