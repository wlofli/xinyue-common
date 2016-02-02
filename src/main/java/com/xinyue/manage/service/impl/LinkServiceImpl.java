package com.xinyue.manage.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.xinyue.manage.beans.SearchFsAndCo;
import com.xinyue.manage.beans.SelectInfo;
import com.xinyue.manage.dao.LinkInfoDAO;
import com.xinyue.manage.model.Cooperation;
import com.xinyue.manage.model.LinkFriendShip;
import com.xinyue.manage.service.LinkService;

/**
 * 友情链接service
 * @author MK)茅
 *
 */
@Service
public class LinkServiceImpl implements LinkService {

	@Resource
	LinkInfoDAO linkInfoDAO;
	
	Logger log = Logger.getLogger(LinkServiceImpl.class);
		
	@Override
	public List<SelectInfo> getLinkType(String code) {
		
		return linkInfoDAO.getLinkTypeList(code);
	}

	@Override
	public boolean saveFriendShipLink(LinkFriendShip linkFriendShip, String user,boolean flag) {
		
		HashMap<String, Object> parMap = new HashMap<>();
		
		try {
			parMap.clear();
			//链接名称
			parMap.put("name", linkFriendShip.getName());
			//图片路径
			parMap.put("imagePath", linkFriendShip.getLogoPath());
			//显示文本
			parMap.put("text", linkFriendShip.getLinkText());
			//网址
			parMap.put("url", linkFriendShip.getLinkUrl());
			//所属城市
			if (linkFriendShip.getLinkZone() != null && !linkFriendShip.getLinkZone().equals("") && !linkFriendShip.getLinkZone().equals("0")) {
				parMap.put("location", linkFriendShip.getLinkZone());
			}else if (linkFriendShip.getLinkCity() != null && !linkFriendShip.getLinkCity().equals("") && !linkFriendShip.getLinkCity().equals("0")) {
				parMap.put("location",linkFriendShip.getLinkCity() );
			}else if (linkFriendShip.getLinkProvince() != null && !linkFriendShip.getLinkProvince().equals("") && !linkFriendShip.getLinkProvince().equals("0")) {
				parMap.put("location", linkFriendShip.getLinkProvince() );
			}else {
				parMap.put("location", "");
			}
			//链接类型
			parMap.put("type", linkFriendShip.getLinkType());
			//截止日
			if (linkFriendShip.getDeadLine()==null || linkFriendShip.getDeadLine().equals("")) {
				parMap.put("deadLine", null);
				parMap.put("status", true);
			} else {
				parMap.put("deadLine", linkFriendShip.getDeadLine());
				parMap.put("status", false);
			}
			parMap.put("user", user);
			
			//添加
			if (flag) {
				SimpleDateFormat df = new SimpleDateFormat("yyyyMMddss");
				String code = "fs_"+ df.format(new Date());
				//唯一识别码
				parMap.put("code", code);
				linkInfoDAO.addFriendShipLinkInfo(parMap);
			//修改
			} else {
				parMap.put("code", linkFriendShip.getCode());
				linkInfoDAO.updateFriendShipLinkInfo(parMap);
			}
			
			
		} catch (Exception e) {
			log.error(e.toString());
			return false;
		}
		return true;
	}

	@Override
	public List<LinkFriendShip> getList(SearchFsAndCo searchFriendShip,int index) {
		
		List<LinkFriendShip> listTemp = null;
		List<LinkFriendShip> list = new ArrayList<LinkFriendShip>();
		HashMap<String, Object> parMap = new HashMap<>();
		
		try {
			parMap.clear();
			//分页
			parMap.put("index", index);
			//链接名称
			parMap.put("linkName", searchFriendShip.getLinkName());
			//链接类型
			if (!searchFriendShip.getLinkType().equals("") && !searchFriendShip.getLinkType().equals("0")) {
				parMap.put("linkType", searchFriendShip.getLinkType());
			}else {
				parMap.put("linkType", "");
			}
			//状态
			parMap.put("linkPublish", searchFriendShip.getLinkStatus());
			//所属城市
			if (searchFriendShip.getSearchZone().equals("0") || searchFriendShip.getSearchZone().equals("")) {
				if (searchFriendShip.getSearchCity().equals("0") || searchFriendShip.getSearchCity().equals("")) {
					parMap.put("location", searchFriendShip.getSearchProvince());
				}else {
					parMap.put("location", searchFriendShip.getSearchCity());
				}
			}else {
				parMap.put("location", searchFriendShip.getSearchZone());
			}
			
			listTemp = linkInfoDAO.getList(parMap);
			//判断截止日期（长期 OR 日期）
			if (listTemp != null && listTemp.size() > 0) {
				for (int i = 0; i < listTemp.size(); i++) {
					LinkFriendShip link = listTemp.get(i);
					
					if (link.getLinkStatus().equals("1")) {
						link.setDeadLine("长期");
					}
					list.add(link);
				}
			}
		} catch (Exception e) {
			list = null;
			log.error(e.toString());
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public boolean deleteFriendShipLinkByCode(String code,String user) {
		
		String[] codeTemp = code.split("~");
		
		try {
			for (int i = 0; i < codeTemp.length; i++) {
				if (!codeTemp[i].equals("")) {
					linkInfoDAO.deleteFriendShipLinkByCode(codeTemp[i],user);
				}
			}
			
			return true;
		} catch (Exception e) {
			log.error(e.toString());
		}
		return false;
	}

	@Override
	public LinkFriendShip getFriendShipInfoByCode(String code) {
		
		LinkFriendShip lfs = new LinkFriendShip();
		
		lfs = linkInfoDAO.getFriendShipInfoByCode(code);
		
		if (lfs != null) {
			if (lfs.getLogoPath() == null) {
				lfs.setLogoPath("");
			}
			lfs.setLogoPathHid(lfs.getLogoPath());
			
			String province = lfs.getLinkCity().substring(0, 2)+"0000";
			
			String city = lfs.getLinkCity().substring(0, 4)+"00";
			
			String Zone = lfs.getLinkCity();
			
			lfs.setLinkProvince(province);
			lfs.setLinkCity(city);
			lfs.setLinkCityHid(city);
			lfs.setLinkZone(Zone);
			lfs.setLinkZoneHid(Zone);
			
		}
		return lfs;
	}

	@Override
	public List<SelectInfo> getLinkStatus(String code) {
		
		return linkInfoDAO.getLinkStatusList(code);
	}

	@Override
	public void updateDeadLine() {
		//取得过期合作机构列表
		List<String> overdueList = linkInfoDAO.getOverdueData();
		
		try {
			//更新状态
			if (overdueList!=null && overdueList.size() > 0) {
				linkInfoDAO.updateStatus(overdueList);
			}
		} catch (Exception e) {
			log.error(e.toString());
		}
	}

	@Override
	public boolean publishLinkByCode(String enCode, String user) {
		List<String> codeList = new ArrayList<String>();
		try {
			String[] arrCode = enCode.split("~");
			
			for (int i = 0; i < arrCode.length; i++) {
				codeList.add(arrCode[i]);
			}
			
			int ret = linkInfoDAO.publishLinkByCode(codeList,user);
			
			if (ret > 0) {
				return true;
			}
		} catch (Exception e) {
			log.error(e.toString());
		}
		return false;
	}

	@Override
	public boolean forbidLinkByCode(String enCode, String user) {
		List<String> codeList = new ArrayList<String>();
		try {
			String[] arrCode = enCode.split("~");
			
			for (int i = 0; i < arrCode.length; i++) {
				codeList.add(arrCode[i]);
			}
			
			int ret = linkInfoDAO.forbidLinkByCode(codeList,user);
			
			if (ret > 0) {
				return true;
			}
		} catch (Exception e) {
			log.error(e.toString());
		}
		return false;
	}

	@Override
	public boolean checkIndexByIndex(String index) {
		try {
			int resault = linkInfoDAO.checkIndexByIndex(index);
			
			if (resault == 0) {
				return true;
			}
		} catch (Exception e) {
			log.error(e.toString());
		}
		return false;
	}

	@Override
	public boolean updateSortIndex(String code, String index, String user) {
		try {
			//更新序列
			int resault = linkInfoDAO.updateSortIndex(code, index,user);
			
			if (resault > 0) {
				return true;
			}
		} catch (Exception e) {
			log.error(e.toString());
		}
		return false;
	}

	@Override
	public int getCount(SearchFsAndCo searchFriendShip) {
		int ret = 0;

		HashMap<String, Object> parMap = new HashMap<>();

		parMap.clear();
		//链接名称
		parMap.put("linkName", searchFriendShip.getLinkName());
		//链接类型
		if (!searchFriendShip.getLinkType().equals("") && !searchFriendShip.getLinkType().equals("0")) {
			parMap.put("linkType", searchFriendShip.getLinkType());
		}else {
			parMap.put("linkType", "");
		}
		//状态
		parMap.put("linkPublish", searchFriendShip.getLinkStatus());
		//所属城市
		if (searchFriendShip.getSearchZone().equals("0") || searchFriendShip.getSearchZone().equals("")) {
			if (searchFriendShip.getSearchCity().equals("0") || searchFriendShip.getSearchCity().equals("")) {
				parMap.put("location", searchFriendShip.getSearchProvince());
			}else {
				parMap.put("location", searchFriendShip.getSearchCity());
			}
		}else {
			parMap.put("location", searchFriendShip.getSearchZone());
		}

		ret = linkInfoDAO.getCount(parMap);
		return ret;
	}

}
