SELECT *
	FROM MEMBER;
	
SELECT name, userid, pwd, email, phone, admin
	FROM MEMBER;

	WHERE userid = 'somi';
	
INSERT INTO MEMBER(NAME, USERID, PWD, EMAIL, PHONE, ADMIN) VALUES ('박규영','parkgy','1234','pgy@gmail.com','010-2313-4467',0,sysdate);

SELECT NAME, USERID,PWD,EMAIL,PHONE,ADMIN,joindate FROM MEMBER WHERE userid = 'parkgy';

UPDATE MEMBER SET name='문채원',pwd='5678',email='mcw@gamil.com',phone='010-3333-5555',admin=1 , joindate='2020-08-20' WHERE userid='parkgy';
	
DELETE FROM MEMBER WHERE userid = 'test';
	

--userckeck
SELECT PWD FROM MEMBER  WHERE userid = 'somi';