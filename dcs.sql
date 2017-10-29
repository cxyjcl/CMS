/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50634
Source Host           : localhost:3306
Source Database       : dcs

Target Server Type    : MYSQL
Target Server Version : 50634
File Encoding         : 65001

Date: 2017-10-29 11:01:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_activities
-- ----------------------------
DROP TABLE IF EXISTS `t_activities`;
CREATE TABLE `t_activities` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `info_id` int(11) DEFAULT NULL COMMENT 'excel关联的表的id',
  `code` varchar(255) COLLATE utf8_unicode_ci DEFAULT '',
  `time` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '序号',
  `place` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '姓名',
  `sponsor` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '性别',
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '民族',
  `description` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '出生年月',
  `remark` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '身份证号码',
  `url` varchar(255) COLLATE utf8_unicode_ci DEFAULT '空' COMMENT '班级',
  `data_status` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of t_activities
-- ----------------------------

-- ----------------------------
-- Table structure for t_application_member
-- ----------------------------
DROP TABLE IF EXISTS `t_application_member`;
CREATE TABLE `t_application_member` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `info_id` int(11) DEFAULT NULL COMMENT 'excel关联的表的id',
  `code` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '序号',
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '姓名',
  `sex` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '性别',
  `nation` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '民族',
  `birthday` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '出生年月',
  `id_card` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '身份证号码',
  `classroom` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '班级',
  `profession` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '专业',
  `student_level` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '学生层次',
  `party_date` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '申请入党时间',
  `application_date` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '成为正式党员时间',
  `data_status` varchar(255) COLLATE utf8_unicode_ci DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of t_application_member
-- ----------------------------
INSERT INTO `t_application_member` VALUES ('1', '1', '', '', '', '', '', '', '', '', '', '', '', '001');
INSERT INTO `t_application_member` VALUES ('2', '2', '1', '231', '312', '23', '13', '321', '331', '132', '1', '23213', '132', '001');

-- ----------------------------
-- Table structure for t_cadres_info
-- ----------------------------
DROP TABLE IF EXISTS `t_cadres_info`;
CREATE TABLE `t_cadres_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `info_id` int(11) DEFAULT NULL,
  `name_chairman` varchar(255) COLLATE utf8_unicode_ci DEFAULT '',
  `function_chairman` varchar(255) COLLATE utf8_unicode_ci DEFAULT '',
  `contacts_chairman` varchar(255) COLLATE utf8_unicode_ci DEFAULT '',
  `department_charge` varchar(255) COLLATE utf8_unicode_ci DEFAULT '',
  `name_secretary` varchar(255) COLLATE utf8_unicode_ci DEFAULT '',
  `function_secretary` varchar(255) COLLATE utf8_unicode_ci DEFAULT '',
  `contacts_secretary` varchar(255) COLLATE utf8_unicode_ci DEFAULT '',
  `student_organization` varchar(255) COLLATE utf8_unicode_ci DEFAULT '',
  `remark` varchar(255) COLLATE utf8_unicode_ci DEFAULT '',
  `data_status` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of t_cadres_info
-- ----------------------------
INSERT INTO `t_cadres_info` VALUES ('20', '1', null, null, null, null, null, null, null, null, null, '001');
INSERT INTO `t_cadres_info` VALUES ('21', '2', null, null, null, null, null, null, null, null, null, '001');
INSERT INTO `t_cadres_info` VALUES ('22', '3', null, null, null, null, null, null, null, null, null, '001');
INSERT INTO `t_cadres_info` VALUES ('23', '4', null, null, null, null, null, null, null, null, null, '001');
INSERT INTO `t_cadres_info` VALUES ('25', '5', null, null, null, null, null, null, null, null, null, '001');
INSERT INTO `t_cadres_info` VALUES ('26', '6', 'jcl', 'jcl', '12', 'jcl', 'jcl', 'jcl', '1231321', 'jcl', 'jcl', '001');

-- ----------------------------
-- Table structure for t_campus_activities
-- ----------------------------
DROP TABLE IF EXISTS `t_campus_activities`;
CREATE TABLE `t_campus_activities` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `info_id` int(11) DEFAULT NULL,
  `context_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '比赛名称',
  `project` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '项目',
  `context_grade` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '级别',
  `student_id` int(11) DEFAULT '0' COMMENT '获奖者学号',
  `reward` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '奖项',
  `student_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '获奖者',
  `grade` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '年级',
  `classroom` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '班级',
  `remark` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '备注',
  `data_status` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of t_campus_activities
-- ----------------------------
INSERT INTO `t_campus_activities` VALUES ('1', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_campus_activities` VALUES ('2', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_campus_activities` VALUES ('3', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_campus_activities` VALUES ('4', '0', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_campus_activities` VALUES ('5', '0', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_campus_activities` VALUES ('6', '0', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_campus_activities` VALUES ('7', '0', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_campus_activities` VALUES ('8', '1', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_campus_activities` VALUES ('9', '2', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_campus_activities` VALUES ('10', '1', '拔河', '拔河', '升级', '1405110', '就', '就', '就', '就', '就', '001');

-- ----------------------------
-- Table structure for t_change_info
-- ----------------------------
DROP TABLE IF EXISTS `t_change_info`;
CREATE TABLE `t_change_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `info_id` int(11) DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '姓名',
  `student_id` int(11) DEFAULT '0' COMMENT '学号',
  `classroom` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '班级',
  `change_reason` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '异动原因',
  `change_time` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '异动时间',
  `url` varchar(255) COLLATE utf8_unicode_ci DEFAULT '空' COMMENT '''空''',
  `data_status` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of t_change_info
-- ----------------------------
INSERT INTO `t_change_info` VALUES ('1', '1', '卓', '1405', '数计1401', '无', '1966年12月24', '/D:/Program Files/apache-tomcat/me-webapps/dcs/temp/1d7f4181b-2bc3-44ff-8a71-946a8c6515c3.xls', '001');

-- ----------------------------
-- Table structure for t_class_info
-- ----------------------------
DROP TABLE IF EXISTS `t_class_info`;
CREATE TABLE `t_class_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `info_id` int(11) DEFAULT NULL COMMENT 'excel关联的表的id',
  `student_id` int(11) DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '名字',
  `sex` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '性别',
  `native_place` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '籍贯',
  `birth_place` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '出生地',
  `id_card` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '身份证号',
  `contacts` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT ' 联系方式',
  `party_member` varchar(1) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '备注（党员）',
  `duties` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '班级职务',
  `data_status` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of t_class_info
-- ----------------------------
INSERT INTO `t_class_info` VALUES ('1', '11', '1501', null, null, null, null, null, null, null, null, '001');
INSERT INTO `t_class_info` VALUES ('2', '11', '1501', null, null, null, null, null, null, null, null, null);
INSERT INTO `t_class_info` VALUES ('3', '12', '1502', null, null, null, null, null, null, null, null, '001');
INSERT INTO `t_class_info` VALUES ('4', '13', '1405', '卓', '男', '湖北', '湖北', '420982', '133333', 'Y', '', '001');
INSERT INTO `t_class_info` VALUES ('5', '13', '1405', '卓', '男', '湖北', '湖北', '420982', '133333', 'Y', '', '001');
INSERT INTO `t_class_info` VALUES ('6', '13', '1405', '卓', '男', '湖北', '湖北', '420982', '133333', 'Y', '', '001');
INSERT INTO `t_class_info` VALUES ('7', '13', '1405', '卓', '男', '湖北', '湖北', '420982', '133333', 'Y', '', '001');

-- ----------------------------
-- Table structure for t_contest_info
-- ----------------------------
DROP TABLE IF EXISTS `t_contest_info`;
CREATE TABLE `t_contest_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `info_id` int(11) DEFAULT NULL,
  `sponsor` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '主办单位',
  `contest_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '比赛名称',
  `contest_grade` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '获奖等级',
  `work_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '作品名称',
  `contest_student` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '获奖学生',
  `tutor` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '指导老师',
  `remark` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '备注',
  `url` varchar(255) COLLATE utf8_unicode_ci DEFAULT '空',
  `data_status` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of t_contest_info
-- ----------------------------
INSERT INTO `t_contest_info` VALUES ('1', '1', '轻工大', '拔河', '一等奖', '拔河', '张三', '李四', '', '空', '001');
INSERT INTO `t_contest_info` VALUES ('2', '2', '轻工大', '拔河', '一等奖', '拔河', '张三', '李四', '', '空', '001');
INSERT INTO `t_contest_info` VALUES ('3', '3', '', '', '', '', null, '', '', '空', '001');
INSERT INTO `t_contest_info` VALUES ('4', '4', 'aafd', 'sdf', 'sdf', 'df', 'sfd', 'fds', 'sfd', '/D:/Program Files/apache-tomcat/me-webapps/dcs/temp/48465ccb1-980f-4c10-8eed-ed966e2e903f.jpg', '000');
INSERT INTO `t_contest_info` VALUES ('5', '4', 'aafd', 'sdf', 'sdf', 'df', 'sfd', 'fds', 'sfd', '空', '001');
INSERT INTO `t_contest_info` VALUES ('6', '5', 'aafd', 'sdf', 'sdf', 'df', 'sfd', 'fds', 'sfd', '/D:/Program Files/apache-tomcat/me-webapps/dcs/temp/60d8373dc-846d-4dd2-942b-0bd1adf501fc.jpg', '001');

-- ----------------------------
-- Table structure for t_glory_info
-- ----------------------------
DROP TABLE IF EXISTS `t_glory_info`;
CREATE TABLE `t_glory_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `info_id` int(11) DEFAULT NULL COMMENT '关联id',
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '姓名',
  `student_id` int(11) DEFAULT '0' COMMENT '学号',
  `classroom` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '班级',
  `contest_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '比赛名称',
  `contest_grade` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '比赛等级',
  `reward_time` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '获奖时间',
  `remark` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '备注',
  `reward_nature` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '获奖属性',
  `data_status` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of t_glory_info
-- ----------------------------
INSERT INTO `t_glory_info` VALUES ('1', '1', '卓', '1405', '数计1401', '篮球', '一等奖', '1996年12月12日', '', '省级奖及以上', '001');
INSERT INTO `t_glory_info` VALUES ('2', '2', '卓', '1405', '数计1401', '篮球', '一等奖', '1996年12月12日', '', '省级奖及以上', '001');
INSERT INTO `t_glory_info` VALUES ('3', '2', '张', '1111', '数计1401', '足球', '二等奖', '1996年12月12日', '', '校级奖', '001');

-- ----------------------------
-- Table structure for t_grade_info
-- ----------------------------
DROP TABLE IF EXISTS `t_grade_info`;
CREATE TABLE `t_grade_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `info_id` int(11) DEFAULT NULL COMMENT 'excel关联的表的id',
  `classroom` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '班级',
  `people` int(2) DEFAULT '0' COMMENT '人数',
  `male` int(2) DEFAULT '0' COMMENT '男生',
  `female` int(2) DEFAULT '0' COMMENT '女生',
  `party_member` int(2) DEFAULT '0' COMMENT '党员',
  `activist` int(2) DEFAULT '0' COMMENT '积极分子',
  `teacher` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '班主任',
  `monitor` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '班长',
  `league_secretary` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '团支书',
  `studies_commissary` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '学委',
  `sports_commissary` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '体委',
  `affair_commissary` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '生活委员',
  `organization_commissary` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '组织委员',
  `publicity_commissary` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '宣传委员',
  `psychological_commissary` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '心理委员',
  `remark` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '备注',
  `data_status` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of t_grade_info
-- ----------------------------
INSERT INTO `t_grade_info` VALUES ('1', '1', null, '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('2', '2', null, '14', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('3', '3', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('4', '3', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('5', '3', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('6', '3', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('7', '4', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('8', '4', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('9', '4', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('10', '4', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('11', '5', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('12', '5', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('13', '5', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('14', '5', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('15', '6', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('16', '6', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('17', '6', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('18', '6', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('19', '7', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('20', '7', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('21', '7', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('22', '7', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('23', '7', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('24', '7', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('25', '7', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('26', '7', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('27', '7', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('28', '7', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('29', '7', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('30', '7', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('31', '7', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('32', '7', '机械设计1201班', '31', '30', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '000');
INSERT INTO `t_grade_info` VALUES ('33', '8', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('34', '8', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('35', '8', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('36', '8', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('37', '8', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('38', '8', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('39', '8', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('40', '8', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('41', '8', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('42', '8', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('43', '8', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('44', '8', '123', '2', '2', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('45', '8', '', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('46', '8', '机械设计1201班', '31', '30', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('47', '9', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('48', '9', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('49', '9', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('50', '9', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('51', '9', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('52', '9', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('53', '9', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('54', '9', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('55', '9', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('56', '9', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('57', '9', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('58', '9', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('59', '9', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('60', '9', '机械设计1201班', '31', '30', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('61', '10', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('62', '10', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('63', '10', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('64', '10', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('65', '10', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('66', '10', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('67', '10', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('68', '10', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('69', '10', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('70', '10', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('71', '10', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('72', '10', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('73', '10', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('74', '10', '机械设计1201班', '31', '30', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('75', '10', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('76', '10', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('77', '10', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('78', '10', '机械设计1201班', '31', '28', '3', '6', '0', '张可维', '王锦坤', '薛齐豪', '王榜', '苏凡', '陈祥祥', '吴中晗', '吴中晗', '无', '', '001');
INSERT INTO `t_grade_info` VALUES ('79', '10', '1501', '1', '1', '1', '1', '11', '1', '11', '1', '1', '1', '11', '1', '11', '11', '1', '001');
INSERT INTO `t_grade_info` VALUES ('80', '10', '1501', '1', '1', '1', '1', '11', '1', '11', '1', '1', '1', '11', '1', '11', '11', '1', '001');
INSERT INTO `t_grade_info` VALUES ('81', '11', '1501', '1', '1', '1', '1', '11', '1', '11', '1', '1', '1', '11', '1', '11', '11', '1', '001');
INSERT INTO `t_grade_info` VALUES ('82', '12', '120', '1', '1', '1', '1', '11', '1', '11', '1', '1', '1', '11', '1', '11', '11', '1', '001');

-- ----------------------------
-- Table structure for t_individual_achievement
-- ----------------------------
DROP TABLE IF EXISTS `t_individual_achievement`;
CREATE TABLE `t_individual_achievement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `info_id` int(11) DEFAULT NULL,
  `achievement` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '成果',
  `reward` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '获奖情况',
  `reward_time` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '获奖时间',
  `remark` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '备注',
  `data_status` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of t_individual_achievement
-- ----------------------------

-- ----------------------------
-- Table structure for t_lecture_info
-- ----------------------------
DROP TABLE IF EXISTS `t_lecture_info`;
CREATE TABLE `t_lecture_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `info_id` int(11) DEFAULT NULL,
  `play` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '场次',
  `time` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '时间',
  `place` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '地点',
  `object` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '主题',
  `talker` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '主讲人',
  `participants` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '参加人员',
  `data_status` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of t_lecture_info
-- ----------------------------
INSERT INTO `t_lecture_info` VALUES ('1', '1', '一', '1996年12月12日', '图书馆', '机械', '张三', '李四', '001');

-- ----------------------------
-- Table structure for t_list_info
-- ----------------------------
DROP TABLE IF EXISTS `t_list_info`;
CREATE TABLE `t_list_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `excel_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'excel的名字',
  `title` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'excel的标题',
  `list_id` int(11) DEFAULT NULL COMMENT '目录id',
  `info_id` int(11) DEFAULT NULL COMMENT 'excel关联的表的id',
  `creator` int(11) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `reviser` int(11) DEFAULT NULL COMMENT '修改人',
  `revise_time` datetime DEFAULT NULL COMMENT '修改时间',
  `user_level` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '冗余字段，便于快速查找出相关职务的文件',
  `data_status` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '状态(000：删除,001:正常使用，002：禁用）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=108 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of t_list_info
-- ----------------------------
INSERT INTO `t_list_info` VALUES ('57', '各组织学生干部名单表模板 (10).xls', '机械工程学院XX-XX学年度XX组织学生干部名单', '20001', '1', '3', '2017-04-29 17:33:22', null, null, '分团委', '001');
INSERT INTO `t_list_info` VALUES ('58', '各组织学生干部名单表模板 (10).xls', '机械工程学院XX-XX学年度XX组织学生干部名单', '20001', '2', '3', '2017-04-29 17:33:57', null, null, '分团委', '001');
INSERT INTO `t_list_info` VALUES ('59', '各组织学生干部名单表模板 (6).xls', '机械工程学院XX-XX学年度XX组织学生干部名单', '20001', '3', '3', '2017-04-29 20:29:05', null, null, '分团委', '001');
INSERT INTO `t_list_info` VALUES ('60', '各组织学生干部名单表模板 (3).xls', '机械工程学院XX-XX学年度XX组织学生干部名单', '20001', '4', '3', '2017-04-29 20:29:23', '3', '2017-05-01 20:22:43', '分团委', '001');
INSERT INTO `t_list_info` VALUES ('62', 'excel (26).xls', '机械工程学院XX-XX学年度XX组织学生干部名单', '20001', '5', '3', '2017-04-29 20:40:40', null, null, '分团委', '001');
INSERT INTO `t_list_info` VALUES ('63', '各组织学生干部名单表模板 (13).xls', '机械工程学院XX-XX学年度XX组织学生干部名单', '20001', '6', '3', '2017-04-29 20:41:30', '3', '2017-05-02 09:10:09', '分团委', '000');
INSERT INTO `t_list_info` VALUES ('64', '年级信息一览表 (4).xls', '级基本情况一览表                      辅导员：', '10001', '10', '3', '2017-04-30 14:10:50', '3', '2017-04-30 14:57:02', '辅导员', '000');
INSERT INTO `t_list_info` VALUES ('65', '年级信息一览表 (4).xls', '级基本情况一览表                      辅导员：', '10001', '10', '3', '2017-04-30 14:12:41', '3', '2017-04-30 14:57:02', '辅导员', '000');
INSERT INTO `t_list_info` VALUES ('66', '年级信息一览表 (4).xls', '级基本情况一览表                      辅导员：', '10001', '11', '3', '2017-04-30 14:57:29', null, null, '辅导员', '001');
INSERT INTO `t_list_info` VALUES ('67', '学科竞赛统计表.xls', '201 -   201 学年 第  学期学生学科竞赛获奖统计表', '10005', '4', '3', '2017-05-01 20:17:37', '3', '2017-05-01 20:22:43', '分团委', '001');
INSERT INTO `t_list_info` VALUES ('68', '学科竞赛统计表.xls', '201 -   201 学年 第  学期学生学科竞赛获奖统计表', '10005', '4', '3', '2017-05-01 20:24:14', null, null, '分团委', '001');
INSERT INTO `t_list_info` VALUES ('69', '学科竞赛统计表.xls', '201 -   201 学年 第  学期学生学科竞赛获奖统计表', '10005', '5', '3', '2017-05-01 20:25:44', null, null, '分团委', '001');
INSERT INTO `t_list_info` VALUES ('71', '年级信息一览表 (4).xls', '级基本情况一览表                      辅导员：', '10001', '12', '3', '2017-05-01 20:44:36', null, null, '辅导员', '001');
INSERT INTO `t_list_info` VALUES ('72', '正式党员名单 (2).xls', '机械学院2016—2017学年度第1学期正式党员报表', '10016', '1', '3', '2017-05-01 21:18:36', null, null, '辅导员', '001');
INSERT INTO `t_list_info` VALUES ('73', '正式党员名单.xls', '机械学院2016—2017学年度第1学期正式党员报表', '10016', '2', '3', '2017-05-01 21:31:51', null, null, '辅导员', '001');
INSERT INTO `t_list_info` VALUES ('74', '预备党员名单.xls', '机械学院2016—2017学年度第1学期发展对象报表', '10015', '1', '3', '2017-05-01 21:33:56', null, null, '辅导员', '001');
INSERT INTO `t_list_info` VALUES ('75', '预备党员名单.xls', '机械学院2016—2017学年度第1学期发展对象报表', '10003', '1', '3', '2017-05-01 21:34:13', null, null, '辅导员', '001');
INSERT INTO `t_list_info` VALUES ('76', '上党校学生名单.xls', '机械学院党校第73期学员名册', '10014', '1', '3', '2017-05-01 21:45:58', null, null, '辅导员', '001');
INSERT INTO `t_list_info` VALUES ('77', '上党校学生名单.xls', '机械学院党校第73期学员名册', '10014', '2', '3', '2017-05-01 21:47:55', null, null, '辅导员', '001');
INSERT INTO `t_list_info` VALUES ('78', '上党校学生名单 (1).xls', '机械学院党校第73期学员名册', '10014', '3', '3', '2017-05-01 21:48:10', null, null, '辅导员', '001');
INSERT INTO `t_list_info` VALUES ('79', '上党校学生名单.xls', '机械学院党校第73期学员名册', '10014', '4', '3', '2017-05-01 21:59:23', null, null, '辅导员', '001');
INSERT INTO `t_list_info` VALUES ('80', '正式党员名单.xls', '机械学院2016—2017学年度第1学期正式党员报表', '10016', '3', '3', '2017-05-02 09:11:21', null, null, '辅导员', '001');
INSERT INTO `t_list_info` VALUES ('81', '预备党员名单.xls', '机械学院2016—2017学年度第1学期发展对象报表', '10015', '2', '3', '2017-05-02 09:17:17', null, null, '辅导员', '001');
INSERT INTO `t_list_info` VALUES ('82', '积极分子名单.xls', '机械学院2016—2017学年度第1学期入党积极分子报表', '10003', '2', '3', '2017-05-02 09:17:49', null, null, '辅导员', '001');
INSERT INTO `t_list_info` VALUES ('101', '资料集锦系统使用文档.doc', '', '10011', '1', '3', '2017-06-05 10:33:28', '3', '2017-06-05 10:49:53', '分团委', '001');
INSERT INTO `t_list_info` VALUES ('102', '计网课设.doc', null, '10012', '9', '3', '2017-10-23 16:52:40', null, null, '辅导员', '001');
INSERT INTO `t_list_info` VALUES ('103', '各组织学生干部名单表模板.xls', null, '10012', '10', '3', '2017-10-23 16:56:54', null, null, '辅导员', '001');
INSERT INTO `t_list_info` VALUES ('104', '资料集锦系统使用文档.doc', null, '10012', '11', '3', '2017-10-23 17:08:58', null, null, '辅导员', '001');
INSERT INTO `t_list_info` VALUES ('105', '各组织学生干部名单表模板.xls', null, '10012', '12', '3', '2017-10-23 17:09:12', null, null, '辅导员', '001');
INSERT INTO `t_list_info` VALUES ('106', '各组织学生干部名单表模板.xls', null, '10012', '13', '3', '2017-10-23 17:16:03', null, null, '辅导员', '001');
INSERT INTO `t_list_info` VALUES ('107', '各组织学生干部名单表模板.xls', null, '30014', '14', '3', '2017-10-23 17:23:16', null, null, '学工办', '001');

-- ----------------------------
-- Table structure for t_money_info
-- ----------------------------
DROP TABLE IF EXISTS `t_money_info`;
CREATE TABLE `t_money_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `info_id` int(11) DEFAULT NULL,
  `money_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT '',
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '姓名',
  `student_id` int(11) DEFAULT '0' COMMENT '学号',
  `classroom` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '行政班级',
  `grade` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '等级',
  `money` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '金额',
  `remark` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '备注',
  `data_status` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of t_money_info
-- ----------------------------
INSERT INTO `t_money_info` VALUES ('1', '1', '奖学金', '张三', '1405', '机械1401班', '一等', '2000', '', '001');

-- ----------------------------
-- Table structure for t_party_lecture
-- ----------------------------
DROP TABLE IF EXISTS `t_party_lecture`;
CREATE TABLE `t_party_lecture` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `info_id` int(11) DEFAULT NULL COMMENT 'excel关联的表的id',
  `code` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '序号',
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '姓名',
  `sex` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '性别',
  `nation` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '民族',
  `birthday` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '出生年月',
  `id_card` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '身份证号码',
  `classroom` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '班级',
  `profession` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '专业',
  `student_level` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '学生层次',
  `party_date` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '成为正式党员时间',
  `application_date` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '申请入党时间',
  `remark` varchar(255) COLLATE utf8_unicode_ci DEFAULT '',
  `data_status` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=117 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of t_party_lecture
-- ----------------------------
INSERT INTO `t_party_lecture` VALUES ('1', '1', '2', '周华晋', '男', '土家族', '1996.08', '500243199608061996', '1408', '机械类', '本科', '2014.09.01', '2016.04.11', '', '001');
INSERT INTO `t_party_lecture` VALUES ('2', '1', '3', '邹叶鑫', '男', '汉族', '1996.07', '432503199607277698', '1410', '机械类', '本科', '2014.09.01', '2016.04.11', '', '001');
INSERT INTO `t_party_lecture` VALUES ('3', '1', '4', '周盼', '男', '汉族', '1996.02', '420802199602261618', '1401', '机械类', '本科', '2014.09.01', '2016.04.11', '', '001');
INSERT INTO `t_party_lecture` VALUES ('4', '1', '5', '商建', '男', '汉族', '1996.02', '421181199602078491', '1409', '机械类', '本科', '2014.09.01', '2016.04.11', '', '001');
INSERT INTO `t_party_lecture` VALUES ('5', '1', '6', '陈兵', '男', '汉族', '1995.12', '429005199512068754', '1405', '机械类', '本科', '2014.09.01', '2016.04.11', '', '001');
INSERT INTO `t_party_lecture` VALUES ('6', '1', '7', '李存程', '男', '汉族', '1995.10', '620403199510013133', '1405', '机械类', '本科', '2014.09.01', '2016.04.11', '', '001');
INSERT INTO `t_party_lecture` VALUES ('7', '1', '8', '李书飞', '男', '汉族', '1995.07', '420684199507233516', '1407', '机械类', '本科', '2014.09.01', '2016.04.11', '', '001');
INSERT INTO `t_party_lecture` VALUES ('8', '1', '9', '朱正想', '男', '汉族', '1995.02', '42118119950215133X', '1402', '机械类', '本科', '2014.09.01', '2016.04.11', '', '001');
INSERT INTO `t_party_lecture` VALUES ('9', '1', '10', '刘高仁', '男', '汉族', '1994.11', '420281199411231291', '1403', '机械类', '本科', '2014.09.01', '2016.04.11', '', '001');
INSERT INTO `t_party_lecture` VALUES ('10', '1', '11', '徐超', '男', '汉族', '1994.08', '420704199408015576', '1401', '机械类', '本科', '2014.09.01', '2016.04.11', '', '001');
INSERT INTO `t_party_lecture` VALUES ('11', '1', '12', '陶昱', '男', '汉族', '1996.02', '522427199602287237', '1501', '机械类', '本科', '2015.10.01', '2015.10.10', '', '001');
INSERT INTO `t_party_lecture` VALUES ('12', '1', '13', '柳仔', '男', '汉族', '1997.01', '420116199701180450', '1501', '机械类', '本科', '2015.10.01', '2016.03.24', '', '001');
INSERT INTO `t_party_lecture` VALUES ('13', '1', '14', '熊文斌', '男', '汉族', '1995.07', '429006199507082152', '1501', '机械类', '本科', '2015.10.01', '2016.03.24', '', '001');
INSERT INTO `t_party_lecture` VALUES ('14', '1', '15', '严欢', '男', '汉族', '1997.01', '420111199701186631', '1503', '机械类', '本科', '2015.10.01', '2016.03.24', '', '001');
INSERT INTO `t_party_lecture` VALUES ('15', '1', '16', '李亚男', '男', '汉族', '1997.03', '140624199703110050', '1503', '机械类', '本科', '2015.10.01', '2015.10.10', '', '001');
INSERT INTO `t_party_lecture` VALUES ('16', '1', '17', '徐英杰', '男', '汉族', '1997.10', '420922199710092816', '1504', '机械类', '本科', '2015.10.01', '2016.03.24', '', '001');
INSERT INTO `t_party_lecture` VALUES ('17', '1', '18', '刘宝山', '男', '汉族', '1995.02', '120225199502083755', '1505', '机械类', '本科', '2015.10.01', '2016.03.24', '', '001');
INSERT INTO `t_party_lecture` VALUES ('18', '1', '19', '彭志伟', '男', '汉族', '1996.08', '350627199608230538', '1506', '机械类', '本科', '2015.10.01', '2016.03.24', '', '001');
INSERT INTO `t_party_lecture` VALUES ('19', '1', '20', '王相', '男', '汉族', '1997.01', '420103199701033715', '1506', '机械类', '本科', '2015.10.01', '2016.03.24', '', '001');
INSERT INTO `t_party_lecture` VALUES ('20', '1', '21', '邓世祥', '男', '汉族', '1996.09', '420922199609268215', '1507', '机械类', '本科', '2015.10.01', '2016.03.24', '', '001');
INSERT INTO `t_party_lecture` VALUES ('21', '1', '22', '郜依然', '男', '汉族', '1997.03', '420602199703112514', '1507', '机械类', '本科', '2015.10.01', '2016.03.24', '', '001');
INSERT INTO `t_party_lecture` VALUES ('22', '1', '23', '罗建', '男', '汉族', '1996.04', '421087199604255319', '1508', '机械类', '本科', '2015.10.01', '2016.03.24', '', '001');
INSERT INTO `t_party_lecture` VALUES ('23', '1', '24', '祖逸伦', '男', '汉族', '1997.08', '110103199708201512', '1509', '机械类', '本科', '2015.10.01', '2016.03.24', '', '001');
INSERT INTO `t_party_lecture` VALUES ('24', '1', '25', '付世文', '男', '汉族', '1997.08', '421125199708188217', '1509', '机械类', '本科', '2015.10.01', '2015.10.10', '', '001');
INSERT INTO `t_party_lecture` VALUES ('25', '1', '26', '赵友玉', '男', '汉族', '1994.08', '411524199408058035', '1510', '机械类', '本科', '2015.10.01', '2016.03.24', '', '001');
INSERT INTO `t_party_lecture` VALUES ('26', '1', '27', '凡龙', '男', '汉族', '1996.09', '420683199609200014', '1510', '机械类', '本科', '2015.10.01', '2016.03.24', '', '001');
INSERT INTO `t_party_lecture` VALUES ('27', '1', '28', '郭宇', '男', '汉族', '1994.06', '429006199406084271', '机械工程', '机械工程', '研究生', '2016.02.26', '2016.04.08', '', '001');
INSERT INTO `t_party_lecture` VALUES ('28', '1', '29', '何兆雄', '男', '汉族', '1997.11', '420103199711264955', '1508', '机械类', '本科', '2015.01.01', '2016.03.24', '', '001');
INSERT INTO `t_party_lecture` VALUES ('29', '1', '30', '梁会勇', '男', '汉族', '1996.09', '450803199609196152', '1502', '机械类', '本科', '2015.12.01', '2016.03.24', '', '001');
INSERT INTO `t_party_lecture` VALUES ('30', '1', '31', '王健', '男', '汉族', '1995.12', '429005199512010616', '1507', '机械类', '本科', '2015.12.01', '2016.03.24', '', '001');
INSERT INTO `t_party_lecture` VALUES ('31', '1', '32', '穆晓佳', '男', '汉族', '1995.10', '130481199510042893', '1501', '机械类', '本科', '2015.01.01', '2016.03.28', '', '001');
INSERT INTO `t_party_lecture` VALUES ('32', '1', '33', '贾江成', '男', '汉族', '1996.09', '42068419960905501X', '1404', '机械类', '本科', '2014.09.01', '2016.04.11', '', '001');
INSERT INTO `t_party_lecture` VALUES ('33', '1', '34', '王玉君', '女', '汉族', '1997.02', '460004199702080626', '1505', '机械类', '本科', '2015.10.01', '2016.03.24', '', '001');
INSERT INTO `t_party_lecture` VALUES ('34', '1', '35', '李佳颖', '女', '汉族', '1995.09', '510682199509230027', '1509', '机械类', '本科', '2015.10.01', '2016.03.24', '', '001');
INSERT INTO `t_party_lecture` VALUES ('35', '1', '36', '刘鑫月', '女', '汉族', '1998.01', '420984199801080027', '1502', '机械类', '本科', '2015.01.01', '2016.03.24', '', '001');
INSERT INTO `t_party_lecture` VALUES ('36', '1', '37', '黄潇', '女', '回族', '1997.11', '420881199711160045', '1503', '机械类', '本科', '2015.01.01', '2016.03.24', '', '001');
INSERT INTO `t_party_lecture` VALUES ('37', '1', '38', '郑凯芸', '女', '汉族', '1998.03', '420621199803110021', '1504', '机械类', '本科', '2015.01.01', '2016.03.28', '', '001');
INSERT INTO `t_party_lecture` VALUES ('38', '1', '39', '万雅妮', '女', '汉族', '1996.01', '420112199601052747', '机制1402', '机械设计与制造', '专科', '2014.10.01', '2015.03.20', '', '001');
INSERT INTO `t_party_lecture` VALUES ('39', '2', '2', '周华晋', '男', '土家族', '1996.08', '500243199608061996', '1408', '机械类', '本科', '2014.09.01', '2016.04.11', '', '001');
INSERT INTO `t_party_lecture` VALUES ('40', '2', '3', '邹叶鑫', '男', '汉族', '1996.07', '432503199607277698', '1410', '机械类', '本科', '2014.09.01', '2016.04.11', '', '001');
INSERT INTO `t_party_lecture` VALUES ('41', '2', '4', '周盼', '男', '汉族', '1996.02', '420802199602261618', '1401', '机械类', '本科', '2014.09.01', '2016.04.11', '', '001');
INSERT INTO `t_party_lecture` VALUES ('42', '2', '5', '商建', '男', '汉族', '1996.02', '421181199602078491', '1409', '机械类', '本科', '2014.09.01', '2016.04.11', '', '001');
INSERT INTO `t_party_lecture` VALUES ('43', '2', '6', '陈兵', '男', '汉族', '1995.12', '429005199512068754', '1405', '机械类', '本科', '2014.09.01', '2016.04.11', '', '001');
INSERT INTO `t_party_lecture` VALUES ('44', '2', '7', '李存程', '男', '汉族', '1995.10', '620403199510013133', '1405', '机械类', '本科', '2014.09.01', '2016.04.11', '', '001');
INSERT INTO `t_party_lecture` VALUES ('45', '2', '8', '李书飞', '男', '汉族', '1995.07', '420684199507233516', '1407', '机械类', '本科', '2014.09.01', '2016.04.11', '', '001');
INSERT INTO `t_party_lecture` VALUES ('46', '2', '9', '朱正想', '男', '汉族', '1995.02', '42118119950215133X', '1402', '机械类', '本科', '2014.09.01', '2016.04.11', '', '001');
INSERT INTO `t_party_lecture` VALUES ('47', '2', '10', '刘高仁', '男', '汉族', '1994.11', '420281199411231291', '1403', '机械类', '本科', '2014.09.01', '2016.04.11', '', '001');
INSERT INTO `t_party_lecture` VALUES ('48', '2', '11', '徐超', '男', '汉族', '1994.08', '420704199408015576', '1401', '机械类', '本科', '2014.09.01', '2016.04.11', '', '001');
INSERT INTO `t_party_lecture` VALUES ('49', '2', '12', '陶昱', '男', '汉族', '1996.02', '522427199602287237', '1501', '机械类', '本科', '2015.10.01', '2015.10.10', '', '001');
INSERT INTO `t_party_lecture` VALUES ('50', '2', '13', '柳仔', '男', '汉族', '1997.01', '420116199701180450', '1501', '机械类', '本科', '2015.10.01', '2016.03.24', '', '001');
INSERT INTO `t_party_lecture` VALUES ('51', '2', '14', '熊文斌', '男', '汉族', '1995.07', '429006199507082152', '1501', '机械类', '本科', '2015.10.01', '2016.03.24', '', '001');
INSERT INTO `t_party_lecture` VALUES ('52', '2', '15', '严欢', '男', '汉族', '1997.01', '420111199701186631', '1503', '机械类', '本科', '2015.10.01', '2016.03.24', '', '001');
INSERT INTO `t_party_lecture` VALUES ('53', '2', '16', '李亚男', '男', '汉族', '1997.03', '140624199703110050', '1503', '机械类', '本科', '2015.10.01', '2015.10.10', '', '001');
INSERT INTO `t_party_lecture` VALUES ('54', '2', '17', '徐英杰', '男', '汉族', '1997.10', '420922199710092816', '1504', '机械类', '本科', '2015.10.01', '2016.03.24', '', '001');
INSERT INTO `t_party_lecture` VALUES ('55', '2', '18', '刘宝山', '男', '汉族', '1995.02', '120225199502083755', '1505', '机械类', '本科', '2015.10.01', '2016.03.24', '', '001');
INSERT INTO `t_party_lecture` VALUES ('56', '2', '19', '彭志伟', '男', '汉族', '1996.08', '350627199608230538', '1506', '机械类', '本科', '2015.10.01', '2016.03.24', '', '001');
INSERT INTO `t_party_lecture` VALUES ('57', '2', '20', '王相', '男', '汉族', '1997.01', '420103199701033715', '1506', '机械类', '本科', '2015.10.01', '2016.03.24', '', '001');
INSERT INTO `t_party_lecture` VALUES ('58', '2', '21', '邓世祥', '男', '汉族', '1996.09', '420922199609268215', '1507', '机械类', '本科', '2015.10.01', '2016.03.24', '', '001');
INSERT INTO `t_party_lecture` VALUES ('59', '2', '22', '郜依然', '男', '汉族', '1997.03', '420602199703112514', '1507', '机械类', '本科', '2015.10.01', '2016.03.24', '', '001');
INSERT INTO `t_party_lecture` VALUES ('60', '2', '23', '罗建', '男', '汉族', '1996.04', '421087199604255319', '1508', '机械类', '本科', '2015.10.01', '2016.03.24', '', '001');
INSERT INTO `t_party_lecture` VALUES ('61', '2', '24', '祖逸伦', '男', '汉族', '1997.08', '110103199708201512', '1509', '机械类', '本科', '2015.10.01', '2016.03.24', '', '001');
INSERT INTO `t_party_lecture` VALUES ('62', '2', '25', '付世文', '男', '汉族', '1997.08', '421125199708188217', '1509', '机械类', '本科', '2015.10.01', '2015.10.10', '', '001');
INSERT INTO `t_party_lecture` VALUES ('63', '2', '26', '赵友玉', '男', '汉族', '1994.08', '411524199408058035', '1510', '机械类', '本科', '2015.10.01', '2016.03.24', '', '001');
INSERT INTO `t_party_lecture` VALUES ('64', '2', '27', '凡龙', '男', '汉族', '1996.09', '420683199609200014', '1510', '机械类', '本科', '2015.10.01', '2016.03.24', '', '001');
INSERT INTO `t_party_lecture` VALUES ('65', '2', '28', '郭宇', '男', '汉族', '1994.06', '429006199406084271', '机械工程', '机械工程', '研究生', '2016.02.26', '2016.04.08', '', '001');
INSERT INTO `t_party_lecture` VALUES ('66', '2', '29', '何兆雄', '男', '汉族', '1997.11', '420103199711264955', '1508', '机械类', '本科', '2015.01.01', '2016.03.24', '', '001');
INSERT INTO `t_party_lecture` VALUES ('67', '2', '30', '梁会勇', '男', '汉族', '1996.09', '450803199609196152', '1502', '机械类', '本科', '2015.12.01', '2016.03.24', '', '001');
INSERT INTO `t_party_lecture` VALUES ('68', '2', '31', '王健', '男', '汉族', '1995.12', '429005199512010616', '1507', '机械类', '本科', '2015.12.01', '2016.03.24', '', '001');
INSERT INTO `t_party_lecture` VALUES ('69', '2', '32', '穆晓佳', '男', '汉族', '1995.10', '130481199510042893', '1501', '机械类', '本科', '2015.01.01', '2016.03.28', '', '001');
INSERT INTO `t_party_lecture` VALUES ('70', '2', '33', '贾江成', '男', '汉族', '1996.09', '42068419960905501X', '1404', '机械类', '本科', '2014.09.01', '2016.04.11', '', '001');
INSERT INTO `t_party_lecture` VALUES ('71', '2', '34', '王玉君', '女', '汉族', '1997.02', '460004199702080626', '1505', '机械类', '本科', '2015.10.01', '2016.03.24', '', '001');
INSERT INTO `t_party_lecture` VALUES ('72', '2', '35', '李佳颖', '女', '汉族', '1995.09', '510682199509230027', '1509', '机械类', '本科', '2015.10.01', '2016.03.24', '', '001');
INSERT INTO `t_party_lecture` VALUES ('73', '2', '36', '刘鑫月', '女', '汉族', '1998.01', '420984199801080027', '1502', '机械类', '本科', '2015.01.01', '2016.03.24', '', '001');
INSERT INTO `t_party_lecture` VALUES ('74', '2', '37', '黄潇', '女', '回族', '1997.11', '420881199711160045', '1503', '机械类', '本科', '2015.01.01', '2016.03.24', '', '001');
INSERT INTO `t_party_lecture` VALUES ('75', '2', '38', '郑凯芸', '女', '汉族', '1998.03', '420621199803110021', '1504', '机械类', '本科', '2015.01.01', '2016.03.28', '', '001');
INSERT INTO `t_party_lecture` VALUES ('76', '2', '39', '万雅妮', '女', '汉族', '1996.01', '420112199601052747', '机制1402', '机械设计与制造', '专科', '2014.10.01', '2015.03.20', '', '001');
INSERT INTO `t_party_lecture` VALUES ('77', '3', '2', '周华晋', '男', '土家族', '1996.08', '500243199608061996', '1408', '机械类', '本科', '2014.09.01', '2016.04.11', '', '001');
INSERT INTO `t_party_lecture` VALUES ('78', '3', '3', '邹叶鑫', '男', '汉族', '1996.07', '432503199607277698', '1410', '机械类', '本科', '2014.09.01', '2016.04.11', '', '001');
INSERT INTO `t_party_lecture` VALUES ('79', '3', '4', '周盼', '男', '汉族', '1996.02', '420802199602261618', '1401', '机械类', '本科', '2014.09.01', '2016.04.11', '', '001');
INSERT INTO `t_party_lecture` VALUES ('80', '3', '5', '商建', '男', '汉族', '1996.02', '421181199602078491', '1409', '机械类', '本科', '2014.09.01', '2016.04.11', '', '001');
INSERT INTO `t_party_lecture` VALUES ('81', '3', '6', '陈兵', '男', '汉族', '1995.12', '429005199512068754', '1405', '机械类', '本科', '2014.09.01', '2016.04.11', '', '001');
INSERT INTO `t_party_lecture` VALUES ('82', '3', '7', '李存程', '男', '汉族', '1995.10', '620403199510013133', '1405', '机械类', '本科', '2014.09.01', '2016.04.11', '', '001');
INSERT INTO `t_party_lecture` VALUES ('83', '3', '8', '李书飞', '男', '汉族', '1995.07', '420684199507233516', '1407', '机械类', '本科', '2014.09.01', '2016.04.11', '', '001');
INSERT INTO `t_party_lecture` VALUES ('84', '3', '9', '朱正想', '男', '汉族', '1995.02', '42118119950215133X', '1402', '机械类', '本科', '2014.09.01', '2016.04.11', '', '001');
INSERT INTO `t_party_lecture` VALUES ('85', '3', '10', '刘高仁', '男', '汉族', '1994.11', '420281199411231291', '1403', '机械类', '本科', '2014.09.01', '2016.04.11', '', '001');
INSERT INTO `t_party_lecture` VALUES ('86', '3', '11', '徐超', '男', '汉族', '1994.08', '420704199408015576', '1401', '机械类', '本科', '2014.09.01', '2016.04.11', '', '001');
INSERT INTO `t_party_lecture` VALUES ('87', '3', '12', '陶昱', '男', '汉族', '1996.02', '522427199602287237', '1501', '机械类', '本科', '2015.10.01', '2015.10.10', '', '001');
INSERT INTO `t_party_lecture` VALUES ('88', '3', '13', '柳仔', '男', '汉族', '1997.01', '420116199701180450', '1501', '机械类', '本科', '2015.10.01', '2016.03.24', '', '001');
INSERT INTO `t_party_lecture` VALUES ('89', '3', '14', '熊文斌', '男', '汉族', '1995.07', '429006199507082152', '1501', '机械类', '本科', '2015.10.01', '2016.03.24', '', '001');
INSERT INTO `t_party_lecture` VALUES ('90', '3', '15', '严欢', '男', '汉族', '1997.01', '420111199701186631', '1503', '机械类', '本科', '2015.10.01', '2016.03.24', '', '001');
INSERT INTO `t_party_lecture` VALUES ('91', '3', '16', '李亚男', '男', '汉族', '1997.03', '140624199703110050', '1503', '机械类', '本科', '2015.10.01', '2015.10.10', '', '001');
INSERT INTO `t_party_lecture` VALUES ('92', '3', '17', '徐英杰', '男', '汉族', '1997.10', '420922199710092816', '1504', '机械类', '本科', '2015.10.01', '2016.03.24', '', '001');
INSERT INTO `t_party_lecture` VALUES ('93', '3', '18', '刘宝山', '男', '汉族', '1995.02', '120225199502083755', '1505', '机械类', '本科', '2015.10.01', '2016.03.24', '', '001');
INSERT INTO `t_party_lecture` VALUES ('94', '3', '19', '彭志伟', '男', '汉族', '1996.08', '350627199608230538', '1506', '机械类', '本科', '2015.10.01', '2016.03.24', '', '001');
INSERT INTO `t_party_lecture` VALUES ('95', '3', '20', '王相', '男', '汉族', '1997.01', '420103199701033715', '1506', '机械类', '本科', '2015.10.01', '2016.03.24', '', '001');
INSERT INTO `t_party_lecture` VALUES ('96', '3', '21', '邓世祥', '男', '汉族', '1996.09', '420922199609268215', '1507', '机械类', '本科', '2015.10.01', '2016.03.24', '', '001');
INSERT INTO `t_party_lecture` VALUES ('97', '3', '22', '郜依然', '男', '汉族', '1997.03', '420602199703112514', '1507', '机械类', '本科', '2015.10.01', '2016.03.24', '', '001');
INSERT INTO `t_party_lecture` VALUES ('98', '3', '23', '罗建', '男', '汉族', '1996.04', '421087199604255319', '1508', '机械类', '本科', '2015.10.01', '2016.03.24', '', '001');
INSERT INTO `t_party_lecture` VALUES ('99', '3', '24', '祖逸伦', '男', '汉族', '1997.08', '110103199708201512', '1509', '机械类', '本科', '2015.10.01', '2016.03.24', '', '001');
INSERT INTO `t_party_lecture` VALUES ('100', '3', '25', '付世文', '男', '汉族', '1997.08', '421125199708188217', '1509', '机械类', '本科', '2015.10.01', '2015.10.10', '', '001');
INSERT INTO `t_party_lecture` VALUES ('101', '3', '26', '赵友玉', '男', '汉族', '1994.08', '411524199408058035', '1510', '机械类', '本科', '2015.10.01', '2016.03.24', '', '001');
INSERT INTO `t_party_lecture` VALUES ('102', '3', '27', '凡龙', '男', '汉族', '1996.09', '420683199609200014', '1510', '机械类', '本科', '2015.10.01', '2016.03.24', '', '001');
INSERT INTO `t_party_lecture` VALUES ('103', '3', '28', '郭宇', '男', '汉族', '1994.06', '429006199406084271', '机械工程', '机械工程', '研究生', '2016.02.26', '2016.04.08', '', '001');
INSERT INTO `t_party_lecture` VALUES ('104', '3', '29', '何兆雄', '男', '汉族', '1997.11', '420103199711264955', '1508', '机械类', '本科', '2015.01.01', '2016.03.24', '', '001');
INSERT INTO `t_party_lecture` VALUES ('105', '3', '30', '梁会勇', '男', '汉族', '1996.09', '450803199609196152', '1502', '机械类', '本科', '2015.12.01', '2016.03.24', '', '001');
INSERT INTO `t_party_lecture` VALUES ('106', '3', '31', '王健', '男', '汉族', '1995.12', '429005199512010616', '1507', '机械类', '本科', '2015.12.01', '2016.03.24', '', '001');
INSERT INTO `t_party_lecture` VALUES ('107', '3', '32', '穆晓佳', '男', '汉族', '1995.10', '130481199510042893', '1501', '机械类', '本科', '2015.01.01', '2016.03.28', '', '001');
INSERT INTO `t_party_lecture` VALUES ('108', '3', '33', '贾江成', '男', '汉族', '1996.09', '42068419960905501X', '1404', '机械类', '本科', '2014.09.01', '2016.04.11', '', '001');
INSERT INTO `t_party_lecture` VALUES ('109', '3', '34', '王玉君', '女', '汉族', '1997.02', '460004199702080626', '1505', '机械类', '本科', '2015.10.01', '2016.03.24', '', '001');
INSERT INTO `t_party_lecture` VALUES ('110', '3', '35', '李佳颖', '女', '汉族', '1995.09', '510682199509230027', '1509', '机械类', '本科', '2015.10.01', '2016.03.24', '', '001');
INSERT INTO `t_party_lecture` VALUES ('111', '3', '36', '刘鑫月', '女', '汉族', '1998.01', '420984199801080027', '1502', '机械类', '本科', '2015.01.01', '2016.03.24', '', '001');
INSERT INTO `t_party_lecture` VALUES ('112', '3', '37', '黄潇', '女', '回族', '1997.11', '420881199711160045', '1503', '机械类', '本科', '2015.01.01', '2016.03.24', '', '001');
INSERT INTO `t_party_lecture` VALUES ('113', '3', '38', '郑凯芸', '女', '汉族', '1998.03', '420621199803110021', '1504', '机械类', '本科', '2015.01.01', '2016.03.28', '', '001');
INSERT INTO `t_party_lecture` VALUES ('114', '3', '39', '万雅妮', '女', '汉族', '1996.01', '420112199601052747', '机制1402', '机械设计与制造', '专科', '2014.10.01', '2015.03.20', '', '001');
INSERT INTO `t_party_lecture` VALUES ('115', '4', '23123', '', '', '', '', '', '', '', '', '', '', '', '001');
INSERT INTO `t_party_lecture` VALUES ('116', '5', '1', '231', '312', '23', '13', '321', '331', '132', '1', '23213', '132', '', '001');

-- ----------------------------
-- Table structure for t_probationary_member
-- ----------------------------
DROP TABLE IF EXISTS `t_probationary_member`;
CREATE TABLE `t_probationary_member` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `info_id` int(11) DEFAULT NULL COMMENT 'excel关联的表的id',
  `code` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '序号',
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '姓名',
  `sex` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '性别',
  `nation` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '民族',
  `birthday` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '出生年月',
  `id_card` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '身份证号码',
  `classroom` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '班级',
  `profession` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '专业',
  `student_level` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '学生层次',
  `application_date` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '申请入党时间',
  `lecture_num` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '成为正式党员时间',
  `probationary_date` varchar(255) COLLATE utf8_unicode_ci DEFAULT '',
  `data_status` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of t_probationary_member
-- ----------------------------
INSERT INTO `t_probationary_member` VALUES ('1', '1', null, null, null, null, null, null, null, null, null, null, null, null, '001');
INSERT INTO `t_probationary_member` VALUES ('2', '2', '1', '231', '312', '23', '13', '321', '331', '132', '1', '23213', '132', '123', '001');

-- ----------------------------
-- Table structure for t_punish_info
-- ----------------------------
DROP TABLE IF EXISTS `t_punish_info`;
CREATE TABLE `t_punish_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `info_id` int(11) DEFAULT NULL COMMENT '关联id',
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '姓名',
  `student_id` int(11) DEFAULT '0' COMMENT '学号',
  `classroom` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '班级',
  `punish_grade` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '处分等级',
  `punish_reason` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '处分原因',
  `punish_time` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '处分时间',
  `data_status` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of t_punish_info
-- ----------------------------
INSERT INTO `t_punish_info` VALUES ('1', '1', '张三', '1405', '机械1401', '警告', '警告', '1996年12月12日', '001');

-- ----------------------------
-- Table structure for t_regular_member
-- ----------------------------
DROP TABLE IF EXISTS `t_regular_member`;
CREATE TABLE `t_regular_member` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `info_id` int(11) DEFAULT NULL COMMENT 'excel关联的表的id',
  `code` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '序号',
  `party_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT '',
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '姓名',
  `sex` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '性别',
  `nation` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '民族',
  `birthday` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '出生年月',
  `id_card` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '身份证号码',
  `classroom` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '班级',
  `profession` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '专业',
  `student_level` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '学生层次',
  `probationary_member_date` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '申请入党时间',
  `regular_party_member_date` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '成为正式党员时间',
  `data_status` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of t_regular_member
-- ----------------------------
INSERT INTO `t_regular_member` VALUES ('1', '1', null, null, null, null, null, null, null, null, null, null, null, null, '001');
INSERT INTO `t_regular_member` VALUES ('2', '2', null, null, null, null, null, null, null, null, null, null, null, null, '001');
INSERT INTO `t_regular_member` VALUES ('3', '3', '1', 'asd', '231', '312', '23', '13', '321', '331', '132', '1', '23213', '132', '001');

-- ----------------------------
-- Table structure for t_student_reward
-- ----------------------------
DROP TABLE IF EXISTS `t_student_reward`;
CREATE TABLE `t_student_reward` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `info_id` int(11) DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '姓名',
  `student_id` int(11) DEFAULT '0' COMMENT '学号',
  `grade` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '年级',
  `classroom` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '班级',
  `reward_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '获奖名称',
  `reward_grade` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '获奖等级',
  `reward_time` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '获奖时间',
  `remark` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '备注',
  `reward_nature` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '奖状性质',
  `data_status` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of t_student_reward
-- ----------------------------
INSERT INTO `t_student_reward` VALUES ('1', '1', '张三', '1405', '大三', '机械1401', '机械创新大赛', '省一等奖', '1996年12月12日', '', '省级奖及以上', '001');
INSERT INTO `t_student_reward` VALUES ('2', '1', '张三', '1405', '大三', '机械1401', '机械创新大赛', '省一等奖', '1996年12月12日', '', '', '001');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '邮箱',
  `login_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '登录名',
  `real_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '真实名',
  `password` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '密码',
  `level` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '权限',
  `creator` int(11) DEFAULT NULL COMMENT '创始人',
  `create_time` datetime DEFAULT NULL COMMENT '创造日期',
  `reviser` int(11) DEFAULT NULL COMMENT '修改人',
  `reviser_time` datetime DEFAULT NULL COMMENT '修改时间',
  `data_status` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('2', 'fsddfsad@qq.com', 'cbjcl0204', '蒋春丽', 'E10ADC3949BA59ABBE56E057F20F883E', '辅导员', null, '2017-03-24 20:38:56', '3', '2017-04-11 13:21:00', '002');
INSERT INTO `t_user` VALUES ('3', 'cbjcl0204@163.com', 'admin', '王老师', '3707D3D1A29E56EA7578F3EEDCD843DD', '管理员', '2', '2017-04-03 14:32:52', '3', '2017-04-11 12:32:19', '001');
INSERT INTO `t_user` VALUES ('6', '406714868@qq.com', 'cbjcl0204', '蒋春丽', 'E10ADC3949BA59ABBE56E057F20F883E', '辅导员', '3', '2017-04-11 13:20:37', null, null, '001');

-- ----------------------------
-- Table structure for t_word_info
-- ----------------------------
DROP TABLE IF EXISTS `t_word_info`;
CREATE TABLE `t_word_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `info_id` int(11) DEFAULT NULL,
  `url` varchar(255) COLLATE utf8_unicode_ci DEFAULT '空' COMMENT '地址',
  `number` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '工作计划及总结:10011 毕业生派遣方案（毕业年级):10012, 学期开展活动汇总表及方案:20003,本学期发文文件:30002,学期值班表:30004,就业质量年度报告:30006,新闻报道上传情况:30007',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of t_word_info
-- ----------------------------
INSERT INTO `t_word_info` VALUES ('1', '1', '13eb9b617-e52f-44e8-a2f9-a23f4fbe1682.doc', '10011');
INSERT INTO `t_word_info` VALUES ('2', '2', '26fa25ad1-d8b3-4dcf-9211-d49464e46725.doc', '10011');
INSERT INTO `t_word_info` VALUES ('3', '3', '33f28103f-36bf-44cc-8f0d-ba3acedc79c6.doc', '10011');
INSERT INTO `t_word_info` VALUES ('4', '4', '4457de821-f00b-4381-9e72-fb50c8d02e38.doc', '10011');
INSERT INTO `t_word_info` VALUES ('5', '5', '51886da83-6c6e-4f3a-b80e-4631ec96bf19.doc', '10011');
INSERT INTO `t_word_info` VALUES ('6', '6', '6816e60e2-dd99-490d-a5bf-2dd7711a8d5e.doc', '10011');
INSERT INTO `t_word_info` VALUES ('7', '7', '79ac537ca-b8ec-44ac-8d46-030dfdc9cd5c.doc', '10011');
INSERT INTO `t_word_info` VALUES ('8', '8', '880b29b9c-20c4-409e-83b9-d1109183303a.doc', '10011');
INSERT INTO `t_word_info` VALUES ('9', '9', '9dc355ce2-5677-47c3-a5cd-467afc89e457.doc', '10012');
INSERT INTO `t_word_info` VALUES ('10', '10', '1019198302-2c5f-4b3e-87a3-cc8269be0a1a.xls', '10012');
INSERT INTO `t_word_info` VALUES ('11', '11', '1101d24afe-bc24-49ca-a096-3eb01a4503c3.doc', '10012');
INSERT INTO `t_word_info` VALUES ('12', '12', '12196f0138-59bd-4d05-a0d2-0224f6e45d34.xls', '10012');
INSERT INTO `t_word_info` VALUES ('13', '13', '1366bd598d-44ec-45bc-9822-c905358e43f9.xls', '10012');
INSERT INTO `t_word_info` VALUES ('14', '14', '141b177219-6f70-4220-ace0-bf23daa67227.xls', '30014');
