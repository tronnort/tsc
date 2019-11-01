drop table  if exists user;
create table user (
 id varchar (100) NOT NULL COMMENT '主键',
 username varchar(40) DEFAULT NULL COMMENT '账号',
 name varchar(20) DEFAULT NULL COMMENT '姓名',
 age int(3) DEFAULT NULL COMMENT '年龄',
 balance decimal(10,2) DEFAULT NULL COMMENT '余额',
 primary key(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '用户表';
--
drop table if exists user_role;
create table user_role (
 id varchar (100) NOT NULL COMMENT '主键',
 user_id varchar (100) NOT NULL COMMENT '用户id',
 role_id varchar (100) NOT NULL COMMENT '角色id',
 primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '用户角色表';
--
drop table if exists role;
create table role (
  id varchar (100) NOT NULL COMMENT '主键',
  role_name varchar (100) NOT NULL COMMENT '角色名称',
  primary key(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '角色表';
--
drop table if exists role_access;
create table role_access (
 id varchar (100) NOT NULL COMMENT '主键',
 role_id varchar (100) NOT NULL COMMENT '角色id',
 access_id varchar (100) NOT NULL COMMENT '可访问资源地址id',
 primary key(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '角色权限表';
--
drop table if exists access;
create table access(
 id varchar (100) NOT NULL COMMENT '主键',
 access_url varchar (500) not null comment '可访问资源地址',
 access_name varchar (200) not null comment '资源名称',
 primary key(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '资源列表表';