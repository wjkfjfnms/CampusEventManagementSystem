/*
 Navicat Premium Data Transfer

 Source Server         : ccdatabase
 Source Server Type    : MySQL
 Source Server Version : 80033
 Source Host           : localhost:3306
 Source Schema         : ccdatabase

 Target Server Type    : MySQL
 Target Server Version : 80033
 File Encoding         : 65001

 Date: 30/06/2023 19:42:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_admin
-- ----------------------------
DROP TABLE IF EXISTS `tb_admin`;
CREATE TABLE `tb_admin`  (
  `AdminName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '管理员名字',
  `Sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '性别',
  `ID` int NOT NULL AUTO_INCREMENT COMMENT '编号',
  `Unit` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '广州城市理工学院' COMMENT '单位',
  `Address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '地址',
  `Age` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '年龄',
  `Number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `Account` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '管理员账号',
  `Password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '管理员密码',
  `Origin` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '籍贯',
  `UserType` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '主办方' COMMENT '用户类型',
  `State` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'Y' COMMENT '状态',
  `Nation` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '民族',
  `birthday` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '出生年月',
  `DocumentType` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '证件类型',
  `DocumentNumber` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '证件号码',
  `MAddress` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '通讯地址',
  PRIMARY KEY (`ID`) USING BTREE,
  UNIQUE INDEX `ID`(`ID` ASC) USING BTREE,
  INDEX `admin_account`(`Account` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 101 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '管理员表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_admin
-- ----------------------------
INSERT INTO `tb_admin` VALUES ('管理员1', '男', 1, '广州城市理工学院', '广州市天河区', '23', '1351849484', 'admin1', '123', '广东省', '管理员', 'Y', '', NULL, '', '', '');
INSERT INTO `tb_admin` VALUES ('管理员2', '女', 2, '广州城市理工学院', '广州市番禺区', '22', '13800002222', 'user2', '123', '广东省', '管理员', 'N', '', NULL, '', '', '');
INSERT INTO `tb_admin` VALUES ('user109', 'tests', 32, 'tests', 'tests', 'tests', 'tests', '111', '123', 'tests', '管理员', 'Y', '汉', '2002/03/15', '居民身份证', '123123', '通讯地址');

-- ----------------------------
-- Table structure for tb_ads
-- ----------------------------
DROP TABLE IF EXISTS `tb_ads`;
CREATE TABLE `tb_ads`  (
  `ads_id` int NOT NULL COMMENT '广告编号（唯一，主键）',
  `sponsors` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '广告商',
  `adsType` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '广告类型',
  `videoAdress` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '视频地址',
  `imageAdress` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '广告海报地址',
  `state` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '状态，是否通过审核',
  `id` int NULL DEFAULT NULL,
  `Items` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ads_id`) USING BTREE,
  INDEX `id`(`id` ASC) USING BTREE,
  INDEX `Items`(`Items` ASC) USING BTREE,
  CONSTRAINT `id` FOREIGN KEY (`id`) REFERENCES `tb_match` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Items` FOREIGN KEY (`Items`) REFERENCES `tb_match` (`Items`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_ads
-- ----------------------------
INSERT INTO `tb_ads` VALUES (202010, 'test', 'test', NULL, 'test', 'test', 1, '微信小程序大赛');
INSERT INTO `tb_ads` VALUES (202012, 'test1', 'test1', NULL, 'test1', 'test1', 1, '微信小程序大赛');
INSERT INTO `tb_ads` VALUES (202013, 'test1', 'test1', NULL, 'test1', 'test1', 1, '微信小程序大赛');
INSERT INTO `tb_ads` VALUES (202014, 'test1', 'test1', NULL, 'test1', 'test1', 1, '微信小程序大赛');
INSERT INTO `tb_ads` VALUES (202015, 'test1', 'test1', NULL, 'test1', 'test1', 1, '微信小程序大赛');
INSERT INTO `tb_ads` VALUES (202016, 'test1', 'test1', NULL, 'test1', 'test1', 1, '微信小程序大赛');
INSERT INTO `tb_ads` VALUES (202017, 'test1', 'test1', NULL, 'test1', 'test1', 1, '微信小程序大赛');
INSERT INTO `tb_ads` VALUES (202018, 'test1', 'test1', NULL, 'test1', 'test1', 1, '微信小程序大赛');
INSERT INTO `tb_ads` VALUES (202019, 'test1', 'test1', NULL, 'test1', 'test1', 1, '微信小程序大赛');
INSERT INTO `tb_ads` VALUES (202020, 'test1', 'test1', NULL, 'test1', 'test1', 1, '微信小程序大赛');

-- ----------------------------
-- Table structure for tb_history
-- ----------------------------
DROP TABLE IF EXISTS `tb_history`;
CREATE TABLE `tb_history`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '登录记录id',
  `Account` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '登录账号',
  `how` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'WEB' COMMENT '登录方式',
  `ip` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '登录ip',
  `time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '登录记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_history
-- ----------------------------
INSERT INTO `tb_history` VALUES (1, 'user1', '', '', '2023-06-12 20:39:05');
INSERT INTO `tb_history` VALUES (2, 'user1', 'PC', '192.155.13.7', '2023-06-21 10:28:58');
INSERT INTO `tb_history` VALUES (3, 'admin2', 'PC', '192.155.13.7', '2023-06-21 10:37:42');
INSERT INTO `tb_history` VALUES (4, 'admin1', 'PC', '192.155.13.7', '2023-06-21 10:38:31');
INSERT INTO `tb_history` VALUES (5, 'admin1', 'PC', '192.155.13.7', '2023-06-21 11:40:05');
INSERT INTO `tb_history` VALUES (6, 'admin1', 'PC', '192.155.13.7', '2023-06-26 20:12:46');
INSERT INTO `tb_history` VALUES (7, 'admin1', 'PC', '192.155.13.7', '2023-06-27 20:34:18');
INSERT INTO `tb_history` VALUES (8, 'user2', 'PC', '192.155.13.7', '2023-06-28 20:34:18');
INSERT INTO `tb_history` VALUES (9, 'user2', 'PC', '192.155.13.7', '2023-06-28 20:34:18');
INSERT INTO `tb_history` VALUES (10, 'user100', 'PC', '192.155.13.7', '2023-06-28 20:29:55');
INSERT INTO `tb_history` VALUES (11, 'admin1', 'PC', '192.155.13.7', '2023-06-28 21:00:48');
INSERT INTO `tb_history` VALUES (12, 'user100', 'PC', '192.155.13.7', '2023-06-28 21:14:26');
INSERT INTO `tb_history` VALUES (13, 'user100', 'PC', '192.155.13.7', '2023-06-28 21:37:45');
INSERT INTO `tb_history` VALUES (14, 'admin1', 'PC', '192.155.13.7', '2023-06-29 20:21:49');
INSERT INTO `tb_history` VALUES (15, 'user100', 'PC', '192.155.13.7', '2023-06-29 20:32:27');
INSERT INTO `tb_history` VALUES (16, 'user123', 'PC', '192.155.13.7', '2023-06-29 20:34:03');
INSERT INTO `tb_history` VALUES (17, 'user99', 'PC', '192.155.13.7', '2023-06-29 20:35:48');
INSERT INTO `tb_history` VALUES (18, 'user99', 'PC', '192.155.13.7', '2023-06-29 20:40:05');
INSERT INTO `tb_history` VALUES (19, 'user99', 'PC', '192.155.13.7', '2023-06-29 20:41:09');
INSERT INTO `tb_history` VALUES (20, 'user99', 'PC', '192.155.13.7', '2023-06-29 20:42:06');
INSERT INTO `tb_history` VALUES (21, 'user99', 'PC', '192.155.13.7', '2023-06-29 20:45:19');
INSERT INTO `tb_history` VALUES (22, 'admin1', 'PC', '192.155.13.7', '2023-06-29 20:48:55');
INSERT INTO `tb_history` VALUES (23, 'user99', 'PC', '192.155.13.7', '2023-06-29 21:02:35');
INSERT INTO `tb_history` VALUES (24, 'admin1', 'PC', '192.155.13.7', '2023-06-29 21:10:26');
INSERT INTO `tb_history` VALUES (25, 'admin1', 'PC', '192.155.13.7', '2023-06-30 17:18:54');
INSERT INTO `tb_history` VALUES (26, 'admin1', 'PC', '192.155.13.7', '2023-06-30 17:20:13');
INSERT INTO `tb_history` VALUES (27, 'admin1', 'PC', '192.155.13.7', '2023-06-30 17:50:57');

-- ----------------------------
-- Table structure for tb_match
-- ----------------------------
DROP TABLE IF EXISTS `tb_match`;
CREATE TABLE `tb_match`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '比赛编号',
  `Unit` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '广州城市理工学院' COMMENT '单位',
  `UnitAddress` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '单位地址',
  `Type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '类型',
  `Items` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '事项',
  `MatchTime` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '开始时间',
  `Place` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '地点',
  `Number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '手机号码',
  `DocumentNumber` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '身份证号',
  `State` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '状态',
  `Account` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户账号',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_tb_match_items`(`Items` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '赛事活动信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_match
-- ----------------------------
INSERT INTO `tb_match` VALUES (1, '广州城市理工学院', '广州城市理工学院B1', '编程设计', '微信小程序大赛', '2023-05-01', '操场', '', '', 'Y', '');
INSERT INTO `tb_match` VALUES (2, '广州城市理工学院', '广州城市理工学院B1', '编程设计', 'ACM编程大赛', '2023-04-01', '操场', '', '', 'N', '');
INSERT INTO `tb_match` VALUES (3, '广州城市理工学院', '广州', '测试', '测试', '2001-01-01', 'b1', '123', '456', 'Y', '123456');
INSERT INTO `tb_match` VALUES (4, 'test', 'test', 'test', 'test', '2020-10-10', 'test', '1852221156', '4290052005566', 'Y', '123456');
INSERT INTO `tb_match` VALUES (5, '广州城市理工学院', '广州', '测试', '测试', '2001-01-01', 'b1', '123', '456', NULL, '123456');
INSERT INTO `tb_match` VALUES (6, '广州城市理工学院', '广州', '测试', '测试', '2001-01-01', 'b1', '123', '456', 'Y', '123456');
INSERT INTO `tb_match` VALUES (9, '广州城市理工学院', '广州', '测试', '测试', '2001-01-01', 'b1', '123', '456', NULL, 'user2');
INSERT INTO `tb_match` VALUES (11, '广州城市理工学院', '广州', '测试', '测试', '2023-6-28', 'b1', '123', '456', NULL, 'user2');
INSERT INTO `tb_match` VALUES (12, 'test14', '华南理工', 'test', 'match', '2023-06-08', 'test', '155', '1161561', 'Y', 'user2');
INSERT INTO `tb_match` VALUES (13, 'test', 'setet', 'set', 'test', '2023-06-30', 'test', 'setets', 'ste', NULL, 'admin1');
INSERT INTO `tb_match` VALUES (14, 'test', 'test', 'test', 'test', '2023-06-13', 'test', '15', '156156', NULL, 'admin1');

-- ----------------------------
-- Table structure for tb_notice
-- ----------------------------
DROP TABLE IF EXISTS `tb_notice`;
CREATE TABLE `tb_notice`  (
  `ID` int NOT NULL AUTO_INCREMENT COMMENT '通知编号',
  `Type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '通知类型',
  `Message` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '通知内容',
  `Time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '通知时间',
  `Sendto` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '发送对象',
  `UAccount` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户账号',
  `AAccount` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '管理员账号',
  `State` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'N' COMMENT '读取情况',
  PRIMARY KEY (`ID`) USING BTREE,
  INDEX `tb_notice_ibfk_1`(`UAccount` ASC) USING BTREE,
  INDEX `tb_notice_ibfk_2`(`AAccount` ASC) USING BTREE,
  CONSTRAINT `tb_notice_ibfk_1` FOREIGN KEY (`UAccount`) REFERENCES `tb_user` (`Account`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `tb_notice_ibfk_2` FOREIGN KEY (`AAccount`) REFERENCES `tb_admin` (`Account`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 168 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '通知表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_notice
-- ----------------------------
INSERT INTO `tb_notice` VALUES (6, '管理员角色替换', '您已被设定为管理员', '2023-05-30 02:02:00', '管理员', NULL, 'admin1', 'N');
INSERT INTO `tb_notice` VALUES (71, 'admin1个人信息更新', 'admin1管理员更新了您的个人信息。', '2023-06-24 16:51:10', '管理员', NULL, 'admin1', 'N');
INSERT INTO `tb_notice` VALUES (76, '111个人信息更新', '111管理员更新了您的个人信息。', '2023-06-24 17:22:44', '管理员', NULL, '111', 'N');
INSERT INTO `tb_notice` VALUES (77, '111个人信息更新', '111管理员更新了您的个人信息。', '2023-06-24 17:22:53', '管理员', NULL, '111', 'N');
INSERT INTO `tb_notice` VALUES (78, 'admin2实名验证成功', 'admin2您现在的身份是赞助商！', '2023-06-24 18:00:40', '赞助商', 'admin2', NULL, 'N');
INSERT INTO `tb_notice` VALUES (79, 'admin2实名验证成功', 'admin2您现在的身份是赞助商！', '2023-06-24 18:09:18', '赞助商', 'admin2', NULL, 'N');
INSERT INTO `tb_notice` VALUES (80, 'admin2实名验证成功', 'admin2您现在的身份是赞助商！', '2023-06-24 18:09:51', '赞助商', 'admin2', NULL, 'N');
INSERT INTO `tb_notice` VALUES (81, 'admin3实名验证成功', 'admin3您现在的身份是赞助商！', '2023-06-24 18:11:21', '赞助商', 'admin3', NULL, 'N');
INSERT INTO `tb_notice` VALUES (82, 'admin3实名验证成功', 'admin3您现在的身份是赞助商！', '2023-06-24 18:12:22', '赞助商', 'admin3', NULL, 'N');
INSERT INTO `tb_notice` VALUES (83, 'admin3实名验证成功', 'admin3您现在的身份是赞助商！', '2023-06-24 18:12:28', '赞助商', 'admin3', NULL, 'N');
INSERT INTO `tb_notice` VALUES (84, 'admin3实名验证成功', 'admin3您现在的身份是赞助商！', '2023-06-24 18:33:27', '赞助商', 'admin3', NULL, 'N');
INSERT INTO `tb_notice` VALUES (85, '2001-01-01,测试 赛事申请成功', '2001-01-01,测试 的赛事已经通过审核！', '2023-06-26 21:05:05', '主办方', 'user2', NULL, 'N');
INSERT INTO `tb_notice` VALUES (86, '2023-05-01,微信小程序大赛 赛事申请失败', '2023-05-01,微信小程序大赛 的的赛事审核未通过批准。', '2023-06-26 21:08:22', '主办方', 'user2', NULL, 'N');
INSERT INTO `tb_notice` VALUES (87, '2023-05-01,微信小程序大赛 赛事申请失败', '2023-05-01,微信小程序大赛 的的赛事审核未通过批准。', '2023-06-26 21:08:29', '主办方', 'user2', NULL, 'N');
INSERT INTO `tb_notice` VALUES (88, '2023-05-01,微信小程序大赛 赛事申请失败', '2023-05-01,微信小程序大赛 的的赛事审核未通过批准。', '2023-06-26 21:08:34', '主办方', 'user2', NULL, 'N');
INSERT INTO `tb_notice` VALUES (89, '2023-05-01,微信小程序大赛 赛事申请失败', '2023-05-01,微信小程序大赛 的的赛事审核未通过批准。', '2023-06-26 21:08:38', '主办方', 'user2', NULL, 'N');
INSERT INTO `tb_notice` VALUES (90, '2023-05-01,微信小程序大赛 赛事申请失败', '2023-05-01,微信小程序大赛 的的赛事审核未通过批准。', '2023-06-26 21:12:17', '主办方', 'user2', NULL, 'N');
INSERT INTO `tb_notice` VALUES (91, '2023-05-01,微信小程序大赛 赛事申请失败', '2023-05-01,微信小程序大赛 的的赛事审核未通过批准。', '2023-06-26 21:22:03', '主办方', 'user2', NULL, 'N');
INSERT INTO `tb_notice` VALUES (92, '2023-05-01,微信小程序大赛 赛事申请失败', '2023-05-01,微信小程序大赛 的的赛事审核未通过批准。', '2023-06-26 21:22:08', '主办方', 'user2', NULL, 'N');
INSERT INTO `tb_notice` VALUES (93, '2023-05-01,微信小程序大赛 赛事申请失败', '2023-05-01,微信小程序大赛 的的赛事审核未通过批准。', '2023-06-26 21:24:28', '主办方', 'user2', NULL, 'N');
INSERT INTO `tb_notice` VALUES (94, '2023-05-01,微信小程序大赛 赛事申请失败', '2023-05-01,微信小程序大赛 的的赛事审核未通过批准。', '2023-06-26 21:24:32', '主办方', 'user2', NULL, 'N');
INSERT INTO `tb_notice` VALUES (95, '2023-05-01,微信小程序大赛 赛事申请失败', '2023-05-01,微信小程序大赛 的的赛事审核未通过批准。', '2023-06-26 21:24:39', '主办方', 'user2', NULL, 'N');
INSERT INTO `tb_notice` VALUES (96, '2023-05-01,微信小程序大赛 赛事申请失败', '2023-05-01,微信小程序大赛 的的赛事审核未通过批准。', '2023-06-26 21:25:23', '主办方', 'user2', NULL, 'N');
INSERT INTO `tb_notice` VALUES (97, '2023-05-01,微信小程序大赛 赛事申请失败', '2023-05-01,微信小程序大赛 的的赛事审核未通过批准。', '2023-06-26 21:25:26', '主办方', 'user2', NULL, 'N');
INSERT INTO `tb_notice` VALUES (98, '2023-04-01,ACM编程大赛 赛事申请失败', '2023-04-01,ACM编程大赛 的的赛事审核未通过批准。', '2023-06-26 21:29:29', '主办方', 'user2', NULL, 'N');
INSERT INTO `tb_notice` VALUES (99, '2020-10-10,test 赛事申请失败', '2020-10-10,test 的的赛事审核未通过批准。', '2023-06-26 21:29:42', '主办方', 'user2', NULL, 'N');
INSERT INTO `tb_notice` VALUES (100, '2001-01-01,测试 赛事申请成功', '2001-01-01,测试 的赛事已经通过审核！', '2023-06-26 21:31:40', '主办方', 'user2', NULL, 'N');
INSERT INTO `tb_notice` VALUES (101, '2020-10-10,test 赛事申请成功', '2020-10-10,test 的赛事已经通过审核！', '2023-06-26 21:31:47', '主办方', 'user2', NULL, 'N');
INSERT INTO `tb_notice` VALUES (102, '2023-05-01,微信小程序大赛 赛事申请成功', '2023-05-01,微信小程序大赛 的赛事已经通过审核！', '2023-06-26 21:32:48', '主办方', 'user2', NULL, 'N');
INSERT INTO `tb_notice` VALUES (103, '2023-05-01,微信小程序大赛 赛事申请成功', '2023-05-01,微信小程序大赛 的赛事已经通过审核！', '2023-06-26 21:33:03', '主办方', 'user2', NULL, 'N');
INSERT INTO `tb_notice` VALUES (104, '2001-01-01,测试 发起赛事申请', '2001-01-01,测试 的审核提交成功！', '2023-06-27 20:45:40', '主办方', 'user2', NULL, 'N');
INSERT INTO `tb_notice` VALUES (105, '2023-06-07,tes 发起赛事申请', '2023-06-07,tes 的审核提交成功！', '2023-06-27 20:48:02', '主办方', 'user2', NULL, 'N');
INSERT INTO `tb_notice` VALUES (106, 'admin3实名验证成功', 'admin3您现在的身份是赞助商！', '2023-06-27 20:50:28', '赞助商', 'admin3', NULL, 'N');
INSERT INTO `tb_notice` VALUES (107, 'admin3实名验证成功', 'admin3您现在的身份是赞助商！', '2023-06-27 20:50:35', '赞助商', 'admin3', NULL, 'N');
INSERT INTO `tb_notice` VALUES (108, 'admin3实名验证成功', 'admin3您现在的身份是赞助商！', '2023-06-27 20:53:01', '赞助商', 'admin3', NULL, 'N');
INSERT INTO `tb_notice` VALUES (109, 'admin3实名验证成功', 'admin3您现在的身份是赞助商！', '2023-06-27 20:53:14', '赞助商', 'admin3', NULL, 'N');
INSERT INTO `tb_notice` VALUES (110, 'admin3实名验证成功', 'admin3您现在的身份是赞助商！', '2023-06-27 20:53:26', '赞助商', 'admin3', NULL, 'N');
INSERT INTO `tb_notice` VALUES (111, 'admin3实名验证成功', 'admin3您现在的身份是赞助商！', '2023-06-27 20:53:35', '赞助商', 'admin3', NULL, 'N');
INSERT INTO `tb_notice` VALUES (112, 'admin3实名验证成功', 'admin3您现在的身份是赞助商！', '2023-06-27 20:53:39', '赞助商', 'admin3', NULL, 'N');
INSERT INTO `tb_notice` VALUES (113, 'admin3实名验证成功', 'admin3您现在的身份是赞助商！', '2023-06-27 20:53:42', '赞助商', 'admin3', NULL, 'N');
INSERT INTO `tb_notice` VALUES (114, 'admin3实名验证成功', 'admin3您现在的身份是赞助商！', '2023-06-27 20:53:43', '赞助商', 'admin3', NULL, 'N');
INSERT INTO `tb_notice` VALUES (115, 'admin3实名验证成功', 'admin3您现在的身份是赞助商！', '2023-06-27 20:53:45', '赞助商', 'admin3', NULL, 'N');
INSERT INTO `tb_notice` VALUES (116, 'admin3实名验证成功', 'admin3您现在的身份是赞助商！', '2023-06-27 20:55:28', '赞助商', 'admin3', NULL, 'N');
INSERT INTO `tb_notice` VALUES (117, 'admin3个人信息更新', 'admin3管理员更新了您的个人信息。', '2023-06-27 21:39:12', '赞助商', 'admin3', NULL, 'N');
INSERT INTO `tb_notice` VALUES (118, 'admin3个人信息更新', 'admin3管理员更新了您的个人信息。', '2023-06-27 21:39:16', '赞助商', 'admin3', NULL, 'N');
INSERT INTO `tb_notice` VALUES (119, 'admin2个人信息更新', 'admin2管理员更新了您的个人信息。', '2023-06-28 20:00:58', '赞助商', 'admin2', NULL, 'N');
INSERT INTO `tb_notice` VALUES (120, 'admin2个人信息更新', 'admin2管理员更新了您的个人信息。', '2023-06-28 20:01:58', '赞助商', 'admin2', NULL, 'N');
INSERT INTO `tb_notice` VALUES (121, '111个人信息更新', '111管理员更新了您的个人信息。', '2023-06-28 20:02:49', '管理员', NULL, '111', 'N');
INSERT INTO `tb_notice` VALUES (122, '2023-6-28,测试 发起赛事申请', '2023-6-28,测试 的审核提交成功！', '2023-06-28 20:08:04', '主办方', 'user2', NULL, 'N');
INSERT INTO `tb_notice` VALUES (123, 'null个人信息更新', 'null管理员更新了您的个人信息。', '2023-06-28 20:47:40', '赞助商', NULL, NULL, 'N');
INSERT INTO `tb_notice` VALUES (124, 'null个人信息更新', 'null管理员更新了您的个人信息。', '2023-06-28 20:47:49', '赞助商', NULL, NULL, 'N');
INSERT INTO `tb_notice` VALUES (125, '111个人信息更新', '111管理员更新了您的个人信息。', '2023-06-28 20:50:43', '管理员', NULL, '111', 'N');
INSERT INTO `tb_notice` VALUES (126, '111个人信息更新', '111管理员更新了您的个人信息。', '2023-06-28 20:51:44', '管理员', NULL, '111', 'N');
INSERT INTO `tb_notice` VALUES (127, '111个人信息更新', '111管理员更新了您的个人信息。', '2023-06-28 20:52:03', '管理员', NULL, '111', 'N');
INSERT INTO `tb_notice` VALUES (128, '111个人信息更新', '111管理员更新了您的个人信息。', '2023-06-28 20:52:11', '管理员', NULL, '111', 'N');
INSERT INTO `tb_notice` VALUES (129, '2023-06-08,match 发起赛事申请', '2023-06-08,match 的审核提交成功！', '2023-06-28 21:02:02', '主办方', 'user2', NULL, 'N');
INSERT INTO `tb_notice` VALUES (130, '111个人信息更新', '111管理员更新了您的个人信息。', '2023-06-28 21:04:29', '管理员', NULL, '111', 'N');
INSERT INTO `tb_notice` VALUES (131, '2023-06-08,match 赛事申请成功', '2023-06-08,match 的赛事已经通过审核！', '2023-06-28 21:12:47', '主办方', 'user2', NULL, 'N');
INSERT INTO `tb_notice` VALUES (132, 'user100实名验证成功', 'user100您现在的身份是赞助商！', '2023-06-28 21:27:15', '赞助商', 'user100', NULL, 'N');
INSERT INTO `tb_notice` VALUES (133, '2023-06-08,match 赛事申请成功', '2023-06-08,match 的赛事已经通过审核！', '2023-06-28 21:30:05', '主办方', 'user2', NULL, 'N');
INSERT INTO `tb_notice` VALUES (134, 'user100实名验证成功', 'user100您现在的身份是赞助商！', '2023-06-28 21:34:37', '赞助商', 'user100', NULL, 'N');
INSERT INTO `tb_notice` VALUES (135, 'user100实名验证成功', 'user100您现在的身份是赞助商！', '2023-06-28 21:34:43', '赞助商', 'user100', NULL, 'N');
INSERT INTO `tb_notice` VALUES (136, 'user100实名验证成功', 'user100您现在的身份是赞助商！', '2023-06-28 21:34:55', '赞助商', 'user100', NULL, 'N');
INSERT INTO `tb_notice` VALUES (137, 'user100实名验证成功', 'user100您现在的身份是赞助商！', '2023-06-28 21:58:32', '赞助商', 'user100', NULL, 'N');
INSERT INTO `tb_notice` VALUES (138, 'user123发起实名验证', 'user123审核提交成功！', '2023-06-29 16:19:31', '主办方', 'user123', NULL, 'N');
INSERT INTO `tb_notice` VALUES (139, 'user123实名验证成功', 'user123您现在的身份是主办方！', '2023-06-29 16:21:25', '主办方', 'user123', NULL, 'N');
INSERT INTO `tb_notice` VALUES (140, 'user99发起实名验证', 'user99审核提交成功！', '2023-06-29 20:45:53', '赞助商', 'user99', NULL, 'N');
INSERT INTO `tb_notice` VALUES (141, 'user99实名验证成功', 'user99您现在的身份是赞助商！', '2023-06-29 21:01:57', '赞助商', 'user99', NULL, 'N');
INSERT INTO `tb_notice` VALUES (142, 'user99实名验证成功', 'user99您现在的身份是赞助商！', '2023-06-29 21:10:41', '赞助商', 'user99', NULL, 'N');
INSERT INTO `tb_notice` VALUES (143, 'user99实名验证成功', 'user99您现在的身份是赞助商！', '2023-06-29 21:12:16', '赞助商', 'user99', NULL, 'N');
INSERT INTO `tb_notice` VALUES (144, 'user99实名验证成功', 'user99您现在的身份是赞助商！', '2023-06-29 21:12:31', '赞助商', 'user99', NULL, 'N');
INSERT INTO `tb_notice` VALUES (145, 'admin2实名验证成功', 'admin2您现在的身份是赞助商！', '2023-06-29 21:51:25', '赞助商', 'admin2', NULL, 'N');
INSERT INTO `tb_notice` VALUES (146, 'admin1个人信息更新', 'admin1管理员更新了您的个人信息。', '2023-06-29 22:22:00', '管理员', NULL, 'admin1', 'N');
INSERT INTO `tb_notice` VALUES (147, 'admin1个人信息更新', 'admin1管理员更新了您的个人信息。', '2023-06-29 22:29:30', '管理员', NULL, 'admin1', 'N');
INSERT INTO `tb_notice` VALUES (149, '赞助商修改广告信息申请', '广告内容为：广告ID:null,赞助商:test1,广告类型:test,视频地址:null,图片地址:test,审核状态:test,赛事项目:null,赛事id:1', '2023-06-30 18:00:56', '超级管理员', NULL, NULL, '');
INSERT INTO `tb_notice` VALUES (150, '赞助商修改广告信息申请', '广告内容为：广告ID:null,赞助商:test1,广告类型:test,视频地址:null,图片地址:test,审核状态:test,赛事项目:null,赛事id:1', '2023-06-30 18:00:56', '管理员', NULL, NULL, '');
INSERT INTO `tb_notice` VALUES (151, '赞助商修改广告信息申请', '广告内容为：广告ID:null,赞助商:test1,广告类型:test,视频地址:null,图片地址:test,审核状态:test,赛事项目:null,赛事id:1', '2023-06-30 18:00:56', '赞助商', NULL, NULL, '');
INSERT INTO `tb_notice` VALUES (152, '赞助商修改广告信息申请', '广告内容为：广告ID:null,赞助商:test2,广告类型:test,视频地址:null,图片地址:test,审核状态:test,赛事项目:null,赛事id:1', '2023-06-30 18:01:11', '超级管理员', NULL, NULL, '');
INSERT INTO `tb_notice` VALUES (153, '赞助商修改广告信息申请', '广告内容为：广告ID:null,赞助商:test2,广告类型:test,视频地址:null,图片地址:test,审核状态:test,赛事项目:null,赛事id:1', '2023-06-30 18:01:11', '管理员', NULL, NULL, '');
INSERT INTO `tb_notice` VALUES (154, '赞助商修改广告信息申请', '广告内容为：广告ID:null,赞助商:test2,广告类型:test,视频地址:null,图片地址:test,审核状态:test,赛事项目:null,赛事id:1', '2023-06-30 18:01:11', '赞助商', NULL, NULL, '');
INSERT INTO `tb_notice` VALUES (156, '赞助商修改广告信息申请', '广告内容为：广告ID:null,赞助商:test3,广告类型:test,视频地址:null,图片地址:test,审核状态:test,赛事项目:null,赛事id:1', '2023-06-30 18:06:50', '超级管理员', NULL, NULL, '');
INSERT INTO `tb_notice` VALUES (157, '赞助商修改广告信息申请', '广告内容为：广告ID:null,赞助商:test3,广告类型:test,视频地址:null,图片地址:test,审核状态:test,赛事项目:null,赛事id:1', '2023-06-30 18:06:50', '管理员', NULL, NULL, '');
INSERT INTO `tb_notice` VALUES (158, '赞助商修改广告信息申请', '广告内容为：广告ID:null,赞助商:test3,广告类型:test,视频地址:null,图片地址:test,审核状态:test,赛事项目:null,赛事id:1', '2023-06-30 18:06:50', '赞助商', NULL, NULL, '');
INSERT INTO `tb_notice` VALUES (159, '赞助商修改广告信息申请', '广告内容为：广告ID:null,赞助商:test3,广告类型:test1,视频地址:null,图片地址:test1,审核状态:test1,赛事项目:null,赛事id:1', '2023-06-30 18:12:01', '超级管理员', NULL, NULL, '');
INSERT INTO `tb_notice` VALUES (160, '赞助商修改广告信息申请', '广告内容为：广告ID:null,赞助商:test3,广告类型:test1,视频地址:null,图片地址:test1,审核状态:test1,赛事项目:null,赛事id:1', '2023-06-30 18:12:01', '管理员', NULL, NULL, '');
INSERT INTO `tb_notice` VALUES (161, '赞助商修改广告信息申请', '广告内容为：广告ID:null,赞助商:test3,广告类型:test1,视频地址:null,图片地址:test1,审核状态:test1,赛事项目:null,赛事id:1', '2023-06-30 18:12:01', '赞助商', NULL, NULL, '');
INSERT INTO `tb_notice` VALUES (162, '赞助商修改广告信息申请', '广告内容为：广告ID:null,赞助商:test1,广告类型:test,视频地址:null,图片地址:test,审核状态:test,赛事项目:null,赛事id:1', '2023-06-30 18:17:13', '超级管理员', NULL, NULL, '');
INSERT INTO `tb_notice` VALUES (163, '赞助商修改广告信息申请', '广告内容为：广告ID:null,赞助商:test1,广告类型:test,视频地址:null,图片地址:test,审核状态:test,赛事项目:null,赛事id:1', '2023-06-30 18:17:13', '管理员', NULL, NULL, '');
INSERT INTO `tb_notice` VALUES (164, '赞助商修改广告信息申请', '广告内容为：广告ID:null,赞助商:test1,广告类型:test,视频地址:null,图片地址:test,审核状态:test,赛事项目:null,赛事id:1', '2023-06-30 18:17:13', '赞助商', NULL, NULL, '');
INSERT INTO `tb_notice` VALUES (165, '赞助商修改广告信息申请', '广告内容为：广告ID:null,赞助商:test12,广告类型:test1,视频地址:null,图片地址:test1,审核状态:test1,赛事项目:null,赛事id:1', '2023-06-30 18:17:24', '超级管理员', NULL, NULL, '');
INSERT INTO `tb_notice` VALUES (166, '赞助商修改广告信息申请', '广告内容为：广告ID:null,赞助商:test12,广告类型:test1,视频地址:null,图片地址:test1,审核状态:test1,赛事项目:null,赛事id:1', '2023-06-30 18:17:24', '管理员', NULL, NULL, '');
INSERT INTO `tb_notice` VALUES (167, '赞助商修改广告信息申请', '广告内容为：广告ID:null,赞助商:test12,广告类型:test1,视频地址:null,图片地址:test1,审核状态:test1,赛事项目:null,赛事id:1', '2023-06-30 18:17:24', '赞助商', NULL, NULL, '');

-- ----------------------------
-- Table structure for tb_player
-- ----------------------------
DROP TABLE IF EXISTS `tb_player`;
CREATE TABLE `tb_player`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '编号',
  `headshot` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '头像',
  `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '无' COMMENT '昵称',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '真实姓名',
  `school` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sex` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `phone` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `age` int NOT NULL,
  `origin` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '无',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `MatchID`(`headshot` ASC) USING BTREE,
  CONSTRAINT `tb_player_ibfk_2` FOREIGN KEY (`id`) REFERENCES `tb_user` (`ID`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '参赛者表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_player
-- ----------------------------
INSERT INTO `tb_player` VALUES (1, '12', '无', '123', '123', '13', '123', '132', 13, '无');
INSERT INTO `tb_player` VALUES (2, '12', '无', '123', '123', '13', '123', '132', 13, '无');

-- ----------------------------
-- Table structure for tb_player2
-- ----------------------------
DROP TABLE IF EXISTS `tb_player2`;
CREATE TABLE `tb_player2`  (
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `school` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `items` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `position` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `state` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_player2
-- ----------------------------
INSERT INTO `tb_player2` VALUES ('李华', '男', 1, '广州城市理工学院', '编程设计', '微信小程序大赛', '2022-5-23', '学生活动中心', '1', '已结束');
INSERT INTO `tb_player2` VALUES ('李华', '男', 2, '广州城市理工学院', '编程设计', 'ACM编程大赛', '2022-5-23', 'A9', '3', '已结束');
INSERT INTO `tb_player2` VALUES ('李华', '女', 3, '广州城市理工学院', '编程设计', 'JAVA编程大赛', '2022-5-23', '学生活动中心', '1', '已结束');

-- ----------------------------
-- Table structure for tb_prize
-- ----------------------------
DROP TABLE IF EXISTS `tb_prize`;
CREATE TABLE `tb_prize`  (
  `id` int NOT NULL COMMENT '奖品id，唯一，主键',
  `Sponsorshipfeeds` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '赞助源',
  `Sponsorshipgoals` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '赞助目标',
  `activityname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '所属活动，外键',
  `level` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '级别',
  `state` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '审核状态',
  `raceID` int NULL DEFAULT NULL COMMENT '赛事活动id，外键',
  `details` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '奖品信息文字描述',
  `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '奖品信息图片描述',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `raceID`(`raceID` ASC) USING BTREE,
  INDEX `activityname`(`activityname` ASC) USING BTREE,
  CONSTRAINT `activityname` FOREIGN KEY (`activityname`) REFERENCES `tb_match` (`Items`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `raceID` FOREIGN KEY (`raceID`) REFERENCES `tb_match` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_prize
-- ----------------------------
INSERT INTO `tb_prize` VALUES (0, '略', '略', '微信小程序大赛', '略', '略', 1, '略', '略');
INSERT INTO `tb_prize` VALUES (1, 'test2', 'test2', '微信小程序大赛', '一等奖', 'test2', 1, 'test2', 'test2');

-- ----------------------------
-- Table structure for tb_spadmin
-- ----------------------------
DROP TABLE IF EXISTS `tb_spadmin`;
CREATE TABLE `tb_spadmin`  (
  `ID` int NOT NULL AUTO_INCREMENT COMMENT '编号',
  `SPAdminName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '超级管理员姓名',
  `Account` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '账号',
  `Password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `OldType` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '原账号类型',
  `UserType` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '新账号类型',
  PRIMARY KEY (`ID`) USING BTREE,
  INDEX `spadmin_account`(`Account` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '超级管理员表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_spadmin
-- ----------------------------
INSERT INTO `tb_spadmin` VALUES (1, '王五', 'spadmin1', '123', '管理员', '超级管理员');
INSERT INTO `tb_spadmin` VALUES (2, '更改后', 'spadmin3', '123', '管理员', '超级管理员');
INSERT INTO `tb_spadmin` VALUES (3, 'test', 'spadmin4', '123', '管理员', '超级管理员');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `UserName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名字',
  `Sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '性别',
  `ID` int NOT NULL AUTO_INCREMENT COMMENT '编号',
  `Unit` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '广州城市理工学院' COMMENT '单位',
  `Address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '地址',
  `Age` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '年龄',
  `Number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `Account` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户账号',
  `Password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户密码',
  `Origin` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '籍贯',
  `UserType` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '主办方' COMMENT '用户类型',
  `State` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'Y' COMMENT '状态',
  `Nation` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '民族',
  `birthday` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '出生年月',
  `DocumentType` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '证件类型',
  `DocumentNumber` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '证件号码',
  `MAddress` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '通讯地址',
  PRIMARY KEY (`ID`, `Account`) USING BTREE,
  INDEX `user_account`(`Account` ASC) USING BTREE,
  INDEX `ID`(`ID` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 86 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('小明', '男', 1, '广州城市理工学院', '广东省广州市天河区', '23', '13800001111', 'user1', '123', '广东省', '赞助商', 'Y', '汉', NULL, '', '', '');
INSERT INTO `tb_user` VALUES ('小红', '女', 2, '广州城市理工学院', '广东省广州市番禺区', '22', '13800002222', 'user2', '123', '广东省', '主办方', 'N', '汉', NULL, '', '', '');
INSERT INTO `tb_user` VALUES ('小红', '女', 67, '广州城市理工学院', '广东省广州市番禺区', '22', '13800002222', 'user3', '123', '广东省', '主办方', 'N', '汉', NULL, '测试', '测试', '测试');
INSERT INTO `tb_user` VALUES ('小明', '男', 68, '广州城市理工学院', '广东省广州市天河区', '23', '13800001111', 'user5', '123', '广东省', '赞助商', 'Y', '汉', NULL, '', '', '');
INSERT INTO `tb_user` VALUES ('小红', '女', 69, '广州城市理工学院', '广东省广州市番禺区', '22', '13800002222', 'user6', '123', '广东省', '主办方', 'N', '汉', NULL, '', '', '');
INSERT INTO `tb_user` VALUES ('小红', '女', 70, '广州城市理工学院', '广东省广州市番禺区', '22', '13800002222', 'user7', '123', '广东省', '主办方', 'N', '汉', NULL, '测试', '测试', '测试');
INSERT INTO `tb_user` VALUES ('小明', '男', 71, '广州城市理工学院', '广东省广州市天河区', '23', '13800001111', 'user8', '123', '广东省', '赞助商', 'Y', '汉', NULL, '', '', '');
INSERT INTO `tb_user` VALUES ('小红', '女', 72, '广州城市理工学院', '广东省广州市番禺区', '22', '13800002222', 'user9', '123', '广东省', '主办方', 'N', '汉', NULL, '', '', '');
INSERT INTO `tb_user` VALUES ('小红', '女', 73, '广州城市理工学院', '广东省广州市番禺区', '22', '13800002222', 'user10', '123', '广东省', '主办方', 'N', '汉', NULL, '测试', '测试', '测试');
INSERT INTO `tb_user` VALUES ('小红', '女', 75, '广州城市理工学院', '广东省广州市番禺区', '22', '13800002222', 'user12', '123', '广东省', '主办方', 'N', '汉', NULL, '', '', '');
INSERT INTO `tb_user` VALUES ('小红', '女', 76, '广州城市理工学院', '广东省广州市番禺区', '22', '13800002222', 'user13', '123', '广东省', '主办方', 'N', '汉', NULL, '测试', '测试', '测试');
INSERT INTO `tb_user` VALUES ('小明', '男', 77, '广州城市理工学院', '广东省广州市天河区', '23', '13800001111', 'user14', '123', '广东省', '赞助商', 'Y', '汉', NULL, '', '', '');
INSERT INTO `tb_user` VALUES ('小红', '女', 78, '广州城市理工学院', '广东省广州市番禺区', '22', '13800002222', 'user15', '123', '广东省', '主办方', 'N', '汉', NULL, '', '', '');
INSERT INTO `tb_user` VALUES ('小红', '女', 79, '广州城市理工学院', '广东省广州市番禺区', '22', '13800002222', 'user16', '123', '广东省', '主办方', 'N', '汉', NULL, '测试', '测试', '测试');
INSERT INTO `tb_user` VALUES ('游客注册', '男', 81, '广州城市理工学院', NULL, NULL, '1852221156', 'admin2', '123', '广东省', '赞助商', 'Y', '汉族', '2020-10-10', '居民身份证', '4290052005566', '通讯地址');
INSERT INTO `tb_user` VALUES ('111', 'sss', 82, 'test', 'test', '555', '555', 'admin3', '123', 'test', '赞助商', 'Y', '汉族', '2020-10-10', '居民身份证', '4290052005566', '通讯地址');
INSERT INTO `tb_user` VALUES ('游客注册', '男', 83, '广州城市理工学院', NULL, NULL, '1852221156', 'user100', '123', '广东省', '赞助商', 'Y', '汉族', '2020-10-10', '居民身份证', '4290052005566', '通讯地址');
INSERT INTO `tb_user` VALUES ('游客测试', '男', 84, '广州城市理工学院', NULL, NULL, '12312312312', 'user123', '123', '广东省', '主办方', 'Y', '汉', '2002/03/15', '居民身份证', '123123', '通讯地址');
INSERT INTO `tb_user` VALUES ('tets', '男', 85, 'tet', NULL, NULL, '1851651', 'user99', '123', 'han', '赞助商', 'Y', 'han', '2023-06-06', '中国大陆居民身份证', '15615616', 'test');

-- ----------------------------
-- Table structure for tb_vetting
-- ----------------------------
DROP TABLE IF EXISTS `tb_vetting`;
CREATE TABLE `tb_vetting`  (
  `ID` int NOT NULL AUTO_INCREMENT COMMENT '审核编号',
  `Type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '审核类型',
  `Message` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '审核内容',
  `Time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '发送时间',
  `Sendto` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '发送对象',
  `Account` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户账号',
  `Matchid` int NULL DEFAULT NULL COMMENT '比赛表id',
  `State` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '读取情况',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 40 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '审核表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_vetting
-- ----------------------------
INSERT INTO `tb_vetting` VALUES (1, '游客注册的实名验证申请', '游客注册申请成为赞助商', '2023-05-30 02:02:00', '管理员', '', NULL, 'Y');
INSERT INTO `tb_vetting` VALUES (2, '游客注册的实名验证申请', '游客注册申请成为赞助商', '2023-05-30 02:02:00', '超级管理员', '', NULL, 'N');
INSERT INTO `tb_vetting` VALUES (3, 'vis1的实名验证申请', 'vis1申请成为赞助商', '2023-05-30 02:02:00', '管理员', 'vis1', NULL, 'Y');
INSERT INTO `tb_vetting` VALUES (4, 'vis4的实名验证申请', 'vis4申请成为赞助商', '2023-06-04 09:05:52', '管理员', 'vis4', NULL, NULL);
INSERT INTO `tb_vetting` VALUES (5, 'vis4的实名验证申请', 'vis4申请成为赞助商', '2023-06-04 09:05:52', '超级管理员', 'vis4', NULL, NULL);
INSERT INTO `tb_vetting` VALUES (6, 'vis5的实名验证申请', 'vis5申请成为赞助商', '2023-06-04 09:17:14', '管理员', 'vis5', NULL, NULL);
INSERT INTO `tb_vetting` VALUES (7, 'vis5的实名验证申请', 'vis5申请成为赞助商', '2023-06-04 09:17:14', '超级管理员', 'vis5', NULL, 'Y');
INSERT INTO `tb_vetting` VALUES (8, 'user2的2001-01-01的测试的赛事申请', 'user2的2001-01-01的测试的赛事申请', '2023-06-06 01:08:55', '管理员', 'user2', 7, 'Y');
INSERT INTO `tb_vetting` VALUES (9, 'user2的2001-01-01的测试的赛事申请', 'user2的2001-01-01的测试的赛事申请', '2023-06-06 01:08:55', '超级管理员', 'user2', 7, 'Y');
INSERT INTO `tb_vetting` VALUES (10, 'user2 2001-01-01 测试的赛事申请', 'user2 2001-01-01 测试的赛事申请', '2023-06-06 01:12:04', '管理员', 'user2', 8, 'Y');
INSERT INTO `tb_vetting` VALUES (11, 'user2 2001-01-01 测试的赛事申请', 'user2 2001-01-01 测试的赛事申请', '2023-06-06 01:12:04', '超级管理员', 'user2', 8, 'Y');
INSERT INTO `tb_vetting` VALUES (22, 'admin2的实名验证申请', 'admin2申请成为赞助商', '2023-06-24 18:00:40', '管理员', 'admin2', NULL, 'Y');
INSERT INTO `tb_vetting` VALUES (23, 'admin2的实名验证申请', 'admin2申请成为赞助商', '2023-06-24 18:00:40', '超级管理员', 'admin2', NULL, NULL);
INSERT INTO `tb_vetting` VALUES (24, 'admin3的实名验证申请', 'admin3申请成为赞助商', '2023-06-24 18:11:21', '管理员', 'admin3', NULL, 'Y');
INSERT INTO `tb_vetting` VALUES (25, 'admin3的实名验证申请', 'admin3申请成为赞助商', '2023-06-24 18:11:21', '超级管理员', 'admin3', NULL, NULL);
INSERT INTO `tb_vetting` VALUES (26, 'user2,2001-01-01,测试 的赛事申请', 'user2,2001-01-01,测试 的赛事申请', '2023-06-27 20:45:40', '管理员', 'user2', 9, NULL);
INSERT INTO `tb_vetting` VALUES (27, 'user2,2001-01-01,测试 的赛事申请', 'user2,2001-01-01,测试 的赛事申请', '2023-06-27 20:45:40', '超级管理员', 'user2', 9, NULL);
INSERT INTO `tb_vetting` VALUES (28, 'user2,2023-06-07,tes 的赛事申请', 'user2,2023-06-07,tes 的赛事申请', '2023-06-27 20:48:02', '管理员', 'user2', 10, NULL);
INSERT INTO `tb_vetting` VALUES (29, 'user2,2023-06-07,tes 的赛事申请', 'user2,2023-06-07,tes 的赛事申请', '2023-06-27 20:48:02', '超级管理员', 'user2', 10, NULL);
INSERT INTO `tb_vetting` VALUES (30, 'user2的赛事申请', 'user2,2023-6-28,测试 的赛事申请', '2023-06-28 20:08:04', '管理员', 'user2', 11, NULL);
INSERT INTO `tb_vetting` VALUES (31, 'user2的赛事申请', 'user2,2023-6-28,测试 的赛事申请', '2023-06-28 20:08:04', '超级管理员', 'user2', 11, NULL);
INSERT INTO `tb_vetting` VALUES (32, 'user2的赛事申请', 'user2,2023-06-08,match 的赛事申请', '2023-06-28 21:02:02', '管理员', 'user2', 12, 'Y');
INSERT INTO `tb_vetting` VALUES (33, 'user2的赛事申请', 'user2,2023-06-08,match 的赛事申请', '2023-06-28 21:02:02', '超级管理员', 'user2', 12, 'Y');
INSERT INTO `tb_vetting` VALUES (34, 'user100的实名验证申请', 'user100申请成为赞助商', '2023-06-28 21:27:15', '管理员', 'user100', NULL, 'Y');
INSERT INTO `tb_vetting` VALUES (35, 'user100的实名验证申请', 'user100申请成为赞助商', '2023-06-28 21:27:15', '超级管理员', 'user100', NULL, NULL);
INSERT INTO `tb_vetting` VALUES (36, 'user123的实名验证申请', 'user123申请成为主办方', '2023-06-29 16:19:31', '管理员', 'user123', NULL, 'Y');
INSERT INTO `tb_vetting` VALUES (37, 'user123的实名验证申请', 'user123申请成为主办方', '2023-06-29 16:19:31', '超级管理员', 'user123', NULL, NULL);
INSERT INTO `tb_vetting` VALUES (38, 'user99的实名验证申请', 'user99申请成为赞助商', '2023-06-29 20:45:53', '管理员', 'user99', NULL, 'Y');
INSERT INTO `tb_vetting` VALUES (39, 'user99的实名验证申请', 'user99申请成为赞助商', '2023-06-29 20:45:53', '超级管理员', 'user99', NULL, NULL);

-- ----------------------------
-- Table structure for tb_visitor
-- ----------------------------
DROP TABLE IF EXISTS `tb_visitor`;
CREATE TABLE `tb_visitor`  (
  `ID` int NOT NULL AUTO_INCREMENT COMMENT '编号',
  `UserName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名称',
  `Account` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户账号',
  `Password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户密码',
  `UserType` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '_utf8mb4\\\'æ¸¸å®¢\\\'' COMMENT '用户类型',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '游客表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_visitor
-- ----------------------------
INSERT INTO `tb_visitor` VALUES (6, 'admin4', 'admin4', '123', '游客');
INSERT INTO `tb_visitor` VALUES (9, '游客测试', 'user125', '123', '游客');
INSERT INTO `tb_visitor` VALUES (10, '游客测试', 'user126', '123', '游客');
INSERT INTO `tb_visitor` VALUES (11, '游客测试', 'user127', '123', '游客');
INSERT INTO `tb_visitor` VALUES (13, 'user66', 'user66', '123', '游客');

SET FOREIGN_KEY_CHECKS = 1;
