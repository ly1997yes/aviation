package com.aviation.aircraft.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.aviation.aircraft.vo.Aircraft;

public class AircraftDao extends HibernateDaoSupport{

	//��ѯ���пͻ���Ϣ
	public List<Aircraft> findAll() {
		String sql = "from Aircraft";
		List<Aircraft> list = this.getHibernateTemplate().find(sql);
		return list;
	}
	//����id��ѯ�ͻ���Ϣ
	public Aircraft findByAid(Integer aid) {
		return this.getHibernateTemplate().get(Aircraft.class, aid);
	}
	public void update(Aircraft aircraft) {
		this.getHibernateTemplate().update(aircraft);
	}
	public void save(Aircraft aircraft) {
		this.getHibernateTemplate().save(aircraft);
	}
	public void delete(Aircraft aircraft) {
		this.getHibernateTemplate().delete(aircraft);
	}


}
