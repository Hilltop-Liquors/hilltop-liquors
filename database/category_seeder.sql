USE hilltop_app_db;
USE hilltop_db;
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


INSERT INTO `product` (`id`, `sku`, `name`, `sub_category_id`, `size_by_volume`, `price`, `in_store_count`, `image`)
VALUES
(1, '1071', 'CAPRICCIO WHITE SANGRIA BUBBLY 750', 43, '750ML', 9.49, 0, 'https://cdn.shopify.com/s/files/1/1154/8424/products/capriccio_white_sangria_small__36079.1540070141.jpg?v=1547241768'),
(2, '1077', 'CASTILLO GOLD PET 1.75L', 19, '1.75L', 19.49, 0, 'https://i5.walmartimages.com/asr/f24322f5-413f-468b-87c9-013d3c283d32.9bbde86f4f294370f0b7b8636d83cc66.jpeg'),
(3, '1082', 'CAP MORGAN WHITE RUM 750ML', 52, '750ML', 19.49, 0, 'https://austin-liquors.com/wp-content/uploads/2019/10/Captin-Morgan-white-Austin-liquors.jpg'),
(4, '1083', 'CAPPRICIO SANGRIA', 43, '750ML', 9.49, 0, 'https://cdn.shopify.com/s/files/1/0227/0581/products/Capriccio-Bubbly-Sangria-750ML-BTL_600x.JPG?v=1587351071'),
(5, '1095', 'CASTILLO GOLD 750ML', 19, '750ML', 11.99, 0, 'https://www.meijer.com/content/dam/meijer/product/0008/04/8019/54/0008048019540_0_A1C1_1200.png'),
(6, '1300', 'CRUZAN STRAWBERRY RUM 750ML', 16, '750ML', 14.99, 0, 'https://cdn11.bigcommerce.com/s-d4ygz9et8q/images/stencil/1280x1280/products/1618/1225/cruzan_strawberry_750___34028.1549648986.jpg?c=2'),
(7, '1380', 'FRAPPACHATA MOCHA ICED COFFEE100ML', 12, '100ML', 1.49, 0, 'https://www.bevindustry.com/ext/resources/2018/New-Products/May/FrappaChata_web.png?1527085214'),
(8, '1395', 'SAUZA BLUE SILVER 750ML', 47, '750ML', 21.99, 0, 'https://vintageliquor.com/wp-content/uploads/2017/08/Sauza-Blue-Silver-Tequila-175-l_1.png'),
(9, '1521', 'CROWN ROYAL 6PK 50ML', 9, '6PK 50ML', 13.49, 0, 'https://www.melandrose.com/istarimages/mp/92810-18063.jpg'),
(10, '1562', 'BAREFOOT VANILLA APPLE CHARDONNAY 4 PK', 11, '8PK 50ML', 6.99, 0, 'https://www.binnys.com/media/catalog/product/cache/eab16ae251e4410504af434c6d9419db/1/2/12012.jpg'),
(11, '1658', 'BLACK BOX 12 PK ROSE 500ML', 41, '550ML', 4.89, 0, 'https://centralliquors.com/wp-content/uploads/2018/09/Black-Box-Rose-500.png'),
(12, '1707', 'MORALES SILVER TEQ 1.0L', 47, '1.0L', 9.99, 0, 'https://4.bp.blogspot.com/-RzfPhDuweZA/T9-YWLYVoeI/AAAAAAAABos/NIXC9-0Rs-A/s1600/1735_la-cava-de-los-morales-tequila-blanco_1319754790.jpg'),
(13, '1716', 'MR MRS T MARGARITA MIX 64OZ', 27, '64OZ', 6.49, 0, 'https://d2lnr5mha7bycj.cloudfront.net/product-image/file/large_ec250a13-b416-4fb6-90a0-65310790550b.jpg'),
(14, '1724', 'NEW AMSTERDAM LONDON GIN 750ML', 24, '750ML', 18.99, 0, 'https://centralliquors.com/wp-content/uploads/2019/07/New-Amsterdam-London-Dry-Gin-750Ml.jpg'),
(15, '1738', 'MSTR MIX BLOODY MARY 1.75L', 5, '1.75L', 6.49, 0, 'https://products1.imgix.drizly.com/ci-master-of-mixes-bloody-mary-mix-4a6043efb05fb2cd.jpeg?auto=format%2Ccompress&dpr=2&fm=jpg&h=240&q=20'),
(16, '1807', 'EXOTICO REPOSADO TEQ 750ML', 39, '750ML', 16.99, 0, 'https://i5.walmartimages.com/asr/989cec15-01f5-4b12-ae3c-312f421e51e3_3.af28afd2e4de723d3a488547dd93cce7.jpeg'),
(17, '1814', 'FALL CREEK CHARD  750ML', 11, '750ML', 8.49, 0, 'https://www.wine-searcher.com/images/labels/47/80/10764780.jpg'),
(18, '1816', 'FAMILA CAMARENA SIL 750ML', 47, '750ML', 26.99, 0, 'https://images.freshop.com/00085000016824/243f88a2780fc4c763a2afebaf2a8ac4_medium.png'),
(19, '1864', 'BOTA BOX PINOT GRIGIO 3L', 35, '3L', 19.99, 0, 'https://goldrushliquor.greatlandgrocery.com/wp-content/uploads/2018/06/Bota-Box-Pinot-Grigio-3L.jpg'),
(20, '1953', 'EL MEXICANO TEQ BLANCO 750ML', 47, '750ML', 16.99, 0, 'https://resources.claroshop.com/medios-plazavip/s2/10643/1321277/5e447dc4c739c-5d5203109a412-16716-2f8488-el_mexicano_blanco_750_ml-1600x1600-1600x1600.jpg'),
(21, '1956', 'EL JIMADOR REPO W/GLS 750ML', 39, '750ML', 22.99, 0, 'https://hips.hearstapps.com/vader-prod.s3.amazonaws.com/1584997500-eljimsil_1200x1200.jpg'),
(22, '1959', 'EL JIMADOR REPOSADO 200ML', 39, '200ML', 8.49, 0, 'https://specsonline.com/wp-content/uploads/2019/04/074460706970.jpg'),
(23, '2020', 'CRUZAN RASPBERRY RUM 750ML', 16, '750ML', 16.99, 0, 'https://applejack.com/site/images/Cruzan-Raspberry-Rum-750-ml_1.png?resizeid=2&resizeh=293&resizew=293'),
(24, '2049', 'LLANO PINOT GRIGIO 750ML', 35, '750ML', 9.99, 0, 'https://s7d5.scene7.com/is/image/CentralMarket/000959100-1?$large$&hei=416&wid=416'),
(25, '2085', 'CRUZAN MANGO RUM 750ML', 16, '750ML', 11.9, 0, 'https://i5.walmartimages.com/asr/a103a4f8-0550-4eb9-9776-aab073667b15_1.6921acdfd31626f35e65a5bb14f70f32.jpeg'),
(26, '2128', 'CM PARROT BAY COCONUT 1.0L', 16, '1.0L', 21.99, 0, 'https://i5.walmartimages.com/asr/d58d235c-0a2a-4fd5-adca-193cfd276f9f_1.f736896ff80126919102b2b7d45ba985.jpeg'),
(27, '2204', 'MALIBU RTD PINK LMNADE 4PK CAN', 16, '4PK CAN', 10.49, 0, 'https://i.pinimg.com/originals/7c/57/17/7c57176c85872a97d9703445d1ff4010.jpg'),
(28, '2207', 'MAKERS MARK BOURBON 375ML', 7, '375ML', 18.99, 0, 'https://beeliquor.com/wp-content/uploads/2018/02/MAKERS20MARK20BOURBON20375ML.jpg'),
(29, '2208', 'MALIBU RTD PINEAPPLE 4PK CAN', 16, '4PK CAN', 10.49, 0, 'https://d2lnr5mha7bycj.cloudfront.net/product-image/file/large_1fda2333-2694-43db-9bfe-3e4382c22c49.jpg'),
(30, '2217', 'MALIBU COCONUT 1.0L', 16, '1.0L', 25.99, 0, 'https://i5.walmartimages.com/asr/dd9cdade-51b3-4b0d-953c-0838061835f7.3548c81ebfe87c906beb8c4c5add4b8b.jpeg?odnWidth=612&odnHeight=612&odnBg=ffffff'),
(31, '2488', 'PUCKER CHERRY VODKA 750ML', 16, '750ML', 15.33, 0, 'https://images.freshop.com/00080686119050/9d10662d6942de85a3a87f2bf8d51371_large.png'),
(32, '2519', 'SMIRNOFF SOUR GREEN APPLE 750ML', 16, '750ML', 14.99, 0, 'https://cdn.powered-by-nitrosell.com/product_images/26/6463/large-1520983169207-1.jpg'),
(33, '2522', 'SMIRNOFF RASPBERRY 750ML', 16, '750ML', 17.99, 0, 'https://cdn.powered-by-nitrosell.com/product_images/25/6073/large-smirnoff%20raspberry-750ml.jpg'),
(34, '2529', 'SMIRNOFF SOUR BERRY LEMON 750ML', 16, '750ML', 17.99, 0, 'https://www.meijer.com/content/dam/meijer/product/0008/20/0077/54/0008200077543_0_A1C1_1200.png'),
(35, '2551', '360 VODKA DBL CHOC 750ML', 16, '750ML', 13.99, 0, 'https://specsonline.com/wp-content/uploads/2018/11/008559213855.jpg'),
(36, '2554', '360 VODKA LEMON 750ML', 16, '750ML', 13.99, 0, 'https://images.gotoliquorstore.com/product/1000001458/1985f286-76a3-4a34-9536-b932d3d886d5_510.jpg'),
(37, '2555', '360 VODKA CHERRY 750ML', 16, '750ML', 14.99, 0, 'https://leesliquorlv.com/wp-content/uploads/2020/03/360-Bing-Cherry-Vodka.jpg'),
(38, '2560', '360 VODKA RASP 750ML', 16, '750ML', 22.99, 0, 'https://vodka360.com/wp-content/uploads/2018/02/360-Red-Raspberry.jpg'),
(39, '2634', 'BERINGER MOSCATO 1.5L', 29, '1.5L', 9.99, 0, 'https://www.bottleking.com/labels/B50524.png'),
(40, '2668', 'CRUZAN ORANGE RUM 750ML', 16, '750ML', 16.99, 0, 'https://www.wine-searcher.com/images/labels/07/64/10540764.jpg'),
(41, '2748', 'BACARDI BANANA RUM 70 200ML', 16, '200ML', 4.99, 0, 'https://www.abc.virginia.gov/library/product-images/2018-02-15/bacardi-banana.jpg?h=400&w=311&la=en&hash=87448BE4F63C34232F3D57FD200093695E9D6045'),
(42, '2849', 'CIROC BLK RASP 375ML', 16, '375ML', 17.99, 0, 'https://d2lnr5mha7bycj.cloudfront.net/product-image/file/large_41f9a5cf-7e7e-4275-a2d5-9a4be71574b9.jpg'),
(43, '2930', 'CAP MORGAN SILVER 1.0L', 47, '1.0L', 23.99, 0, 'https://www.haskells.com/media/catalog/product/cache/1/image/816x1200/040ec09b1e35df139433887a97daa66f/1/4/140326_0_1_1.jpg'),
(44, '2931', 'CAP MORGAN SILVER 1.75L', 47, '1.75L', 26.49, 0, 'https://target.scene7.com/is/image/Target/GUEST_672e4611-3302-43ab-a2e1-d29b275eb625?wid=488&hei=488&fmt=pjpeg'),
(45, '2973', 'ANDRE CHAMP PINK MOSCATO 750ML', 10, '750ML', 5.99, 0, 'https://products1.imgix.drizly.com/ci-andre-pink-moscato-california-champagne-2efd759093fe9352.jpeg?auto=format%2Ccompress&dpr=2&fm=jpg&h=240&q=20'),
(46, '3098', 'PINNACLE CAKE VODKA 750ML', 16, '750ML', 17.99, 0, 'https://images.freshop.com/00089708458450/fced68878ce3e073232aea875b2f2482_large.png'),
(47, '3462', 'ARBOR BLACKBERRY MERLOT WINE 750ML', 28, '750ML', 4.99, 0, 'https://images.freshop.com/00082100179237/02ec917438a92120fe51d33fc57db5aa_large.png'),
(48, '3571', 'CRAFTHOUSE MOSCOW MULE 750', 30, '750ML', 19.99, 0, 'https://www.kroger.com/product/images/large/front/0060940844381'),
(49, '3868', 'BAREFOOT CALIF CHARD 750ML', 11, '750ML', 8.59, 0, 'https://cdn.shoplightspeed.com/shops/609238/files/5977768/barefoot-chardonnay-2014-abv-13-750-ml.jpg'),
(50, '3874', 'KJ RIESLING 750ML', 40, '750ML', 9.89, 0, 'https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcS5mW5B2l1FvYPvs_oxSHvnrRRyidfmL9cJhA&usqp=CAU'),
(51, '3900', 'CALICO JACK COCONUT 750ML', 16, '750ML', 12.99, 0, 'https://cdn.powered-by-nitrosell.com/product_images/26/6463/large-176720-arru.jpg'),
(52, '4060', 'RONRICO RUM GOLD 750ML', 19, '750ML', 12.49, 0, 'https://cdn2.bigcommerce.com/server5500/tpbc2s65/products/1360/images/6304/ronrico-gold-175__16964.1333141566.1280.1280__91558.1472144159.380.500.jpg?c=2'),
(53, '10074346', 'AGAVALES GOLD TEQ 50ML', 19, '50ML', 2.49, 0, 'https://d2d8wwwkmhfcva.cloudfront.net/800x/d2lnr5mha7bycj.cloudfront.net/product-image/file/large_31dbf058-83c4-4ee3-a278-aff97a46c7c5.jpg'),
(54, '10074355', 'BSB BROWN SUGAR BOURBON 750', 7, '750ML', 22.99, 0, 'https://cdn.shopify.com/s/files/1/2516/7914/products/HDC_BSB_750_Rendered_websize_2000x.jpg?v=1562111966'),
(55, '10074384', 'PENASCO REPOSADO 750ML', 39, '750ML', 25.99, 0, 'https://d2lnr5mha7bycj.cloudfront.net/product-image/file/large_f386f3ce-624a-4e70-a780-5a6f71305eed.jpg'),
(56, '10074538', 'JULES PERCHARD TRIPLE SEC 1.0L', 50, '1.0L', 7.99, 0, 'https://cdn10.bigcommerce.com/s-tsmf5ul0/products/9577/images/10437/IMG_2376__70295.1534300654.380.507.jpg?c=2'),
(57, '10074585', 'NEW AMSTERDAM RASEBERRY VODKA 50ML', 16, '50ML', 0.99, 0, 'https://target.scene7.com/is/image/Target/GUEST_50f92ea5-b9b6-40fd-a69f-bfa801c98bc0?wid=488&hei=488&fmt=pjpeg'),
(58, '10074596', 'CRANE LAKE MERLOT 1.5L', 28, '1.5L', 9.99, 0, 'https://www.miltonsliquors.com/Images/StoreImages/Store_1818/ItemImage/LRG/74488.jpg'),
(59, '10074611', 'CRUZAN PEACH RUM 750ML', 16, '750ML', 16.99, 0, 'https://cdn11.bigcommerce.com/s-d4ygz9et8q/images/stencil/1280x1280/products/1616/1227/cruzan_peach__21675.1549649145.jpg?c=2'),
(60, '10074625', 'CRUZAN BANANA RUM 750ML', 16, '750ML', 14.99, 0, 'https://i5.walmartimages.com/asr/612a9575-aa63-4ad2-8326-1f93f12a205b_1.6a66672485ac827cc4f27397f2be9fa2.jpeg?odnWidth=612&odnHeight=612&odnBg=ffffff'),
(61, '10074631', 'ESTANCIA P GRIGIO 2007Y 750ML', 35, '750ML', 10.99, 0, 'https://target.scene7.com/is/image/Target/GUEST_2aa5c77b-b523-4074-afe9-67639a668461?wid=488&hei=488&fmt=pjpeg'),
(62, '10074671', '1800 Mango Margarita 1.75', 16, '1.75L', 22.99, 0, 'https://images.freshop.com/00811538018920/407049b86f64eaef9f3be22276e93b1e_large.png'),
(63, '10074711', 'JUAREZ TEQUILA SILVER 750ML', 47, '750ML', 11.99, 0, 'https://cdn.powered-by-nitrosell.com/product_images/26/6463/large-juarez%20white%201.75.jpg'),
(64, '10074714', 'BALLANTINE FINEST SCOTCH 1.75L', 46, '1.75L', 25.99, 0, 'https://jensensliquors.com/uploads/products/95151403b0db4f75bfd8da0b393af853/ballantines-1490733646-1490992093.jpg'),
(65, '10074718', 'FLUERS DE PRARIE FRENCH ROSE 750', 41, '750ML', 17.49, 0, 'https://target.scene7.com/is/image/Target/GUEST_4e5bac3c-4905-4cfd-a16f-c714248b3855?wid=488&hei=488&fmt=pjpeg'),
(66, '10074762', 'KAHLUA DTG MUDSLIDE 200ML SG', 31, '200ML', 1.99, 0, 'https://www.b-21.com/labels/live/LCORKAHLEI.jpg'),
(67, '10074815', 'MC CORMICK CHERRY VODKA 1.75ML', 16, '750ML', 14.99, 0, 'https://applejack.com/site/images/McCormick-Vodka-175-l_1.png?resizeid=2&resizeh=293&resizew=293'),
(68, '10074833', 'BACARDI BANANA RUM 70 750ML', 16, '750ML', 18.99, 0, 'https://target.scene7.com/is/image/Target/GUEST_5472e541-97c8-49f0-8190-97c3a32e2ae0?wid=488&hei=488&fmt=pjpeg'),
(69, '10074865', 'AGAVALES GOLD 110 PF TEQ 1.0L', 19, '1.0L', 18.49, 0, 'https://www.totalwine.com/dynamic/490x/media/sys_master/twmmedia/hea/h8b/12291690790942.png'),
(70, '10074891', 'GFV MOSCATO 1.5L', 29, '1.5L', 8.99, 0, 'https://i5.walmartimages.com/asr/cf8e0d73-1ef5-45d0-a689-87f4b8a46784_1.aa6fe1de9f05b16391696abc2848e2e2.jpeg'),
(71, '10074910', 'KAHLUA DTG RAS WH RUS 200ML SG', 53, '200ML', 1.89, 0, 'https://cdn.shopify.com/s/files/1/0144/7703/3526/products/9532_f6f7e6fb1de5f1d3160114b86414c5ea_600x.jpg?v=1578339038'),
(72, '10074957', 'AGAVALES REPOSADO TEQ 750ML', 39, '750ML', 17.99, 0, 'https://cdn10.bigcommerce.com/s-tsmf5ul0/products/6829/images/13203/IMG_9230__24374.1583790466.380.507.jpg?c=2'),
(73, '10074959', 'COLBY RED RED BLEND 750ML', 38, '750ML', 12.99, 0, 'https://www.elmaliquor.com/wp-content/uploads/2016/11/Colby-Red-Blend-750ML.jpg'),
(74, '10074966', 'POTTERS CROWN CANADIAN 375ML', 9, '375ML', 4.49, 0, 'https://cdn10.bigcommerce.com/s-tsmf5ul0/products/4783/images/5107/yhst-128588312714207_2232_56822150__52298.1451339575.380.507.jpg?c=2'),
(75, '10074996', 'CAP MORGAN WATER SMASH 750ML', 16, '750ML', 15.99, 0, 'https://images.freshop.com/00080686119135/82ab64e1f480bbb5097f4791e992db38_large.png'),
(76, '10075011', 'BACARDI GOLD 1.0L', 16, '1.0L', 19.99, 0, 'https://cdn11.bigcommerce.com/s-r2972og70q/images/stencil/1280x1280/products/2088/2441/bacardi-gold__00282.1585930580.jpg?c=1'),
(77, '10075015', 'MALIBU STRAWBERRY KIWI 4 PK', 16, '4PK CAN', 10.49, 0, 'https://chilledmagazine.com/wp-content/uploads/2016/02/Malibu-Strawberry-Kiwi-4pk.jpg'),
(78, '10075055', 'PUCKER CITRUS VODKA 750ML', 16, '750ML', 1547, 0, 'https://images.freshop.com/00080686119135/82ab64e1f480bbb5097f4791e992db38_large.png'),
(79, '10075082', 'BONTERRA CABERNET SAUV 750ML', 8, '750ML', 14.49, 0, 'https://d2d8wwwkmhfcva.cloudfront.net/800x/d2lnr5mha7bycj.cloudfront.net/product-image/file/large_c1f2370b-64ba-4e70-b0ed-d3e2bb440af7.png'),
(80, '10075106', 'BURNETTS RASPBERRY VODKA 750ML', 16, '750ML', 10.99, 0, 'https://www.abc.virginia.gov/library/product-images/vodka/regular/burnetts_raspberry.jpg?'),
(81, '10075112', 'CASTILLO SILVER 750ML', 47, '750ML', 11.99, 0, 'https://ipcdn.freshop.com/resize?url=https://images.freshop.com/00080480165406/26bdd4f88f2a7ac448b0e5c8d0638592_large.png&width=512&type=webp&quality=40'),
(82, '10075132', 'ARBOR EXOTIC FRUIT WHITE  ZINFANDEL', 54, '750ML', 4.99, 0, 'https://www.binnys.com/media/catalog/product/cache/eab16ae251e4410504af434c6d9419db/1/1/11011.jpg'),
(83, '10075138', 'CAP MORGAN COCONUT RUM 750ML', 16, '750ML', 19.49, 0, 'https://cdn2.bigcommerce.com/server5500/tpbc2s65/products/5100/images/6696/cmgr_bottle_coconut__29219.1473271916.1280.1280.jpg?c=2'),
(84, '10075182', 'BALLANTINE FINEST SCOTCH 750ML', 46, '750ML', 18.99, 0, 'https://vintageliquor.com/wp-content/uploads/2017/09/BALLANTINES_FINEST_SCOTCH_750ml-1-e1570614631908.jpg'),
(85, '10075263', 'JIM BEAM RYE 750ML', 42, '750ML', 25.99, 0, 'https://vintageliquor.com/wp-content/uploads/2013/12/JIM-BEAM-RYE-750ml.jpg'),
(86, '10075310', 'CAPT MORGAN SPICED RUM 50ml 1.75', 48, '1.75L', 26.99, 0, 'https://d2lnr5mha7bycj.cloudfront.net/product-image/file/large_967a613e-1b85-4f59-b53b-658a32e2f190.jpg'),
(87, '83664120260', 'CRUZAN BLACK CHERRY RUM 750ML', 16, '750ML', 11.99, 0, 'https://cdn2.bigcommerce.com/server5500/tpbc2s65/products/1102/images/1135/CruzanBlackCherry__98574__38254.1358534182.1280.1280.jpg?c=2');


CREATE TABLE `product` (
 `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
`sku` Long,
`name` varchar(255),
`sub_category_id` int(11) unsigned,
`size_by_volume` varchar(100),
`price` double,
`in_store_count` int,
`image` varchar(5000),
PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8