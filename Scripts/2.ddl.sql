create table MEMBER (
ID int auto_increment primary key,
EMAIL varchar(255),
PASSWORD varchar(100),
NAME varchar(100),
REGDATE datetime,
unique key (EMAIL) 
);
insert into member(EMAIL, PASSWORD, NAME) values
('tkdrjs2@naver.com', 'tkdrjs8', '김민');
select ID, EMAIL, PASSWORD, NAME, REGDATE from member;


select * from member where REGDATE between '2021-05-25' and '2021-05-26' order by regdate desc;

delete from member where id >91;

