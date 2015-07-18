package com.xinyue.manage.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xinyue.manage.model.Cooperation;

public interface CooperationInfoDAO {

	List<Cooperation> getList(HashMap<String, Object> map);
	
	Cooperation getCooperationInfoByCode(String code);
	
	int addFriendShipLinkInfo(HashMap<String, Object> map);
	
	int updateFriendShipLinkInfo(HashMap<String, Object> map);
		
	int deleteCooperationByCode(@Param("code")List<String> code,@Param("user")String user);
	
	int publishCooperationByCode(@Param("code")List<String> code,@Param("user")String user);
	
	int forbidCooperationByCode(@Param("code")List<String> code,@Param("user")String user);
	
	List<String> getOverdueData();
	
	int updateStatus(@Param("code")List<String> code);
	
	int checkIndexByIndex(String index);
	
	int updateSortIndex(@Param("code")String code,@Param("index")String index,@Param("user")String user);

	int getCount(HashMap<String, Object> map);
}
