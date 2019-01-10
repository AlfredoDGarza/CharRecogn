-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: char_recogn
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.16-MariaDB

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
-- Table structure for table `caracter`
--

DROP TABLE IF EXISTS `caracter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `caracter` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Identificador único de cada caracter.',
  `caracter` varchar(1) NOT NULL COMMENT 'Caracter almacenado.',
  `bits` varchar(35) NOT NULL COMMENT 'Vector de bits de un caracter.',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1 COMMENT='Información acerca de un caracter.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `caracter`
--

LOCK TABLES `caracter` WRITE;
/*!40000 ALTER TABLE `caracter` DISABLE KEYS */;
INSERT INTO `caracter` VALUES (1,'A','01110100011000111111100011000110001'),(2,'B','11110100011000111110100011000111110'),(3,'C','01110100011000010000100001000101110'),(4,'D','11110100011000110001100011000111110'),(5,'E','11111100001000011110100001000011111'),(6,'F','11111100001000011110100001000010000'),(7,'G','01110100011000010111100011000101110'),(8,'H','10001100011000111111100011000110001'),(9,'I','11111001000010000100001000010011111'),(10,'J','11111001000010000100001000010011100'),(11,'K','10001100101010011000101001001010001'),(12,'L','10000100001000010000100001000011111'),(14,'M','10001110111010110001100011000110001'),(15,'N','11001110011010110101101011001110011'),(16,'O','01110100011000110001100011000101110');
/*!40000 ALTER TABLE `caracter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `red`
--

DROP TABLE IF EXISTS `red`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `red` (
  `id` int(11) NOT NULL COMMENT 'Identificador único.',
  `factorAprendizaje` double NOT NULL COMMENT 'Factor de aprendizaje de la red neuronal artificial.',
  `error` double NOT NULL COMMENT 'Error admitido para cada época de la red neuronal artificial.',
  `iteracionesMaximas` int(11) NOT NULL COMMENT 'Número de iteraciones máximas permitidas.',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Información acerca de las herramientas de la red neuronal artificial.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `red`
--

LOCK TABLES `red` WRITE;
/*!40000 ALTER TABLE `red` DISABLE KEYS */;
INSERT INTO `red` VALUES (1,0.5,0.001,50000);
/*!40000 ALTER TABLE `red` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'char_recogn'
--

--
-- Dumping routines for database 'char_recogn'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-11-01 16:28:49
