package com.xinyue.manage.service.impl;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xinyue.manage.beans.OrganizationInfo;
import com.xinyue.manage.dao.OrganizationDao;
import com.xinyue.manage.model.Organization;
import com.xinyue.manage.service.OrganizationService;
import com.xinyue.manage.util.GlobalConstant;
import com.xinyue.manage.util.PinYin;

/**
 * 
 * @author wenhai.you
 * @2015年5月16日
 * @下午2:26:07
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {

	
	@Autowired
	private OrganizationDao orgDao;
	
	private Logger logger = Logger.getLogger(OrganizationServiceImpl.class);
	@Override
	public List<Organization> findPageData(OrganizationInfo orgInfo) {
		// TODO Auto-generated method stub
		 
		return orgDao.findPageData(orgInfo);
	}

	@Override
	public int getOrganizationCount(OrganizationInfo orgInfo) {
		// TODO Auto-generated method stub
		return orgDao.getOrganizationCount(orgInfo);
	}
	
	
	@Override
	public boolean updateDisable(List<String> list, String modifyUser) {
		// TODO Auto-generated method stub
		try {
			orgDao.updateDisable(list, modifyUser);
			logger.info("机构禁用成功 数据为:"+list+",操作者为:"+modifyUser);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("机构禁用失败 数据为:"+list+",操作者为:"+modifyUser, e);
			return false;
		}
	}
	
	@Override
	public boolean updateEnable(List<String> list, String modifyUser) {
		// TODO Auto-generated method stub
		try {
			orgDao.updateEnable(list, modifyUser);
			logger.info("机构启用成功 数据为:"+list+",操作者为:"+modifyUser);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("机构启用失败 数据为:"+list+",操作者为:"+modifyUser, e);
			return false;
		}
	}
	@Override
	public boolean updateMarker(List<String> list, String modifyUser) {
		// TODO Auto-generated method stub
		try {
			orgDao.updateMarker(list, modifyUser);
			logger.info("机构删除成功 数据为:"+list+",操作者为:"+modifyUser);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("机构删除失败 数据为:"+list+",操作者为:"+modifyUser, e);
			return false;
		}
	}
	
	
	@Override
	public List<Organization> findListByNumber(String number) {
		// TODO Auto-generated method stub
		return orgDao.findListByNumber(number);
	}
	
	
	@Override
	public boolean saveOrganization(String orgedit , String loginName) {
		
		try {
			List<Organization> organ = getJavaCollection(new Organization(), orgedit);
			// TODO Auto-generated method stub
			for (int i = 0; i < organ.size(); i++) {
				Organization org = organ.get(0);
				org.setPinyin(PinYin.spellTone(org.getName()));
				if(i != 0){
					Organization orgs = organ.get(i);
					orgs.setGenre(org.getGenre());//机构类型
					orgs.setName(org.getName());
					orgs.setNumber(org.getNumber());
					orgs.setSite(org.getSite());
					orgs.setPostcode(org.getPostcode());
					orgs.setPinyin(PinYin.spellTone(org.getName()));
				}
			}
			for (Organization editInfo : organ) {
				if(GlobalConstant.isNull(editInfo.getId())){
					orgDao.addOrganization(editInfo , loginName);
					logger.info("机构添加成功 , 数据为:"+orgedit+",编辑者为:"+loginName);
				}else{
					orgDao.updateOrganization(editInfo , loginName);
					logger.info("机构修改成功 , 数据为:"+orgedit+",编辑者为:"+loginName);
				}
			}
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("机构编辑失败 , 数据为:"+orgedit+",编辑者为:"+loginName, e);
			return false;
		}
		
	}
	
	private <T> List<T> getJavaCollection(T clazz, String jsons) {        
    	
		List<T> objs=null;        
    	JSONArray jsonArray=(JSONArray)JSONSerializer.toJSON(jsons);        
    	if(jsonArray!=null){            
    		objs=new ArrayList<T>();            
    		List list=(List)JSONSerializer.toJava(jsonArray);            
    		for(Object o:list){                
    			JSONObject jsonObject=JSONObject.fromObject(o);                
    			T obj=(T)JSONObject.toBean(jsonObject, clazz.getClass());                
    			objs.add(obj);            
    		}        
    	}        
    	return objs;   
		
    }
	
	@Override
	public List<Organization> editListByNumber(String number) {
		// TODO Auto-generated method stub
		return orgDao.editListByNumber(number);
	}
	@Override
	public List<Organization> findOrgNameByPinying(String pinying) {
		// TODO Auto-generated method stub
		return orgDao.findOrgNameByPinying(pinying);
	}
}
