package com.xinyue.manage.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xinyue.manage.beans.SearchNew;
import com.xinyue.manage.beans.SelectInfo;
import com.xinyue.manage.model.NewInfo;
import com.xinyue.manage.model.NewType;


/**
 * 
 * @author lzc
 * @date 2015年6月26日上午10:56:31
 */
public interface NewService {
	
	//newType类操作
	public boolean addNewType(NewType newType);
	
	public List<NewType> getNewTypeByPage(int index);
	
	public List<NewType> getNewTypeByPage(int pageNo, int pageSize);
	
	public NewType getNewType(String id);
	
	public boolean deleteNewType(@Param("id")String id,@Param("modifiedId")String modifiedId);
	
	public boolean updateNewType(NewType newType);
	//获取新闻类型对应的新闻数量
	public int getNewNumber(String id);
	
	
	public int getNewTypeCount();
	
	
	public List<SelectInfo> getAllNewTypeList();
	
	//获取所有除了idList里的新闻类型
	public List<SelectInfo> getAllNewTypeList(List<String> idList);
	
	/**
	 * 
	 * @param idList 需要修改的新闻类型id列表
	 * @param status 0 status字段修改 1 delete字段修改
	 * @param modifiedId 修改id
	 */
	public boolean updateNewType(List<String> idList, int status,String modifiedId);
	
	//newInfo类操作
	public List<NewInfo> getNewInfoListByPage(int index,SearchNew searchNew);
	
	
	public boolean addNewInfo(NewInfo newInfo);
	
	public boolean updateNewInfo(NewInfo newInfo);
	
	public boolean deleteNewInfo(String id,String modifiedId);
	
	public NewInfo getNewInfo(String id);
	
	public int getNewInfoCount(SearchNew searchNew);

	public List<SelectInfo> getAllSubstationList();
	//获取固定的seleInfoList
	public List<SelectInfo> getSearchNewList(String typeCode);
	
	
	/**
	 * 
	 * @param idList 需要修改的新闻id列表
	 * @param status 0 status字段修改 1 delete字段修改
	 * @param username 修改人id
	 */
	public boolean updateNewInfo(List<String> idList,int status,String modifiedId);
	
	
	//前台新闻操作
	public List<NewInfo> getNewInfoListByTime(SearchNew searchNew, int pageNo, int pageSize);

	
	public SelectInfo getRecentNew(String typeId, Date sendDate,int type);
}
