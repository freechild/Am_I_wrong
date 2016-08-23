CREATE TABLE member(
	idx number(20) PRIMARY KEY,
	name varchar2(60 char) NOT null,
	email varchar2(40 char) UNIQUE,
	pw varchar2(200 char) NOT NULL,
	regdate TIMESTAMP DEFAULT sysdate,
	status number(2) DEFAULT 0,
	hint varchar(30 char) not null
);

CREATE SEQUENCE member_idx_seq;


CREATE TABLE member(
	idx number(20) PRIMARY KEY,
	userid varchar2(60 char) UNIQUE,
	userpw varchar2(200 char) NOT NULL,
	username varchar2(60 char) NOT null,
	email varchar2(40 char) NOT null,
	zipcode varchar2(40 char) NOT NULL,
	address1 varchar2(100 char) NOT NULL,
	address2 varchar2(100 char) NOT NULL,
	regdate TIMESTAMP DEFAULT sysdate,
	status number(2) DEFAULT 0,
	hint varchar(30 char) not null
);