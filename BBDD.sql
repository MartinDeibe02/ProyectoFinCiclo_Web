-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jun 02, 2023 at 03:58 PM
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;

--
-- Dumping data for table `comentarios`
--

INSERT INTO `comentarios` (`id`, `id_producto`, `comentario`, `usuario`) VALUES
(1, 5, 'WOW!', 'prueba'),
(2, 5, 'hola', 'admin');

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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `marcas`
--

INSERT INTO `marcas` (`id`, `nombre`, `descripcion`) VALUES
(1, 'Nike', 'Nike is one of the leading brands in the basketball world.'),
(2, 'Adidas', 'Adidas is another recognized brand in the basketball industry.'),
(3, 'Jordan Brand', 'Jordan Brand is a division of Nike that exclusively focuses on basketball.'),
(4, 'Under Armour', 'Under Armour is a brand known for its innovation in high-performance apparel.'),
(5, 'Puma', 'Puma is a sports brand that has gained popularity in the basketball world in recent years.'),
(6, 'Louis Vuitton', 'Luxury fashion brand known for its high-quality luggage, handbags, and accessories.'),
(7, 'prueba', 'prueba');

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pedidos`
--

INSERT INTO `pedidos` (`id`, `numero_de_orden`, `fecha_de_compra`, `usuario_id`) VALUES
(1, '20230530151503', '2023-05-30 15:15:04', 21),
(2, '20230602131519', '2023-06-02 13:15:19', 2),
(3, '20230602173137', '2023-06-02 17:31:37', 34),
(4, '20230602173224', '2023-06-02 17:32:25', 34);

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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `productos`
--

INSERT INTO `productos` (`id`, `nombre`, `descripcion`, `Genero`, `precio`, `marca_id`, `product_image`, `featured`) VALUES
(1, 'prueba 3002', 'prueba', 'Mujer', '3000.00', 7, 'http://res.cloudinary.com/daolhlyb6/image/upload/v1684491655/o0ljx065xub7tggxfvyi.png', 0),
(2, 'LV x NBA Cloakroom', 'Part of the LV x NBA SEASON 2 Capsule Collection, the Cloakroom Dopp Kit bag is crafted in black leather with an embossed Monogram pattern. It is decorated with motifs and patches inspired by NBA jackets. The adjustable leather handle allows it to be carried by hand or attached to a carabiner.', 'Hombre', '2300.00', 6, 'https://res.cloudinary.com/daolhlyb6/image/upload/v1685037287/4_bolsitoMarron_kpwzl9.png', 1),
(3, 'LV X NBA Hang It ', 'The LVXNBA Hang It Bracelet features an eye-catching mix of materials. Perfectly embodying the spirit of the collaboration between the House and the NBA, this elegant piece combines exquisite Monogram canvas cording and shimmering NBA logo and LV Initials logo pendants. It is enhanced with a distinctive engraving on the clasp.', 'Hombre', '430.00', 6, 'https://res.cloudinary.com/daolhlyb6/image/upload/v1685037628/9_brazalete_fvrxqv.png', 0),
(4, 'LV x NBA Basketball Short-Sleeved', 'Unite luxury and basketball culture with the Louis Vuitton x NBA Basketball Short-Sleeved shirt. Iconic LV monogram meets dynamic NBA style for a fashionable, limited edition piece.', 'Mujer', '400.00', 6, 'https://res.cloudinary.com/daolhlyb6/image/upload/v1685037284/3_camisetaBlancaBeisbol_oakwce.png', 0),
(5, 'LV X NBA Multi-Logo T-Shirt', 'Make a bold statement with the LV x NBA Multi-Logo T-Shirt. Combining the iconic LV logo with multiple NBA team logos, this shirt showcases a unique fusion of luxury and basketball. Crafted with attention to detail, it exudes contemporary style and represents the perfect blend of high fashion and sports culture.', 'Hombre', '1500.00', 6, 'https://res.cloudinary.com/daolhlyb6/image/upload/v1685037283/2_camisetaNegra_kpsuxb.png', 1),
(6, 'LV x NBA Short-Sleeved T-shirt', 'Elevate your streetwear game with the LV x NBA Short-Sleeved T-shirt. This collaboration merges the iconic LV logo with the energy of the NBA, creating a stylish and dynamic piece. Crafted with quality materials, it offers a comfortable fit and showcases a modern aesthetic that seamlessly combines luxury and basketball culture.', 'Mujer', '2100.00', 6, 'https://res.cloudinary.com/daolhlyb6/image/upload/v1685037284/5_camisetaBlanca_bwyq67.png', 0),
(7, 'LV x NBA Multiple Wallet', 'Experience the perfect blend of luxury and basketball with the Louis Vuitton x NBA Multiple Wallet. Featuring the iconic LV monogram and NBA team logos, this wallet showcases a stylish collaboration. Crafted with precision and high-quality materials, it offers both functionality and fashion-forward appeal. Elevate your everyday essentials with this exclusive accessory', 'Mujer', '2300.00', 6, 'https://res.cloudinary.com/daolhlyb6/image/upload/v1685037289/1_carteraMarron_hemoeg.png', 1),
(8, 'LV x NBA Pocket Organizer', 'Introducing the Louis Vuitton x NBA Pocket Organizer – a stylish accessory that combines luxury and basketball in one compact design. Featuring the iconic LV monogram and NBA team logos, this pocket organizer showcases a unique collaboration.', 'Mujer', '890.00', 6, 'https://res.cloudinary.com/daolhlyb6/image/upload/v1685037294/6_carteraBlanca_mbatdb.png', 1),
(9, 'LV x NBA Nil Messenger', 'Introducing the Louis Vuitton x NBA Nil Messenger bag, a sleek and sporty collaboration that combines luxury and basketball culture. This messenger bag features the iconic LV monogram design alongside NBA team logos, creating a unique and fashionable statement. ', 'Hombre', '1900.00', 6, 'https://res.cloudinary.com/daolhlyb6/image/upload/v1685037290/7_bolsitoBlanco_zuwaul.png', 0),
(10, 'LV x NBA Waterfront Mule', 'Introducing the Louis Vuitton x NBA Waterfront Mule, a stylish footwear collaboration that merges luxury and basketball-inspired design. These mules feature the iconic LV monogram alongside NBA team logos, creating a unique and fashionable statement.', 'Hombre', '1200.00', 6, 'https://res.cloudinary.com/daolhlyb6/image/upload/v1685038019/8_clancla_jkjdte.png', 1);

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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

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
(9, 3, 1, 1, '3000.00');

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
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usuarios`
--

INSERT INTO `usuarios` (`id`, `nombre`, `correo_electronico`, `contrasena`, `direccion`, `telefono`, `estatus`) VALUES
(2, 'admin', 'admin@admin', '$2a$10$ifcrKKxVzw4hXdHBfgzyZ.Bjxlfdz8pr/8HCX7DCUhX9Tl/5Ozjd2', 'admin', 'admin', 1),
(21, 'martin', 'martin@gmail.com', '$2a$10$eQOJUb5xh2ZwhMKl5CmSDOH1EvdECtlU/eqy2fUyY9QyT36HHlJLK', 'martin', '123', 1),
(34, 'laura_garcia', 'laura.garcia@example.com', '$2a$10$heT4uAk.ZH5yn3bh7uZswO6LmSyRcPuahy8wcDZ2Fz8BvLS3FaZuG', 'Calle Mayor 123', '666111222', 1),
(35, 'juan_lopez', 'juan.lopez@example.com', '$2a$10$9f/jkMC./DvYVWFvUuSPIuDhsI24PjORX0FyYmmekDDwMa3.cKHze', 'Avenida Libertad 456', '666333444', 1),
(36, 'ana_martinez', 'ana.martinez@example.com', '$2a$10$AZ1JVOses03LFmKVca9Ulupp/Qi/YB.toGgZpShnrOxWrGSrjkevi', 'Plaza España 789', '666555666', 1),
(37, 'pedro_fernandez', 'pedro.fernandez@example.com', '$2a$10$J5JsGJJcPDvCu.yypNRJSe237acMAcdk5zkFW6IRgB3wPqNYcrvRi', 'Calle Principal 321', '666777888', 1),
(38, 'maria_rodriguez', 'maria.rodriguez@example.com', '$2a$10$yDkyfum.sxA6yexBoC1AN./yz3RVdFUYHdnj6Da6/G0nwRX8clB.O', 'Avenida Central 654', '666999000', 1),
(39, 'carlos_sanchez', 'carlos.sanchez@example.com', '$2a$10$IyxFLJB.Ookqgdh9WqxFZ.CXlTpeHPLhhxf3rXnMfKjPxJ9D/Ikie', 'Calle Secundaria 987', '666111333', 1),
(40, 'marta_gomez', 'marta.gomez@example.com', '$2a$10$Vr6e5YFHwvZA8RKcLO8VNuuYxLyKiY9tLV8jcc3NhD1gEZbhr4GqO', 'Avenida Principal 456', '666222444', 1),
(41, 'antonio_ramirez', 'antonio.ramirez@example.com', '$2a$10$l1Fdl7n2hR0QGGtpj7sjou8G7iLqYjXLEFegnry.4/bOTYkIC5rpq', 'Plaza Mayor 789', '666333555', 1),
(42, 'sara_torres', 'sara.torres@example.com', '$2a$10$fwHWdNbOzAPG1B.qmaW/IeTfV5pB3oSlbiU8Q5Fh918vNdZ5oBxhe', 'Calle Libertad 321', '666444666', 1),
(43, 'javier_jimenez', 'javier.jimenez@example.com', '$2a$10$ObzxOwlDljNb5t9XtF6uye0.H/5QCLAnevpXYKTuHHlM0wNKEIqPy', 'Avenida Central 654', '666555888', 1);

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
(43, 2);

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
