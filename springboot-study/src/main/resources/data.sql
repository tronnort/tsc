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

