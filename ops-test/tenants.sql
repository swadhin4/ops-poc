-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.6.37-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for tenants
DROP DATABASE IF EXISTS `tenants`;
CREATE DATABASE IF NOT EXISTS `tenants` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `tenants`;

-- Dumping structure for table tenants.tenants
DROP TABLE IF EXISTS `tenants`;
CREATE TABLE IF NOT EXISTS `tenants` (
  `tenant_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_email` varchar(50) NOT NULL,
  `company_code` varchar(50) NOT NULL,
  `db_name` varchar(50) NOT NULL,
  PRIMARY KEY (`tenant_id`),
  UNIQUE KEY `user_email` (`user_email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table tenants.tenants: ~2 rows (approximately)
/*!40000 ALTER TABLE `tenants` DISABLE KEYS */;
INSERT INTO `tenants` (`tenant_id`, `user_email`, `company_code`, `db_name`) VALUES
	(1, 'swadhin4@gmail.com', 'GB01', 'opstenant1'),
	(2, 'malay18@bp.com', 'EUG', 'opstenant2');
/*!40000 ALTER TABLE `tenants` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
