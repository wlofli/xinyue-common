package com.xinyue.manage.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.xinyue.manage.beans.SearchFsAndCo;
import com.xinyue.manage.dao.CooperationInfoDAO;
import com.xinyue.manage.model.Cooperation;
import com.xinyue.manage.service.CooperationService;

/**
 * 
 * @author MK)茅
 *
 */
@Service
public class CooperationServiceImpl implements CooperationService {

	@Resource
	CooperationInfoDAO cooperationInfoDAO;
	
	//log
	Logger log = Logger.getLogger(CooperationServiceImpl.class);
	
	@Override
	public List<Cooperation> getList(SearchFsAndCo searchCooperation, int index) {
		
		List<Cooperation> listTemp = null;
		List<Cooperation> list = new ArrayList<>();
		
		HashMap<String, Object> parMap = new HashMap<>();
		
		try {
			parMap.clear();
			//分页
			parMap.put("index", index);
			//机构名称
			parMap.put("linkName", searchCooperation.getLinkName());
			//链接类型
			parMap.put("linkType", searchCooperation.getLinkType());
			//状态
			parMap.put("status", searchCooperation.getLinkStatus());
			//所属城市
			if (searchCooperation.getSearchZone().equals("0") || searchCooperation.getSearchZone().equals("")) {
				if (searchCooperation.getSearchCity().equals("0") || searchCooperation.getSearchCity().equals("")) {
					parMap.put("location", searchCooperation.getSearchProvince());
				}else {
					parMap.put("location", searchCooperation.getSearchCity());
				}
			}else {
				parMap.put("location", searchCooperation.getSearchZone());
			}
			//获取列表信息
			list.clear();
			listTemp = cooperationInfoDAO.getList(parMap);
			
			//判断截止日期（长期 OR 日期）
			if (listTemp != null && listTemp.size() > 0) {
				for (int i = 0; i < listTemp.size(); i++) {
					Cooperation coop = listTemp.get(i);
					
					if (coop.getCoopStatus().equals("1")) {
						coop.setDeadLine("长期");
					}
					list.add(coop);
				}
			}
			
		} catch (Exception e) {
			log.error(e.toString());
			list = null;
		}
		
		return list;
	}

	@Override
	public Cooperation getCooperationInfoByCode(String code) {
		
		Cooperation cooperation = cooperationInfoDAO.getCooperationInfoByCode(code);
		
		if (cooperation != null) {
			if (cooperation.getLogoPath() == null) {
				cooperation.setLogoPath("");
			}
			cooperation.setLogoPathHid(cooperation.getLogoPath());
			
			String province = cooperation.getCoopCity().substring(0, 2)+"0000";
			
			String city = cooperation.getCoopCity().substring(0, 4)+"00";
			
			String zone = cooperation.getCoopCity();
			
			cooperation.setCoopProvince(province);
			cooperation.setCoopCity(city);
			cooperation.setCoopCityHid(city);
			cooperation.setCoopZone(zone);
			cooperation.setCoopZoneHid(zone);
		}
		
		return cooperation;
	}

	@Override
	public boolean saveCooperation(Cooperation cooperation, String user,
			boolean flag) {
		HashMap<String, Object> parMap = new HashMap<>();
		
		parMap.clear();
		
		try {
			//链接名称
			parMap.put("name", cooperation.getName());
			//图片路径
			parMap.put("imageUrl", "cooperate/co/");
			parMap.put("imageName", cooperation.getLogoPathHid());
			//显示文本
			parMap.put("text", cooperation.getCoopText());
			//网址
			parMap.put("url", cooperation.getCoopUrl());
			//所属城市
			if (!cooperation.getCoopZone().equals("") && !cooperation.getCoopZone().equals("0")) {
				parMap.put("location", cooperation.getCoopZone());
			}else if (!cooperation.getCoopCity().equals("") && !cooperation.getCoopCity().equals("0")) {
				parMap.put("location", cooperation.getCoopCity());
			}else if (!cooperation.getCoopProvince().equals("") && !cooperation.getCoopProvince().equals("0")) {
				parMap.put("location", cooperation.getCoopProvince());
			}else {
				parMap.put("location", "");
			}
			
			//链接类型
			parMap.put("type", cooperation.getCoopType());
			//截止日
			if (cooperation.getDeadLine()==null || cooperation.getDeadLine().equals("")) {
				parMap.put("deadLine", null);
				parMap.put("status", "1");
			} else {
				parMap.put("deadLine", cooperation.getDeadLine());
				parMap.put("status", "2");
			}
			parMap.put("user", user);
			
			int ret = 0;
			//添加
			if (flag) {
				String code = UUID.randomUUID().toString().replace("-", "");
				//唯一识别码
				parMap.put("code", code);
				ret = cooperationInfoDAO.addFriendShipLinkInfo(parMap);
				
				if (ret>0) {
					return true;
				}
			//修改
			} else {
				parMap.put("code", cooperation.getCode());
				ret = cooperationInfoDAO.updateFriendShipLinkInfo(parMap);
				if (ret>0) {
					return true;
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean deleteCooperationByCode(String code,String user) {
		
		List<String> codeList = new ArrayList<String>();
		
		try {
			String[] arrCode = code.split("~");
			
			for (int i = 0; i < arrCode.length; i++) {
				codeList.add(arrCode[i]);
			}
			
			int ret = cooperationInfoDAO.deleteCooperationByCode(codeList,user);
			
			if (ret > 0) {
				return true;
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean publishCooperationByCode(String code, String user) {
		List<String> codeList = new ArrayList<String>();
		try {
			String[] arrCode = code.split("~");
			
			for (int i = 0; i < arrCode.length; i++) {
				codeList.add(arrCode[i]);
			}
			
			int ret = cooperationInfoDAO.publishCooperationByCode(codeList,user);
			
			if (ret > 0) {
				return true;
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean forbidCooperationByCode(String code, String user) {
		List<String> codeList = new ArrayList<String>();
		try {
			String[] arrCode = code.split("~");
			
			for (int i = 0; i < arrCode.length; i++) {
				codeList.add(arrCode[i]);
			}
			
			int ret = cooperationInfoDAO.forbidCooperationByCode(codeList,user);
			
			if (ret > 0) {
				return true;
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return false;
	}

	@Override
	public void updateDeadLine() {
		//取得过期合作机构列表
		List<String> overdueList = cooperationInfoDAO.getOverdueData();
		
		try {
			//更新状态
			if (overdueList!=null && overdueList.size() > 0) {
				cooperationInfoDAO.updateStatus(overdueList);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	@Override
	public boolean checkIndexByIndex(String index) {
		try {
			int resault = cooperationInfoDAO.checkIndexByIndex(index);
			
			if (resault == 0) {
				return true;
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean updateSortIndex(String code, String index,String user) {
		try {
			//更新序列
			int resault = cooperationInfoDAO.updateSortIndex(code, index,user);
			
			if (resault > 0) {
				return true;
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return false;
	}

	@Override
	public int getCount(SearchFsAndCo searchCooperation) {
		
		int ret = 0;

		HashMap<String, Object> parMap = new HashMap<>();

		parMap.clear();
		// 机构名称
		parMap.put("linkName", searchCooperation.getLinkName());
		// 链接类型
		parMap.put("linkType", searchCooperation.getLinkType());
		// 状态
		parMap.put("status", searchCooperation.getLinkStatus());
		// 所属城市
		if (searchCooperation.getSearchZone().equals("0")
				|| searchCooperation.getSearchZone().equals("")) {
			if (searchCooperation.getSearchCity().equals("0")
					|| searchCooperation.getSearchCity().equals("")) {
				parMap.put("location", searchCooperation.getSearchProvince());
			} else {
				parMap.put("location", searchCooperation.getSearchCity());
			}
		} else {
			parMap.put("location", searchCooperation.getSearchZone());
		}

		ret = cooperationInfoDAO.getCount(parMap);

		return ret;
	}

}
