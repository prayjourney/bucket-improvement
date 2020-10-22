/*
Navicat MySQL Data Transfer

Source Server         : mariadb
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2019-10-11 23:55:22
*/

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`
(
    `id`     int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `name`   varchar(100) DEFAULT NULL COMMENT '姓名',
    `age`    int(11)      DEFAULT NULL COMMENT '年龄',
    `salary` double       DEFAULT NULL COMMENT '工资',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 7
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee`
VALUES ('1', '张飞', '35', '10000');
INSERT INTO `employee`
VALUES ('2', '刘备', '42', '50000');
INSERT INTO `employee`
VALUES ('3', '关羽', '39', '30000');
INSERT INTO `employee`
VALUES ('4', '赵云', '27', '12000');
INSERT INTO `employee`
VALUES ('5', '黄忠', '56', '20000');
INSERT INTO `employee`
VALUES ('6', '马超', '25', '17000');
