package com.xinyue.manage.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.xinyue.manage.beans.AnswerTypeBean;
import com.xinyue.manage.beans.PageData;
import com.xinyue.manage.dao.AnswerDao;
import com.xinyue.manage.dao.AnswerTypeDao;
import com.xinyue.manage.model.AnswerType;
import com.xinyue.manage.service.AnswerTypeService;
import com.xinyue.manage.util.GlobalConstant;

/**
 * 
 * @author wenhai.you
 * @2015年9月30日
 * @上午9:23:59
 */
@Service
public class AnswerTypeServiceImpl implements AnswerTypeService {

	
	@Resource
	private AnswerTypeDao adao;
	
	@Resource
	private AnswerDao answerDao;
	
	private Logger logger = Logger.getLogger(AnswerTypeServiceImpl.class); 
	@Override
	public PageData<AnswerType> findPageAnswerType(String topage , String type) {
		// TODO Auto-generated method stub
		int currentPage = GlobalConstant.isNull(topage) || "0".equals(topage)?1:Integer.valueOf(topage);
		int start = (currentPage - 1)*GlobalConstant.PAGE_SIZE;
		return new PageData<AnswerType>(adao.findPageAanswerType(type, start, GlobalConstant.PAGE_SIZE)
				, adao.getPageAanswerType(type), currentPage);
	}
	
	@Override
	public List<AnswerType> findAnswerType() {
		// TODO Auto-generated method stub
		return adao.findAanswerType(true);
	}

	@Override
	public boolean updateAnswertype(AnswerType abean) {
		// TODO Auto-generated method stub
		if(GlobalConstant.isNull(abean.getId()) ){
			try {
				adao.addAnswertype(abean);
				logger.info("添加问题类型成功");
				return true;
			} catch (Exception e) {
				// TODO: handle exception
				logger.error("添加问题类型失败", e);
				return false;
			}
		}else{
			try {
				adao.updateAnswertype(abean);
				logger.info("修改问题类型成功");
				return true;
			} catch (Exception e) {
				// TODO: handle exception
				logger.error("修改问题类型失败", e);
				return false;
			}
		}
		
	}
	
	@Override
	public boolean delAnswertype(String id, String createUser) {
		// TODO Auto-generated method stub
		try {
			List<String> ids = adao.findIdByParentid(id);
			adao.delAnswertype(id);
			answerDao.cleanForeignByQuestionType(ids, createUser);
			logger.info("删除问题类型成功并清空问题对应问题类型外键成功");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("删除问题类型并清空问题对应问题类型外键失败", e);
			throw new RuntimeException("删除问题类型并清空问题对应问题类型外键失败", e);
		}
	}
	
	@Override
	public boolean updateStatus(String id, String status) {
		// TODO Auto-generated method stub
		if("1".equals(status)){
			try {
				adao.updateStatus(id, status);
				adao.updateAllStatusByParent(id);
				logger.info("禁用问题类型成功");
				return true;
			} catch (Exception e) {
				// TODO: handle exception
				logger.error("禁用问题类型失败", e);
				throw new RuntimeException("禁用问题类型失败", e);
			}
		}else{
			try {
				adao.updateStatus(id, status);
				logger.info("启用问题类型成功");
				return true;
			} catch (Exception e) {
				// TODO: handle exception
				logger.error("启用问题类型失败", e);
				return false;
			}
		}
	}
	
	
	@Override
	public AnswerType getAnswertypeById(String id) {
		// TODO Auto-generated method stub
		return adao.getAnswertypeById(id);
	}
	
	
}
