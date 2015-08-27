package com.xinyue.manage.beans;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

/**
 * author lzc
 */
public class SearchCustomer {
	private String status;
	private String collateral;
	private String twoYearCredit;
	@DateTimeFormat(iso=ISO.DATE)
	private Date startTime;
	@DateTimeFormat(iso=ISO.DATE)
	private Date endTime;
	private String product;
	private String code;
	private String applicantPhone;
	private String applicantName;
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
	
	
	
	
}
