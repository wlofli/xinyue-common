package com.xinyue.manage.dao;


import java.util.List;



import org.apache.ibatis.annotations.Param;
/**
 * 
 * @author lzc
 * @date 2015年6月26日上午10:55:42
 */

public interface NewSubstationDAO {
	
	public void addNewSubstation(@Param("list")List<String> list, @Param("value")String value);

	public void deleteNewSubstation(String value);
	
	//根据新闻id获取对应的substationlist的id
	public List<String> getNewSubstationList(String id);
	
	
	//根据新闻id获取对应的substationlist的id对应的城市名称
	public List<String> getNewSubstationListName(String id);

}
