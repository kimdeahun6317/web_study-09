SELECT NAME, USERID, PWD, EMAIL, PHONE, ADMIN, JOINDATE
FROM MEMBER;

INSERT INTO MEMBER(NAME, USERID, PWD, EMAIL, PHONE, ADMIN)
VALUES('박규영', 'parkgy', '1234', 'pgy@gmail.com', '010-1111-2222', 0);

--로그인 할때 사용할수있는 sql
SELECT NAME, USERID, EMAIL, PHONE, ADMIN, JOINDATE
FROM MEMBER
WHERE USERID = 'parkgy' AND pwd ='1234';

UPDATE MEMBER
SET NAME = '문채원', PWD = '5678', EMAIL='mcw@gmail.com', PHONE = '010-3333-5555', ADMIN=1, JOINDATE='2020-08-20'
WHERE USERID = 'parkgy';

DELETE MEMBER
WHERE USERID = 'banana';

SELECT PWD FROM MEMBER WHERE USERID = 'somi';

SELECT * FROM MEMBER;

SELECT NAME, USERID, PWD, EMAIL, PHONE, ADMIN, JOINDATE FROM MEMBER WHERE USERID = 'somi';