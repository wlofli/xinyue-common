package com.xinyue.manage.beans;

/**
 * 信贷经理检索条件（后台）
 * @author MK)茅
 * @version v1.0
 * @date 创建时间：2015年8月28日
 */
public class SearchCreditManager {

	//信贷经理姓名
	private String creditManagerName = "";
	//性别
	private String sex = "";
	//手机号
	private String telPhone = "";
	//所在地(省)
	private String province = "";
	//所在地(市)
	private String city = "";
	//所在地(区)
	private String zone = "";
	//所属机构
	private String organization = "";
	//注册时间
	private String registerTimeStart = "";
	
	private String registerTimeEnd = "";
	//服务质量
	private String serverStar = "";
	//客户数排序：0:不排序;1:升序;2:降序
	private int sortCustomerAmount = 0;
	//成功案例：0:不排序;1:升序;2:降序
	private int sortSuccessCase = 0;
	//余额：0:不排序;1:升序;2:降序
	private int sortRemaind = 0;
	//代金券：0:不排序;1:升序;2:降序
	private int sortMoneyPaper = 0;
	//积分：0:不排序;1:升序;2:降序
	private int sortPoint = 0;
	//页数
	private int jumpPage = 1;
	
	private int index = 0;
	//ywh start
	private String audit;
	private String orgid;
	private String topage;
	//ywh over
	
	/**
	 * 信贷经理ID
	 */
	private String managerId="";
	public String getTopage() {
		return topage;
	}

	public void setTopage(String topage) {
		this.topage = topage;
	}

	public String getOrgid() {
		return orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	public String getAudit() {
		return audit;
	}

	public void setAudit(String audit) {
		this.audit = audit;
	}

	/**
	 * 擅长业务
	 */
	private String goodBusiness ="";
	/**
	 * 服务地区
	 */
	private String serverZone ="";
	/**
	 * 机构类型
	 */
	private String organizationType ="";
	
	/**
	 * 是否认证
	 */
	private boolean auth = false;
	
	/**
	 * 排列方式：0：默认，1：最近登录
	 */
	private int orderType = 0;

	/**
	 * @return the creditManagerName
	 */
	public String getCreditManagerName() {
		return creditManagerName;
	}

	/**
	 * @param creditManagerName the creditManagerName to set
	 */
	public void setCreditManagerName(String creditManagerName) {
		this.creditManagerName = creditManagerName;
	}

	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * @return the telPhone
	 */
	public String getTelPhone() {
		return telPhone;
	}

	/**
	 * @param telPhone the telPhone to set
	 */
	public void setTelPhone(String telPhone) {
		this.telPhone = telPhone;
	}

	/**
	 * @return the province
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * @param province the province to set
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the zone
	 */
	public String getZone() {
		return zone;
	}

	/**
	 * @param zone the zone to set
	 */
	public void setZone(String zone) {
		this.zone = zone;
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
	 * @return the registerTimeStart
	 */
	public String getRegisterTimeStart() {
		return registerTimeStart;
	}

	/**
	 * @param registerTimeStart the registerTimeStart to set
	 */
	public void setRegisterTimeStart(String registerTimeStart) {
		this.registerTimeStart = registerTimeStart;
	}

	/**
	 * @return the registerTimeEnd
	 */
	public String getRegisterTimeEnd() {
		return registerTimeEnd;
	}

	/**
	 * @param registerTimeEnd the registerTimeEnd to set
	 */
	public void setRegisterTimeEnd(String registerTimeEnd) {
		this.registerTimeEnd = registerTimeEnd;
	}

	/**
	 * @return the serverStar
	 */
	public String getServerStar() {
		return serverStar;
	}

	/**
	 * @param serverStar the serverStar to set
	 */
	public void setServerStar(String serverStar) {
		this.serverStar = serverStar;
	}

	/**
	 * @return the sortCustomerAmount
	 */
	public int getSortCustomerAmount() {
		return sortCustomerAmount;
	}

	/**
	 * @param sortCustomerAmount the sortCustomerAmount to set
	 */
	public void setSortCustomerAmount(int sortCustomerAmount) {
		this.sortCustomerAmount = sortCustomerAmount;
	}

	/**
	 * @return the sortSuccessCase
	 */
	public int getSortSuccessCase() {
		return sortSuccessCase;
	}

	/**
	 * @param sortSuccessCase the sortSuccessCase to set
	 */
	public void setSortSuccessCase(int sortSuccessCase) {
		this.sortSuccessCase = sortSuccessCase;
	}

	/**
	 * @return the sortRemaind
	 */
	public int getSortRemaind() {
		return sortRemaind;
	}

	/**
	 * @param sortRemaind the sortRemaind to set
	 */
	public void setSortRemaind(int sortRemaind) {
		this.sortRemaind = sortRemaind;
	}

	/**
	 * @return the sortMoneyPaper
	 */
	public int getSortMoneyPaper() {
		return sortMoneyPaper;
	}

	/**
	 * @param sortMoneyPaper the sortMoneyPaper to set
	 */
	public void setSortMoneyPaper(int sortMoneyPaper) {
		this.sortMoneyPaper = sortMoneyPaper;
	}

	/**
	 * @return the sortPoint
	 */
	public int getSortPoint() {
		return sortPoint;
	}

	/**
	 * @param sortPoint the sortPoint to set
	 */
	public void setSortPoint(int sortPoint) {
		this.sortPoint = sortPoint;
	}

	/**
	 * @return the jumpPage
	 */
	public int getJumpPage() {
		return jumpPage;
	}

	/**
	 * @param jumpPage the jumpPage to set
	 */
	public void setJumpPage(int jumpPage) {
		this.jumpPage = jumpPage;
	}

	/**
	 * @return the managerId
	 */
	public String getManagerId() {
		return managerId;
	}

	/**
	 * @param managerId the managerId to set
	 */
	public void setManagerId(String managerId) {
		this.managerId = managerId;
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
		this.goodBusiness = goodBusiness;
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
	 * @return the organizationType
	 */
	public String getOrganizationType() {
		return organizationType;
	}

	/**
	 * @param organizationType the organizationType to set
	 */
	public void setOrganizationType(String organizationType) {
		this.organizationType = organizationType;
	}

	/**
	 * @return the auth
	 */
	public boolean isAuth() {
		return auth;
	}

	/**
	 * @param auth the auth to set
	 */
	public void setAuth(boolean auth) {
		this.auth = auth;
	}

	/**
	 * @return the orderType
	 */
	public int getOrderType() {
		return orderType;
	}

	/**
	 * @param orderType the orderType to set
	 */
	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}

	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * @param index the index to set
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public String toString() {
		return "SearchCreditManager [creditManagerName=" + creditManagerName
				+ ", sex=" + sex + ", telPhone=" + telPhone + ", province="
				+ province + ", city=" + city + ", zone=" + zone
				+ ", organization=" + organization + ", registerTimeStart="
				+ registerTimeStart + ", registerTimeEnd=" + registerTimeEnd
				+ ", serverStar=" + serverStar + ", sortCustomerAmount="
				+ sortCustomerAmount + ", sortSuccessCase=" + sortSuccessCase
				+ ", sortRemaind=" + sortRemaind + ", sortMoneyPaper="
				+ sortMoneyPaper + ", sortPoint=" + sortPoint + ", jumpPage="
				+ jumpPage + ", index=" + index + ", audit=" + audit
				+ ", orgid=" + orgid + ", topage=" + topage + ", managerId="
				+ managerId + ", goodBusiness=" + goodBusiness
				+ ", serverZone=" + serverZone + ", organizationType="
				+ organizationType + ", auth=" + auth + ", orderType="
				+ orderType + "]";
	}
	
}
