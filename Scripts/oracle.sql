CREATE TABLE comments(
	idx NUMBER(20) PRIMARY KEY,
	REF NUMBER(20) NOT NULL,
	name VARCHAR2(60) NOT NULL,
	pw VARCHAR2(60) NOT NULL,
	content varchar2 (200) NOT NULL,
	regdate timestamp default sysdate
);

CREATE SEQUENCE comments_idx_seq;

CREATE TABLE board(
	idx NUMBER(20) PRIMARY KEY,
	categoryid NUMBER(20) NOT NULL,
	name varchar2(60 char) NOT NULL,
	pw varchar2(60 char) NOT NULL,
	title varchar2(200 char) NOT NULL,
	content varchar2(3000 char) NOT NULL,
	ip varchar2(10 char) NOT NULL,
	savefile varchar2(20 char) NOT NULL,
	origfile varchar2(20 char) NOT NULL,
	email varchar2(20 char) NOT NULL,
	regdate timestamp default sysdate
);

CREATE SEQUENCE board_idx_seq;

CREATE TABLE category( 
	idx NUMBER PRIMARY KEY,
	item varchar2(60 char)
);
