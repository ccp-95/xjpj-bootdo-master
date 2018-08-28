-- Create table
create table XJPJ_PINGDINGXINXI
(
  ID       number not null,
  KHZQ     varchar2(20),
  DEPT_ID  number,
  ZGXM     varchar2(20),
  NL       number,
  XB       char(1),
  CHE_JIAN varchar2(50),
  BAN_ZU   varchar2(50),
  GANG_WEI varchar2(50),
  SFZH     varchar2(50),
  XING_JI  number,
  ZHDF     number,
  YWJN     number,
  ZZSJ     number,
  AQJX     number,
  WCGZ     number
)
;
-- Add comments to the columns 
comment on column XJPJ_PINGDINGXINXI.KHZQ
  is '考核周期';
comment on column XJPJ_PINGDINGXINXI.DEPT_ID
  is '单位';
comment on column XJPJ_PINGDINGXINXI.ZGXM
  is '职工姓名';
comment on column XJPJ_PINGDINGXINXI.XB
  is '性别 0：女 1：男';
comment on column XJPJ_PINGDINGXINXI.CHE_JIAN
  is '车间';
comment on column XJPJ_PINGDINGXINXI.BAN_ZU
  is '班组';
comment on column XJPJ_PINGDINGXINXI.GANG_WEI
  is '岗位';
comment on column XJPJ_PINGDINGXINXI.SFZH
  is '身份证号';
comment on column XJPJ_PINGDINGXINXI.XING_JI
  is '星级';
comment on column XJPJ_PINGDINGXINXI.ZHDF
  is '综合得分';
comment on column XJPJ_PINGDINGXINXI.YWJN
  is '业务技能';
comment on column XJPJ_PINGDINGXINXI.ZZSJ
  is '遵章守纪';
comment on column XJPJ_PINGDINGXINXI.AQJX
  is '安全绩效';
comment on column XJPJ_PINGDINGXINXI.WCGZ
  is '完成工作';
-- Create/Recreate primary, unique and foreign key constraints 
alter table XJPJ_PINGDINGXINXI
  add constraint PK_XJPJ_PDXX_ID primary key (ID);

-- Create sequence 
create sequence SEQ_XJPJ_PINGDINGXINXI
start with 100
increment by 1
nocache;



-- Create table
create table BLOG_ATTATCHMENT
(
  ID  number,
  cid number,
  fid number
)
;
-- Add comments to the table 
comment on table BLOG_ATTATCHMENT
  is '文章附件';
-- Add comments to the columns 
comment on column BLOG_ATTATCHMENT.ID
  is '序号';
comment on column BLOG_ATTATCHMENT.cid
  is '文章ID';
comment on column BLOG_ATTATCHMENT.fid
  is '文件ID';

  -- Create sequence 
create sequence SEQ_BLOG_ATTATCHMENT
start with 100
nocache;


-- Alter table 
alter table SYS_FILE
  storage
  (
    next 1
  )
;
-- Add/modify columns 
alter table SYS_FILE add ORIGINAL_NAME NVARCHAR2(200);
-- Add comments to the columns 
comment on column SYS_FILE.ORIGINAL_NAME
  is '原始文件名';

-- Alter table 
alter table SYS_DEPT
  storage
  (
    next 1
  )
;
-- Add/modify columns 
alter table SYS_DEPT add TYPE NUMBER(4);
-- Add comments to the columns 
comment on column SYS_DEPT.TYPE
  is '0:根节点 1:系统 2:单位 3:部门';
  
  
  
-- Create table
create table XJPJ_WHITELIST
(
  ID          number,
  dept_id     number not null,
  expiry_date date not null
)
;
-- Add comments to the columns 
comment on column XJPJ_WHITELIST.ID
  is '序号';
comment on column XJPJ_WHITELIST.dept_id
  is '部门ID';
comment on column XJPJ_WHITELIST.expiry_date
  is '有效期';
-- Create/Recreate primary, unique and foreign key constraints 
alter table XJPJ_WHITELIST
  add constraint PK_XJPJ_WHITELIST_ID primary key (ID);
  
  
  -- Create sequence 
create sequence SEQ_XJPJ_WHITELIST
minvalue 100
start with 100
nocache;

