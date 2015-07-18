package com.xinyue.manage.model;

import java.io.Serializable;

/**
 * 对应数据表m_bank_info
 * @author wenhai.you
 * @2015年5月23日
 * @下午1:43:00
 */
public class BankInfo implements Serializable {

	private String id;//序列
	private String name;//名称
	private String description;//描述
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
