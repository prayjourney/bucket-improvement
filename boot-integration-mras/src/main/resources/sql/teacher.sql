CREATE TABLE teacher (
	teId INT ( 11 ) NOT NULL AUTO_INCREMENT COMMENT "id",
	teName VARCHAR ( 50 ) NOT NULL COMMENT "姓名",
	teAge INT ( 2 ) NOT NULL COMMENT "年龄",
	tePhoneNo VARCHAR ( 11 ) NOT NULL DEFAULT "000000" COMMENT "手机",
	teGender VARCHAR ( 4 ) NOT NULL COMMENT "性别",
	teClass VARCHAR ( 30 ) NOT NULL COMMENT "教授班级",
	teCourse VARCHAR ( 20 ) NOT NULL COMMENT "教授科目",
	teWorkTime INT ( 2 ) COMMENT "工作年限",
	PRIMARY KEY ( teId )
) ENGINE = INNODB AUTO_INCREMENT = 500 DEFAULT CHARSET = utf8;

INSERT INTO `teacher` VALUES ('500', '鸿钧老祖', '5000', '000000', '男', '总教主', '奠基人', '4900');
INSERT INTO `teacher` VALUES ('501', '太上老君', '3200', '000000', '男', '人教教主', '大教主', '3000');
INSERT INTO `teacher` VALUES ('502', '元始天尊', '3100', '000000', '男', '阐教教主', '二教主', '2800');
INSERT INTO `teacher` VALUES ('503', '通天教主', '3000', '000000', '男', '截教教主', '三教主', '2750');
INSERT INTO `teacher` VALUES ('504', '太乙真人', '1200', '000000', '男', '金光洞洞主', '高级教师', '1000');
INSERT INTO `teacher` VALUES ('505', '慈航真人', '1100', '000000', '女', '普陀岛岛主', '高级教师', '900');
INSERT INTO `teacher` VALUES ('506', '龟灵圣母', '1600', '000000', '女', '碧游宫大弟子', '特聘教师', '1500');
INSERT INTO `teacher` VALUES ('507', '多宝道人', '2200', '000000', '男', '教导主任', '高级管理员', '2150');