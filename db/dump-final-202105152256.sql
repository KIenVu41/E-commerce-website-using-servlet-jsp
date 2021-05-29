-- MySQL dump 10.13  Distrib 5.5.62, for Win64 (AMD64)
--
-- Host: localhost    Database: final
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.17-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bill`
--

DROP TABLE IF EXISTS `bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bill` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `buydate` date NOT NULL,
  `total_price` double NOT NULL,
  `id_user` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_user` (`id_user`),
  CONSTRAINT `FK_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill`
--

LOCK TABLES `bill` WRITE;
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
INSERT INTO `bill` VALUES (10,'2021-05-08',441,7),(11,'2021-05-08',555,12),(12,'2021-05-08',590,14),(13,'2021-05-09',240,7),(14,'2021-05-09',460,3),(15,'2021-05-09',790,15),(16,'2021-05-09',250,15),(17,'2021-05-09',450,15),(18,'2021-05-09',0,15),(19,'2021-05-11',570,15),(20,'2021-05-12',352,15),(21,'2021-05-12',520,15),(22,'2021-05-12',120,15),(23,'2021-05-12',340,15),(24,'2021-05-12',320,15),(25,'2021-05-12',340,15);
/*!40000 ALTER TABLE `bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bill_product`
--

DROP TABLE IF EXISTS `bill_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bill_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `quantity` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `id_bill` int(11) NOT NULL,
  `id_product` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_product` (`id_product`),
  KEY `FK_bill` (`id_bill`),
  CONSTRAINT `FK_bill` FOREIGN KEY (`id_bill`) REFERENCES `bill` (`id`),
  CONSTRAINT `FK_product` FOREIGN KEY (`id_product`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill_product`
--

LOCK TABLES `bill_product` WRITE;
/*!40000 ALTER TABLE `bill_product` DISABLE KEYS */;
INSERT INTO `bill_product` VALUES (53,1,250,10,12),(54,1,240,10,14),(55,2,250,11,12),(56,1,240,11,14),(57,2,350,12,13),(58,1,240,13,14),(59,1,120,14,17),(60,1,340,14,18),(61,1,450,15,16),(62,1,340,15,18),(63,1,250,16,12),(64,1,450,17,16),(68,2,240,12,14),(73,1,450,19,16),(74,1,120,19,17),(75,1,352,20,15),(76,1,280,21,19),(77,1,240,21,14),(78,1,120,22,17),(79,1,340,23,18),(80,1,320,24,21),(81,1,340,25,18);
/*!40000 ALTER TABLE `bill_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Apple'),(2,'HTC'),(3,'LG'),(4,'Nokia'),(5,'Samsung'),(6,'Sony');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coupon`
--

DROP TABLE IF EXISTS `coupon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `coupon` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(45) NOT NULL,
  `discount` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `bill_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `kn_coupon` (`user_id`),
  KEY `kn_bill` (`bill_id`),
  CONSTRAINT `kn_bill` FOREIGN KEY (`bill_id`) REFERENCES `bill` (`id`),
  CONSTRAINT `kn_coupon` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coupon`
--

LOCK TABLES `coupon` WRITE;
/*!40000 ALTER TABLE `coupon` DISABLE KEYS */;
INSERT INTO `coupon` VALUES (1,'VG24T',25,12,'used',11),(2,'HTLG50',50,NULL,NULL,NULL),(3,'TKLP10',10,7,'used',10),(5,'ZYLFR',10,NULL,NULL,NULL),(6,'GKPOED',20,NULL,NULL,NULL),(7,'RTELQF',25,NULL,NULL,NULL),(8,'QSKMO',10,NULL,NULL,NULL);
/*!40000 ALTER TABLE `coupon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL,
  `quantity` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `image` varchar(100) DEFAULT NULL,
  `id_category` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  KEY `FK_category` (`id_category`),
  CONSTRAINT `FK_category` FOREIGN KEY (`id_category`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (12,'Nokia Lumia 230',10,250,'product-2.jpg',4),(13,'Samsung s7',10,350,'product-1.jpg',5),(14,'LG L8',8,240,'product-3.jpg',3),(15,'Sony Xperia 1',11,352,'product-4.jpg',6),(16,'IPhone 7',10,450,'product-5.jpg',1),(17,'Samsung J2',10,120,'product-1.jpg',5),(18,'Nokia 320',10,340,'product-2.jpg',4),(19,'LG V2',10,280,'product-3.jpg',3),(20,'IPhone 8',10,560,'product-5.jpg',1),(21,'Sony Xperia 2',10,320,'product-4.jpg',6),(22,'Samsung J5',10,340,'product-3.jpg',5),(23,'IPhone 6',10,530,'product-5.jpg',1);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `role` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_2` (`username`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Kiên','kienvu','123','09845213','kienvu@gmail.com','Ha Noi','admin'),(2,'Nam','namtran','123','095847382','nam@gmail.com','Ha Noi','member'),(3,'Dung','dungg','123',NULL,NULL,'null-null-null','member'),(7,'Linh','linh','123',NULL,NULL,'null-null-null','member'),(12,'anhs','anhhong','123',NULL,NULL,'null-null-null','member'),(14,'anh','anhhong1','123',NULL,NULL,'null-null-null','member'),(15,'thanhpham','thanh','123','0958473923','thanh44112000@gmail.com','Dai Mo-Ha Noi-VN','member');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'final'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-15 22:56:45
