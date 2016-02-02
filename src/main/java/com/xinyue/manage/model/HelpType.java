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

	private String publish ;
	
	//ywh start 帮助分类
	private String id ;
	private String createName;
	private int total;
	//ywh over
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	public String getPublish() {
		return publish;
	}

	public void setPublish(String publish) {
		this.publish = publish;
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
