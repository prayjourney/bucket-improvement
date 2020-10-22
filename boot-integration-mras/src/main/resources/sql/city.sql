CREATE TABLE `city` (
  `ctId` int(11) NOT NULL AUTO_INCREMENT,
  `ctName` varchar(50) NOT NULL,
  `ctProvince` varchar(50) NOT NULL,
  PRIMARY KEY (`ctId`)
) ENGINE=InnoDB AUTO_INCREMENT=112 DEFAULT CHARSET=utf8;


INSERT INTO `city` VALUES ('100', '成都', '四川');
INSERT INTO `city` VALUES ('101', '重庆', '重庆');
INSERT INTO `city` VALUES ('102', '天水', '甘肃');
INSERT INTO `city` VALUES ('103', '绵阳', '四川');
INSERT INTO `city` VALUES ('104', '西安', '陕西');
INSERT INTO `city` VALUES ('105', '青岛', '山东');
INSERT INTO `city` VALUES ('106', '苏州', '江苏');
INSERT INTO `city` VALUES ('107', '上海', '上海');
INSERT INTO `city` VALUES ('108', '南京', '江苏');
INSERT INTO `city` VALUES ('109', '广州', '广东');
INSERT INTO `city` VALUES ('110', '深圳', '广东');
INSERT INTO `city` VALUES ('111', '北京', '北京');
