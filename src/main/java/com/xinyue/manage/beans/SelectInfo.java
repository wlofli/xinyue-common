package com.xinyue.manage.beans;

import java.io.Serializable;

/**
 * 下拉表信息
 * @author MK)茅
 *
 */
public class SelectInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6419356408238217997L;

	String key;
	
	String value;

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
}
