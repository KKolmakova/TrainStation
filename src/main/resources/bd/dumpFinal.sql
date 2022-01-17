-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: TrainStation
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `Comfort`
--

DROP TABLE IF EXISTS `Comfort`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Comfort` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Comfort`
--

LOCK TABLES `Comfort` WRITE;
/*!40000 ALTER TABLE `Comfort` DISABLE KEYS */;
INSERT INTO `Comfort` VALUES (1,'RESERVED_SEAT'),(2,'COMPARTMENT');
/*!40000 ALTER TABLE `Comfort` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Document`
--

DROP TABLE IF EXISTS `Document`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Document` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Document`
--

LOCK TABLES `Document` WRITE;
/*!40000 ALTER TABLE `Document` DISABLE KEYS */;
INSERT INTO `Document` VALUES (1,'PASSPORT'),(2,'RESIDENT_CARD'),(3,'CERTIFICATE');
/*!40000 ALTER TABLE `Document` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Passenger`
--

DROP TABLE IF EXISTS `Passenger`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Passenger` (
  `id` int NOT NULL AUTO_INCREMENT,
  `passenger_name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
  `surname` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
  `document_type_id` int DEFAULT NULL,
  `document_series` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
  `account_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `Passenger_FK` (`document_type_id`),
  KEY `Passenger_FK_1` (`account_id`),
  CONSTRAINT `Passenger_FK` FOREIGN KEY (`document_type_id`) REFERENCES `Document` (`id`),
  CONSTRAINT `Passenger_FK_1` FOREIGN KEY (`account_id`) REFERENCES `User_data` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=167 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Passenger`
--

LOCK TABLES `Passenger` WRITE;
/*!40000 ALTER TABLE `Passenger` DISABLE KEYS */;
INSERT INTO `Passenger` VALUES (1,'Ksenia','Kolmakova',1,'KH873473835',15),(2,'Mark','Vilkevich',2,'LI8768754645',15),(3,'Maria','Kot',3,'RO9875474565',15),(6,'Nelli','Denisova',3,'HY8743596065',15),(93,'Alena','Novik',3,'FR9830002345',15),(95,'Valya','Acria',2,'SD3455643425',15),(97,'Marina','Ganich',1,'SV4564364565',15),(98,'Alena','Poroma',2,'TE3452353466',15),(139,'Valeria','Homko',3,'BV2344323579',15),(140,'Maksim','Boberko',1,'NF3434734226',15),(141,'Nikita','Falin',1,'PL2384382394',15),(155,'Kate','Rinatova',1,'RT8934578346',15),(157,'Nikolay','Federuk',1,'KH8734745435',15),(158,'Alexandra','Golovina',3,'KH8734738345',15),(159,'Alena','Kotova',3,'GT9587454563',15);
/*!40000 ALTER TABLE `Passenger` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Payment`
--

DROP TABLE IF EXISTS `Payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Payment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `train_id` int DEFAULT NULL,
  `passenger_id` int DEFAULT NULL,
  `pricing_id` int DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `mark_as_deleted` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `check_fk_1_idx` (`passenger_id`),
  KEY `check_fk_2_idx` (`train_id`),
  KEY `fk_payment_pricing_1_idx` (`pricing_id`),
  CONSTRAINT `fk_payment_passenger_1` FOREIGN KEY (`passenger_id`) REFERENCES `Passenger` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `fk_payment_pricing_1` FOREIGN KEY (`pricing_id`) REFERENCES `Pricing` (`id`),
  CONSTRAINT `fk_payment_train_1` FOREIGN KEY (`train_id`) REFERENCES `Train` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=130 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Payment`
--

LOCK TABLES `Payment` WRITE;
/*!40000 ALTER TABLE `Payment` DISABLE KEYS */;
INSERT INTO `Payment` VALUES (32,1,6,2,17.4,0),(56,9,93,14,17.4,0),(58,1,95,2,17.4,0),(59,1,97,2,17.4,1),(101,1,6,2,17.4,1),(109,1,155,3,10.5,0),(110,8,155,10,20,1),(111,2,155,6,22.9,0),(116,7,6,7,20,0),(117,7,158,7,20,0),(118,7,159,8,30,0),(121,7,6,7,20,1),(124,4,1,4,12.6,0),(125,1,1,2,17.4,0),(126,9,3,13,19,0),(127,8,140,9,23.5,0),(128,3,157,12,25,0),(129,9,2,13,19,0);
/*!40000 ALTER TABLE `Payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Pricing`
--

DROP TABLE IF EXISTS `Pricing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Pricing` (
  `id` int NOT NULL AUTO_INCREMENT,
  `train_id` int DEFAULT NULL,
  `comfort_type_id` int DEFAULT NULL,
  `seats_number` int DEFAULT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_pricing_train_1_idx` (`train_id`),
  KEY `fk_wagon_type_1_idx` (`comfort_type_id`),
  CONSTRAINT `fk_pricing_comfort_1` FOREIGN KEY (`comfort_type_id`) REFERENCES `Comfort` (`id`),
  CONSTRAINT `fk_pricing_train_1` FOREIGN KEY (`train_id`) REFERENCES `Train` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Pricing`
--

LOCK TABLES `Pricing` WRITE;
/*!40000 ALTER TABLE `Pricing` DISABLE KEYS */;
INSERT INTO `Pricing` VALUES (2,1,1,0,17.4),(3,1,2,50,10.5),(4,4,1,52,12.6),(5,4,2,43,7),(6,2,1,18,22.9),(7,7,1,45,20),(8,7,2,49,30),(9,8,1,20,23.5),(10,8,2,23,20),(11,3,1,45,20),(12,3,2,26,25),(13,9,1,15,19),(14,9,2,44,29.9);
/*!40000 ALTER TABLE `Pricing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Train`
--

DROP TABLE IF EXISTS `Train`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Train` (
  `id` int NOT NULL AUTO_INCREMENT,
  `train_number` int DEFAULT NULL,
  `arrival_place` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
  `departure_time` time DEFAULT NULL,
  `departure_date` date DEFAULT NULL,
  `kilometers` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Train`
--

LOCK TABLES `Train` WRITE;
/*!40000 ALTER TABLE `Train` DISABLE KEYS */;
INSERT INTO `Train` VALUES (1,314,'Minsk','10:30:00','2022-01-20',275),(2,46,'Brest','09:25:00','2021-12-20',239),(3,465,'Gomel','08:58:00','2021-12-20',590),(4,201,'Minsk','16:30:00','2022-02-04',300),(7,56,'Mogilev','21:50:00','2022-07-02',477),(8,6,'Vitebsk','06:00:00','2022-03-02',536),(9,23,'Polotsk','13:20:00','2022-02-17',493);
/*!40000 ALTER TABLE `Train` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User_data`
--

DROP TABLE IF EXISTS `User_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `User_data` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
  `password` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
  `role` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User_data`
--

LOCK TABLES `User_data` WRITE;
/*!40000 ALTER TABLE `User_data` DISABLE KEYS */;
INSERT INTO `User_data` VALUES (14,'ksenia','$2a$10$jb8IwJJwyXAmupPGvcVRler5tHzJn3G/BheJ5wnGXYq/QzaOHW7EO','USER'),(15,'user','$2a$10$xU9dNPAeq5SuB9pxp7oRSOe7mDGn0VE4XpDQZANPKeTAGddx5zLum','USER'),(16,'admin','$2a$10$jb8IwJJwyXAmupPGvcVRler5tHzJn3G/BheJ5wnGXYq/QzaOHW7EO','ADMIN'),(24,'Viola','$2a$10$H9H0mjQLqxxDaWAoZumnI.jW3FPnAnhw7NkUGyKxsjqA/yJn6gJ0a','USER'),(25,'malica','$2a$10$GTn7pk6beUQTcr10Au/5e.RUKn0GfIo8VwJTcQadLFkZdFOUWp2BC','USER');
/*!40000 ALTER TABLE `User_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User_role`
--

DROP TABLE IF EXISTS `User_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `User_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `roles` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User_role`
--

LOCK TABLES `User_role` WRITE;
/*!40000 ALTER TABLE `User_role` DISABLE KEYS */;
INSERT INTO `User_role` VALUES (1,14,'ADMIN'),(2,15,'ADMIN');
/*!40000 ALTER TABLE `User_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-17 14:36:08
