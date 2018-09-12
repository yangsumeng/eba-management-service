-- 区域表
DROP TABLE IF EXISTS`iot_area`;
CREATE TABLE`iot_area` (
 `area_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '区域Id',
 `area_code` varchar(50) DEFAULT NULL COMMENT '区域编码',
 `area_name` varchar(20) DEFAULT NULL COMMENT '区域名称',
 `company_id` varchar(32) DEFAULT NULL COMMENT '公司Id',
 `state` int(1) DEFAULT NULL COMMENT '0-删除,1-有效',
 `creator` varchar(50) DEFAULT NULL COMMENT '创建者',
 `create_date` datetime DEFAULT NULL COMMENT '创建时间',
 `operator` varchar(50) DEFAULT NULL COMMENT '操作者',
 `operate_date` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`area_id`),
  KEY`i_company_id` (`company_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='区域表';

-- 公司表
DROP TABLE IF EXISTS`iot_company`;
CREATE TABLE`iot_company` (
 `company_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '公司Id',
 `company_name` varchar(50) DEFAULT NULL COMMENT '公司名称',
 `company_code` varchar(20) DEFAULT NULL COMMENT '公司编码',
 `admin` varchar(32) DEFAULT NULL COMMENT '公司管理员ID',
 `state` int(1) DEFAULT NULL COMMENT '0-删除,1-有效',
 `creator` varchar(50) DEFAULT NULL COMMENT '创建者',
 `create_date` datetime DEFAULT NULL COMMENT '创建时间',
 `operator` varchar(50) DEFAULT NULL COMMENT '操作者',
 `operate_date` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`company_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='公司表';

-- 项目表
DROP TABLE IF EXISTS`iot_project`;
CREATE TABLE`iot_project` (
 `project_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '项目Id',
 `project_name` varchar(50) DEFAULT NULL COMMENT '项目名称',
 `end_point` varchar(20) DEFAULT NULL COMMENT '物接入实例地址',
 `from_mqtt_topic` varchar(32) DEFAULT NULL COMMENT 'MQTT物接入主题',
 `tsdb_point` varchar(32) DEFAULT NULL COMMENT '时序数据库地址',
 `company_id` varchar(32) DEFAULT NULL COMMENT '公司Id',
 `area_id` varchar(20) DEFAULT NULL COMMENT '区域Id',
 `area_name` varchar(20) DEFAULT NULL COMMENT '区域名称',
 `state` int(1) DEFAULT NULL COMMENT '0-删除,1-有效',
 `creator` varchar(50) DEFAULT NULL COMMENT '创建者',
 `create_date` datetime DEFAULT NULL COMMENT '创建时间',
 `operator` varchar(50) DEFAULT NULL COMMENT '操作者',
 `operate_date` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`project_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='项目表';

-- 用户表
DROP TABLE IF EXISTS`iot_user`;
CREATE TABLE`iot_user` (
 `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户Id',
 `user_account` varchar(50) DEFAULT NULL COMMENT '登录账号',
 `user_name` varchar(20) DEFAULT NULL COMMENT '用户名',
 `password` varchar(32) DEFAULT NULL COMMENT '密码',
 `telephone` varchar(32) DEFAULT NULL COMMENT '电话',
 `sex` varchar(32) DEFAULT NULL COMMENT '0-男,1-女',
 `remark` varchar(20) DEFAULT NULL COMMENT '备注',
 `job_number` varchar(20) DEFAULT NULL COMMENT '工号',
 `company_id` varchar(20) DEFAULT NULL COMMENT '公司Id',
 `is_admin` varchar(20) DEFAULT NULL COMMENT '管理员标识（0:否 1:是）',
 `role_id` varchar(20) DEFAULT NULL COMMENT '角色Id',
 `app_push_flag` varchar(20) DEFAULT NULL COMMENT '消息推送（0:否 1:是）',
 `state` int(1) DEFAULT NULL COMMENT '0-删除,1-有效',
 `creator` varchar(50) DEFAULT NULL COMMENT '创建者',
 `create_date` datetime DEFAULT NULL COMMENT '创建时间',
 `operator` varchar(50) DEFAULT NULL COMMENT '操作者',
 `operate_date` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- 系统表
DROP TABLE IF EXISTS`iot_system`;
CREATE TABLE`iot_system` (
 `system_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '系统Id',
 `system_name` varchar(20) DEFAULT NULL COMMENT '系统名称',
 `state` int(1) DEFAULT NULL COMMENT '0-删除,1-有效',
 `creator` varchar(50) DEFAULT NULL COMMENT '创建者',
 `create_date` datetime DEFAULT NULL COMMENT '创建时间',
 `operator` varchar(50) DEFAULT NULL COMMENT '操作者',
 `operate_date` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`system_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='系统表';

-- 机房表
DROP TABLE IF EXISTS`iot_machine_room`;
CREATE TABLE`iot_machine_room` (
  `room_id` varchar(36) NOT NULL COMMENT '机房Id(主键)',
  `room_name` varchar(20) DEFAULT NULL COMMENT '机房名称',
  `project_id` varchar(20) DEFAULT NULL COMMENT '项目Id',
  `system_id` varchar(20) DEFAULT NULL COMMENT '系统Id',
  `sort_num` varchar(20) DEFAULT NULL COMMENT '排序字段',
  `state` int(1) DEFAULT NULL COMMENT '0-删除,1-有效',
  `creator` varchar(50) DEFAULT NULL COMMENT '创建者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `operator` varchar(50) DEFAULT NULL COMMENT '操作者',
  `operate_date` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`room_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='机房表';

-- 设备级别（类型）
DROP TABLE IF EXISTS`iot_device_level`;
CREATE TABLE`iot_device_level` (
  `level_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '设备级别Id(主键)',
  `level_name` varchar(20) DEFAULT NULL COMMENT '级别名',
  `level_code` varchar(20) DEFAULT NULL COMMENT '级别编码',
  `state` int(1) DEFAULT NULL COMMENT '0-删除,1-有效',
  `creator` varchar(50) DEFAULT NULL COMMENT '创建者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `operator` varchar(50) DEFAULT NULL COMMENT '操作者',
  `operate_date` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`level_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='设备级别（类型）';

-- 设备表
DROP TABLE IF EXISTS`iot_device`;
CREATE TABLE`iot_device` (
  `device_id` varchar(36) NOT NULL COMMENT '设备Id(主键)',
  `level_id` varchar(20) DEFAULT NULL COMMENT '设备级别',
  `device_name` varchar(20) DEFAULT NULL COMMENT '设备名称',
  `device_code` varchar(20) DEFAULT NULL COMMENT '设备编码',
  `room_id` varchar(36) DEFAULT NULL COMMENT '房间Id',
  `project_id` varchar(20) DEFAULT NULL COMMENT '项目Id',
  `state` int(1) DEFAULT NULL COMMENT '0-删除,1-有效',
  `creator` varchar(50) DEFAULT NULL COMMENT '创建者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `operator` varchar(50) DEFAULT NULL COMMENT '操作者',
  `operate_date` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`device_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='设备表';

-- 级别参数
DROP TABLE IF EXISTS`iot_level_param`;
CREATE TABLE`iot_level_param` (
  `param_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '参数Id',
  `level_id` bigint(20) DEFAULT NULL COMMENT '设备级别',
  `param_name` varchar(20) DEFAULT NULL COMMENT '参数名称',
  `param_code` varchar(20) DEFAULT NULL COMMENT '参数编码',
  `state` int(1) DEFAULT NULL COMMENT '0-删除,1-有效',
  `creator` varchar(50) DEFAULT NULL COMMENT '创建者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `operator` varchar(50) DEFAULT NULL COMMENT '操作者',
  `operate_date` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`param_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='级别参数';

-- 设备属性详情
DROP TABLE IF EXISTS`iot_param_detail`;
CREATE TABLE`iot_param_detail` (
  `detail_id` varchar(36) NOT NULL COMMENT '详情Id(主键)',
  `up_alarm_val` varchar(20) DEFAULT NULL COMMENT '上限报警值',
  `down_alarm_val` varchar(20) DEFAULT NULL COMMENT '下限报警值',
  `param_id` varchar(20) DEFAULT NULL COMMENT '参数Id',
  `param_no` varchar(20) DEFAULT NULL COMMENT '参数编码',
  `collect_address` varchar(20) DEFAULT NULL COMMENT '采集地址',
  `device_id` varchar(36) DEFAULT NULL COMMENT '设备Id',
  `state` int(1) DEFAULT NULL COMMENT '0-删除,1-有效',
  `creator` varchar(50) DEFAULT NULL COMMENT '创建者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `operator` varchar(50) DEFAULT NULL COMMENT '操作者',
  `operate_date` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`detail_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='设备属性详情';

-- 设备属性和外部key值中间表
DROP TABLE IF EXISTS`iot_detail_key`;
CREATE TABLE`iot_detail_key` (
  `detail_key_id` varchar(36) NOT NULL COMMENT '(主键)',
  `detail_id` varchar(20) DEFAULT NULL COMMENT '属性Id',
  `tag_key` varchar(20) DEFAULT NULL COMMENT '外部key值',
  `state` int(1) DEFAULT NULL COMMENT '0-删除,1-有效',
  `creator` varchar(50) DEFAULT NULL COMMENT '创建者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `operator` varchar(50) DEFAULT NULL COMMENT '操作者',
  `operate_date` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='设备属性和外部key值中间表';

-- 时序数据库标签信息
DROP TABLE IF EXISTS`iot_tsdb_tag_info`;
CREATE TABLE`iot_tsdb_tag_info` (
  `tag_info_id` varchar(36) NOT NULL COMMENT '（主键）',
  `tag_name` varchar(20) DEFAULT NULL COMMENT '标签名称',
  `tag_value` varchar(50) DEFAULT NULL COMMENT '标签值',
  `remark` varchar(20) DEFAULT NULL COMMENT '备注',
  `state` int(1) DEFAULT NULL COMMENT '0-删除,1-有效',
  `creator` varchar(50) DEFAULT NULL COMMENT '创建者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `operator` varchar(50) DEFAULT NULL COMMENT '操作者',
  `operate_date` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`tag_info_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='时序数据库标签信息';

-- 操作日志
DROP TABLE IF EXISTS`iot_operate_log`;
CREATE TABLE`iot_operate_log` (
  `log_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志Id',
  `operate_desc` varchar(20) DEFAULT NULL COMMENT '操作描述',
  `user_name` varchar(20) DEFAULT NULL COMMENT '操作人',
  `state` int(1) DEFAULT NULL COMMENT '0-删除,1-有效',
  `creator` varchar(50) DEFAULT NULL COMMENT '创建者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `operator` varchar(50) DEFAULT NULL COMMENT '操作者',
  `operate_date` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='操作日志';

-- 告警消息模板
DROP TABLE IF EXISTS`iot_warning_msg`;
CREATE TABLE`iot_warning_msg` (
  `message_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '消息模板Id',
  `param_detail_id` varchar(36) DEFAULT NULL COMMENT '设备属性Id',
  `messageInfo` varchar(150) DEFAULT NULL COMMENT '告警消息内容',
  `unit` varchar(20) DEFAULT NULL COMMENT '单位',
  `state` int(1) DEFAULT NULL COMMENT '0-删除,1-有效',
  `creator` varchar(50) DEFAULT NULL COMMENT '创建者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `operator` varchar(50) DEFAULT NULL COMMENT '操作者',
  `operate_date` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`message_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='告警消息模板';

