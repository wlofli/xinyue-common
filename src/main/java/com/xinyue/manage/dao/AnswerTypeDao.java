package com.xinyue.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xinyue.manage.beans.AnswerTypeBean;
import com.xinyue.manage.model.AnswerType;

/**
 * 
 * @author wenhai.you
 * @2015年8月6日
 * @下午3:51:19
 */
public interface AnswerTypeDao {

	
	/**
	 * ywh 获取问题类型每页数据
	 * @param type
	 * @param start
	 * @param pageSize
	 * @return
	 */
	public List<AnswerType> findPageAanswerType(@Param("type")String type , @Param("start")int start , @Param("pageSize")int pageSize);
	
	/**
	 * ywh 获取一级问题类型数据
	 * @param type
	 * @param start
	 * @param pageSize
	 * @return
	 */
	public List<AnswerType> findAanswerType(@Param("parent")boolean parent);
	/**
	 * ywh 获取问题类型总记录数
	 * @param type
	 * @return
	 */
	public int getPageAanswerType(@Param("type")String type);
	
	
	/**
	 * ywh 删除
	 * @param id
	 */
	public void delAnswertype(String id);
	
	/**
	 * ywh 删除
	 * @param id
	 */
	public void delAllAnswerTypeByParentid(String id);
	
	/**
	 * ywh 添加
	 * @param abean
	 */
	public void addAnswertype(AnswerType abean);

	/**
	 * ywh 更改状态
	 * @param id
	 * @param status
	 */
	public void updateStatus(@Param("id")String id ,@Param("status")String status);
	
	/**
	 * ywh 更改状态
	 * @param id
	 * @param status
	 */
	public void updateAllStatusByParent(@Param("id")String id);
	/**
	 * ywh 修改问题类型
	 * @param abean
	 */
	public void updateAnswertype(AnswerType abean);
	
	/**
	 * ywh 根据id加载
	 * @param id
	 * @return
	 */
	public AnswerType getAnswertypeById(String id);
}
