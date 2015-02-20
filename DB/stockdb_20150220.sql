CREATE DATABASE  IF NOT EXISTS `stockdb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `stockdb`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: stockdb
-- ------------------------------------------------------
-- Server version	5.5.14

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
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department` (
  `departmentId` int(11) NOT NULL AUTO_INCREMENT,
  `departmentName` varchar(45) NOT NULL,
  PRIMARY KEY (`departmentId`),
  UNIQUE KEY `departmentName_UNIQUE` (`departmentName`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'Administration'),(3,'Engineering'),(5,'Management'),(4,'Mechanical'),(2,'Technical');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item` (
  `itemId` int(11) NOT NULL AUTO_INCREMENT,
  `itemName` varchar(100) NOT NULL,
  `autostamp` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`itemId`),
  UNIQUE KEY `itemName_UNIQUE` (`itemName`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (28,'FLANGED GATE VALVES',NULL),(29,'PUSH IN GATE VALVE',NULL),(30,'LSTAR KENT',NULL),(31,'FLANGED ADAPTER',NULL);
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itemdescription`
--

DROP TABLE IF EXISTS `itemdescription`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itemdescription` (
  `itemdescriptionId` int(11) NOT NULL AUTO_INCREMENT,
  `itemId` int(11) NOT NULL,
  `itemSize` varchar(45) NOT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `balance` int(11) DEFAULT NULL,
  `autostamp` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`itemdescriptionId`),
  UNIQUE KEY `Unique_ItemDescription` (`itemId`,`itemSize`),
  KEY `fk_itemDescription_item1_idx` (`itemId`),
  CONSTRAINT `fk_itemDescription_item1` FOREIGN KEY (`itemId`) REFERENCES `item` (`itemId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itemdescription`
--

LOCK TABLES `itemdescription` WRITE;
/*!40000 ALTER TABLE `itemdescription` DISABLE KEYS */;
INSERT INTO `itemdescription` VALUES (13,28,'DN 500','',5,NULL),(14,28,'DN 400','',3,NULL),(15,28,'DN 300','',10,'2015-02-11 14:43:00'),(16,28,'DN 250','',5,NULL),(17,28,'DN 200','',10,NULL),(18,28,'DN 150','',0,NULL),(19,28,'DN 125','',0,NULL),(20,28,'DN 80','',0,NULL),(21,28,'DN 75','',0,NULL),(22,28,'DN 65','',0,NULL),(23,28,'DN 50','',0,NULL),(24,28,'DN 32','',0,NULL),(25,28,'DN 25','',0,NULL),(26,28,'DN 20','',0,NULL),(27,28,'DN 15','',0,NULL),(29,29,'DN 150','',45,NULL),(30,30,'LK 500','',0,NULL);
/*!40000 ALTER TABLE `itemdescription` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jobtitle`
--

DROP TABLE IF EXISTS `jobtitle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jobtitle` (
  `jobtitleId` int(11) NOT NULL AUTO_INCREMENT,
  `jobtitleName` varchar(45) NOT NULL,
  PRIMARY KEY (`jobtitleId`),
  UNIQUE KEY `jobtitle_UNIQUE` (`jobtitleName`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jobtitle`
--

LOCK TABLES `jobtitle` WRITE;
/*!40000 ALTER TABLE `jobtitle` DISABLE KEYS */;
INSERT INTO `jobtitle` VALUES (3,'Managing Director'),(5,'Mechanical Engineer'),(4,'Procurement Officer'),(1,'Store Manager'),(2,'Technical Director');
/*!40000 ALTER TABLE `jobtitle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `roleId` int(11) NOT NULL AUTO_INCREMENT,
  `rolename` varchar(45) NOT NULL,
  PRIMARY KEY (`roleId`),
  UNIQUE KEY `rolename_UNIQUE` (`rolename`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'Managing Director'),(5,'Mechanical Engineer'),(4,'Procurement Officer'),(2,'Store Manager'),(3,'Technical Director');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `site`
--

DROP TABLE IF EXISTS `site`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `site` (
  `siteId` int(11) NOT NULL AUTO_INCREMENT,
  `siteName` varchar(100) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `otherInfo` varchar(255) DEFAULT NULL,
  `autostamp` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`siteId`),
  UNIQUE KEY `siteName_UNIQUE` (`siteName`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `site`
--

LOCK TABLES `site` WRITE;
/*!40000 ALTER TABLE `site` DISABLE KEYS */;
INSERT INTO `site` VALUES (1,'JINJA','Njinja District','','2015-01-22 22:06:00'),(2,'NYARWONDO','NEBBI District','',NULL),(3,'LIRIMA','TORORO District','',NULL),(4,'KAMOKYA','Kanjokya street','',NULL);
/*!40000 ALTER TABLE `site` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stockin`
--

DROP TABLE IF EXISTS `stockin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stockin` (
  `stockInId` int(11) NOT NULL AUTO_INCREMENT,
  `itemdescriptionId` int(11) NOT NULL,
  `quantity` int(11) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `deliveredby_userId` int(11) NOT NULL,
  `receivedby_userId` int(11) NOT NULL,
  `autostamp` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `goodsReceivedNoteNumber` varchar(45) DEFAULT NULL COMMENT 'This field might be of use if for any reason one wants to write a manual goods received note besides the electronic record',
  PRIMARY KEY (`stockInId`),
  KEY `fk_stockIn_itemDescription1_idx` (`itemdescriptionId`),
  KEY `fk_stockIn_user1_idx` (`deliveredby_userId`),
  KEY `fk_stockIn_user2_idx` (`receivedby_userId`),
  CONSTRAINT `fk_stockIn_itemDescription1` FOREIGN KEY (`itemdescriptionId`) REFERENCES `itemdescription` (`itemdescriptionId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_stockIn_user1` FOREIGN KEY (`deliveredby_userId`) REFERENCES `user` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_stockIn_user2` FOREIGN KEY (`receivedby_userId`) REFERENCES `user` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stockin`
--

LOCK TABLES `stockin` WRITE;
/*!40000 ALTER TABLE `stockin` DISABLE KEYS */;
INSERT INTO `stockin` VALUES (18,13,1,'',13,1,'2015-02-06 09:14:45',''),(19,14,9,'',13,1,'2015-02-06 09:15:00',''),(20,15,42,'',13,1,'2015-02-06 09:15:22',''),(21,13,2,'',13,1,'2015-02-06 11:49:23','56662'),(22,16,15,'',14,1,'2015-02-06 17:06:52','73273'),(23,14,4,'',13,1,'2015-02-07 08:16:55',''),(24,13,4,'',13,1,'2015-02-07 19:17:52',''),(25,13,5,'',13,1,'2015-02-07 19:18:27',''),(26,14,6,'',13,1,'2015-02-07 20:00:14',''),(27,17,15,'',13,1,'2015-02-07 20:01:52',''),(28,13,4,'',13,1,'2015-02-07 20:05:11',''),(29,29,45,'',13,1,'2015-02-07 20:23:22',''),(30,13,4,'',13,1,'2015-02-17 08:10:44','');
/*!40000 ALTER TABLE `stockin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stockout`
--

DROP TABLE IF EXISTS `stockout`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stockout` (
  `stockOutId` int(11) NOT NULL AUTO_INCREMENT,
  `itemdescriptionId` int(11) NOT NULL,
  `quantity` int(10) unsigned DEFAULT NULL,
  `issuedby_userId` int(11) NOT NULL COMMENT 'The company employee who issued the stock out. This is usually the storekeeper',
  `despatchedby_userId` int(11) NOT NULL COMMENT 'The person who is taking the stock from the yard to the site.',
  `takento_siteId` int(11) NOT NULL COMMENT 'The site to which the stock is going to be delivered',
  `vehicleNumber` varchar(20) DEFAULT NULL COMMENT 'The ID of the vehicle that will carry the goods.',
  `remarks` varchar(255) DEFAULT NULL,
  `deliveryNoteNumber` varchar(45) DEFAULT NULL COMMENT 'This field might be useful if for any reason one wants to write a manual delivery note besides the electronic record',
  `autostamp` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`stockOutId`),
  KEY `fk_stockOut_itemDescription1_idx` (`itemdescriptionId`),
  KEY `fk_stockOut_user1_idx` (`despatchedby_userId`),
  KEY `fk_stockOut_site1_idx` (`takento_siteId`),
  KEY `fk_stockOut_user2_idx` (`issuedby_userId`),
  CONSTRAINT `fk_stockOut_itemDescription1` FOREIGN KEY (`itemdescriptionId`) REFERENCES `itemdescription` (`itemdescriptionId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_stockOut_site1` FOREIGN KEY (`takento_siteId`) REFERENCES `site` (`siteId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_stockOut_user1` FOREIGN KEY (`despatchedby_userId`) REFERENCES `user` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_stockOut_user2` FOREIGN KEY (`issuedby_userId`) REFERENCES `user` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stockout`
--

LOCK TABLES `stockout` WRITE;
/*!40000 ALTER TABLE `stockout` DISABLE KEYS */;
INSERT INTO `stockout` VALUES (1,15,4,1,13,1,'UAB 745G','','','2015-02-06 09:15:58'),(2,15,2,1,13,2,'UAB  55F','','','2015-02-06 10:41:34'),(3,15,2,1,13,2,'UAB 788','','','2015-02-06 11:46:24'),(4,13,1,1,13,1,'UAB 789I','In good condition','8837','2015-02-06 11:51:06'),(5,16,5,1,14,3,'UAB 783G','','','2015-02-06 17:07:34'),(6,14,3,1,13,2,'UAB 588U','','','2015-02-07 08:21:30'),(7,14,2,1,13,2,'UAB 898C','','','2015-02-07 19:10:24'),(8,15,6,1,13,3,'UAG 889U','','','2015-02-07 19:11:48'),(9,13,2,1,13,2,'','','','2015-02-07 19:19:05'),(10,13,2,1,13,3,'','','','2015-02-07 19:25:34'),(11,15,4,1,13,2,'UAB 576U','','','2015-02-07 19:52:38'),(12,14,2,1,13,3,'','','','2015-02-07 19:54:05'),(13,17,5,1,13,1,'','','','2015-02-07 20:02:49'),(14,13,2,1,13,1,'','','','2015-02-07 20:05:33'),(15,14,4,1,13,1,'UAB 878I','','','2015-02-09 07:43:34'),(16,13,3,1,13,3,'UAB 500Y','','','2015-02-17 08:12:03');
/*!40000 ALTER TABLE `stockout` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `phone1` varchar(45) NOT NULL,
  `phone2` varchar(45) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `jobtitleId` int(11) NOT NULL,
  `departmentId` int(11) NOT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  KEY `fk_user_jobtitle_idx` (`jobtitleId`),
  KEY `fk_user_department1_idx` (`departmentId`),
  CONSTRAINT `fk_user_department1` FOREIGN KEY (`departmentId`) REFERENCES `department` (`departmentId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_jobtitle` FOREIGN KEY (`jobtitleId`) REFERENCES `jobtitle` (`jobtitleId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'OSINDE','FRANCIS','0779561782','','osinde.francis@gmail.com',1,5,'osinde',''),(12,'Super','Admin','0702016262','0777184383','gilbert.gillz@gmail.com',3,1,'superadmin','186cf774c97b60a1c106ef718d10970a6a06e06bef89553d9ae65d938a886eae'),(13,'FITSUM','FITSUM','0788195223','','fitsum@gmail.com',5,3,'fitsum','ba20b5a3c9f68a5961c72d16dd1d654a88428d08c82de1af2e9be6b7b2dc8068'),(14,'victor','varathan','0776551212','','varathanvictor@gmail.com',1,5,'victor','99bde068af2d49ed7fc8b8fa79abe13a6059e0db320bb73459fd96624bb4b33f');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_has_role`
--

DROP TABLE IF EXISTS `user_has_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_has_role` (
  `userId` int(11) NOT NULL,
  `roleId` int(11) NOT NULL,
  PRIMARY KEY (`userId`,`roleId`),
  KEY `fk_user_has_role_role1_idx` (`roleId`),
  KEY `fk_user_has_role_user1_idx` (`userId`),
  CONSTRAINT `fk_user_has_role_role1` FOREIGN KEY (`roleId`) REFERENCES `role` (`roleId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_role_user1` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_has_role`
--

LOCK TABLES `user_has_role` WRITE;
/*!40000 ALTER TABLE `user_has_role` DISABLE KEYS */;
INSERT INTO `user_has_role` VALUES (12,1),(14,1),(1,2),(14,2),(13,5);
/*!40000 ALTER TABLE `user_has_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `viewuserrole`
--

DROP TABLE IF EXISTS `viewuserrole`;
/*!50001 DROP VIEW IF EXISTS `viewuserrole`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `viewuserrole` (
  `username` tinyint NOT NULL,
  `password` tinyint NOT NULL,
  `rolename` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `viewuserrole`
--

/*!50001 DROP TABLE IF EXISTS `viewuserrole`*/;
/*!50001 DROP VIEW IF EXISTS `viewuserrole`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `viewuserrole` AS select `user`.`username` AS `username`,`user`.`password` AS `password`,`role`.`rolename` AS `rolename` from ((`user` join `user_has_role` on((`user_has_role`.`userId` = `user`.`userId`))) join `role` on((`user_has_role`.`roleId` = `role`.`roleId`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-02-20  4:56:37
