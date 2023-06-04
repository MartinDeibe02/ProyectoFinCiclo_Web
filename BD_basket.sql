-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jun 04, 2023 at 04:25 PM
-- Server version: 8.0.31
-- PHP Version: 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `basket`
--

-- --------------------------------------------------------

--
-- Table structure for table `comentarios`
--

DROP TABLE IF EXISTS `comentarios`;
CREATE TABLE IF NOT EXISTS `comentarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_producto` int NOT NULL,
  `comentario` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci NOT NULL,
  `usuario` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Coment_Prod` (`id_producto`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;

--
-- Dumping data for table `comentarios`
--

INSERT INTO `comentarios` (`id`, `id_producto`, `comentario`, `usuario`) VALUES
(1, 5, 'WOW!', 'prueba'),
(2, 5, 'hola', 'admin'),
(3, 27, 'Good!', 'antonio_ramirez'),
(7, 26, 'Muy caro', 'juan_lopez'),
(8, 4, 'Increible!', 'juan_lopez'),
(9, 7, 'Que bonita', 'juan_lopez'),
(10, 21, 'MJ GOAT', 'juan_lopez'),
(11, 23, 'No cumple mis expectativas.', 'juan_lopez'),
(12, 10, 'No vale la pena el dinero.', 'juan_lopez'),
(13, 27, 'Muy satisfecho con mi compra.', 'carlos_sanchez'),
(14, 19, 'Gran relación calidad-precio', 'carlos_sanchez'),
(15, 2, 'Perfecto para mis necesidades.', 'antonio_ramirez'),
(16, 3, 'Me arrepiento de haberlo comprado.', 'antonio_ramirez'),
(17, 6, 'Fácil de configurar y usar.', 'antonio_ramirez'),
(18, 24, 'Mala calidad', 'antonio_ramirez');

-- --------------------------------------------------------

--
-- Table structure for table `marcas`
--

DROP TABLE IF EXISTS `marcas`;
CREATE TABLE IF NOT EXISTS `marcas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `descripcion` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `marcas`
--

INSERT INTO `marcas` (`id`, `nombre`, `descripcion`) VALUES
(1, 'Nike', 'Nike is one of the leading brands in the basketball world.'),
(2, 'Adidas', 'Adidas is another recognized brand in the basketball industry.'),
(3, 'Jordan Brand', 'Jordan Brand is a division of Nike that exclusively focuses on basketball.'),
(4, 'Under Armour', 'Under Armour is a brand known for its innovation in high-performance apparel.'),
(5, 'Puma', 'Puma is a sports brand that has gained popularity in the basketball world in recent years.'),
(6, 'Louis Vuitton', 'Luxury fashion brand known for its high-quality luggage, handbags, and accessories.');

-- --------------------------------------------------------

--
-- Table structure for table `pedidos`
--

DROP TABLE IF EXISTS `pedidos`;
CREATE TABLE IF NOT EXISTS `pedidos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `numero_de_orden` varchar(50) NOT NULL,
  `fecha_de_compra` datetime NOT NULL,
  `usuario_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `usuario_id` (`usuario_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pedidos`
--

INSERT INTO `pedidos` (`id`, `numero_de_orden`, `fecha_de_compra`, `usuario_id`) VALUES
(1, '20230530151503', '2023-05-30 15:15:04', 21),
(2, '20230602131519', '2023-06-02 13:15:19', 2),
(3, '20230602173137', '2023-06-02 17:31:37', 34),
(4, '20230602173224', '2023-06-02 17:32:25', 34),
(5, '20230603141634', '2023-06-03 14:16:35', 35),
(6, '20230603142049', '2023-06-03 14:20:49', 35),
(7, '20230603142637', '2023-06-03 14:26:37', 39),
(9, '20230603143605', '2023-06-03 14:36:05', 40),
(10, '20230604181212', '2023-06-04 18:12:12', 44),
(11, '20230604182159', '2023-06-04 18:22:00', 42);

-- --------------------------------------------------------

--
-- Table structure for table `permisos`
--

DROP TABLE IF EXISTS `permisos`;
CREATE TABLE IF NOT EXISTS `permisos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `permiso` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `permisos`
--

INSERT INTO `permisos` (`id`, `permiso`) VALUES
(1, 'ADMIN'),
(2, 'USER');

-- --------------------------------------------------------

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
CREATE TABLE IF NOT EXISTS `productos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `descripcion` text NOT NULL,
  `Genero` enum('Hombre','Mujer','Niño') NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `marca_id` int NOT NULL,
  `product_image` varchar(255) NOT NULL,
  `featured` tinyint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `marca_id` (`marca_id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `productos`
--

INSERT INTO `productos` (`id`, `nombre`, `descripcion`, `Genero`, `precio`, `marca_id`, `product_image`, `featured`) VALUES
(2, 'LV x NBA Cloakroom', 'Part of the LV x NBA SEASON 2 Capsule Collection, the Cloakroom Dopp Kit bag is crafted in black leather with an embossed Monogram pattern. It is decorated with motifs and patches inspired by NBA jackets. The adjustable leather handle allows it to be carried by hand or attached to a carabiner.', 'Hombre', '2300.00', 6, 'https://res.cloudinary.com/daolhlyb6/image/upload/v1685037287/4_bolsitoMarron_kpwzl9.png', 1),
(3, 'LV X NBA Hang It ', 'The LVXNBA Hang It Bracelet features an eye-catching mix of materials. Perfectly embodying the spirit of the collaboration between the House and the NBA, this elegant piece combines exquisite Monogram canvas cording and shimmering NBA logo and LV Initials logo pendants. It is enhanced with a distinctive engraving on the clasp.', 'Hombre', '430.00', 6, 'https://res.cloudinary.com/daolhlyb6/image/upload/v1685037628/9_brazalete_fvrxqv.png', 0),
(4, 'LV x NBA Basketball Short-Sleeved', 'Unite luxury and basketball culture with the Louis Vuitton x NBA Basketball Short-Sleeved shirt. Iconic LV monogram meets dynamic NBA style for a fashionable, limited edition piece.', 'Mujer', '400.00', 6, 'https://res.cloudinary.com/daolhlyb6/image/upload/v1685037284/3_camisetaBlancaBeisbol_oakwce.png', 0),
(5, 'LV X NBA Multi-Logo T-Shirt', 'Make a bold statement with the LV x NBA Multi-Logo T-Shirt. Combining the iconic LV logo with multiple NBA team logos, this shirt showcases a unique fusion of luxury and basketball. Crafted with attention to detail, it exudes contemporary style and represents the perfect blend of high fashion and sports culture.', 'Hombre', '1500.00', 6, 'https://res.cloudinary.com/daolhlyb6/image/upload/v1685037283/2_camisetaNegra_kpsuxb.png', 1),
(6, 'LV x NBA Short-Sleeved T-shirt', 'Elevate your streetwear game with the LV x NBA Short-Sleeved T-shirt. This collaboration merges the iconic LV logo with the energy of the NBA, creating a stylish and dynamic piece. Crafted with quality materials, it offers a comfortable fit and showcases a modern aesthetic that seamlessly combines luxury and basketball culture.', 'Mujer', '2100.00', 6, 'https://res.cloudinary.com/daolhlyb6/image/upload/v1685037284/5_camisetaBlanca_bwyq67.png', 0),
(7, 'LV x NBA Multiple Wallet', 'Experience the perfect blend of luxury and basketball with the Louis Vuitton x NBA Multiple Wallet. Featuring the iconic LV monogram and NBA team logos, this wallet showcases a stylish collaboration. Crafted with precision and high-quality materials, it offers both functionality and fashion-forward appeal. Elevate your everyday essentials with this exclusive accessory', 'Mujer', '2300.00', 6, 'https://res.cloudinary.com/daolhlyb6/image/upload/v1685037289/1_carteraMarron_hemoeg.png', 1),
(8, 'LV x NBA Pocket Organizer', 'Introducing the Louis Vuitton x NBA Pocket Organizer – a stylish accessory that combines luxury and basketball in one compact design. Featuring the iconic LV monogram and NBA team logos, this pocket organizer showcases a unique collaboration.', 'Mujer', '890.00', 6, 'https://res.cloudinary.com/daolhlyb6/image/upload/v1685037294/6_carteraBlanca_mbatdb.png', 1),
(9, 'LV x NBA Nil Messenger', 'Introducing the Louis Vuitton x NBA Nil Messenger bag, a sleek and sporty collaboration that combines luxury and basketball culture. This messenger bag features the iconic LV monogram design alongside NBA team logos, creating a unique and fashionable statement. ', 'Hombre', '1900.00', 6, 'https://res.cloudinary.com/daolhlyb6/image/upload/v1685037290/7_bolsitoBlanco_zuwaul.png', 0),
(10, 'LV x NBA Waterfront Mule', 'Introducing the Louis Vuitton x NBA Waterfront Mule, a stylish footwear collaboration that merges luxury and basketball-inspired design. These mules feature the iconic LV monogram alongside NBA team logos, creating a unique and fashionable statement.', 'Hombre', '1200.00', 6, 'https://res.cloudinary.com/daolhlyb6/image/upload/v1685038019/8_clancla_jkjdte.png', 1),
(17, 'Lakers 2002 3Peat Leather Jacket', 'The Jeff Hamilton Lakers 2002 3-Peat Leather Jacket is a premium leather jacket by the Moroccan fashion designer that pays tribute to the Los Angeles Lakers back-to-back-to-back NBA Championships from 2000-2002.', 'Mujer', '5500.00', 4, 'http://res.cloudinary.com/daolhlyb6/image/upload/v1685883724/fjkwiocsrgdvgvgjxpic.png', 0),
(18, 'JEFF HAMILTON Jacket 75th', 'To commemorate the 75th anniversary of the NBA, designer Jeff Hamilton revives his iconic \'Championship\' jackets, which once waited for Michael Jordan and his teammates in their locker room.', 'Mujer', '5435.00', 4, 'http://res.cloudinary.com/daolhlyb6/image/upload/v1685883793/ldkux1n8ifju7lqamspy.png', 1),
(19, 'NBA Short Sleeve T-Shirt', 'The NBA Short Sleeve T-Shirt S is a stylish and comfortable apparel option for basketball fans and enthusiasts. Crafted with high-quality materials, this t-shirt features the iconic NBA logo prominently displayed on the front, showcasing your love for the game.', 'Hombre', '200.00', 5, 'http://res.cloudinary.com/daolhlyb6/image/upload/v1685883933/l9vnjbqqezkerhghbiee.png', 1),
(20, 'NBA BOMBER', 'The NBA BOMBER - Training Jacket is the ultimate outerwear for basketball training and beyond. Designed with both style and functionality in mind, this jacket is perfect for athletes and fans alike. It features a sleek and sporty design with the iconic NBA logo prominently displayed on the front.', 'Hombre', '500.00', 1, 'http://res.cloudinary.com/daolhlyb6/image/upload/v1685883976/qshbgsivirqlsiqn65nz.png', 0),
(21, 'Michael Jordan Signed 1991-92 ', '\r\nThe Michael Jordan Signed 1991-92 Mitchell & Ness Bulls Jersey is a truly iconic and highly coveted piece of sports memorabilia. This authentic jersey represents a significant era in basketball history when Michael Jordan led the Chicago Bulls to their first NBA Championship in the 1991-1992 season.', 'Mujer', '1999.00', 3, 'http://res.cloudinary.com/daolhlyb6/image/upload/v1685884031/w4dj7jwnvvodmhof9eks.png', 0),
(22, 'Michael Jordan Autographed Basketball', 'The Michael Jordan Autographed Basketball is the ultimate treasure for any basketball enthusiast or fan of the legendary Michael Jordan. This authentic basketball bears the personal signature of the basketball icon, making it a highly sought-after collector\'s item and a symbol of Jordan\'s unparalleled greatness.', 'Hombre', '7999.00', 3, 'http://res.cloudinary.com/daolhlyb6/image/upload/v1685884057/tkpzzmraax9ryu20j0nh.png', 0),
(23, 'NBA x Nike Blazer Mid', 'The NBA x Nike Blazer Mid is a collaboration between the National Basketball Association (NBA) and Nike, resulting in a stylish and iconic sneaker that combines the best of both worlds.', 'Mujer', '1999.00', 2, 'http://res.cloudinary.com/daolhlyb6/image/upload/v1685884136/lm58ypnnxjdezfvgpe0u.png', 1),
(24, 'NBA Teams Authentic Jersey', 'The Nike/NBA Teams Authentic Jersey is a highly sought-after collaboration between the renowned streetwear brand Supreme and the National Basketball Association (NBA) in partnership with Nike.', 'Mujer', '198.00', 1, 'http://res.cloudinary.com/daolhlyb6/image/upload/v1685884194/dbtpmwqnj49gl51wy7xj.png', 1),
(25, 'NBA ALL STAR 2022 VARSITY JACKET ', 'The NBA All-Star 2022 Varsity Jacket is a must-have item for basketball enthusiasts and fans of the annual NBA All-Star Game. This premium jacket is a commemorative piece that celebrates the gathering of the league\'s brightest stars and showcases your love for the game.', 'Hombre', '300.00', 2, 'http://res.cloudinary.com/daolhlyb6/image/upload/v1685884245/gzikxvpo9gvmwu5xxkqe.png', 0),
(26, 'Stephen Curry Autographed', 'The Stephen Curry Autographed Under Armour item is a highly sought-after collector\'s piece for fans of both Stephen Curry and Under Armour. This autographed item represents the talent and impact of one of the greatest basketball players of our time.', 'Hombre', '10000.00', 4, 'http://res.cloudinary.com/daolhlyb6/image/upload/v1685884512/oa3bkkhnwze5ea2rdgh6.png', 1),
(27, 'Louis Vuitton x NBA Monogram', 'The Louis Vuitton x NBA SS2021 Monogram collection is a highly anticipated collaboration between the luxury fashion brand Louis Vuitton and the National Basketball Association (NBA). ', 'Mujer', '8000.00', 5, 'http://res.cloudinary.com/daolhlyb6/image/upload/v1685884670/h19skhjphs6pq9pxees3.png', 1),
(28, 'LV Dopp Kit ', 'The LV Dopp Kit is a luxurious and functional accessory designed by Louis Vuitton. Also known as a toiletry bag or travel case, the LV Dopp Kit is crafted with the brand\'s renowned attention to detail and high-quality materials.', 'Mujer', '1900.00', 6, 'http://res.cloudinary.com/daolhlyb6/image/upload/v1685884721/xz5vbkecierojskbklpv.png', 0),
(29, 'Louis Vuitton x NBA Basketball Keepall', 'The Louis Vuitton x NBA Basketball Keepall is a highly coveted and limited-edition collaboration between Louis Vuitton and the National Basketball Association (NBA). ', 'Mujer', '4200.00', 6, 'http://res.cloudinary.com/daolhlyb6/image/upload/v1685884786/na3zs9kflnairjxbfxl0.png', 0);

-- --------------------------------------------------------

--
-- Table structure for table `productos_pedidos`
--

DROP TABLE IF EXISTS `productos_pedidos`;
CREATE TABLE IF NOT EXISTS `productos_pedidos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `pedido_id` int NOT NULL,
  `producto_id` int NOT NULL,
  `cantidad` int NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `pedido_id` (`pedido_id`),
  KEY `producto_id` (`producto_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `productos_pedidos`
--

INSERT INTO `productos_pedidos` (`id`, `pedido_id`, `producto_id`, `cantidad`, `precio`) VALUES
(1, 1, 10, 1, '1200.00'),
(2, 1, 2, 1, '2300.00'),
(3, 1, 3, 3, '1290.00'),
(4, 2, 5, 3, '4500.00'),
(5, 2, 4, 1, '400.00'),
(6, 2, 3, 4, '1720.00'),
(7, 2, 8, 1, '890.00'),
(8, 2, 7, 1, '2300.00'),
(11, 5, 2, 1, '2300.00'),
(12, 5, 6, 1, '2100.00'),
(13, 5, 4, 1, '400.00'),
(14, 5, 5, 2, '3000.00'),
(15, 6, 7, 1, '2300.00'),
(16, 6, 8, 2, '1780.00'),
(17, 7, 3, 1, '430.00'),
(18, 7, 10, 2, '2400.00'),
(21, 9, 5, 2, '3000.00'),
(22, 9, 6, 1, '2100.00'),
(23, 10, 2, 1, '2300.00'),
(24, 10, 5, 1, '1500.00'),
(25, 10, 19, 1, '200.00'),
(26, 10, 17, 1, '5500.00'),
(27, 10, 22, 2, '15998.00');

-- --------------------------------------------------------

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `correo_electronico` varchar(100) NOT NULL,
  `contrasena` varchar(100) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `estatus` tinyint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usuarios`
--

INSERT INTO `usuarios` (`id`, `nombre`, `correo_electronico`, `contrasena`, `direccion`, `telefono`, `estatus`) VALUES
(2, 'admin', 'admin@admin', '$2a$10$ifcrKKxVzw4hXdHBfgzyZ.Bjxlfdz8pr/8HCX7DCUhX9Tl/5Ozjd2', 'admin', 'admin', 1),
(21, 'martinez', 'martin@gmail.com', '$2a$10$eQOJUb5xh2ZwhMKl5CmSDOH1EvdECtlU/eqy2fUyY9QyT36HHlJLK', 'martin', '666444222', 1),
(34, 'laura_garcia', 'laura.garcia@example.com', '$2a$10$heT4uAk.ZH5yn3bh7uZswO6LmSyRcPuahy8wcDZ2Fz8BvLS3FaZuG', 'Calle Mayor 123', '666111222', 1),
(35, 'juan_lopez', 'juan.lopez@example.com', '$2a$10$9f/jkMC./DvYVWFvUuSPIuDhsI24PjORX0FyYmmekDDwMa3.cKHze', 'Avenida Libertad 456', '666333444', 1),
(36, 'ana_martinez', 'ana.martinez@example.com', '$2a$10$AZ1JVOses03LFmKVca9Ulupp/Qi/YB.toGgZpShnrOxWrGSrjkevi', 'Plaza España 789', '666555666', 0),
(37, 'pedro_fernandez', 'pedro.fernandez@example.com', '$2a$10$J5JsGJJcPDvCu.yypNRJSe237acMAcdk5zkFW6IRgB3wPqNYcrvRi', 'Calle Principal 321', '666777888', 0),
(38, 'maria_rodriguez', 'maria.rodriguez@example.com', '$2a$10$yDkyfum.sxA6yexBoC1AN./yz3RVdFUYHdnj6Da6/G0nwRX8clB.O', 'Avenida Central 654', '666999000', 0),
(39, 'carlos_sanchez', 'carlos.sanchez@example.com', '$2a$10$IyxFLJB.Ookqgdh9WqxFZ.CXlTpeHPLhhxf3rXnMfKjPxJ9D/Ikie', 'Calle Secundaria 987', '666111333', 1),
(40, 'marta_gomez', 'marta.gomez@example.com', '$2a$10$Vr6e5YFHwvZA8RKcLO8VNuuYxLyKiY9tLV8jcc3NhD1gEZbhr4GqO', 'Avenida Principal 456', '666222444', 1),
(41, 'antonio_ramirez', 'antonio.ramirez@example.com', '$2a$10$l1Fdl7n2hR0QGGtpj7sjou8G7iLqYjXLEFegnry.4/bOTYkIC5rpq', 'Plaza Mayor 789', '666333555', 1),
(42, 'sara_torres', 'sara.torres@example.com', '$2a$10$fwHWdNbOzAPG1B.qmaW/IeTfV5pB3oSlbiU8Q5Fh918vNdZ5oBxhe', 'Calle Libertad 321', '666444666', 1),
(43, 'javier_jimenez', 'javier.jimenez@example.com', '$2a$10$ObzxOwlDljNb5t9XtF6uye0.H/5QCLAnevpXYKTuHHlM0wNKEIqPy', 'Avenida Central 654', '666555888', 1),
(44, 'nerea', 'nerea@gmail.com', '$2a$10$V0fKh6o2vF6pUPl32TVmEO.KV3j..ZDxDAf77fwwepGYHlSam4uTu', '123', '98756', 1);

-- --------------------------------------------------------

--
-- Table structure for table `usuarios_permiso`
--

DROP TABLE IF EXISTS `usuarios_permiso`;
CREATE TABLE IF NOT EXISTS `usuarios_permiso` (
  `idUsuario` int NOT NULL,
  `idPermiso` int NOT NULL,
  PRIMARY KEY (`idUsuario`,`idPermiso`),
  KEY `usuarios_permisos_ibfk_2` (`idPermiso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usuarios_permiso`
--

INSERT INTO `usuarios_permiso` (`idUsuario`, `idPermiso`) VALUES
(2, 1),
(21, 1),
(21, 2),
(34, 2),
(35, 2),
(36, 2),
(37, 2),
(38, 2),
(39, 2),
(40, 2),
(41, 2),
(42, 2),
(43, 2),
(44, 2);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `comentarios`
--
ALTER TABLE `comentarios`
  ADD CONSTRAINT `Coment_Prod` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id`);

--
-- Constraints for table `pedidos`
--
ALTER TABLE `pedidos`
  ADD CONSTRAINT `pedidos_ibfk_1` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`);

--
-- Constraints for table `productos`
--
ALTER TABLE `productos`
  ADD CONSTRAINT `productos_ibfk_2` FOREIGN KEY (`marca_id`) REFERENCES `marcas` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `productos_pedidos`
--
ALTER TABLE `productos_pedidos`
  ADD CONSTRAINT `productos_pedidos_ibfk_1` FOREIGN KEY (`pedido_id`) REFERENCES `pedidos` (`id`),
  ADD CONSTRAINT `productos_pedidos_ibfk_2` FOREIGN KEY (`producto_id`) REFERENCES `productos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `usuarios_permiso`
--
ALTER TABLE `usuarios_permiso`
  ADD CONSTRAINT `usuarios_permisos_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  ADD CONSTRAINT `usuarios_permisos_ibfk_2` FOREIGN KEY (`idPermiso`) REFERENCES `permisos` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
