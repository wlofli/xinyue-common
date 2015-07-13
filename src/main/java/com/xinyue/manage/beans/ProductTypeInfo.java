package com.xinyue.manage.beans;

import java.io.Serializable;

import com.xinyue.manage.util.GlobalConstant;

/**
 * 
 * @author wenhai.you
 * @2015年5月28日
 * @上午9:46:55
 */
public class ProductTypeInfo implements Serializable {

	private int fstart = 0;
	private int sstart = 0;
	private int pageSize = GlobalConstant.PAGE_SIZE;
	private int fpage = 1;
	private int spage = 1;
	
	public int getFstart() {
		return fstart;
	}
	public void setFstart(int fstart) {
		this.fstart = fstart;
	}
	public int getSstart() {
		return sstart;
	}
	public void setSstart(int sstart) {
		this.sstart = sstart;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getFpage() {
		return fpage;
	}
	public void setFpage(int fpage) {
		this.fpage = fpage;
	}
	public int getSpage() {
		return spage;
	}
	public void setSpage(int spage) {
		this.spage = spage;
	}
	@Override
	public String toString() {
		return "ProductTypeInfo [fstart=" + fstart + ", sstart=" + sstart
				+ ", pageSize=" + pageSize + ", fpage=" + fpage + ", spage="
				+ spage + "]";
	}
	
}
