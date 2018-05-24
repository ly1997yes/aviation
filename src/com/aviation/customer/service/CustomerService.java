package com.aviation.customer.service;

import com.aviation.customer.vo.Customer;

import java.util.List;

import com.aviation.customer.dao.CustomerDao;

public class CustomerService {
	//ע��CustomerDao
	private CustomerDao customerDao;

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	
	
	//���û�����ѯ�û��ķ���
	public Customer findByCustomername(String cname){
		return customerDao.findByCustomername(cname);
	}

/*	//ҵ�������û�ע��ķ���
	public void save(Customer Customer) {
		Customer.setState(1);//0�����û�δ��� 1�����û��Ѿ�����
		//����uuid��Ϊ������������ݿ�
		String code = UUIDUtils.getUUID()+UUIDUtils.getUUID();
		Customer.setCode(code);
		CustomerDao.save(Customer);
	}*/

	//�û���¼�ķ���
	public Customer login(Customer customer) {
		return customerDao.login(customer);
	}
	//��̨��ѯ�����û�
	public List<Customer> findAll() {
		return customerDao.findAll();
	}



	public Customer findByCid(Integer cid) {
		// TODO Auto-generated method stub
		return customerDao.findByCid(cid);
	}



	public void update(Customer customer) {
		customerDao.update(customer);
	}



	public void save(Customer customer) {
		customerDao.save(customer);
	}



	public void delete(Customer customer) {
		customerDao.delete(customer);
	}

}
