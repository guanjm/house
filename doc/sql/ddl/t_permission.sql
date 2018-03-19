-- Create table
create table T_PERMISSION
(
  id              NUMBER(20) not null,
  permission_name VARCHAR2(100),
  permission_type NUMBER(10),
  father_id       NUMBER(20),
  description     VARCHAR2(100),
  create_user_id  NUMBER(20),
  create_date     DATE,
  update_user_id  NUMBER(20),
  update_date     DATE,
  flag            NUMBER(1) default 0
);
-- Add comments to the table 
comment on table T_PERMISSION
  is '权限表';
-- Add comments to the columns 
comment on column T_PERMISSION.id
  is '权限id';
comment on column T_PERMISSION.permission_name
  is '权限名';
comment on column T_PERMISSION.permission_type
  is '权限类型';
comment on column T_PERMISSION.father_id
  is '父权限id';
comment on column T_PERMISSION.description
  is '权限描述';
comment on column T_PERMISSION.create_user_id
  is '创建用户id';
comment on column T_PERMISSION.create_date
  is '创建时间';
comment on column T_PERMISSION.update_user_id
  is '更新用户id';
comment on column T_PERMISSION.update_date
  is '更新时间';
comment on column T_PERMISSION.flag
  is '是否失效，0：有效，1：失效';
-- Create/Recreate primary, unique and foreign key constraints 
alter table T_PERMISSION
  add constraint T_PERMISSION_PK primary key (ID);
  
alter table T_PERMISSION
  add constraint T_PERMISSION_NAME_ONLY unique (PERMISSION_NAME);