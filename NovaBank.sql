-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: PROJECT
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `accounts`
--

DROP TABLE IF EXISTS `accounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `accounts` (
  `A_Id` varchar(10) NOT NULL,
  `Pass` varchar(30) DEFAULT NULL,
  `A_Balance` mediumtext NOT NULL,
  PRIMARY KEY (`A_Id`),
  CONSTRAINT `accounts_chk_1` CHECK ((`A_Balance` > 50000)),
  CONSTRAINT `pass_check` CHECK (regexp_like(`Pass`,_utf8mb4'^[0-9]{6}$'))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accounts`
--

LOCK TABLES `accounts` WRITE;
/*!40000 ALTER TABLE `accounts` DISABLE KEYS */;
INSERT INTO `accounts` VALUES ('0000011111','123456','500000000'),('0222222222','123456','2000000000'),('0363458282','123456','200000000'),('0379831003','123456','417000000'),('0774825887','123456','520000000'),('0783939975','122456','111800009'),('0783939976','123456','1000000000'),('0787806521','123456','200000000'),('0901248021','123456','19000000'),('0939522423','123466','100000'),('0984719935','123456','500000000');
/*!40000 ALTER TABLE `accounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `C_Name` varchar(50) NOT NULL,
  `C_CCCD` varchar(12) NOT NULL,
  `C_Dob` date NOT NULL,
  `C_Address` varchar(100) DEFAULT NULL,
  `C_Tel` char(10) DEFAULT NULL,
  PRIMARY KEY (`C_CCCD`),
  UNIQUE KEY `C_Tel` (`C_Tel`),
  CONSTRAINT `customer_chk_1` CHECK (regexp_like(`C_CCCD`,_utf8mb4'[0-9]{12}')),
  CONSTRAINT `customer_chk_2` CHECK (regexp_like(`C_tel`,_utf8mb4'^0[0-9]{9}'))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES ('Kaito Ho','000000111111','2002-06-05','Vinh Long','0783939976'),('Le Xuan Thanh','000011112222','2003-04-08','Can Tho','0939522423'),('Anh Tuan','012345678933','2022-01-01','Can Tho','0768811094'),('La Thanh Trong','012345678955','2022-10-19','CT','0123456666'),('Me vo','086123456788','1966-12-20','Vinh Long','0984719935'),('Ho Thi My Nuong','086123456789','1990-02-15','Vinh Long','0000011111'),('Ho Minh Nhut','086202000614','2002-06-05','Vinh Long','0783939975'),('Tran Phuoc loc','092202003294','2002-10-13','ct','0787806521'),('La Thanh Trong','092202005889','2002-04-09','21 Tran Hung Dao, phuong An Cu, quan Ninh Kieu, thanh pho Can Tho','0901248021'),('Duong Thi Yen Nhi','094302002500','2002-11-19','Soc Trang','0975203545'),('Jany','123456789234','2003-01-06','Vinh Long','0379831003'),('Le Minh Man','123456789999','2002-01-01','CT','0886292319'),('Do Thi My Lien','437170690483','1968-01-01','Vinh Long','0363458282'),('Ho Son Hai','662546647274','1968-04-24','Vinh Long','0774825887'),('Ho Thi My Lac','987654321011','1987-06-10','Vinh Long','0222222222');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `debt`
--

DROP TABLE IF EXISTS `debt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `debt` (
  `Debt_Id` varchar(10) NOT NULL,
  `Debt_Amount` int DEFAULT NULL,
  `Debt_date` date DEFAULT NULL,
  `Debt_Rates` float DEFAULT '0.005',
  `Debt_Interest` int DEFAULT NULL,
  PRIMARY KEY (`Debt_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `debt`
--

LOCK TABLES `debt` WRITE;
/*!40000 ALTER TABLE `debt` DISABLE KEYS */;
INSERT INTO `debt` VALUES ('0774825887',20000000,'2022-11-24',0.005,NULL),('0783939975',500000000,'2022-11-01',0.005,NULL);
/*!40000 ALTER TABLE `debt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employment`
--

DROP TABLE IF EXISTS `employment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employment` (
  `E_Id` varchar(10) NOT NULL,
  `P_Id` varchar(10) DEFAULT NULL,
  `E_Name` varchar(50) NOT NULL,
  `E_Dob` date NOT NULL,
  `E_CCCD` varchar(12) NOT NULL,
  `E_Address` varchar(100) DEFAULT NULL,
  `E_Tel` char(10) DEFAULT NULL,
  PRIMARY KEY (`E_Id`),
  UNIQUE KEY `E_CCCD` (`E_CCCD`),
  CONSTRAINT `employment_chk_1` CHECK (regexp_like(`E_tel`,_utf8mb4'^0[0-9]{9}'))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employment`
--

LOCK TABLES `employment` WRITE;
/*!40000 ALTER TABLE `employment` DISABLE KEYS */;
INSERT INTO `employment` VALUES ('E111','01','Kaito','2002-06-05','086202000614','Vinh Long','0783939975'),('E222','02','Ho Thi My Nuong','1990-02-15','554377532674','Vinh Long','0907115290'),('E333','03','Nguyen Duy Khang','2002-01-01','276040255750','Can Tho','0365655800'),('E334','03','La Thanh Trong','2002-01-01','530416897955','Can Tho','0901248021');
/*!40000 ALTER TABLE `employment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `positions`
--

DROP TABLE IF EXISTS `positions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `positions` (
  `P_Id` varchar(10) NOT NULL,
  `Position_Name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`P_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `positions`
--

LOCK TABLES `positions` WRITE;
/*!40000 ALTER TABLE `positions` DISABLE KEYS */;
INSERT INTO `positions` VALUES ('01','Director'),('02','Manager'),('03','Clerk');
/*!40000 ALTER TABLE `positions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trans_detail`
--

DROP TABLE IF EXISTS `trans_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trans_detail` (
  `Trans_Id` int NOT NULL AUTO_INCREMENT,
  `Trans_type` varchar(30) DEFAULT NULL,
  `Sources` varchar(10) DEFAULT NULL,
  `Des` varchar(10) DEFAULT NULL,
  `Trans_Date` date DEFAULT NULL,
  `Amount` int DEFAULT NULL,
  PRIMARY KEY (`Trans_Id`),
  CONSTRAINT `trans_detail_chk_1` CHECK ((`Amount` > 0))
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trans_detail`
--

LOCK TABLES `trans_detail` WRITE;
/*!40000 ALTER TABLE `trans_detail` DISABLE KEYS */;
INSERT INTO `trans_detail` VALUES (1,'Transfer money','0783939975','0379831003','2022-10-26',2000000),(2,'Deposit','0783939975','','2022-10-26',2000000),(3,'Transfer money','0379831003','0783939975','2022-10-26',19000000),(4,'Transfer money','0783939975','0774825887','2022-10-26',20000000),(5,'Deposit','0783939975','0774825887','2022-10-26',50000000),(6,'Deposit','0379831003','0774825887','2022-10-26',50000000),(7,'Withdraw','0379831003','0774825887','2022-10-26',2000000),(8,'Withdraw','0939522423','','2022-10-27',10000000),(9,'Withdraw','0939522423','','2022-10-27',1000000),(10,'Withdraw','0939522423','','2022-10-27',100000),(11,'Withdraw','0901248021','','2022-10-27',1000000),(12,'Transfer money','0783939975','0901248021','2022-10-27',10000000),(13,'Withdraw','0379831003','','2022-10-27',200000000),(14,'Deposit','0783939975','','2022-10-27',9000000),(15,'Withdraw','0783939975','','2022-10-27',1200000),(16,'Transfer money','0783939975','0379831003','2022-10-30',15000000),(17,'Transfer money','0783939975','0379831003','2022-11-18',50000000),(18,'Pay debt','0783939975',NULL,'2022-11-01',1003850),(19,'Transfer money','0783939975','0379831003','2022-11-24',1000000),(20,'Deposit','0783939975','','2022-11-24',10000000),(21,'Deposit','0783939975','0379831003','2022-11-24',1000000),(22,'Deposit','0783939975','','2022-11-24',25000000);
/*!40000 ALTER TABLE `trans_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'PROJECT'
--
/*!50003 DROP FUNCTION IF EXISTS `caculator` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `caculator`(x date) RETURNS int
    DETERMINISTIC
begin 
	declare d int;
    declare m int;
    declare y int;
    set d = x.date();
    return d;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `DELETE_CUS` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `DELETE_CUS`(tel varchar(10))
    DETERMINISTIC
begin
	delete from customer where customer.C_Tel = tel;
    delete from accounts where accounts.A_Id = tel;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `DEPOSIT` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `DEPOSIT`(pA_Id varchar(10), pA_Balance int)
    DETERMINISTIC
begin
		update accounts set A_Balance = A_Balance + pA_Balance where A_Id = pA_Id;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `INSERT_CUS` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `INSERT_CUS`( name varchar(50), cccd varchar(12),  dob date, addr varchar(100), tel char(10), pass varchar(30),bal  int)
    DETERMINISTIC
begin
	insert into customer values(name, cccd, dob, addr, tel);
    insert into accounts values(tel,pass , bal);
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insert_debt` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_debt`(tel varchar(10), a int, d date)
begin 
	insert into Debt(debt_id, debt_amount, debt_date) values(tel, a, d);
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `INSERT_EMP` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `INSERT_EMP`(eid varchar(10), pid varchar(10), name varchar(50), dob date, cccd varchar(12),  addr varchar(100), tel char(10))
    DETERMINISTIC
begin
	insert into employment values(name, cccd , dob , addr , tel);
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `pay` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pay`(id char(10))
begin 
	delete from debt where debt_id = id;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `PROMOTION` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `PROMOTION`(eid varchar(5), pid varchar(5))
    DETERMINISTIC
begin
	update employments set P_Id = pid where E_Id = eid;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `TRANSFER` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `TRANSFER`(Sender_Id varchar(10), Receiver_Id varchar(10), p_Transfer int)
begin
	call Withdraw(Sender_Id, p_Transfer);
    call Deposit(Receiver_Id, p_Transfer);
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `WITHDRAW` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `WITHDRAW`(pA_Id varchar(10), pA_Balance int)
begin
		update accounts set A_Balance = A_Balance - pA_Balance where A_Id = pA_Id;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-27 19:10:31
