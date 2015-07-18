package com.xinyue.manage.beans;

import java.io.Serializable;
import java.sql.Date;

import com.xinyue.manage.util.GlobalConstant;

/**
 * 贷款产品列表 查询条件 
 * @author wenhai.you
 * @2015年5月22日
 * @下午6:34:15
 */
public class ProductInfo implements Serializable {

	private String productName;//产品名称
	private String code;//产品编号
	private String type;//产品类别
	private String bank;//所属银行或贷款机构
	private int sort;//上架时间
	private int status; //状态
	private int pageSize = GlobalConstant.PAGE_SIZE;//每页大小 
	private String topage;//当前页
	private int start;//开始行
	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getTopage() {
		return topage;
	}
	public void setTopage(String topage) {
		this.topage = topage;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ProductInfo [productName=" + productName + ", code=" + code
				+ ", type=" + type + ", bank=" + bank + ", sort=" + sort
				+ ", status=" + status + ", pageSize=" + pageSize + ", topage="
				+ topage + ", start=" + start + "]";
	}
	
}
