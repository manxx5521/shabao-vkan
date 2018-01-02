-- ----------------------------
-- Table structure for test_demo
-- ----------------------------
DROP TABLE IF EXISTS `test_demo`;
CREATE TABLE `test_demo` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1022 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for vk_file
-- ----------------------------
DROP TABLE IF EXISTS `vk_file`;
CREATE TABLE `vk_file` (
  `file_id` bigint(18) NOT NULL,
  `project_id` int(5) NOT NULL,
  `file_name` varchar(50) DEFAULT NULL,
  `path` varchar(200) NOT NULL DEFAULT '' COMMENT '相对目录',
  `md5` varchar(32) DEFAULT NULL,
  `project_tag` int(1) NOT NULL DEFAULT '0' COMMENT '是否是项目标识，1-是、0-否',
  `file_type` int(1) NOT NULL,
  `parent_id` bigint(18) NOT NULL,
  `cover_id` bigint(18) DEFAULT NULL COMMENT '封面',
  `child_number` int(6) DEFAULT NULL,
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `show` int(1) NOT NULL DEFAULT '1' COMMENT '是否显示默认显示',
  PRIMARY KEY (`file_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for vk_file_tag
-- ----------------------------
DROP TABLE IF EXISTS `vk_file_tag`;
CREATE TABLE `vk_file_tag` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `file_id` bigint(18) NOT NULL,
  `tag_id` int(6) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `un_vk_file_tag` (`file_id`,`tag_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10000143 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for vk_file_type
-- ----------------------------
DROP TABLE IF EXISTS `vk_file_type`;
CREATE TABLE `vk_file_type` (
  `type_id` int(2) NOT NULL,
  `type_name` varchar(30) NOT NULL,
  `used` int(1) NOT NULL,
  `order_no` int(3) NOT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for vk_project
-- ----------------------------
DROP TABLE IF EXISTS `vk_project`;
CREATE TABLE `vk_project` (
  `project_id` int(4) NOT NULL AUTO_INCREMENT,
  `project_name` varchar(30) NOT NULL,
  `project_prefix` varchar(10) NOT NULL COMMENT '所属盘符',
  `project_path` varchar(100) NOT NULL,
  `create_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`project_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1004 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for vk_tag
-- ----------------------------
DROP TABLE IF EXISTS `vk_tag`;
CREATE TABLE `vk_tag` (
  `tag_id` int(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `icon` varchar(50) DEFAULT NULL,
  `type` int(1) DEFAULT NULL COMMENT '类型1-普通、2-热门',
  `level` int(1) NOT NULL,
  `multiple` int(1) NOT NULL COMMENT '是否可以多选',
  `parent_id` int(6) NOT NULL,
  `file_show` int(1) NOT NULL DEFAULT '1' COMMENT '是否在文件列表展现',
  `used` int(1) NOT NULL DEFAULT '1',
  `order_no` int(6) DEFAULT NULL,
  `file_order` int(6) DEFAULT NULL COMMENT '文件列表标签展现排序',
  PRIMARY KEY (`tag_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2006 DEFAULT CHARSET=utf8;