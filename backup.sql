-- MySQL dump 10.13  Distrib 9.2.0, for macos13.7 (x86_64)
--
-- Host: localhost    Database: Viajes
-- ------------------------------------------------------
-- Server version	8.0.39

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `Viajes`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `Viajes` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `Viajes`;

--
-- Table structure for table `hotel`
--

DROP TABLE IF EXISTS `hotel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hotel` (
  `disponible` bit(1) NOT NULL,
  `precio` double NOT NULL,
  `id_hotel` bigint NOT NULL AUTO_INCREMENT,
  `categoria` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_hotel`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel`
--

LOCK TABLES `hotel` WRITE;
/*!40000 ALTER TABLE `hotel` DISABLE KEYS */;
INSERT INTO `hotel` VALUES (_binary '',300,1,'5 estrellas','Hilton'),(_binary '\0',100,2,'3 estrellas','NH'),(_binary '',90,3,'3 estrellas','AC Hotel'),(_binary '\0',250,4,'5 estrellas','Ritz'),(_binary '',100,5,'3 estrellas','Gran Meliá'),(_binary '',50,6,'2 estrellas','Ilunion Atrium'),(_binary '',20,7,'1 estrellas','nogallas'),(_binary '\0',120,8,'4 estrellas','Finisterre'),(_binary '',35.5,9,'1 estrellas','Barreiro');
/*!40000 ALTER TABLE `hotel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservas`
--

DROP TABLE IF EXISTS `reservas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservas` (
  `id_hotel` bigint DEFAULT NULL,
  `id_reserva` bigint NOT NULL AUTO_INCREMENT,
  `id_vuelo` bigint DEFAULT NULL,
  `dni_cliente` varchar(255) DEFAULT NULL,
  `nombre_cliente` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_reserva`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservas`
--

LOCK TABLES `reservas` WRITE;
/*!40000 ALTER TABLE `reservas` DISABLE KEYS */;
INSERT INTO `reservas` VALUES (1,1,1,'12345678-F','Juan'),(3,2,5,'2025-07-05','Paco Gomez'),(3,3,5,'1212121212-R','Mariano Rico'),(1,4,5,'32165487-S','Claudia Souto'),(1,5,7,'17394756-S','Elena Oliveira'),(1,6,7,'17322756-1','Manuel Amor'),(5,7,5,'98345762-w','Hugo Paz'),(2,8,5,'18345762-w','Hugo Pazos'),(2,9,12,'18345762-w','Hugo Pazos'),(2,10,11,'10203040-M','Carlos Mouriño'),(2,11,11,'10203040-M','Carlos Mouriño'),(2,12,11,'10203870-L','Adela Moure'),(6,13,11,'90023645-C','Lara Castaño'),(2,14,11,'pepepepe-P','Mariano Rajoy'),(1,15,11,'12345678X','Juan'),(2,16,11,'82349099-L','Carlos Petroleo'),(6,17,12,'28449845-S','nicolas'),(9,18,12,'81233457-G','Antonio Machado'),(3,19,5,'39984456-A','Maria Patiño');
/*!40000 ALTER TABLE `reservas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` enum('ADMIN','USER') DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (7,'admin','$argon2id$v=19$m=16384,t=2,p=1$z67U84E7ohlM7EsMyQWVDQ$d2lhvtIBmgYPikRScUJVH99sjU4IxNl17nnO6+SE/+8','ADMIN'),(8,'user','$argon2id$v=19$m=16384,t=2,p=1$z67U84E7ohlM7EsMyQWVDQ$d2lhvtIBmgYPikRScUJVH99sjU4IxNl17nnO6+SE/+8','USER'),(9,'nico','$argon2id$v=19$m=16384,t=2,p=1$80Yb3vKPDLBflHE/iQ1ZjQ$xMj0zkf6hgZrkrqsoSKCP+XEyPaVcBiWqtnIN6prCoo','USER');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vuelos`
--

DROP TABLE IF EXISTS `vuelos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vuelos` (
  `vuelo_id` bigint NOT NULL AUTO_INCREMENT,
  `compañia` varchar(255) DEFAULT NULL,
  `fecha_vuelo` date DEFAULT NULL,
  `plazas_disponibles` int NOT NULL,
  `precio` double NOT NULL,
  PRIMARY KEY (`vuelo_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vuelos`
--

LOCK TABLES `vuelos` WRITE;
/*!40000 ALTER TABLE `vuelos` DISABLE KEYS */;
INSERT INTO `vuelos` VALUES (1,'Iberia','2025-12-12',9,100),(2,'Air Europa','2025-01-22',4,180),(3,'Ryanair','2025-02-19',10,50),(4,'Vueling','2025-07-05',0,122),(5,'EasyJet','2025-08-02',20,30),(6,'Iberia','2025-05-12',0,200),(7,'Iberia','2025-01-01',9,60),(8,'Air Europa','2025-10-22',2,180),(10,'Vueling','2025-07-05',0,122),(11,'Vueling','2025-08-12',12,62),(12,'Vueling','2025-08-12',15,62);
/*!40000 ALTER TABLE `vuelos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vuelos_model`
--

DROP TABLE IF EXISTS `vuelos_model`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vuelos_model` (
  `fecha_vuelo` date DEFAULT NULL,
  `plazas_disponibles` int NOT NULL,
  `precio` double NOT NULL,
  `vuelo_id` bigint NOT NULL AUTO_INCREMENT,
  `compañia` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`vuelo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vuelos_model`
--

LOCK TABLES `vuelos_model` WRITE;
/*!40000 ALTER TABLE `vuelos_model` DISABLE KEYS */;
/*!40000 ALTER TABLE `vuelos_model` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-03-01  0:26:19
