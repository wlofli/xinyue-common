package com.xinyue.manage.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.xinyue.manage.beans.OrganizationInfo;
import com.xinyue.manage.beans.PageData;
import com.xinyue.manage.beans.SelectInfo;
import com.xinyue.manage.model.Organization;
import com.xinyue.manage.model.OrganizationType;
import com.xinyue.manage.model.ProductType;
import com.xinyue.manage.model.SubStation;
import com.xinyue.manage.util.CommonFunction;
import com.xinyue.manage.util.GlobalConstant;

/**
 * 
 * @author wenhai.you
 * @2015年5月16日
 * @下午2:25:04
 */
public interface OrganizationService {

	
	/**
	 * 
	 * @param pinying
	 * @return
	 */
	public List<Organization> findOrgNameByPinying(String pinying);

	//add by mzj 2015/07/06 start
	/**
	 * 获得机构列表
	 * @return
	 */
	public List<SelectInfo> getOrganizations();
	//add by mzj 2015/07/06 end
	
	public Organization findShop(String orgid);
	
	/**
	 * 城市分站信息
	 * @return
	 */
	public List<SubStation> findAll();
	
	public List<ProductType> findProductTypeByList();
	
	//2015-09-07以后修改保存写下面
	
	/**
	 * ywh 机构图片临时上传
	 * @param suffix
	 * @param req
	 * @return
	 */
	public String upload(String suffix , HttpServletRequest req);
	public final static String TEMP_PATH = (new StringBuffer(CommonFunction.getValue("upload.path")).append("org/temp/")).toString();
	public final static String DOWN_PATH = (new StringBuffer(CommonFunction.getValue("down.path")).append("moko/images/org/temp/")).toString();
	public final static String REAL_PATH = CommonFunction.getValue("upload.path");
	public final static String SHOW_PATH = CommonFunction.getValue("down.path")+"moko/images/";
	
	
	/**
	 * ywh修改店铺信息
	 * @param org 店铺信息
	 * @param loginName 登录者
	 * @return
	 */
	public boolean saveShop(Organization org , String loginName);
	
	/**
	 * ywh 检测域名是否存在
	 * @param domain 域名
	 * @return
	 */
	public boolean checkDomain(String orgid , String domain);
	
	/**
	 * ywh修改店铺内容
	 * @param org
	 * @param loginName
	 * @return
	 */
	public boolean saveShopcontent(Organization org , String loginName);
	
	
	/**
	 * ywh 获取所有机构分类
	 * @return 所有机构分类
	 */
	public List<OrganizationType> findOrgTypeAll();
	
	/**
	 * ywh 显示机构列表
	 * @param orgInfo
	 * @return
	 */
	public PageData<Organization> findPageData(OrganizationInfo orgInfo);
	
	/**
	 * ywh根据机构标识符集合 启用
	 * @param list
	 * @param modifyUser
	 */
	public boolean updateEnable(List<String> list , String modifyUser);
	
	/**
	 * ywh根据机构标识符集合 禁用
	 * @param list
	 * @param modifyUser
	 */
	public boolean updateDisable(List<String> list , String modifyUser);
	
	/**
	 * ywh根据机构标识符集合 删除
	 * @param list
	 * @param modifyUser
	 */
	public boolean updateMarker(List<String> list , String modifyUser);
	
	
	/**
	 * ywh添加或修改机构信息 和  添加或修改联系人信息
	 * @param orgedit
	 * @param loginName
	 * @return
	 */
	public boolean saveOrg(String orgedit , String loginName);

}
