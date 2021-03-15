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
type number(10) not null,
memo varchar2(100)
)
select * from member
drop table sell
create table board(
bnum number(6) primary key,
title varchar2(300) not null,
writer varchar2(300) not null,
content varchar2(300) not null,
veiwcnt number(6) default 0,
bcount number(6) default 1,
regdate DATE DEFAULT SYSDATE,
updatedate DATE DEFAULT SYSDATE,
goods varchar2(300) not null
)
drop table board
select * from sell
insert into sell values(18,1,1,1,30000,1,sysdate,null)
create table sell(
sellNum number primary key,
buyNum number,
sellboardNo number,
amount number,
aPrice number,
groupNum number,
sellDate date default sysdate
)
alter table sell add img varchar2(200)

SELECT LISTAGG(selldate, "*", sum(aprice)) AS sss 
FROM ((SELECT to_char(selldate, 'yyyy-mm-dd') selldate,aprice FROM sell))
        GROUP BY selldate order by selldate asc

select selldate, sum(aprice) as aprice
from ((SELECT to_char(selldate, 'yyyy/fmmm/dd') selldate,aprice FROM sell))
GROUP BY selldate order by selldate asc
