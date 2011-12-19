create table course(
	subject_code varchar2(10) primary key,	
	subject_name varchar2(50) not null,				
	major_name varchar2(50) not null,				
	professor_name varchar2(25) not null,			
	subject_detail varchar2(1000) not null,			
	applicant number not null,					
	capacity number not null,					
	lecture_time varchar2(20) not null,			
	credit number not null
)
select * from course
drop table course
purge recyclebin

insert into course values('AAAA', '돈 버는 법', '경영학', '김선달', '1주일만 하면 10억 번다.', 0, 100, '월 09:00 ~ 10:00', 2);