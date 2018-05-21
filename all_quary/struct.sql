create database ArunDB;
use ArunDB;


create table Demo
(
	name varchar(20)
);

select * from admin;

insert into admin values('abhi',12345,8392936919);







INSERT INTO `admin` VALUES ('arun', '8055', '9515536835');
	INSERT INTO `admin` VALUES ('arunyadav', '8055', '9515536835');


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

INSERT INTO `distributions` VALUES ('1', 'St.Xavier school,Bathinda', '2016-06-06', '5000', '10', '20', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `distributions` VALUES ('2', 'St.pauls school,surat', '2017-11-11', '4000', '12', '22', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `distributions` VALUES ('3', 'St. yunas school,etah', '2017-12-12', '4500', '13', '23', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');




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
    
   INSERT INTO `donations` VALUES ('1', '1', 'arun yadav', '959221298', '10000', 'cheque', '1', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '', '0', '2015-05-16');
	INSERT INTO `donations` VALUES ('2', '34', 'arun yadav', '9592211298', '10000', 'cheque', '2', '5', '6', '9', '7', '4', '6', '2', '1', '6', '8', '3', 'water cooler', '2', '2015-05-12'); 
    INSERT INTO `donations` VALUES ('3', '2', 'abhi yadav', '8392936919', '20000', 'cheque', '1', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '', '0', '2017-03-14');
	INSERT INTO `donations` VALUES ('4', '35', 'anuj yadav', '9515536835', '30000', 'cheque', '2', '5', '6', '9', '7', '4', '6', '2', '1', '6', '8', '3', 'coffee maker', '2', '2015-05-12'); 
    
    
    
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
   
    
INSERT INTO `doners` VALUES ('34', 'arun yadav', 'Individual', 'house no. 202', 'mansa', '9592211298', 'arunyc2@gmail.com');
INSERT INTO `doners` VALUES ('36', 'anuj yadav', 'Individual', 'house no. 505', 'etah', '9515536835', 'anujyc2@gmail.com');



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

INSERT INTO `schools` VALUES ('2', 'St.Xavier school,Bathinda', 'Bathinda', 'bathinda', 'sudhakar', '9595959595', 'books', '100');
	INSERT INTO `schools` VALUES ('3', 'arya sen. sec. school', 'MANSA', 'mansa', 'subha reddy', '8585858585', 'notebooks', '1000');


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
    
    
  INSERT INTO `stock` VALUES ('40000', '180', '60', '50', '10', '5', '500', '50', '10', '30', '60', '45', '35', 'water cooler', '2');  
    
    
   DROP TABLE IF EXISTS `users`;
	CREATE TABLE `users` (
	  `username` varchar(20) NOT NULL,
	  `name` varchar(20) DEFAULT NULL,
	  `password` varchar(20) DEFAULT NULL,
	  `mobile` varchar(20) DEFAULT NULL,
	  PRIMARY KEY (`username`)
	) ENGINE=InnoDB DEFAULT CHARSET=latin1;
 
    
  INSERT INTO `users` VALUES ('arunyadav', 'arun', '8055', '9515536835');
	INSERT INTO `users` VALUES ('udeepgarg', 'udeep', '8055', '9515536835');  
    INSERT INTO `users` VALUES ('abhiadav', 'abhi', '12345', '9515536835');
	INSERT INTO `users` VALUES ('annu', 'ann', '54321', '8392936919'); 
    
    
    
    
    
    
    
    
    
    
    
    
    






















