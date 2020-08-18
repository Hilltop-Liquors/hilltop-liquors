
SHOW DATABASES;
CREATE DATABASE IF NOT EXISTS hilltop_test_db;
USE hilltop_test_db;

# DROP DATABASE hilltop_test_db;

SHOW TABLES;
SELECT * FROM products;
SELECT * FROM product_types;
SELECT * FROM categories;
SELECT * FROM sub_categories;
# SELECT * FROM cats_mapping;
DROP TABLE products;
DROP TABLE categories;
DROP TABLE sub_categories;
# DROP TABLE cats_mapping;

# PRODUCTS TABLE
CREATE TABLE `products` (
                            `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
                            `sku_num` varchar(255),
                            `name` varchar(255),
                            `sub_cat_id` int(11) unsigned,
                            `size` varchar(100),
                            `price_in_cents` double,
                            `in_store_count` int,
                            `img` varchar(100),
                            PRIMARY KEY (`id`),
                            FOREIGN KEY (sub_cat_id) REFERENCES sub_categories(id)
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
                             `product_type_id` int(11) unsigned,
                              PRIMARY KEY (`id`),
                              FOREIGN KEY (product_type_id) REFERENCES product_types(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# SUB CATEGORIES
CREATE TABLE `sub_categories` (
                             `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
                             `name` varchar(255),
                             `cat_id` int(11) unsigned,
                             PRIMARY KEY (`id`),
                             FOREIGN KEY(cat_id) REFERENCES categories(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


# MAPPING
# CREATE TABLE `cats_mapping` (
#                                  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
#                                  `product_types_id` int(11) unsigned NOT NULL,
#                                  `cat_id` int(11) unsigned NOT NULL,
#                                  `sub_cat_id` int(11) unsigned,
#                                  PRIMARY KEY (`id`),
#                                  FOREIGN KEY (product_types_id) REFERENCES product_types(id),
#                                  FOREIGN KEY (cat_id) REFERENCES categories(id),
#                                  FOREIGN KEY (sub_cat_id) REFERENCES sub_categories(id)
# ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

