package com.aviation.aircraft.adminaction;

import java.util.List;

import com.aviation.aircraft.service.AircraftService;
import com.aviation.aircraft.vo.Aircraft;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AdminAircraftAction extends ActionSupport implements ModelDriven<Aircraft>{
	
	private Aircraft aircraft = new Aircraft();
	@Override
	public Aircraft getModel() {
		return aircraft;
	}
	
	private AircraftService aircraftService;
	
	public void setAircraftService(AircraftService aircraftService) {
		this.aircraftService = aircraftService;
	}

	//��̨��ѯ���пͻ�
	public String findAll(){
		List<Aircraft> aList = aircraftService.findAll();
		ActionContext.getContext().getValueStack().set("aList", aList);
		return "findAll";
	}
	
	//��̨�༭�ͻ�
	public String edit(){
		//�Ȳ�ѯ
		aircraft = aircraftService.findByAid(aircraft.getAid());
		return "editSuccess";
	}
	
	//��ѯ��༭
	public String update(){
		aircraftService.update(aircraft);
		return "updateSuccess";
	}
	
	//���ʱ����
	public String save(){
		aircraftService.save(aircraft);
		return "saveSuccess";
	}
	
	//ɾ���ͻ���Ϣ
	public String delete(){
		//ɾ��Ҫ�Ȳ�ѯ
		aircraft = aircraftService.findByAid(aircraft.getAid());
		aircraftService.delete(aircraft);
		return "deleteSuccess";
	}

	
}
