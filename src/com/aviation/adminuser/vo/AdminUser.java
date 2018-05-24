package com.aviation.adminuser.vo;




/**
 * 
 * @author lijun
 * create table "adminuser" 
(
   "userid"             int                  not null,
   "username"           VARCHAR(50)          not null,
   "password"           VARCHAR(50)          not null,
   constraint PK_ADMINUSER primary key ("userid")
);
comment on table "adminuser" is
'����Ա��Ϣ��';
comment on column "adminuser"."userid" is
'����Ա���';
comment on column "adminuser"."username" is
'����Ա����';
comment on column "adminuser"."password" is
'����';
 */
//����Ա��Ϣ��
public class AdminUser {
	//����Ա���
	private Integer userid;
	//����Ա����
	private String username;
	//����
	private String password;
	
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
