package com.xinyue.manage.beans;
/**
 * 
 * @author lzc
 * @date 2015年6月26日上午10:54:56
 */
/**
 * 
 * @author lzc
 * @date 2015年6月26日
 * 复选框多选模型
 */

public class CheckboxInfo {
	
	private String key;
	private String value;
	private boolean checked;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}

}
