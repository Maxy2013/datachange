/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : emp

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2018-09-26 11:39:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `dept`
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `d_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '部门编号',
  `d_name` int(255) DEFAULT NULL COMMENT '部门名称  1.研发部  2.人事部  3.公关部  4.教育部',
  `d_location` varchar(255) DEFAULT NULL COMMENT '部门地点',
  `d_wei` varchar(255) DEFAULT NULL COMMENT '部门大小  分为：小型、中小型、大型、特大型',
  PRIMARY KEY (`d_id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('1', '1', '深圳', '特大型');
INSERT INTO `dept` VALUES ('2', '2', '北京', '小型');
INSERT INTO `dept` VALUES ('3', '3', '广州', '中小型');
INSERT INTO `dept` VALUES ('4', '2', '河南', '大型');
INSERT INTO `dept` VALUES ('5', '4', '北京', '小型');
INSERT INTO `dept` VALUES ('6', '3', '天津', '特大型');
INSERT INTO `dept` VALUES ('7', '2', '上海', '中小型');
INSERT INTO `dept` VALUES ('8', '5', '5', '');

-- ----------------------------
-- Table structure for `emp`
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp` (
  `e_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '员工编号',
  `e_portrait` varchar(255) DEFAULT NULL COMMENT '员工头像',
  `e_name` varchar(255) DEFAULT NULL COMMENT '员工账号',
  `e_pwd` varchar(255) DEFAULT NULL COMMENT '员工密码  要md5加密',
  `e_uname` varchar(255) DEFAULT NULL COMMENT '员工姓名',
  `e_birthday` date DEFAULT NULL COMMENT '员工生日',
  `e_level` int(11) DEFAULT NULL COMMENT '员工级别 1.王者  2.黄金  3.青铜 4.白银',
  `e_six` int(11) DEFAULT NULL COMMENT '员工性别  1.男  2.女',
  `e_wages` int(255) DEFAULT NULL COMMENT '员工工资',
  `e_hobby` varchar(255) DEFAULT NULL COMMENT '员工爱好',
  `e_mibiao` varchar(255) DEFAULT NULL COMMENT '员工密保人',
  `e_midaan` varchar(255) DEFAULT NULL COMMENT '员工密保答案',
  `e_add` datetime DEFAULT NULL COMMENT '员工创建时间',
  `e_update` datetime DEFAULT NULL COMMENT '员工更新时间',
  `e_login` datetime DEFAULT NULL COMMENT '员工上一次登录时间',
  `e_xzlogin` datetime DEFAULT NULL COMMENT '员工现在登录时间',
  `e_deptId` int(11) DEFAULT NULL COMMENT '员工外键',
  PRIMARY KEY (`e_id`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of emp
-- ----------------------------
INSERT INTO `emp` VALUES ('1', 'img/123.jpg', '123', 'dsf3423csqad', '方法', '1018-04-08', '1', '1', '5415', '敲代码', '敲代码的时间？', '1111', '2018-04-04 12:18:54', '2018-04-08 13:18:57', '2018-04-08 12:19:01', '2018-04-03 12:19:05', '1');
INSERT INTO `emp` VALUES ('2', 'img/123.jpg', '344', '432fwsdg321', 'gsfdg', '2009-04-03', '2', '2', '21416', '王者荣耀', 'vgedr', 'gwsd', '2018-03-27 12:19:47', '2018-03-01 12:19:51', '2018-04-08 12:19:55', '2018-04-08 12:19:58', '2');
INSERT INTO `emp` VALUES ('3', 'img/123.jpg', '6547', 'vdhnet2345234', 'fsdg', '1989-01-08', '3', '2', '64536', '前端游戏', '6t345', '52346fge', '2018-04-02 12:20:52', '2018-04-08 12:20:55', '2018-01-08 12:20:58', '2018-01-30 12:21:01', '3');
INSERT INTO `emp` VALUES ('4', 'img/123.jpg', '63456', 'g3erty', '52346', '2000-02-08', '4', '1', '444', '后端游戏', '562346t', 'vwetg', '2018-04-15 12:21:32', '2018-04-26 12:21:35', '2018-04-08 12:21:40', '2018-04-08 12:21:43', '4');
INSERT INTO `emp` VALUES ('5', 'img/123.jpg', 't3456y', 'v3wer24356', '5623456v2', '1988-04-03', '3', '2', '4564', '敲代码', 'efrh', '4123', '2018-04-02 12:22:20', '2018-04-08 12:22:23', '2018-04-10 12:22:26', '2018-04-08 12:22:29', '5');
INSERT INTO `emp` VALUES ('6', 'img/123.jpg', '5234', 'fwert', '5324', '1983-04-04', '2', '1', '3245', '王者荣耀', 'gfed', 'gfed', '2018-03-26 12:22:53', '2018-05-08 12:22:56', '2010-04-08 12:23:00', '2009-04-08 12:23:05', '6');
INSERT INTO `emp` VALUES ('7', 'img/123.jpg', '5555234', 'fwer66t', '536624', '1018-04-04', '2', '1', '3245', '睡觉', 'gfed', 'gfed', '2018-03-26 12:22:53', '2018-05-08 12:22:56', '2010-04-08 12:23:00', '2009-04-08 12:23:05', '7');
INSERT INTO `emp` VALUES ('10', '121', '121', '121', '121', '2011-09-01', '3', '1', '3454', '121', '121', '121', '2018-05-29 14:50:15', '2018-05-29 14:50:15', '2018-05-29 14:50:15', '2018-05-29 14:50:15', '1');
INSERT INTO `emp` VALUES ('11', '121', '121', '121', '121', '2011-09-01', '3', '1', '3454', '121', '121', '121', '2018-05-29 14:58:36', '2018-05-29 14:58:36', '2018-05-29 14:58:36', '2018-05-29 14:58:36', '1');
INSERT INTO `emp` VALUES ('12', '121', '121', '121', '121', '2011-09-01', '3', '1', '3454', '121', '121', '121', '2018-09-26 11:38:24', '2018-09-26 11:38:24', '2018-09-26 11:38:24', '2018-09-26 11:38:24', '1');
