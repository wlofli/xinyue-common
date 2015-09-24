package com.xinyue.manage.model;

import java.io.Serializable;

/**
 * 字典数据
 * @author wenhai.you
 * @2015年5月18日
 * @上午9:27:49
 */
public class Select implements Serializable {

	private String dicCode;//字典类型
	private String dicKey;//字典值
	private String dicVal;//字典显示
	
	public String getDicCode() {
		return dicCode;
	}
	public void setDicCode(String dicCode) {
		this.dicCode = dicCode;
	}
	public String getDicKey() {
		return dicKey;
	}
	public void setDicKey(String dicKey) {
		this.dicKey = dicKey;
	}
	public String getDicVal() {
		return dicVal;
	}
	public void setDicVal(String dicVal) {
		this.dicVal = dicVal;
	}
	
	@Override
	public String toString() {
		return "Select [dicCode=" + dicCode + ", dicKey=" + dicKey
				+ ", dicVal=" + dicVal + "]";
	}
	public Select(String dicCode, String dicKey) {
		super();
		this.dicCode = dicCode;
		this.dicKey = dicKey;
	}
	public Select() {
		super();
	}
	
}
