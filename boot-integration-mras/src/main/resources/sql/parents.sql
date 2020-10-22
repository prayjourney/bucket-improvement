/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 myschool 的数据库结构
CREATE DATABASE IF NOT EXISTS `myschool` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `myschool`;

-- 导出  表 myschool.parents 结构
CREATE TABLE IF NOT EXISTS `parents` (
  `parentsId` int(11) NOT NULL AUTO_INCREMENT COMMENT '父母id',
  `fatherName` varchar(50) DEFAULT NULL,
  `motherName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`parentsId`)
) ENGINE=InnoDB AUTO_INCREMENT=113 DEFAULT CHARSET=utf8;

-- 正在导出表  myschool.parents 的数据：~10 rows (大约)
/*!40000 ALTER TABLE `parents` DISABLE KEYS */;
INSERT INTO `parents` (`parentsId`, `fatherName`, `motherName`) VALUES
	(100, '天', '地'),
	(103, '石头人', '大地'),
	(104, '李靖', '殷夫人'),
	(105, '黄飞虎', '贾夫人'),
	(106, '文王', '无'),
	(108, '张飞', '刘夫人');
/*!40000 ALTER TABLE `parents` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
