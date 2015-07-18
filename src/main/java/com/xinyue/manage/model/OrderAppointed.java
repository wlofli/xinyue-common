package com.xinyue.manage.model;

import java.util.Date;

/**
 * author lzc
 * 2015年6月30日下午4:01:38
 * 
 * 指定客户
 */
public class OrderAppointed {
	private String id;
	private String creditName;//信贷经理姓名
	private String creditPhone;//手机号
	private String blank;//所属机构
	private double price;//获得价格
	private int deleted;
	private String createdId;
	private Date createdTime;
	private String modifiedId;
	private Date modifiedTime;
	private String orderId;//订单外键
	private int type;//1.订单2快速申贷
	private String manageId;//信贷经理外键
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCreditName() {
		return creditName;
	}
	public void setCreditName(String creditName) {
		this.creditName = creditName;
	}
	public String getCreditPhone() {
		return creditPhone;
	}
	public void setCreditPhone(String creditPhone) {
		this.creditPhone = creditPhone;
	}
	public String getBlank() {
		return blank;
	}
	public void setBlank(String blank) {
		this.blank = blank;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getDeleted() {
		return deleted;
	}
	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}
	public String getCreatedId() {
		return createdId;
	}
	public void setCreatedId(String createdId) {
		this.createdId = createdId;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public String getModifiedId() {
		return modifiedId;
	}
	public void setModifiedId(String modifiedId) {
		this.modifiedId = modifiedId;
	}
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getManageId() {
		return manageId;
	}
	public void setManageId(String manageId) {
		this.manageId = manageId;
	}
	
	
	

}
