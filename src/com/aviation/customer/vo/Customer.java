package com.aviation.customer.vo;

import java.util.HashSet;
import java.util.Set;

import com.aviation.order.vo.Order;

/**
 * 
 * @author lijun
 *create table "customer" 
(
   "cid"                int                  not null,
   "cname"              VARCHAR(50)          not null,
   "cpassword"              VARCHAR(50)          not null,
   "sex"                VARCHAR(50)          not null,
   "idcard"             VARCHAR(50)          not null,
   "phone"              VARCHAR(50)          not null,
   "sign"               CHAR(1)              not null,
   constraint PK_CUSTOMER primary key ("cid")
);
comment on table "customer" is '�ͻ���Ϣ��';
comment on column "customer"."cid" is '�ͻ����';
comment on column "customer"."cname" is '�ͻ�����';
comment on column "customer"."cpassword" is '�ͻ�����';
comment on column "customer"."sex" is '�Ա�';
comment on column "customer"."idcard" is '���֤����';
comment on column "customer"."phone" is '��ϵ�绰';
comment on column "customer"."sign" is '���������';
 */

//�ͻ���Ϣ��
public class Customer {
	//�ͻ����
	private Integer cid;
	//�û���
	private String cname;
	//�û�����
	private String cpassword;
	//�Ա�
	private String sex;
	//��ʵ����
	private String name;
	//���֤����
	private String idcard;
	//��ϵ�绰
	private String phone;
	//���������
	private String sign;
	//һ���û���Ӧ�������
	private Set<Order> orders = new HashSet<Order>();
	
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCpassword() {
		return cpassword;
	}
	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	
}
