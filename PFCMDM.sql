-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: May 24, 2023 at 02:49 PM
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
-- Table structure for table `marcas`
--

DROP TABLE IF EXISTS `marcas`;
CREATE TABLE IF NOT EXISTS `marcas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `descripcion` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `productos`
--

INSERT INTO `productos` (`id`, `nombre`, `descripcion`, `Genero`, `precio`, `marca_id`, `product_image`, `featured`) VALUES
(1, 'prueba', 'prueba', 'Mujer', '20.00', 2, 'http://res.cloudinary.com/daolhlyb6/image/upload/v1684491655/o0ljx065xub7tggxfvyi.png', 0),
(2, 'LV x NBA Cloakroom', 'Part of the LV x NBA SEASON 2 Capsule Collection, the Cloakroom Dopp Kit bag is crafted in black leather with an embossed Monogram pattern. It is decorated with motifs and patches inspired by NBA jackets. The adjustable leather handle allows it to be carried by hand or attached to a carabiner.', 'Hombre', '2300.00', 6, 'http://res.cloudinary.com/daolhlyb6/image/upload/v1684858504/mayzcozgezkkdqs7edwb.webp', 1),
(3, 'LV X NBA Hang It ', 'The LVXNBA Hang It Bracelet features an eye-catching mix of materials. Perfectly embodying the spirit of the collaboration between the House and the NBA, this elegant piece combines exquisite Monogram canvas cording and shimmering NBA logo and LV Initials logo pendants. It is enhanced with a distinctive engraving on the clasp.', 'Hombre', '430.00', 6, 'http://res.cloudinary.com/daolhlyb6/image/upload/v1684858633/rv1ghsw2eu03hx0u7syb.webp', 0),
(4, 'LV x NBA Basketball Short-Sleeved', 'Unite luxury and basketball culture with the Louis Vuitton x NBA Basketball Short-Sleeved shirt. Iconic LV monogram meets dynamic NBA style for a fashionable, limited edition piece.', 'Mujer', '400.00', 6, 'http://res.cloudinary.com/daolhlyb6/image/upload/v1684858861/d7tb8dwnfkvcpudwfl7y.webp', 0),
(5, 'LV X NBA Multi-Logo T-Shirt', 'Make a bold statement with the LV x NBA Multi-Logo T-Shirt. Combining the iconic LV logo with multiple NBA team logos, this shirt showcases a unique fusion of luxury and basketball. Crafted with attention to detail, it exudes contemporary style and represents the perfect blend of high fashion and sports culture.', 'Hombre', '1500.00', 6, 'http://res.cloudinary.com/daolhlyb6/image/upload/v1684858988/b0w2gwswesd9x53jsxqf.webp', 1),
(6, 'LV x NBA Short-Sleeved T-shirt', 'Elevate your streetwear game with the LV x NBA Short-Sleeved T-shirt. This collaboration merges the iconic LV logo with the energy of the NBA, creating a stylish and dynamic piece. Crafted with quality materials, it offers a comfortable fit and showcases a modern aesthetic that seamlessly combines luxury and basketball culture.', 'Mujer', '2100.00', 6, 'http://res.cloudinary.com/daolhlyb6/image/upload/v1684859090/pz0o0twjirshntf7gkm8.webp', 0),
(7, 'LV x NBA Multiple Wallet', 'Experience the perfect blend of luxury and basketball with the Louis Vuitton x NBA Multiple Wallet. Featuring the iconic LV monogram and NBA team logos, this wallet showcases a stylish collaboration. Crafted with precision and high-quality materials, it offers both functionality and fashion-forward appeal. Elevate your everyday essentials with this exclusive accessory', 'Mujer', '2300.00', 6, 'http://res.cloudinary.com/daolhlyb6/image/upload/v1684859354/mjivvcrar2ulhh13ec9c.webp', 1),
(8, 'LV x NBA Pocket Organizer', 'Introducing the Louis Vuitton x NBA Pocket Organizer – a stylish accessory that combines luxury and basketball in one compact design. Featuring the iconic LV monogram and NBA team logos, this pocket organizer showcases a unique collaboration.', 'Mujer', '890.00', 6, 'http://res.cloudinary.com/daolhlyb6/image/upload/v1684859440/jaj6vvucrizss5kis0oc.webp', 1),
(9, 'LV x NBA Nil Messenger', 'Introducing the Louis Vuitton x NBA Nil Messenger bag, a sleek and sporty collaboration that combines luxury and basketball culture. This messenger bag features the iconic LV monogram design alongside NBA team logos, creating a unique and fashionable statement. ', 'Hombre', '1900.00', 6, 'http://res.cloudinary.com/daolhlyb6/image/upload/v1684859531/qh0hyix86lqbw6zog7rs.webp', 0),
(10, 'LV x NBA Waterfront Mule', 'Introducing the Louis Vuitton x NBA Waterfront Mule, a stylish footwear collaboration that merges luxury and basketball-inspired design. These mules feature the iconic LV monogram alongside NBA team logos, creating a unique and fashionable statement.', 'Hombre', '1200.00', 6, 'http://res.cloudinary.com/daolhlyb6/image/upload/v1684859670/tf3tyvavsbpszd6ickzn.webp', 1);

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usuarios`
--

INSERT INTO `usuarios` (`id`, `nombre`, `correo_electronico`, `contrasena`, `direccion`, `telefono`, `estatus`) VALUES
(2, 'prueba', 'prueba@prueba', '$2a$10$ifcrKKxVzw4hXdHBfgzyZ.Bjxlfdz8pr/8HCX7DCUhX9Tl/5Ozjd2', 'prueba', '1234', 1),
(3, 'prueba2', 'prueba2@prueba2', '$2a$10$R2plkZi.39vSMVl8uCbnaes/aJGwl1OqYZTpN8nF3wCguNGjXx7XS', 'prueba2', '123', 1);

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
(3, 2);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `pedidos`
--
ALTER TABLE `pedidos`
  ADD CONSTRAINT `pedidos_ibfk_1` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`);

--
-- Constraints for table `productos`
--
ALTER TABLE `productos`
  ADD CONSTRAINT `productos_ibfk_2` FOREIGN KEY (`marca_id`) REFERENCES `marcas` (`id`);

--
-- Constraints for table `productos_pedidos`
--
ALTER TABLE `productos_pedidos`
  ADD CONSTRAINT `productos_pedidos_ibfk_1` FOREIGN KEY (`pedido_id`) REFERENCES `pedidos` (`id`),
  ADD CONSTRAINT `productos_pedidos_ibfk_2` FOREIGN KEY (`producto_id`) REFERENCES `productos` (`id`);

--
-- Constraints for table `usuarios_permiso`
--
ALTER TABLE `usuarios_permiso`
  ADD CONSTRAINT `usuarios_permisos_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`id`),
  ADD CONSTRAINT `usuarios_permisos_ibfk_2` FOREIGN KEY (`idPermiso`) REFERENCES `permisos` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
