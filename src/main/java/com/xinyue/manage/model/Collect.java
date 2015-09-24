package com.xinyue.manage.model;

import java.io.Serializable;

/**
 * 产品收藏 普通会员 
 * @author wenhai.you
 * @2015年7月21日
 * @上午10:56:22
 */
public class Collect implements Serializable {

	private int id;
	private String productName;//产品名称
	private String orgName;//机构名称 
	private String credit;//信贷额度
	private String interest;//月息
	private String period;//贷款周期
	private String collectTime;//收藏时间
	private String memberid;//会员id
	private String productid;//产品id
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getCollectTime() {
		return collectTime;
	}
	public void setCollectTime(String collectTime) {
		this.collectTime = collectTime;
	}
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
