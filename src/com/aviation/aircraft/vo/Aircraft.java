package com.aviation.aircraft.vo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.aviation.order.vo.Order;
import com.aviation.route.vo.Route;

/**
 * 
 * @author lijun
 *create table "aircraft" 
(
   "aid"                INT                  not null,
   "type"               VARCHAR(50)          not null,
   "purchase_time"      DATE                 not null,
   "service_time"       DATE                 not null,
   "first_class"        NUMBER(10)           not null,
   "tourist_class"      NUMBER(10)           not null,
   "business_class"     NUMBER(10)           not null,
   "remark"             VARCHAR(100),
   constraint PK_AIRCRAFT primary key ("aid")
);
comment on table "aircraft" is '�ͻ���Ϣ';
comment on column "aircraft"."aid" is '�ͻ����';
comment on column "aircraft"."type" is '�ͻ��ͺ�';
comment on column "aircraft"."purchase_time" is '����ʱ��';
comment on column "aircraft"."service_time" is '����ʱ��';
comment on column "aircraft"."first_class" is 'ͷ�Ȳ�����';
comment on column "aircraft"."tourist_class" is '���ò�����';
comment on column "aircraft"."business_class" is '���������';
comment on column "aircraft"."remark" is '��ע';
 */

//�ͻ���Ϣ
public class Aircraft {
	//�ͻ�id
	private Integer aid;
	//�������չ�˾
	private String airline;
	//�ͻ��ͺ�
	private String type;
	//����ʱ��
	private String purchaseTime;
	//����ʱ��
	private String serviceTime;
	//ͷ�Ȳ�����
	private Integer firstClass;
	//���ò�����
	private Integer touristClass;
	//���������
	private Integer businessClass;
	//���ά��ʱ��
	private Date repair_time;
	//ά�޴���
	private Integer frequency;
	//��ע
	private String remark;
	//�뺽�߹�ϵ
	private Set<Route> routes = new HashSet<Route>();
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPurchaseTime() {
		return purchaseTime;
	}
	public void setPurchaseTime(String purchaseTime) {
		this.purchaseTime = purchaseTime;
	}
	public String getServiceTime() {
		return serviceTime;
	}
	public void setServiceTime(String serviceTime) {
		this.serviceTime = serviceTime;
	}
	public Integer getFirstClass() {
		return firstClass;
	}
	public void setFirstClass(Integer firstClass) {
		this.firstClass = firstClass;
	}
	public Integer getTouristClass() {
		return touristClass;
	}
	public void setTouristClass(Integer touristClass) {
		this.touristClass = touristClass;
	}
	public Integer getBusinessClass() {
		return businessClass;
	}
	public void setBusinessClass(Integer businessClass) {
		this.businessClass = businessClass;
	}
	public Date getRepair_time() {
		return repair_time;
	}
	public void setRepair_time(Date repair_time) {
		this.repair_time = repair_time;
	}
	public Integer getFrequency() {
		return frequency;
	}
	public void setFrequency(Integer frequency) {
		this.frequency = frequency;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Set<Route> getRoutes() {
		return routes;
	}
	public void setRoutes(Set<Route> routes) {
		this.routes = routes;
	}
	
	
}
