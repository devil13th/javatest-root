/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50510
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50510
File Encoding         : 65001

Date: 2015-07-16 08:33:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `pro_id` varchar(50) NOT NULL DEFAULT '',
  `pro_name` varchar(50) DEFAULT NULL,
  `sort_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`pro_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('2c9a40dd4e9141f2014e9141f4820002', '产品', '1111');

-- ----------------------------
-- Table structure for `sort`
-- ----------------------------
DROP TABLE IF EXISTS `sort`;
CREATE TABLE `sort` (
  `sort_id` varchar(50) NOT NULL DEFAULT '',
  `sort_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`sort_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sort
-- ----------------------------
INSERT INTO `sort` VALUES ('2c9a40dd4e9141f2014e9141f47d0001', '分类');

-- ----------------------------
-- View structure for `custom`
-- ----------------------------
DROP VIEW IF EXISTS `custom`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `custom` AS select distinct `test`.`ship_owner`.`cus_name` AS `cus_name`,`test`.`ship_owner`.`cus_addr` AS `cus_addr`,`test`.`ship_owner`.`cus_usr_name` AS `cus_usr_name`,`test`.`ship_owner`.`cus_usr_tel` AS `cus_usr_tel`,`test`.`ship_owner`.`cus_usr_phone` AS `cus_usr_phone`,`test`.`ship_owner`.`cus_usr_fax` AS `cus_usr_fax`,`test`.`ship_owner`.`cus_usr_mail` AS `cus_usr_mail` from `ship_owner` where ((`test`.`ship_owner`.`cus_name` is not null) and (not((`test`.`ship_owner`.`cus_name` like '')))) order by `test`.`ship_owner`.`cus_name`;

-- ----------------------------
-- View structure for `custom2`
-- ----------------------------
DROP VIEW IF EXISTS `custom2`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `custom2` AS select distinct `test`.`ship_owner2`.`cus_name` AS `cus_name`,`test`.`ship_owner2`.`cus_addr` AS `cus_addr`,`test`.`ship_owner2`.`cus_usr_name` AS `cus_usr_name`,`test`.`ship_owner2`.`cus_usr_tel` AS `cus_usr_tel`,`test`.`ship_owner2`.`cus_usr_phone` AS `cus_usr_phone`,`test`.`ship_owner2`.`cus_usr_fax` AS `cus_usr_fax`,`test`.`ship_owner2`.`cus_usr_mail` AS `cus_usr_mail` from `ship_owner2` where ((`test`.`ship_owner2`.`cus_name` is not null) and (not((`test`.`ship_owner2`.`cus_name` like '')))) order by `test`.`ship_owner2`.`cus_name`;

-- ----------------------------
-- View structure for `more1`
-- ----------------------------
DROP VIEW IF EXISTS `more1`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `more1` AS select `yz`.`cus_name` AS `cus_name`,`yz`.`ct` AS `ct` from `yz` where (`yz`.`ct` > 1) order by `yz`.`ct` desc;

-- ----------------------------
-- View structure for `more2`
-- ----------------------------
DROP VIEW IF EXISTS `more2`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `more2` AS select `yz2`.`cus_name` AS `cus_name`,`yz2`.`ct` AS `ct` from `yz2` where (`yz2`.`ct` > 1) order by `yz2`.`ct` desc;

-- ----------------------------
-- View structure for `result1`
-- ----------------------------
DROP VIEW IF EXISTS `result1`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `result1` AS select `yz`.`cus_name` AS `cus_name`,`yz`.`ct` AS `ct` from `yz` where (`yz`.`ct` <= 1) order by `yz`.`ct` desc;

-- ----------------------------
-- View structure for `result2`
-- ----------------------------
DROP VIEW IF EXISTS `result2`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `result2` AS select `yz2`.`cus_name` AS `cus_name`,`yz2`.`ct` AS `ct` from `yz2` where (`yz2`.`ct` <= 1) order by `yz2`.`ct` desc;

-- ----------------------------
-- View structure for `yz`
-- ----------------------------
DROP VIEW IF EXISTS `yz`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `yz` AS select `custom`.`cus_name` AS `cus_name`,count(distinct `custom`.`cus_addr`,`custom`.`cus_usr_fax`,`custom`.`cus_usr_name`,`custom`.`cus_usr_tel`,`custom`.`cus_usr_phone`,`custom`.`cus_usr_mail`) AS `ct` from `custom` group by `custom`.`cus_name`;

-- ----------------------------
-- View structure for `yz2`
-- ----------------------------
DROP VIEW IF EXISTS `yz2`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `yz2` AS select `custom2`.`cus_name` AS `cus_name`,count(distinct `custom2`.`cus_addr`,`custom2`.`cus_usr_fax`,`custom2`.`cus_usr_name`,`custom2`.`cus_usr_tel`,`custom2`.`cus_usr_phone`,`custom2`.`cus_usr_mail`) AS `ct` from `custom2` group by `custom2`.`cus_name`;

-- ----------------------------
-- View structure for `单一记录船舶所有人`
-- ----------------------------
DROP VIEW IF EXISTS `单一记录船舶所有人`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `单一记录船舶所有人` AS select `c`.`cus_name` AS `cus_name`,`c`.`cus_addr` AS `cus_addr`,`c`.`cus_usr_name` AS `cus_usr_name`,`c`.`cus_usr_tel` AS `cus_usr_tel`,`c`.`cus_usr_phone` AS `cus_usr_phone`,`c`.`cus_usr_fax` AS `cus_usr_fax`,`c`.`cus_usr_mail` AS `cus_usr_mail` from `custom` `c` where `c`.`cus_name` in (select `result2`.`cus_name` from `result2`);

-- ----------------------------
-- Procedure structure for `myproc`
-- ----------------------------
DROP PROCEDURE IF EXISTS `myproc`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `myproc`()
begin 
   select * from a;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for `myproc01`
-- ----------------------------
DROP PROCEDURE IF EXISTS `myproc01`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `myproc01`(in a int,in b int)
BEGIN
declare  c int;
set c = a+b;
select c;
	
END
;;
DELIMITER ;
