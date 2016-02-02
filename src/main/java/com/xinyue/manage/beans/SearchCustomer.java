package com.xinyue.manage.beans;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

/**
 * author lzc
 */
public class SearchCustomer {
	private String status;//订单状态
	private String collateral;//抵押物
	private String twoYearCredit;//信用记录
	@DateTimeFormat(iso=ISO.DATE)
	private Date startTime;//申请日期开始
	@DateTimeFormat(iso=ISO.DATE)
	private Date endTime;//申请日期结束
	private String product;//选择产品
	private String code;//订单编号
	private String applicantPhone;//客户电话
	private String applicantName;//客户姓名
	private String orderType;//订单类型:1立即领取,2竞拍,3唯一低价,4指定推送,
	//ywh start
	private String orderStatus;//订单状态查询 
	
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	//ywh end
	//add by mzj 2015/09/11 start
	//页
	private int page = 1;
	//序号
	private int index = 0;
	//选择(信贷经理详细-客户信息用：0:全部;1:系统推送;2:人工推送)
	private int selectType = 0;
	//信贷经理ID
	private String managerId = "";
	//add by mzj 2015/09/11 end
	
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public String getCollateral() {
		return collateral;
	}
	public void setCollateral(String collateral) {
		this.collateral = collateral;
	}
	public String getTwoYearCredit() {
		return twoYearCredit;
	}
	public void setTwoYearCredit(String twoYearCredit) {
		this.twoYearCredit = twoYearCredit;
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
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getApplicantPhone() {
		return applicantPhone;
	}
	public void setApplicantPhone(String applicantPhone) {
		this.applicantPhone = applicantPhone;
	}
	public String getApplicantName() {
		return applicantName;
	}
	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the page
	 */
	public int getPage() {
		return page;
	}
	
	/**
	 * @param page the page to set
	 */
	public void setPage(int page) {
		this.page = page;
		this.index = (page-1)*10;
	}
	
	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * @return the selectType
	 */
	public int getSelectType() {
		return selectType;
	}
	
	/**
	 * @param selectType the selectType to set
	 */
	public void setSelectType(int selectType) {
		this.selectType = selectType;
	}
	/**
	 * @return the managerId
	 */
	public String getManagerId() {
		return managerId;
	}
	/**
	 * @param managerId the managerId to set
	 */
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	
	
	
	
}
