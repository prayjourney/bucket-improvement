-- 导出 test 的数据库结构
CREATE DATABASE IF NOT EXISTS `test`;
USE `test`;

-- 导出  表 test.account 结构
CREATE TABLE IF NOT EXISTS `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `balance` double NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- 正在导出表  test.account 的数据：~2 rows (大约)
INSERT INTO `account` (`id`, `name`, `balance`) VALUES
	(1, '张三', 522),
	(2, '李四', 170);


-- 导出  表 test.book 结构
CREATE TABLE IF NOT EXISTS `book` (
  `isbn` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `price` int(11) DEFAULT 0,
  `stock` int(11) DEFAULT 0,
  PRIMARY KEY (`isbn`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- 正在导出表  test.book 的数据：~2 rows (大约)
INSERT INTO `book` (`isbn`, `name`, `price`, `stock`) VALUES
	(1, '雪山飞狐', 39, 95),
	(2, 'Java编程思想', 75, 12),
	(3, '面向对象编程', 50, 2);