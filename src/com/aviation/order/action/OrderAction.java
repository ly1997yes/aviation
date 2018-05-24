package com.aviation.order.action;


import java.util.Date;

import org.apache.struts2.ServletActionContext;

import com.aviation.customer.vo.Customer;
import com.aviation.order.service.OrderService;
import com.aviation.order.vo.Order;
import com.aviation.route.service.RouteService;
import com.aviation.route.vo.Route;
import com.aviation.util.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class OrderAction extends ActionSupport implements ModelDriven<Order> {

	private Order order = new Order();

	@Override
	public Order getModel() {
		return order;
	}

	private OrderService orderService;
	
	private RouteService routeService;

	

	private Integer page;
	
	public void setPage(Integer page) {
		this.page = page;
	}

	public void setRouteService(RouteService routeService) {
		this.routeService = routeService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	// ����������
	public String toMyOrder() {
		Customer customer = (Customer) ServletActionContext.getRequest().getSession().getAttribute("existCustomer");
		PageBean<Order> pageBean =  orderService.findPageByCid(customer.getCid(),page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "toMyOrder";
	}
	//ֱ�Ӹ���
	/*public String payOrder(){
		
		Customer customer = new Customer();
		customer = (Customer) ServletActionContext.getRequest().getSession().getAttribute("existCustomer");
		if(customer == null){
			this.addActionError("��δ��½�����ȵ�½");
			return "login";
		}
		if(customer.getSign().equals("1")){
			this.addActionError("���������ò��㣬�޷�Ԥ��");
			return "toOrderPage";
		}
	System.out.println("========="+order.getRoute());
		order.setCustomer(customer);
		order.setState(2);
		//order.setAircraft(routeService.findByRid(order.getRid()).getAircraft());
		order.setOrdertime(new Date());
		orderService.save(order);
		this.addActionMessage("֧���ɹ�");
		return "saveOrder";
	}*/
	//���涩��
	public String saveOrder(){
		Customer customer = new Customer();
		customer = (Customer) ServletActionContext.getRequest().getSession().getAttribute("existCustomer");
		if(customer == null){
			this.addActionError("��δ��½�����ȵ�½");
			return "login";
		}
		if(customer.getSign().equals("1")){
			this.addActionError("���������ò��㣬�޷�Ԥ��");
			return "toOrderPage";
		}
		order.setCustomer(customer);
		order.setState(1);
		order.setOrdertime(new Date());
		Route route = new Route();
		route = routeService.findByRid(order.getRoute().getRid());
		if(order.getPrice().equals(route.getFirst_price())){
			route.setFirst_number(route.getFirst_number()-1);
			routeService.update(route);
		}
		if(order.getPrice().equals(route.getBusiness_price())){
			route.setBusiness_number(route.getBusiness_number()-1);
			routeService.update(route);
		}
		if(order.getPrice().equals(route.getTourist_price())){
			route.setTourist_number(route.getTourist_number()-1);
			routeService.update(route);
		}
		orderService.save(order);
		this.addActionMessage("Ԥ���ɹ�");
		return "saveOrder";	
	}
	
	//δ֧��ȥ����
	public String goPayOrder(){	
		order = orderService.findByOid(order.getOid());
		order.setState(2);
		
		orderService.update(order);
		return "updateOrderSuccess";
	}
	//�Ѹ���������
	public String updateState(){
		order = orderService.findByOid(order.getOid());
		order.setState(3);
		orderService.update(order);
		return "updateOrderSuccess";
	}
	
	//ȡ������
	public String cancelOrder(){
		order = orderService.findByOid(order.getOid());
		
		Route route = new Route();
		route = routeService.findByRid(order.getRoute().getRid());
		if(order.getPrice().equals(route.getFirst_price())){
			route.setFirst_number(route.getFirst_number()+1);
			routeService.update(route);
		}
		if(order.getPrice().equals(route.getBusiness_price())){
			route.setBusiness_number(route.getBusiness_number()+1);
			routeService.update(route);
		}
		if(order.getPrice().equals(route.getTourist_price())){
			route.setTourist_number(route.getTourist_number()+1);
			routeService.update(route);
		}
		
		orderService.delete(order);
		return "cancelOrder";
	}
}
