CREATE TABLE `souvenir` (
  `soId` int(11) NOT NULL AUTO_INCREMENT,
  `soName` varchar(50) NOT NULL,
  `ctId` int(11) DEFAULT NULL,
  PRIMARY KEY (`soId`)
) ENGINE=InnoDB AUTO_INCREMENT=112 DEFAULT CHARSET=utf8;


INSERT INTO `souvenir` VALUES ('100', '火锅底料', '100');
INSERT INTO `souvenir` VALUES ('101', '蜀锦', '100');
INSERT INTO `souvenir` VALUES ('102', '火锅底料', '101');
INSERT INTO `souvenir` VALUES ('103', '黄元帅', '102');
INSERT INTO `souvenir` VALUES ('104', '挂面', '102');
INSERT INTO `souvenir` VALUES ('105', '挂面', '104');
INSERT INTO `souvenir` VALUES ('106', '挂面', '105');
INSERT INTO `souvenir` VALUES ('107', '长安汽车', '101');
INSERT INTO `souvenir` VALUES ('108', '油泼面', '104');
INSERT INTO `souvenir` VALUES ('109', '云锦', '108');
INSERT INTO `souvenir` VALUES ('110', '烤鸭', '108');
INSERT INTO `souvenir` VALUES ('111', '烤鸭', '111');
