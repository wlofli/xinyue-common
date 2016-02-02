package com.xinyue.manage.beans;

import java.io.Serializable;

/**
 * author lzc
 */
public class Recommend implements Serializable{
	
	private String id;
	private String userName;//用户名
	private String userPhone;//用户电话
	private String userType;//会员类型
	private String province;
	private String city;
	private String zone;
	private String recommendUserNum;//推荐会员数
	private String recommendOrderNum;//成功订单数
	private String recommendCreditNum;//推荐信贷经理数
	private String recommendRechargeNum;//推荐信贷经理充值金额
	//ywh start;
	private String typeid="0";
	private String memberid;
	private String membertopage;
	private String credittopage;
	//gg admin
	private String topage; 
	private String rank;
	//ywh over
	
	
	
	public String getTopage() {
		return topage;
	}
	public void setTopage(String topage) {
		this.topage = topage;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getUserName() {
		return userName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTypeid() {
		return typeid;
	}
	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public String getMembertopage() {
		return membertopage;
	}
	public void setMembertopage(String membertopage) {
		this.membertopage = membertopage;
	}
	public String getCredittopage() {
		return credittopage;
	}
	public void setCredittopage(String credittopage) {
		this.credittopage = credittopage;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZone() {
		return zone;
	}
	public void setZone(String zone) {
		this.zone = zone;
	}
	public String getRecommendUserNum() {
		return recommendUserNum;
	}
	public void setRecommendUserNum(String recommendUserNum) {
		this.recommendUserNum = recommendUserNum;
	}
	public String getRecommendOrderNum() {
		return recommendOrderNum;
	}
	public void setRecommendOrderNum(String recommendOrderNum) {
		this.recommendOrderNum = recommendOrderNum;
	}
	public String getRecommendCreditNum() {
		return recommendCreditNum;
	}
	public void setRecommendCreditNum(String recommendCreditNum) {
		this.recommendCreditNum = recommendCreditNum;
	}
	public String getRecommendRechargeNum() {
		return recommendRechargeNum;
	}
	public void setRecommendRechargeNum(String recommendRechargeNum) {
		this.recommendRechargeNum = recommendRechargeNum;
	}
	@Override
	public String toString() {
		return "Recommend [userName=" + userName + ", userPhone=" + userPhone
				+ ", userType=" + userType + ", province=" + province
				+ ", city=" + city + ", zone=" + zone + ", recommendUserNum="
				+ recommendUserNum + ", recommendOrderNum=" + recommendOrderNum
				+ ", recommendCreditNum=" + recommendCreditNum
				+ ", recommendRechargeNum=" + recommendRechargeNum
				+ ", typeid=" + typeid + ", memberid=" + memberid
				+ ", membertopage=" + membertopage + ", credittopage="
				+ credittopage + "]";
	}
	
	
	
}
