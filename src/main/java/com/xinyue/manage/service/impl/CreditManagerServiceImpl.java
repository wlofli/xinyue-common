package com.xinyue.manage.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.xinyue.manage.beans.SearchCreditManager;
import com.xinyue.manage.dao.CreditManagerDAO;
import com.xinyue.manage.model.CreditManager;
import com.xinyue.manage.model.CreditManagerInfo;
import com.xinyue.manage.service.CreditManagerService;
/**
 * 信贷经理服务层
 * @author MK)茅
 * @version v1.0
 * @date 创建时间：2015年8月12日
 */
@Service
public class CreditManagerServiceImpl implements CreditManagerService {

	@Resource
	private CreditManagerDAO creditManagerDAO;
	
	private Logger log = Logger.getLogger(CreditManagerServiceImpl.class);

	@Override
	public List<CreditManagerInfo> findCmanagersByConditions(SearchCreditManager cmSearch) {
		
		HashMap<String, Object> map = new HashMap<>();
		
		//关键字匹配
		String tempGB = "";
		if (!cmSearch.getGoodBusiness().equals("")) {
			tempGB = cmSearch.getGoodBusiness().substring(0, 4);
		}
		map.put("goodBusiness", tempGB);
		map.put("organizationType", cmSearch.getOrganizationType());
		map.put("serverZone", cmSearch.getServerZone());
		map.put("orderType", cmSearch.getOrderType());
		map.put("isAuth", cmSearch.isAuth());
		map.put("managerId", cmSearch.getManagerId());
		map.put("index", (cmSearch.getJumpPage()-1)*10);
		
		//数据取得
		List<CreditManagerInfo> info = creditManagerDAO.findCmanagersByConditions(map);
		
		return info;
	}

	@Override
	public CreditManagerInfo findCreditManagerInfoById(String managerId) {
		
		HashMap<String, Object> map = new HashMap<>();
		
		map.put("managerId", managerId);
		map.put("goodBusiness", "");
		map.put("organizationType", "");
		map.put("serverZone", "");
		map.put("isAuth", "");
		map.put("index", "");
		
		//数据取得
		List<CreditManagerInfo> info = creditManagerDAO.findCmanagersByConditions(map);
		if (info !=null && info.size() > 0) {
			return info.get(0);
		}
		return null;
	}

	@Override
	public int getCmanagersCountByConditions(SearchCreditManager cmSearch) {
		HashMap<String, Object> map = new HashMap<>();
		
		map.put("goodBusiness", cmSearch.getGoodBusiness());
		map.put("organizationType", cmSearch.getOrganizationType());
		map.put("serverZone", cmSearch.getServerZone());
		map.put("isAuth", cmSearch.isAuth());
		map.put("managerId", cmSearch.getManagerId());
		
		int result = creditManagerDAO.getCmanagersCountByConditions(map);
		return result;
	}

	@Override
	public List<CreditManager> getMangerListByConditions(SearchCreditManager sc) {
		
		List<CreditManager> list = null;
		
		try {
			list = creditManagerDAO.getMangerListByConditions(sc);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return list;
	}

	@Override
	public int getManagerCountByConditions(SearchCreditManager sc) {
		
		return creditManagerDAO.getManagerCountByConditions(sc);
	}

	@Override
	public boolean deleteCreditManagers(String managerIds) {
		
		try {
			//信贷经理ID分离
			String[] temp = managerIds.split("~");
			
			//添加到list
			List<String> list = new ArrayList<String>();
			for (int i = 0; i < temp.length; i++) {
				list.add(temp[i]);
			}
			
			//数据持久化
			int result = creditManagerDAO.deleteCreditManagers(list);
			
			if (result > 0) {
				return true;
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean lockCreditmanagers(String managerIds, String status) {
		try {
			//信贷经理ID分离
			String[] temp = managerIds.split("~");
			
			//添加到list
			List<String> list = new ArrayList<String>();
			for (int i = 0; i < temp.length; i++) {
				list.add(temp[i]);
			}
			
			//数据持久化
			int result = creditManagerDAO.lockCreditmanagers(list,status);
			
			if (result > 0) {
				return true;
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return false;
	}

}
