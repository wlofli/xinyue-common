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
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date registerTime;//公司成立时间
	private double registerFund;//注册资金
	private String companyType;//企业性质
	private String industry;//所属行业
	private String registerAddress;//注册地址
	private String factBusinessArea;//实际经营所属地区
	private double yearTurnover;//年营业额
	private double yearInvoice;//近一年开票额
	private double assetLiability;//资产负债率
	private double businessGrowth;//营业额年均增长率
	private double yearNetProfit;//上年度净利润
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
	public double getRegisterFund() {
		return registerFund;
	}
	public void setRegisterFund(double registerFund) {
		this.registerFund = registerFund;
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
	public double getYearTurnover() {
		return yearTurnover;
	}
	public void setYearTurnover(double yearTurnover) {
		this.yearTurnover = yearTurnover;
	}
	public double getYearInvoice() {
		return yearInvoice;
	}
	public void setYearInvoice(double yearInvoice) {
		this.yearInvoice = yearInvoice;
	}
	public double getAssetLiability() {
		return assetLiability;
	}
	public void setAssetLiability(double assetLiability) {
		this.assetLiability = assetLiability;
	}
	public double getBusinessGrowth() {
		return businessGrowth;
	}
	public void setBusinessGrowth(double businessGrowth) {
		this.businessGrowth = businessGrowth;
	}
	public double getYearNetProfit() {
		return yearNetProfit;
	}
	public void setYearNetProfit(double yearNetProfit) {
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
