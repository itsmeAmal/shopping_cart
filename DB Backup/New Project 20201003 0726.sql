-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.7.30-log


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema shopping_cart
--

CREATE DATABASE IF NOT EXISTS shopping_cart;
USE shopping_cart;

--
-- Definition of table `item`
--

DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `item_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `item_name` varchar(450) DEFAULT NULL,
  `item_brand` varchar(100) DEFAULT NULL,
  `item_model` varchar(450) DEFAULT NULL,
  `item_serial_no` varchar(450) DEFAULT NULL,
  `item_price` decimal(10,2) DEFAULT NULL,
  `item_status` tinyint(3) unsigned DEFAULT NULL,
  `item_description_1` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `item`
--

/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` (`item_id`,`item_name`,`item_brand`,`item_model`,`item_serial_no`,`item_price`,`item_status`,`item_description_1`) VALUES 
 (1,'Clogard 400g','Clogard','Tooth Paste',NULL,'135.00',1,NULL),
 (2,'Anchor Milk Powder 400g','Anchor','Milk Powder',NULL,'390.00',1,NULL),
 (3,'White Board Marker Pen ( Blue )','Atlas','Marker',NULL,'100.00',1,NULL),
 (4,'Munchee Kome ','Munchee','Biscuit ',NULL,'65.00',1,NULL);
/*!40000 ALTER TABLE `item` ENABLE KEYS */;


--
-- Definition of table `order`
--

DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `order_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `order_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `order_user_id` int(10) unsigned DEFAULT NULL,
  `order_item_count` int(10) unsigned DEFAULT NULL,
  `order_status` tinyint(1) unsigned DEFAULT NULL,
  `order_delivery_address` varchar(450) DEFAULT NULL,
  `order_total_amount` decimal(10,2) DEFAULT NULL,
  `order_discount_percentage` decimal(10,2) DEFAULT NULL,
  `order_description` varchar(450) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `order`
--

/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;


--
-- Definition of table `order_detail`
--

DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail` (
  `order_detail_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `order_detail_order_id` int(10) unsigned DEFAULT NULL,
  `order_detail_item_name` varchar(450) DEFAULT NULL,
  `order_detail_qty` decimal(10,2) DEFAULT NULL,
  `order_detail_status` tinyint(1) unsigned DEFAULT NULL,
  `order_detail_retail_price` decimal(10,2) DEFAULT NULL,
  `order_detail_selling_price` decimal(10,2) DEFAULT NULL,
  `order_detail_description` varchar(450) DEFAULT NULL,
  PRIMARY KEY (`order_detail_id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `order_detail`
--

/*!40000 ALTER TABLE `order_detail` DISABLE KEYS */;
INSERT INTO `order_detail` (`order_detail_id`,`order_detail_order_id`,`order_detail_item_name`,`order_detail_qty`,`order_detail_status`,`order_detail_retail_price`,`order_detail_selling_price`,`order_detail_description`) VALUES 
 (41,0,' Anchor Milk Powder 400g','3.00',NULL,'390.00',NULL,NULL),
 (43,0,' Clogard 400g','1.00',NULL,'135.00',NULL,NULL);
/*!40000 ALTER TABLE `order_detail` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
