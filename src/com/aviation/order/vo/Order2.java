package com.aviation.order.vo;

import java.util.Date;

import com.aviation.aircraft.vo.Aircraft;
import com.aviation.customer.vo.Customer;
import com.aviation.route.vo.Route;

/**
 * 
 * @author lijun
 *drop table if exists "order";
create table "order"
(
   oid                  int not null comment '�������',
   rid                  int not null comment '���߱��',
   date                 date not null comment '����',
   aircraft_type        varchar(50) not null comment '�������',
   start_city           varchar(50) not null comment '��������',
   arrival_city         varchar(50) not null comment '�������',
   price                date not null comment '����ʱ��',
   start_time           date not null comment '����ʱ��',
   arrival_time         varchar(50) not null comment '�۸�',
   cname                varchar(50) not null comment '�ͻ�����',
   idcard               varchar(50) not null comment '���֤����',
   cid                  int not null comment '�ͻ�id',
   state                int comment '����״̬',
   primary key (oid)
);
alter table "order" comment '������Ϣ';
alter table "order" add constraint FK_Reference_1 foreign key (cid)
      references customer (cid) on delete restrict on update restrict;
alter table "order" add constraint FK_Reference_2 foreign key (rid)
      references route (rid) on delete restrict on update restrict;
 */
public class Order2 {
	//�������
	private Integer oid;
	//��������
	private Date ordertime;
	//���߱��
	private Integer rid;
	//��������
	private Date flight_date;
	//������󣺿ͻ�
	private Aircraft aircraft;
	//��������
	private String start_city;
	//�������
	private String arrival_city;
	//����ʱ��
	private Date start_time;
	//����ʱ��
	private Date arrival_time;
	//Ʊ��
	private Double price;
	//�ͻ�����
	private String cname;
	//�ͻ����֤��
	private String idcard;
	//����״̬��
	// 1:δ����   2:�����Ѿ�����   3:��������
	private Integer state;
	//��������û�
	private Customer customer;
	
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	
	
	public Date getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}
	public Date getFlight_date() {
		return flight_date;
	}
	public void setFlight_date(Date flight_date) {
		this.flight_date = flight_date;
	}
	public Aircraft getAircraft() {
		return aircraft;
	}
	public void setAircraft(Aircraft aircraft) {
		this.aircraft = aircraft;
	}
	public String getStart_city() {
		return start_city;
	}
	public void setStart_city(String start_city) {
		this.start_city = start_city;
	}
	public String getArrival_city() {
		return arrival_city;
	}
	public void setArrival_city(String arrival_city) {
		this.arrival_city = arrival_city;
	}
	public Date getStart_time() {
		return start_time;
	}
	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}
	public Date getArrival_time() {
		return arrival_time;
	}
	public void setArrival_time(Date arrival_time) {
		this.arrival_time = arrival_time;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
