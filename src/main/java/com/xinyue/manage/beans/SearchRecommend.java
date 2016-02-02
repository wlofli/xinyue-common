package com.xinyue.manage.beans;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

/**
 * author lzc
 * <coushuxiaolang@163.com>
 */
public class SearchRecommend {
	@DateTimeFormat(iso=ISO.DATE)
	private Date regigsterStartTime;//注册开始时间
	@DateTimeFormat(iso=ISO.DATE)
	private Date registerEndTime;//注册结束时间
	public Date getRegigsterStartTime() {
		return regigsterStartTime;
	}
	public void setRegigsterStartTime(Date regigsterStartTime) {
		this.regigsterStartTime = regigsterStartTime;
	}
	public Date getRegisterEndTime() {
		return registerEndTime;
	}
	public void setRegisterEndTime(Date registerEndTime) {
		this.registerEndTime = registerEndTime;
	}
	
	
	

}
