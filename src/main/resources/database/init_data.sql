说明：
1、默认数据库为h2，数据库，只需要创建表和初始化数据即可；
2、同时支持oracle数据库，检查oracle驱动，然后创建数据库用户，修改jdbc.properties即可；

-----------------------------------------------------------------------------------
----1、创建Oracle数据库----
-----------------------------------------------------------------------------------
create tablespace imark
datafile 'D:\oracle\product\10.2.0\oradata\orcl\imark.dbf' size 500M
autoextend on next 100M maxsize unlimited logging   
extent management local autoallocate
segment space management auto;

--创建用户
create user imark              --创建用户名
identified by "imark"          --创建密码
default tablespace imark      --默认表空间
temporary tablespace TEMP     --临时表空间（默认的）

--赋予管理员权限
grant dba to imark;


-----------------------------------------------------------------------------------
----2、创建表----
-----------------------------------------------------------------------------------
create table SYS_LOGIN_USER
(
  USER_ID       VARCHAR2(32) not null,
  USER_NAME     VARCHAR2(20) ,
  USER_ALIAS    VARCHAR2(20),
  USER_CODE     VARCHAR2(20),
  SEX           VARCHAR2(1),
  LOGIN_ACCOUNT VARCHAR2(30),
  LOGIN_PWD     VARCHAR2(40),
  USER_EMAIL    VARCHAR2(30),
  USER_STATE    CHAR(1) default 'U',
  USER_TYPE     CHAR(1) default '0',
  USER_THEME    VARCHAR2(50) default 'Default',
  MEMO          VARCHAR2(500),
  ORDER_BY      NUMBER(10) default 0,
  primary key (USER_ID)
);
create table APP_DISP_DATA
(
  APP_DISP_DATA_ID VARCHAR2(32) not null,
  DATA_TYPE        VARCHAR2(50),
  DATA_KEY         VARCHAR2(20),
  DATA_VALUE       NUMBER(20,4),
  DATA_DATE        DATE,
  primary key (APP_DISP_DATA_ID)
);


CREATE TABLE SYS_MARK_LOGS
(
  ID           VARCHAR2(36) NOT NULL,
  MARK_TYPE    VARCHAR2(50),
  OP_DATE      VARCHAR2(50),
  BIZ_ID       VARCHAR2(50),
  BIZ_TYPE     VARCHAR2(50),
  BIZ_PARAM    VARCHAR2(200),
  BIZ_DESC     VARCHAR2(200),
  BIZ_STATUS   VARCHAR2(10),
  LOGIC_STATUS VARCHAR2(10),
  OP_USER      VARCHAR2(100),
  PRIMARY KEY (ID)
);

--系统权限表
create table SYS_MENU
(
  ID       VARCHAR2(36) NOT NULL,
  MENU_PID      VARCHAR2(36),
  MENU_NAME     VARCHAR2(20) not null,
  MENU_ADDR     VARCHAR2(100) ,
  MENU_ICON_URL VARCHAR2(20),
  MENU_TYPE     VARCHAR2(1),
  IS_USE        VARCHAR2(1),
  MEMO          VARCHAR2(500),
  ORDER_NO      NUMBER(10) default 0,
  MENU_PATH     VARCHAR2(100),
  PRIMARY KEY (ID)
)

--系统角色表
create table SYS_ROLE
(
ID VARCHAR2(36)NOT NULL,
ROLE_NAME VARCHAR2(50) NOT NULL,
ROLE_TYPE     VARCHAR2(1),
IS_USE        VARCHAR2(1),
MEMO          VARCHAR2(500),
ORDER_NO      NUMBER(10) default 0,
UPDATE_USER   VARCHAR2(36),
UPDATE_DATE  DATE,
PRIMARY KEY (ID)
)

--用户角色关联表
create table SYS_USER_ROLE
(
ID VARCHAR2(36)NOT NULL,
USER_ID VARCHAR2(36)NOT NULL,
ROLE_ID   VARCHAR2(36)NOT NULL,
UPDATE_USER   VARCHAR2(36),
UPDATE_DATE  DATE,
PRIMARY KEY (ID)
)

--角色权限关联表
create table SYS_ROLE_MENU
(
ID VARCHAR2(36)NOT NULL,
ROLE_ID VARCHAR2(36)NOT NULL,
MENU_ID    VARCHAR2(36)NOT NULL,
UPDATE_USER  VARCHAR2(36),
UPDATE_DATE  DATE,
PRIMARY KEY (ID)
)



create table ARTICLE
(
  ARTICLE_ID        VARCHAR2(32)  NOT NULL,
  ARTICLE_TYPE      VARCHAR2(20),
  ARTICLE_TITLE     VARCHAR2(200),
  ARTICLE_DESC     VARCHAR2(1000) ,
  KEY_WORD 			VARCHAR2(100),
  ARTICLE_CONTENT    CLOB,
  CREATE_USER_ID     VARCHAR2(32),
  CREATE_DATE        DATE,
  UPDATE_USER_ID     VARCHAR2(32),
  UPDATE_DATE      DATE,
  DISP_ORDER     NUMBER(10) default 0,
  PRIMARY KEY (ARTICLE_ID)
)

create table ATTACH
(
  ID        VARCHAR2(32)  NOT NULL,
  ATTACH_NAME      VARCHAR2(200),
  BIZ_TYPE     VARCHAR2(20),
  BIZ_ID     VARCHAR2(32) ,
  FILE_PATH 			VARCHAR2(100),
  FILE_CONTENT    CLOB,
  CREATE_USER_ID     VARCHAR2(32),
  CREATE_DATE        DATE,
  UPDATE_USER_ID     VARCHAR2(32),
  UPDATE_DATE      DATE,
  PRIMARY KEY (ID)
)


-----------------------------------------------------------------------------------
----3、初始化数据----
-----------------------------------------------------------------------------------
insert into sys_login_user (USER_ID, USER_NAME, USER_ALIAS, USER_CODE, SEX, LOGIN_ACCOUNT, LOGIN_PWD, USER_EMAIL, USER_STATE, USER_TYPE, USER_THEME, MEMO, ORDER_BY)
values ('6123611A034F4A66967607C13FFD1848', 'admin', 'admin', '0721001', '1', 'admin', 'd9b1d7db4cd6e70935368a1efb10e377', 'admin@ustcsoft.com', 'U', '', '', '系统管理员', 1);

insert into sys_login_user (USER_ID, USER_NAME, USER_ALIAS, USER_CODE, SEX, LOGIN_ACCOUNT, LOGIN_PWD, USER_EMAIL, USER_STATE, USER_TYPE, USER_THEME, MEMO, ORDER_BY)
values ('5893A79FEF6F4120A981DA66D62C9FEF', 'zhangsan', 'zhangsan', '0721002', 'F', 'zhangsan', 'd9b1d7db4cd6e70935368a1efb10e377', 'zhangsan@ustcsoft.com', 'U', '1', '1', '普通用户', 2);