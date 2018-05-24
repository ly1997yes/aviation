package com.aviation.customer.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.aviation.customer.service.CustomerService;
import com.aviation.customer.vo.Customer;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{
	//ģ������ʹ�õĶ���
	private Customer customer = new Customer();
	@Override
	public Customer getModel() {
		return customer;
	}
	//������֤��
	private String checkcode;
	
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}
	//ע��CustomerService
	private CustomerService customerService;
	
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	/**
	 * ��ת��ע�����
	 */
	public String registPage(){
		return "registPage";
	}
	
	/**
	 * ajax�����첽У���û�����ִ�з���
	 * @throws IOException 
	 */
	public String findByName() throws IOException{
		//����service��ѯ
		Customer existCustomer = customerService.findByCustomername(customer.getCname());
		//���response������ҳ�����
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		//�ж�
		if(existCustomer != null){
			//�û����Ѵ���
			response.getWriter().println("<font color='red'>�û����Ѵ���</font>");
		}else{
			//�û�������ʹ��
			response.getWriter().println("<font color='green'>�û�������ʹ��</font>");
		}
		return NONE;
	}

	/**
	 * �û�ע��ķ���
	 */
	public String regist(){
		//�ж���֤�����
		//��session�л�������֤��
		String checkcode1 = (String) ServletActionContext.getRequest().getSession().getAttribute("checkcode");
		
		if(!checkcode.equalsIgnoreCase(checkcode1)){
			this.addActionError("��֤���������");
			return "checkcodeFail";
		}
		customer.setSign("0");
		customerService.save(customer);
		this.addActionMessage("ע��ɹ�");
		return "msg";
	}
	
	/**
	 * ��ת����¼ҳ��
	 */
	public String loginPage(){	
		return "loginPage";
	}
	
	/**
	 * ��¼�ķ���
	 */
	public String login(){
		Customer existCustomer = customerService.login(customer);
		if(existCustomer == null){
			//��¼ʧ��
			this.addActionError("�û������������");
			return "login";
		}else{
			//��¼�ɹ�
			//���û���Ϣ����session��
			ServletActionContext.getRequest().getSession()
			.setAttribute("existCustomer", existCustomer);
		}
		return "loginSuccess";
	}
	
	/**
	 * �û��˳��ķ���
	 */
	public String quit(){
		//����session
		ServletActionContext.getRequest().getSession().invalidate();
		return "quit";
	}
	
	//��������Ϣҳ�淽��
	public String toPersonalInfo(){
		/*customer = customerService.findByCid(customer.getCid());*/
		customer = (Customer) ServletActionContext.getRequest().getSession().getAttribute("existCustomer");
		customer = customerService.findByCid(customer.getCid());
		return "toPersonalInfo";
	}
	
	//��������Ϣҳ��
	public String toCompleteInfo(){
		
		customer = (Customer) ServletActionContext.getRequest().getSession().getAttribute("existCustomer");
		customer = customerService.findByCid(customer.getCid());
		return "toCompleteInfo";
	}
	//ȥ�޸�����ҳ��
	public String toPasswordInfo(){
		customer = (Customer) ServletActionContext.getRequest().getSession().getAttribute("existCustomer");
		customer = customerService.findByCid(customer.getCid());
		return "toPasswordInfo";
	}
	//�༭������Ϣ
	public String editInfo(){
		//customer = (Customer) ServletActionContext.getRequest().getSession().getAttribute("existCustomer");
		customerService.update(customer);
		
		return "editInfoSuccess";
	}
	
	

}
