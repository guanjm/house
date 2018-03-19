-- Create table
create table T_ROLE_PERMISSION
(
  id            NUMBER(20) not null,
  role_id       NUMBER(20),
  permission_id NUMBER(20)
);
-- Add comments to the table 
comment on table T_ROLE_PERMISSION
  is '角色权限表';
-- Add comments to the columns 
comment on column T_ROLE_PERMISSION.id
  is '流水id';
comment on column T_ROLE_PERMISSION.role_id
  is '角色id';
comment on column T_ROLE_PERMISSION.permission_id
  is '权限id';
-- Create/Recreate primary, unique and foreign key constraints 
alter table T_ROLE_PERMISSION
  add constraint T_ROLE_PERMISSION primary key (ID);
