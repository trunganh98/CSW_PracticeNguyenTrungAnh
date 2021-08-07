CREATE DATABASE  IF NOT EXISTS `ABCShop`;
USE `ABCShop`;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `price` varchar(45) DEFAULT NULL,
  `quantity` int(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `employee`
--

INSERT INTO `product` VALUES (1,'ASUS Tuf Gaming','16000','1'),
                              (2,'SamSung Note 10','12000','1'),
                              (3,'Iphone 11','20000','1'),
                              (4,'MSI Gaming','15000','1'),
                              (5,'Xiaomi Note 10','10000','1');

