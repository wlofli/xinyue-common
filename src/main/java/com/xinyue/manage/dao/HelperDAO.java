package com.xinyue.manage.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xinyue.manage.beans.SelectInfo;
import com.xinyue.manage.model.HelpType;
import com.xinyue.manage.model.Helper;

public interface HelperDAO {

	List<Helper> getList(int index);

	int getCount();

	int publishHelperByCode(@Param("codeList")List<String> codeList, @Param("user")String user);

	int forbidHelperByCode(@Param("codeList")List<String> codeList, @Param("user")String user);

	int deleteHelperByCode(@Param("codeList")List<String> codeList, @Param("user")String user);

	Helper getHelperByCode(String code);

	int updateHelperByCode(HashMap<String, Object> map);

	int addHelperByCode(HashMap<String, Object> map);

	int addHelpType(HelpType helpType);

	List<SelectInfo> getTypes();

	List<Helper> getAllListByIndex();
	
	//ywh start 2015-11-19 帮助分类
	public List<HelpType> findHelpType(@Param("start")int start , @Param("pageSize")int pageSize);
	
	public int findHelpTypeCount();
	
	public void upatePublishHelperType(@Param("list")List<String> list , @Param("user")String user);
	
	public void deleteHelperType(@Param("list")List<String> list , @Param("user")String user);
	
	public HelpType findHelpTypeById(@Param("id")String id);
	//ywh over
}
