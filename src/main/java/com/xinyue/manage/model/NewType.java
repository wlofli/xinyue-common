package com.xinyue.manage.model;

import java.util.Date;
/**
 * 
 * @author lzc
 * @date 2015年6月26日上午10:56:15
 */
public class NewType {
	
	private String id;
	private int orderNum;
	private String name;
	private int status;
	private int deleted;
	private int newNum;
	
	private Date createdTime;
	private String createdId;
	private Date modifiedTime;
	private String modifiedId;
	
	public int getNewNum() {
		return newNum;
	}
	public void setNewNum(int newNum) {
		this.newNum = newNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getDeleted() {
		return deleted;
	}
	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}
	
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public String getCreatedId() {
		return createdId;
	}
	public void setCreatedId(String createdId) {
		this.createdId = createdId;
	}
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public String getModifiedId() {
		return modifiedId;
	}
	public void setModifiedId(String modifiedId) {
		this.modifiedId = modifiedId;
	}
	
	

}
