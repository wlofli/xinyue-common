package com.xinyue.manage.model;

import java.io.Serializable;
import java.sql.Date;

/**
 * 产品类别 m_product_type
 * @author wenhai.you
 * @2015年5月22日
 * @下午6:23:43
 */
public class ProductType implements Serializable {

	private String id;//
	private String name;//产品 类别名称
	private String status;
	private String deleted;
	private String parentid;
	private Date createdTime;
	private Date modifiedTime;
	private String createUser;
	private String modifyUser;
	
	public String getParentid() {
		return parentid;
	}
	public void setParentid(String parentid) {
		this.parentid = parentid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDeleted() {
		return deleted;
	}
	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public String getModifyUser() {
		return modifyUser;
	}
	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "ProductType [id=" + id + ", name=" + name + ", status="
				+ status + ", deleted=" + deleted + ", createdTime="
				+ createdTime + ", modifiedTime=" + modifiedTime
				+ ", createUser=" + createUser + ", modifyUser=" + modifyUser
				+ "]";
	}
	
}
