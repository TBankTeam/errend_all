/*
Navicat MySQL Data Transfer

Source Server         : firstwork
Source Server Version : 80030
Source Host           : localhost:3306
Source Database       : errand

Target Server Type    : MYSQL
Target Server Version : 80030
File Encoding         : 65001

Date: 2024-04-12 12:29:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '名称',
  `cover` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '封面',
  `descr` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '简介',
  `start` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '开始日期',
  `end` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '结束时间',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '活动详情',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='公益活动';

-- ----------------------------
-- Records of activity
-- ----------------------------
INSERT INTO `activity` VALUES ('2', '志愿服务树时代新风雷锋精神放璀璨光芒', 'http://localhost:9090/files/1704856762181-2.jpeg', '送温暖，送祝福，关爱老人身心健康', '2023-12-01', '2024-01-10', '<p>为大力弘扬“奉献、友爱、互助、进步”的志愿服务精神，践行助人为乐的志愿服务理念，在全国第60个学雷锋纪念日来临之际，3月5日，太谷区委统战部组织“党外人士之家”——传统文化志愿者协会走进<a href=\"https://www.yanglaocn.com/ylyxx/y27774.html\" target=\"_blank\">福康老年公寓</a>开展第二期“诵经典 塑品行”活动。</p><p style=\"text-align:center;\"><a href=\"https://www.yanglaocn.com/images/upload/img/2023/03_07/1975733afb5c614b78e56833a4466e6c.png\" target=\"_blank\"><img src=\"https://www.yanglaocn.com/images/upload/img/2023/03_07/1975733afb5c614b78e56833a4466e6c.png\"/></a></p><p style=\"text-align:center;\"><a href=\"https://www.yanglaocn.com/images/upload/img/2023/03_07/809f3e84c6cce11415c32dea07e4847b.png\" target=\"_blank\"><img src=\"https://www.yanglaocn.com/images/upload/img/2023/03_07/809f3e84c6cce11415c32dea07e4847b.png\"/></a></p><p>活动中，志愿者服务队为老人表演了手语舞、诗歌朗诵、舞蹈等丰富多彩的节目，小志愿者们将水果、点心分享给老人，并且给老人们捶背、揉肩，福康养老院的老人们大多为五保户，感受到子孙绕膝的快乐，脸上都露出开心地笑容。</p><p style=\"text-align:center;\"><a href=\"https://www.yanglaocn.com/images/upload/img/2023/03_07/f13cd67b08eaea80743fb5dd5d964da9.png\" target=\"_blank\"><img src=\"https://www.yanglaocn.com/images/upload/img/2023/03_07/f13cd67b08eaea80743fb5dd5d964da9.png\"/></a></p><p>这次活动不仅使新时代雷锋精神得到继承和发扬，更是身体力行优秀传统文化的生动实践。活动计划发出后，得到许多人的积极响应，除了协会志愿者带孩子参加，更有山西农大、信息学院大学生，心连心志愿者协会会员慕名前来，活动参与者将近60人。在中华优秀传统文化的熏陶下，志愿服务精神正逐步成为当代人乐于接受的新风尚。志愿于心，志愿于行，雷锋精神将代代相传，绽放璀璨光芒！</p><p style=\"text-align:center;\"><a href=\"https://www.yanglaocn.com/images/upload/img/2023/03_07/780710ae87821a51e1972aa4724bc65b.png\" target=\"_blank\"><img src=\"https://www.yanglaocn.com/images/upload/img/2023/03_07/780710ae87821a51e1972aa4724bc65b.png\"/></a></p>', '和平东路1221号');
INSERT INTO `activity` VALUES ('3', '【爷爷奶奶的新年礼物】——“边陲暖心行情系夕阳红”', 'http://localhost:9090/files/1704856756927-3085808915_14_561_400.jpg', '送温暖，送祝福，关爱老人身心健康', '2023-12-01', '2024-02-07', '<p>木棉花开，柳絮纷飞，最美的三月天，唯有春风和笑容不可错过。3月7日，临江市博达志愿者协会联合上海浦东新区恩派公益基金会和爱心人士易宏超前往临江市望江村、大栗子村、大湖村、站前村开展【爷爷奶奶的新年礼物】之“边陲暖心行 情系夕阳红”爱心捐助活动。带着节日的美好祝福，为老人们送去了温暖。</p><p style=\"text-align:center;\"><a href=\"https://www.yanglaocn.com/images/upload/img/2023/03_13/a4afbc43e1fec158d2e8c3c1df86cca9.png\" target=\"_blank\"><img src=\"https://www.yanglaocn.com/images/upload/img/2023/03_13/a4afbc43e1fec158d2e8c3c1df86cca9.png\"/></a></p><p>活动先后走访了大栗子村、望江村、大湖村、站前村10户边境村低收入老人，为她们送去了毛衣外套、鞋等慰问品。每走一户，巾帼志愿者们都与她们交心谈心、聊家常，聆听生活需求，向她们送去问候与关怀。在这特殊的日子里，志愿者们还为老人们送上了节日祝福歌，并和老人们一同跳舞欢唱，温暖动人的场面，让老人们满心喜悦，并衷心地感谢“巾帼志愿者”对她们的关爱。</p><p style=\"text-align:center;\"><a href=\"https://www.yanglaocn.com/images/upload/img/2023/03_13/fcf28f49aa1cc5267c98d3c11d2456bd.png\" target=\"_blank\"><img src=\"https://www.yanglaocn.com/images/upload/img/2023/03_13/fcf28f49aa1cc5267c98d3c11d2456bd.png\"/></a></p><p style=\"text-align:center;\"><a href=\"https://www.yanglaocn.com/images/upload/img/2023/03_13/96863e19456e3dbf36d2383dc5be93e9.png\" target=\"_blank\"><img src=\"https://www.yanglaocn.com/images/upload/img/2023/03_13/96863e19456e3dbf36d2383dc5be93e9.png\"/></a></p><p style=\"text-align:center;\"><a href=\"https://www.yanglaocn.com/images/upload/img/2023/03_13/928aee331ec63a7502a9aa4ae13b0f08.png\" target=\"_blank\"><img src=\"https://www.yanglaocn.com/images/upload/img/2023/03_13/928aee331ec63a7502a9aa4ae13b0f08.png\"/></a></p><p>活动历时近四个小时，期间参加活动的志愿者们分别与帮扶老人合影，整个活动不仅充满了温暖、传递了爱心，更是用这样一种方式表达了尊老、敬老、爱老的心念，用实际行动弘扬了中华民族懂得感恩的传统美德！</p>', '和平东路1221号');
INSERT INTO `activity` VALUES ('4', '冬病夏治”麻布社区健康知识科普活动', 'http://localhost:9090/files/1704856750467-微信截图_20231229162702.png', '送温暖，送祝福，关爱老人身心健康', '2023-12-01', '2024-01-10', '<p>2023年7月5日，尚德驻麻布社区党群服务中心社工开展了“冬病夏治”麻布社区健康知识科普活动，本次讲座链接深圳恒生医院的宋主任精彩讲解，共吸引了25位社区长者参与活动。</p><p style=\"text-align:center;\"><a href=\"https://www.yanglaocn.com/images/upload/img/2023/07_14/c1a5ed7275808a271a0c56bb2d0d1f9f.jpg\" target=\"_blank\"><img alt=\"“冬病夏治”麻布社区健康知识科普活动\" src=\"https://www.yanglaocn.com/images/upload/img/2023/07_14/c1a5ed7275808a271a0c56bb2d0d1f9f.jpg\"/></a></p><p>本次活动主要是讲解“冬病夏治”三伏灸的养生方法，医师通过PPT为大家认真讲解健康知识点，不时也有互动环节，在活动的最后，通过有奖答题互动调动了大家的积极性，医师准备了五题讲过的知识点作为问答题，作为知识的巩固，前五名答对题目的参与者可以获得三伏灸体验一次。大家都很认真的听讲，所以很熟知答案，都争先恐后的举手回答，现场气氛很活跃，大家都沉浸在健康知识的海洋中。</p><p style=\"text-align:center;\"><a href=\"https://www.yanglaocn.com/images/upload/img/2023/07_14/368a923da1b91234c758a5bd6baff0e7.jpg\" target=\"_blank\"><img alt=\"“冬病夏治”麻布社区健康知识科普活动\" src=\"https://www.yanglaocn.com/images/upload/img/2023/07_14/368a923da1b91234c758a5bd6baff0e7.jpg\"/></a></p><p>此次讲座增进了长者们之间的交流，参与者表示不仅学习到了知识点，还有实际操作，可以了解到三伏灸的具体做法，讲座结束后，很多参与者建议，希望多开展此类的活动，他们很感兴趣，学到的内容也很有用。</p>', '和平东路1221号');
INSERT INTO `activity` VALUES ('5', '支部结对聚合力 携手共建保健康', 'http://localhost:9090/files/1704856746075-微信截图_20231229162702.png', '天津市滨海新区海滨街幸福社区居委会与幸福社区卫生服务中心是“党支部结对共建单位”，疫情期间在社区居民健康、疾病防治等方面合作密切。', '2023-12-01', '2024-01-10', '<p>天津市滨海新区海滨街幸福社区居委会与幸福社区卫生服务中心是“党支部结对共建单位”，疫情期间在社区居民健康、疾病防治等方面合作密切。近日，海滨街幸福社区党支部组织60余名辖区退休老党员到周邓纪念馆、天津博物馆、科技馆等红色教育基地参观，幸福社区卫生服务中心作为协作单位选派有丰富工作经验的龙雪、巩传慧、刘国凤三名同志，成立随行保障组，为这些社区老党员干部提供医疗保障服务。</p><p style=\"text-align:center;\"><a href=\"https://www.yanglaocn.com/images/upload/img/2023/07_21/79b669c00c4741791c589010a1813d83.jpg\" target=\"_blank\"><img alt=\"支部结对聚合力 携手共建保健康\" src=\"https://www.yanglaocn.com/images/upload/img/2023/07_21/79b669c00c4741791c589010a1813d83.jpg\"/></a></p><p>考虑到参加此次活动的老党员年龄都在65岁以上，保障组为应对突发情况准备了急救箱，配备血压计、血糖仪、防中暑药、救心丸、纱布、绷带等医疗急救物品。保障组的同志为保证天气炎热的情况下活动能够顺利主动与居委会对接，与居委会协商确定每到一个展馆大家稍作休息再开始参观。</p><p style=\"text-align:center;\"><a href=\"https://www.yanglaocn.com/images/upload/img/2023/07_21/9defb3a9915b038808fe449753d375fa.jpg\" target=\"_blank\"><img alt=\"支部结对聚合力 携手共建保健康\" src=\"https://www.yanglaocn.com/images/upload/img/2023/07_21/9defb3a9915b038808fe449753d375fa.jpg\"/></a></p><p>虽然事前考虑了各种情况也做了很多准备工作，但是仍有两位75岁的老党员由于天气原因出现身体不适的症状，龙雪医生和刘国凤护士急忙上前给予紧急处置，为他们缓解症状。午后气温高达42℃，她们又及时给老党员们发放了藿香正气水等药物，防止“中暑”发生。与此同时，随行医护人员和老党员们也一起接受了红色洗礼，重温党的光荣历史。一天的行程结束，随行保障组的成员虽感劳累，但倍觉心安，她们尽心竭力为老党员们保驾护航的行动，得到幸福社区居委会和老党员们的一致好评。</p><p style=\"text-align:center;\"><a href=\"https://www.yanglaocn.com/images/upload/img/2023/07_21/e02ad659bb081b6d6461c19087067af8.jpg\" target=\"_blank\"><img alt=\"支部结对聚合力 携手共建保健康\" src=\"https://www.yanglaocn.com/images/upload/img/2023/07_21/e02ad659bb081b6d6461c19087067af8.jpg\"/></a></p>', '和平东路1221号');
INSERT INTO `activity` VALUES ('6', '季度集体生日会，让“银发”志愿者感受“大家庭”的温暖', 'http://localhost:9090/files/1704856740599-1.jpeg', '\"老吾老，以及人之老\"，尊老敬老是中华民族的传统美德，也是培育和践行社会主义核心价值观的基本要求。为营造敬老、亲老、爱老、助老的社会风尚', '2023-12-01', '2024-01-30', '<p>\"老吾老，以及人之老\"，尊老敬老是中华民族的传统美德，也是培育和践行社会主义核心价值观的基本要求。为营造敬老、亲老、爱老、助老的社会风尚，7月30日下午，思南县青年志愿者协会在双塘街道丽景社区开展\"银发丽景”集体生日会\"。下午一点半，志愿者们就开始为生日会做准备。摆桌椅、切水果、泡茶……志愿者们忙得不亦乐乎。一个小时后，生日会现场布置妥当，志愿者们满怀期待地等待寿星们的到来。</p><p style=\"text-align:center;\"><a href=\"https://www.yanglaocn.com/images/upload/img/2023/08_03/1ab710e2b541778e94fc822a3dab3dbb.jpg\" target=\"_blank\"><img alt=\"季度集体生日会，让“银发”志愿者感受“大家庭”的温暖\" src=\"https://www.yanglaocn.com/images/upload/img/2023/08_03/1ab710e2b541778e94fc822a3dab3dbb.jpg\"/></a></p><p>下午三点半活动正式开始，来自丽景社区的32名银发志愿者欢聚一堂。志愿者首先带着老人们做了暖心小游戏，之后为他们送上生日帽，志愿们还为每位老人精心的准备了爱心生日卡。拿到生日卡，戴上生日帽的银发志愿者像孩子一样，露出兴奋和欣喜的笑容。</p><p>志愿者们集体喊出\"爷爷奶奶们，祝你们生日快乐！\"生日会就在这轻松愉快的氛围中开始。活动中，志愿者们表演了舞蹈、合唱了《没有共产党就没有新中国》等节目。，邀请大家一起唱，现场气氛热烈，把生日会推上了高潮。</p><p>最抢眼的还算是我们年纪最长的寿星了，我们的老赵，今年已有75岁，他还为所有的寿星们献上祝福，祝\"大家生日快乐，身体健康，还感谢协会为我们举办生日会，真是太高兴了，虽然自己的子女都不在身边，但有你们在我们身边，有你们惦记着我们，我们就是幸福的\"，虽然老赵75岁的高龄了，但说起话来一点都不含糊，在他讲完后，大家的掌声都不愿停下。最后为大家为大家献上一首《大海航前靠舵手》，现场其乐融融，充满了温暖与欢笑。</p><p style=\"text-align:center;\"><a href=\"https://www.yanglaocn.com/images/upload/img/2023/08_03/29ec0c8e6dfb94a63d2e872d48b6e5c4.jpg\" target=\"_blank\"><img alt=\"季度集体生日会，让“银发”志愿者感受“大家庭”的温暖\" src=\"https://www.yanglaocn.com/images/upload/img/2023/08_03/29ec0c8e6dfb94a63d2e872d48b6e5c4.jpg\"/></a></p><p>活动最后，志愿者们将双层大蛋糕推到场地中央，点燃蜡烛，为寿星们唱起生日歌。寿星们许下心愿，一同吹灭蜡烛，开心地享用志愿者切好的蛋糕，活动在温馨的氛围中落下帷幕。</p><p style=\"text-align:center;\"><a href=\"https://www.yanglaocn.com/images/upload/img/2023/08_03/15cada325e90ad67d14316c25de3aa7b.jpg\" target=\"_blank\"><img alt=\"季度集体生日会，让“银发”志愿者感受“大家庭”的温暖\" src=\"https://www.yanglaocn.com/images/upload/img/2023/08_03/15cada325e90ad67d14316c25de3aa7b.jpg\"/></a></p><p>协会希望通过集体生日会，让银发志愿者们彼此拉近距离，多走出家门，多交朋友，丰富老年人生活。为此，接下来协会将每季度都会为银发志愿者们集体庆生，让他们都能感觉到大家庭的温暖。</p>', '和平东路1221号');
INSERT INTO `activity` VALUES ('7', '爱心共建聚合力 关爱老人做公益', 'http://localhost:9090/files/1704856732397-3085808915_14_561_400.jpg', '送温暖，送祝福，关爱老人身心健康', '2023-12-01', '2024-01-20', '<p style=\"text-align:center;\"><img src=\"https://www.yanglaocn.com/images/upload/img/2023/12_13/885e29bf31d55a7065303bc7dff2f2c3.png\"/><img src=\"http://localhost:9090/files/1703840142970-image.png\" contenteditable=\"false\" style=\"font-size: 14px; max-width: 100%;\"/></p><br/>', '和平东路1221号');
INSERT INTO `activity` VALUES ('8', 'test', null, 'test', '2024-03-28', '2024-03-30', '<p>来玩啊</p>', 'test');
INSERT INTO `activity` VALUES ('9', 'test', 'http://localhost:9090/files/1712823646489-1697438073596-avatar.png', 'test', '2024-04-12', '2024-04-12', '<p>test</p>', 'test');

-- ----------------------------
-- Table structure for activity_sign
-- ----------------------------
DROP TABLE IF EXISTS `activity_sign`;
CREATE TABLE `activity_sign` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `activity_id` int DEFAULT NULL COMMENT '活动ID',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '联系方式',
  `date` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '报名日期',
  `user_id` int DEFAULT NULL COMMENT '报名人ID',
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '待审核' COMMENT '审核状态',
  `reason` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '审核意见',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='活动报名';

-- ----------------------------
-- Records of activity_sign
-- ----------------------------
INSERT INTO `activity_sign` VALUES ('6', '7', '13988997788', '2024-01-17', '2', '待审核', null);
INSERT INTO `activity_sign` VALUES ('7', '6', '139888990099', '2024-01-17', '2', '审核通过', 'OK');
INSERT INTO `activity_sign` VALUES ('8', '6', '13988997799', '2024-01-18', '8', '待审核', null);
INSERT INTO `activity_sign` VALUES ('9', '8', '1313', '2024-03-28', '1', '待审核', null);
INSERT INTO `activity_sign` VALUES ('10', '8', '13', '2024-03-28', '31', '审核通过', null);

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '地址',
  `door_no` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '门牌号',
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '联系人',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '联系电话',
  `user_id` int DEFAULT NULL COMMENT '关联用户ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='联系人信息';

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES ('1', '北京东路', '100号', '李四四', '13877889988', '1');
INSERT INTO `address` VALUES ('3', '政务东路', '120号', '青哥哥哥', '13766998899', '1');
INSERT INTO `address` VALUES ('4', '合肥西路', '1100号', '小武哥哥', '13099008899', '1');
INSERT INTO `address` VALUES ('6', '合肥东路', '120号', '小雨', '13677889966', '2');
INSERT INTO `address` VALUES ('7', '合肥北路', '110号', '小王', '13988778866', '2');
INSERT INTO `address` VALUES ('8', '合肥南里', '1110号', '笑笑', '13677558877', '2');
INSERT INTO `address` VALUES ('12', '合肥大剧院', '110号', '小武哥哥', '13988997788', '24');
INSERT INTO `address` VALUES ('13', '合肥西路', '1201号', '小雨', '13988997788', '24');
INSERT INTO `address` VALUES ('15', 'dsa', 'das', 'dsa', 'dsa', '31');
INSERT INTO `address` VALUES ('16', 'sf', 'gf', 'dgfd', 'gdf', '31');
INSERT INTO `address` VALUES ('17', 'dz', 'mp', 'zl', '123', '32');

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '密码',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '姓名',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '头像',
  `role` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '角色标识',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '电话',
  `count_address` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '钱包地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='管理员';

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', '$2a$10$LENHDWwWccAAVaeI.F/d0O0sMnVfowlObdqR2Uts1x0gQnoYuZDCG', '王大爷', 'http://localhost:9090/files/1697438073596-avatar.png', 'ADMIN', '13677889922', null);
INSERT INTO `admin` VALUES ('3', 'test', '$2a$10$LENHDWwWccAAVaeI.F/d0O0sMnVfowlObdqR2Uts1x0gQnoYuZDCG', 'test', 'http://localhost:9090/files/1710832789611-1700704030807-mT24qmNOwHzsd0c4ff9133bcb1b397eeedf9d5bc65e0.png', 'ADMIN', '123', null);
INSERT INTO `admin` VALUES ('4', 'test2', '******', 'test2', 'http://localhost:9090/files/1710933709146-1700703916417-vj17JrViON0r99915b5d3c7d49851528fb541fada677.png', 'ADMIN', '123', null);
INSERT INTO `admin` VALUES ('5', 'test3', '******', 'test3', 'http://localhost:9090/files/1710933720210-1700706315381-nQC2Fa5ufYXE76fda5dd9caa4d0a4037ec4dc7e157b7.png', 'ADMIN', '123', null);

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='资讯分类';

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '养老动态');
INSERT INTO `category` VALUES ('2', '养老政策');
INSERT INTO `category` VALUES ('3', '养老服务');
INSERT INTO `category` VALUES ('4', '养老产业');
INSERT INTO `category` VALUES ('5', '养老模式');
INSERT INTO `category` VALUES ('6', '养老金');
INSERT INTO `category` VALUES ('7', '居家养老');

-- ----------------------------
-- Table structure for certification
-- ----------------------------
DROP TABLE IF EXISTS `certification`;
CREATE TABLE `certification` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_id` int DEFAULT NULL COMMENT '账号',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '名称',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '本人照片',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '联系方式',
  `card_no` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '身份证号码',
  `card1` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '身份证正面',
  `card2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '身份证反面',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '常住地址',
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '待审核' COMMENT '审核状态',
  `reason` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '审核理由',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='认证信息';

-- ----------------------------
-- Records of certification
-- ----------------------------
INSERT INTO `certification` VALUES ('1', '16', 'aaa11', 'http://localhost:9090/files/1700706310081-OLFpNOtJcOzi99915b5d3c7d49851528fb541fada677.png', '2222', '222', 'http://localhost:9090/files/1700706313528-pVZWqsT4bu9cd0c4ff9133bcb1b397eeedf9d5bc65e0.png', 'http://localhost:9090/files/1700706315381-nQC2Fa5ufYXE76fda5dd9caa4d0a4037ec4dc7e157b7.png', '2222', '通过', null);
INSERT INTO `certification` VALUES ('2', '14', 'aaa9', 'http://localhost:9090/files/1700706310081-OLFpNOtJcOzi99915b5d3c7d49851528fb541fada677.png', '2222', '222', 'http://localhost:9090/files/1700706313528-pVZWqsT4bu9cd0c4ff9133bcb1b397eeedf9d5bc65e0.png', 'http://localhost:9090/files/1700706315381-nQC2Fa5ufYXE76fda5dd9caa4d0a4037ec4dc7e157b7.png', '2222', '拒绝', '');
INSERT INTO `certification` VALUES ('13', '1', 'abc', 'http://localhost:9090/files/1700706310081-OLFpNOtJcOzi99915b5d3c7d49851528fb541fada677.png', '2222', '222', 'http://localhost:9090/files/1700706313528-pVZWqsT4bu9cd0c4ff9133bcb1b397eeedf9d5bc65e0.png', 'http://localhost:9090/files/1700706315381-nQC2Fa5ufYXE76fda5dd9caa4d0a4037ec4dc7e157b7.png', '2222', '通过', 'OK');
INSERT INTO `certification` VALUES ('15', '15', 'abc10', null, null, null, null, null, null, '通过', null);
INSERT INTO `certification` VALUES ('16', '31', 'wanglaowu', null, null, null, null, null, null, '通过', null);
INSERT INTO `certification` VALUES ('17', '2', 'lisi', null, '123123', '321321', null, null, '123', '通过', null);
INSERT INTO `certification` VALUES ('19', '32', 'yq', 'http://localhost:9090/files/1712844727707-OiNbhSc5DwqIa211f268fcb5da6c99a805f8d86993fa.png', '123123', '361025195303020516', 'http://localhost:9090/files/1712844752227-vdrkP7JpoWlw33910d12706074886a41ea3f068e3653.png', 'http://localhost:9090/files/1712844754937-24o9EHeY0waE33910d12706074886a41ea3f068e3653.png', 'dz', '通过', null);

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `content` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '内容',
  `user_id` int DEFAULT NULL COMMENT '评论人',
  `pid` int DEFAULT NULL COMMENT '父级ID',
  `root_id` int DEFAULT NULL COMMENT '根节点ID',
  `time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '评论时间',
  `fid` int DEFAULT NULL COMMENT '关联ID',
  `module` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '模块',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='评论表';

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('5', '测试一下3', '2', null, null, '2024-01-15 09:57:00', '9', 'news');
INSERT INTO `comment` VALUES ('6', '测试一下4', '2', null, null, '2024-01-15 09:57:00', '9', 'news');
INSERT INTO `comment` VALUES ('7', '11111111', '2', null, null, '2024-01-15 11:19:09', '9', 'news');
INSERT INTO `comment` VALUES ('8', '2222', '2', null, null, '2024-01-15 11:19:51', '9', 'news');
INSERT INTO `comment` VALUES ('9', '3333', '2', null, null, '2024-01-15 11:19:52', '9', 'news');
INSERT INTO `comment` VALUES ('24', '11111', '3', '9', '9', '2024-01-15 11:56:54', '9', 'news');
INSERT INTO `comment` VALUES ('25', '2222', '3', '8', '8', '2024-01-15 11:57:00', '9', 'news');
INSERT INTO `comment` VALUES ('26', '哈哈哈哈  我是卖报的小行家', '2', null, null, '2024-01-17 09:58:45', null, 'news');
INSERT INTO `comment` VALUES ('27', '哈哈哈  我又来了', '2', null, null, '2024-01-17 10:02:33', '7', 'activity');
INSERT INTO `comment` VALUES ('28', '哈哈哈哈  你好帅啊', '2', null, null, '2024-01-17 10:02:41', '7', 'activity');
INSERT INTO `comment` VALUES ('29', '这是我的回复', '2', '28', '28', '2024-01-17 10:02:48', '7', 'activity');
INSERT INTO `comment` VALUES ('31', '23123213213213', '8', null, null, '2024-01-18 11:27:23', '5', 'news');
INSERT INTO `comment` VALUES ('32', '321321321', '8', '31', '31', '2024-01-18 11:27:26', '5', 'news');

-- ----------------------------
-- Table structure for evaluate
-- ----------------------------
DROP TABLE IF EXISTS `evaluate`;
CREATE TABLE `evaluate` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '评论',
  `star` double(10,1) DEFAULT '0.0' COMMENT '评分',
  `user_id` int DEFAULT NULL COMMENT '用户ID',
  `accept_id` int DEFAULT NULL COMMENT '骑手ID',
  `order_id` int DEFAULT NULL COMMENT '订单ID',
  `time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `user_id` (`user_id`,`order_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='评价表';

-- ----------------------------
-- Records of evaluate
-- ----------------------------
INSERT INTO `evaluate` VALUES ('8', '跑腿小哥哥非常nice，很贴心', '5.0', '24', '1', '23', '2023-11-24 13:00:19');
INSERT INTO `evaluate` VALUES ('9', 'ok\n', '5.0', '24', '1', '25', '2023-11-24 13:02:42');
INSERT INTO `evaluate` VALUES ('10', null, '4.0', '2', '31', '22', '2024-03-21 20:24:39');
INSERT INTO `evaluate` VALUES ('13', '好', '5.0', '31', '2', '29', '2024-03-21 20:30:15');
INSERT INTO `evaluate` VALUES ('14', 'h', '5.0', '2', '31', '21', '2024-03-21 20:44:30');
INSERT INTO `evaluate` VALUES ('16', '好', '5.0', '2', '31', '20', '2024-03-21 20:44:37');
INSERT INTO `evaluate` VALUES ('17', 'dsa', '4.0', '32', '31', '30', '2024-04-11 22:55:22');

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '标题',
  `descr` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '简介',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '内容',
  `cover` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '封面',
  `time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '发布时间',
  `count` int DEFAULT '0' COMMENT '浏览次数',
  `category` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '分类',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='资讯表';

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES ('1', '印发推动乡镇敬老院高质量发展十条措施的通知', '推进乡镇敬老院规划建设，提升乡镇敬老院居住环境，统筹区域养老服务资源配置', '<p>各县 （区）人民政府、抚州高新区管委会、东临新区管委会，市政府各部门：</p><p>为贯彻落实《江西省人民政府办公厅<a href=\"https://www.yanglaocn.com/shtml/20210909/1631159047127882.html\" target=\"_blank\">关于加快推进养老服务高质量发展的实施意见</a>》（赣府厅发〔2021〕16号）、《江西省民政厅中共江西省委编办江西省发展改革委江西省财政厅江西省人力资源和社会保障厅关于深化公办<a href=\"https://www.yanglaocn.com/shtml/20231213/1702446420157798.html\" target=\"_blank\">养老机构</a>改革的实施意见》（赣民发〔2021〕12号）等文件精神，加快补齐农村养老服务短板，全面构建满足农村老年人需求的新时代<a href=\"https://www.yanglaocn.com/search/?SearchKey=%E5%86%9C%E6%9D%91%E5%85%BB%E8%80%81%E6%9C%8D%E5%8A%A1%E4%BD%93%E7%B3%BB\" target=\"_blank\">农村养老服务体系</a>，不断满足农村老人日益增长的养老需求,结合抚州实际，提出推动乡镇<a href=\"https://www.yanglaocn.com/shtml/20231213/1702438144157980.html\" target=\"_blank\">敬老院</a>高质量发展十条措施如下:</p><p><strong>一、推进乡镇敬老院规划建设。</strong>依照 《<a href=\"https://www.yanglaocn.com/shtml/20180703/1530607390115337.html\" target=\"_blank\">老年人照料设施建筑设计标准</a>》（ JGJ450-2018）、《<a href=\"https://www.yanglaocn.com/search/?SearchKey=%E8%80%81%E5%B9%B4%E5%85%BB%E6%8A%A4\" target=\"_blank\">老年养护</a>院建设标准》（建标144-2010）等标准，各县（区）人民政府要对规模小、条件差，难以满足养老服务发展需求的乡镇敬老院，积极统筹政府专项债、中央预算内项目资金，加快推进乡镇敬老院新建、改建或扩建，单体项目床位设置规模原则上不超过150张，其中新建护理型床位占比不低于60%，改建或扩建护理型床位占比不低于50%。</p><p><strong>二、提升乡镇敬老院居住环境。</strong>按照《江西省公办<a href=\"https://www.yanglaocn.com/shtml/20231227/1703636280158838.html\" target=\"_blank\">养老院</a>改造提升实施方案（2020-2022年）》，对乡镇敬老院实施建筑标准、设施设备、院区场地、用房功能等改造提升。 2022年6月前，乡镇敬老院具备安装空调条件的老人居室、活动室要全部安装完成； 2022年底前，新建、改扩建和改造提升后的乡镇敬老院须达到《江西省公办养老院服务设施改造提升基础指标》要求。依照《江西省公办养老院适老化改造指南》，对在运营的乡镇敬老院实施适老化改造， 2022年底前完成80%以上，且全部达到一级或二级养老机构标准。</p><p><strong>三、统筹区域养老服务资源配置。</strong>原则上按每2至3个毗邻乡镇组成一个协作区域，选择该区域内一所设施条件较好、床位规模较多、交通便利的乡镇敬老院作为区域性中心敬老院，负责接收协作区域内其他乡镇敬老院转送的特困供养障对象。对现有床位数不足40张且收住人数少于10人的乡镇敬老院，可将收住对象安置到毗邻乡镇或区域性中心敬老院，相关经费按标准一并划入接收机构。原有设施不得改变养老服务用途，可通过公建民营方式交由社会力量运营，或用于<a href=\"https://www.yanglaocn.com/search/?SearchKey=%E5%B1%85%E5%AE%B6%E7%A4%BE%E5%8C%BA%E5%85%BB%E8%80%81%E6%9C%8D%E5%8A%A1\" target=\"_blank\">居家社区养老服务</a>和农村互助养老服务。到2022年底前，各县 （区）在运营的乡镇敬老院入住率达到60%以上。</p><p><strong>四、优化乡镇敬老院功能定位。</strong>乡镇敬老院要从兜底保障服务机构向区域养老服务中心转型，为周边老年人提供短期托养、日间照料、家庭养老床位以及助餐、助浴、助洁、助急、助医等养老延伸服务。到2022年底前，乡镇敬老院在满足特困人员集中供养服务需求的前提下，逐步满足其他经济困难的高龄、失能老年人社会化照护托养需求。</p><p><strong>五、推进乡镇敬老院改革。</strong>按照《<a href=\"https://www.yanglaocn.com/shtml/20180522/1526957521114879.html\" target=\"_blank\">江西省养老服务设施公建民营暂行办法</a>》要求，对符合国家规定并需要实施公建民营的，综合从业信誉、服务水平、可持续性等指标，引入品牌化、专业化的服务机构、社会组织承接运营。公建民营协议要明确约定保留不低于20%的床位用于接收政府供养和基本养老服务保障对象，确保公益属性。公建民营乡镇敬老院接收特殊困难群体的服务收费标准，由相关部门按照普惠性原则合理确定。</p><p><strong>六、推进乡镇敬老院人事制度改革。</strong>根据省民政厅、省委编办等5部门联合下发的《关于深化公办养老机构改革的实施意见》（以下简称 《实施意见》）要求，2022年1月起，乡镇敬老院核定事业编制岗位出现空缺的，应根据国家和我省事业单位公开招聘制度等有关规定进行公开招聘，列入正式事业编制。《实施意见》下发之前，通过公开选聘方式聘用、实行定编定岗不定人管理的人员，在聘期内享受事业单位国家规定的工资福利待遇，参照事业单位同类人员缴费基数缴纳社会保险。</p><p><strong>七、加强乡镇敬老院管理人员考核。</strong>县（区）民政部门或乡镇人民政府要加强对乡镇敬老院管理人员的规范管理，建立健全人员管理制度和管理人员考核办法，重点考核服务数量和质量、管理水平、运营效率、持续发展、满意度评价等。建立按岗定酬、按工作业绩取酬的内部分配激励机制，考核结果与职务职级晋升、奖惩、薪酬分配挂钩。</p><p><strong>八、做好乡镇敬老院消防改造工作。</strong>按照养老机构消防安全专项整治三年行动要求，县（区）人民政府要加强协调调度，妥善解决乡镇敬老院消防审验历史遗留问题。对局部设施条件落后、功能不完善、安全不达标的乡镇敬老院实施改造提升，重点对涉及底线的安全设施设备进行维修和配置。对符合消防安全要求的乡镇敬老院，因未办理土地、规划等手续问题未能通过消防审验的，由属地县（区）政府按规定集中研究处理。</p><p><strong>九、健全乡镇敬老院综合监管。</strong>建立以“双随机、一公开”监管为基本手段、以重点监管为补充、以标准规范为支撑、以信用监管为基础的新型监管机制。建立各司其职、各尽其责的跨部门协同监管机制，对乡镇敬老院消防安全、燃气安全、疫情防控、食品安全、服务安全工作加强事中事后协同监督，实现各部门线索互联、标准互通、结果互认。</p><p><strong>十、做好乡镇敬老院经费保障。</strong>各县（区）人民政府要把乡镇敬老院正常运营所需经费列入财政预算，并及时足额拨付。入住人数少于或等于10人的，安排运行经费（不含人员工资、绩效等经费）不少于2万元/年；入住人数大于10人的，每增加1人，增加运行经费不少于0.2万元/年。要按照“应储尽储”原则，将乡镇敬老院新建或提升改造工程纳入中央预算内项目和政府专项债券，并做好项目申报前期各项准备工作。</p><p>市政府将定期调度各地工作推进情况，对工作推进有力的地方予以通报表扬，并在项目资金安排上予以倾斜；对工作推进不力的地方予以通报批评。各县（区）人民政府要落实属地管理职责，结合实际制定实施方案，细化具体举措，强化督促检查，确保完成各项工作任务。</p>', 'http://localhost:9090/files/1705028322504-1caee21e187f3e929fd4bbdb8151c19b.jpg', '2023-12-28 20:00:00', '44', '养老政策');
INSERT INTO `news` VALUES ('2', '冬至吃饺子，九九养老•玖悦颐养中心陪你过一个温暖的节日！', '九九养老•玖悦颐养中心于冬至当天举办了一场别开生面的包饺子活动。志愿者们和长者们一起动手，擀皮、包馅，共同创造出一份份充满爱心的饺子。活动现场氛围热烈，长者们的脸上洋溢着满足的笑容，他们品尝着自己的劳动成果，感受到了家一般的温暖。此次活动不仅是对传统文化的继承，更是对长者们关爱的表现，让他们在这个特殊的日子里感受到了家的温馨和关怀。', '<p>冬至不端饺子碗，冻掉耳朵没人管。</p><p>老话说“冬至大如年”，按照北方的传统，冬至是必须要吃饺子的！这不仅是一种文化习俗的传承，也是一种颇有仪式感的情感表达。</p><p><a href=\"https://www.yanglaocn.com/images/upload/img/2023/12_25/5a589c5b30d83a46c918f18a05b21f80.jpg\" target=\"_blank\"><img alt=\"冬至吃饺子，九九养老•玖悦颐养中心陪你过一个温暖的节日！\" src=\"https://www.yanglaocn.com/images/upload/img/2023/12_25/5a589c5b30d83a46c918f18a05b21f80.jpg\"/></a></p><p>饺子形如元宝，是福气和财源的象征，另一方面在包饺子的时候全家齐上阵，热热闹闹，也是团圆幸福的象征。所以每到冬至吃饺子就是北方人的执念。</p><p><a href=\"https://www.yanglaocn.com/images/upload/img/2023/12_25/0202042d28006ced34aa094c3245c7c8.jpg\" target=\"_blank\"><img alt=\"冬至吃饺子，九九养老•玖悦颐养中心陪你过一个温暖的节日！\" src=\"https://www.yanglaocn.com/images/upload/img/2023/12_25/0202042d28006ced34aa094c3245c7c8.jpg\"/></a></p><p><a href=\"https://www.yanglaocn.com/images/upload/img/2023/12_25/1d856c10d9f79a53c726a5a75aa09433.jpg\" target=\"_blank\"><img alt=\"冬至吃饺子，九九养老•玖悦颐养中心陪你过一个温暖的节日！\" src=\"https://www.yanglaocn.com/images/upload/img/2023/12_25/1d856c10d9f79a53c726a5a75aa09433.jpg\"/></a></p><p>冬至这天，高新区社会事业服务局和锦业路社区的志愿者们来到<a href=\"https://www.yanglaocn.com/ylyxx/y25606.html\" target=\"_blank\">高新区丈八街道综合养老服务中心（玖悦颐养中心）</a>，和长者们一起包饺子。</p><p>厨房已经帮大家准备好食材，长者和志愿者们相互配合、分工合作，擀皮、包馅，共享厨房里欢笑声、交谈声、锅碗瓢盆的撞击声交织在一起，气氛欢乐融洽、热闹非凡。</p><p><a href=\"https://www.yanglaocn.com/images/upload/img/2023/12_25/d438be80250eac54bcea57993dbf62bb.jpg\" target=\"_blank\"><img alt=\"冬至吃饺子，九九养老•玖悦颐养中心陪你过一个温暖的节日！\" src=\"https://www.yanglaocn.com/images/upload/img/2023/12_25/d438be80250eac54bcea57993dbf62bb.jpg\"/></a></p><p><a href=\"https://www.yanglaocn.com/images/upload/img/2023/12_25/dc4cdad8dff7067a82e82f1b09550618.jpg\" target=\"_blank\"><img alt=\"冬至吃饺子，九九养老•玖悦颐养中心陪你过一个温暖的节日！\" src=\"https://www.yanglaocn.com/images/upload/img/2023/12_25/dc4cdad8dff7067a82e82f1b09550618.jpg\"/></a></p><p><a href=\"https://www.yanglaocn.com/images/upload/img/2023/12_25/6023c911b60af313370a4a9c0131ed4e.jpg\" target=\"_blank\"><img alt=\"冬至吃饺子，九九养老•玖悦颐养中心陪你过一个温暖的节日！\" src=\"https://www.yanglaocn.com/images/upload/img/2023/12_25/6023c911b60af313370a4a9c0131ed4e.jpg\"/></a></p><p>人多力量大，很快就成果颇丰，花样繁多、充满创意的饺子摆满了餐盘，有扇形的、元宝形的、花形的……看着自己包的饺子，长者们脸上露出了笑容。</p><p><a href=\"https://www.yanglaocn.com/images/upload/img/2023/12_25/8f2fbf06667d433babb4337fd108df47.jpg\" target=\"_blank\"><img alt=\"冬至吃饺子，九九养老•玖悦颐养中心陪你过一个温暖的节日！\" src=\"https://www.yanglaocn.com/images/upload/img/2023/12_25/8f2fbf06667d433babb4337fd108df47.jpg\"/></a></p><p><a href=\"https://www.yanglaocn.com/images/upload/img/2023/12_25/2675f393142789c07c65dcf8d84fa8c2.jpg\" target=\"_blank\"><img alt=\"冬至吃饺子，九九养老•玖悦颐养中心陪你过一个温暖的节日！\" src=\"https://www.yanglaocn.com/images/upload/img/2023/12_25/2675f393142789c07c65dcf8d84fa8c2.jpg\"/></a></p><p>当热气腾腾的饺子呈现在大家眼前，喜悦之情洋溢在每个人的脸上。大家品尝着自己亲手包的饺子，享受着这份香甜与美味。</p><p><a href=\"https://www.yanglaocn.com/images/upload/img/2023/12_25/2ae16807015552b0a792524a123b5503.jpg\" target=\"_blank\"><img alt=\"冬至吃饺子，九九养老•玖悦颐养中心陪你过一个温暖的节日！\" src=\"https://www.yanglaocn.com/images/upload/img/2023/12_25/2ae16807015552b0a792524a123b5503.jpg\"/></a></p><p><a href=\"https://www.yanglaocn.com/images/upload/img/2023/12_25/f786d44ee3ef52f2f65d562458660c10.jpg\" target=\"_blank\"><img alt=\"冬至吃饺子，九九养老•玖悦颐养中心陪你过一个温暖的节日！\" src=\"https://www.yanglaocn.com/images/upload/img/2023/12_25/f786d44ee3ef52f2f65d562458660c10.jpg\"/></a></p><p>为了讨个好彩头，长者们在饺子中还放入红枣、紫薯等馅料，包成幸运甜饺子，吃到这个甜饺子的人运气是非同一般的，寓意新的一年生活甜蜜蜜。</p><p>人间小团圆，冬至大如年。小小的饺子，包进去的是情感，吃出来的是幸福。</p>', 'http://localhost:9090/files/1705028322504-1caee21e187f3e929fd4bbdb8151c19b.jpg', '2023-12-28 21:57:55', '22', '养老动态');
INSERT INTO `news` VALUES ('3', '西乡街道麻布社区开展“抗压有方”麻布社区长者慢病管理小组活动', '“群众利益无小事,慢病防控是大事”，为了满足长者对于慢病健康知识的需求，且有利于其日常健康的自我管理', '<p>群众利益无小事,慢病防控是大事”，为了满足长者对于慢病健康知识的需求，且有利于其日常健康的自我管理，12月5日至12月15日，尚德驻麻布社区党群服务中心社工开展了麻布社区新时代文明实践站活动暨“抗压有方”麻布社区长者慢病管理小组，本次小组共吸引了72人次长者报名参与，旨在通过多种方式为长者群体传递健康知识，为其提供一个学习的平台。</p><p><a href=\"https://www.yanglaocn.com/images/upload/img/2023/12_15/5536edd7425402538bf69948b4208358.jpg\" target=\"_blank\"><img alt=\"西乡街道麻布社区开展“抗压有方”麻布社区长者慢病管理小组活动\" src=\"https://www.yanglaocn.com/images/upload/img/2023/12_15/5536edd7425402538bf69948b4208358.jpg\"/></a></p><p>小组初期，社工引导长者们通过自我介绍加深彼此间的认识，了解相互间目前的身体情况，并制定小组契约，促进小组顺利开展。</p><p>在小组过程中，社工通过邀请医师为组员们讲解防治高血压知识及防治脑卒中知识，如何正确使用血压仪，社工带领组员们做手指保健操，宣传宝安区居民高血压防治惠民政策，手工制作艾草锤等多种方式，让组员们学习的形式丰富多彩，多方面加深防治慢性病的重要性，重视慢病带给生活的影响。</p><p><a href=\"https://www.yanglaocn.com/images/upload/img/2023/12_15/974dbaf1d9988c57345f676b4ae7f8b1.jpg\" target=\"_blank\"><img alt=\"西乡街道麻布社区开展“抗压有方”麻布社区长者慢病管理小组活动\" src=\"https://www.yanglaocn.com/images/upload/img/2023/12_15/974dbaf1d9988c57345f676b4ae7f8b1.jpg\"/></a></p><p>小组最后，社工与组员们一同回忆学习到的内容，温故而知新，巩固慢病防治知识，邀请组员们分享参与小组的感受，“这个小组很多实用的东西，比如那个手指操，做一下身体都热乎起来了，我们走在路上手都会不自觉的按一按，虽然我高血压不算太严重，也确实需要重视，希望多多举行这种活动”，有位组员感慨道。</p><p><a href=\"https://www.yanglaocn.com/images/upload/img/2023/12_15/e231342d88223ed9ea94c33788aa43b0.jpg\" target=\"_blank\"><img alt=\"西乡街道麻布社区开展“抗压有方”麻布社区长者慢病管理小组活动\" src=\"https://www.yanglaocn.com/images/upload/img/2023/12_15/e231342d88223ed9ea94c33788aa43b0.jpg\"/></a></p>', 'http://localhost:9090/files/1705028322504-1caee21e187f3e929fd4bbdb8151c19b.jpg', '2023-12-28 21:59:31', '67', '养老动态');
INSERT INTO `news` VALUES ('4', '【最新】2023年杭州高龄老人生活津贴标准调整啦', '高龄老人生活津贴标准调整啦', '<p>2023年3月1日杭州市民政局、财政局印发《<a href=\"https://www.yanglaocn.com/shtml/20230306/1678063521140241.html\" target=\"_blank\">关于调整全市高龄老人生活津贴发放标准的通知</a>》，自2023年3月1日起，杭州市高龄老人生活津贴发放标准调整如下：</p><p><strong>1、100周岁（含）以上老人的高龄津贴由原每人每月300元提高到每人每月800元；</strong></p><p><strong>2、80（含）—99周岁老人高龄津贴按照省市相关标准执行。</strong></p><p>3、本标准自2023年3月1日起施行（2023年1月1日至2023年2月28日期间按本通知相关标准执行）。</p>', 'http://localhost:9090/files/1705028322504-1caee21e187f3e929fd4bbdb8151c19b.jpg', '2023-12-28 22:00:14', '12', '养老政策');
INSERT INTO `news` VALUES ('5', '社区养老服务中心在并建成', '该中心是由省、太原市、迎泽区三级政府提供支持的公益项目，是迎泽区城镇社区幸福养老工程。中心划分为大客厅、社区课堂等8个功能区，可为老人提供多项服务。', '<p>蝴蝶型的餐桌、舒适的室温、可自由操控的座椅……1月9日，记者走进位于太原三晋国际饭店三层的迎泽区南官坊社区养老服务中心时，顿时感受到这里对老年人细致入微的关爱。该中心于2020年12月30日开始试运营，占地2600平方米，是我省已获批的30个城镇社区幸福养老工程中面积最大、设施和服务项目最完备的养老服务示范中心。</p><p>该中心是由省、太原市、迎泽区三级政府提供支持的公益项目，是迎泽区城镇社区幸福养老工程。中心划分为大客厅、社区课堂等8个功能区，可为老人提供多项服务。</p><p>根据我省2020年9月下发的《关于支持社区居家养老服务发展的意见》，到2022年，将以太原为标杆，基本实现每个社区具有一处社区养老服务站（点）。目前，太原市已建成7处城区重点养老服务示范中心。</p><p>据悉，该中心运营主体为太原市三晋大厦有限公司，老人们的活动场所为公司自有，工作人员为酒店员工，人工成本由酒店承担。“目前，中心日接待量可达到150人，配有25辆送餐车，加上居家上门服务项目，可辐射到迎泽区桥东和迎泽两个街道，为老人们晚年幸福生活提供帮助。”该中心负责人宋小霞说。</p>', 'http://localhost:9090/files/1705028354738-微信截图_20231230112730.png', '2023-12-29 16:25:57', '27', '居家养老');
INSERT INTO `news` VALUES ('6', '新型养老模式造福老人：以前再麻烦的事，有了他们，也能解决了', '身患重病、行动不便的94岁老人，被家人抬到银行，搀扶着到网点完成人脸识别，仅仅为了激活社保卡；黑龙江哈尔滨市的一辆公交车上，一位白发苍苍的老人因为没带手机，不会扫码，被车上众多乘客斥责；老人冒雨用现金交医保被拒绝……一幅幅心酸的画面让我们关注到了数字时代的弱势群体——老年人。', '<p>在数字时代下，全民科技进步，但对于老年人来说，很多事情却变成了“麻烦”，如果期望老人像年轻人一样，完全掌握当下的电子信息化生活，并不现实，那么如果能为老年人提供更贴心、更直接的服务，让老人不至于被大踏步的新社会“抛弃”，已经成为刻不容缓的事情。</p><p>这个时候，就不得不提一下我国飞速发展的<a href=\"http://www.yanglaocn.com/shtml/juhe/yanglaoxingye_183.html\" target=\"_blank\">养老行业</a>，“十三五”以来，我国<a href=\"http://www.yanglaocn.com/yanglaoyuan/yanglaofuwu/\" target=\"_blank\">养老服务</a>事业取得全方位进步。各种新型的<a href=\"http://www.yanglaocn.com/ylzx/qitamoshi/\" target=\"_blank\">养老模式</a>正展开“双臂”准备拥抱更多需要帮助的老人们。</p><p><a href=\"http://www.yanglaocn.com/images/upload/img/2021/01_29/7502a2783f3e22e761cfabb16b8a2820.png\" target=\"_blank\"><img alt=\"新型养老模式造福老人：以前再麻烦的事，有了他们，也能解决了\" src=\"http://www.yanglaocn.com/images/upload/img/2021/01_29/7502a2783f3e22e761cfabb16b8a2820.png\"/></a></p><p>小福想跟大家介绍一下<a href=\"http://www.yanglaocn.com/jjyl\" target=\"_blank\">居家养老</a>这个新型的养老模式。它是指以家庭为核心、以社区为依托、以专业化服务为依靠，由经过专业培训的服务人员上门，为居住在家的老年人提供以解决日常生活困难为主要内容的社会化服务。</p><p>用通俗一点的话就是，购买上门到家的养老服务。他们可以做到日常的生活起居照料，如做饭洗衣保洁等，也可以为有慢性疾病，或半自理、失能等老人，提供<a href=\"http://www.yanglaocn.com/jjyl/kangfuhuli/\" target=\"_blank\">康复护理</a>服务。形式似乎和保姆有点相似，但不同的是，居家养老的服务人员，是必须经过专业培训的。</p><p><a href=\"http://www.yanglaocn.com/images/upload/img/2021/01_29/6f0058ff2225d59f2f83c8c863289df0.png\" target=\"_blank\"><img alt=\"新型养老模式造福老人：以前再麻烦的事，有了他们，也能解决了\" src=\"http://www.yanglaocn.com/images/upload/img/2021/01_29/6f0058ff2225d59f2f83c8c863289df0.png\"/></a></p><p>而这样便捷的居家养老服务，有不少地区的老人已经体验上了。“打个电话，就可预约居家清洁、康复护理等上门服务。”79岁的陈长征老人说。“一日三餐也不用操心，他们直接上门来帮我做好，碗都不要我洗。”</p><p>这样一来，老人既能享受到专业的、与<a href=\"http://www.yanglaocn.com/yanglaoyuan/yly/\" target=\"_blank\">养老院</a>一样的<a href=\"http://www.yanglaocn.com/shtml/juhe/yanglaohuli_182.html\" target=\"_blank\">养老护理</a>服务，又不需要离开家，离开自己熟悉的环境和朋友，子女也不用担心老人独居无人照料，可以安心上班，节假日回家还能好好和老人团聚。</p><p><a href=\"http://www.yanglaocn.com/images/upload/img/2021/01_29/4b422dda90def36f18d334f67761d844.png\" target=\"_blank\"><img alt=\"新型养老模式造福老人：以前再麻烦的事，有了他们，也能解决了\" src=\"http://www.yanglaocn.com/images/upload/img/2021/01_29/4b422dda90def36f18d334f67761d844.png\"/></a></p><p>生活照料、康复护理等居家社区养老服务普遍开展；养老与医疗、健康、信息技术等产业融合发展，业态不断创新；从居家、社区到机构，从公办到民办，多元化、多层次养老服务供给体系初步形成，老年人的获得感、幸福感、安全感明显提升。</p><p>而居家养老所体现的好处，还并不止在老人的日常生活照料上，文章一开头我们就有讲到，现代生活，很多看似智能化的设置，但对老人来说却显复杂，老人自己是很难办到的。但这些事情，只要有人帮忙，是完全可以解决，甚至是避免的。</p><p><a href=\"http://www.yanglaocn.com/images/upload/img/2021/01_29/64f37c1f1ff8d9da4e337803f0bd8cf0.png\" target=\"_blank\"><img alt=\"新型养老模式造福老人：以前再麻烦的事，有了他们，也能解决了\" src=\"http://www.yanglaocn.com/images/upload/img/2021/01_29/64f37c1f1ff8d9da4e337803f0bd8cf0.png\"/></a></p><p>居家养老服务不止提供上门服务，也可以陪同老人外出，不管是外出买菜，还是办事都可陪同前往，文章开头老人所遇到的困境，其实如果有个居家养老的工作人员在旁陪同，及时给予老人帮助，也就不会有那么多麻烦发生了。这样的养老新模式，您愿意尝试吗？</p>', 'http://localhost:9090/files/1705028322504-1caee21e187f3e929fd4bbdb8151c19b.jpg', '2023-12-29 16:27:35', '56', '养老产业');
INSERT INTO `news` VALUES ('7', '特困老人的“温暖使者”', '记沭阳县贤官镇敬老院院长杨光来', '<p>“大娘，我又来看您啦！”每月16日，是沭阳县万匹乡丁蒋村姜根英老人“家访”的日子，走进院里的是一位身材魁悟的中年汉子，他一边招呼同来的人打扫院子、整理被褥、洗衣服，一边为老人洗头、聊家常……</p><p>“这位‘家访’的老哥叫杨光来，是沭阳县万匹乡敬老院院长。”姜根英老人说，“自己82岁了，有个残疾儿子，平时弄口饭吃还凑合，打扫卫生就吃力了，幸好县里搞高龄老人上门照料服务，杨院长他们每月都会来家里服务，还带儿子洗澡，为我减轻了一大负担。”</p><p>“从月初开始，我都会带着服务员，为全乡74户80岁以上高龄老人提供日间照料服务，每次服务时间不少于1个工时，一般每天要‘走访’5、6户老人”。杨光来说，“如今农村高龄困难老人比较多，更需要有人陪伴、照顾。”</p><p><strong>二</strong></p><p>2016年2月，沭阳县万匹乡蔡庄村党支部书记杨光来，接到乡党委调令，辞去村支部书记职务，担任乡敬老院院长。“自己曾是4000多人口、90多位党员的“村支”两委带头人，以后要服务30多位老弱病残的孤寡老人，顿觉肩上的担子有千钧重”。很快，杨光来还是信心满满地上任了。</p><p>杨光来没到敬老院之前，就听说这里有“三差”——吃的差、住的差、服务差，这让那些想进敬老院生活的老人普遍存在畏惧心理。看着老人期盼的眼神和斑剥的院墙，杨光来下定决心对敬老院升级改造。</p><p>万匹敬老院原是由一所学校改建的，设施老旧，墙体脱落，仅有的供暖设备还是上世纪的产品。杨光来多次跑乡政府、跑县民政局，敬老院改造资金终于有了着落……做外墙防水、刷乳胶漆，修葺路面、改造老旧线路，更换门窗，铺设防滑地砖，仅一年多时间，呈现在眼前的是一处粉墙碧瓦、温馨优雅的新院落。尤其是每位老人都分到了宽敞明亮的宿舍，有了干净舒适的床位和私人空间，这让老人倍受尊重和关怀。</p><p>在饮食方面，做到每餐荤素搭配，营养均衡，一周不重样，努力让老人吃饱吃好，对患有糖尿病、高血压的老人，为他们“开小灶”、定制“个性化食谱”，并提醒他们按时服药，注意适当运动。</p><p>老人的伙食有了明显改善后，杨光来又在丰富老人精神生活上动起脑筋，通过联系志愿者服务队，定期来院里开展关爱活动，为老人理发、剪指甲、搞演出、开茶话会，让老人们感受到了久违的温暖和热闹。杨光来有一个记事本，那上面准确地记着30多位老人的生日，每逢老人生日，他都会买来蛋糕、送上祝福，让老人心里暖暖的，时刻感受到党和政府关心、关爱。</p><p><strong>三</strong></p><p>相比“杨院长”，杨光来更喜欢老人和同事叫他“杨大哥”、“杨老弟”，因为在他心里，早把这些老人视为父母、兄长。“院里的老人大多是苦命人，他们无儿无女，如今到了晚年，更需要我们的关心和照顾”。杨光来没有院长“架子”，却有一颗火热的心，工作中身先士卒，不怕苦累不嫌脏，深受老人和服务人员的信任、爱戴。</p><p>2012年进院的张发成老人，患有脑梗，不能自理，因大小便失禁、身体有异味，经常被其他老人嫌弃。杨光来每天亲自为他擦洗身体、换床单，并劝导其他老人包容他。经过一段时间康复，老人的症状明显好转，心情也开朗了许多。</p><p>82岁的仇立新老人，2020年5月因患脑梗入院治疗两月后回敬老院，大便干结排不出，看着老人痛苦的样子，杨光来二话没说，戴上手套一点点地抠……最终帮老人正常排便，饱受病痛的老人虽然不能说话，还是流下了感激的泪水。</p><p>今年75岁的葛巨青老人，患静脉曲张，不能行走。杨光来听说有一种药膏效果不错，就亲自买来，每天为老人换药、上药，经过几个疗程的治疗，老人竟能一个人上下楼梯……“要不是杨院长，我也许早死了”。 老人逢人就夸是杨院长救了自己。</p><p>2020年春节前夕，突发新冠肺炎疫情，为确保在院老人的生命健康安全，杨光来吃住在院里，第一时间做好封闭化管理，每天组织防疫消毒，为老人测量体温并做好核酸检测，同时积极做好老人心理疏导工作，缓解焦虑情绪，两个月下来没有回过一次家。</p>', 'http://localhost:9090/files/1705028348560-1ab710e2b541778e94fc822a3dab3dbb.jpg', '2023-12-29 16:28:55', '13', '养老动态');
INSERT INTO `news` VALUES ('8', '市卫生健康委领导参观历城区养老服务中心，肯定医养结合服务内容', '市医养健康产业协会“暖冬敬老”系列活动走进历城区养老服务中心，省市卫健领导、协会相关领导参加了此次活动。在现场举行的慰问捐赠仪式上，省卫生健康委中医产业处向养老中心赠送了老年人营养膳食指南等书籍，协会也为中心长者带来了米面粮油等生活物资。此外，还开展了老年营养保健讲座和公益诊疗活动，受到了中心长者的热烈欢迎。历城区养老服务中心将继续提供优质医养结合专业服务，为在住长者打造高品质晚年生活。', '<p style=\"text-align:left;\">情暖寒冬，关爱老人。为进一步弘扬尊老、敬老、爱老的传统美德，做好老年人医疗服务，传播健康理念，12月26日，省市卫健领导、济南市医养健康产业协会“暖冬敬老”系列活动走进历城区养老服务中心。山东省卫生健康委中医产业处处长王萱、济南市卫生健康委医养健康处二级调研员王芝美、历城区卫健局、济南市第三人民医院及等协会相关领导等参加活动。现场举行了“暖冬敬老”慰问捐赠仪式、开展了老年营养保健讲座及市立三院的公益诊疗活动。</p><p><br/></p><p style=\"text-align:center;\"><a href=\"https://www.yanglaocn.com/images/upload/img/2023/12_27/385e9b0762a44d5ff68aeb75e9bc8b41.jpg\" target=\"_blank\"><img alt=\"市卫生健康委领导参观历城区养老服务中心，肯定医养结合服务内容\" src=\"https://www.yanglaocn.com/images/upload/img/2023/12_27/385e9b0762a44d5ff68aeb75e9bc8b41.jpg\"/></a></p><p style=\"text-align:left;\"><br/></p><p style=\"text-align:left;\">领导一行参观了养老中心各功能区域，深入了解了中心医疗保健、康复护理、中医理疗、认知照护等医养结合服务内容，并对中心医疗设施设备及专业化服务给予充分肯定。</p><p><br/></p><p style=\"text-align:center;\"><a href=\"https://www.yanglaocn.com/images/upload/img/2023/12_27/9ae65ee1a52ec263b44b1fdb2bd64bd5.jpg\" target=\"_blank\"><img alt=\"市卫生健康委领导参观历城区养老服务中心，肯定医养结合服务内容\" src=\"https://www.yanglaocn.com/images/upload/img/2023/12_27/9ae65ee1a52ec263b44b1fdb2bd64bd5.jpg\"/></a></p><p style=\"text-align:left;\"><br/></p><p style=\"text-align:left;\">参观结束在中心举行“暖冬敬老”慰问捐赠仪式，山东省卫生健康委中医产业处给养老中心赠送了老年人营养膳食指南等书籍，协会为中心长者送来米面粮油等生活物资，不仅强化了入住老人的物质生活保障，更丰富了长者的精神文化生活。</p><p><br/></p><p style=\"text-align:center;\"><a href=\"https://www.yanglaocn.com/images/upload/img/2023/12_27/9d0adada38674523476037b919b6fb3d.jpg\" target=\"_blank\"><img alt=\"市卫生健康委领导参观历城区养老服务中心，肯定医养结合服务内容\" src=\"https://www.yanglaocn.com/images/upload/img/2023/12_27/9d0adada38674523476037b919b6fb3d.jpg\"/></a></p><p style=\"text-align:left;\"><br/></p><p style=\"text-align:left;\">“暖冬敬老”活动现场，济南市第三人民医院副主任医师杨其军为中心在住长者带来老年营养保健讲座，现场普及营养与健康知识，有效增强老年人的健康意识和自我保健能力，养成健康、文明、科学的生活习惯，预防和延缓疾病的发生和发展，提升生命质量。</p><p><br/></p><p style=\"text-align:center;\"><a href=\"https://www.yanglaocn.com/images/upload/img/2023/12_27/5ceeeec97d0141bb41e769df8532318b.jpg\" target=\"_blank\"><img alt=\"市卫生健康委领导参观历城区养老服务中心，肯定医养结合服务内容\" src=\"https://www.yanglaocn.com/images/upload/img/2023/12_27/5ceeeec97d0141bb41e769df8532318b.jpg\"/></a></p><p style=\"text-align:left;\"><br/></p><p style=\"text-align:left;\">市立三院为中心长者提供义诊服务，心血管内科、神经外科、脊柱外科、心血管内科、泌尿外科、中医科等科室医师现场为长者们进行了生命体征测量等医疗诊断服务，并将移动医疗车开进养老中心，给老人做CT、B超检查，耐心倾听长者各类问题，给予专业的建议和解答，受到中心长者们的一致欢迎。</p><p><br/></p><p style=\"text-align:center;\"><a href=\"https://www.yanglaocn.com/images/upload/img/2023/12_27/8f45ff5fae34b96c43f554147ee6b975.jpg\" target=\"_blank\"><img alt=\"市卫生健康委领导参观历城区养老服务中心，肯定医养结合服务内容\" src=\"https://www.yanglaocn.com/images/upload/img/2023/12_27/8f45ff5fae34b96c43f554147ee6b975.jpg\"/></a></p><p style=\"text-align:center;\"><a href=\"https://www.yanglaocn.com/images/upload/img/2023/12_27/26a675fd016e44ef3e6d024a81d6f58b.jpg\" target=\"_blank\"><img alt=\"市卫生健康委领导参观历城区养老服务中心，肯定医养结合服务内容\" src=\"https://www.yanglaocn.com/images/upload/img/2023/12_27/26a675fd016e44ef3e6d024a81d6f58b.jpg\"/></a></p><p style=\"text-align:left;\"><br/></p><p style=\"text-align:left;\">此次“暖冬敬老”活动是济南市医养健康产业协会各级领导关心关注老年群体、践行爱老初心的有力实践。历城区养老服务中心负责人表示，中心将用优质的医养结合专业服务，让入住长者老有所养、老有所医，为在住长者持续打造高品质晚年生活。</p><p><br/></p><p style=\"text-align:center;\"><a href=\"https://www.yanglaocn.com/images/upload/img/2023/12_27/8799a30e1062421e00e2bae5f634bfbc.jpg\" target=\"_blank\"><img alt=\"市卫生健康委领导参观历城区养老服务中心，肯定医养结合服务内容\" src=\"https://www.yanglaocn.com/images/upload/img/2023/12_27/8799a30e1062421e00e2bae5f634bfbc.jpg\"/></a></p><p style=\"text-align:center;\"><a href=\"https://www.yanglaocn.com/images/upload/img/2023/12_13/885e29bf31d55a7065303bc7dff2f2c3.png\" target=\"_blank\"><img src=\"https://www.yanglaocn.com/images/upload/img/2023/12_13/885e29bf31d55a7065303bc7dff2f2c3.png\"/></a></p>', 'http://localhost:9090/files/1705028342900-1caee21e187f3e929fd4bbdb8151c19b.jpg', '2023-12-29 16:30:06', '15', '养老政策');
INSERT INTO `news` VALUES ('9', '特困老人的“温暖使者”', '记沭阳县贤官镇敬老院院长杨光来', '<p>“大娘，我又来看您啦！”每月16日，是沭阳县万匹乡丁蒋村姜根英老人“家访”的日子，走进院里的是一位身材魁悟的中年汉子，他一边招呼同来的人打扫院子、整理被褥、洗衣服，一边为老人洗头、聊家常……</p><p>“这位‘家访’的老哥叫杨光来，是沭阳县万匹乡敬老院院长。”姜根英老人说，“自己82岁了，有个残疾儿子，平时弄口饭吃还凑合，打扫卫生就吃力了，幸好县里搞高龄老人上门照料服务，杨院长他们每月都会来家里服务，还带儿子洗澡，为我减轻了一大负担。”</p><p>“从月初开始，我都会带着服务员，为全乡74户80岁以上高龄老人提供日间照料服务，每次服务时间不少于1个工时，一般每天要‘走访’5、6户老人”。杨光来说，“如今农村高龄困难老人比较多，更需要有人陪伴、照顾。”</p><p><strong>二</strong></p><p>2016年2月，沭阳县万匹乡蔡庄村党支部书记杨光来，接到乡党委调令，辞去村支部书记职务，担任乡敬老院院长。“自己曾是4000多人口、90多位党员的“村支”两委带头人，以后要服务30多位老弱病残的孤寡老人，顿觉肩上的担子有千钧重”。很快，杨光来还是信心满满地上任了。</p><p>杨光来没到敬老院之前，就听说这里有“三差”——吃的差、住的差、服务差，这让那些想进敬老院生活的老人普遍存在畏惧心理。看着老人期盼的眼神和斑剥的院墙，杨光来下定决心对敬老院升级改造。</p><p>万匹敬老院原是由一所学校改建的，设施老旧，墙体脱落，仅有的供暖设备还是上世纪的产品。杨光来多次跑乡政府、跑县民政局，敬老院改造资金终于有了着落……做外墙防水、刷乳胶漆，修葺路面、改造老旧线路，更换门窗，铺设防滑地砖，仅一年多时间，呈现在眼前的是一处粉墙碧瓦、温馨优雅的新院落。尤其是每位老人都分到了宽敞明亮的宿舍，有了干净舒适的床位和私人空间，这让老人倍受尊重和关怀。</p><p>在饮食方面，做到每餐荤素搭配，营养均衡，一周不重样，努力让老人吃饱吃好，对患有糖尿病、高血压的老人，为他们“开小灶”、定制“个性化食谱”，并提醒他们按时服药，注意适当运动。</p><p>老人的伙食有了明显改善后，杨光来又在丰富老人精神生活上动起脑筋，通过联系志愿者服务队，定期来院里开展关爱活动，为老人理发、剪指甲、搞演出、开茶话会，让老人们感受到了久违的温暖和热闹。杨光来有一个记事本，那上面准确地记着30多位老人的生日，每逢老人生日，他都会买来蛋糕、送上祝福，让老人心里暖暖的，时刻感受到党和政府关心、关爱。</p><p><strong>三</strong></p><p>相比“杨院长”，杨光来更喜欢老人和同事叫他“杨大哥”、“杨老弟”，因为在他心里，早把这些老人视为父母、兄长。“院里的老人大多是苦命人，他们无儿无女，如今到了晚年，更需要我们的关心和照顾”。杨光来没有院长“架子”，却有一颗火热的心，工作中身先士卒，不怕苦累不嫌脏，深受老人和服务人员的信任、爱戴。</p><p>2012年进院的张发成老人，患有脑梗，不能自理，因大小便失禁、身体有异味，经常被其他老人嫌弃。杨光来每天亲自为他擦洗身体、换床单，并劝导其他老人包容他。经过一段时间康复，老人的症状明显好转，心情也开朗了许多。</p><p>82岁的仇立新老人，2020年5月因患脑梗入院治疗两月后回敬老院，大便干结排不出，看着老人痛苦的样子，杨光来二话没说，戴上手套一点点地抠……最终帮老人正常排便，饱受病痛的老人虽然不能说话，还是流下了感激的泪水。</p><p>今年75岁的葛巨青老人，患静脉曲张，不能行走。杨光来听说有一种药膏效果不错，就亲自买来，每天为老人换药、上药，经过几个疗程的治疗，老人竟能一个人上下楼梯……“要不是杨院长，我也许早死了”。 老人逢人就夸是杨院长救了自己。</p><p>2020年春节前夕，突发新冠肺炎疫情，为确保在院老人的生命健康安全，杨光来吃住在院里，第一时间做好封闭化管理，每天组织防疫消毒，为老人测量体温并做好核酸检测，同时积极做好老人心理疏导工作，缓解焦虑情绪，两个月下来没有回过一次家。</p>', 'http://localhost:9090/files/1705028338439-a4afbc43e1fec158d2e8c3c1df86cca9.png', '2023-12-29 16:28:55', '243', '养老动态');
INSERT INTO `news` VALUES ('10', '市卫生健康委领导参观历城区养老服务中心，肯定医养结合服务内容', '市医养健康产业协会“暖冬敬老”系列活动走进历城区养老服务中心，省市卫健领导、协会相关领导参加了此次活动。在现场举行的慰问捐赠仪式上，省卫生健康委中医产业处向养老中心赠送了老年人营养膳食指南等书籍，协会也为中心长者带来了米面粮油等生活物资。此外，还开展了老年营养保健讲座和公益诊疗活动，受到了中心长者的热烈欢迎。历城区养老服务中心将继续提供优质医养结合专业服务，为在住长者打造高品质晚年生活。', '<p style=\"text-align:left;\">情暖寒冬，关爱老人。为进一步弘扬尊老、敬老、爱老的传统美德，做好老年人医疗服务，传播健康理念，12月26日，省市卫健领导、济南市医养健康产业协会“暖冬敬老”系列活动走进历城区养老服务中心。山东省卫生健康委中医产业处处长王萱、济南市卫生健康委医养健康处二级调研员王芝美、历城区卫健局、济南市第三人民医院及等协会相关领导等参加活动。现场举行了“暖冬敬老”慰问捐赠仪式、开展了老年营养保健讲座及市立三院的公益诊疗活动。</p><p><br/></p><p style=\"text-align:center;\"><a href=\"https://www.yanglaocn.com/images/upload/img/2023/12_27/385e9b0762a44d5ff68aeb75e9bc8b41.jpg\" target=\"_blank\"><img alt=\"市卫生健康委领导参观历城区养老服务中心，肯定医养结合服务内容\" src=\"https://www.yanglaocn.com/images/upload/img/2023/12_27/385e9b0762a44d5ff68aeb75e9bc8b41.jpg\"/></a></p><p style=\"text-align:left;\"><br/></p><p style=\"text-align:left;\">领导一行参观了养老中心各功能区域，深入了解了中心医疗保健、康复护理、中医理疗、认知照护等医养结合服务内容，并对中心医疗设施设备及专业化服务给予充分肯定。</p><p><br/></p><p style=\"text-align:center;\"><a href=\"https://www.yanglaocn.com/images/upload/img/2023/12_27/9ae65ee1a52ec263b44b1fdb2bd64bd5.jpg\" target=\"_blank\"><img alt=\"市卫生健康委领导参观历城区养老服务中心，肯定医养结合服务内容\" src=\"https://www.yanglaocn.com/images/upload/img/2023/12_27/9ae65ee1a52ec263b44b1fdb2bd64bd5.jpg\"/></a></p><p style=\"text-align:left;\"><br/></p><p style=\"text-align:left;\">参观结束在中心举行“暖冬敬老”慰问捐赠仪式，山东省卫生健康委中医产业处给养老中心赠送了老年人营养膳食指南等书籍，协会为中心长者送来米面粮油等生活物资，不仅强化了入住老人的物质生活保障，更丰富了长者的精神文化生活。</p><p><br/></p><p style=\"text-align:center;\"><a href=\"https://www.yanglaocn.com/images/upload/img/2023/12_27/9d0adada38674523476037b919b6fb3d.jpg\" target=\"_blank\"><img alt=\"市卫生健康委领导参观历城区养老服务中心，肯定医养结合服务内容\" src=\"https://www.yanglaocn.com/images/upload/img/2023/12_27/9d0adada38674523476037b919b6fb3d.jpg\"/></a></p><p style=\"text-align:left;\"><br/></p><p style=\"text-align:left;\">“暖冬敬老”活动现场，济南市第三人民医院副主任医师杨其军为中心在住长者带来老年营养保健讲座，现场普及营养与健康知识，有效增强老年人的健康意识和自我保健能力，养成健康、文明、科学的生活习惯，预防和延缓疾病的发生和发展，提升生命质量。</p><p><br/></p><p style=\"text-align:center;\"><a href=\"https://www.yanglaocn.com/images/upload/img/2023/12_27/5ceeeec97d0141bb41e769df8532318b.jpg\" target=\"_blank\"><img alt=\"市卫生健康委领导参观历城区养老服务中心，肯定医养结合服务内容\" src=\"https://www.yanglaocn.com/images/upload/img/2023/12_27/5ceeeec97d0141bb41e769df8532318b.jpg\"/></a></p><p style=\"text-align:left;\"><br/></p><p style=\"text-align:left;\">市立三院为中心长者提供义诊服务，心血管内科、神经外科、脊柱外科、心血管内科、泌尿外科、中医科等科室医师现场为长者们进行了生命体征测量等医疗诊断服务，并将移动医疗车开进养老中心，给老人做CT、B超检查，耐心倾听长者各类问题，给予专业的建议和解答，受到中心长者们的一致欢迎。</p><p><br/></p><p style=\"text-align:center;\"><a href=\"https://www.yanglaocn.com/images/upload/img/2023/12_27/8f45ff5fae34b96c43f554147ee6b975.jpg\" target=\"_blank\"><img alt=\"市卫生健康委领导参观历城区养老服务中心，肯定医养结合服务内容\" src=\"https://www.yanglaocn.com/images/upload/img/2023/12_27/8f45ff5fae34b96c43f554147ee6b975.jpg\"/></a></p><p style=\"text-align:center;\"><a href=\"https://www.yanglaocn.com/images/upload/img/2023/12_27/26a675fd016e44ef3e6d024a81d6f58b.jpg\" target=\"_blank\"><img alt=\"市卫生健康委领导参观历城区养老服务中心，肯定医养结合服务内容\" src=\"https://www.yanglaocn.com/images/upload/img/2023/12_27/26a675fd016e44ef3e6d024a81d6f58b.jpg\"/></a></p><p style=\"text-align:left;\"><br/></p><p style=\"text-align:left;\">此次“暖冬敬老”活动是济南市医养健康产业协会各级领导关心关注老年群体、践行爱老初心的有力实践。历城区养老服务中心负责人表示，中心将用优质的医养结合专业服务，让入住长者老有所养、老有所医，为在住长者持续打造高品质晚年生活。</p><p><br/></p><p style=\"text-align:center;\"><a href=\"https://www.yanglaocn.com/images/upload/img/2023/12_27/8799a30e1062421e00e2bae5f634bfbc.jpg\" target=\"_blank\"><img alt=\"市卫生健康委领导参观历城区养老服务中心，肯定医养结合服务内容\" src=\"https://www.yanglaocn.com/images/upload/img/2023/12_27/8799a30e1062421e00e2bae5f634bfbc.jpg\"/></a></p><p style=\"text-align:center;\"><a href=\"https://www.yanglaocn.com/images/upload/img/2023/12_13/885e29bf31d55a7065303bc7dff2f2c3.png\" target=\"_blank\"><img src=\"https://www.yanglaocn.com/images/upload/img/2023/12_13/885e29bf31d55a7065303bc7dff2f2c3.png\"/></a></p>', 'http://localhost:9090/files/1705028322504-1caee21e187f3e929fd4bbdb8151c19b.jpg', '2023-12-29 16:30:06', '39', '养老政策');

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '标题',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '内容',
  `time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建时间',
  `user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='公告信息表';

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES ('1', '今天系统正式上线，开始内测', '今天系统正式上线，开始内测', '2023-09-05', 'admin');
INSERT INTO `notice` VALUES ('2', '所有功能都已完成，可以正常使用', '所有功能都已完成，可以正常使用', '2023-09-05', 'admin');
INSERT INTO `notice` VALUES ('3', '今天天气很不错，可以出去一起玩了', '今天天气很不错，可以出去一起玩了。', '2023-09-05', 'admin');
INSERT INTO `notice` VALUES ('4', '春分祝福', '春分快乐', '2024-03-20', 'admin');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `order_no` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '订单编号',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '物品名称',
  `descr` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '描述',
  `img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '物品图片',
  `certificate` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '证书地址',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '物品类型',
  `weight` double(10,2) DEFAULT NULL COMMENT '物品重量',
  `price` int DEFAULT NULL COMMENT '小费',
  `user_id` int DEFAULT NULL COMMENT '发起人ID',
  `accept_id` int DEFAULT NULL COMMENT '接单人ID',
  `serve_time` datetime DEFAULT NULL COMMENT '服务时间',
  `time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建时间',
  `accept_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '接单时间',
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '订单状态',
  `address_id` int DEFAULT NULL COMMENT '取货地址ID',
  `target_id` int DEFAULT NULL COMMENT '送货地址ID',
  `comment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '订单备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='订单信息';

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('19', '1727868740552798208', '买包米', '买包米', 'http://localhost:9090/files/1700790978696-CxCguWQjx8nP7cd21a9de1f499f2a532d7b9cc928f02.png', null, '代拿物品', '0.10', '5', '31', null, '2023-11-24 09:56:24', '2023-11-24 09:56:24', null, '已取消', '8', '7', '热的');
INSERT INTO `orders` VALUES ('20', '1727869169172959232', '扫地', '扫地', 'http://localhost:9090/files/1700791084963-fDmaVRxeLnGd203bfcffb7b80e708090cbdb8fcd671b.png', null, '打扫卫生', '0.20', '5', '2', '31', '2023-11-24 09:56:24', '2023-11-24 09:58:06', '2024-03-21 10:34:36', '已完成', '8', '7', null);
INSERT INTO `orders` VALUES ('21', '1727873257063280640', '高奶奶很无聊，需要陪聊', '高奶奶很无聊，需要陪聊', 'http://localhost:9090/files/1700792058969-KrQtpRLTlh1y21b37635be9790fed814b1f298173089.png', null, '空巢老人陪聊', '0.10', '6', '2', '31', null, '2024-03-21 10:34:36', '2024-03-21 16:23:47', '已完成', '8', '7', '1');
INSERT INTO `orders` VALUES ('22', '1727912858976935936', '擦玻璃', '擦玻璃', 'http://localhost:9090/files/1700801501337-qQNVRmk2Y2jeacb88604e05a527a2e8a5f348549ac51.png', null, '打扫卫生', '1.00', '5', '2', '31', null, '2023-11-24 12:51:43', '2023-11-24 12:51:50', '已完成', '8', '7', '1');
INSERT INTO `orders` VALUES ('23', '1727914789656989696', '楼下买包烟', '楼下买包烟', 'http://localhost:9090/files/1700801931808-00cUgnNoLY2c7d94a44c7f66436ec4e45e0369e4b764.jpg', null, '代拿物品', '0.20', '10', '24', '1', null, '2023-11-24 12:59:23', '2023-11-24 12:59:40', '已取消', '12', '13', '我爱你小雨');
INSERT INTO `orders` VALUES ('24', '1727915204498821120', '楼下买瓶酒', '楼下买瓶酒', 'http://localhost:9090/files/1700802061505-s6M2juhZRGhl650871f9e0db400e0e2b1329ca9049f4.png', null, '代拿物品', '1.00', '6', '31', null, null, '2023-11-24 13:01:02', null, '已取消', '13', '12', '11');
INSERT INTO `orders` VALUES ('25', '1727915386980405248', '李奶奶很无聊，需要陪聊', '李奶奶很无聊，需要陪聊', 'http://localhost:9090/files/1700802104212-SMy1gIojSi61b96dd2c8e1b554ea99f00bf8d8f9e04d.jpg', null, '空巢老人陪聊', '2.00', '6', '24', '31', null, '2024-03-21 10:34:36', '2024-03-21 20:22:23', '已接单', '13', '12', '22');
INSERT INTO `orders` VALUES ('26', '1770763093540904960', 'wp', 'des', null, null, '代拿物品', '1.20', '1', '31', null, null, '2024-03-21 18:43:15', null, '已取消', '16', '15', null);
INSERT INTO `orders` VALUES ('27', '1770764854972424192', 'ww', 'des', null, null, '代拿快递', '11.00', '3', '31', null, null, '2024-03-21 18:50:15', null, '已取消', '16', '15', null);
INSERT INTO `orders` VALUES ('29', '1770787696854216704', '德萨', '多少', null, null, '代拿快递', '1.00', '2', '31', '2', null, '2024-03-21 20:21:01', '2024-03-21 20:27:04', '已完成', '16', '15', null);
INSERT INTO `orders` VALUES ('30', '0x729890bba0441b988b322058dd10b82122ef15f6', 'bt', 'des', null, 'http://localhost:9090/files/1712849070802-0x729890bba0441b988b322058dd10b82122ef15f6.png', '代买零食', '2.00', '0', '32', '31', null, '2024-04-11 22:13:46', '2024-04-11 22:54:54', '已完成', '16', '17', null);

-- ----------------------------
-- Table structure for records
-- ----------------------------
DROP TABLE IF EXISTS `records`;
CREATE TABLE `records` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '事件',
  `money` int DEFAULT NULL COMMENT '金额',
  `user_id` int DEFAULT NULL COMMENT '用户',
  `accept_id` int DEFAULT NULL,
  `time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '时间',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='收支明细';

-- ----------------------------
-- Records of records
-- ----------------------------
INSERT INTO `records` VALUES ('1', '王雨薇充值了10元', '10', '2', '24', '2023-11-16 10:06:55', '发放');
INSERT INTO `records` VALUES ('4', '李四下单支付了10元', '10', '1', '24', '2023-11-16 10:06:55', '公益');
INSERT INTO `records` VALUES ('5', '王雨薇下单外卖', '10', '2', '24', '2023-11-16 10:06:55', '公益');
INSERT INTO `records` VALUES ('6', '王雨薇接单赚了10元', '10', '2', '24', '2023-11-16 10:06:55', '服务');
INSERT INTO `records` VALUES ('8', '下单三明治', '5', '2', '24', '2023-11-24 09:58:06', '公益');
INSERT INTO `records` VALUES ('9', '接单三明治', '5', '1', '24', '2023-11-24 10:01:42', '服务');
INSERT INTO `records` VALUES ('10', '接单三明治', '5', '1', '24', '2023-11-24 10:06:52', '服务');
INSERT INTO `records` VALUES ('11', '取消订单三明治', '5', '2', '24', '2023-11-24 10:06:52', '发放');
INSERT INTO `records` VALUES ('12', '下单咖啡', '6', '2', '24', '2023-11-24 10:14:21', '公益');
INSERT INTO `records` VALUES ('13', '取消订单咖啡', '6', '2', '24', '2023-11-24 10:15:56', '发放');
INSERT INTO `records` VALUES ('14', '充值', '6', '2', '24', '2023-11-24 11:09:03', '发放');
INSERT INTO `records` VALUES ('15', '充值', '18', '2', '24', '2023-11-24 11:09:34', '发放');
INSERT INTO `records` VALUES ('16', '充值', '999', '2', '24', '2023-11-24 11:09:39', '发放');
INSERT INTO `records` VALUES ('17', '下单222', '5', '2', '24', '2023-11-24 12:51:43', '公益');
INSERT INTO `records` VALUES ('18', '接单222', '5', '1', '24', '2023-11-24 12:51:55', '服务');
INSERT INTO `records` VALUES ('19', '下单玫瑰', '10', '15', '24', '2023-11-24 12:59:23', '公益');
INSERT INTO `records` VALUES ('20', '接单玫瑰', '10', '1', '24', '2023-11-24 12:59:47', '服务');
INSERT INTO `records` VALUES ('21', '充值', '18', '15', '24', '2023-11-24 13:00:34', '发放');
INSERT INTO `records` VALUES ('22', '下单111', '6', '15', '24', '2023-11-24 13:01:02', '公益');
INSERT INTO `records` VALUES ('23', '取消订单111', '6', '15', '24', '2023-11-24 13:01:19', '发放');
INSERT INTO `records` VALUES ('24', '下单2222', '6', '15', '24', '2023-11-24 13:01:46', '公益');
INSERT INTO `records` VALUES ('25', '接单2222', '6', '1', '24', '2023-11-24 13:02:19', '服务');
INSERT INTO `records` VALUES ('30', '审核发放', '70', '31', null, '2024-03-21 10:32:17', '发放');
INSERT INTO `records` VALUES ('31', '擦玻璃', '5', '31', null, '2024-03-21 20:24:39', '服务');
INSERT INTO `records` VALUES ('32', '审核发放', '70', '2', null, '2024-03-21 20:26:42', '发放');
INSERT INTO `records` VALUES ('33', '德萨', '2', '2', null, '2024-03-21 20:30:15', '服务');
INSERT INTO `records` VALUES ('34', '高奶奶很无聊，需要陪聊', '6', '2', '31', '2024-03-21 20:44:30', '服务');
INSERT INTO `records` VALUES ('35', '扫地', '5', '2', '31', '2024-03-21 20:44:37', '服务');
INSERT INTO `records` VALUES ('36', '审核发放', '0', '0', '33', '2024-04-10 21:09:09', '发放');
INSERT INTO `records` VALUES ('37', '审核发放', '70', '0', '32', '2024-04-11 22:12:49', '发放');
INSERT INTO `records` VALUES ('38', 'bt', '3', '32', '31', '2024-04-11 22:55:16', '服务');
INSERT INTO `records` VALUES ('39', 'bt', '0', '32', '31', '2024-04-11 23:09:48', '服务');
INSERT INTO `records` VALUES ('40', 'bt', '0', '32', '31', '2024-04-11 23:15:00', '服务');
INSERT INTO `records` VALUES ('41', 'bt', '0', '32', '31', '2024-04-11 23:16:21', '服务');
INSERT INTO `records` VALUES ('42', 'bt', '0', '32', '31', '2024-04-11 23:17:36', '服务');
INSERT INTO `records` VALUES ('43', 'bt', '0', '32', '31', '2024-04-11 23:19:43', '服务');
INSERT INTO `records` VALUES ('44', 'bt', '0', '32', '31', '2024-04-11 23:21:48', '服务');
INSERT INTO `records` VALUES ('45', 'bt', '0', '32', '31', '2024-04-11 23:22:52', '服务');
INSERT INTO `records` VALUES ('46', 'bt', '0', '32', '31', '2024-04-11 23:24:30', '服务');

-- ----------------------------
-- Table structure for reserve
-- ----------------------------
DROP TABLE IF EXISTS `reserve`;
CREATE TABLE `reserve` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `serve_id` int DEFAULT NULL COMMENT '服务ID',
  `user_id` int DEFAULT NULL COMMENT '预约人ID',
  `time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '预约时间',
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '待审核' COMMENT '审核状态',
  `reason` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '审核意见',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='服务预约';

-- ----------------------------
-- Records of reserve
-- ----------------------------
INSERT INTO `reserve` VALUES ('3', '2', '2', '2024-01-18 10:26:00', '审核拒绝', '不行');
INSERT INTO `reserve` VALUES ('4', '1', '3', '2024-01-18 10:26:00', '审核通过', 'OK');
INSERT INTO `reserve` VALUES ('5', '4', '2', '2024-01-18 10:31:07', '审核通过', '可以的');
INSERT INTO `reserve` VALUES ('6', '4', '8', '2024-01-18 11:28:07', '待审核', null);
INSERT INTO `reserve` VALUES ('7', '3', '2', '2024-01-19 10:21:12', '待审核', null);
INSERT INTO `reserve` VALUES ('9', '3', '31', '2024-03-28 14:22:06', '审核通过', null);

-- ----------------------------
-- Table structure for serve
-- ----------------------------
DROP TABLE IF EXISTS `serve`;
CREATE TABLE `serve` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '名称',
  `cover` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '封面',
  `descr` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '服务描述',
  `date` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '发布时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='养老服务';

-- ----------------------------
-- Records of serve
-- ----------------------------
INSERT INTO `serve` VALUES ('1', '社区医疗服务', 'http://localhost:9090/files/1704941949771-微信截图_20231230112220.png', '提供老人血压、血糖、血脂免费检查，提供一般常规项目检查', '2023-12-30');
INSERT INTO `serve` VALUES ('2', '社区维修服务', 'http://localhost:9090/files/1704941938927-微信截图_20231230112820.png', '提供一般小型家用电器维修，手机维修，电子器件维修，家具维修', '2023-12-30');
INSERT INTO `serve` VALUES ('3', '社区心理健康服务', 'http://localhost:9090/files/1704941931018-微信截图_20231230112700.png', '提供心理问题咨询，帮助老人疏导心理障碍，改善老人心理环境', '2023-12-30');
INSERT INTO `serve` VALUES ('4', '社区文化服务', 'http://localhost:9090/files/1704941925339-F2F761BB6C9A388E2A2B78A2F3D60D81.jpg', '提供丰富多彩的文化娱乐活动，包括舞蹈、歌唱比赛、户外跑步等活动', '2023-12-30');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '账号',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '密码',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '姓名',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT 'https://cube.elemecdn.com/9/c2/f0ee8a3c7c9638a54940382568c9dpng.png' COMMENT '头像',
  `role` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '角色',
  `age` int DEFAULT NULL COMMENT '年龄',
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '性别',
  `id_number` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '身份证号',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '电话',
  `account_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '资金账户',
  `weid` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'weid',
  `account` int DEFAULT '0' COMMENT '余额',
  `available_funds` int DEFAULT '0' COMMENT '可用资金',
  `register_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '注册时间',
  `login_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '登录时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `status` tinyint DEFAULT NULL COMMENT '状态：1.正常 2.审核中 3.冻结 4.删除 5.审核未通过',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'abc', '$2a$10$72GVi62S8vBU8IjbIfwQr.HN42DFW8ZMTPrifiR/i0J8wuf8Q9Y4q', '王雨薇', 'http://localhost:9090/files/1700709015974-2GLXt4Nzpr0T99915b5d3c7d49851528fb541fada677.png', 'USER', '65', '男', null, '13766775588', null, null, '50', null, '2024-03-19 21:31:19', '2024-03-19 21:31:19', '2024-03-19 21:31:19', '1');
INSERT INTO `user` VALUES ('2', 'lisi', '$2a$10$PeRR/QbaXYKO04zLq4bbzOFx6yjTt8G8FGeilMlv2iN4z4JRuJHIS', '李四', 'http://localhost:9090/files/1710728549852-1699934583069-微信截图_20231018172208.png', 'USER', '74', '女', null, '123', null, null, '70', '70', '2024-03-21 20:45:17', '2024-03-21 20:45:17', '2024-03-21 20:45:17', '1');
INSERT INTO `user` VALUES ('12', 'aaa7', '$2a$10$72GVi62S8vBU8IjbIfwQr.HN42DFW8ZMTPrifiR/i0J8wuf8Q9Y4q', '李四7', 'http://localhost:9090/files/1710728549852-1699934583069-微信截图_20231018172208.png', 'USER', '74', '女', null, '123', null, null, '70', '70', '2024-03-20 20:24:48', '2024-03-20 20:24:48', '2024-03-20 20:24:48', '1');
INSERT INTO `user` VALUES ('13', 'abc8', '$2a$10$72GVi62S8vBU8IjbIfwQr.HN42DFW8ZMTPrifiR/i0J8wuf8Q9Y4q', '王雨薇8', 'http://localhost:9090/files/1712842001036-1699934583069-微信截图_20231018172208.png', 'USER', '64', '男', '4321', '1234', null, null, '30', '30', '2024-03-20 20:24:35', '2024-03-20 20:24:35', '2024-04-11 21:26:47', '1');
INSERT INTO `user` VALUES ('14', 'aaa9', '$2a$10$72GVi62S8vBU8IjbIfwQr.HN42DFW8ZMTPrifiR/i0J8wuf8Q9Y4q', '李四9', null, 'USER', '59', '男', null, null, null, null, '0', null, '2024-03-19 21:29:33', '2024-03-19 21:29:33', '2024-03-24 15:54:44', '1');
INSERT INTO `user` VALUES ('15', 'abc10', '$2a$10$72GVi62S8vBU8IjbIfwQr.HN42DFW8ZMTPrifiR/i0J8wuf8Q9Y4q', '王雨薇10', null, 'USER', '79', '男', null, null, null, null, '80', '80', '2024-03-20 20:25:03', '2024-03-20 20:25:03', '2024-03-20 20:25:03', '1');
INSERT INTO `user` VALUES ('16', 'aaa11', '$2a$10$72GVi62S8vBU8IjbIfwQr.HN42DFW8ZMTPrifiR/i0J8wuf8Q9Y4q', '李四11', null, 'USER', '80', ' 女', null, null, null, null, '120', '120', '2024-03-20 20:25:06', '2024-03-20 20:25:06', '2024-03-20 20:25:06', '1');
INSERT INTO `user` VALUES ('17', 'abc12', '$2a$10$cMZTOVBbauCC7hEIC1LpVuz8va4SgkRW5LbvjJmjnwA2/LwHOzrCy', '王雨薇12', null, 'USER', null, '男', null, '123', null, null, '1000', null, '2024-03-19 20:43:17', '2024-03-19 20:33:09', '2024-03-19 20:43:17', '1');
INSERT INTO `user` VALUES ('18', 'aaa13', '$10$72GVi62S8vBU8IjbIfwQr.HN42DFW8ZMTPrifiR/i0J8wuf8Q9Y4q', '李四13', null, 'USER', null, '男', null, '123', null, null, '1000', null, '2024-03-19 20:54:30', '2024-03-19 20:54:30', '2024-03-19 20:54:30', '1');
INSERT INTO `user` VALUES ('19', 'abc14', '$2a$10$72GVi62S8vBU8IjbIfwQr.HN42DFW8ZMTPrifiR/i0J8wuf8Q9Y4q', '王雨薇14', null, 'USER', null, '女', null, null, null, null, '1000', null, '2024-04-10 21:13:48', '2024-04-10 21:13:48', '2024-04-10 21:13:48', '1');
INSERT INTO `user` VALUES ('20', 'aaa15', '$2a$10$72GVi62S8vBU8IjbIfwQr.HN42DFW8ZMTPrifiR/i0J8wuf8Q9Y4q', '李四15', null, 'USER', null, '男', null, null, null, null, '1000', null, '2024-04-10 21:13:51', '2024-04-10 21:13:51', '2024-04-10 21:13:51', '1');
INSERT INTO `user` VALUES ('21', 'abc16', '$2a$10$72GVi62S8vBU8IjbIfwQr.HN42DFW8ZMTPrifiR/i0J8wuf8Q9Y4q', '王雨薇16', null, 'USER', null, '男', null, null, null, null, '1000', null, '2024-04-10 21:13:53', '2024-04-10 21:13:53', '2024-04-10 21:13:53', '1');
INSERT INTO `user` VALUES ('22', 'abt', '$2a$10$72GVi62S8vBU8IjbIfwQr.HN42DFW8ZMTPrifiR/i0J8wuf8Q9Y4q', 'abt', 'https://cube.elemecdn.com/9/c2/f0ee8a3c7c9638a54940382568c9dpng.png', 'USER', null, null, null, null, null, null, '1000', null, '2024-03-19 20:01:39', '2024-03-19 20:01:39', '2024-03-19 20:01:39', '1');
INSERT INTO `user` VALUES ('23', 'ccc', '$2a$10$72GVi62S8vBU8IjbIfwQr.HN42DFW8ZMTPrifiR/i0J8wuf8Q9Y4q', 'ccc', 'https://cube.elemecdn.com/9/c2/f0ee8a3c7c9638a54940382568c9dpng.png', 'USER', null, null, null, null, null, null, '1000', null, '2024-03-19 20:01:39', '2024-03-19 20:01:39', '2024-03-19 20:01:39', '1');
INSERT INTO `user` VALUES ('24', 'ddd', '$2a$10$OzdrIw3C7f.JyLH.r9QqruUf8qJdOFIDkT0er4HOrOKsj4k/zZyO2', '李大爷', 'https://cube.elemecdn.com/9/c2/f0ee8a3c7c9638a54940382568c9dpng.png', 'USER', null, null, null, null, null, null, '10006', null, '2024-03-20 19:41:02', '2024-03-20 19:41:02', '2024-03-21 19:30:51', '1');
INSERT INTO `user` VALUES ('29', 'test', '$2a$10$72GVi62S8vBU8IjbIfwQr.HN42DFW8ZMTPrifiR/i0J8wuf8Q9Y4q', 'test', 'https://cube.elemecdn.com/9/c2/f0ee8a3c7c9638a54940382568c9dpng.png', 'USER', null, '男', '4321', '1234', null, null, '0', '0', '2024-03-20 21:01:29', '2024-03-20 21:01:29', '2024-03-20 21:01:29', '2');
INSERT INTO `user` VALUES ('30', 'haha', '$2a$10$9yfEpv0SFrQC/MLRTHespuBCIX07m1qU/yzLIE9Fy8jYxNPe6GFPy', 'haha', 'https://cube.elemecdn.com/9/c2/f0ee8a3c7c9638a54940382568c9dpng.png', 'USER', null, '女', '321321', '123123', null, null, '0', '0', '2024-03-19 15:57:28', null, '2024-03-19 15:57:28', '2');
INSERT INTO `user` VALUES ('31', 'wanglaowu', '$2a$10$PeRR/QbaXYKO04zLq4bbzOFx6yjTt8G8FGeilMlv2iN4z4JRuJHIS', '王老五', 'https://cube.elemecdn.com/9/c2/f0ee8a3c7c9638a54940382568c9dpng.png', 'USER', '73', '男', '13888', '13666', '0xf592a5f36524261964048543c8736b9f1c94157e', null, '73', '73', '2024-04-11 23:10:01', '2024-04-11 23:10:01', '2024-04-11 23:24:30', '1');
INSERT INTO `user` VALUES ('32', 'zhaoliu', '$2a$10$PeRR/QbaXYKO04zLq4bbzOFx6yjTt8G8FGeilMlv2iN4z4JRuJHIS', 'zhaoliu', 'https://cube.elemecdn.com/9/c2/f0ee8a3c7c9638a54940382568c9dpng.png', 'USER', '71', '男', null, null, '0xc05aec7a8e5e67254456535f69614389a76d1afe', 'did:weid:1000:0x5482ef8d0e0d08d2bd6d8e562d56d5712e334ddf', '67', '67', '2024-04-11 23:22:43', '2024-04-11 23:22:44', '2024-04-11 23:24:30', '1');
