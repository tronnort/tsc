drop table  if exists user;
create table user (
 id varchar (100) not null COMMENT '主键',
 username varchar(40) DEFAULT NULL COMMENT '用户名',
 name varchar(20) DEFAULT NULL,
 age int(3) DEFAULT NULL,
 balance decimal(10,2) DEFAULT NULL,
 primary key(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;