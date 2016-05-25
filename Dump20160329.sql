CREATE DATABASE  IF NOT EXISTS `desa_cupones` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `desa_cupones`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: desa_cupones
-- ------------------------------------------------------
-- Server version	5.6.17

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
-- Table structure for table `carrito_compras`
--

DROP TABLE IF EXISTS `carrito_compras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `carrito_compras` (
  `ID_CLIENTE` int(11) NOT NULL,
  `ID_OFERTA` int(30) NOT NULL DEFAULT '0',
  `CANTIDAD` int(9) DEFAULT NULL,
  `VALOR_OFERTA` float(14,2) DEFAULT NULL,
  `IMPUESTO` float(14,2) DEFAULT NULL,
  `TOTAL` float(14,2) DEFAULT NULL,
  `FECHA_HORA_CREA` date DEFAULT NULL,
  `USR_CODIGO_CREA` varchar(15) DEFAULT NULL,
  `FECHA_HORA_MODI` date DEFAULT NULL,
  `USR_CODIGO_MODI` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`ID_CLIENTE`,`ID_OFERTA`),
  KEY `fk_carritocompra_oferta_idx` (`ID_OFERTA`),
  CONSTRAINT `fk_carritocompra_cliente` FOREIGN KEY (`ID_CLIENTE`) REFERENCES `cliente` (`ID_CLIENTE`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_carritocompra_oferta` FOREIGN KEY (`ID_OFERTA`) REFERENCES `oferta` (`ID_OFERTA`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carrito_compras`
--

LOCK TABLES `carrito_compras` WRITE;
/*!40000 ALTER TABLE `carrito_compras` DISABLE KEYS */;
INSERT INTO `carrito_compras` VALUES (1,1,1,90.00,0.00,90.00,'2016-03-16','admin','2016-03-16','0'),(1,262,1,45.00,0.00,45.00,'2016-03-16','admin','2016-03-16','0'),(1,268,1,342.00,0.00,342.00,'2016-03-16','admin','2016-03-16','0'),(1,272,1,34.00,0.00,34.00,'2016-03-16','admin','2016-03-16','0');
/*!40000 ALTER TABLE `carrito_compras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categoria` (
  `ID_CATEGORIA` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE_CATEGORIA` varchar(30) NOT NULL,
  `DESCRIPCION_CATEGORIA` char(20) DEFAULT NULL,
  `CAT_ESTADO` int(11) DEFAULT NULL,
  `FECHA_HORA_CREA` date DEFAULT NULL,
  `USR_CODIGO_CREA` varchar(15) DEFAULT NULL,
  `FECHA_HORA_MODI` date DEFAULT NULL,
  `USR_CODIGO_MODI` char(20) DEFAULT NULL,
  PRIMARY KEY (`ID_CATEGORIA`),
  UNIQUE KEY `NOMBRE_CATEGORIA` (`NOMBRE_CATEGORIA`),
  UNIQUE KEY `INDEX_CATEGORIA` (`ID_CATEGORIA`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'HOTELERIA','OFERTAS DE HOTELES',1,'2014-06-13','GSANTOS',NULL,NULL);
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `ID_CLIENTE` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE_CLIENTE` varchar(40) NOT NULL,
  `CLT_DIRECCION1` varchar(100) NOT NULL,
  `CLT_DIRECCION2` varchar(99) DEFAULT NULL,
  `CLT_RNC` varchar(20) NOT NULL,
  `CLT_EMAIL` varchar(99) DEFAULT NULL,
  `CLT_TELEFONO1` varchar(10) DEFAULT NULL,
  `CLT_TELEFONO2` varchar(10) DEFAULT NULL,
  `CLT_FECHA_HORA_CREA` date NOT NULL,
  `USR_CODIGO_CREA` varchar(15) NOT NULL,
  `CLT_FECHA_HORA_MODI` date DEFAULT NULL,
  `USR_CODIGO_MODI` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`ID_CLIENTE`),
  UNIQUE KEY `INDEX_CLIENTE` (`ID_CLIENTE`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'ADMIN','Fracisco del rosario sanchez','ASDFA','22300603978','get.delossantos@gmail.com','8092348196','','2014-06-20','GDELOSSANTOS',NULL,NULL),(8,'asdfasdfasdfasdf','klsdjflaskjdflksajdf','','9999999999','fkasldjfalkjdflasjdfl','99999999','9999999','2016-03-22','admin1',NULL,NULL),(10,'dfsadfasdfasdfasdf','lkfjalsdjflsakjdfklasjdfkla','','99999999','fskldjfakdjfklsjdf','999999','999999','2016-03-22','admin2',NULL,NULL),(11,'Jenifer Sams','la romana','','9999999999','sams@gmail.com','99999999','99999999','2016-03-22','jsams',NULL,NULL),(13,'Jenifer Sams','la romana','','99999999','jsams@gmail.com','99999','999999','2016-03-22','jsams1',NULL,NULL);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_pedido`
--

DROP TABLE IF EXISTS `detalle_pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalle_pedido` (
  `ID_PEDIDO` int(11) NOT NULL,
  `LINEA` int(11) NOT NULL,
  `MONTO_PEDIDO` double(14,2) NOT NULL,
  `DESCUENTO_PEDIDO` double(14,2) NOT NULL,
  `ITBIS_PEDIDO` double(14,2) NOT NULL,
  `NETO_PEDIDO` double(14,2) DEFAULT NULL,
  `FECHA_HORA_CREA` date DEFAULT NULL,
  `USR_CODIGO_CREA` varchar(15) DEFAULT NULL,
  `FECHA_HORA_MODI` date DEFAULT NULL,
  `USR_CODIGO_MODI` varchar(15) DEFAULT NULL,
  `MONEDA_MONEDA` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`ID_PEDIDO`,`LINEA`),
  UNIQUE KEY `INDEX_PEDIDO` (`ID_PEDIDO`),
  CONSTRAINT `fk_DETALLE_PEDIDO` FOREIGN KEY (`ID_PEDIDO`) REFERENCES `pedido` (`ID_PEDIDO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_pedido`
--

LOCK TABLES `detalle_pedido` WRITE;
/*!40000 ALTER TABLE `detalle_pedido` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle_pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_solicitud`
--

DROP TABLE IF EXISTS `detalle_solicitud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalle_solicitud` (
  `ID_OFERTA` int(30) NOT NULL,
  `ID_SOLICITUD` int(11) NOT NULL,
  `LINEA` int(11) NOT NULL,
  `SOD_MONTO` double(14,2) NOT NULL,
  `SOD_DESCUENTO` double(14,2) NOT NULL,
  `SOD_ITBIS` double(14,2) NOT NULL,
  `SOD_NETO` double(14,2) DEFAULT NULL,
  `FECHA_HORA_CREA` date DEFAULT NULL,
  `USR_CODIGO_CREA` varchar(15) DEFAULT NULL,
  `FECHA_HORA_MODI` date DEFAULT NULL,
  `USR_CODIGO_MODI` varchar(15) DEFAULT NULL,
  `SOD_MONEDA` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`ID_OFERTA`,`ID_SOLICITUD`,`LINEA`),
  KEY `fk_DETALLE_SOLICITUD1` (`ID_SOLICITUD`),
  CONSTRAINT `fk_DETALLE_SOLICITUD1` FOREIGN KEY (`ID_SOLICITUD`) REFERENCES `solicitud` (`ID_SOLICITUD`),
  CONSTRAINT `fk_DETALLE_SOLICITUD_OFERTA` FOREIGN KEY (`ID_OFERTA`) REFERENCES `oferta` (`ID_OFERTA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_solicitud`
--

LOCK TABLES `detalle_solicitud` WRITE;
/*!40000 ALTER TABLE `detalle_solicitud` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle_solicitud` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estado`
--

DROP TABLE IF EXISTS `estado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estado` (
  `ID_ESTADO` int(11) NOT NULL AUTO_INCREMENT,
  `ESTADO_DESCRIPCION` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`ID_ESTADO`),
  KEY `INDEX_ESTADO` (`ID_ESTADO`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estado`
--

LOCK TABLES `estado` WRITE;
/*!40000 ALTER TABLE `estado` DISABLE KEYS */;
INSERT INTO `estado` VALUES (1,'ACTIVO'),(2,'INACTIVO');
/*!40000 ALTER TABLE `estado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fotos`
--

DROP TABLE IF EXISTS `fotos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fotos` (
  `ID_FOTOS` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE_FOTO` varchar(30) NOT NULL,
  `DESCRIPCION` varchar(50) NOT NULL,
  `RUTA_FOTO` varchar(255) NOT NULL,
  `FOTO_ESTADO` char(20) DEFAULT NULL,
  `FECHA_HORA_CREA` date DEFAULT NULL,
  `USR_CODIGO_CREA` varchar(15) DEFAULT NULL,
  `FECHA_HORA_MODI` date DEFAULT NULL,
  `USR_CODIGO_MODI` varchar(15) DEFAULT NULL,
  `ID_OFERTA` int(30) NOT NULL,
  `RUTA_FOTO_P` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`ID_FOTOS`,`NOMBRE_FOTO`),
  UNIQUE KEY `INDEX_FOTOS` (`ID_FOTOS`,`NOMBRE_FOTO`),
  KEY `fk_FOTOS_OFERTA1_idx` (`ID_OFERTA`),
  CONSTRAINT `fk_FOTOS_OFERTA` FOREIGN KEY (`ID_OFERTA`) REFERENCES `oferta` (`ID_OFERTA`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fotos`
--

LOCK TABLES `fotos` WRITE;
/*!40000 ALTER TABLE `fotos` DISABLE KEYS */;
INSERT INTO `fotos` VALUES (32,'portada','Oferta asdfadfadsf','C:\\appservers\\wildfly-8.1.0.Final\\standalone\\deployments\\cupones.war\\imagenes\\oferta1\\Lighthouse-2918758378310370838.png','A','2014-07-16','user()',NULL,NULL,265,'/imagenes/oferta1/Lighthouse-2918758378310370838.png'),(33,'portada','Oferta fsdfadsfdsgafgdgsgfgsdfgsfgdf','C:\\appservers\\wildfly-8.1.0.Final\\standalone\\deployments\\cupones.war\\imagenes\\oferta1\\Lighthouse-2918758378310370838.png','A','2014-07-16','user()',NULL,NULL,265,'/imagenes/oferta1/Lighthouse-2918758378310370838.png'),(34,'portada','Oferta dfasdfasdfasd','C:\\appservers\\wildfly-8.1.0.Final\\standalone\\deployments\\cupones.war\\imagenes\\oferta1\\Lighthouse-2918758378310370838.png','A','2014-07-17','user()',NULL,NULL,265,'/imagenes/oferta1/Lighthouse-2918758378310370838.png'),(35,'portada','Oferta FASDFASDFA','C:\\appservers\\wildfly-8.1.0.Final\\standalone\\deployments\\cupones.war\\imagenes\\oferta1\\Lighthouse-2918758378310370838.png','A','2014-08-26','user()',NULL,NULL,262,'/imagenes/oferta1/Lighthouse-2918758378310370838.png'),(36,'Tulips','Oferta sdfasdfasd','C:\\appservers\\wildfly-8.1.0.Final\\standalone\\deployments\\cupones.war\\imagenes\\oferta1\\Lighthouse-2918758378310370838.png','A','2014-08-27','user()',NULL,NULL,263,'/imagenes/oferta1/Lighthouse-2918758378310370838.png'),(37,'Penguins','Oferta Prueba de oferta','C:\\appservers\\wildfly-8.1.0.Final\\standalone\\deployments\\cupones.war\\imagenes\\oferta1\\Lighthouse-2918758378310370838.png','A','2014-10-28','user()',NULL,NULL,264,'/imagenes/oferta1/Lighthouse-2918758378310370838.png'),(38,'Koala','Oferta ELVIS','C:\\appservers\\wildfly-8.1.0.Final\\standalone\\deployments\\cupones.war\\imagenes\\oferta1\\Desert-309722780776382705.jpg','A','2014-11-11','user()',NULL,NULL,265,'/imagenes/oferta1/Lighthouse-2918758378310370838.png'),(39,'jj','Oferta oferta 1','C:\\appservers\\wildfly-8.1.0.Final\\standalone\\deployments\\cupones.war\\imagenes\\oferta1\\Lighthouse-2918758378310370838.png','A','2015-11-07','user()',NULL,NULL,267,'/imagenes/oferta1/Lighthouse-2918758378310370838.png'),(40,'pp','Oferta fasdfsad','C:\\appservers\\wildfly-8.1.0.Final\\standalone\\deployments\\cupones.war\\imagenes\\oferta1\\Lighthouse-2918758378310370838.png','A','2015-11-14','user()',NULL,NULL,268,'/imagenes/oferta1/Lighthouse-2918758378310370838.png'),(41,'jj','Oferta aaaaaaaa','C:\\appservers\\wildfly-8.1.0.Final\\standalone\\deployments\\cupones.war\\imagenes\\oferta1\\Lighthouse-2918758378310370838.png','A','2015-11-17','user()',NULL,NULL,269,'/imagenes/oferta1/Lighthouse-2918758378310370838.png'),(42,'20150926_201448','Oferta prueba1','C:\\appservers\\wildfly-8.1.0.Final\\standalone\\deployments\\cupones.war\\imagenes\\oferta1\\Lighthouse-2918758378310370838.png','A','2015-11-28','user()',NULL,NULL,270,'/imagenes/oferta1/Lighthouse-2918758378310370838.png'),(43,'jj','Oferta fsdfasdf','C:\\appservers\\wildfly-8.1.0.Final\\standalone\\deployments\\cupones.war\\imagenes\\oferta1\\Lighthouse-2918758378310370838.png','A','2015-12-01','user()',NULL,NULL,271,'/imagenes/oferta1/Lighthouse-2918758378310370838.png'),(44,'jj','Oferta sdfasdfasdf','C:\\appservers\\wildfly-8.1.0.Final\\standalone\\deployments\\cupones.war\\imagenes\\oferta1\\jj-716044267474763607.jpg','A','2015-12-02','user()',NULL,NULL,272,'/imagenes/oferta1/Lighthouse-2918758378310370838.png'),(45,'jj','Oferta sdfasdfasdf','C:\\appservers\\wildfly-8.1.0.Final\\standalone\\deployments\\cupones.war\\imagenes\\oferta1\\jj-5241578456564494488.jpg','A','2015-12-02','user()',NULL,NULL,273,'/imagenes/oferta1/Lighthouse-2918758378310370838.png'),(46,'jj','Oferta dASDasd','C:\\appservers\\wildfly-8.1.0.Final\\standalone\\deployments\\cupones.war\\imagenes\\oferta1\\jj-1784096653311937640.jpg','A','2015-12-02','user()',NULL,NULL,274,'/imagenes/oferta1/Lighthouse-2918758378310370838.png'),(47,'DSCN0254','Oferta Getzels Xavier','C:\\appservers\\wildfly-8.1.0.Final\\standalone\\deployments\\cupones.war\\imagenes\\oferta1\\Lighthouse-2918758378310370838.png','A','2015-12-26','user()',NULL,NULL,275,'/imagenes/oferta1/Lighthouse-2918758378310370838.png'),(48,'DSCN0254','Oferta Getzels Xavier','C:\\appservers\\wildfly-8.1.0.Final\\standalone\\deployments\\cupones.war\\imagenes\\oferta1\\Lighthouse-2918758378310370838.png','A','2015-12-26','user()',NULL,NULL,1,'/imagenes/oferta1/Lighthouse-2918758378310370838.png'),(49,'Penguins','Oferta nuevo oferta','C:\\appservers\\wildfly-8.1.0.Final\\standalone\\deployments\\cupones.war\\imagenes\\oferta1\\Lighthouse-2918758378310370838.png','A','2016-02-29','user()',NULL,NULL,276,'/imagenes/oferta1/Lighthouse-2918758378310370838.png');
/*!40000 ALTER TABLE `fotos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oferta`
--

DROP TABLE IF EXISTS `oferta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `oferta` (
  `ID_OFERTA` int(30) NOT NULL AUTO_INCREMENT,
  `ID_CATEGORIA` int(11) NOT NULL,
  `ID_ESTADO` int(11) NOT NULL,
  `NOMBRE_OFERTA` varchar(50) NOT NULL,
  `PRECIO_OFERTA` float(14,2) NOT NULL,
  `PRECIO_OFERTA_US` float(14,2) NOT NULL,
  `VALOR_OFERTA` float(14,2) NOT NULL,
  `VALOR_OFERTA_US` float(14,2) DEFAULT NULL,
  `DESCUETO_OFERTA` int(11) NOT NULL,
  `AHORO_OFERTA` float(14,2) NOT NULL,
  `AHORO_OFERTA_US` float(14,2) DEFAULT NULL,
  `TIEMPO_OFERTA` int(11) DEFAULT NULL,
  `FECHA_HORA_CREA` date DEFAULT NULL,
  `USR_CODIGO_CREA` varchar(15) NOT NULL,
  `FECHA_HORA_MODI` date DEFAULT NULL,
  `USR_CODIGO_MODI` char(15) DEFAULT NULL,
  `DETALLE_OFERTA` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`ID_OFERTA`),
  UNIQUE KEY `INDEX_OFERTA` (`ID_OFERTA`),
  KEY `fk_OFERTA_CATEGORIA` (`ID_CATEGORIA`),
  KEY `fk_OFERTA_ESTADO` (`ID_ESTADO`),
  CONSTRAINT `fk_OFERTA_CATEGORIA` FOREIGN KEY (`ID_CATEGORIA`) REFERENCES `categoria` (`ID_CATEGORIA`),
  CONSTRAINT `fk_OFERTA_ESTADO` FOREIGN KEY (`ID_ESTADO`) REFERENCES `estado` (`ID_ESTADO`)
) ENGINE=InnoDB AUTO_INCREMENT=277 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oferta`
--

LOCK TABLES `oferta` WRITE;
/*!40000 ALTER TABLE `oferta` DISABLE KEYS */;
INSERT INTO `oferta` VALUES (1,1,1,'Getzels Xavier',90.00,0.00,90.00,0.00,90,90.00,0.00,90,'2015-12-26','GDELOSSANTOS',NULL,NULL,'Esta es una oferta de prueba&nbsp;<div><br></div><div><br></div><div>hola mundo&nbsp;</div><div><br></div><div><br></div><div>bla bla bla bla bla bla&nbsp;</div>'),(259,1,1,'asdfadfadsf',9999.00,0.00,9999.00,0.00,999,9999.00,0.00,999,'2014-07-16','GDELOSSANTOS',NULL,NULL,'sdfasdfasdfsd fadsfa sdf adfadsfasdfasdfasd&nbsp; adfasdfadfadsf adsf<br>sd<br>fa<br>dsf<br>ads<br>fa<br>dsfasdfadsfasdf<br>sd<br>fadsfadsfadsfadfasdfadsfadsfadfadsfadfadsfadsfadsfasdf<br>asdfads<br>'),(260,1,1,'fsdfadsfdsgafgdgsgfgsdfgsfgdf',1111.00,0.00,1.00,0.00,1111,1111.00,0.00,22222,'2014-07-16','GDELOSSANTOS',NULL,NULL,'sdfasdf sdfadfsfads hadfafadfadf adfad f adfwefds fasdfadfad fdf adfad<br>'),(261,1,1,'dfasdfasdfasd',4534534.00,0.00,3453453.00,0.00,3453453,3453453.00,0.00,34534534,'2014-07-17','GDELOSSANTOS',NULL,NULL,'dfasdfa sd fsd asd dfadsf dfadsf adsfa dfasd fasdf asdf asd fasdfasdf<br>'),(262,1,1,'FASDFASDFA',45.00,0.00,45.00,0.00,45,45.00,0.00,45,'2014-08-26','GDELOSSANTOS',NULL,NULL,'HHHHJHJHBJHBJH J J HJBHJ<br>'),(263,1,1,'sdfasdfasd',55.00,0.00,55.00,0.00,55,55.00,0.00,55,'2014-08-27','GDELOSSANTOS',NULL,NULL,'fa dfdf adfadf adfad adfdf dfadf adfdfadfa dsfasdfa dsfadfa dfasdfasd fasdf asdf<br>'),(264,1,1,'Prueba de oferta',90.00,0.00,90.00,0.00,90,90.00,0.00,90,'2014-10-28','GDELOSSANTOS',NULL,NULL,'Este es un ejemplo de la creacion de una oferta.<br>'),(265,1,1,'ELVIS',56.00,0.00,56.00,0.00,56,5656.00,0.00,565,'2014-11-11','GDELOSSANTOS',NULL,NULL,'FASDFASDFA SDF ASDFA SD FASDFASD FASDFASDF ASDFASDFASDF<br>'),(267,1,1,'oferta 1',500.00,0.00,55.00,0.00,55,55.00,0.00,55,'2015-11-07','GDELOSSANTOS',NULL,NULL,'sdfasdfasdf asdf asdfasd fasdfasdf asdf asdfa sdfasdfasdf<br>'),(268,1,1,'fasdfsad',234.00,0.00,342.00,0.00,34,34.00,0.00,3422,'2015-11-14','GDELOSSANTOS',NULL,NULL,'asdfasdfasdfasdfasdfasdfasd'),(269,1,1,'aaaaaaaa',34.00,0.00,34.00,0.00,34,34.00,0.00,34,'2015-11-17','GDELOSSANTOS',NULL,NULL,'sfdfsadf asdfasdf asdf asdfasdfasdf asdf asdfasdfasdfasdfa sdfasdfasdfasdfasdf asdf asdf asdf asdf'),(270,1,1,'prueba1',234.00,0.00,342.00,0.00,234,342.00,0.00,342,'2015-11-28','GDELOSSANTOS',NULL,NULL,'sdfasdfasdfasdfasdfaddsfasdfasdf'),(271,1,1,'fsdfasdf',34.00,0.00,342.00,0.00,34,34.00,0.00,34,'2015-12-01','GDELOSSANTOS',NULL,NULL,'sdfsadfasd fasdf dfadfasdfasd'),(272,1,1,'sdfasdfasdf',234.00,0.00,34.00,0.00,34,34.00,0.00,34,'2015-12-02','GDELOSSANTOS',NULL,NULL,'fasdfasdfasdfasdfasdfasdfas'),(273,1,1,'sdfasdfasdf',234.00,0.00,34.00,0.00,34,34.00,0.00,34,'2015-12-02','GDELOSSANTOS',NULL,NULL,'fasdfasdfasdfasdfasdfasdfas'),(274,1,1,'dASDasd',244.00,0.00,234.00,0.00,234,234.00,0.00,342,'2015-12-02','GDELOSSANTOS',NULL,NULL,''),(275,1,1,'Getzels Xavier',90.00,0.00,90.00,0.00,90,90.00,0.00,90,'2015-12-26','GDELOSSANTOS',NULL,NULL,'Esta es una oferta de prueba&nbsp;<div><br></div><div><br></div><div>hola mundo&nbsp;</div><div><br></div><div><br></div><div>bla bla bla bla bla bla&nbsp;</div>'),(276,1,1,'nuevo oferta',55.00,0.00,1010.00,0.00,1010,1010.00,0.00,122,'2016-02-29','GDELOSSANTOS',NULL,NULL,'Prueba de la creacion de una oferta.<div><br></div>');
/*!40000 ALTER TABLE `oferta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pais`
--

DROP TABLE IF EXISTS `pais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pais` (
  `ID_PAIS` int(11) NOT NULL AUTO_INCREMENT,
  `PAIS_DESCRIPCION` varchar(20) DEFAULT NULL,
  `PAIS_DESCRIPCION_CORTA` varchar(20) DEFAULT NULL,
  `FECHA_HORA_CREA` date DEFAULT NULL,
  `USR_CODIGO_CREA` varchar(15) DEFAULT NULL,
  `FECHA_HORA_MODI` date DEFAULT NULL,
  `USR_CODIGO_MODI` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`ID_PAIS`),
  UNIQUE KEY `INDEX_PAIS` (`ID_PAIS`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pais`
--

LOCK TABLES `pais` WRITE;
/*!40000 ALTER TABLE `pais` DISABLE KEYS */;
INSERT INTO `pais` VALUES (1,'REPUBLICA DOMINICANA','RD','2014-06-13','GDELOSSANTOS',NULL,NULL);
/*!40000 ALTER TABLE `pais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedido` (
  `ID_PEDIDO` int(11) NOT NULL AUTO_INCREMENT,
  `ID_SOLICITUD` int(11) NOT NULL,
  `SOLICITUD_FECHA` date DEFAULT NULL,
  `ESTADO_PEDIDO` char(1) NOT NULL,
  `MONTO_PEDIDO` double(14,2) NOT NULL,
  `DESCUENTO_PEDIDO` double(14,2) NOT NULL,
  `ITBIS_PEDIDO` double(14,2) NOT NULL,
  `NETO_PEDIDO` double(14,2) NOT NULL,
  `TASA_PEDIDO` int(11) DEFAULT NULL,
  `OBSERVACIONES_PEDIDO` varchar(150) DEFAULT NULL,
  `FECHA_IMPRESION` char(20) DEFAULT NULL,
  `FECHA_HORA_CREA` date DEFAULT NULL,
  `USR_CODIGO_CREA` varchar(15) DEFAULT NULL,
  `FECHA_HORA_MODI` date DEFAULT NULL,
  `USR_CODIGO_MODI` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`ID_PEDIDO`),
  UNIQUE KEY `INDEX_PEDIDO` (`ID_PEDIDO`),
  KEY `fk_PEDIDO_SOLICITUD` (`ID_SOLICITUD`),
  CONSTRAINT `fk_PEDIDO_SOLICITUD` FOREIGN KEY (`ID_SOLICITUD`) REFERENCES `solicitud` (`ID_SOLICITUD`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `provincia`
--

DROP TABLE IF EXISTS `provincia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `provincia` (
  `ID_PROVINCIA` int(11) NOT NULL AUTO_INCREMENT,
  `PRO_DESCRIPCION` varchar(30) NOT NULL,
  `PRO_DESCRIPCION_CORTA` varchar(10) DEFAULT NULL,
  `FECHA_HORA_CREA` date DEFAULT NULL,
  `USR_CODIGO_CREA` varchar(15) DEFAULT NULL,
  `FECHA_HORA_MODI` date DEFAULT NULL,
  `USR_CODIGO_MODI` varchar(15) DEFAULT NULL,
  `ID_PAIS` int(11) NOT NULL,
  PRIMARY KEY (`ID_PROVINCIA`),
  KEY `INDEX_PROVINCIA` (`ID_PROVINCIA`),
  KEY `fk_PROVINCIA_PAIS` (`ID_PAIS`),
  CONSTRAINT `fk_PROVINCIA_PAIS` FOREIGN KEY (`ID_PAIS`) REFERENCES `pais` (`ID_PAIS`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `provincia`
--

LOCK TABLES `provincia` WRITE;
/*!40000 ALTER TABLE `provincia` DISABLE KEYS */;
INSERT INTO `provincia` VALUES (1,'SANTO DOMINGO','STO DGO','2014-06-13','GDELOSSANTOS',NULL,NULL,1);
/*!40000 ALTER TABLE `provincia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roles` (
  `ROLE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_USUARIO` int(11) NOT NULL,
  `ROLE_NOMBRE` varchar(20) DEFAULT NULL,
  `FECHA_HORA_CREA` date DEFAULT NULL,
  `USR_CODIGO_CREA` varchar(15) DEFAULT NULL,
  `FECHA_HORA_MODI` date DEFAULT NULL,
  `USR_CODIGO_MODI` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`ROLE_ID`,`ID_USUARIO`),
  UNIQUE KEY `INDEX_ROLES` (`ROLE_ID`,`ID_USUARIO`),
  KEY `fk_ROLES_USUARIO` (`ID_USUARIO`),
  CONSTRAINT `fk_ROLES_USUARIO` FOREIGN KEY (`ID_USUARIO`) REFERENCES `usuario` (`ID_USUARIO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sector`
--

DROP TABLE IF EXISTS `sector`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sector` (
  `ID_SECTOR` int(11) NOT NULL AUTO_INCREMENT,
  `SECTOR_DESCRIPCION` varchar(40) NOT NULL,
  `FECHA_HORA_CREA` date DEFAULT NULL,
  `USR_CODIGO_CREA` char(20) DEFAULT NULL,
  `FECHA_HORA_MODI` date DEFAULT NULL,
  `USR_CODIGO_MODI` varchar(15) DEFAULT NULL,
  `ID_PROVINCIA` int(11) NOT NULL,
  PRIMARY KEY (`ID_SECTOR`),
  UNIQUE KEY `INDEX_SECTOR` (`ID_SECTOR`),
  KEY `fk_SECTOR_PROVINCIA` (`ID_PROVINCIA`),
  CONSTRAINT `fk_SECTOR_PROVINCIA` FOREIGN KEY (`ID_PROVINCIA`) REFERENCES `provincia` (`ID_PROVINCIA`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sector`
--

LOCK TABLES `sector` WRITE;
/*!40000 ALTER TABLE `sector` DISABLE KEYS */;
INSERT INTO `sector` VALUES (1,'LOS FRAILES','2014-06-13','GDELOSSANTOS',NULL,NULL,1);
/*!40000 ALTER TABLE `sector` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `solicitud`
--

DROP TABLE IF EXISTS `solicitud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `solicitud` (
  `ID_SOLICITUD` int(11) NOT NULL AUTO_INCREMENT,
  `ID_CLIENTE` int(11) NOT NULL,
  `SOLICITUD_FECHA` date DEFAULT NULL,
  `ESTADO_SOLICITUD` char(1) NOT NULL,
  `SOL_IND_TRANSPORTE` char(1) DEFAULT NULL,
  `MONTO_SOLICITUD` double(14,2) NOT NULL,
  `DESCUENTO_SOLICITUD` double(14,2) NOT NULL,
  `ITBIS_SOLICITUD` double(14,2) NOT NULL,
  `NETO_SOLICITUD` double(14,2) NOT NULL,
  `TASA_SOLICITUD` int(11) DEFAULT NULL,
  `OBSERVACIONES_SOLICITUD` varchar(150) DEFAULT NULL,
  `FECHA_IMPRESION` char(20) DEFAULT NULL,
  `FECHA_HORA_CREA` date DEFAULT NULL,
  `USR_CODIGO_CREA` varchar(15) DEFAULT NULL,
  `FECHA_HORA_MODI` date DEFAULT NULL,
  `USR_CODIGO_MODI` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`ID_SOLICITUD`),
  UNIQUE KEY `INDEX_SOLICITUD` (`ID_SOLICITUD`),
  KEY `fk_SOLICITUD_CLIENTE` (`ID_CLIENTE`),
  CONSTRAINT `fk_SOLICITUD_CLIENTE` FOREIGN KEY (`ID_CLIENTE`) REFERENCES `cliente` (`ID_CLIENTE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solicitud`
--

LOCK TABLES `solicitud` WRITE;
/*!40000 ALTER TABLE `solicitud` DISABLE KEYS */;
/*!40000 ALTER TABLE `solicitud` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `ID_USUARIO` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE_USUARIO` varchar(15) NOT NULL,
  `CONTRASENA` varchar(200) NOT NULL,
  `CALLE` varchar(40) DEFAULT NULL,
  `NUMERO_CASO_LOCAL` int(11) DEFAULT NULL,
  `ID_SECTOR` int(11) NOT NULL,
  `PREGUNTA_SECRETA` varchar(40) DEFAULT NULL,
  `RESPUESTA_PREGUNTA` varchar(88) DEFAULT NULL,
  `FECHA_HORA_CREA` date NOT NULL,
  `USR_CODIGO_CREA` varchar(15) NOT NULL,
  `FECHA_HORA_MODI` date DEFAULT NULL,
  `USR_CODIGO_MODI` varchar(15) DEFAULT NULL,
  `ID_CLIENTE` int(11) NOT NULL,
  PRIMARY KEY (`ID_USUARIO`),
  UNIQUE KEY `NOMBRE_USUARIO` (`NOMBRE_USUARIO`),
  UNIQUE KEY `INDEX_USUARIO` (`ID_USUARIO`),
  KEY `fk_USUARIO_SECTOR` (`ID_SECTOR`),
  KEY `fk_USUARIO_CLIENTE1_idx` (`ID_CLIENTE`),
  CONSTRAINT `fk_USUARIO_CLIENTE` FOREIGN KEY (`ID_CLIENTE`) REFERENCES `cliente` (`ID_CLIENTE`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_USUARIO_SECTOR` FOREIGN KEY (`ID_SECTOR`) REFERENCES `sector` (`ID_SECTOR`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'admin','admin','respaldo',NULL,1,NULL,NULL,'2014-06-13','gdelossantos',NULL,NULL,1),(2,'admin1','admin',NULL,NULL,1,NULL,NULL,'2016-03-22','admin1',NULL,NULL,8),(4,'admin2','admin',NULL,NULL,1,NULL,NULL,'2016-03-22','admin2',NULL,NULL,10),(5,'jsams','jsams',NULL,NULL,1,NULL,NULL,'2016-03-22','jsams',NULL,NULL,11),(7,'jsams1','jsams',NULL,NULL,1,NULL,NULL,'2016-03-22','jsams1',NULL,NULL,13);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-03-29 14:49:23
