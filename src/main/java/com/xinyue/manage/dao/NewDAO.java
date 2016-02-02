package com.xinyue.manage.dao;

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
 * @date 2015年6月26日上午10:55:37
 */
/**
 * lzc 15-12-03 getNewInfoByNewTypeNamet方法添加
 *
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
	
	public List<SelectInfo> getAllNewTypeListExceptIdList(@Param("idList")List<String> idList);
	
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
	
	
	public List<NewInfo> getListByTime(@Param("pageNo")int pageNo, @Param("pageSize")int pageSize, @Param("searchNew")SearchNew searchNew);
	
	//获取置顶的新闻
	public List<NewInfo> getListByTop(@Param("pageSize")int pageSize,@Param("pageNo")int pageNo);
	
	/**
	 * add by lzc     date: 2015年12月3日
	 * @param typeName新闻类型名称 e.t.c 贷款攻略
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<NewInfo> getNewInfoByNewTypeName(@Param("name")String typeName, @Param("pageNo")int pageNo, @Param("pageSize")int pageSize);
	
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

	
	/**获取离时间最近的相同新闻类型的新闻列表
	 * add by lzc     date: 2015年8月6日
	 * @param typeId 新闻类型
	 * @param modifiedTime 时间
	 * @param type 0 ->before  1->after
	 * @param pageNo  可能没什么用
	 * @param pageSize
	 * @return key->id value->name
	 */
	public List<SelectInfo>  getRecentlyInfoList(@Param("typeId")String typeId, @Param("date")Date modifiedTime, 
			@Param("type")int type, @Param("pageNo")int pageNo, @Param("pageSize")int pageSize);
	
//	关联表的内容
	public List<SelectInfo> getAllSubstationList();
	
	public List<SelectInfo> getSearchNewType(@Param("typeCode")String typeCode);
}
