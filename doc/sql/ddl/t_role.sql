-- Create table
create table T_ROLE
(
  id             NUMBER(20) not null,
  role_name      VARCHAR2(100),
  description    VARCHAR2(100),
  create_user_id NUMBER(20),
  create_date    DATE,
  update_user_id NUMBER(20),
  update_date    DATE,
  flag           NUMBER(1) default 0
);
-- Add comments to the table 
comment on table T_ROLE
  is '角色表';
-- Add comments to the columns 
comment on column T_ROLE.id
  is '角色id';
comment on column T_ROLE.role_name
  is '角色名';
comment on column T_ROLE.description
  is '角色描述';
comment on column T_ROLE.create_user_id
  is '创建用户id';
comment on column T_ROLE.create_date
  is '创建时间';
comment on column T_ROLE.update_user_id
  is '更新用户id';
comment on column T_ROLE.update_date
  is '更新时间';
comment on column T_ROLE.flag
  is '是否失效，0：有效，1：失效';
-- Create/Recreate primary, unique and foreign key constraints 
alter table T_ROLE
  add constraint T_ROLE_PK primary key (ID);
  
alter table T_ROLE
  add constraint T_ROLE_NAME_ONLY unique (ROLE_NAME);
