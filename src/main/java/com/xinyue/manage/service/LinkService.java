package com.xinyue.manage.service;

import java.util.List;

import com.xinyue.manage.beans.SearchFsAndCo;
import com.xinyue.manage.beans.SelectInfo;
import com.xinyue.manage.model.LinkFriendShip;

public interface LinkService {

	//友情链接
	List<SelectInfo> getLinkType(String code);
	
	boolean saveFriendShipLink(LinkFriendShip linkFriendShip,String user,boolean flag);
	
	List<LinkFriendShip> getList(SearchFsAndCo searchFriendShip,int index);
	
	boolean deleteFriendShipLinkByCode(String code,String user);
	
	LinkFriendShip getFriendShipInfoByCode(String code);
	
	List<SelectInfo> getLinkStatus(String code);
	
	void updateDeadLine();

	boolean publishLinkByCode(String enCode, String user);

	boolean forbidLinkByCode(String enCode, String user);

	boolean checkIndexByIndex(String index);

	boolean updateSortIndex(String code, String index, String user);

	int getCount(SearchFsAndCo searchFriendShip);
	
	
}
