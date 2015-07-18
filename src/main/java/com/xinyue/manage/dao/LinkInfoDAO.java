package com.xinyue.manage.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xinyue.manage.beans.SelectInfo;
import com.xinyue.manage.model.LinkFriendShip;

public interface LinkInfoDAO {

	List<SelectInfo> getLinkTypeList(String code);
	
	void addFriendShipLinkInfo(HashMap<String, Object> map);
	
	List<LinkFriendShip> getList(HashMap<String, Object> map);
	
	void deleteFriendShipLinkByCode(@Param("code")String code,@Param("user")String user);
	
	LinkFriendShip getFriendShipInfoByCode(String code);
	
	void updateFriendShipLinkInfo(HashMap<String, Object> map);

	List<SelectInfo> getLinkStatusList(String code);
	
	List<String> getOverdueData();
	
	int updateStatus(@Param("code")List<String> code);

	int publishLinkByCode(@Param("code")List<String> codeList, @Param("user")String user);

	int forbidLinkByCode(@Param("code")List<String> codeList, @Param("user")String user);

	int checkIndexByIndex(String index);

	int updateSortIndex(@Param("code")String code,@Param("index")String index,@Param("user")String user);

	int getCount(HashMap<String, Object> parMap);
	
}
