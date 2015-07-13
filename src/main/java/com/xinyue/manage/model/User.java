package com.xinyue.manage.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class User implements Serializable{
	
	private static final long serialVersionUID = 4761675990445076478L;

	private int id;
	private String name;
	private String password;
	private String phone;
	private Integer deleted;
	private Date createdtime;
	private Date deletedtime;
	private Integer status;
	private Date lastestlogin;
	
//	private List<Role> roles;
//	private List<Resource> resources;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
//	public List<Role> getRoles() {
//		return roles;
//	}
//	public void setRoles(List<Role> roles) {
//		this.roles = roles;
//	}
//	public List<Resource> getResources() {
//		return resources;
//	}
//	public void setResources(List<Resource> resources) {
//		this.resources = resources;
//	}
	public Integer getDeleted() {
		return deleted;
	}
	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}
	public Date getCreatedtime() {
		return createdtime;
	}
	public void setCreatedtime(Date createdtime) {
		this.createdtime = createdtime;
	}
	public Date getDeletedtime() {
		return deletedtime;
	}
	public void setDeletedtime(Date deletedtime) {
		this.deletedtime = deletedtime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getLastestlogin() {
		return lastestlogin;
	}
	public void setLastestlogin(Date lastestlogin) {
		this.lastestlogin = lastestlogin;
	}

}
