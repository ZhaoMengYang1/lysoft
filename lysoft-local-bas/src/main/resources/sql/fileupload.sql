/*
SQLyog Ultimate v11.27 (32 bit)
MySQL - 5.7.31 : Database - fileupload
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`fileupload` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `fileupload`;

/*Table structure for table `file_res` */

DROP TABLE IF EXISTS `file_res`;

CREATE TABLE `file_res` (
  `id` int(10) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `suffix` varchar(50) DEFAULT NULL,
  `uuid` varchar(100) DEFAULT NULL,
  `path` varchar(100) DEFAULT NULL,
  `size` int(50) DEFAULT NULL,
  `md5` varchar(50) DEFAULT NULL,
  `status` int(10) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `file_res` */

/*Table structure for table `imguploadinfo` */

DROP TABLE IF EXISTS `imguploadinfo`;

CREATE TABLE `imguploadinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `imgPath` varchar(300) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `imguploadinfo` */

insert  into `imguploadinfo`(`id`,`imgPath`) values (1,'123test.cn'),(2,'456779test.com'),(3,'http://127.0.0.1:8086/Downloads/imgUpload/test.jpeg');

/*Table structure for table `orderinfo` */

DROP TABLE IF EXISTS `orderinfo`;

CREATE TABLE `orderinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_number` int(30) DEFAULT NULL,
  `order_name` varchar(20) DEFAULT NULL,
  `order_total` int(20) DEFAULT NULL,
  `order_owner` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `orderinfo` */

/*Table structure for table `person` */

DROP TABLE IF EXISTS `person`;

CREATE TABLE `person` (
  `id` int(255) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `age` int(10) DEFAULT NULL,
  `sex` varchar(1) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `ip` int(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `person` */

insert  into `person`(`id`,`name`,`age`,`sex`,`birthday`,`ip`) values (1,'张三',12,'男','2021-04-21',172168057),(2,'李四',13,'男','2021-04-21',172168057),(3,'王五',14,'男','2021-04-21',172168057),(4,'赵六',15,'女','2021-04-21',172168057),(5,'石头',16,'女','2021-04-21',172168057),(6,'华为',88,NULL,NULL,172168057);

/*Table structure for table `shopinfo` */

DROP TABLE IF EXISTS `shopinfo`;

CREATE TABLE `shopinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shop_name` varchar(20) DEFAULT NULL,
  `shop_intro` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `shopinfo` */

/*Table structure for table `t_files` */

DROP TABLE IF EXISTS `t_files`;

CREATE TABLE `t_files` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `oldFileName` varchar(200) DEFAULT NULL,
  `newFileName` varchar(300) DEFAULT NULL,
  `ext` varchar(20) DEFAULT NULL,
  `path` varchar(300) DEFAULT NULL,
  `size` varchar(200) DEFAULT NULL,
  `type` varchar(120) DEFAULT NULL,
  `isImg` varchar(8) DEFAULT NULL,
  `downcounts` int(6) DEFAULT NULL,
  `uploadTime` datetime DEFAULT NULL,
  `userId` int(8) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `userId` (`userId`),
  CONSTRAINT `userId` FOREIGN KEY (`userId`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_files` */

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int(8) NOT NULL,
  `username` varchar(80) DEFAULT NULL,
  `password` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`username`,`password`) values (1,'xiaochen','123456'),(2,'zhangsan','123456'),(3,'李四','123456'),(4,'王武','123456'),(5,'石头','123456'),(6,'田七','123456'),(7,'老八','123456'),(8,'赵六','123456'),(9,'张坤','123456');

/*Table structure for table `userinfo` */

DROP TABLE IF EXISTS `userinfo`;

CREATE TABLE `userinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `user_intro` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `userinfo` */

insert  into `userinfo`(`id`,`username`,`password`,`sex`,`phone`,`user_intro`) values (2,'test,test','123456,123456',NULL,NULL,NULL),(3,'test,test,test','123456,123456,123',NULL,NULL,NULL),(4,'test,test,test,testing','123456,123456,123,123456',NULL,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
