-- Create table
create table T_USER_ROLE
(
  id      NUMBER(20) not null,
  user_id NUMBER(20),
  role_id NUMBER(20)
);
-- Add comments to the table 
comment on table T_USER_ROLE
  is '用户角色表';
-- Add comments to the columns 
comment on column T_USER_ROLE.id
  is '流水id';
comment on column T_USER_ROLE.user_id
  is '用户id';
comment on column T_USER_ROLE.role_id
  is '角色id';
-- Create/Recreate primary, unique and foreign key constraints 
alter table T_USER_ROLE
  add constraint T_USER_ROLE_PK primary key (ID);
