/*
Navicat MySQL Data Transfer

Source Server         : 虚拟机
Source Server Version : 50717
Source Host           : 192.168.134.3:3306
Source Database       : mms

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-05-03 22:37:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for f_category
-- ----------------------------
DROP TABLE IF EXISTS `f_category`;
CREATE TABLE `f_category` (
  `Id` bigint(11) NOT NULL COMMENT '编号',
  `Pid` bigint(11) DEFAULT NULL COMMENT '父编号',
  `Name` varchar(4000) DEFAULT NULL COMMENT '名称',
  `remark` varchar(4000) DEFAULT NULL COMMENT '注释',
  `CreatorId` bigint(11) DEFAULT NULL COMMENT '创建人编号',
  `CreatorName` varchar(4000) DEFAULT NULL COMMENT '创建人姓名',
  `CreateDate` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建日期',
  `DataLevel` tinyint(1) unsigned zerofill DEFAULT '0' COMMENT '数据级别 0正常 1审核中 2被否决 -1已删除 -2草稿',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='礼品分类 礼分类表';

-- ----------------------------
-- Records of f_category
-- ----------------------------

-- ----------------------------
-- Table structure for f_count_record
-- ----------------------------
DROP TABLE IF EXISTS `f_count_record`;
CREATE TABLE `f_count_record` (
  `Id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `f_member_id` bigint(11) DEFAULT NULL COMMENT '会员id',
  `count_type` decimal(1,0) DEFAULT NULL COMMENT '金额类型 0 表示充值 1表示消费',
  `sum` double DEFAULT NULL COMMENT '金额',
  `pay_type` decimal(1,0) DEFAULT NULL COMMENT '付款方式 付款方式 0 表示默认为余额消费 1表示 现金消费 2同时使用余额与现金',
  `pay_monery` double DEFAULT NULL COMMENT '现金',
  `remark` varchar(4000) DEFAULT NULL COMMENT '备注',
  `CreatorId` bigint(11) DEFAULT NULL COMMENT '创建人编号',
  `CreatorName` varchar(4000) DEFAULT NULL COMMENT '创建人姓名',
  `CreateDate` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建日期',
  `DataLevel` tinyint(1) unsigned zerofill DEFAULT '0' COMMENT '数据级别 0正常 1审核中 2被否决 -1已删除 -2草稿',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='金额表 金额记录';

-- ----------------------------
-- Records of f_count_record
-- ----------------------------

-- ----------------------------
-- Table structure for f_member
-- ----------------------------
DROP TABLE IF EXISTS `f_member`;
CREATE TABLE `f_member` (
  `Id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(4000) DEFAULT NULL COMMENT '会员姓名',
  `Sex` tinyint(1) DEFAULT NULL COMMENT '性别 0未知 1男 2女',
  `Tel` varchar(4000) DEFAULT NULL COMMENT '电话',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `card_NO` varchar(4000) DEFAULT NULL COMMENT '会员卡号',
  `card_date` datetime DEFAULT NULL COMMENT '有效期',
  `card_monery` double(11,0) DEFAULT NULL COMMENT '会员当前余额',
  `f_vip_id` bigint(11) DEFAULT NULL COMMENT '会员等级',
  `f_vip_name` varchar(4000) DEFAULT NULL COMMENT '会员级别',
  `f_point_sum` double(11,0) DEFAULT NULL COMMENT '会员卡积分',
  `CreatorId` bigint(11) DEFAULT NULL COMMENT '创建人编号',
  `CreatorName` varchar(4000) DEFAULT NULL COMMENT '创建人姓名',
  `CreateDate` datetime DEFAULT NULL COMMENT '创建日期',
  `DataLevel` tinyint(1) unsigned zerofill DEFAULT '0' COMMENT '数据级别 0正常 1审核中 2被否决 -1已删除 -2草稿',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员 会员信息';

-- ----------------------------
-- Records of f_member
-- ----------------------------

-- ----------------------------
-- Table structure for f_point_record
-- ----------------------------
DROP TABLE IF EXISTS `f_point_record`;
CREATE TABLE `f_point_record` (
  `Id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `f_member_id` bigint(11) DEFAULT NULL COMMENT '会员id',
  `point_type` tinyint(1) DEFAULT NULL COMMENT '积分类型 0 表示累计 1表示消费',
  `point` double DEFAULT NULL COMMENT '积分',
  `f_product_id` bigint(11) DEFAULT NULL COMMENT '兑换礼品id',
  `count` double(11,0) DEFAULT NULL COMMENT '数量',
  `remark` varchar(4000) DEFAULT NULL COMMENT '备注',
  `CreatorId` bigint(11) DEFAULT NULL COMMENT '创建人编号',
  `CreatorName` varchar(4000) DEFAULT NULL COMMENT '创建人姓名',
  `CreateDate` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建日期',
  `DataLevel` bigint(1) unsigned zerofill DEFAULT '0' COMMENT '数据级别 0正常 1审核中 2被否决 -1已删除 -2草稿',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='积分表 会员积分记录表';

-- ----------------------------
-- Records of f_point_record
-- ----------------------------

-- ----------------------------
-- Table structure for f_product
-- ----------------------------
DROP TABLE IF EXISTS `f_product`;
CREATE TABLE `f_product` (
  `Id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `Name` varchar(4000) DEFAULT NULL COMMENT '名称',
  `price` double DEFAULT NULL COMMENT '价值',
  `point` bigint(11) DEFAULT NULL COMMENT '所需积分',
  `num` bigint(11) DEFAULT NULL COMMENT '数量',
  `CreatorId` bigint(11) DEFAULT NULL COMMENT '创建人编号',
  `CreatorName` varchar(4000) DEFAULT NULL COMMENT '创建人姓名',
  `CreateDate` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建日期',
  `DataLevel` bigint(1) unsigned zerofill DEFAULT '0' COMMENT '数据级别 0正常 1审核中 2被否决 -1已删除 -2草稿',
  `OrderNo` double DEFAULT NULL COMMENT '排序号',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='礼品 礼品表';

-- ----------------------------
-- Records of f_product
-- ----------------------------

-- ----------------------------
-- Table structure for f_user_wages
-- ----------------------------
DROP TABLE IF EXISTS `f_user_wages`;
CREATE TABLE `f_user_wages` (
  `Id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `sys_User_id` bigint(11) DEFAULT NULL COMMENT '员工ID',
  `wages` double DEFAULT NULL COMMENT '工资',
  `CreatorId` bigint(11) DEFAULT NULL COMMENT '创建人编号',
  `CreatorName` varchar(4000) DEFAULT NULL COMMENT '创建人姓名',
  `CreateDate` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建日期',
  `DataLevel` bigint(11) DEFAULT NULL COMMENT '数据级别 0正常 1审核中 2被否决 -1已删除 -2草稿',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='员工工资 员工工资表';

-- ----------------------------
-- Records of f_user_wages
-- ----------------------------

-- ----------------------------
-- Table structure for f_vip
-- ----------------------------
DROP TABLE IF EXISTS `f_vip`;
CREATE TABLE `f_vip` (
  `Id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `Name` varchar(4000) DEFAULT NULL COMMENT '名称',
  `remark` varchar(4000) DEFAULT NULL COMMENT '注释',
  `discount` bigint(11) DEFAULT NULL COMMENT '折扣',
  `point` bigint(11) DEFAULT NULL COMMENT '换算积分',
  `CreatorId` bigint(11) DEFAULT NULL COMMENT '创建人编号',
  `CreatorName` varchar(4000) DEFAULT NULL COMMENT '创建人姓名',
  `CreateDate` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建日期',
  `DataLevel` tinyint(1) unsigned zerofill DEFAULT '0' COMMENT '数据级别 0正常 1审核中 2被否决 -1已删除 -2草稿',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of f_vip
-- ----------------------------

-- ----------------------------
-- Table structure for Sys_Menu
-- ----------------------------
DROP TABLE IF EXISTS `Sys_Menu`;
CREATE TABLE `Sys_Menu` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单编号',
  `Menu_Name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `Menu_Type` tinyint(1) DEFAULT NULL COMMENT '菜单类型 菜单类型(0:CURD;1:系统菜单;2:业务菜单;)',
  `Parent_Id` bigint(20) DEFAULT NULL COMMENT '上级菜单编号',
  `ICOnCls` varchar(50) DEFAULT NULL COMMENT '节点图标CSS类名',
  `Request_URL` varchar(100) DEFAULT NULL COMMENT '请求地址',
  `Sort_No` bigint(2) DEFAULT NULL COMMENT '排序号',
  `Remark` varchar(1024) DEFAULT NULL COMMENT '备注',
  `CreatorId` bigint(11) DEFAULT NULL COMMENT '创建人编号',
  `CreatorName` varchar(4000) DEFAULT NULL COMMENT '创建人姓名',
  `CreateDate` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建日期',
  `DataLevel` tinyint(1) unsigned zerofill DEFAULT '0' COMMENT '数据级别 0正常 1审核中 2被否决 -1已删除 -2草稿',
  `OrderNo` double DEFAULT NULL COMMENT '排序号',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单 菜单表';

-- ----------------------------
-- Records of Sys_Menu
-- ----------------------------

-- ----------------------------
-- Table structure for Sys_Role
-- ----------------------------
DROP TABLE IF EXISTS `Sys_Role`;
CREATE TABLE `Sys_Role` (
  `Id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '角色编号',
  `Role_Name` varchar(50) DEFAULT NULL COMMENT '角色名称',
  `Role_Type` tinyint(1) DEFAULT NULL COMMENT '角色类型 角色类型(1:业务角色;2:管理角色;3:系统内置角色)',
  `Remark_` varchar(1024) DEFAULT NULL COMMENT '备注',
  `CreatorId` bigint(11) DEFAULT NULL COMMENT '创建人编号',
  `CreatorName` varchar(4000) DEFAULT NULL COMMENT '创建人姓名',
  `CreateDate` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建日期',
  `DataLevel` tinyint(1) unsigned zerofill DEFAULT '0' COMMENT '数据级别 0正常 1审核中 2被否决 -1已删除 -2草稿',
  `OrderNo` int(11) DEFAULT NULL COMMENT '排序号',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户角色表';

-- ----------------------------
-- Records of Sys_Role
-- ----------------------------
INSERT INTO `Sys_Role` VALUES ('1', '系统内置管理员', '3', '平台内置的管理员不做处理', '1', '管理员', '2017-05-01 12:50:10', '0', '1');
INSERT INTO `Sys_Role` VALUES ('2', '系统管理员', '2', '配置管理员', '1', '管理员', '2017-05-01 12:51:42', '0', '2');
INSERT INTO `Sys_Role` VALUES ('3', '员工', '1', '业务角色', '1', '管理员', '2017-05-01 12:53:18', '0', '3');

-- ----------------------------
-- Table structure for Sys_Role_menu
-- ----------------------------
DROP TABLE IF EXISTS `Sys_Role_menu`;
CREATE TABLE `Sys_Role_menu` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sys_Role_Id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `sys_Menu_Id` bigint(20) DEFAULT NULL COMMENT '菜单ID',
  `Remark` varchar(1024) DEFAULT NULL,
  `CreatorId` bigint(11) DEFAULT NULL COMMENT '创建人编号',
  `CreatorName` varchar(4000) DEFAULT NULL COMMENT '创建人姓名',
  `CreateDate` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建日期',
  `DataLevel` tinyint(1) unsigned zerofill DEFAULT '0' COMMENT '数据级别 0正常 1审核中 2被否决 -1已删除 -2草稿',
  `OrderNo` int(11) DEFAULT NULL COMMENT '排序号',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色授权 角色授权表';

-- ----------------------------
-- Records of Sys_Role_menu
-- ----------------------------

-- ----------------------------
-- Table structure for Sys_User
-- ----------------------------
DROP TABLE IF EXISTS `Sys_User`;
CREATE TABLE `Sys_User` (
  `Id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `Account` varchar(4000) DEFAULT NULL COMMENT '登陆用户名',
  `Name` varchar(4000) DEFAULT NULL COMMENT '名称',
  `Sex` tinyint(1) DEFAULT NULL COMMENT '性别 性别(0:未知;1:男;2:女)',
  `Password` varchar(4000) DEFAULT NULL COMMENT '密码',
  `User_Type` decimal(1,0) DEFAULT NULL COMMENT '人员类型 人员类型(1:管理员;2:员工;)',
  `Phone` varchar(50) DEFAULT NULL COMMENT '电话',
  `Email` varchar(64) DEFAULT NULL COMMENT '邮箱',
  `Birth_Day` datetime DEFAULT NULL COMMENT '出生日期',
  `Position` varchar(64) DEFAULT NULL COMMENT '职位',
  `Address` varchar(256) DEFAULT NULL COMMENT '详细地址',
  `Staff_No` varchar(32) DEFAULT NULL COMMENT '工号',
  `CreatorId` bigint(11) DEFAULT NULL COMMENT '创建人编号',
  `CreatorName` varchar(4000) DEFAULT NULL COMMENT '创建人姓名',
  `CreateDate` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建日期',
  `DataLevel` tinyint(1) unsigned zerofill DEFAULT '0' COMMENT '数据级别 0正常 1审核中 2被否决 -1已删除 -2草稿',
  `OrderNo` int(11) DEFAULT NULL COMMENT '排序号',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户表 后台用户表，管理员与员工';

-- ----------------------------
-- Records of Sys_User
-- ----------------------------
INSERT INTO `Sys_User` VALUES ('1', 'admin', '管理员', '1', 'admin', '1', '13800000000', null, '2017-05-02 12:46:35', '老板', '上海', '001', '1', '管理员', '2017-05-01 12:46:59', '1', '1');

-- ----------------------------
-- Table structure for Sys_User_Role
-- ----------------------------
DROP TABLE IF EXISTS `Sys_User_Role`;
CREATE TABLE `Sys_User_Role` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `sys_User_Id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `sys_Role_Id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `CreatorId` bigint(11) DEFAULT NULL COMMENT '创建人编号',
  `CreatorName` varchar(4000) DEFAULT NULL COMMENT '创建人姓名',
  `CreateDate` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建日期',
  `DataLevel` tinyint(1) unsigned zerofill DEFAULT '0' COMMENT '数据级别 0正常 1审核中 2被否决 -1已删除 -2草稿',
  `OrderNo` double DEFAULT NULL COMMENT '排序号',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户授权角色 用户授权角色';

-- ----------------------------
-- Records of Sys_User_Role
-- ----------------------------
INSERT INTO `Sys_User_Role` VALUES ('1', '1', '1', '1', '管理员', '2017-05-01 12:53:47', '0', '1');
INSERT INTO `Sys_User_Role` VALUES ('2', '1', '2', '1', '管理员', '2017-05-01 12:54:49', '0', '2');
INSERT INTO `Sys_User_Role` VALUES ('3', '1', '3', '1', '管理员', '2017-05-01 12:55:10', '0', '3');
