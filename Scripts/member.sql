CREATE TABLE member(
	idx number(20) PRIMARY KEY,
	name varchar2(60 char) NOT null,
	email varchar2(40 char) UNIQUE,
	pw varchar2(200 char) NOT NULL,
	regdate TIMESTAMP DEFAULT sysdate,
	status number(2) DEFAULT 0,
	hint varchar2(30 char) not null
	friendList varchar2(3000 char),
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
	hint varchar2(30 char) not null,
	friendList varchar2(3000 char)
);

CREATE SEQUENCE message_seq_idx;
CREATE TABLE message(
	idx NUMBER(20) PRIMARY KEY,
	sender_idx NUMBER(20) not null,
	recipient_idx number(20) not null,
	message varchar2(4000 char) NOT NULL,
	add_status number(2) DEFAULT 0,
	CONSTRAINT FK_message_sender FOREIGN KEY(sender_idx)
	REFERENCES member(idx),
	CONSTRAINT FK_message_recipient FOREIGN KEY(recipient_idx)
	REFERENCES member(idx)
);

CREATE SEQUENCE scheduler_seq_idx;
create TABLE scheduler(
	idx number(20) PRIMARY KEY,
	m_idx number(20) NOT NULL,
	scheduler varchar2(2000 char) NOT NULL,
	CONSTRAINT FK_scheduler_idx FOREIGN KEY(m_idx)
	REFERENCES member(idx)
) ;
