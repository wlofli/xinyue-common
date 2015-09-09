package com.xinyue.manage.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xinyue.manage.dao.ServicerDAO;
import com.xinyue.manage.model.Servicer;
import com.xinyue.manage.service.ServicerService;

/**
 * author lzc
 */
@Service
public class ServicerServiceImpl  implements ServicerService{

	@Resource
	private ServicerDAO servicerDAO;
	@Override
	public Servicer getServicerById(String id) {
		// TODO Auto-generated method stub
		return servicerDAO.getServicerById(id);
	}

}
