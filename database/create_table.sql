CONNECT 'jdbc:derby://localhost:1527/phonebookdb;create=true';
CREATE TABLE PHONERECORD
(ID INT PRIMARY KEY,
NAME VARCHAR(40) DEFAULT NULL,
SURNAME VARCHAR(40) DEFAULT NULL,
FAMILY VARCHAR(40) DEFAULT NULL,
ADDRESS VARCHAR(40) DEFAULT NULL,
PHONENUMBER VARCHAR(20) DEFAULT NULL
);