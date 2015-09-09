package com.xinyue.manage.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xinyue.manage.beans.SelectInfo;
import com.xinyue.manage.dao.SelectDao;
import com.xinyue.manage.model.Select;
import com.xinyue.manage.service.SelectService;

/**
 * 
 * @author wenhai.you
 * @2015年5月18日
 * @上午9:33:15
 */
@Service
public class SelectServiceImpl implements SelectService {

	@Resource
	private SelectDao sdao;
	
	@Override
	public List<Select> findSelectByCode(String code) {
		// TODO Auto-generated method stub
		return sdao.findSelectByCode(code);
	}

	
	@Override
	public String showValue(Select select) {
		// TODO Auto-generated method stub
		return sdao.showValue(select);
	}


	@Override
	public List<SelectInfo> findSelectByType(String code) {
		
		return sdao.findSelectByType(code);
	}


	@Override
	public List<SelectInfo> findProvince() {
		
		return sdao.findProvince();
	}


	@Override
	public List<SelectInfo> findCitiesByProvinceCode(String code) {
		return sdao.findCitiesByProvinceId(code);
	}


	@Override
	public List<SelectInfo> findZonesByCityCode(String code) {
		return sdao.findZonesByCityId(code);
	}
	
	public List<Select> getIndustryList() {
		
		return sdao.getIndustryList();
	}
	
	@Override
	public List<Select> getOrgList() {
		// TODO Auto-generated method stub
		return sdao.getOrgList();
	}


	@Override
	public List<SelectInfo> getProductList() {
		// TODO Auto-generated method stub
		return sdao.findProduct();
	}


	@Override
	public List<SelectInfo> findSelectByTypePart(String code, int[] number) {
		// TODO Auto-generated method stub
		return sdao.findSelectByTypePart(code, number);
	}
}
