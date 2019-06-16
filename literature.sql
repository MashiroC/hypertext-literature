/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : localhost:3306
 Source Schema         : literature

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 16/06/2019 11:27:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for fiction
-- ----------------------------
DROP TABLE IF EXISTS `fiction`;
CREATE TABLE `fiction`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `author_id` int(11) NOT NULL,
  `created_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `state` tinyint(4) NOT NULL DEFAULT 1,
  `prologue_id` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of fiction
-- ----------------------------
INSERT INTO `fiction` VALUES (1, '男更衣室', 1, '2019-06-07 12:05:32', 1, 1);
INSERT INTO `fiction` VALUES (2, '游戏评测', 1, '2019-06-14 09:11:17', 1, 5);

-- ----------------------------
-- Table structure for slice
-- ----------------------------
DROP TABLE IF EXISTS `slice`;
CREATE TABLE `slice`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `author_id` int(11) NOT NULL,
  `fiction_id` int(11) NOT NULL,
  `title` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `text` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `created_at` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of slice
-- ----------------------------
INSERT INTO `slice` VALUES (1, 1, 1, '男更衣室', '只有红茶可以吗', '2019-06-07 12:05:32');
INSERT INTO `slice` VALUES (2, 1, 1, '♂', '看起来很结实呢，平时有在健身什么的吗？', '2019-06-07 12:19:11');
INSERT INTO `slice` VALUES (3, 1, 1, '♂', '看起来很结实呢，平时有在健身什么的吗？', '2019-06-07 12:19:55');
INSERT INTO `slice` VALUES (4, 1, 1, '♂', '看起来很结实呢，平时有在健身什么的吗？', '2019-06-14 15:03:18');
INSERT INTO `slice` VALUES (5, 1, 2, '游戏评测', '这是一些游戏评测', '2019-06-14 09:12:25');
INSERT INTO `slice` VALUES (6, 1, 2, '只狼评测', '> 最近用了一周多的时间打完了《只狼》，之前就想写一篇评测，今天周末刚好有一些时间把它写完，在正文开始前我想再次强调一次：这篇评测是我个人作为玩家的感受，每个人喜欢的游戏口味不同，每个人玩游戏的方式也不同，所以这篇文章不可能满足所有玩家的观点，如果你同意那我们可以深入讨论，如果你不认同的地方也请包容。\r\n\r\n> PS：未经同意请不要转载。有一些地方使用英文是因为英文是最精确的原意，有精确中文的翻译我会在后面用括号加入中文翻译，没有加的地方是因为我个人认为没有准确的中文翻译或者不了解准确的中文翻译是什么。\r\n\r\n我先简单介绍一下我玩的过程：一共用了36小时左右通关了主线，战斗基本全部硬刚，除了加血之外没有用过任何辅助道具，有时使用义手武器和辅助招式，也有很多支线没有全部做完，所以肯定对游戏一些方面了解的不深入，如果有不精确的地方也请包容和指证，正文开始。\r\n\r\n\r\n\r\n首先我个人给《只狼》的打分在87分，当然这是个人分数了，没有上90的原因其实在文章标题就说的很清晰了，《只狼》是一款资源有限的3A动作游戏大作，总体来说优点非常明显，缺点也有一些，但是优点大于缺点：\r\n\r\n**优点：**\r\n\r\n- 非常优秀的level design（关卡设计）和player traversal\r\n\r\n- 畅快淋漓的战斗和优秀的boss战\r\n\r\n- 展现给玩家苦难和凄美的艺术世界\r\n\r\n**缺点：**\r\n\r\n- 资源有限，技术力不足导致的渲染和综合表现力跟不上时代，fidelity一般\r\n\r\n- 一般的叙事，差劲的任务指引\r\n\r\n- 容易迷路的地图，还可以更好优化的一些鸡肋系统和一般的player growth（玩家成长）\r\n\r\n- 用过于难的combat encounter和boss战来延长游戏时间', '2019-06-14 09:12:55');
INSERT INTO `slice` VALUES (7, 1, 2, '塞尔达评测', '狂野、末日后科魔风的海拉尔大陆是《塞尔达传说：野之息》中的重要背景。不仅仅是因为它美丽广袤，里面还充满了各种草地或者高耸山脉以及其他类型的地点，同时这个世界里面的一切又是如此符合现实世界规则，让你能够在不经意之间使出自己都意想不到的解决方法：树木开花结果，草地可以燃气熊熊大火，甚至敌人和动物也有自己相对真实的行为逻辑。\r\n\r\n　　但是游戏里的真实性还远不止这些。你接触到的每一样物体，从木棒到苹果、从石头到金属都是由某种物质构成的，而且那些物质通常都会对火焰或磁力这类的力量产生反应。\r\n\r\n游侠网\r\n\r\n　　一切都发生在一个有趣灵动且真实异常的世界中，我从来没有想过会在一款动作冒险游戏中见到此种情景。如果你觉得一样东西有可能会起作用，那么基本上它绝对会起作用。在冒险之旅中我做了各种各样有趣搞笑的实验。你可以举着火把站在苹果树下面，直接把水果烤成有快速治疗效果的零食，或者朝没有武器的敌人投掷一把金属剑，看着它被雷电劈焦掉。与此同时，林克需要温暖的衣物才能在寒冷环境中生存下去，靠近死亡火焰山脉时还需要抗火焰装备。在游戏中研究、探索各种交互机制是相当重要的一点要素。', '2019-06-14 09:13:59');
INSERT INTO `slice` VALUES (8, 1, 2, '坐等赛博朋克2077', '这代码是真的难写', '2019-06-14 09:14:33');

-- ----------------------------
-- Table structure for slice_ref
-- ----------------------------
DROP TABLE IF EXISTS `slice_ref`;
CREATE TABLE `slice_ref`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `choose` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `author_id` int(11) NOT NULL,
  `from_id` int(11) NOT NULL DEFAULT 0,
  `to_id` int(11) NOT NULL DEFAULT 0,
  `fiction_id` int(11) NOT NULL,
  `state` int(11) NOT NULL DEFAULT 1,
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `next_id` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of slice_ref
-- ----------------------------
INSERT INTO `slice_ref` VALUES (1, '♂', 1, 1, 2, 1, 1, '2019-06-07 12:19:53', 0);
INSERT INTO `slice_ref` VALUES (2, '♂', 1, 1, 3, 1, 1, '2019-06-07 12:19:55', 0);
INSERT INTO `slice_ref` VALUES (3, '♂', 1, 1, 4, 1, 1, '2019-06-14 15:03:18', 0);
INSERT INTO `slice_ref` VALUES (4, '玩只狼', 1, 5, 6, 2, 1, '2019-06-14 09:15:09', 0);
INSERT INTO `slice_ref` VALUES (5, '玩塞尔达', 1, 5, 7, 2, 1, '2019-06-14 09:15:36', 0);
INSERT INTO `slice_ref` VALUES (6, '睡觉', 1, 6, 8, 2, 1, '2019-06-14 17:16:06', 0);
INSERT INTO `slice_ref` VALUES (7, '睡觉', 1, 7, 8, 2, 1, '2019-06-14 17:16:06', 0);

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'mashiroc', '9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08', '2019-06-07 11:15:14');

SET FOREIGN_KEY_CHECKS = 1;
