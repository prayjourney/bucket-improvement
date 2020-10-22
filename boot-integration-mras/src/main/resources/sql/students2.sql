/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出  表 myschool.student 结构
CREATE TABLE IF NOT EXISTS `student` (
  `stId` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `stName` varchar(50) NOT NULL COMMENT '姓名',
  `stAge` int(2) NOT NULL COMMENT '年龄',
  `stPhoneNo` varchar(11) DEFAULT '000000' COMMENT '手机',
  `stGender` varchar(4) NOT NULL COMMENT '性别',
  `stClass` varchar(30) NOT NULL COMMENT '班级',
  `stHome` varchar(100) DEFAULT NULL COMMENT '家庭住址',
  `stParentsId` int(11) DEFAULT NULL COMMENT '父母id',
  PRIMARY KEY (`stId`)
) ENGINE=InnoDB AUTO_INCREMENT=118 DEFAULT CHARSET=utf8;

-- 正在导出表  myschool.student 的数据：~13 rows (大约)
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` (`stId`, `stName`, `stAge`, `stPhoneNo`, `stGender`, `stClass`, `stHome`, `stParentsId`) VALUES
	(101, '太乙真人', 1085, '13186986711', '男', '高三5班', '乾元山金光洞', NULL),
	(102, '度厄真人', 1035, '17129847835', '男', '高三2班', '九顶铁刹山八宝云光洞', NULL),
	(103, '慈航真人', 1022, '15189673478', '女', '高三1班', '普陀山紫竹林', NULL),
	(104, '月游星君', 700, '000000', '女', '初三2班', NULL, 103),
	(105, '文殊广法天尊', 1125, '000000', '男', '高三1班', '五龙山云霄洞', NULL),
	(106, '邓婵玉', 26, '18922226731', '女', '三年6班', NULL, NULL),
	(107, '321312', 123, '12312321', 'awqe', '121', '1231312', NULL),
	(108, '倪马安', 1, 'demoData', '123', 'demoData', 'demoData', 103),
	(109, 'test123', 12, 'demoData', '123', 'demoData', 'demoData', NULL),
	(112, '孙悟饭', 123, '1333123112', '男', '二年3班', '轻水亚居', 100),
	(113, '哪吒', 15, '000000', '男', '三年5班', '陈塘关', 104),
	(114, '金吒', 17, '000000', '男', '五年2班', '陈塘关', 104),
	(115, '木吒', 16, '000000', '男', '四年1班', '陈塘关', 104),
	(116, '黄天霸', 19, '000000', '男', '初一2班', '朝歌', 105),
	(117, '雷震子', 13, '000000', '男', '三年3班', '镐京', 106);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
