-- Create table
create table T_USER
(
  id             NUMBER(20) not null,
  user_name      VARCHAR2(100),
  password       VARCHAR2(100),
  nickname       VARCHAR2(100),
  sex            VARCHAR2(10) default 0,
  mobile         VARCHAR2(100),
  create_user_id NUMBER(20),
  create_date    DATE,
  update_user_id NUMBER(20),
  update_date    DATE,
  flag           NUMBER(1) default 0
);
-- Add comments to the table 
comment on table T_USER
  is '用户表';
-- Add comments to the columns 
comment on column T_USER.id
  is '用户id';
comment on column T_USER.user_name
  is '账号';
comment on column T_USER.password
  is '密码';
comment on column T_USER.nickname
  is '昵称';
comment on column T_USER.sex
  is '性别';
comment on column T_USER.mobile
  is '手机号码';
comment on column T_USER.create_user_id
  is '创建用户id';
comment on column T_USER.create_date
  is '创建时间';
comment on column T_USER.update_user_id
  is '更新用户id';
comment on column T_USER.update_date
  is '更新时间';
comment on column T_USER.flag
  is '是否失效，0：有效，1：失效';
-- Create/Recreate primary, unique and foreign key constraints 
alter table T_USER
  add constraint T_USER_PK primary key (ID);
  
alter table T_USER
  add constraint T_USER_USERNAME_ONLY unique (USER_NAME);