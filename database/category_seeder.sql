USE hilltop_app_db;

# TRUNCATE TABLE orders;
# TRUNCATE TABLE order_product;

# role
INSERT INTO `role` (`id`, `name`)
VALUES
('1','ROLE_USER'),
('2','ROLE_ADMIN');

# PRODUCTS_TYPES
INSERT INTO `product_type` (`id`, `name`)
VALUES
(1, 'BEER'),
(2, 'LIQUOR'),
(3, 'WINE'),
(4, 'NON ALCOHOL'),
(5, 'SNACKS'),
(6, 'MISC ITEMS');

# CATEGORIES
INSERT INTO `cat` (`id`, `name`, `product_type_id`)
VALUES
(1, 'ALE', 1),
(2, 'BOTTLE OPENER', 6),
(3, 'BRANDY', 2),
(4, 'CIDER', 1),
(5, 'CORKSCREW', 6),
(6, 'CUPS', 6),
(7, 'DRINKS', 4),
(8, 'FLASK', 6),
(9, 'FRUIT', 3),
(10, 'GIFTS', 6),
(11, 'GIN', 2),
(12, 'IPA', 1),
(13, 'JUICE', 4),
(14, 'KOOZIES', 6),
(15, 'LAGER', 1),
(16, 'LIQUEUR', 2),
(17, 'MEAD', 3),
(18, 'MEZCAL', 2),
(19, 'MISC ITEMS', 6),
(20, 'MIXERS', 4),
(21, 'MOONSHINE', 2),
(22, 'NON ALCOHOL', 4),
(23, 'PICKLE', 4),
(24, 'PINK', 3),
(25, 'POURER', 6),
(26, 'RED', 3),
(27, 'RTD', 6),
(28, 'RUM', 2),
(29, 'SANGRIA', 3),
(30, 'SHOT GLASS', 6),
(31, 'SNACKS', 5),
(32, 'SPARKLING', 3),
(33, 'SPECIALTY BEER', 1),
(34, 'SYRUP', 6),
(35, 'TEQUILA', 2),
(36, 'TREATS', 5),
(37, 'VODKA', 2),
(38, 'WHISKEY', 2),
(39, 'WHITE', 3),
(40, 'WINE', 3),
(41, 'WINE OPENER', 6);


# SUB_CATEGORIES
INSERT INTO `sub_category` (`id`, `name`, `cat_id`)
VALUES
(1, 'AMBER', 1),
(2, 'AMERICAN', 38),
(3, 'ANEJO', 35),
(4, 'BLANCO', 28),
(5, 'BLOODY MARY', 20),
(6, 'BOCK', 1),
(7, 'BOURBON', 38),
(8, 'CABERNET SAUVIGNON', 26),
(9, 'CANADIAN', 38),
(10, 'CHAMPAGNE', 32),
(11, 'CHARDONNAY', 39),
(12, 'COFFEE', 16),
(13, 'COGNAC', 3),
(14, 'DAQUIRI', 27),
(15, 'DARK', 28),
(16, 'FLAVORED', 37),
(17, 'FRUIT BEER', 9),
(18, 'FRUIT COCKTAIL', 9),
(19, 'GOLD', 35),
(20, 'HARD ICED TEA', 33),
(21, 'HARD SELTZER', 33),
(22, 'HERBAL / SPICE', 16),
(23, 'KOLSH', 15),
(24, 'LONDON DRY', 11),
(25, 'MALBEC', 26),
(26, 'MALT LIQUOR', 38),
(27, 'MARGARITA', 27),
(28, 'MERLOT', 26),
(29, 'MOSCATO', 27),
(30, 'MOSCOW MULE', 27),
(31, 'MUD SLIDES', 27),
(32, 'PALE LAGER', 15),
(33, 'PINA COLADA', 27),
(34, 'PINK MOSCATO', 24),
(35, 'PINOT GRIGIO', 39),
(36, 'PINOT NOIR', 39),
(37, 'PROSECCO', 32),
(38, 'RED BLENDS', 26),
(39, 'REPOSADO', 35),
(40, 'RIESLING', 39),
(41, 'ROSE', 24),
(42, 'RYE', 38),
(43, 'SANGRIA', 40),
(44, 'SAUVIGNON BLANC', 39),
(45, 'SCHNAPPS', 16),
(46, 'SCOTCH', 38),
(47, 'SILVER / BLANCO', 35),
(48, 'SPICED', 28),
(49, 'STOUT', 1),
(50, 'TRIPLE SEC', 16),
(51, 'WHEAT ALE', 1),
(52, 'WHITE', 40),
(53, 'WHITE RUSSIAN', 27),
(54, 'WHITE ZINFADEL', 24);
