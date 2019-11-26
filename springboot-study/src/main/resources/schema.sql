drop table  if exists user;
create table user (
 id varchar (100) NOT NULL COMMENT '主键',
 username varchar(40) DEFAULT NULL COMMENT '账号',
 name varchar(20) DEFAULT NULL COMMENT '姓名',
 age int(3) DEFAULT NULL COMMENT '年龄',
 balance decimal(10,2) DEFAULT NULL COMMENT '余额',
 primary key(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '用户表';


drop table if exists user_role;
create table user_role (
 id varchar (100) NOT NULL COMMENT '主键',
 user_id varchar (100) NOT NULL COMMENT '用户id',
 role_id varchar (100) NOT NULL COMMENT '角色id',
 primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '用户角色表';



drop table if exists role;
create table role (
  id varchar (100) NOT NULL COMMENT '主键',
  role_name varchar (100) NOT NULL COMMENT '角色名称',
  primary key(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '角色表';



drop table if exists role_access;
create table role_access (
 id varchar (100) NOT NULL COMMENT '主键',
 role_id varchar (100) NOT NULL COMMENT '角色id',
 access_id varchar (100) NOT NULL COMMENT '可访问资源地址id',
 primary key(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '角色权限表';



drop table if exists access;
create table access(
 id varchar (100) NOT NULL COMMENT '主键',
 access_url varchar (500) not null comment '可访问资源地址',
 access_name varchar (200) not null comment '资源名称',
 primary key(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '资源列表表';


 DROP TABLE IF EXISTS school;
 CREATE TABLE school(
  id VARCHAR(100) NOT NULL COMMENT '学校id',
  pid varchar (100) not null default '0' comment '上级学校id,没有上级该值为0',
  name VARCHAR(100) NOT NULL COMMENT '学校名称',
  address VARCHAR(300) NOT NULL COMMENT '学校地址',
  PRIMARY KEY (id)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '学校表';



 DROP TABLE IF EXISTS school_class;
 CREATE TABLE school_class(
  id VARCHAR(100) NOT NULL COMMENT '班级id',
  name VARCHAR(100) NOT NULL COMMENT '班级名称',
  school_id VARCHAR(100) NOT NULL COMMENT '学校id',
  class_no VARCHAR(100) NOT NULL COMMENT '班级编号',
  PRIMARY KEY (id)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '班级表';



 DROP TABLE IF EXISTS student;
 CREATE TABLE student(
  id VARCHAR(100) NOT NULL COMMENT '班级id',
  name VARCHAR(100) NOT NULL COMMENT '学生姓名',
  gender VARCHAR(4) NOT NULL COMMENT '学生性别',
  school_id VARCHAR(100) NOT NULL COMMENT '学校id',
  class_id VARCHAR(100) NOT NULL COMMENT '班级id',
  PRIMARY KEY (id)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '学生表';



DROP TABLE IF EXISTS t_test;
CREATE TABLE t_test(
 id VARCHAR(100) NOT NULL COMMENT '主键id',
 f_update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
 update_by VARCHAR(100) COMMENT '更新人',
 f_create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
 create_by VARCHAR(100) COMMENT '创建人',
 PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '自定填充字段的表';