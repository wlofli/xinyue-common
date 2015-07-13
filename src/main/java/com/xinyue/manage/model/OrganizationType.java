package com.xinyue.manage.model;

import java.io.Serializable;

/**
 * 
 * @author wenhai.you
 * @2015年6月2日
 * @下午3:57:37
 */
public class OrganizationType implements Serializable {

	private String id;
	private String name;
	private String number;
	private String deleted;
	private int count;
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
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
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getDeleted() {
		return deleted;
	}
	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}
	@Override
	public String toString() {
		return "OrganizationType [id=" + id + ", name=" + name + ", number="
				+ number + ", deleted=" + deleted + ", count=" + count + "]";
	}
	
}
