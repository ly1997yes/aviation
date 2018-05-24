package com.aviation.order.vo;

import java.util.Date;

import com.aviation.aircraft.vo.Aircraft;
import com.aviation.customer.vo.Customer;
import com.aviation.route.vo.Route;

/**
 * 
 * @author lijun
 *
 */
public class Order {
	//�������
	private Integer oid;
	//��������
	private Date ordertime;
	//������Ϣ
	private Route route;
	//Ʊ��
	private Double price;
	//�ͻ�����
	private String cname;
	//�ͻ����֤��
	private String idcard;
	//��������û�
	private Customer customer;
	//����״̬��
	// 1:δ����   2:�����Ѿ�����   3:��������
	private Integer state;
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
	public Route getRoute() {
		return route;
	}
	public void setRoute(Route route) {
		this.route = route;
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
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	
	
	
}
