package com.xinyue.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xinyue.manage.beans.OrganizationInfo;
import com.xinyue.manage.beans.SearchCreditManager;
import com.xinyue.manage.beans.SelectInfo;
import com.xinyue.manage.model.CreditManager;
import com.xinyue.manage.model.LinkMan;
import com.xinyue.manage.model.Organization;

/**
 * 
 * @author wenhai.you
 * @2015年5月16日
 * @下午2:23:33
 */
public interface OrganizationDao {

	
	
	
	
	/**
	 * 
	 * @param pinying
	 * @return
	 */
	public List<Organization> findOrgNameByPinying(@Param("pinying") String pinying);

	//add by mzj 2015/07/06 start
	public List<SelectInfo> getOrganizations();
	//add by mzj 2015/07/06 end
	
	
	
	
	public Organization checkOrgNameOrDomain(@Param("orgid")String orgid ,@Param("domain")String domain , @Param("orgName")String orgName);
	
	
	//2015-09-07以后
	/**
	 * ywh 删除店铺业务区域
	 * @param orgid 机构标识符
	 * @return
	 */
	public int delOrgStation(String orgid);
	
	/**
	 * ywh 添加店铺业务区域
	 * @param orgid 机构标识符
	 * @param list 分站标识符集合
	 * @return
	 */
	public int addOrgStation(@Param("orgid")String orgid , @Param("list")List<String> list);
	
	/**
	 * ywh 删除店铺 擅长业务 
	 * @param orgid 机构标识符
	 * @return
	 */
	public int delOrgProType(String orgid);
	
	/**
	 * ywh 添加店铺擅长业务
	 * @param orgid 机构标识符
	 * @param list 产品类型标识符集合
	 * @return
	 */
	public int addOrgProType(@Param("orgid")String orgid , @Param("list")List<String> list);
	
	/**
	 * ywh 根据orgInfo查询相应的机构信息
	 * @param orgInfo
	 * @return
	 */
	public  List<Organization> findOrgList(@Param("orgInfo")OrganizationInfo orgInfo , @Param("start")int start , @Param("pageSize")int pageSize);
	
	/**
	 * ywh 根据orginfo查询机构信息的记录数
	 * @param orgInfo
	 * @return
	 */
	public int getOrgCount(@Param("orgInfo")OrganizationInfo orgInfo);
	
	/**
	 * ywh根据机构标识符集合 禁用
	 * @param list
	 * @param modifyUser
	 */
	public void updateDisable(@Param("list") List<String> list , @Param("modifyUser") String modifyUser);
	
	/**
	 * ywh根据机构标识符集合 启用
	 * @param list
	 * @param modifyUser
	 */
	public void updateEnable(@Param("list") List<String> list , @Param("modifyUser") String modifyUser);
	

	/**
	 * ywh根据机构标识符集合 删除
	 * @param list
	 * @param modifyUser
	 */
	public void updateMarker(@Param("list") List<String> list , @Param("modifyUser") String modifyUser);
	
	
	/**
	 * ywh 修改机构基本信息或者修改店铺信息
	 * @param org
	 * @param modifyUser
	 */
	public void updateOrg(@Param("org")Organization org , @Param("modifyUser") String modifyUser);
	
	

	/**
	 * ywh 添加机构信息
	 * @param org
	 * @param createUser
	 */
	public void addOrg(@Param("org")Organization org , @Param("createUser") String createUser);
	
	
	/**
	 * ywh 修改机构联系人信息
	 * @param linkman
	 */
	public void updateOrgLinkMan(LinkMan linkman);
	
	/**
	 * ywh 添加机构联系人信息
	 * @param linkman
	 */
	public void addOrgLinkMan(LinkMan linkman);
	
	/**
	 * ywh 获取所有机构  代后台调用 
	 * @return
	 */
	public List<SelectInfo> getOrgs();
	
	
	/**
	 * 下显示店铺设置信息 和 显示机构基本信息和联系人信息
	 * @param orgid
	 * @return
	 */
	public Organization findShop(@Param("orgid") String orgid);
	
	/**
	 * ywh admin 根据机构显示信贷经理信息
	 * @param sc
	 * @param start
	 * @param pageSize
	 * @return
	 */
	public List<CreditManager> findCreditByOrgid(@Param("sc")SearchCreditManager sc , @Param("start")int start , @Param("pageSize")int pageSize);
	
	/**
	 * ywh admin 根据机构显示信贷经理信息 记录数
	 * @param sc
	 * @return
	 */
	public int getCreditByOrgidCount(SearchCreditManager sc);
}
