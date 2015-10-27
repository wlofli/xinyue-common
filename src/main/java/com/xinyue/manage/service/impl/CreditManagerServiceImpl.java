package com.xinyue.manage.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.xinyue.authe.util.Md5;
import com.xinyue.manage.beans.InvitationMemberInfo;
import com.xinyue.manage.beans.SearchCreditManager;
import com.xinyue.manage.dao.CreditManagerDAO;
import com.xinyue.manage.model.AuthenticationCM;
import com.xinyue.manage.model.CreditManager;
import com.xinyue.manage.model.CreditManagerInfo;
import com.xinyue.manage.model.MoneyOutline;
import com.xinyue.manage.model.Order;
import com.xinyue.manage.service.CreditManagerService;
import com.xinyue.manage.util.SecurityUtils;
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
			
			sc.setIndex((sc.getJumpPage()-1)*10);
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
	public boolean updateCreditmanagers(String managerIds, String status) {
		try {
			//信贷经理ID分离
			String[] temp = managerIds.split("~");
			
			//添加到list
			List<String> list = new ArrayList<String>();
			for (int i = 0; i < temp.length; i++) {
				list.add(temp[i]);
			}
			
			//数据持久化
			int result = creditManagerDAO.updateCreditmanagers(list,status);
			
			if (result > 0) {
				return true;
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean saveCreditManager(CreditManager creditManager) {
		
		try {
			String uuid = UUID.randomUUID().toString().replace("-", "");
			creditManager.setId(uuid);
			
			//密码加密
			creditManager.setPassword(Md5.encodeByMD5(creditManager.getPassword()));
			
			while (true) {
				//邀请码生成
				String invitationCode = SecurityUtils.randomStr(6);
				
				int checkResult=creditManagerDAO.checkInvitationCode(invitationCode);
				
				if (checkResult == 0) {
					creditManager.setInvitationCode(invitationCode);
					break;
				}
			}
			
			int result = creditManagerDAO.saveCreditManager(creditManager);
			if (result > 0) {
				return true;
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
		return false;
	}

	@Override
	public CreditManager getCreditManagerById(String managerId) {
		
		return creditManagerDAO.getCreditManagerById(managerId);
	}

	@Override
	public AuthenticationCM getAuthenticationById(String managerId) {
		
		return creditManagerDAO.getAuthenticationById(managerId);
	}

	@Override
	public int getInvitationMemberCount(String managerId) {
		
		return creditManagerDAO.getInvitationMemberCount(managerId);
	}

	@Override
	public List<InvitationMemberInfo> getInvitationMemberInfo(String managerId,int page) {
		
		return creditManagerDAO.getInvitationMemberInfo(managerId,(page-1)*10);
	}

	@Override
	public int getInvitationMemberRecords(String managerId) {
		
		return creditManagerDAO.getInvitationMemberRecords(managerId);
	}

	@Override
	public int getInvitationManagerCount(String managerId) {
		
		return creditManagerDAO.getInvitationManagerCount(managerId);
	}

	@Override
	public List<InvitationMemberInfo> getInvitationManagerInfo(
			String managerId, int page) {
		
		return creditManagerDAO.getInvitationManagerInfo(managerId,(page-1)*10);
	}

	@Override
	public int getInvitationManagerRecords(String managerId) {
		
		return creditManagerDAO.getInvitationManagerRecords(managerId);
	}

	@Override
	public MoneyOutline getMoneyAccountByManagerId(String managerId) {
		
		return creditManagerDAO.getMoneyAccountByManagerId(managerId);
	}

	@Override
	public List<Order> getServerRatingByManagerId(String managerId, int page, int star) {
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("managerId", managerId);
		map.put("index", (page-1)*10);
		map.put("star", star);
		
		return creditManagerDAO.getServerRating(map);
	}

	@Override
	public int getServerRatingCount(String managerId) {
		return creditManagerDAO.getServerRatingCount(managerId);
	}

	@Override
	public int getServerStar(String managerId) {
		
		int result = 0;
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("managerId", managerId);
		map.put("index", "");
		map.put("star", 0);
		
		List<Order> orders = creditManagerDAO.getServerRating(map);
		
		int size = 0;
		int stars = 0;
		for (int i = 0; i < orders.size(); i++) {
			if (orders.get(i).getLevel() != null && !orders.get(i).getLevel().equals("")) {
				stars = stars + Integer.parseInt(orders.get(i).getLevel());
				size++;
			}
		}
		
		if (size > 0) {
			result = stars / size;
		}
		
		return result;
	}
	
	

}
