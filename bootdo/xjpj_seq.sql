-------------------------------------------
-- Export file for user XJPJ             --
-- Created by Zz on 2018.08.16, 16:04:27 --
-------------------------------------------

spool xjpj_seq.log

prompt
prompt Creating sequence ACT_EVT_LOG_SEQ
prompt =================================
prompt
create sequence XJPJ.ACT_EVT_LOG_SEQ
minvalue 1
maxvalue 9999999999999999999999999999
start with 1000
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_BLOG_CONTENT
prompt ==================================
prompt
create sequence XJPJ.SEQ_BLOG_CONTENT
minvalue 1
maxvalue 9999999999999999999999999999
start with 1002
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_OA_NOTIFY
prompt ===============================
prompt
create sequence XJPJ.SEQ_OA_NOTIFY
minvalue 1
maxvalue 9999999999999999999999999999
start with 1002
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_OA_NOTIFY_RECORD
prompt ======================================
prompt
create sequence XJPJ.SEQ_OA_NOTIFY_RECORD
minvalue 1
maxvalue 9999999999999999999999999999
start with 1003
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_SALARY
prompt ============================
prompt
create sequence XJPJ.SEQ_SALARY
minvalue 1
maxvalue 9999999999999999999999999999
start with 1000
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_SYS_DEPT
prompt ==============================
prompt
create sequence XJPJ.SEQ_SYS_DEPT
minvalue 1
maxvalue 9999999999999999999999999999
start with 1008
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_SYS_DICT
prompt ==============================
prompt
create sequence XJPJ.SEQ_SYS_DICT
minvalue 1
maxvalue 9999999999999999999999999999
start with 1002
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_SYS_FILE
prompt ==============================
prompt
create sequence XJPJ.SEQ_SYS_FILE
minvalue 1
maxvalue 9999999999999999999999999999
start with 1007
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_SYS_LOG
prompt =============================
prompt
create sequence XJPJ.SEQ_SYS_LOG
minvalue 1
maxvalue 9999999999999999999999999999
start with 1503
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_SYS_MENU
prompt ==============================
prompt
create sequence XJPJ.SEQ_SYS_MENU
minvalue 1
maxvalue 9999999999999999999999999999
start with 1005
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_SYS_ROLE
prompt ==============================
prompt
create sequence XJPJ.SEQ_SYS_ROLE
minvalue 1
maxvalue 9999999999999999999999999999
start with 1001
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_SYS_ROLE_MENU
prompt ===================================
prompt
create sequence XJPJ.SEQ_SYS_ROLE_MENU
minvalue 1
maxvalue 9999999999999999999999999999
start with 4374
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_SYS_TASK
prompt ==============================
prompt
create sequence XJPJ.SEQ_SYS_TASK
minvalue 1
maxvalue 9999999999999999999999999999
start with 1000
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_SYS_USER
prompt ==============================
prompt
create sequence XJPJ.SEQ_SYS_USER
minvalue 1
maxvalue 9999999999999999999999999999
start with 1008
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_SYS_USER_PLUS
prompt ===================================
prompt
create sequence XJPJ.SEQ_SYS_USER_PLUS
minvalue 1
maxvalue 9999999999999999999999999999
start with 1000
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_SYS_USER_ROLE
prompt ===================================
prompt
create sequence XJPJ.SEQ_SYS_USER_ROLE
minvalue 1
maxvalue 9999999999999999999999999999
start with 1013
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_XJPJ_PINGDINGXINXI
prompt ========================================
prompt
create sequence XJPJ.SEQ_XJPJ_PINGDINGXINXI
minvalue 1
maxvalue 9999999999999999999999999999
start with 163
increment by 1
nocache;


spool off
