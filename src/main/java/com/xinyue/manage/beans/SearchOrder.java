package com.xinyue.manage.beans;

import java.util.Date;

/**
 * author lzc
 * 2015年7月16日下午2:39:46
 */
public class SearchOrder {
	
	private String sort;//排序 1.升序 2.降序
	private Date startTime;
	private Date endTime;
	private String status;//订单状态
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
