CREATE DATABASE  IF NOT EXISTS `bd_control_de_peliculas` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bd_control_de_peliculas`;
-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: bd_control_de_peliculas
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `calificacion`
--

DROP TABLE IF EXISTS `calificacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `calificacion` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_pelicula` int DEFAULT NULL,
  `calificacion` decimal(3,1) DEFAULT NULL COMMENT 'Guarda el promedio de la calificacion',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_pelicula_UNIQUE` (`id_pelicula`),
  KEY `FK_calificacion_pelicula_idx` (`id_pelicula`),
  CONSTRAINT `FK_calificacion_pelicula` FOREIGN KEY (`id_pelicula`) REFERENCES `peliculas` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calificacion`
--

LOCK TABLES `calificacion` WRITE;
/*!40000 ALTER TABLE `calificacion` DISABLE KEYS */;
INSERT INTO `calificacion` VALUES (1,1,6.6),(2,2,10.0),(3,3,9.8),(4,4,5.5),(5,5,5.0),(6,6,8.9),(7,7,9.0),(8,8,7.7),(9,9,10.0),(10,10,6.0);
/*!40000 ALTER TABLE `calificacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `casa_productora`
--

DROP TABLE IF EXISTS `casa_productora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `casa_productora` (
  `id_productora` int NOT NULL AUTO_INCREMENT,
  `nombre_productora` varchar(50) NOT NULL,
  `fecha_fundacion` varchar(25) DEFAULT NULL,
  `subproductoras` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_productora`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `casa_productora`
--

LOCK TABLES `casa_productora` WRITE;
/*!40000 ALTER TABLE `casa_productora` DISABLE KEYS */;
INSERT INTO `casa_productora` VALUES (1,'Warner Bros. Entretainment','4 de abril de 1923','Cartoon Network Studios, Warner Animation Group, Warner Bros. Animation, DC Films, Cartoon Network Movies'),(2,'Walt Disney Studios','16 de octubre de 1923','Marvel Studios, 20th Century Animation, Pixar, Lucasfilm, Disney Channel Original Movies'),(3,'NBCUniversal','30 de abril de 1912','Universal Animation Studios, Dreamworsk Animation, Illumination, Focus World'),(4,'Sony Pictures','10 de enero de 1924','Columbia Pictures, TriStrar Pictures, Funimation, Affirm Films'),(5,'Paramount Global','8 de mayo de 1912','Nickelodeon Movies, Paramount Players, Miramax, Comedy Central Films');
/*!40000 ALTER TABLE `casa_productora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categorias`
--

DROP TABLE IF EXISTS `categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `categorias` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(75) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias`
--

LOCK TABLES `categorias` WRITE;
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
INSERT INTO `categorias` VALUES (1,'Terror'),(2,'Suspenso'),(3,'Accion'),(4,'Romance'),(5,'Comedia'),(6,'Aventuras'),(7,'Ficcion'),(8,'Drama'),(9,'Musical'),(10,'ciencia ficcion');
/*!40000 ALTER TABLE `categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clasificacion`
--

DROP TABLE IF EXISTS `clasificacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `clasificacion` (
  `id_clasificacion` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `edad_minima` varchar(45) DEFAULT NULL,
  `recomendacion` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id_clasificacion`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clasificacion`
--

LOCK TABLES `clasificacion` WRITE;
/*!40000 ALTER TABLE `clasificacion` DISABLE KEYS */;
INSERT INTO `clasificacion` VALUES (1,'A o TP/G','Todas las edades','Todo publico'),(2,'PG','Mayores de 11 años','En compañia, se recomienda orientacion paternal'),(3,'B o M-12','Mayores de 12 años','Guia paternal sugerida'),(4,'PG-13','Mayores de 13 años','En compañia nocturna. Guia paternal estricta'),(5,'C o M-15','Mayores de 15 años','En compañia nocturna. Guia paternal estricta'),(6,'R','Mayores de 17 años','En compañia estricta. Restingido, no se admiten a menores de 17 años'),(7,'D o M-18/NC-17','Solo mayores de 18 años','Prohibido para audiencia de 17 años y menos'),(8,'E o M-21','Solo mayores de 21 años','Prohibido para audiencia menor a 21 años');
/*!40000 ALTER TABLE `clasificacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `peliculas`
--

DROP TABLE IF EXISTS `peliculas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `peliculas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `descripcion` varchar(500) DEFAULT NULL,
  `thumbnail` varchar(45) DEFAULT NULL,
  `id_categoria` int DEFAULT NULL,
  `id_productora` int DEFAULT NULL,
  `id_clasificacion` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_pelicula_categoria_idx` (`id_categoria`),
  KEY `FK_pelicula_productora_idx` (`id_productora`),
  KEY `FK_pelicula_clasificacion_idx` (`id_clasificacion`),
  CONSTRAINT `FK_pelicula_categoria` FOREIGN KEY (`id_categoria`) REFERENCES `categorias` (`id`),
  CONSTRAINT `FK_pelicula_clasificacion` FOREIGN KEY (`id_clasificacion`) REFERENCES `clasificacion` (`id_clasificacion`),
  CONSTRAINT `FK_pelicula_productora` FOREIGN KEY (`id_productora`) REFERENCES `casa_productora` (`id_productora`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `peliculas`
--

LOCK TABLES `peliculas` WRITE;
/*!40000 ALTER TABLE `peliculas` DISABLE KEYS */;
INSERT INTO `peliculas` VALUES (1,'Avengers end game','Estreno: 2019. El fin de thanos','images/pelis/avengersendgame.jpg',1,2,4),(2,'Avengers era de ultron','Estreno: 2015. Las maquinas se revelan','images/pelis/avengersageofultron.jpg',1,2,4),(3,'Piratas del caribe','Estreno: 2003. El pirata Jack Sparrow intenta recuperar su barco, el Perla Negra y vengarse del tridor Barbosa','images/pelis/PiratasdelCaribe.jpg',3,2,4),(4,'La momia','Estreno: 1999. Los muertos reviven','images/pelis/Lamomia.jpg',1,3,4),(5,'Last day on earth','Estreno: 2011. Un mundo posapocaliptico lleno de zombies el protagonista es el ultimo superviviente','images/pelis/LastDay.jpg',7,5,4),(6,'La huérfana','Estreno: 2009. El filme narra la historia de una pareja que adopta a una niña pero detrás de su dulce apariencia, esconde un oscuro secreto','images/pelis/huerfana.jpg',1,5,6),(7,'Ready Player One','Estreno: 2018. El adolescente Wade Watts es solo uno de los millones de personas que evaden el sombrio mundo \nreal para sumergirse en un mundo utopico virtual donde todo es posible ','images/pelis/readyplayer.jpg',1,1,4),(8,'Transformers','Estreno: 2007. El destino de la humanidad esta en juego cunado dos razas de robot,los buenos y los villanos, llevan su guerra\n a la tierra','images/pelis/Transformers.jpg',2,3,4),(9,'Venom','Estreno: 2018. El periodista Eddie Brock esta investigando a Carlton Drake, eñ celebre fundador de life Foundation.\nBrock establece una simbiosis con una inteligencia alienigena que les ofrece superpoderes','images/pelis/venom.jpg',3,4,4),(10,'Misión imposible','Estreno: 1996. El espía Ethan Hunt debe llevar a cabo una misión imposible: evitar la venta de un disco \nrobado que contiene información confidencial','images/pelis/Misinimposible.jpg',8,5,4);
/*!40000 ALTER TABLE `peliculas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rating`
--

DROP TABLE IF EXISTS `rating`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `rating` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_usuario` int DEFAULT NULL,
  `id_pelicula` int DEFAULT NULL,
  `puntuacion` decimal(2,0) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_rating_usuario_idx` (`id_usuario`),
  KEY `FK_rating_pelicula_idx` (`id_pelicula`),
  CONSTRAINT `FK_rating_pelicula` FOREIGN KEY (`id_pelicula`) REFERENCES `peliculas` (`id`),
  CONSTRAINT `FK_rating_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 CHARSET=utf8 COLLATE utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rating`
--

LOCK TABLES `rating` WRITE;
/*!40000 ALTER TABLE `rating` DISABLE KEYS */;
INSERT INTO `rating` VALUES (1,1,1,7),(2,2,2,9),(3,3,3,10),(4,1,4,7),(5,5,5,10),(6,6,1,10),(7,7,2,7),(8,1,3,8),(9,9,4,10),(10,2,5,7);
/*!40000 ALTER TABLE `rating` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_usuario`
--

DROP TABLE IF EXISTS `tipo_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `tipo_usuario` (
  `id_tipo_usuario` int NOT NULL AUTO_INCREMENT,
  `user_type` varchar(45) DEFAULT NULL COMMENT '"suscriptor", "administrador", "editor",',
  PRIMARY KEY (`id_tipo_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=4 CHARSET=utf8 COLLATE utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_usuario`
--

LOCK TABLES `tipo_usuario` WRITE;
/*!40000 ALTER TABLE `tipo_usuario` DISABLE KEYS */;
INSERT INTO `tipo_usuario` VALUES (1,'Administrador'),(2,'Usuario'),(3,'Supervisor');
/*!40000 ALTER TABLE `tipo_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombres` varchar(50) DEFAULT NULL,
  `apellidos` varchar(50) DEFAULT NULL,
  `email` varchar(75) DEFAULT NULL,
  `password` varchar(15) DEFAULT NULL,
  `fecha_nacimiento` varchar(45) DEFAULT NULL,
  `id_tipo_usuario` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_usuario_tipousuario_idx` (`id_tipo_usuario`),
  CONSTRAINT `FK_usuario_tipoUsuario` FOREIGN KEY (`id_tipo_usuario`) REFERENCES `tipo_usuario` (`id_tipo_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=11 CHARSET=utf8 COLLATE utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'Marvin','Alvarado','Marvin@gmail.com','1234','24/06/2002',1),(2,'Steven','Gonzalez','steven@gmail.com','1234','24/06/2002',1),(3,'Jhossleyn','Deras','jhosselyn@gmail.com','1234','15/09/2002',1),(4,'Milagro','Coreas','milagro@gmail.com','1234','05/06/2002',2),(5,'Esau','Hernandez','Esau@gmail.com','1234','12/07/2002',2),(6,'Mario','Gomez','mario@gmail.com','1234','24/05/2002',2),(7,'Aejandra','Martinez','ale@gmail.com','1234','21/06/2002',2),(8,'Perez','Juarez','perez@gmail.com','1234','13/06/2002',1),(9,'Maya','Lopez','Maya@gmail.com','1234','22/08/2002',1),(10,'Godinez','Perez','godinez@gmail.com','1234','26/05/2002',1);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-23 13:45:04
