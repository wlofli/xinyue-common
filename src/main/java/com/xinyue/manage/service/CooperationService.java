package com.xinyue.manage.service;

import java.util.List;

import com.xinyue.manage.beans.SearchFsAndCo;
import com.xinyue.manage.model.Cooperation;


public interface CooperationService {

	//合作机构
	List<Cooperation> getList(SearchFsAndCo searchCooperation,int index);
	
	Cooperation getCooperationInfoByCode(String code);
	
	boolean saveCooperation(Cooperation cooperation,String user,boolean flag);
	
	boolean deleteCooperationByCode(String code,String user);
	
	boolean publishCooperationByCode(String code,String user);
	
	boolean forbidCooperationByCode(String code,String user);
	
	void updateDeadLine();
	
	boolean checkIndexByIndex(String index);
	
	boolean updateSortIndex(String code,String index,String user);

	int getCount(SearchFsAndCo searchCooperation);
}
