-- 계정 추가 및 권한 부여

--접속자 확인
SELECT USER FROM dual;

--계정 생성
DROP USER JSP_STUDY CASCADE;

CREATE USER JSP_STUDY IDENTIFIED BY rootroot;

--권하 추가
GRANT CONNECT,resource,CREATE synonym, CREATE VIEW 
	TO JSP_STUDY;


--테이블 생성 권한
GRANT CREATE ANY TABLE TO JSP_STUDY;
--계정 확인
SELECT *
	FROM DBA_USERS 
	WHERE USERNAME = 'JSP_STUDY';
	


