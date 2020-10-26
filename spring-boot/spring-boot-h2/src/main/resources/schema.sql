DROP TABLE IF EXISTS user;

CREATE TABLE user
(
	userId int not null identity comment '主键',
	name varchar(64) not null comment '姓名',
	age int not null comment '年龄',
	PRIMARY KEY (userId)
);