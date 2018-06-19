/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50510
Source Host           : localhost:3306
Source Database       : jdbctest

Target Server Type    : MYSQL
Target Server Version : 50510
File Encoding         : 65001

Date: 2012-05-15 20:59:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `userinfo`
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(32) DEFAULT '',
  `user_password` varchar(32) DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('1', 'devil13th', '123456', '初始化数据');
INSERT INTO `userinfo` VALUES ('2', 'thirdteendevil', 'abcde', '初始化数据');
