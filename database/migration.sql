
CREATE DATABASE IF NOT EXISTS hilltop_db;

# PRODUCTS TABLE

CREATE TABLE `products` (
                            `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
                            `name` varchar(255),
                            `size` varchar(100),
                            `price_in_cents` decimal,
                            `in_store_count` int,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#  PRODUCT_TYPES TABLES (broadest cats)
CREATE TABLE `product_types` (
                            `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
                            `name` varchar(255),
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

