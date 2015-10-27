package com.xinyue.manage.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.xinyue.manage.beans.SearchNew;
import com.xinyue.manage.beans.SelectInfo;
import com.xinyue.manage.dao.NewDAO;
import com.xinyue.manage.dao.NewSubstationDAO;
import com.xinyue.manage.model.NewInfo;
import com.xinyue.manage.model.NewType;
import com.xinyue.manage.service.NewService;
import com.xinyue.manage.util.GlobalConstant;
/**
 * 
 * @author lzc
 * @date 2015年6月26日上午10:56:48
 */
@Service
public class NewServiceImpl implements NewService {

	@Resource
	private NewDAO newDAO;
	
	@Resource
	private NewSubstationDAO newSubstationDAO;
	
	private Logger logger = Logger.getLogger(getClass());
	
	@Override
	public boolean addNewType(NewType newType) {
		// TODO Auto-generated method stub
		try {
			newDAO.addNewType(newType);
		} catch (Exception e) {
			// TODO: handle exception
			logger.info(e.toString());
			throw new RuntimeException();
		}
		return true;
	}

	@Override
	public List<NewInfo> getNewInfoListByPage(int index, SearchNew searchNew) {
		// TODO Auto-generated method stub
		formatSearchNew(searchNew);
		return newDAO.getListByPage(index * GlobalConstant.PAGE_SIZE, GlobalConstant.PAGE_SIZE,searchNew);
	}

	@Override
	public boolean addNewInfo(NewInfo newInfo) {
		// TODO Auto-generated method stub
		try {
			newDAO.addNewInfo(newInfo);
			newSubstationDAO.addNewSubstation(newInfo.getSubstationList(), newInfo.getId());
		} catch (Exception e) {
			// TODO: handle exception
			logger.info(e.toString());
			throw new RuntimeException();
		}
		return true;
		
	}

	@Override
	public boolean updateNewInfo(NewInfo newInfo) {
		// TODO Auto-generated method stub
		try {
			newSubstationDAO.deleteNewSubstation(newInfo.getId());
			newSubstationDAO.addNewSubstation(newInfo.getSubstationList(), newInfo.getId());
			newDAO.updateNewInfo(newInfo);
		} catch (Exception e) {
			// TODO: handle exception
			logger.info(e.toString());
			throw new RuntimeException();
		}
		return true;
		
	}

	@Override
	public boolean deleteNewInfo(String id,String modifiedId) {
		// TODO Auto-generated method stub
		try {
			newDAO.deleteNewInfo(id,modifiedId);
		} catch (Exception e) {
			// TODO: handle exception
			logger.info(e.toString());
			throw new RuntimeException();
		}
		return true;
	
	}

	@Override
	public NewInfo getNewInfo(String id) {
		// TODO Auto-generated method stub
		return newDAO.getNewInfo(id);
	}

	@Override
	public List<NewType> getNewTypeByPage(int index) {
		// TODO Auto-generated method stub
		return newDAO.getNewTypeByPage(index * GlobalConstant.PAGE_SIZE, GlobalConstant.PAGE_SIZE);
	}

	@Override
	public NewType getNewType(String id) {
		// TODO Auto-generated method stub
		return newDAO.getNewType(id);
	}

	@Override
	public boolean deleteNewType(String id,String modifiedId) {
		// TODO Auto-generated method stub
		try {
			newDAO.deleteNewType(id,modifiedId);
		} catch (Exception e) {
			// TODO: handle exception
			logger.info(e.toString());
			throw new RuntimeException();
		}
		return true;
		
	}

	@Override
	public boolean updateNewType(NewType newType) {
		// TODO Auto-generated method stub
		try {
			newDAO.updateNewType(newType);
		} catch (Exception e) {
			// TODO: handle exception
			logger.info(e.toString());
			throw new RuntimeException();
		}
		return true;
		
	}

	@Override
	public int getNewTypeCount() {
		// TODO Auto-generated method stub
		return newDAO.getNewTypeCount();
	}

	@Override
	public int getNewInfoCount(SearchNew searchNew) {
		// TODO Auto-generated method stub
		formatSearchNew(searchNew);
		return newDAO.getNewInfoCount(searchNew);
	}

	@Override
	public List<SelectInfo> getAllNewTypeList() {
		// TODO Auto-generated method stub
		return newDAO.getAllNewTypeList();
	}

	@Override
	public List<SelectInfo> getAllNewTypeList(List<String> idList) {
		// TODO Auto-generated method stub
		return newDAO.getAllNewTypeListExceptIdList(idList);
	}
	
	@Override
	public List<SelectInfo> getAllSubstationList() {
		// TODO Auto-generated method stub
		List<SelectInfo> list = newDAO.getAllSubstationList();
		return list;
	}

	@Override
	public List<SelectInfo> getSearchNewList(String typeCode) {
		// TODO Auto-generated method stub
		return newDAO.getSearchNewType(typeCode);
	}
	
	@Override
	public boolean updateNewType(List<String> idList, int status, String modifiedId) {
		// TODO Auto-generated method stub
		try {
			newDAO.updateNewTypes(idList, status, modifiedId);
		} catch (Exception e) {
			// TODO: handle exception
			logger.info(e.toString());
			throw new RuntimeException();
		}
		return true;
		
	}

	@Override
	public boolean updateNewInfo(List<String> idList, int status, String modifiedId) {
		// TODO Auto-generated method stub
		try {
			newDAO.updateNewInfos(idList, status, modifiedId);
		} catch (Exception e) {
			// TODO: handle exception
			logger.info(e.toString());
			throw new RuntimeException();
		}
		return true;
		
	}
	
	
	@Override
	public int getNewNumber(String id) {
		// TODO Auto-generated method stub
		return newDAO.getNewNumber(id);
	}

	
	/**
	 * 
	 *add by lzc
	 *获取新闻属性里的当前时间的24小时以后的时间 
	 * @param searchNew
	 */
	protected void formatSearchNew(SearchNew searchNew){
		if(StringUtils.isEmpty(searchNew.getPublish())){
			searchNew.setPublish(null);
		}
		//获取当前时间的24小时之后的时间
		if(searchNew.getPubDate() != null){
			Calendar  calendar =Calendar.getInstance();
			calendar.setTime(searchNew.getPubDate());
			calendar.add(Calendar.DAY_OF_YEAR, 1);
			searchNew.setEndDate(calendar.getTime());
		}
	}

	@Override
	public List<NewInfo> getNewInfoListByTime(SearchNew searchNew, int pageNo,
			int pageSize) {
		// TODO Auto-generated method stub
		return newDAO.getListByTime(pageNo, pageSize, searchNew);
	}

	@Override
	public List<NewType> getNewTypeByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return newDAO.getNewTypeByPage(pageNo, pageSize);
	}

	@Override
	public SelectInfo getRecentNew(String typeId, Date modifiedTime, int type) {
		// TODO Auto-generated method stub
		List<SelectInfo> selectInfos = newDAO.getRecentlyInfoList(typeId, modifiedTime, type, 0, 1);
		return  selectInfos.size() > 0 ? selectInfos.get(0) : null;
	}

	@Override
	public List<NewInfo> getNewINfoTop(int pageSize) {
		// TODO Auto-generated method stub
		return newDAO.getListByTop(pageSize, 0);
	}

	


	
	

}
