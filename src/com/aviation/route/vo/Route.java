package com.aviation.route.vo;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.aviation.aircraft.vo.Aircraft;
import com.aviation.order.vo.Order;

/**
 * 
 * @author lijun
 *	drop table "route" cascade constraints;
create table "route" 
(

   "rid"                INT                  not null,
   "start_city"         VARCHAR(50)          not null,
   "arrival_city"       VARCHAR(50)          not null,
   "flight_date"        DATE                 not null,
   "start_time"         DATE                 not null,
   "arrival_time"       DATE                 not null,
   "aid"                INT                  not null,
   "first_price"        NUMBER(10,2)         not null,
   "tourist_price"      NUMBER(10,2)         not null,
   "business_price"     NUMBER(10,2)         not null,
   "remark"             VARCHAR(100),
   constraint PK_ROUTE primary key ("rid")
);
comment on table "route" is'������Ϣ';
comment on column "route"."rid" is'���߱��';
comment on column "route"."start_city" is'��������';
comment on column "route"."arrival_city" is'�������';
comment on column "route"."flight_date" is'��������';
comment on column "route"."start_time" is'����ʱ��';
comment on column "route"."arrival_time" is'����ʱ��';
comment on column "route"."rid" is'�ͻ���Ϣ';
comment on column "route"."first_price" is'ͷ�Ȳռ۸�';
comment on column "route"."tourist_price" is'���òռ۸�';
comment on column "route"."business_price" is'����ռ۸�';
comment on column "route"."remark" is'��ע';
 */
public class Route {
	//���߱��
	private Integer rid;
	//��������
	private String start_city;
	//�������
	private String arrival_city;
	//��������
	private Date flight_date;
	//����ʱ��
	private Date start_time;
	//����ʱ��
	private Date arrival_time;
	//ͷ�Ȳռ۸�
	private Double first_price;
	//���òռ۸�
	private Double tourist_price;
	//����ռ۸�
	private Double business_price;
	//����
	private String captain;
	//������Ա
	private String maintenance_people;
	//��վ¥
	private String terminal_building;
	//�ǻ���
	private String boarding_port;
	//��ע
	private String remark;
	//�ͻ����
	private Aircraft aircraft;
	//�붩����ϵ
	private Set<Order> orders = new HashSet<Order>();
	
	private Integer first_number;
	private Integer tourist_number;
	private Integer business_number;
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
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
	public Date getFlight_date() {
		return flight_date;
	}
	public void setFlight_date(Date flight_date) {
		this.flight_date = flight_date;
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
	public Double getFirst_price() {
		return first_price;
	}
	public void setFirst_price(Double first_price) {
		this.first_price = first_price;
	}
	public Double getTourist_price() {
		return tourist_price;
	}
	public void setTourist_price(Double tourist_price) {
		this.tourist_price = tourist_price;
	}
	public Double getBusiness_price() {
		return business_price;
	}
	public void setBusiness_price(Double business_price) {
		this.business_price = business_price;
	}
	public String getCaptain() {
		return captain;
	}
	public void setCaptain(String captain) {
		this.captain = captain;
	}
	public String getMaintenance_people() {
		return maintenance_people;
	}
	public void setMaintenance_people(String maintenance_people) {
		this.maintenance_people = maintenance_people;
	}
	public String getTerminal_building() {
		return terminal_building;
	}
	public void setTerminal_building(String terminal_building) {
		this.terminal_building = terminal_building;
	}
	public String getBoarding_port() {
		return boarding_port;
	}
	public void setBoarding_port(String boarding_port) {
		this.boarding_port = boarding_port;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Aircraft getAircraft() {
		return aircraft;
	}
	public void setAircraft(Aircraft aircraft) {
		this.aircraft = aircraft;
	}
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	public Integer getFirst_number() {
		return first_number;
	}
	public void setFirst_number(Integer first_number) {
		this.first_number = first_number;
	}
	public Integer getTourist_number() {
		return tourist_number;
	}
	public void setTourist_number(Integer tourist_number) {
		this.tourist_number = tourist_number;
	}
	public Integer getBusiness_number() {
		return business_number;
	}
	public void setBusiness_number(Integer business_number) {
		this.business_number = business_number;
	}
	
}
