package com.xinyue.manage.model;

/**
 * 信贷经理列表(前台)
 * @author MK)茅
 * @version v1.0
 * @date 创建时间：2015年8月13日
 */
public class CreditManagerInfo {

	/**
	 * 信贷经理ID
	 */
	private String creditManagerId = "";
	/**
	 * 照片
	 */
	private String personImg = "";
	/**
	 * 星等级
	 */
	private String starLevel = "";
	/**
	 * 人名
	 */
	private String personName = "";
	/**
	 * 申请人数
	 */
	private String applyCount = "";
	/**
	 * 机构
	 */
	private String organization = "";
	/**
	 * 机构
	 */
	private String organizationId = "";
	/**
	 * 服务地区
	 */
	private String serverZone = "";
	/**
	 * 擅长业务
	 */
	private String goodBusiness = "";
	/**
	 * 实名认证状态
	 */
	private boolean realNameStatus = false;
	/**
	 * 机构认证状态
	 */
	private boolean organizationAuthStatus = true;
	
	
	/**
	 * @return the personImg
	 */
	public String getPersonImg() {
		return personImg;
	}
	/**
	 * @param personImg the personImg to set
	 */
	public void setPersonImg(String personImg) {
		this.personImg = personImg;
	}
	/**
	 * @return the starLevel
	 */
	public String getStarLevel() {
		return starLevel;
	}
	/**
	 * @param starLevel the starLevel to set
	 */
	public void setStarLevel(String starLevel) {
		
		String starName = "";
		
		switch (Integer.parseInt(starLevel)) {
		case 1:
			starName = "1kx.jpg";
			break;
		case 2:
			starName = "2kx.jpg";
			break;
		case 3:
			starName = "3kx.jpg";
			break;
		case 4:
			starName = "4kx.jpg";
			break;
		case 5:
			starName = "5kx.jpg";
			break;
		default:
			break;
		}
		this.starLevel = starName;
	}
	/**
	 * @return the personName
	 */
	public String getPersonName() {
		return personName;
	}
	/**
	 * @param personName the personName to set
	 */
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	/**
	 * @return the applyCount
	 */
	public String getApplyCount() {
		return applyCount;
	}
	/**
	 * @param applyCount the applyCount to set
	 */
	public void setApplyCount(String applyCount) {
		this.applyCount = applyCount;
	}
	/**
	 * @return the organization
	 */
	public String getOrganization() {
		return organization;
	}
	/**
	 * @param organization the organization to set
	 */
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	/**
	 * @return the serverZone
	 */
	public String getServerZone() {
		return serverZone;
	}
	/**
	 * @param serverZone the serverZone to set
	 */
	public void setServerZone(String serverZone) {
		this.serverZone = serverZone;
	}
	/**
	 * @return the goodBusiness
	 */
	public String getGoodBusiness() {
		return goodBusiness;
	}
	/**
	 * @param goodBusiness the goodBusiness to set
	 */
	public void setGoodBusiness(String goodBusiness) {
		//长度限制
		if (goodBusiness.length()>22) {
			goodBusiness = goodBusiness.substring(0, 22) + "...";
		}
		this.goodBusiness = goodBusiness;
	}
	/**
	 * @return the realNameStatus
	 */
	public boolean isRealNameStatus() {
		return realNameStatus;
	}
	/**
	 * @param realNameStatus the realNameStatus to set
	 */
	public void setRealNameStatus(boolean realNameStatus) {
		this.realNameStatus = realNameStatus;
	}
	/**
	 * @return the organizationAuthStatus
	 */
	public boolean isOrganizationAuthStatus() {
		return organizationAuthStatus;
	}
	/**
	 * @param organizationAuthStatus the organizationAuthStatus to set
	 */
	public void setOrganizationAuthStatus(boolean organizationAuthStatus) {
		this.organizationAuthStatus = organizationAuthStatus;
	}
	/**
	 * @return the creditManagerId
	 */
	public String getCreditManagerId() {
		return creditManagerId;
	}
	/**
	 * @param creditManagerId the creditManagerId to set
	 */
	public void setCreditManagerId(String creditManagerId) {
		this.creditManagerId = creditManagerId;
	}
	/**
	 * @return the organizationId
	 */
	public String getOrganizationId() {
		return organizationId;
	}
	/**
	 * @param organizationId the organizationId to set
	 */
	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}
	
}
