CREATE TABLE board(
	idx NUMBER(20 ) PRIMARY KEY,
	mem_ref NUMBER(20) NOT NULL,
	categoryid NUMBER(20) NOT NULL,
	title varchar2(200 char) NOT NULL,
	content varchar2(3000 char) NOT NULL,
	ip varchar2(20 char) NOT NULL,
	savefile varchar2(20 char) NOT NULL,
	origfile varchar2(20 char) NOT NULL,
	regdate timestamp default sysdate,
	read number(20) default 0,
	likes number(20) default 0,
	CONSTRAINT FK_mem_board FOREIGN KEY(mem_ref)
	REFERENCES member(idx)
);



CREATE SEQUENCE board_idx_seq;

CREATE TABLE comments(
	idx NUMBER(20) PRIMARY KEY,
	mem_ref number(20) NOT NULL,
	b_REF NUMBER(20) not null,
	content varchar2 (200 char) NOT NULL,
	regdate timestamp default sysdate,
	CONSTRAINT FK_b_comment FOREIGN KEY(b_ref)
	REFERENCES board(idx),
	CONSTRAINT FK__mem_comment FOREIGN KEY(mem_ref)
	REFERENCES member(idx)
);
CREATE SEQUENCE comment_idx_seq;


CREATE TABLE category( 
	idx NUMBER PRIMARY KEY,
	item varchar2(60 char)
);
