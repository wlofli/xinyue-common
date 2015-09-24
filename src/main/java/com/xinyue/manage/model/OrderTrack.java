package com.xinyue.manage.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * author lzc
 */
public class OrderTrack {
	private String id;//id
	private String orderId;//订单或者快速申贷订单外键
	private String orderType;//1订单2快速申贷
	private String deleted;//删除
	private String status;//订单状态
	private String price;//下载扣费
	private String info;//下载企业信息情况
	private String remark;//备注信息||状态描述
	private String createdId;//创建人
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private Date createdTime;//跟踪日期
	
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date   creditTime;//放款时间
	private Double creditReal;//贷款额度
	
	
	
	
	public Date getCreditTime() {
		return creditTime;
	}
	public void setCreditTime(Date creditTime) {
		this.creditTime = creditTime;
	}
	public Double getCreditReal() {
		return creditReal;
	}
	public void setCreditReal(Double creditReal) {
		this.creditReal = creditReal;
	}
	public String getDeleted() {
		return deleted;
	}
	public void setDeleted(String deleted) {
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	

}
