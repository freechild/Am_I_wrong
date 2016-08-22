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
