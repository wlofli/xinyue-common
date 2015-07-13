package com.xinyue.manage.model;

import java.io.Serializable;

/**
 * 帮助类型
 * @author MK)茅
 *
 */
public class HelpType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3678237636153956548L;
	
	private String name = "";
	
	private String orderNum = "";

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the orderNum
	 */
	public String getOrderNum() {
		return orderNum;
	}

	/**
	 * @param orderNum the orderNum to set
	 */
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	
	

}
