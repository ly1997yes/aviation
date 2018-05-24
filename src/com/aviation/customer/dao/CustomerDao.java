package com.aviation.customer.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.aviation.customer.vo.Customer;


/**
 * �û�ģ��־ò����
 * @author jun
 *
 */
public class CustomerDao extends HibernateDaoSupport{
	
	//�������ֲ�ѯ�Ƿ��и��û�
	public Customer findByCustomername(String cname){
		String hql = "from Customer where cname=?";
		List<Customer> list = this.getHibernateTemplate().find(hql,cname);
		if(list !=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}

	//ע���û��������ݿ����ʵ��
	public void save(Customer Customer) {
		this.getHibernateTemplate().save(Customer);
	}

	//�û���¼�ķ���
	public Customer login(Customer Customer) {
		String hql = "from Customer where cname=? and cpassword =?";
		List<Customer> list = this.getHibernateTemplate().find(hql,Customer.getCname(),Customer.getCpassword());
		if(list !=null && list.size()>0){
			return list.get(0);
		}
		return null;}

	public List<Customer> findAll() {
		String hql = "from Customer";
		List<Customer> list = this.getHibernateTemplate().find(hql);
		return list;
	}

	public Customer findByCid(Integer cid) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(Customer.class, cid);
	}

	public void update(Customer customer) {
		this.getHibernateTemplate().update(customer);
	}

	public void delete(Customer customer) {
		this.getHibernateTemplate().delete(customer);
	}
}
