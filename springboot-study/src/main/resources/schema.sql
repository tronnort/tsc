drop table  if exists user;
create table user (
 id varchar (100) not null COMMENT '主键',
 username varchar(40) DEFAULT NULL COMMENT '账号',
 name varchar(20) DEFAULT NULL COMMENT '姓名',
 age int(3) DEFAULT NULL COMMENT '年龄',
 balance decimal(10,2) DEFAULT NULL COMMENT '余额',
 primary key(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '用户表';