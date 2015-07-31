package com.xinyue.manage.model;

import java.io.Serializable;

/**
 * 
 * @author wenhai.you
 * @2015年6月8日
 * @下午5:23:08
 */
public class Member implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 103398990170708810L;
	private String id;
	private String loginName; 
	private String memberName;
	private String company;
	private String area;
	private String memberCount;
	private String contactName;
	private String contactPhone;
	private String email;
	private String regTime;
	private String loginTime;
	private String orderCount;
	private String cityid;
	private String provinceid;
	private String zoneid;
	private String cityids;
	private String zoneids;
	private String address;
	private String memberid;
	private Object createUser;
	private Object modifyUser;
	private String status;
	private String sex;
	//2015/07/15 茅 追加 START
	private String password;
	private String invited;
	//2015/07/15 茅 追加 END
	private String invitationCode;//邀请码
	
	public String getInvitationCode() {
		return invitationCode;
	}
	public void setInvitationCode(String invitationCode) {
		this.invitationCode = invitationCode;
	}
	public String getCityids() {
		return cityids;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setCityids(String cityids) {
		this.cityids = cityids;
	}
	public String getZoneids() {
		return zoneids;
	}
	public void setZoneids(String zoneids) {
		this.zoneids = zoneids;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getMemberCount() {
		return memberCount;
	}
	public void setMemberCount(String memberCount) {
		this.memberCount = memberCount;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactPhone() {
		return contactPhone;
	}
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRegTime() {
		return regTime;
	}
	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}
	public String getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}
	public String getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(String orderCount) {
		this.orderCount = orderCount;
	}
	public String getCityid() {
		return cityid;
	}
	public void setCityid(String cityid) {
		this.cityid = cityid;
	}
	public String getProvinceid() {
		return provinceid;
	}
	public void setProvinceid(String provinceid) {
		this.provinceid = provinceid;
	}
	public String getZoneid() {
		return zoneid;
	}
	public void setZoneid(String zoneid) {
		this.zoneid = zoneid;
	}
	public Object getCreateUser() {
		return createUser;
	}
	public void setCreateUser(Object createUser) {
		this.createUser = createUser;
	}
	public Object getModifyUser() {
		return modifyUser;
	}
	public void setModifyUser(Object modifyUser) {
		this.modifyUser = modifyUser;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", loginName=" + loginName
				+ ", memberName=" + memberName + ", company=" + company
				+ ", area=" + area + ", memberCount=" + memberCount
				+ ", contactName=" + contactName + ", contactPhone="
				+ contactPhone + ", email=" + email + ", regTime=" + regTime
				+ ", loginTime=" + loginTime + ", orderCount=" + orderCount
				+ ", cityid=" + cityid + ", provinceid=" + provinceid
				+ ", zoneid=" + zoneid + ", address=" + address + ", memberid="
				+ memberid + ", createUser=" + createUser + ", status="
				+ status + "]";
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the invited
	 */
	public String getInvited() {
		return invited;
	}
	/**
	 * @param invited the invited to set
	 */
	public void setInvited(String invited) {
		this.invited = invited;
	}
	
}
