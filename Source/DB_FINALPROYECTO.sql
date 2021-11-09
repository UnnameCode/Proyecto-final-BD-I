-- MySQL dump 10.13  Distrib 5.7.36, for Win64 (x86_64)
--
-- Host: localhost    Database: BD_SQLFINAL
-- ------------------------------------------------------
-- Server version	5.7.36-log

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
-- Table structure for table `bodega`
--

DROP TABLE IF EXISTS `bodega`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bodega` (
  `nit` varchar(9) NOT NULL,
  `ubicacion` varchar(50) NOT NULL,
  `propietario` varchar(30) NOT NULL,
  `tipo` char(1) NOT NULL,
  `largo` double NOT NULL,
  `ancho` double NOT NULL,
  `tipo_ambiente` char(1) NOT NULL,
  `tipo_producto` varchar(15) NOT NULL,
  `material_construccion` varchar(15) NOT NULL,
  `cantidad_puestos` int(11) NOT NULL,
  PRIMARY KEY (`nit`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bodega`
--

LOCK TABLES `bodega` WRITE;
/*!40000 ALTER TABLE `bodega` DISABLE KEYS */;
/*!40000 ALTER TABLE `bodega` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contenedor`
--

DROP TABLE IF EXISTS `contenedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contenedor` (
  `codigo` int(11) NOT NULL,
  `tipo_contenedor` char(1) NOT NULL,
  `largo` double NOT NULL,
  `ancho` double NOT NULL,
  `alto` double NOT NULL,
  `capacidad_carga` double NOT NULL,
  `empresa_responsable` varchar(30) NOT NULL,
  `poliza_manejo` varchar(15) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contenedor`
--

LOCK TABLES `contenedor` WRITE;
/*!40000 ALTER TABLE `contenedor` DISABLE KEYS */;
/*!40000 ALTER TABLE `contenedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contrato`
--

DROP TABLE IF EXISTS `contrato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contrato` (
  `numero_contrato` int(11) NOT NULL,
  `poliza_amparo` int(11) NOT NULL,
  `local_asignado` varchar(15) NOT NULL,
  `numero_contrato_propietario` int(11) DEFAULT NULL,
  `numero_contrato_membresia` int(11) DEFAULT NULL,
  `numero_contrato_temporal` int(11) DEFAULT NULL,
  `codigo_puesto_almacenamiento` int(11) NOT NULL,
  `contratante` int(11) NOT NULL,
  `referencia_personal_1` int(11) DEFAULT NULL,
  `referencia_personal_2` int(11) DEFAULT NULL,
  `referencia_comercio` int(11) DEFAULT NULL,
  PRIMARY KEY (`numero_contrato`),
  UNIQUE KEY `numero_contrato` (`numero_contrato`),
  KEY `contra_propietario` (`numero_contrato_propietario`),
  KEY `contra_membresia` (`numero_contrato_membresia`),
  KEY `contra_temporal` (`numero_contrato_temporal`),
  KEY `cod_puesto` (`codigo_puesto_almacenamiento`),
  KEY `id_contratante` (`contratante`),
  KEY `id_referencia_personal_1` (`referencia_personal_1`),
  KEY `id_referencia_personal_2` (`referencia_personal_2`),
  KEY `id_referencia_comercio` (`referencia_comercio`),
  CONSTRAINT `cod_puesto` FOREIGN KEY (`codigo_puesto_almacenamiento`) REFERENCES `puesto_almacenamiento` (`codigo`),
  CONSTRAINT `contra_membresia` FOREIGN KEY (`numero_contrato_membresia`) REFERENCES `membresia` (`numero_contrato`),
  CONSTRAINT `contra_propietario` FOREIGN KEY (`numero_contrato_propietario`) REFERENCES `propietario` (`numero_contrato`),
  CONSTRAINT `contra_temporal` FOREIGN KEY (`numero_contrato_temporal`) REFERENCES `temporal` (`numero_contrato`),
  CONSTRAINT `id_contratante` FOREIGN KEY (`contratante`) REFERENCES `persona` (`numero_identificacion`),
  CONSTRAINT `id_referencia_comercio` FOREIGN KEY (`referencia_comercio`) REFERENCES `referencia_comercial` (`identificacion`),
  CONSTRAINT `id_referencia_personal_1` FOREIGN KEY (`referencia_personal_1`) REFERENCES `persona` (`numero_identificacion`),
  CONSTRAINT `id_referencia_personal_2` FOREIGN KEY (`referencia_personal_2`) REFERENCES `persona` (`numero_identificacion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contrato`
--

LOCK TABLES `contrato` WRITE;
/*!40000 ALTER TABLE `contrato` DISABLE KEYS */;
/*!40000 ALTER TABLE `contrato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `maquinaria`
--

DROP TABLE IF EXISTS `maquinaria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `maquinaria` (
  `codigo` int(11) NOT NULL,
  `marca` varchar(15) NOT NULL,
  `peso` double NOT NULL,
  `modelo` year(4) NOT NULL,
  `valor_nominal` double NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `maquinaria`
--

LOCK TABLES `maquinaria` WRITE;
/*!40000 ALTER TABLE `maquinaria` DISABLE KEYS */;
/*!40000 ALTER TABLE `maquinaria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `membresia`
--

DROP TABLE IF EXISTS `membresia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `membresia` (
  `numero_contrato` int(11) NOT NULL,
  `seguro_mecanica` char(1) NOT NULL,
  `fecha_finalizacion` date NOT NULL,
  `frecuencia_pago` char(1) NOT NULL,
  `fecha_poliza` date NOT NULL,
  `fecha_terminacion_poliza` date NOT NULL,
  PRIMARY KEY (`numero_contrato`),
  UNIQUE KEY `numero_contrato` (`numero_contrato`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `membresia`
--

LOCK TABLES `membresia` WRITE;
/*!40000 ALTER TABLE `membresia` DISABLE KEYS */;
/*!40000 ALTER TABLE `membresia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mercancia`
--

DROP TABLE IF EXISTS `mercancia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mercancia` (
  `codigo` int(11) NOT NULL,
  `fragilidad` double NOT NULL,
  `peso` double NOT NULL,
  `volumen` double NOT NULL,
  `fecha_vencimiento` date DEFAULT NULL,
  `fecha_empaque` date NOT NULL,
  `valor_nominal` double NOT NULL,
  `empacador` int(11) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mercancia`
--

LOCK TABLES `mercancia` WRITE;
/*!40000 ALTER TABLE `mercancia` DISABLE KEYS */;
/*!40000 ALTER TABLE `mercancia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persona` (
  `numero_identificacion` int(11) NOT NULL,
  `tipo` varchar(15) NOT NULL,
  `nombre_completo` varchar(30) NOT NULL,
  `numero_contrato_empleo` int(11) DEFAULT NULL,
  `registro_conduccion` varchar(15) DEFAULT NULL,
  `direccion` varchar(50) NOT NULL,
  `telefono` varchar(12) NOT NULL,
  `telefono_secundario` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`numero_identificacion`),
  UNIQUE KEY `numero_identificacion` (`numero_identificacion`),
  KEY `relacion_contractual` (`numero_contrato_empleo`),
  CONSTRAINT `relacion_contractual` FOREIGN KEY (`numero_contrato_empleo`) REFERENCES `contrato` (`numero_contrato`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producto` (
  `codigo` int(11) NOT NULL,
  `tipo` char(1) NOT NULL,
  `valor_asegurado` double NOT NULL,
  `descripcion` varchar(140) NOT NULL,
  `estado_poliza` char(1) NOT NULL,
  `codigo_mercancia` int(11) DEFAULT NULL,
  `codigo_contenedor` int(11) DEFAULT NULL,
  `codigo_maquinaria` int(11) DEFAULT NULL,
  `vehiculo_placa` varchar(6) NOT NULL,
  PRIMARY KEY (`codigo`),
  UNIQUE KEY `codigo` (`codigo`),
  KEY `cod_mercancia` (`codigo_mercancia`),
  KEY `cod_contenedor` (`codigo_contenedor`),
  KEY `cod_maquinaria` (`codigo_maquinaria`),
  CONSTRAINT `cod_contenedor` FOREIGN KEY (`codigo_contenedor`) REFERENCES `contenedor` (`codigo`),
  CONSTRAINT `cod_maquinaria` FOREIGN KEY (`codigo_maquinaria`) REFERENCES `maquinaria` (`codigo`),
  CONSTRAINT `cod_mercancia` FOREIGN KEY (`codigo_mercancia`) REFERENCES `mercancia` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `propietario`
--

DROP TABLE IF EXISTS `propietario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `propietario` (
  `numero_contrato` int(11) NOT NULL,
  `tipo_persona` varchar(9) NOT NULL,
  `tipo_uso` varchar(25) NOT NULL,
  PRIMARY KEY (`numero_contrato`),
  UNIQUE KEY `numero_contrato` (`numero_contrato`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `propietario`
--

LOCK TABLES `propietario` WRITE;
/*!40000 ALTER TABLE `propietario` DISABLE KEYS */;
/*!40000 ALTER TABLE `propietario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `puesto_almacenamiento`
--

DROP TABLE IF EXISTS `puesto_almacenamiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `puesto_almacenamiento` (
  `codigo` int(11) NOT NULL,
  `localizacion_cuadrante` varchar(15) NOT NULL,
  `consecutivo` double NOT NULL,
  `contiene` int(11) DEFAULT NULL,
  `bodega_nit` varchar(9) NOT NULL,
  PRIMARY KEY (`codigo`),
  UNIQUE KEY `codigo` (`codigo`),
  UNIQUE KEY `codigo_2` (`codigo`),
  KEY `puesto_recursivo` (`contiene`),
  KEY `numero_nit` (`bodega_nit`),
  CONSTRAINT `numero_nit` FOREIGN KEY (`bodega_nit`) REFERENCES `bodega` (`nit`),
  CONSTRAINT `puesto_recursivo` FOREIGN KEY (`contiene`) REFERENCES `puesto_almacenamiento` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `puesto_almacenamiento`
--

LOCK TABLES `puesto_almacenamiento` WRITE;
/*!40000 ALTER TABLE `puesto_almacenamiento` DISABLE KEYS */;
/*!40000 ALTER TABLE `puesto_almacenamiento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `referencia_comercial`
--

DROP TABLE IF EXISTS `referencia_comercial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `referencia_comercial` (
  `tipo_identificacion` varchar(15) NOT NULL,
  `identificacion` int(11) NOT NULL,
  `nombre_completo` varchar(30) NOT NULL,
  `razon_social` varchar(50) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `telefono_oficina` int(11) NOT NULL,
  PRIMARY KEY (`identificacion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `referencia_comercial`
--

LOCK TABLES `referencia_comercial` WRITE;
/*!40000 ALTER TABLE `referencia_comercial` DISABLE KEYS */;
/*!40000 ALTER TABLE `referencia_comercial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registro`
--

DROP TABLE IF EXISTS `registro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registro` (
  `numero_registro` int(11) NOT NULL AUTO_INCREMENT,
  `licencia_conductor` varchar(15) DEFAULT NULL,
  `cedula_conductor` int(11) NOT NULL,
  `placa_vehiculo` varchar(6) NOT NULL,
  `marca_vehiculo` varchar(12) DEFAULT NULL,
  `vol_carga` double DEFAULT NULL,
  `capacidad_carga` double DEFAULT NULL,
  `tipo_vehiculo` varchar(10) NOT NULL,
  `local_ingreso` varchar(15) NOT NULL,
  `tipo_usuario` varchar(10) NOT NULL,
  `retiro_mercancia` char(1) DEFAULT NULL,
  `tiempo_entrada` date NOT NULL,
  `tiempo_salida` date DEFAULT NULL,
  `codigo_producto` int(11) DEFAULT NULL,
  PRIMARY KEY (`numero_registro`),
  KEY `ced_cond` (`cedula_conductor`),
  KEY `placa_veh` (`placa_vehiculo`),
  CONSTRAINT `ced_cond` FOREIGN KEY (`cedula_conductor`) REFERENCES `persona` (`numero_identificacion`),
  CONSTRAINT `placa_veh` FOREIGN KEY (`placa_vehiculo`) REFERENCES `vehiculo` (`placa`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registro`
--

LOCK TABLES `registro` WRITE;
/*!40000 ALTER TABLE `registro` DISABLE KEYS */;
/*!40000 ALTER TABLE `registro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `temporal`
--

DROP TABLE IF EXISTS `temporal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `temporal` (
  `numero_contrato` int(11) NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_finalizacion` date NOT NULL,
  `frecuencia_pago` char(1) NOT NULL,
  `poliza_amparo` int(11) NOT NULL,
  `local_asignado` varchar(15) NOT NULL,
  PRIMARY KEY (`numero_contrato`),
  UNIQUE KEY `numero_contrato` (`numero_contrato`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `temporal`
--

LOCK TABLES `temporal` WRITE;
/*!40000 ALTER TABLE `temporal` DISABLE KEYS */;
/*!40000 ALTER TABLE `temporal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehiculo`
--

DROP TABLE IF EXISTS `vehiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vehiculo` (
  `placa` varchar(6) NOT NULL,
  `tipo` varchar(10) NOT NULL,
  `color` varchar(10) NOT NULL,
  `modelo` year(4) NOT NULL,
  `marca` varchar(12) DEFAULT NULL,
  `volumen` double DEFAULT NULL,
  `capacidad` double DEFAULT NULL,
  `numero_contrato` int(11) NOT NULL,
  `identificacion_conductor` int(11) NOT NULL,
  PRIMARY KEY (`placa`),
  KEY `referencia_contractual` (`numero_contrato`),
  KEY `referencia_conductor` (`identificacion_conductor`),
  CONSTRAINT `referencia_conductor` FOREIGN KEY (`identificacion_conductor`) REFERENCES `persona` (`numero_identificacion`),
  CONSTRAINT `referencia_contractual` FOREIGN KEY (`numero_contrato`) REFERENCES `contrato` (`numero_contrato`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehiculo`
--

LOCK TABLES `vehiculo` WRITE;
/*!40000 ALTER TABLE `vehiculo` DISABLE KEYS */;
/*!40000 ALTER TABLE `vehiculo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-09  9:47:06
