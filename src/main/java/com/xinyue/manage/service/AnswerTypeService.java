package com.xinyue.manage.service;

import java.util.List;

import com.xinyue.manage.beans.AnswerTypeBean;
import com.xinyue.manage.beans.PageData;
import com.xinyue.manage.model.AnswerType;

/**
 * 
 * @author wenhai.you
 * @2015年9月30日
 * @上午9:22:32
 */
public interface AnswerTypeService {

	
	/**
	 * ywh 获取问题类型每页数据
	 * @param topage
	 * @return
	 */
	public PageData<AnswerType> findPageAnswerType(String topage , String type);
	
	/**
	 * ywh 获取问题类型一级数据
	 * @param topage
	 * @return
	 */
	public List<AnswerType> findAnswerType();
	
	/**
	 * ywh 删除
	 * @param id
	 */
	public boolean delAnswertype(String id , String createUser);
	
	/**
	 * ywh 添加
	 * @param abean
	 */
	public boolean updateAnswertype(AnswerType abean);

	/**
	 * ywh 更改状态
	 * @param id
	 * @param status
	 */
	public boolean updateStatus(String id ,String status);
	
	

	
	
	/**
	 * ywh 根据id加载
	 * @param id
	 * @return
	 */
	public AnswerType getAnswertypeById(String id);
	
}
