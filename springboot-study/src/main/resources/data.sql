insert into user (id, username, name, age, balance) values (1,'account1','张三', 20, 100.00);
insert into user (id, username, name, age, balance) values (2,'account2','李四', 28, 180.00);
insert into user (id, username, name, age, balance) values (3,'account3','王五', 32, 280.00);
--
insert into role (id,role_name) values (1,'vip1');
insert into role (id,role_name) values (2,'vip2');
insert into role (id,role_name) values (3,'vip3');
--
insert into user_role (id,user_id,role_id) values (1,1,1);
insert into user_role (id,user_id,role_id) values (2,1,2);
insert into user_role (id,user_id,role_id) values (3,1,3);
insert into user_role (id,user_id,role_id) values (4,2,1);
insert into user_role (id,user_id,role_id) values (5,2,2);
insert into user_role (id,user_id,role_id) values (6,3,1);
--
insert into access (id,access_url,access_name) values (1,'/getUser','获取用户');
insert into access (id,access_url,access_name) values (2,'/getRole','获取权限');
insert into access (id,access_url,access_name) values (3,'/getAll','获取全部信息');
insert into access (id,access_url,access_name) values (4,'/deleteUser','删除用户');
insert into access (id,access_url,access_name) values (5,'/deleteRole','删除角色');
insert into access (id,access_url,access_name) values (6,'/deleteAll','删除全部信息');
insert into access (id,access_url,access_name) values (7,'/createUser','创建用户');
insert into access (id,access_url,access_name) values (8,'/createRole','创建角色');
--
insert into role_access (id,role_id,access_id) values (1,1,'1');
insert into role_access (id,role_id,access_id) values (2,1,'4');
insert into role_access (id,role_id,access_id) values (3,1,'7');
insert into role_access (id,role_id,access_id) values (4,2,'2');
insert into role_access (id,role_id,access_id) values (5,2,'5');
insert into role_access (id,role_id,access_id) values (6,2,'8');
insert into role_access (id,role_id,access_id) values (7,3,'3');
insert into role_access (id,role_id,access_id) values (8,3,'6');

-- 查询用户权限列表
-- select u.id,u.username,u.name,role.role_name,access.access_name,access.access_url from user  u
--      join user_role  ur on ur.user_id = u.id
--      join role_access ra on ur.role_id = ra.role_id
--      join role on ra.role_id = role.id
--      join access on ra.access_id = access.id
--     where u.id =1

insert into school (id,pid,name,address) values ('1','0','中国总校','中国');
insert into school (id,pid,name,address) values ('2','0','美国总校','美国');
insert into school (id,pid,name,address) values ('3','1','中国分校01','中国');
insert into school (id,pid,name,address) values ('4','1','中国分校02','中国');
insert into school (id,pid,name,address) values ('5','2','美国分校01','美国');
insert into school (id,pid,name,address) values ('6','2','美国分校02','美国');

insert into school_class (id,name,school_id,class_no) values ('1','一年一班','3','1001');
insert into school_class (id,name,school_id,class_no) values ('2','一年二班','3','1002');
insert into school_class (id,name,school_id,class_no) values ('3','一年三班','3','1003');
insert into school_class (id,name,school_id,class_no) values ('4','一年四班','3','1004');
insert into school_class (id,name,school_id,class_no) values ('5','一年一班','4','1001');
insert into school_class (id,name,school_id,class_no) values ('6','一年二班','4','1002');
insert into school_class (id,name,school_id,class_no) values ('7','一年三班','4','1003');
insert into school_class (id,name,school_id,class_no) values ('8','一年四班','4','1004');
insert into school_class (id,name,school_id,class_no) values ('9','一年一班','5','1001');
insert into school_class (id,name,school_id,class_no) values ('10','一年二班','5','1002');
insert into school_class (id,name,school_id,class_no) values ('11','一年三班','5','1003');
insert into school_class (id,name,school_id,class_no) values ('12','一年四班','5','1004');
insert into school_class (id,name,school_id,class_no) values ('13','一年一班','6','1001');
insert into school_class (id,name,school_id,class_no) values ('14','一年二班','6','1002');
insert into school_class (id,name,school_id,class_no) values ('15','一年三班','6','1003');
insert into school_class (id,name,school_id,class_no) values ('16','一年四班','6','1004');

insert into student (id,name,gender,school_id,class_id) values ('1','tom1','man','3','1');
insert into student (id,name,gender,school_id,class_id) values ('2','tom2','man','3','2');
insert into student (id,name,gender,school_id,class_id) values ('3','tom3','man','3','3');
insert into student (id,name,gender,school_id,class_id) values ('4','tom4','man','3','4');
insert into student (id,name,gender,school_id,class_id) values ('5','tom5','man','4','5');
insert into student (id,name,gender,school_id,class_id) values ('6','tom6','man','4','6');
insert into student (id,name,gender,school_id,class_id) values ('7','tom7','man','4','7');
insert into student (id,name,gender,school_id,class_id) values ('8','tom8','man','4','8');
insert into student (id,name,gender,school_id,class_id) values ('9','tom9','man','5','9');
insert into student (id,name,gender,school_id,class_id) values ('10','tom10','man','5','10');
insert into student (id,name,gender,school_id,class_id) values ('11','tom11','man','5','11');
insert into student (id,name,gender,school_id,class_id) values ('12','tom12','man','5','12');
insert into student (id,name,gender,school_id,class_id) values ('13','tom13','man','6','13');
insert into student (id,name,gender,school_id,class_id) values ('14','tom14','man','6','14');
insert into student (id,name,gender,school_id,class_id) values ('15','tom15','man','6','15');
insert into student (id,name,gender,school_id,class_id) values ('16','tom16','man','6','16');

