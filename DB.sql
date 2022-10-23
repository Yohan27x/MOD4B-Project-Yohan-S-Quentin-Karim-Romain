-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: shop
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `UserName` varchar(50) DEFAULT NULL,
  `prodName` varchar(50) DEFAULT NULL,
  `prodDescription` varchar(200) DEFAULT NULL,
  `prodPath` varchar(200) DEFAULT NULL,
  `Cartegory` varchar(50) DEFAULT NULL,
  `Price` decimal(15,2) DEFAULT NULL,
  `Quantity` int DEFAULT NULL,
  `QuantityChosen` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `UserName` varchar(50) NOT NULL,
  `Password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`UserName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES ('Karim','123'),('Quentin','abcd'),('Yohann','yes');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordershop`
--

DROP TABLE IF EXISTS `ordershop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ordershop` (
  `userName` varchar(50) DEFAULT NULL,
  `price` decimal(15,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordershop`
--

LOCK TABLES `ordershop` WRITE;
/*!40000 ALTER TABLE `ordershop` DISABLE KEYS */;
INSERT INTO `ordershop` VALUES ('Quentin',36.72),('Yohan',70.00),('Yohan',13.43),('Yohan',15.73);
/*!40000 ALTER TABLE `ordershop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `SKU` varchar(50) NOT NULL,
  `prodName` varchar(50) DEFAULT NULL,
  `prodDescription` varchar(200) DEFAULT NULL,
  `prodPath` varchar(200) DEFAULT NULL,
  `Cartegory` varchar(50) DEFAULT NULL,
  `Price` decimal(15,2) DEFAULT NULL,
  `Quantity` int DEFAULT NULL,
  PRIMARY KEY (`SKU`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES ('1','Cookies','C\'est tout choco','https://static.wikia.nocookie.net/minecraft/images/1/17/CookieNew.png/revision/latest?cb=20190901163518','FOOD',3.00,50),('2','Egg','strong as a rock','https://static.wikia.nocookie.net/minecraft/images/a/a4/EggNew.png/revision/latest?cb=20190829232139','FOOD',8.00,5),('3','Leather','cool material','https://static.wikia.nocookie.net/minecraft/images/1/13/HideNew.png/revision/latest?cb=20190902213436','MATERIAL',20.00,25),('4','MIlk','mmh','https://static.wikia.nocookie.net/minecraft/images/2/2e/MilkNew.png/revision/latest?cb=20190915063749','FOOD',5.00,20),('5','Bread','baguette','https://static.wikia.nocookie.net/minecraft/images/9/94/BreadNew.png/revision/latest?cb=20190908175214','FOOD',7.00,40);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userdb`
--

DROP TABLE IF EXISTS `userdb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userdb` (
  `UserName` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `Adress` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Balance` decimal(15,2) NOT NULL,
  `logged` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`UserName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userdb`
--

LOCK TABLES `userdb` WRITE;
/*!40000 ALTER TABLE `userdb` DISABLE KEYS */;
INSERT INTO `userdb` VALUES ('Karim','abcd','someWhere','Karim@yes.com',0.00,0),('Quentin','yes','someWhere','quentin@yes.com',232963.28,0),('Romain','test','someWhere','Romain@yes.com',10000.00,0),('Vanus','lePetitGregory','dans le van rue lagache','vanus@tonenfant.com',9999999999999.00,0),('yes','yes','test','test',10.00,0),('Yohan','1234','someWhere','Yohan@yes.com',9900.84,1);
/*!40000 ALTER TABLE `userdb` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-22 20:01:49
