package com.xinyue.manage.model;

/**
 * 产品选项信息表
 * @author wenhai.you
 * @2015年9月14日
 * @下午4:30:23
 */
public class ProductContent {

	// 产品标识符
	private String productcode;

	// 申请人姓名
	private boolean applicantname = true;

	// 手机号码
	private boolean phonenumber = true;

	// 电子邮箱
	private boolean email = true;

	// 申贷期限
	private boolean loandate = true;

	// 申贷金额
	private boolean loanamount = true;
	
	private boolean purpose = true;//申请用途
	// 可接受最高利率
	private boolean interestrate = true;

	// 还款方式
	private boolean repaymenttype = true;

	// 主要担保方式
	private boolean collateraltype = true;
	
	private boolean collateralname = true;//担保人姓名
	// 担保金额
	private boolean guaranteeamount = true;
	private boolean collateralthinkname = true;//担保物名称
	// 担保物所在地区
	private boolean guarantearea = true;

	// 担保物是否在本地
	private boolean localareathing = true;

	// 推荐我的渠道经理
	//private boolean channelmanager = true;

	// 工号
	//private boolean jobnumber = true;

	// 公司名称
	private boolean companyname = true;

	// 法人代表
	private boolean legalperson = true;

	// 证件类型1
	private boolean certificatetype_1 = true;

	// 证件号码1
	private boolean certificatenum_1 = true;

	// 营业执照注册号
	private boolean businesslicensenum = true;

	// 工商注册时间
	private boolean registerdate = true;

	// 最近一年年检时间
	private boolean lastinspectiondate = true;

	// 是否有年检记录
	private boolean inspectionrecord = true;

	// 注册资本
	private boolean registercapital = true;

	// 实收资本
	private boolean realcapital = true;

	// 企业性质
	private boolean companytype = true;

	// 实际经营场所所属地区
	private boolean placearea = true;

	// 组织机构代码证编号
	private boolean codenum = true;

	private boolean enterpriseno;//企业电户号
	// 公司联系电话
	private boolean companyphone = true;

	// 公司传真号码
	private boolean companyfax = true;

	// 营业执照到期日
	private boolean licensedate = true;

	// 工商登记类型
	private boolean registertype = true;

	// 机构类型
	private boolean organizationtype = true;

	// 税务登记证号码（国）
	private boolean nationtaxnum = true;

	// 税务登记证号码（地）
	private boolean localtaxnum = true;

	// 股东控股方式
	private boolean staketype = true;

	// 实际控制人之一
	private boolean stakeperson = true;

	// 证件类型2
	private boolean certificatetype_2 = true;

	// 证件号码2
	private boolean certificatenum_2 = true;

	// 从业年限
	private boolean employeeage = true;

	// 学历
	private boolean education = true;

	// 婚姻状况
	private boolean marriage = true;
	//private boolean salesgrowth=true;//销售增长情况
	// 所属行业
	private boolean industry = true;

	// 持续经营开始时间
	private boolean managementstartdate = true;

	// 主要经营地点是否在本地
	private boolean localarea = true;

	// 主要产品销售区域
	private boolean salearea = true;

	// 是否固定营业场所
	private boolean managementplace = true;

	// 进入园区或市场的年限
	private boolean entertime = true;

	// 是否存在多个股东在我行、他行授信
	private boolean creditstatus = true;

	// 企业财务报表的审计意见类型
	private boolean audittype = true;
	private boolean annualvatamount = true;//年度增值税纳额
	private boolean annualtaxamount = true;//年度所得税纳额
	// 员工人数
	private boolean employeenum = true;

	// 是否有贷款卡
	private boolean loancard = true;

	// 贷款卡卡号
	private boolean loancardnum = true;

	// 年度总销售收入
	private boolean totalincome = true;

	// 年度月均水费
	private boolean monthlywater = true;

	// 年度订单总金额
	private boolean totalordermoney = true;

	// 年度月均电费
	private boolean monthlyelectric = true;

	// 厂房
	private boolean workshop = true;

	// 土地
	private boolean land = true;

	// 办公楼
	private boolean officebuilding = true;

	// 店铺
	private boolean shop = true;

	// 法人私有房产
	private boolean priviatehouse = true;

	// 机器设备
	private boolean machine = true;

	// 其他
	private boolean other = true;

	// 公司资产负债率
	private boolean debtrate = true;

	// 公司收入负债比
	private boolean incomerate = true;

	// 抵质押物情况
	private boolean collateral = true;

	// 可作为第一还款来源的年净收入
	private boolean fristincome = true;

	// 是否大型企业的上下游行业
	private boolean relevantindustry = true;

	// 企业净资产
	private boolean netasset = true;

	// 企业资产流动比率
	private boolean assetflowrate = true;

	// 企业主资产
	private boolean mainasset = true;
	
	// 删除标志位
	private boolean deleted = true;	
	
	//2014/09/11 茅 追加 START
	// 销售增长情况
	private boolean salegrowthtype = true;
	//2014/09/11 茅 追加 END

	/**
	 * @return the productCode
	 */
	public String getProductcode() {
		return productcode;
	}

	public boolean isGuarantearea() {
		return guarantearea;
	}

	public void setGuarantearea(boolean guarantearea) {
		this.guarantearea = guarantearea;
	}

	public boolean isCollateralname() {
		return collateralname;
	}

	public void setCollateralname(boolean collateralname) {
		this.collateralname = collateralname;
	}

	public boolean isCollateralthinkname() {
		return collateralthinkname;
	}

	public void setCollateralthinkname(boolean collateralthinkname) {
		this.collateralthinkname = collateralthinkname;
	}

	public boolean isEnterpriseno() {
		return enterpriseno;
	}

	public void setEnterpriseno(boolean enterpriseno) {
		this.enterpriseno = enterpriseno;
	}

	public boolean isAnnualvatamount() {
		return annualvatamount;
	}

	public void setAnnualvatamount(boolean annualvatamount) {
		this.annualvatamount = annualvatamount;
	}

	public boolean isAnnualtaxamount() {
		return annualtaxamount;
	}

	public void setAnnualtaxamount(boolean annualtaxamount) {
		this.annualtaxamount = annualtaxamount;
	}

	public boolean isPurpose() {
		return purpose;
	}

	public void setPurpose(boolean purpose) {
		this.purpose = purpose;
	}

	/**
	 * @param productCode the productCode to set
	 */
	public void setProductcode(String productcode) {
		this.productcode = productcode;
	}

	/**
	 * @return the applicantname
	 */
	public boolean isApplicantname() {
		return applicantname;
	}

	/**
	 * @param applicantname the applicantname to set
	 */
	public void setApplicantname(boolean applicantname) {
		this.applicantname = applicantname;
	}

	/**
	 * @return the phonenumber
	 */
	public boolean isPhonenumber() {
		return phonenumber;
	}

	/**
	 * @param phonenumber the phonenumber to set
	 */
	public void setPhonenumber(boolean phonenumber) {
		this.phonenumber = phonenumber;
	}

	/**
	 * @return the email
	 */
	public boolean isEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(boolean email) {
		this.email = email;
	}

	/**
	 * @return the loandate
	 */
	public boolean isLoandate() {
		return loandate;
	}

	/**
	 * @param loandate the loandate to set
	 */
	public void setLoandate(boolean loandate) {
		this.loandate = loandate;
	}

	/**
	 * @return the loanamount
	 */
	public boolean isLoanamount() {
		return loanamount;
	}

	/**
	 * @param loanamount the loanamount to set
	 */
	public void setLoanamount(boolean loanamount) {
		this.loanamount = loanamount;
	}

	/**
	 * @return the interestrate
	 */
	public boolean isInterestrate() {
		return interestrate;
	}

	/**
	 * @param interestrate the interestrate to set
	 */
	public void setInterestrate(boolean interestrate) {
		this.interestrate = interestrate;
	}

	/**
	 * @return the repaymenttype
	 */
	public boolean isRepaymenttype() {
		return repaymenttype;
	}

	/**
	 * @param repaymenttype the repaymenttype to set
	 */
	public void setRepaymenttype(boolean repaymenttype) {
		this.repaymenttype = repaymenttype;
	}

	/**
	 * @return the guaranteeamount
	 */
	public boolean isGuaranteeamount() {
		return guaranteeamount;
	}

	/**
	 * @param guaranteeamount the guaranteeamount to set
	 */
	public void setGuaranteeamount(boolean guaranteeamount) {
		this.guaranteeamount = guaranteeamount;
	}


	/**
	 * @return the localareathing
	 */
	public boolean isLocalareathing() {
		return localareathing;
	}

	/**
	 * @param localareathing the localareathing to set
	 */
	public void setLocalareathing(boolean localareathing) {
		this.localareathing = localareathing;
	}

	/**
	 * @return the companyname
	 */
	public boolean isCompanyname() {
		return companyname;
	}

	/**
	 * @param companyname the companyname to set
	 */
	public void setCompanyname(boolean companyname) {
		this.companyname = companyname;
	}

	/**
	 * @return the legalperson
	 */
	public boolean isLegalperson() {
		return legalperson;
	}

	/**
	 * @param legalperson the legalperson to set
	 */
	public void setLegalperson(boolean legalperson) {
		this.legalperson = legalperson;
	}

	/**
	 * @return the certificatetype_1
	 */
	public boolean isCertificatetype_1() {
		return certificatetype_1;
	}

	/**
	 * @param certificatetype_1 the certificatetype_1 to set
	 */
	public void setCertificatetype_1(boolean certificatetype_1) {
		this.certificatetype_1 = certificatetype_1;
	}

	/**
	 * @return the certificatenum_1
	 */
	public boolean isCertificatenum_1() {
		return certificatenum_1;
	}

	/**
	 * @param certificatenum_1 the certificatenum_1 to set
	 */
	public void setCertificatenum_1(boolean certificatenum_1) {
		this.certificatenum_1 = certificatenum_1;
	}

	/**
	 * @return the businesslicensenum
	 */
	public boolean isBusinesslicensenum() {
		return businesslicensenum;
	}

	/**
	 * @param businesslicensenum the businesslicensenum to set
	 */
	public void setBusinesslicensenum(boolean businesslicensenum) {
		this.businesslicensenum = businesslicensenum;
	}

	/**
	 * @return the registerdate
	 */
	public boolean isRegisterdate() {
		return registerdate;
	}

	/**
	 * @param registerdate the registerdate to set
	 */
	public void setRegisterdate(boolean registerdate) {
		this.registerdate = registerdate;
	}

	/**
	 * @return the lastinspectiondate
	 */
	public boolean isLastinspectiondate() {
		return lastinspectiondate;
	}

	/**
	 * @param lastinspectiondate the lastinspectiondate to set
	 */
	public void setLastinspectiondate(boolean lastinspectiondate) {
		this.lastinspectiondate = lastinspectiondate;
	}

	/**
	 * @return the inspectionrecord
	 */
	public boolean isInspectionrecord() {
		return inspectionrecord;
	}

	/**
	 * @param inspectionrecord the inspectionrecord to set
	 */
	public void setInspectionrecord(boolean inspectionrecord) {
		this.inspectionrecord = inspectionrecord;
	}

	/**
	 * @return the registercapital
	 */
	public boolean isRegistercapital() {
		return registercapital;
	}

	/**
	 * @param registercapital the registercapital to set
	 */
	public void setRegistercapital(boolean registercapital) {
		this.registercapital = registercapital;
	}

	/**
	 * @return the realcapital
	 */
	public boolean isRealcapital() {
		return realcapital;
	}

	/**
	 * @param realcapital the realcapital to set
	 */
	public void setRealcapital(boolean realcapital) {
		this.realcapital = realcapital;
	}

	/**
	 * @return the companytype
	 */
	public boolean isCompanytype() {
		return companytype;
	}

	/**
	 * @param companytype the companytype to set
	 */
	public void setCompanytype(boolean companytype) {
		this.companytype = companytype;
	}

	/**
	 * @return the placearea
	 */
	public boolean isPlacearea() {
		return placearea;
	}

	/**
	 * @param placearea the placearea to set
	 */
	public void setPlacearea(boolean placearea) {
		this.placearea = placearea;
	}

	/**
	 * @return the codenum
	 */
	public boolean isCodenum() {
		return codenum;
	}

	/**
	 * @param codenum the codenum to set
	 */
	public void setCodenum(boolean codenum) {
		this.codenum = codenum;
	}

	/**
	 * @return the companyphone
	 */
	public boolean isCompanyphone() {
		return companyphone;
	}

	/**
	 * @param companyphone the companyphone to set
	 */
	public void setCompanyphone(boolean companyphone) {
		this.companyphone = companyphone;
	}

	/**
	 * @return the companyfax
	 */
	public boolean isCompanyfax() {
		return companyfax;
	}

	/**
	 * @param companyfax the companyfax to set
	 */
	public void setCompanyfax(boolean companyfax) {
		this.companyfax = companyfax;
	}

	/**
	 * @return the licensedate
	 */
	public boolean isLicensedate() {
		return licensedate;
	}

	/**
	 * @param licensedate the licensedate to set
	 */
	public void setLicensedate(boolean licensedate) {
		this.licensedate = licensedate;
	}

	/**
	 * @return the registertype
	 */
	public boolean isRegistertype() {
		return registertype;
	}

	/**
	 * @param registertype the registertype to set
	 */
	public void setRegistertype(boolean registertype) {
		this.registertype = registertype;
	}

	/**
	 * @return the organizationtype
	 */
	public boolean isOrganizationtype() {
		return organizationtype;
	}

	/**
	 * @param organizationtype the organizationtype to set
	 */
	public void setOrganizationtype(boolean organizationtype) {
		this.organizationtype = organizationtype;
	}

	/**
	 * @return the nationtaxnum
	 */
	public boolean isNationtaxnum() {
		return nationtaxnum;
	}

	/**
	 * @param nationtaxnum the nationtaxnum to set
	 */
	public void setNationtaxnum(boolean nationtaxnum) {
		this.nationtaxnum = nationtaxnum;
	}

	/**
	 * @return the localtaxnum
	 */
	public boolean isLocaltaxnum() {
		return localtaxnum;
	}

	/**
	 * @param localtaxnum the localtaxnum to set
	 */
	public void setLocaltaxnum(boolean localtaxnum) {
		this.localtaxnum = localtaxnum;
	}

	/**
	 * @return the staketype
	 */
	public boolean isStaketype() {
		return staketype;
	}

	/**
	 * @param staketype the staketype to set
	 */
	public void setStaketype(boolean staketype) {
		this.staketype = staketype;
	}

	/**
	 * @return the stakeperson
	 */
	public boolean isStakeperson() {
		return stakeperson;
	}

	/**
	 * @param stakeperson the stakeperson to set
	 */
	public void setStakeperson(boolean stakeperson) {
		this.stakeperson = stakeperson;
	}

	/**
	 * @return the certificatetype_2
	 */
	public boolean isCertificatetype_2() {
		return certificatetype_2;
	}

	/**
	 * @param certificatetype_2 the certificatetype_2 to set
	 */
	public void setCertificatetype_2(boolean certificatetype_2) {
		this.certificatetype_2 = certificatetype_2;
	}

	/**
	 * @return the certificatenum_2
	 */
	public boolean isCertificatenum_2() {
		return certificatenum_2;
	}

	/**
	 * @param certificatenum_2 the certificatenum_2 to set
	 */
	public void setCertificatenum_2(boolean certificatenum_2) {
		this.certificatenum_2 = certificatenum_2;
	}

	/**
	 * @return the employeeage
	 */
	public boolean isEmployeeage() {
		return employeeage;
	}

	/**
	 * @param employeeage the employeeage to set
	 */
	public void setEmployeeage(boolean employeeage) {
		this.employeeage = employeeage;
	}

	/**
	 * @return the education
	 */
	public boolean isEducation() {
		return education;
	}

	/**
	 * @param education the education to set
	 */
	public void setEducation(boolean education) {
		this.education = education;
	}

	/**
	 * @return the marriage
	 */
	public boolean isMarriage() {
		return marriage;
	}

	/**
	 * @param marriage the marriage to set
	 */
	public void setMarriage(boolean marriage) {
		this.marriage = marriage;
	}

	/**
	 * @return the industry
	 */
	public boolean isIndustry() {
		return industry;
	}

	/**
	 * @param industry the industry to set
	 */
	public void setIndustry(boolean industry) {
		this.industry = industry;
	}

	/**
	 * @return the managementstartdate
	 */
	public boolean isManagementstartdate() {
		return managementstartdate;
	}

	/**
	 * @param managementstartdate the managementstartdate to set
	 */
	public void setManagementstartdate(boolean managementstartdate) {
		this.managementstartdate = managementstartdate;
	}

	/**
	 * @return the localarea
	 */
	public boolean isLocalarea() {
		return localarea;
	}

	/**
	 * @param localarea the localarea to set
	 */
	public void setLocalarea(boolean localarea) {
		this.localarea = localarea;
	}

	/**
	 * @return the salearea
	 */
	public boolean isSalearea() {
		return salearea;
	}

	/**
	 * @param salearea the salearea to set
	 */
	public void setSalearea(boolean salearea) {
		this.salearea = salearea;
	}

	/**
	 * @return the managementplace
	 */
	public boolean isManagementplace() {
		return managementplace;
	}

	/**
	 * @param managementplace the managementplace to set
	 */
	public void setManagementplace(boolean managementplace) {
		this.managementplace = managementplace;
	}

	/**
	 * @return the entertime
	 */
	public boolean isEntertime() {
		return entertime;
	}

	/**
	 * @param entertime the entertime to set
	 */
	public void setEntertime(boolean entertime) {
		this.entertime = entertime;
	}

	/**
	 * @return the creditstatus
	 */
	public boolean isCreditstatus() {
		return creditstatus;
	}

	/**
	 * @param creditstatus the creditstatus to set
	 */
	public void setCreditstatus(boolean creditstatus) {
		this.creditstatus = creditstatus;
	}

	/**
	 * @return the audittype
	 */
	public boolean isAudittype() {
		return audittype;
	}

	/**
	 * @param audittype the audittype to set
	 */
	public void setAudittype(boolean audittype) {
		this.audittype = audittype;
	}

	/**
	 * @return the employeenum
	 */
	public boolean isEmployeenum() {
		return employeenum;
	}

	/**
	 * @param employeenum the employeenum to set
	 */
	public void setEmployeenum(boolean employeenum) {
		this.employeenum = employeenum;
	}

	/**
	 * @return the loancard
	 */
	public boolean isLoancard() {
		return loancard;
	}

	/**
	 * @param loancard the loancard to set
	 */
	public void setLoancard(boolean loancard) {
		this.loancard = loancard;
	}

	/**
	 * @return the loancardnum
	 */
	public boolean isLoancardnum() {
		return loancardnum;
	}

	/**
	 * @param loancardnum the loancardnum to set
	 */
	public void setLoancardnum(boolean loancardnum) {
		this.loancardnum = loancardnum;
	}

	/**
	 * @return the totalincome
	 */
	public boolean isTotalincome() {
		return totalincome;
	}

	/**
	 * @param totalincome the totalincome to set
	 */
	public void setTotalincome(boolean totalincome) {
		this.totalincome = totalincome;
	}

	/**
	 * @return the monthlywater
	 */
	public boolean isMonthlywater() {
		return monthlywater;
	}

	/**
	 * @param monthlywater the monthlywater to set
	 */
	public void setMonthlywater(boolean monthlywater) {
		this.monthlywater = monthlywater;
	}

	/**
	 * @return the totalordermoney
	 */
	public boolean isTotalordermoney() {
		return totalordermoney;
	}

	/**
	 * @param totalordermoney the totalordermoney to set
	 */
	public void setTotalordermoney(boolean totalordermoney) {
		this.totalordermoney = totalordermoney;
	}

	/**
	 * @return the monthlyelectric
	 */
	public boolean isMonthlyelectric() {
		return monthlyelectric;
	}

	/**
	 * @param monthlyelectric the monthlyelectric to set
	 */
	public void setMonthlyelectric(boolean monthlyelectric) {
		this.monthlyelectric = monthlyelectric;
	}

	/**
	 * @return the workshop
	 */
	public boolean isWorkshop() {
		return workshop;
	}

	/**
	 * @param workshop the workshop to set
	 */
	public void setWorkshop(boolean workshop) {
		this.workshop = workshop;
	}

	/**
	 * @return the land
	 */
	public boolean isLand() {
		return land;
	}

	/**
	 * @param land the land to set
	 */
	public void setLand(boolean land) {
		this.land = land;
	}

	/**
	 * @return the officebuilding
	 */
	public boolean isOfficebuilding() {
		return officebuilding;
	}

	/**
	 * @param officebuilding the officebuilding to set
	 */
	public void setOfficebuilding(boolean officebuilding) {
		this.officebuilding = officebuilding;
	}

	/**
	 * @return the shop
	 */
	public boolean isShop() {
		return shop;
	}

	/**
	 * @param shop the shop to set
	 */
	public void setShop(boolean shop) {
		this.shop = shop;
	}

	/**
	 * @return the priviatehouse
	 */
	public boolean isPriviatehouse() {
		return priviatehouse;
	}

	/**
	 * @param priviatehouse the priviatehouse to set
	 */
	public void setPriviatehouse(boolean priviatehouse) {
		this.priviatehouse = priviatehouse;
	}

	/**
	 * @return the machine
	 */
	public boolean isMachine() {
		return machine;
	}

	/**
	 * @param machine the machine to set
	 */
	public void setMachine(boolean machine) {
		this.machine = machine;
	}

	/**
	 * @return the other
	 */
	public boolean isOther() {
		return other;
	}

	/**
	 * @param other the other to set
	 */
	public void setOther(boolean other) {
		this.other = other;
	}

	/**
	 * @return the debtrate
	 */
	public boolean isDebtrate() {
		return debtrate;
	}

	/**
	 * @param debtrate the debtrate to set
	 */
	public void setDebtrate(boolean debtrate) {
		this.debtrate = debtrate;
	}

	/**
	 * @return the incomerate
	 */
	public boolean isIncomerate() {
		return incomerate;
	}

	/**
	 * @param incomerate the incomerate to set
	 */
	public void setIncomerate(boolean incomerate) {
		this.incomerate = incomerate;
	}

	/**
	 * @return the collateral
	 */
	public boolean isCollateral() {
		return collateral;
	}

	/**
	 * @param collateral the collateral to set
	 */
	public void setCollateral(boolean collateral) {
		this.collateral = collateral;
	}

	/**
	 * @return the fristincome
	 */
	public boolean isFristincome() {
		return fristincome;
	}

	/**
	 * @param fristincome the fristincome to set
	 */
	public void setFristincome(boolean fristincome) {
		this.fristincome = fristincome;
	}

	/**
	 * @return the relevantindustry
	 */
	public boolean isRelevantindustry() {
		return relevantindustry;
	}

	/**
	 * @param relevantindustry the relevantindustry to set
	 */
	public void setRelevantindustry(boolean relevantindustry) {
		this.relevantindustry = relevantindustry;
	}

	/**
	 * @return the netasset
	 */
	public boolean isNetasset() {
		return netasset;
	}

	/**
	 * @param netasset the netasset to set
	 */
	public void setNetasset(boolean netasset) {
		this.netasset = netasset;
	}

	/**
	 * @return the assetflowrate
	 */
	public boolean isAssetflowrate() {
		return assetflowrate;
	}

	/**
	 * @param assetflowrate the assetflowrate to set
	 */
	public void setAssetflowrate(boolean assetflowrate) {
		this.assetflowrate = assetflowrate;
	}

	/**
	 * @return the mainasset
	 */
	public boolean isMainasset() {
		return mainasset;
	}

	/**
	 * @param mainasset the mainasset to set
	 */
	public void setMainasset(boolean mainasset) {
		this.mainasset = mainasset;
	}

	/**
	 * @return the collateraltype
	 */
	public boolean isCollateraltype() {
		return collateraltype;
	}

	/**
	 * @param collateraltype the collateraltype to set
	 */
	public void setCollateraltype(boolean collateraltype) {
		this.collateraltype = collateraltype;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	//2014/09/11 茅 追加 START
	public boolean isSalegrowthtype() {
		return salegrowthtype;
	}

	public void setSalegrowthtype(boolean salegrowthtype) {
		this.salegrowthtype = salegrowthtype;
	}
	//2014/09/11 茅 追加 END

	@Override
	public String toString() {
		return "ProductContent [productcode=" + productcode
				+ ", applicantname=" + applicantname + ", phonenumber="
				+ phonenumber + ", email=" + email + ", loandate=" + loandate
				+ ", loanamount=" + loanamount + ", purpose=" + purpose
				+ ", interestrate=" + interestrate + ", repaymenttype="
				+ repaymenttype + ", collateraltype=" + collateraltype
				+ ", collateralname=" + collateralname + ", guaranteeamount="
				+ guaranteeamount + ", collateralthinkname="
				+ collateralthinkname + ", guarantearea=" + guarantearea
				+ ", localareathing=" + localareathing + ", companyname="
				+ companyname + ", legalperson=" + legalperson
				+ ", certificatetype_1=" + certificatetype_1
				+ ", certificatenum_1=" + certificatenum_1
				+ ", businesslicensenum=" + businesslicensenum
				+ ", registerdate=" + registerdate + ", lastinspectiondate="
				+ lastinspectiondate + ", inspectionrecord=" + inspectionrecord
				+ ", registercapital=" + registercapital + ", realcapital="
				+ realcapital + ", companytype=" + companytype + ", placearea="
				+ placearea + ", codenum=" + codenum + ", enterpriseno="
				+ enterpriseno + ", companyphone=" + companyphone
				+ ", companyfax=" + companyfax + ", licensedate=" + licensedate
				+ ", registertype=" + registertype + ", organizationtype="
				+ organizationtype + ", nationtaxnum=" + nationtaxnum
				+ ", localtaxnum=" + localtaxnum + ", staketype=" + staketype
				+ ", stakeperson=" + stakeperson + ", certificatetype_2="
				+ certificatetype_2 + ", certificatenum_2=" + certificatenum_2
				+ ", employeeage=" + employeeage + ", education=" + education
				+ ", marriage=" + marriage + ", industry=" + industry
				+ ", managementstartdate=" + managementstartdate
				+ ", localarea=" + localarea + ", salearea=" + salearea
				+ ", managementplace=" + managementplace + ", entertime="
				+ entertime + ", creditstatus=" + creditstatus + ", audittype="
				+ audittype + ", annualvatamount=" + annualvatamount
				+ ", annualtaxamount=" + annualtaxamount + ", employeenum="
				+ employeenum + ", loancard=" + loancard + ", loancardnum="
				+ loancardnum + ", totalincome=" + totalincome
				+ ", monthlywater=" + monthlywater + ", totalordermoney="
				+ totalordermoney + ", monthlyelectric=" + monthlyelectric
				+ ", workshop=" + workshop + ", land=" + land
				+ ", officebuilding=" + officebuilding + ", shop=" + shop
				+ ", priviatehouse=" + priviatehouse + ", machine=" + machine
				+ ", other=" + other + ", debtrate=" + debtrate
				+ ", incomerate=" + incomerate + ", collateral=" + collateral
				+ ", fristincome=" + fristincome + ", relevantindustry="
				+ relevantindustry + ", netasset=" + netasset
				+ ", assetflowrate=" + assetflowrate + ", mainasset="
				+ mainasset + ", deleted=" + deleted + ", salegrowthtype="
				+ salegrowthtype + "]";
	}

	
}
