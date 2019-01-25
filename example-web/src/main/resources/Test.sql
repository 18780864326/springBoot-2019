???prompt PL/SQL Developer Export User Objects for user SCOTT@ORCL
prompt Created by Administrator on 2019��1��25��
set define off
spool Test.log

prompt
prompt Creating table AA10
prompt ===================
prompt
create table SCOTT.AA10
(
  aaa100 VARCHAR2(20) not null,
  aaa101 VARCHAR2(50),
  aaa102 VARCHAR2(20) not null,
  aaa103 VARCHAR2(100),
  aae100 VARCHAR2(1) default 1,
  id     VARCHAR2(32) default SYS_GUID() not null
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
comment on table SCOTT.AA10
  is '码表';
comment on column SCOTT.AA10.aaa100
  is '字符名称';
comment on column SCOTT.AA10.aaa101
  is '字符含义';
comment on column SCOTT.AA10.aaa102
  is '实际值';
comment on column SCOTT.AA10.aaa103
  is '显示值';
comment on column SCOTT.AA10.aae100
  is '有效标识 ';
comment on column SCOTT.AA10.id
  is 'ID';
alter table SCOTT.AA10
  add constraint SYS_AA10 primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table BONUS
prompt ====================
prompt
create table SCOTT.BONUS
(
  ename VARCHAR2(10),
  job   VARCHAR2(9),
  sal   NUMBER,
  comm  NUMBER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;

prompt
prompt Creating table DEPT
prompt ===================
prompt
create table SCOTT.DEPT
(
  deptno NUMBER(2) not null,
  dname  VARCHAR2(14),
  loc    VARCHAR2(13)
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
alter table SCOTT.DEPT
  add constraint PK_DEPT primary key (DEPTNO)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table EMP
prompt ==================
prompt
create table SCOTT.EMP
(
  empno    NUMBER(4) not null,
  ename    VARCHAR2(10),
  job      VARCHAR2(9),
  mgr      NUMBER(4),
  hiredate DATE,
  sal      NUMBER(7,2),
  comm     NUMBER(7,2),
  deptno   NUMBER(2)
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
alter table SCOTT.EMP
  add constraint PK_EMP primary key (EMPNO)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table SCOTT.EMP
  add constraint FK_DEPTNO foreign key (DEPTNO)
  references SCOTT.DEPT (DEPTNO);

prompt
prompt Creating table LINE_AREA
prompt ========================
prompt
create table SCOTT.LINE_AREA
(
  line_area_id          NUMBER(18) not null,
  line_area_build       VARCHAR2(20),
  line_area_f           VARCHAR2(20),
  line_area_line        VARCHAR2(20),
  line_area_name        VARCHAR2(50),
  line_area_description VARCHAR2(100),
  line_area_process     VARCHAR2(100)
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
comment on table SCOTT.LINE_AREA
  is '線別區域關係4級，棟，層，線，區域';
comment on column SCOTT.LINE_AREA.line_area_id
  is '線別區域ID';
comment on column SCOTT.LINE_AREA.line_area_build
  is '所屬樓棟';
comment on column SCOTT.LINE_AREA.line_area_f
  is '所屬樓層';
comment on column SCOTT.LINE_AREA.line_area_line
  is '所屬線別/模組';
comment on column SCOTT.LINE_AREA.line_area_name
  is '所屬線別/模組下的區域劃分,也就是一個鏡頭的覆蓋範圍';
comment on column SCOTT.LINE_AREA.line_area_description
  is '線別區域描述,此為現場區域劃分(鏡頭覆蓋)最小單位';
comment on column SCOTT.LINE_AREA.line_area_process
  is '所屬製程';
alter table SCOTT.LINE_AREA
  add constraint SEQ_LINE_AREA primary key (LINE_AREA_ID)
  using index 
  tablespace MONITOR
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table MONITOR_AREA
prompt ===========================
prompt
create table SCOTT.MONITOR_AREA
(
  monitor_id           NUMBER(18) not null,
  monitor_play         VARCHAR2(200),
  monitor_area_id      NUMBER(18),
  monitor_description  VARCHAR2(200),
  monitor_nvr_ip       VARCHAR2(100),
  monitor_nvr_password VARCHAR2(100),
  monitor_ch           NUMBER,
  monitor_nvr_user     VARCHAR2(100),
  monitor_camera_ip    VARCHAR2(100)
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
comment on table SCOTT.MONITOR_AREA
  is '現場監控與線別對應關係';
comment on column SCOTT.MONITOR_AREA.monitor_id
  is '鏡頭ID,遞增';
comment on column SCOTT.MONITOR_AREA.monitor_play
  is '播放路徑參數';
comment on column SCOTT.MONITOR_AREA.monitor_area_id
  is '區域ID FR:LINE_AREA_ID';
comment on column SCOTT.MONITOR_AREA.monitor_description
  is '鏡頭描述';
comment on column SCOTT.MONITOR_AREA.monitor_nvr_ip
  is 'NVR IP';
comment on column SCOTT.MONITOR_AREA.monitor_nvr_password
  is 'NVR PASSWORD';
comment on column SCOTT.MONITOR_AREA.monitor_ch
  is 'NVR 通道';
comment on column SCOTT.MONITOR_AREA.monitor_nvr_user
  is 'NVR 賬號';
comment on column SCOTT.MONITOR_AREA.monitor_camera_ip
  is '攝像頭IP,一般情況無用';
alter table SCOTT.MONITOR_AREA
  add constraint SEQ_MONITOR_AREA primary key (MONITOR_ID)
  using index 
  tablespace MONITOR
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table SALGRADE
prompt =======================
prompt
create table SCOTT.SALGRADE
(
  grade NUMBER,
  losal NUMBER,
  hisal NUMBER
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
prompt Creating table SYS_MENU
prompt =======================
prompt
create table SCOTT.SYS_MENU
(
  menu_id         NUMBER(18) not null,
  menu_name       VARCHAR2(50),
  menu_href       VARCHAR2(255),
  menu_parent_id  NUMBER(18),
  menu_permission VARCHAR2(20),
  aae100          VARCHAR2(2) default 1
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
comment on table SCOTT.SYS_MENU
  is '菜单表';
comment on column SCOTT.SYS_MENU.menu_id
  is 'id';
comment on column SCOTT.SYS_MENU.menu_name
  is '菜单表';
comment on column SCOTT.SYS_MENU.menu_href
  is '菜单链接';
comment on column SCOTT.SYS_MENU.menu_parent_id
  is '父菜单ID';
comment on column SCOTT.SYS_MENU.menu_permission
  is '权限标识';
comment on column SCOTT.SYS_MENU.aae100
  is '有效标识';
alter table SCOTT.SYS_MENU
  add constraint SEQ_MENU_ID primary key (MENU_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;

prompt
prompt Creating table SYS_ROLE
prompt =======================
prompt
create table SCOTT.SYS_ROLE
(
  role_id       NUMBER(18) not null,
  role_name     VARCHAR2(50),
  role_describe VARCHAR2(200)
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
comment on table SCOTT.SYS_ROLE
  is '角色表';
comment on column SCOTT.SYS_ROLE.role_id
  is 'id';
comment on column SCOTT.SYS_ROLE.role_name
  is '角色名';
comment on column SCOTT.SYS_ROLE.role_describe
  is '描述';
alter table SCOTT.SYS_ROLE
  add constraint SEQ_ROLE_ID primary key (ROLE_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table SYS_ROLE_MENU
prompt ============================
prompt
create table SCOTT.SYS_ROLE_MENU
(
  menu_id          NUMBER(18),
  role_id          NUMBER(18),
  sys_role_menu_id NUMBER(18) not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
comment on table SCOTT.SYS_ROLE_MENU
  is '角色与菜单表';
comment on column SCOTT.SYS_ROLE_MENU.menu_id
  is '菜单ID';
comment on column SCOTT.SYS_ROLE_MENU.role_id
  is '角色ID';
comment on column SCOTT.SYS_ROLE_MENU.sys_role_menu_id
  is 'id';
alter table SCOTT.SYS_ROLE_MENU
  add constraint SEQ_SYS_ROLE_MENU_ID primary key (SYS_ROLE_MENU_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;

prompt
prompt Creating table SYS_USER
prompt =======================
prompt
create table SCOTT.SYS_USER
(
  sys_user_id   NUMBER(18) not null,
  user_name     VARCHAR2(50),
  user_password VARCHAR2(20)
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
comment on table SCOTT.SYS_USER
  is '用户表';
comment on column SCOTT.SYS_USER.sys_user_id
  is 'id';
comment on column SCOTT.SYS_USER.user_name
  is '用户名';
comment on column SCOTT.SYS_USER.user_password
  is '密码';
alter table SCOTT.SYS_USER
  add constraint SEQ_SYS_USER_ID primary key (SYS_USER_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table SYS_USER_ROLE
prompt ============================
prompt
create table SCOTT.SYS_USER_ROLE
(
  sys_user_role_id NUMBER(18) not null,
  user_id          NUMBER(18),
  role_id          NUMBER(18)
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
comment on table SCOTT.SYS_USER_ROLE
  is '用户与角色的关系表';
comment on column SCOTT.SYS_USER_ROLE.sys_user_role_id
  is '主键';
comment on column SCOTT.SYS_USER_ROLE.user_id
  is '用户id';
comment on column SCOTT.SYS_USER_ROLE.role_id
  is '角色id';
alter table SCOTT.SYS_USER_ROLE
  add constraint SEQ_SYS_USER_ROLE_ID primary key (SYS_USER_ROLE_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table TEST_USER
prompt ========================
prompt
create table SCOTT.TEST_USER
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
comment on table SCOTT.TEST_USER
  is '蚚誧';
comment on column SCOTT.TEST_USER.user_name
  is '用户名';
comment on column SCOTT.TEST_USER.password
  is '密码';
alter table SCOTT.TEST_USER
  add constraint SEQ_TEST_USER primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating sequence SEQ_LINE_AREA
prompt ===============================
prompt
create sequence SCOTT.SEQ_LINE_AREA
minvalue 1
maxvalue 9999999999999999999999999999
start with 1020
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_MENU_ID
prompt =============================
prompt
create sequence SCOTT.SEQ_MENU_ID
minvalue 1
maxvalue 9999999999999999999999999999
start with 20
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_MONITOR_AREA
prompt ==================================
prompt
create sequence SCOTT.SEQ_MONITOR_AREA
minvalue 1
maxvalue 9999999999999999999999999999
start with 100
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_ROLE_ID
prompt =============================
prompt
create sequence SCOTT.SEQ_ROLE_ID
minvalue 1
maxvalue 9999999999999999999999999999
start with 20
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_SYS_ROLE_MENU_ID
prompt ======================================
prompt
create sequence SCOTT.SEQ_SYS_ROLE_MENU_ID
minvalue 1
maxvalue 9999999999999999999999999999
start with 21
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_SYS_USER_ID
prompt =================================
prompt
create sequence SCOTT.SEQ_SYS_USER_ID
minvalue 1
maxvalue 9999999999999999999999999999
start with 20
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_SYS_USER_ROLE_ID
prompt ======================================
prompt
create sequence SCOTT.SEQ_SYS_USER_ROLE_ID
minvalue 1
maxvalue 9999999999999999999999999999
start with 21
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_TEST_USER
prompt ===============================
prompt
create sequence SCOTT.SEQ_TEST_USER
minvalue 1
maxvalue 9999999999999999999999999999
start with 102
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_USER_ID
prompt =============================
prompt
create sequence SCOTT.SEQ_USER_ID
minvalue 1
maxvalue 99999
start with 21
increment by 1
cache 20;


prompt Done
spool off
set define on
