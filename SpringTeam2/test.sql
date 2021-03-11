create table goods(
gnum number(6) primary key,
name varchar2(300) not null,
cost number(10) DEFAULT 0,
price number(10) DEFAULT 0,
writedate DATE DEFAULT SYSDATE,
updatedate DATE DEFAULT SYSDATE
)
create table member(
mnum number(6) primary key,
id varchar2(10) not null,
email varchar2(20) not null,
pw varchar2(15) not null,
name varchar2(12) not null,
phone number(15) not null,
address varchar2(300) not null,
regdate DATE DEFAULT SYSDATE,
updatedate DATE DEFAULT SYSDATE,
birth date not null,
point number(10) DEFAULT 0,
mtype number(10) not null,
memo varchar2(100)
)
create table qboard(
bnum number(6) primary key,
title varchar2(300) not null,
writer varchar2(300) not null,
content varchar2(300) not null,
veiwcnt number(6) default 0,
regdate DATE DEFAULT SYSDATE,
updatedate DATE DEFAULT SYSDATE
)
create table sellboard(
bnum number(6) primary key,
title varchar2(300) not null,
writer varchar2(300) not null,
content varchar2(300) not null,
veiwcnt number(6) default 0,
bcount number(6) default 1,
goods varchar2(300) not null,
regdate DATE DEFAULT SYSDATE,
updatedate DATE DEFAULT SYSDATE
)
create table sell(
sellnum number(6) primary key,
goodsnum number(6),
buynum number(6),
sellDate date default sysdate
)
select *from sell
drop table goods