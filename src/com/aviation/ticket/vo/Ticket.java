package com.aviation.ticket.vo;

import java.sql.Date;

/**
 * 
 * @author lijun
 *drop table "tickets" cascade constraints;
create table "tickets" 
(
   "tid"                int                  not null,
   "cid"                int                  not null,
   "rid"                int                  not null,
   "date"               DATE                 not null,
   "jipiaoleixing"      VARCHAR(50)          not null,
   "zhangshu"           VARCHAR(50)          not null,
   "feiyong"            VARCHAR(50)          not null,
   constraint PK_TICKETS primary key ("tid")
);

comment on table "tickets" is'Ʊ����Ϣ';
comment on column "tickets"."tid" is'�������';
comment on column "tickets"."cid" is'�ͻ���Ϣ';
comment on column "tickets"."rid" is'������Ϣ';
comment on column "tickets"."date" is'��������';
comment on column "tickets"."jipiaoleixing" is'��Ʊ����';
comment on column "tickets"."zhangshu" is'��������';
comment on column "tickets"."feiyong" is'����';
 */
public class Ticket {
	private Integer tid;
	private Integer cid;
	private Integer rid;
	private Date date;
	private String jipiaoleixing;
}
