package com.xinyue.manage.beans;

import java.io.Serializable;

import com.xinyue.manage.util.GlobalConstant;

/**
 * 广告vo
 * @author wenhai.you
 * @2015年5月6日
 * @下午2:33:20
 */
public class AdvertisingInfo implements Serializable {

	private String title;//广告类型  用来显示数据
	private int start = 0;//分页起始行
	
	private int adtype = 0;//用于标识显示哪个叶签   默认为0显示在全部广告
	private int pageSize = GlobalConstant.PAGE_SIZE;
	/**
	 * 用于记录各个叶签 显示在 哪一页默认都显示在第一页
	 */
	private String pageAll = "1";//全部
	private String pageBig = "1";//首页大广告
	private String pageSmall = "1";//首页小广告
	private String pageIn = "1";//内页广告
	
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getAdtype() {
		return adtype;
	}
	public void setAdtype(int adtype) {
		this.adtype = adtype;
	}
	public String getPageAll() {
		return pageAll;
	}
	public void setPageAll(String pageAll) {
		this.pageAll = pageAll;
	}
	public String getPageBig() {
		return pageBig;
	}
	public void setPageBig(String pageBig) {
		this.pageBig = pageBig;
	}
	public String getPageSmall() {
		return pageSmall;
	}
	public void setPageSmall(String pageSmall) {
		this.pageSmall = pageSmall;
	}
	public String getPageIn() {
		return pageIn;
	}
	public void setPageIn(String pageIn) {
		this.pageIn = pageIn;
	}
	public AdvertisingInfo(String title) {
		super();
		this.title = title;
	}
	public AdvertisingInfo() {
		super();
	}
	@Override
	public String toString() {
		return "AdvertisingInfo [title=" + title + ", start=" + start
				+ ", adtype=" + adtype + ", pageAll=" + pageAll + ", pageBig="
				+ pageBig + ", pageSmall=" + pageSmall + ", pageIn=" + pageIn
				+ "]";
	}
	
}
