/*
Navicat MySQL Data Transfer

Source Server         : da
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : sgms

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2020-01-06 16:52:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `Cno` varchar(10) NOT NULL,
  `Cname` varchar(255) DEFAULT NULL,
  `Ccre` float(4,2) DEFAULT NULL,
  `Chour` int(3) DEFAULT NULL,
  PRIMARY KEY (`Cno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', '离散数学', '5.00', '48');
INSERT INTO `course` VALUES ('2', '数据库原理', '5.00', '48');
INSERT INTO `course` VALUES ('3', '操作系统', '5.00', '48');
INSERT INTO `course` VALUES ('4', '高等数学', '6.00', '60');
INSERT INTO `course` VALUES ('5', '大学物理', '5.00', '56');
INSERT INTO `course` VALUES ('6', '大数据技术', '5.00', '48');
INSERT INTO `course` VALUES ('7', '数值分析', '5.00', '48');
INSERT INTO `course` VALUES ('8', '计算机网络', '5.00', '48');
INSERT INTO `course` VALUES ('9', '单片机技术', '5.00', '48');

-- ----------------------------
-- Table structure for sc
-- ----------------------------
DROP TABLE IF EXISTS `sc`;
CREATE TABLE `sc` (
  `Sno` varchar(10) NOT NULL,
  `Cno` varchar(10) NOT NULL,
  `Tno` varchar(10) NOT NULL,
  `Cgrade` float(4,2) DEFAULT NULL,
  PRIMARY KEY (`Sno`,`Cno`,`Tno`),
  KEY `Cno` (`Cno`),
  CONSTRAINT `sc_ibfk_1` FOREIGN KEY (`Sno`) REFERENCES `student` (`sno`),
  CONSTRAINT `sc_ibfk_2` FOREIGN KEY (`Cno`) REFERENCES `course` (`cno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of sc
-- ----------------------------
INSERT INTO `sc` VALUES ('1707004103', '2', '2', null);
INSERT INTO `sc` VALUES ('1707004110', '1', '1', '77.00');
INSERT INTO `sc` VALUES ('1707004236', '1', '1', '99.00');
INSERT INTO `sc` VALUES ('1707004237', '1', '1', null);
INSERT INTO `sc` VALUES ('1707004237', '2', '2', null);
INSERT INTO `sc` VALUES ('1707004237', '3', '3', null);
INSERT INTO `sc` VALUES ('1707004237', '4', '4', null);
INSERT INTO `sc` VALUES ('1707004237', '5', '5', null);
INSERT INTO `sc` VALUES ('1707004237', '6', '6', '94.00');
INSERT INTO `sc` VALUES ('1707004237', '8', '5', null);
INSERT INTO `sc` VALUES ('1707004237', '9', '4', null);
INSERT INTO `sc` VALUES ('1707004555', '6', '6', '93.00');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `Sno` varchar(10) NOT NULL,
  `Spassword` varchar(255) DEFAULT NULL,
  `Sname` varchar(10) DEFAULT NULL,
  `Ssex` varchar(2) DEFAULT NULL,
  `Sdept` varchar(255) DEFAULT NULL,
  `Sclass` varchar(10) DEFAULT NULL,
  `Splace` varchar(255) DEFAULT NULL,
  `Stel` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Sno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1707004103', '123456', '杜睿敏', '女', '计算机科学与技术', '17070141', '山西太原', '13976462185');
INSERT INTO `student` VALUES ('1707004110', '123456', '张宇帆', '女', '计算机科学与技术', '17070141', '山西临汾', '17964614553');
INSERT INTO `student` VALUES ('1707004236', '123456', '杨家成', '男', '计算机科学与技术', '17070141', '辽宁鞍山', '15698445613');
INSERT INTO `student` VALUES ('1707004237', '123456', '王眺', '男', '计算机科学与技术', '17070141', '浙江绍兴', '18945622513');
INSERT INTO `student` VALUES ('1707004555', '123456', '李四', '男', '大数据科学与技术', '17070541', '河南洛阳', '18654321653');
INSERT INTO `student` VALUES ('1707004666', '123456', '张三', '男', '物联网', '17070241', '山东济南', '15649563256');

-- ----------------------------
-- Table structure for tc
-- ----------------------------
DROP TABLE IF EXISTS `tc`;
CREATE TABLE `tc` (
  `Tno` varchar(10) NOT NULL,
  `Cno` varchar(10) NOT NULL,
  `Cterm` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Cmaxnum` int(10) DEFAULT NULL,
  `Cstate` int(3) DEFAULT NULL,
  PRIMARY KEY (`Tno`,`Cno`,`Cterm`),
  KEY `Cno` (`Cno`),
  CONSTRAINT `tc_ibfk_1` FOREIGN KEY (`Tno`) REFERENCES `teacher` (`tno`),
  CONSTRAINT `tc_ibfk_2` FOREIGN KEY (`Cno`) REFERENCES `course` (`cno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tc
-- ----------------------------
INSERT INTO `tc` VALUES ('1', '1', '201901', '82', '0');
INSERT INTO `tc` VALUES ('2', '2', '201901', '82', '0');
INSERT INTO `tc` VALUES ('2', '3', '201902', '48', '0');
INSERT INTO `tc` VALUES ('3', '3', '201902', '82', '1');
INSERT INTO `tc` VALUES ('4', '4', '201902', '82', '2');
INSERT INTO `tc` VALUES ('4', '9', '201902', '48', '0');
INSERT INTO `tc` VALUES ('5', '5', '201901', '48', '3');
INSERT INTO `tc` VALUES ('5', '8', '201901', '82', '0');
INSERT INTO `tc` VALUES ('6', '6', '201902', '82', '4');
INSERT INTO `tc` VALUES ('6', '7', '201902', '48', '0');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `Tno` varchar(10) NOT NULL,
  `Tpassword` varchar(255) DEFAULT NULL,
  `Tname` varchar(10) DEFAULT NULL,
  `Tsex` varchar(2) DEFAULT NULL,
  `Tdept` varchar(255) DEFAULT NULL,
  `Tpro` varchar(10) DEFAULT NULL,
  `Tedu` varchar(10) DEFAULT NULL,
  `Ttel` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`Tno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', '123456', '张元', '女', '计算机科学与技术', '副教授', '博士', '15926336845');
INSERT INTO `teacher` VALUES ('2', '123456', '刘冬明', '男', '计算机科学与技术', '副教授', '博士', '13498566514');
INSERT INTO `teacher` VALUES ('3', '123456', '秦品乐', '男', '物联网', '副教授', '博士', '18945668925');
INSERT INTO `teacher` VALUES ('4', '123456', '韩慧妍', '女', '计算机科学与技术', '副教授', '博士', '15623665489');
INSERT INTO `teacher` VALUES ('5', '123456', '韩燮', '女', '计算机科学与技术', '教授', '博士', '18956664891');
INSERT INTO `teacher` VALUES ('6', '123456', '乔钢柱', '男', '大数据科学与技术', '教授', '博士', '18954887965');
INSERT INTO `teacher` VALUES ('admin', 'admin', '教务处', null, null, null, null, null);

-- ----------------------------
-- View structure for alltsc
-- ----------------------------
DROP VIEW IF EXISTS `alltsc`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `alltsc` AS select `student`.`Sno` AS `Sno`,`student`.`Spassword` AS `Spassword`,`student`.`Sname` AS `Sname`,`student`.`Ssex` AS `Ssex`,`student`.`Sdept` AS `Sdept`,`student`.`Sclass` AS `Sclass`,`student`.`Splace` AS `Splace`,`student`.`Stel` AS `Stel`,`course`.`Cno` AS `Cno`,`course`.`Cname` AS `Cname`,`course`.`Ccre` AS `Ccre`,`course`.`Chour` AS `Chour`,`teacher`.`Tno` AS `Tno`,`teacher`.`Tpassword` AS `Tpassword`,`teacher`.`Tname` AS `Tname`,`teacher`.`Tsex` AS `Tsex`,`teacher`.`Tdept` AS `Tdept`,`teacher`.`Tpro` AS `Tpro`,`teacher`.`Tedu` AS `Tedu`,`teacher`.`Ttel` AS `Ttel`,`tc`.`Cterm` AS `Cterm`,`tc`.`Cmaxnum` AS `Cmaxnum`,`tc`.`Cstate` AS `Cstate`,`sc`.`Cgrade` AS `Cgrade` from ((((`course` join `sc`) join `student`) join `tc`) join `teacher`) where ((`course`.`Cno` = `sc`.`Cno`) and (`sc`.`Cno` = `tc`.`Cno`) and (`teacher`.`Tno` = `sc`.`Tno`) and (`sc`.`Tno` = `tc`.`Tno`) and (`student`.`Sno` = `sc`.`Sno`)) ;

-- ----------------------------
-- View structure for coursechoose
-- ----------------------------
DROP VIEW IF EXISTS `coursechoose`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `coursechoose` AS select distinct `course`.`Cno` AS `Cno`,`course`.`Cname` AS `Cname`,`tt`.`Tno` AS `Tno`,`course`.`Ccre` AS `Ccre`,`course`.`Chour` AS `Chour`,ifnull(`t`.`Cnumber`,0) AS `Cnumber`,`tt`.`Cmaxnum` AS `Cmaxnum`,`tt`.`Tname` AS `Tname` from ((`course` left join (select `course`.`Cno` AS `cno`,`course`.`Cname` AS `Cname`,count(`sc`.`Sno`) AS `Cnumber` from (`sc` join `course`) where (`sc`.`Cno` = `course`.`Cno`) group by `course`.`Cno`) `t` on((`course`.`Cno` = `t`.`cno`))) left join (select `tc`.`Tno` AS `Tno`,`course`.`Cno` AS `Cno`,`tc`.`Cmaxnum` AS `Cmaxnum`,`tc`.`Cstate` AS `Cstate`,`teacher`.`Tname` AS `Tname` from ((`course` join `tc`) join `teacher`) where ((`course`.`Cno` = `tc`.`Cno`) and (`tc`.`Tno` = `teacher`.`Tno`))) `tt` on((`course`.`Cno` = `tt`.`Cno`))) where (`tt`.`Cstate` = 0) ;

-- ----------------------------
-- View structure for mygrade
-- ----------------------------
DROP VIEW IF EXISTS `mygrade`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `mygrade` AS select `sc`.`Sno` AS `Sno`,`sc`.`Cno` AS `Cno`,`course`.`Cname` AS `Cname`,`sc`.`Tno` AS `Tno`,`teacher`.`Tname` AS `Tname`,`sc`.`Cgrade` AS `Cgrade` from ((`sc` join `course`) join `teacher`) where ((`sc`.`Cgrade` is not null) and (`sc`.`Cno` = `course`.`Cno`) and (`sc`.`Tno` = `teacher`.`Tno`)) ;

-- ----------------------------
-- View structure for teamystu
-- ----------------------------
DROP VIEW IF EXISTS `teamystu`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `teamystu` AS select `course`.`Cno` AS `Cno`,`course`.`Cname` AS `Cname`,`student`.`Sno` AS `Sno`,`student`.`Sname` AS `Sname`,`student`.`Sclass` AS `Sclass`,`student`.`Stel` AS `Stel`,`sc`.`Tno` AS `Tno`,`sc`.`Cgrade` AS `Cgrade` from ((`course` join `student`) join `sc`) where ((`course`.`Cno` = `sc`.`Cno`) and (`student`.`Sno` = `sc`.`Sno`)) ;
