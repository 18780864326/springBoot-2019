???prompt PL/SQL Developer Export User Objects for user SCOTT@ORCL
prompt Created by Administrator on 2019Äê2ÔÂ13ÈÕ
set define off
spool Test.log

prompt
prompt Creating table SYSTEM_MENU
prompt ==========================
prompt
create table SCOTT.SYSTEM_MENU
(
  system_menu_id        NUMBER(18) not null,
  system_menu_name      VARCHAR2(200),
  system_menu_url       VARCHAR2(200),
  system_menu_oreder    NUMBER(12),
  system_menu_parent_id NUMBER(18),
  system_menu_comments  VARCHAR2(200),
  system_menu_icon      VARCHAR2(200),
  valid_status          VARCHAR2(1)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
comment on column SCOTT.SYSTEM_MENU.system_menu_id
  is 'ä¸»é®';
comment on column SCOTT.SYSTEM_MENU.system_menu_name
  is 'èåå';
comment on column SCOTT.SYSTEM_MENU.system_menu_url
  is 'è®¿é®è·¯å¾';
comment on column SCOTT.SYSTEM_MENU.system_menu_oreder
  is 'æåº å¼è¶å° è¶é å';
comment on column SCOTT.SYSTEM_MENU.system_menu_parent_id
  is 'ç¶èå id';
comment on column SCOTT.SYSTEM_MENU.system_menu_comments
  is 'è¯´æ';
comment on column SCOTT.SYSTEM_MENU.system_menu_icon
  is 'èåå¾æ ';
comment on column SCOTT.SYSTEM_MENU.valid_status
  is 'ææç¶æ  1 ææ  0 æ æ';
alter table SCOTT.SYSTEM_MENU
  add constraint SEQ_SYSTEM_MENU primary key (SYSTEM_MENU_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;

prompt
prompt Creating table SYSTEM_ROLE
prompt ==========================
prompt
create table SCOTT.SYSTEM_ROLE
(
  system_role_id       NUMBER(18) not null,
  system_role_name     VARCHAR2(50),
  system_role_comments VARCHAR2(200),
  valid_status         VARCHAR2(1)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
comment on column SCOTT.SYSTEM_ROLE.system_role_id
  is 'ä¸»é®';
comment on column SCOTT.SYSTEM_ROLE.system_role_name
  is 'è§è²å';
comment on column SCOTT.SYSTEM_ROLE.system_role_comments
  is 'è¯´æ';
comment on column SCOTT.SYSTEM_ROLE.valid_status
  is 'ææç¶æ  1 ææ  0 æ æ';
alter table SCOTT.SYSTEM_ROLE
  add constraint SEA_SYTEM_ROLE primary key (SYSTEM_ROLE_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;

prompt
prompt Creating table SYSTEM_ROLE_MENU
prompt ===============================
prompt
create table SCOTT.SYSTEM_ROLE_MENU
(
  id             NUMBER(18) not null,
  system_role_id NUMBER(18),
  system_menu_id NUMBER(18)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
comment on column SCOTT.SYSTEM_ROLE_MENU.id
  is 'id';
comment on column SCOTT.SYSTEM_ROLE_MENU.system_role_id
  is 'è§è²id';
comment on column SCOTT.SYSTEM_ROLE_MENU.system_menu_id
  is 'èåid';
alter table SCOTT.SYSTEM_ROLE_MENU
  add constraint SEQ_SYSTEM_ROLE_MENU primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;

prompt
prompt Creating table SYSTEM_USER
prompt ==========================
prompt
create table SCOTT.SYSTEM_USER
(
  id        NUMBER(18) not null,
  user_name VARCHAR2(20),
  password  VARCHAR2(20)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table SYSTEM_USER_ROLE
prompt ===============================
prompt
create table SCOTT.SYSTEM_USER_ROLE
(
  id             NUMBER(18) not null,
  system_user_id NUMBER(18),
  system_role_id NUMBER(18)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
comment on column SCOTT.SYSTEM_USER_ROLE.id
  is 'ä¸»é®';
comment on column SCOTT.SYSTEM_USER_ROLE.system_user_id
  is 'ç¨æ·id';
comment on column SCOTT.SYSTEM_USER_ROLE.system_role_id
  is 'è§è²id';
alter table SCOTT.SYSTEM_USER_ROLE
  add constraint SEQ_SYSTEM_USER_ROLE primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;

prompt
prompt Creating sequence SEQ_SYSTEM_MENU
prompt =================================
prompt
create sequence SCOTT.SEQ_SYSTEM_MENU
minvalue 1
maxvalue 9999999999999999999999999999
start with 100
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_SYSTEM_ROLE
prompt =================================
prompt
create sequence SCOTT.SEQ_SYSTEM_ROLE
minvalue 1
maxvalue 9999999999999999999999999999
start with 100
increment by 1
cache 20;

prompt
prompt Creating sequence SQE_SYSTEM_ROLE_MENU
prompt ======================================
prompt
create sequence SCOTT.SQE_SYSTEM_ROLE_MENU
minvalue 1
maxvalue 9999999999999999999999999999
start with 20
increment by 1
cache 20;

prompt
prompt Creating sequence SQE_SYSTEM_USER_ROLE
prompt ======================================
prompt
create sequence SCOTT.SQE_SYSTEM_USER_ROLE
minvalue 1
maxvalue 9999999999999999999999999999
start with 20
increment by 1
cache 20;


prompt Done
spool off
set define on
