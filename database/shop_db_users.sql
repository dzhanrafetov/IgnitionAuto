-- MySQL dump 10.13  Distrib 8.0.27, for macos11 (x86_64)
--
-- Host: localhost    Database: shop_db
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(200) NOT NULL,
  `last_login` varchar(60) DEFAULT NULL,
  `isloged` varchar(5) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `registerdate` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (101,'Admin','Dzhan','03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4','06/01/2022 11:52:35','yes','canrafet0@gmail.com','15/12/2021 21:09:32'),(102,'Admin','Brandon','a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3',NULL,NULL,'can.11@abv.bg','15/12/2021 21:12:37'),(104,'Client','Mitko','b9253e231b947f4420069bb241b2a4d2c20cedef6b9d48f968afb4a1d39d5c68','15/12/2021 23:03:14','yes','can.33@abv.bg','15/12/2021 23:02:57'),(105,'Admin','probvam','canimorandi33',NULL,NULL,'can.99@abv.bg','04/01/2022 22:32:19'),(106,'Admin','r80103184','2966211216004e3ba0f2badcd0e696e084bfaf85bdb3f2a34ab871201b64faee',NULL,NULL,'can.33@abv.bg','04/01/2022 22:39:32'),(107,'Admin','Haki33','33bc5d726d39465240e2fef6191b8702ef1e317e1816d7b31dceb4a44c1f7e59',NULL,NULL,'can.933@abv.bg','04/01/2022 23:13:08'),(108,'Client','asdf1234','33bc5d726d39465240e2fef6191b8702ef1e317e1816d7b31dceb4a44c1f7e59',NULL,NULL,'can.00@abv.bg','05/01/2022 09:37:15'),(109,'Client','probvam3444','216cce688fbff89cdb7bbd4dac7c0700e4f41ef69dad1de9a06cddf9ff082a1d',NULL,NULL,'proba@abv.bg','05/01/2022 10:47:58');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-08 19:44:39
