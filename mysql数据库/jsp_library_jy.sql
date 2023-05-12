/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : jsp_library_jy

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2020-02-06 22:59:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `author` varchar(20) DEFAULT NULL,
  `publish` varchar(20) DEFAULT NULL,
  `pages` int(10) DEFAULT NULL,
  `price` float(10,2) DEFAULT NULL,
  `bookcaseid` int(10) DEFAULT NULL,
  `abled` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `FK_ieh6qsxp6q7oydadktc9oc8t2` (`bookcaseid`) USING BTREE,
  CONSTRAINT `FK_ieh6qsxp6q7oydadktc9oc8t2` FOREIGN KEY (`bookcaseid`) REFERENCES `bookcase` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('2', '追风筝的人', '卡勒德·胡赛尼', '上海人民出版社', '230', '33.50', '3', '0');
INSERT INTO `book` VALUES ('3', '人间失格', '太宰治', '作家出版社', '150', '17.30', '1', '0');
INSERT INTO `book` VALUES ('4', '这就是二十四节气', '高春香', '海豚出版社', '220', '59.00', '3', '0');
INSERT INTO `book` VALUES ('5', '白夜行', '东野圭吾', '南海出版公司', '300', '27.30', '4', '0');
INSERT INTO `book` VALUES ('6', '摆渡人', '克莱儿·麦克福尔', '百花洲文艺出版社', '225', '22.80', '1', '1');
INSERT INTO `book` VALUES ('7', '暖暖心绘本', '米拦弗特毕', '湖南少儿出版社', '168', '131.60', '5', '1');
INSERT INTO `book` VALUES ('8', '天才在左疯子在右', '高铭', '北京联合出版公司', '330', '21.50', '6', '0');
INSERT INTO `book` VALUES ('9', '我们仨', '杨绛', '生活.读书.新知三联书店', '89', '17.20', '7', '1');
INSERT INTO `book` VALUES ('10', '活着', '余华', '作家出版社', '100', '13.00', '1', '0');
INSERT INTO `book` VALUES ('11', '水浒传', '施耐庵', '三联出版社', '300', '50.00', '1', '1');
INSERT INTO `book` VALUES ('12', '三国演义', '罗贯中', '三联出版社', '300', '50.00', '1', '1');
INSERT INTO `book` VALUES ('13', '红楼梦', '曹雪芹', '三联出版社', '300', '50.00', '5', '0');
INSERT INTO `book` VALUES ('14', '西游记', '吴承恩', '三联出版社', '300', '60.00', '3', '1');
INSERT INTO `book` VALUES ('15', 'Java高级编程', 'Tom', '人民日报出版社', '500', '68.00', '1', '0');

-- ----------------------------
-- Table structure for `bookadmin`
-- ----------------------------
DROP TABLE IF EXISTS `bookadmin`;
CREATE TABLE `bookadmin` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(15) DEFAULT NULL,
  `password` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of bookadmin
-- ----------------------------
INSERT INTO `bookadmin` VALUES ('1', 'uadmin', '123456');
INSERT INTO `bookadmin` VALUES ('2', 'admin2', '222222');
INSERT INTO `bookadmin` VALUES ('3', 'zhangsan', '123123');

-- ----------------------------
-- Table structure for `bookcase`
-- ----------------------------
DROP TABLE IF EXISTS `bookcase`;
CREATE TABLE `bookcase` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of bookcase
-- ----------------------------
INSERT INTO `bookcase` VALUES ('1', '社会');
INSERT INTO `bookcase` VALUES ('3', '国学');
INSERT INTO `bookcase` VALUES ('4', '推理');
INSERT INTO `bookcase` VALUES ('5', '绘画');
INSERT INTO `bookcase` VALUES ('6', '心理学');
INSERT INTO `bookcase` VALUES ('7', '传记');
INSERT INTO `bookcase` VALUES ('8', '计算机');
INSERT INTO `bookcase` VALUES ('9', '小张');

-- ----------------------------
-- Table structure for `borrow`
-- ----------------------------
DROP TABLE IF EXISTS `borrow`;
CREATE TABLE `borrow` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `bookid` int(10) DEFAULT NULL,
  `readerid` int(10) DEFAULT NULL,
  `borrowtime` varchar(20) DEFAULT NULL,
  `returntime` varchar(20) DEFAULT NULL,
  `adminid` int(10) DEFAULT NULL,
  `state` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of borrow
-- ----------------------------
INSERT INTO `borrow` VALUES ('9', '2', '3', '2019-01-04 12:34:06', null, '1', '3');
INSERT INTO `borrow` VALUES ('10', '3', '3', '2019-01-04 12:35:25', null, '1', '3');
INSERT INTO `borrow` VALUES ('11', '4', '3', '2019-01-04 02:19:53', '2019-01-04 05:09:47', null, '3');
INSERT INTO `borrow` VALUES ('16', '2', '3', '2019-01-09 10:49:27', null, '1', '2');
INSERT INTO `borrow` VALUES ('17', '2', '3', '2019-01-09 14:40:31', null, '1', '3');
INSERT INTO `borrow` VALUES ('18', '15', '3', '2019-01-09 17:00:36', '2019-01-09 17:01:11', '1', '3');
INSERT INTO `borrow` VALUES ('19', '9', '3', '2019-01-09 17:03:03', '2019-01-09 17:03:22', '1', '3');
INSERT INTO `borrow` VALUES ('20', '8', '3', '2019-01-09 17:15:38', '2019-01-09 17:15:58', '1', '3');
INSERT INTO `borrow` VALUES ('21', '8', '3', '2019-01-09 17:16:22', '2019-01-10 15:00:34', '1', '2');
INSERT INTO `borrow` VALUES ('22', '2', '7', '2019-01-09 17:18:42', null, '1', '1');
INSERT INTO `borrow` VALUES ('23', '15', '7', '2019-01-09 17:20:52', null, '1', '1');
INSERT INTO `borrow` VALUES ('24', '5', '7', '2019-01-09 17:22:48', null, '1', '1');
INSERT INTO `borrow` VALUES ('25', '4', '3', '2019-01-14 14:34:18', null, '1', '1');
INSERT INTO `borrow` VALUES ('26', '4', '1', '2019-05-14 17:56:36', '2019-05-14 17:59:32', '1', '3');
INSERT INTO `borrow` VALUES ('27', '9', '1', '2019-05-14 17:56:42', '2019-08-28 14:39:18', '1', '3');
INSERT INTO `borrow` VALUES ('28', '10', '1', '2019-08-28 14:01:01', null, '1', '2');
INSERT INTO `borrow` VALUES ('29', '8', '1', '2019-08-28 14:02:02', null, '1', '4');
INSERT INTO `borrow` VALUES ('30', '8', '1', '2019-08-28 14:03:29', null, '1', '4');
INSERT INTO `borrow` VALUES ('31', '9', '1', '2019-08-28 14:03:34', null, '1', '4');
INSERT INTO `borrow` VALUES ('32', '13', '1', '2019-08-28 14:07:49', null, '1', '1');
INSERT INTO `borrow` VALUES ('33', '10', '1', '2019-08-28 14:56:55', null, '1', '1');
INSERT INTO `borrow` VALUES ('34', '12', '1', '2019-08-28 14:56:57', null, null, '0');
INSERT INTO `borrow` VALUES ('35', '9', '1', '2019-08-28 14:57:13', null, null, '0');

-- ----------------------------
-- Table structure for `reader`
-- ----------------------------
DROP TABLE IF EXISTS `reader`;
CREATE TABLE `reader` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `name` varchar(10) DEFAULT NULL,
  `tel` varchar(11) DEFAULT NULL,
  `cardid` varchar(20) DEFAULT NULL,
  `gender` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of reader
-- ----------------------------
INSERT INTO `reader` VALUES ('1', 'xiaozhang', '123456', '小张', '13520109202', '2323222222222111', '男');
INSERT INTO `reader` VALUES ('3', 'zhangsan', '123123', '张三', '18714313303', '12321312312312312', '男');
INSERT INTO `reader` VALUES ('6', 'tom', '123456', '王五', '13511100000', '2222211111111111', '男');
INSERT INTO `reader` VALUES ('7', 'jackie', '123456', '杰特', '15910000000', '2323222222222222', '男');
INSERT INTO `reader` VALUES ('8', 'adm', '123456', '张三', '13022502111', '2323222222222111', '男');

-- ----------------------------
-- Table structure for `returnbook`
-- ----------------------------
DROP TABLE IF EXISTS `returnbook`;
CREATE TABLE `returnbook` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `bookid` int(10) DEFAULT NULL,
  `readerid` int(10) DEFAULT NULL,
  `returntime` varchar(20) DEFAULT NULL,
  `adminid` int(10) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of returnbook
-- ----------------------------
INSERT INTO `returnbook` VALUES ('1', '2', '3', '2019-01-10 14:56:24', '1', '2');
INSERT INTO `returnbook` VALUES ('2', '3', '3', '2019-01-10 15:00:27', '1', '2');
INSERT INTO `returnbook` VALUES ('3', '2', '3', '2019-01-09 15:34:32', '1', null);
INSERT INTO `returnbook` VALUES ('4', '15', '3', '2019-01-09 17:00:56', '1', null);
INSERT INTO `returnbook` VALUES ('5', '9', '3', '2019-01-09 17:03:16', '1', null);
INSERT INTO `returnbook` VALUES ('6', '8', '3', '2019-01-10 15:00:34', '1', '2');
INSERT INTO `returnbook` VALUES ('7', '8', '3', '2019-01-14 11:00:54', '1', '1');
INSERT INTO `returnbook` VALUES ('8', '4', '1', '2019-05-14 17:59:32', '1', '3');
INSERT INTO `returnbook` VALUES ('9', '9', '1', '2019-08-28 14:39:17', '1', '3');
INSERT INTO `returnbook` VALUES ('10', '8', '1', '2019-08-28 14:39:29', null, '4');
INSERT INTO `returnbook` VALUES ('11', '9', '1', '2019-08-28 14:39:31', null, '4');
INSERT INTO `returnbook` VALUES ('12', '8', '1', '2019-08-28 14:56:46', null, '4');
