package com.xinyue.manage.beans;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
/**
 * 
 * @author lzc
 * @date 2015年6月26日上午10:55:29
 */
public class SearchNew {
	private String keywords;
	private String value;
	private String publish;
	private int city;
	private String newType;
	@DateTimeFormat(pattern = "yyyy-MM-dd" )
	private Date pubDate;
	private Date endDate;
	
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	
	
	public String getNewType() {
		return newType;
	}
	public void setNewType(String newType) {
		this.newType = newType;
	}
	
	public int getCity() {
		return city;
	}
	public void setCity(int city) {
		this.city = city;
	}

	
	
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getPublish() {
		return publish;
	}
	public void setPublish(String publish) {
		this.publish = publish;
	}
	public Date getPubDate() {
		return pubDate;
	}
	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}
	

}
