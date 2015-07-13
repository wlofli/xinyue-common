package com.xinyue.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xinyue.manage.beans.SearchNew;
import com.xinyue.manage.beans.SelectInfo;
import com.xinyue.manage.model.NewInfo;
import com.xinyue.manage.model.NewType;
/**
 * 
 * @author lzc
 * @date 2015年6月26日上午10:55:37
 */
public interface NewDAO {
	//newType表
	public void addNewType(NewType newType);
	
	public List<NewType> getNewTypeByPage(@Param("pageNo")int pageNo, @Param("pageSize")int pageSize);
	/**
	 * 获取所有新闻类型
	 * 包括新闻类型ID,新闻类型名称
	 */
	public List<SelectInfo> getAllNewTypeList();
	
	public void deleteNewType(@Param("id")String id,@Param("modifiedId")String modifiedId);
	
	public void updateNewType(NewType newType);
	
	public NewType getNewType(String id);
	
	public int getNewTypeCount();
	
	public int getNewNumber(String id);
	
	/**
	 * 
	 * @param idList 需要修改的新闻类型id列表
	 * @param status 0 status字段修改 1 delete字段修改
	 */
	public void updateNewTypes(@Param("list")List<String> idList, @Param("status")int status,@Param("modifiedId")String modifiedId);
	
	//newInfo表
	
	public List<NewInfo> getListByPage(@Param("pageNo")int pageNo, @Param("pageSize")int pageSize, 
			@Param("searchNew")SearchNew searchNew);
	
	public void addNewInfo(NewInfo newInfo);
	
	public void updateNewInfo(NewInfo newInfo);
	
	public void deleteNewInfo(@Param("id")String id,@Param("modifiedId")String modifiedId);
	
	public NewInfo getNewInfo(String id);
	
	public int getNewInfoCount(@Param("searchNew")SearchNew searchNew);
	
	/**
	 * 
	 * @param idList 需要修改的新闻id列表
	 * @param status 0 status字段修改 1 delete字段修改
	 */
	public void updateNewInfos(@Param("list")List<String> idList,@Param("status")int status,@Param("modifiedId")String modifiedId);

	
//	关联表的内容
	public List<SelectInfo> getAllSubstationList();
	
	public List<SelectInfo> getSearchNewType(@Param("typeCode")String typeCode);
}
