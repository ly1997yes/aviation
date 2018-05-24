package com.aviation.route.adminaction;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.aviation.aircraft.service.AircraftService;
import com.aviation.aircraft.vo.Aircraft;
import com.aviation.route.service.RouteService;
import com.aviation.route.vo.Route;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AdminRouteAction extends ActionSupport implements ModelDriven<Route>{

	private Route route = new Route();
	@Override
	public Route getModel() {
		return route;
	}
	
	private RouteService routeService;
	
	private AircraftService aircraftService;
	
	public void setRouteService(RouteService routeService) {
		this.routeService = routeService;
	}

	public void setAircraftService(AircraftService aircraftService) {
		this.aircraftService = aircraftService;
	}

	//��̨��ѯ���к���
	public String findAll(){
		List<Route> rList = routeService.findAll();
		ActionContext.getContext().getValueStack().set("rList", rList);
		return "findAll";
	}
	//�����ҳ��
	public String toAddPage(){
		List<Aircraft> aList = aircraftService.findAll();
		ActionContext.getContext().getValueStack().set("aList", aList);
		return "toAddPage";
	}
	//��̨��Ӻ���
	public String save(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String aid = request.getParameter("aircraft.aid");
System.out.println("======================"+route.getFlight_date());
System.out.println("======================"+route.getStart_time());
System.out.println("======================"+route.getArrival_time());
		Date start = route.getStart_time();
		Date arr = route.getArrival_time();
		boolean a = start.after(arr);
		boolean b = start.before(arr);
		if(start.after(arr)){
			this.addActionError("����ʱ�䲻���ٵ���ʱ��֮��");
			List<Aircraft> aList = aircraftService.findAll();
			ActionContext.getContext().getValueStack().set("aList", aList);
			return "toAddPage";
		}else{
			Aircraft aircraft = aircraftService.findByAid(Integer.valueOf(aid));
			route.setFirst_number(aircraft.getFirstClass());
			route.setTourist_number(aircraft.getTouristClass());
			route.setBusiness_number(aircraft.getBusinessClass());
			routeService.save(route);
			return "saveSuccess";
		}
		
	}
	//��̨�༭ʱ��ѯ
	public String edit(){
		route = routeService.findByRid(route.getRid());
		List<Aircraft> aList = aircraftService.findAll();
		ActionContext.getContext().getValueStack().set("aList", aList);
		
		
		return "editSuccess";
	}
	public String update(){
		Aircraft aircraft = aircraftService.findByAid(route.getAircraft().getAid());
		route.setFirst_number(aircraft.getFirstClass());
		route.setTourist_number(aircraft.getTouristClass());
		route.setBusiness_number(aircraft.getBusinessClass());
		routeService.update(route);
		return "updateSuccess";
	}
	
	//��̨ɾ������
	public String delete(){
		route = routeService.findByRid(route.getRid());
		routeService.delete(route);
		return "deleteSuccess";
	}
}
