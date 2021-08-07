DROP DATABASE  IF EXISTS `ABCShop_bcrypt`;

CREATE DATABASE  IF NOT EXISTS `ABCShop_bcrypt`;
USE `ABCShop_bcrypt`;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` char(68) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--
-- NOTE: The passwords are encrypted using BCrypt
--
-- A generation tool is avail at: http://www.luv2code.com/generate-bcrypt-password
--
-- Default passwords here are: fun123
--

INSERT INTO `users` 
VALUES 
('trunganh','{bcrypt}$2a$10$EblZqNptyYvcLm/VwDCVAuBjzZOI7khzdyGPBr08PpIi0na624b8',1),
('phuong','{bcrypt}$2a$10$EblZqNptyYvcLm/VwDCVAuBjzZOI7khzdyGPBr08PpIi0na624b8',1),
('hai','{bcrypt}$2a$10$EblZqNptyYvcLm/VwDCVAuBjzZOI7khzdyGPBr08PpIi0na624b8',1),
('tuananh','{bcrypt}$2a$10$EblZqNptyYvcLm/VwDCVAuBjzZOI7khzdyGPBr08PpIi0na624b8',1),
('lam','{bcrypt}$2a$10$EblZqNptyYvcLm/VwDCVAuBjzZOI7khzdyGPBr08PpIi0na624b8',1);


--
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `authorities`
--

INSERT INTO `authorities` 
VALUES 
('trunganh','ROLE_STAFF'),
('phuong','ROLE_STAFF'),
('hai','ROLE_CUSTOMER'),
('tuananh','ROLE_CUSTOMER'),
('lam','ROLE_CUSTOMER');


