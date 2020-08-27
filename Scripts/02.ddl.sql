CREATE TABLE member(
	name varchar2(10),
	userid varchar2(10),
	pwd varchar2(10),
	email varchar2(20),
	phone char(13),
	admin number(1) DEFAULT 0, --0사용자, 1관리자
	joinDate Date DEFAULT sysdate,
	PRIMARY KEY (userid)
);

DROP TABLE MEMBER;

SELECT * FROM MEMBER;

SELECT * FROM user_tab_columns WHERE table_name in('MEMBER');

SELECT *
	FROM USER_TAB_COLUMNS 
	WHERE table_name IN ('member');
	
SELECT * FROM MEMBER;