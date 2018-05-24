package com.aviation.route.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.aviation.order.vo.Order;
import com.aviation.route.dao.RouteDao;
import com.aviation.route.vo.Route;
import com.aviation.util.PageBean;

@Transactional
public class RouteService {
	
	private RouteDao routeDao;

	public void setRouteDao(RouteDao routeDao) {
		this.routeDao = routeDao;
	}

	public List<Route> findAll() {
		return routeDao.findAll();
	}

	public Route findByRid(Integer rid) {
		return routeDao.findByRid(rid);
	}

	public void update(Route route) {
		routeDao.update(route);
	}

	public void delete(Route route) {
		routeDao.delete(route);
	}

	public void save(Route route) {
		routeDao.save(route);
	}
	//��ҳ��ѯ�ķ���
	public PageBean<Route> findByPage(Integer page) {
		PageBean<Route> pageBean = new PageBean<Route>();
		//���õ�ǰҳ��
		pageBean.setPage(page);
		//����ÿҳ��ʾ�ļ�¼��
		int limit = 10;
		pageBean.setLimit(limit);
		//�����ܼ�¼��
		int totalCount = 0;
		totalCount = routeDao.findCount();
		pageBean.setTotalCount(totalCount);
		//������ҳ��
		int totalPage = 0;
		//Math.ceil(totalCount/limit);
		if(totalCount % limit ==0){
			totalPage = totalCount / limit;
		}else{
			totalPage = totalCount / limit+1;
		}
		pageBean.setTotalPage(totalPage);
		//ÿҳ��ʾ���ݵļ���
		//���Ŀ�ʼ
		int begin = (page-1)*limit;
		List<Route> list = routeDao.findByPage(begin,limit);
		pageBean.setList(list);
		return pageBean;
	}


	public List<Route> findMoreCondition(Route route) {
		return routeDao.findMoreCondition(route);
	}

	public PageBean<Route> findMoreConditionPage(Route route, Integer page) {
		PageBean<Route> pageBean = new PageBean<Route>();
		// ���õ�ǰҳ��:
		page = 1;
		pageBean.setPage(page);
		// ����ÿҳ��ʾ��¼��:
		// ��ʾ5��
		int limit = 5;
		pageBean.setLimit(limit);
		// �����ܼ�¼��:
		int totalCount = 0;
		totalCount = routeDao.findTotal(route);
		pageBean.setTotalCount(totalCount);
		// ������ҳ��
		int totalPage = 0;
		if(totalCount % limit == 0){
			totalPage = totalCount / limit;
		}else{
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// ����ÿҳ��ʾ���ݼ���:
		int begin = (page - 1)*limit;
		List<Route> list = routeDao.findMoreConditionPage(route, begin, limit);
		pageBean.setList(list);
		return pageBean;
	}
}
