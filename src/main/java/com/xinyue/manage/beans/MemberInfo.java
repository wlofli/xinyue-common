package com.xinyue.manage.beans;

import java.io.Serializable;

import com.xinyue.manage.util.GlobalConstant;

/**
 * 
 * @author wenhai.you
 * @2015年6月9日
 * @下午2:15:20
 */
public class MemberInfo implements Serializable {

	private String company;
	private String startTime;
	private String endTime;
	private String contactName;
	private String contactPhone;
	private String legalRepresentative;
	private String startCapital;
	private String endCapital;
	private String industry;
	private String startCount;
	private String taxRegistrationArea;
	private String endCount;
	private int start;
	private String type;
	private String topage;
	private int pageSize = GlobalConstant.PAGE_SIZE;
	private int page=1;//1分页  2 不分页查询所有数据
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTopage() {
		return topage;
	}
	public void setTopage(String topage) {
		this.topage = topage;
	}
	public String getTaxRegistrationArea() {
		return taxRegistrationArea;
	}
	public void setTaxRegistrationArea(String taxRegistrationArea) {
		this.taxRegistrationArea = taxRegistrationArea;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactPhone() {
		return contactPhone;
	}
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	public String getLegalRepresentative() {
		return legalRepresentative;
	}
	public void setLegalRepresentative(String legalRepresentative) {
		this.legalRepresentative = legalRepresentative;
	}
	public String getStartCapital() {
		return startCapital;
	}
	public void setStartCapital(String startCapital) {
		this.startCapital = startCapital;
	}
	public String getEndCapital() {
		return endCapital;
	}
	public void setEndCapital(String endCapital) {
		this.endCapital = endCapital;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getStartCount() {
		return startCount;
	}
	public void setStartCount(String startCount) {
		this.startCount = startCount;
	}
	public String getEndCount() {
		return endCount;
	}
	public void setEndCount(String endCount) {
		this.endCount = endCount;
	}
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
	@Override
	public String toString() {
		return "MemberInfo [company=" + company + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", contactName=" + contactName
				+ ", contactPhone=" + contactPhone + ", legalRepresentative="
				+ legalRepresentative + ", startCapital=" + startCapital
				+ ", endCapital=" + endCapital + ", industry=" + industry
				+ ", startCount=" + startCount + ", taxRegistrationArea="
				+ taxRegistrationArea + ", endCount=" + endCount + ", start="
				+ start + ", type=" + type + ", pageSize=" + pageSize
				+ ", topage=" + topage + "]";
	}
	
}
