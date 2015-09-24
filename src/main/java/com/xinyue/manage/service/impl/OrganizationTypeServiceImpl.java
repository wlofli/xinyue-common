package com.xinyue.manage.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xinyue.manage.dao.OrganizationTypeDao;
import com.xinyue.manage.model.OrganizationType;
import com.xinyue.manage.service.OrganizationTypeService;
import com.xinyue.manage.util.GlobalConstant;

/**
 * 
 * @author wenhai.you
 * @2015年6月2日
 * @下午4:55:31
 */
@Service("organizationTypeService")
public class OrganizationTypeServiceImpl implements OrganizationTypeService {

	@Autowired
	private OrganizationTypeDao tdao;
	
	private Logger logger = Logger.getLogger(OrganizationTypeServiceImpl.class);
	@Override
	public List<OrganizationType> findListPage(int start , int pageSize){
		// TODO Auto-generated method stub
		return tdao.findListPage(start , pageSize);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return tdao.getCount();
	}

	@Override
	public void delOrganizationType(List<String> id , String modifyUser) {
		// TODO Auto-generated method stub
		boolean b = false;
		try {
			tdao.delOrganizationType(id);
			tdao.updateOrgByType(id, modifyUser);
			logger.info("删除机构类型和更新机构成功,id为"+id+",删除者:"+modifyUser);
			
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("删除机构类型失败,id为"+id+",删除者:"+modifyUser, e);
			throw new RuntimeException("删除失败", e);
		}
	}
	
	@Override
	public boolean saveOrganizationType(OrganizationType otype , String user) {
		// TODO Auto-generated method stub
		try {
			if(GlobalConstant.isNull(otype.getId())){
				SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssms");
				String code = new StringBuffer(df.format(new java.sql.Date(System.currentTimeMillis()))).toString();
				otype.setNumber(code);
				tdao.addOrganizationType(otype);
				logger.info("添加机构类型成功,数据为"+otype+",添加者为:"+user);
			}else{
				tdao.updateOrganizationType(otype);
				logger.info("修改机构类型成功,数据为"+otype+",修改者为:"+user);
			}
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("保存机构类型失败,数据为"+otype, e);
			return false;
		}
		
	}
	
	@Override
	public OrganizationType findTypeById(String id) {
		// TODO Auto-generated method stub
		return tdao.findTypeById(id);
	}

	@Override
	public List<OrganizationType> findTypes() {
		
		return tdao.findTypes();
	}
}
