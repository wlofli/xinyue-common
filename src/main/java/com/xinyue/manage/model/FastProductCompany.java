package com.xinyue.manage.model;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * author lzc
 */
public class FastProductCompany {
	
	private String companyFastId;  //id
	private String companyName; //公司名称
	private String legalRepresentative;//法人代表
	private String parpersType;//证件类型
	private String papersNumber;//证件号码
	private String businessLicenseNumber;//营业执照注册号
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date registerTime;//公司成立时间
	private Double registerFund;//注册资金
	private String companyType;//企业性质
	private String industry;//所属行业
	private String registerAddress;//注册地址
	private String factBusinessArea;//实际经营所属地区
	private Double yearTurnover;//年营业额
	private Double yearInvoice;//近一年开票额
	private Double assetLiability;//资产负债率
	private Double businessGrowth;//营业额年均增长率
	private Double yearNetProfit;//上年度净利润
	private String staffNumber;//员工人数
	private String personInformation;//个人信息
	
	
	public String getParpersType() {
		return parpersType;
	}
	public void setParpersType(String parpersType) {
		this.parpersType = parpersType;
	}
	public String getCompanyFastId() {
		return companyFastId;
	}
	public void setCompanyFastId(String companyFastId) {
		this.companyFastId = companyFastId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getLegalRepresentative() {
		return legalRepresentative;
	}
	public void setLegalRepresentative(String legalRepresentative) {
		this.legalRepresentative = legalRepresentative;
	}
	public String getPapersNumber() {
		return papersNumber;
	}
	public void setPapersNumber(String papersNumber) {
		this.papersNumber = papersNumber;
	}
	public String getBusinessLicenseNumber() {
		return businessLicenseNumber;
	}
	public void setBusinessLicenseNumber(String businessLicenseNumber) {
		this.businessLicenseNumber = businessLicenseNumber;
	}
	public Date getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
	
	public String getCompanyType() {
		return companyType;
	}
	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getRegisterAddress() {
		return registerAddress;
	}
	public void setRegisterAddress(String registerAddress) {
		this.registerAddress = registerAddress;
	}
	public String getFactBusinessArea() {
		return factBusinessArea;
	}
	public void setFactBusinessArea(String factBusinessArea) {
		this.factBusinessArea = factBusinessArea;
	}
	
	
	
	public Double getRegisterFund() {
		return registerFund;
	}
	public void setRegisterFund(Double registerFund) {
		this.registerFund = registerFund;
	}
	public Double getYearTurnover() {
		return yearTurnover;
	}
	public void setYearTurnover(Double yearTurnover) {
		this.yearTurnover = yearTurnover;
	}
	public Double getYearInvoice() {
		return yearInvoice;
	}
	public void setYearInvoice(Double yearInvoice) {
		this.yearInvoice = yearInvoice;
	}
	public Double getAssetLiability() {
		return assetLiability;
	}
	public void setAssetLiability(Double assetLiability) {
		this.assetLiability = assetLiability;
	}
	public Double getBusinessGrowth() {
		return businessGrowth;
	}
	public void setBusinessGrowth(Double businessGrowth) {
		this.businessGrowth = businessGrowth;
	}
	public Double getYearNetProfit() {
		return yearNetProfit;
	}
	public void setYearNetProfit(Double yearNetProfit) {
		this.yearNetProfit = yearNetProfit;
	}
	public String getStaffNumber() {
		return staffNumber;
	}
	public void setStaffNumber(String staffNumber) {
		this.staffNumber = staffNumber;
	}
	public String getPersonInformation() {
		return personInformation;
	}
	public void setPersonInformation(String personInformation) {
		this.personInformation = personInformation;
	}

	
	
}
