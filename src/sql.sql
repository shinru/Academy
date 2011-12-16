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