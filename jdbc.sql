/*
Navicat MySQL Data Transfer

Source Server         : java
Source Server Version : 50136
Source Host           : localhost:3306
Source Database       : jdbc

Target Server Type    : MYSQL
Target Server Version : 50136
File Encoding         : 65001

Date: 2015-07-16 13:05:57
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `name` varchar(20) NOT NULL DEFAULT '',
  `password` varchar(20) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('rana', '9592', '9592211298');
INSERT INTO `admin` VALUES ('ranayadav', '9592', '9592211298');

-- ----------------------------
-- Table structure for `distributions`
-- ----------------------------
DROP TABLE IF EXISTS `distributions`;
CREATE TABLE `distributions` (
  `disid` int(11) NOT NULL AUTO_INCREMENT,
  `sname` varchar(40) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `amount` bigint(20) DEFAULT NULL,
  `copy` int(11) DEFAULT NULL,
  `pen` int(11) DEFAULT NULL,
  `pencil` int(11) DEFAULT NULL,
  `shoes` int(11) DEFAULT NULL,
  `uniform` int(11) DEFAULT NULL,
  `eatables` int(11) DEFAULT NULL,
  `bag` int(11) DEFAULT NULL,
  `cycle` int(11) DEFAULT NULL,
  `water_bottle` int(11) DEFAULT NULL,
  `tiffin` int(11) DEFAULT NULL,
  `erasor` int(11) DEFAULT NULL,
  `stationary` int(11) DEFAULT NULL,
  `others` int(11) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  PRIMARY KEY (`disid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of distributions
-- ----------------------------
INSERT INTO `distributions` VALUES ('1', 'St.Xavier school,Bathinda', '2016-06-06', '5000', '10', '20', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');

-- ----------------------------
-- Table structure for `donations`
-- ----------------------------
DROP TABLE IF EXISTS `donations`;
CREATE TABLE `donations` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `did` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `mobile` varchar(15) DEFAULT NULL,
  `amount` bigint(20) DEFAULT NULL,
  `mode` varchar(10) DEFAULT NULL,
  `copy` int(11) DEFAULT NULL,
  `pen` int(11) DEFAULT NULL,
  `pencil` int(11) DEFAULT NULL,
  `shoes` int(11) DEFAULT NULL,
  `uniform` int(11) DEFAULT NULL,
  `eatables` int(11) DEFAULT NULL,
  `bag` int(11) DEFAULT NULL,
  `cycle` int(11) DEFAULT NULL,
  `water_bottle` int(11) DEFAULT NULL,
  `tiffin` int(11) DEFAULT NULL,
  `erasor` int(11) DEFAULT NULL,
  `stationary` int(11) DEFAULT NULL,
  `others` varchar(50) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of donations
-- ----------------------------
INSERT INTO `donations` VALUES ('1', '1', 'rana yadav', '959221298', '10000', 'cheque', '1', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '', '0', '2015-05-16');
INSERT INTO `donations` VALUES ('2', '34', 'rana yadav', '9592211298', '10000', 'cheque', '2', '5', '6', '9', '7', '4', '6', '2', '1', '6', '8', '3', 'water cooler', '2', '2015-05-12');

-- ----------------------------
-- Table structure for `doners`
-- ----------------------------
DROP TABLE IF EXISTS `doners`;
CREATE TABLE `doners` (
  `did` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `city` varchar(15) DEFAULT NULL,
  `mobile` varchar(15) DEFAULT NULL,
  `email` varchar(35) DEFAULT NULL,
  PRIMARY KEY (`did`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of doners
-- ----------------------------
INSERT INTO `doners` VALUES ('34', 'rana yadav', 'Individual', 'house no. 202', 'mansa', '9592211298', 'ranayadav222@gmail.com');

-- ----------------------------
-- Table structure for `schools`
-- ----------------------------
DROP TABLE IF EXISTS `schools`;
CREATE TABLE `schools` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `sname` varchar(40) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `head` varchar(20) DEFAULT NULL,
  `mobile` varchar(15) DEFAULT NULL,
  `requirements` varchar(60) DEFAULT NULL,
  `strength` int(11) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of schools
-- ----------------------------
INSERT INTO `schools` VALUES ('2', 'St.Xavier school,Bathinda', 'Bathinda', 'bathinda', 'sudhakar', '9595959595', 'books', '100');
INSERT INTO `schools` VALUES ('3', 'arya sen. sec. school', 'MANSA', 'mansa', 'subha reddy', '8585858585', 'notebooks', '1000');

-- ----------------------------
-- Table structure for `stock`
-- ----------------------------
DROP TABLE IF EXISTS `stock`;
CREATE TABLE `stock` (
  `amount` bigint(20) DEFAULT NULL,
  `copy` int(11) DEFAULT NULL,
  `pen` int(11) DEFAULT NULL,
  `pencil` int(11) DEFAULT NULL,
  `shoes` int(11) DEFAULT NULL,
  `uniform` int(11) DEFAULT NULL,
  `eatables` int(11) DEFAULT NULL,
  `bag` int(11) DEFAULT NULL,
  `cycle` int(11) DEFAULT NULL,
  `water_bottle` int(11) DEFAULT NULL,
  `tiffin` int(11) DEFAULT NULL,
  `erasor` int(11) DEFAULT NULL,
  `stationary` int(11) DEFAULT NULL,
  `others` varchar(40) DEFAULT NULL,
  `count` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of stock
-- ----------------------------
INSERT INTO `stock` VALUES ('40000', '180', '60', '50', '10', '5', '500', '50', '10', '30', '60', '45', '35', 'water cooler', '2');

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('ranayadav', 'rana', '9592', '9592211298');
INSERT INTO `users` VALUES ('udeepgarg', 'udeep', '9592', '9592211298');
