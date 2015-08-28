package com.xinyue.manage.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

/**
 * author lzc
 * 2015年6月30日下午3:48:56
 * 
 * 竞拍
 */
public class OrderAuction {
	private String id;
	private Double fixedPrice;//一口价
	private Double startPrice;//起拍价
	private Double lowerAddPrice;//最低加价
	private Double nowPrice;//现在的价格
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date startTime;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date endTime;
	private int deleted;
	private String createdId;
	private Date createdTime;
	private String modifiedId;
	private Date modifiedTime;
	private String orderId;//订单外键
	private int type;//1.订单2快速申贷
	private String manageId;//信贷经理外键
	public String getManageId() {
		return manageId;
	}
	public void setManageId(String manageId) {
		this.manageId = manageId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Double getFixedPrice() {
		return fixedPrice;
	}
	public void setFixedPrice(Double fixedPrice) {
		this.fixedPrice = fixedPrice;
	}
	public Double getStartPrice() {
		return startPrice;
	}
	public void setStartPrice(Double startPrice) {
		this.startPrice = startPrice;
	}
	public Double getLowerAddPrice() {
		return lowerAddPrice;
	}
	public void setLowerAddPrice(Double lowerAddPrice) {
		this.lowerAddPrice = lowerAddPrice;
	}
	public Double getNowPrice() {
		return nowPrice;
	}
	public void setNowPrice(Double nowPrice) {
		this.nowPrice = nowPrice;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
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
	
	
	

}
