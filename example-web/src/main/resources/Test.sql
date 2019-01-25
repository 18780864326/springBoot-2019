???prompt PL/SQL Developer Export User Objects for user SCOTT@ORCL
prompt Created by Administrator on 2019Äê1ÔÂ25ÈÕ
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
  is 'ç è¡¨';
comment on column SCOTT.AA10.aaa100
  is 'å­ç¬¦åç§°';
comment on column SCOTT.AA10.aaa101
  is 'å­ç¬¦å«ä¹';
comment on column SCOTT.AA10.aaa102
  is 'å®éå¼';
comment on column SCOTT.AA10.aaa103
  is 'æ¾ç¤ºå¼';
comment on column SCOTT.AA10.aae100
  is 'æææ è¯ ';
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
  is 'ç·å¥ååéä¿4ç´ï¼æ£ï¼å±¤ï¼ç·ï¼åå';
comment on column SCOTT.LINE_AREA.line_area_id
  is 'ç·å¥ååID';
comment on column SCOTT.LINE_AREA.line_area_build
  is 'æå±¬æ¨æ£';
comment on column SCOTT.LINE_AREA.line_area_f
  is 'æå±¬æ¨å±¤';
comment on column SCOTT.LINE_AREA.line_area_line
  is 'æå±¬ç·å¥/æ¨¡çµ';
comment on column SCOTT.LINE_AREA.line_area_name
  is 'æå±¬ç·å¥/æ¨¡çµä¸çåååå,ä¹å°±æ¯ä¸åé¡é ­çè¦èç¯å';
comment on column SCOTT.LINE_AREA.line_area_description
  is 'ç·å¥ååæè¿°,æ­¤çºç¾å ´åååå(é¡é ­è¦è)æå°å®ä½';
comment on column SCOTT.LINE_AREA.line_area_process
  is 'æå±¬è£½ç¨';
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
  is 'ç¾å ´ç£æ§èç·å¥å°æéä¿';
comment on column SCOTT.MONITOR_AREA.monitor_id
  is 'é¡é ­ID,éå¢';
comment on column SCOTT.MONITOR_AREA.monitor_play
  is 'æ­æ¾è·¯å¾åæ¸';
comment on column SCOTT.MONITOR_AREA.monitor_area_id
  is 'ååID FR:LINE_AREA_ID';
comment on column SCOTT.MONITOR_AREA.monitor_description
  is 'é¡é ­æè¿°';
comment on column SCOTT.MONITOR_AREA.monitor_nvr_ip
  is 'NVR IP';
comment on column SCOTT.MONITOR_AREA.monitor_nvr_password
  is 'NVR PASSWORD';
comment on column SCOTT.MONITOR_AREA.monitor_ch
  is 'NVR éé';
comment on column SCOTT.MONITOR_AREA.monitor_nvr_user
  is 'NVR è³¬è';
comment on column SCOTT.MONITOR_AREA.monitor_camera_ip
  is 'æåé ­IP,ä¸è¬ææ³ç¡ç¨';
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
  is 'èåè¡¨';
comment on column SCOTT.SYS_MENU.menu_id
  is 'id';
comment on column SCOTT.SYS_MENU.menu_name
  is 'èåè¡¨';
comment on column SCOTT.SYS_MENU.menu_href
  is 'èåé¾æ¥';
comment on column SCOTT.SYS_MENU.menu_parent_id
  is 'ç¶èåID';
comment on column SCOTT.SYS_MENU.menu_permission
  is 'æéæ è¯';
comment on column SCOTT.SYS_MENU.aae100
  is 'æææ è¯';
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
  is 'è§è²è¡¨';
comment on column SCOTT.SYS_ROLE.role_id
  is 'id';
comment on column SCOTT.SYS_ROLE.role_name
  is 'è§è²å';
comment on column SCOTT.SYS_ROLE.role_describe
  is 'æè¿°';
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
  is 'è§è²ä¸èåè¡¨';
comment on column SCOTT.SYS_ROLE_MENU.menu_id
  is 'èåID';
comment on column SCOTT.SYS_ROLE_MENU.role_id
  is 'è§è²ID';
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
  is 'ç¨æ·è¡¨';
comment on column SCOTT.SYS_USER.sys_user_id
  is 'id';
comment on column SCOTT.SYS_USER.user_name
  is 'ç¨æ·å';
comment on column SCOTT.SYS_USER.user_password
  is 'å¯ç ';
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
  is 'ç¨æ·ä¸è§è²çå³ç³»è¡¨';
comment on column SCOTT.SYS_USER_ROLE.sys_user_role_id
  is 'ä¸»é®';
comment on column SCOTT.SYS_USER_ROLE.user_id
  is 'ç¨æ·id';
comment on column SCOTT.SYS_USER_ROLE.role_id
  is 'è§è²id';
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
  is 'èèª§';
comment on column SCOTT.TEST_USER.user_name
  is 'ç¨æ·å';
comment on column SCOTT.TEST_USER.password
  is 'å¯ç ';
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
