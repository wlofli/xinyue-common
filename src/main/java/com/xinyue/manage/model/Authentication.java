package com.xinyue.manage.model;

/**
 * 实名认证信息
 * 
 * @author MK)茅
 * 
 */
public class Authentication {

	private String code = "";

	private String taxCode = "";

	private String companyName = "";

	/**
	 * 营业执照注册号
	 */
	private String zone = "";

	private String companyRegDate = "";

	private String legalPersonName = "";
	
	private String legalPersonID = "";
	
	private String legalPersonTel = "";
	
	private String registerAddress = "";

	private String regFund = "";

	private String industry = "";

	private String contactPerson = "";

	private int contactSex =3;
	
	private String contactTel = "";
	
	private String postCode = "";
	
	private String contactAddress = "";
	
	private String businessLicense = "";
	
	private String taxRegistration = "";
	
	private String organizationCode = "";
	
	private String identityCarda = "";
	
	private String identityCardn = "";
	
	private String identityCardp = "";

	private String memberName = "";

	private String regDate = "";

	private String authenticationDate = "";

	private String authenticationStatus = "";

	private String authenticationType = "";
	
	private String messages ="";
	
	private String contactEmail ="";
	
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the taxCode
	 */
	public String getTaxCode() {
		return taxCode;
	}

	/**
	 * @param taxCode
	 *            the taxCode to set
	 */
	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * @param companyName
	 *            the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * @return the zone
	 */
	public String getZone() {
		return zone;
	}

	/**
	 * @param zone
	 *            the zone to set
	 */
	public void setZone(String zone) {
		this.zone = zone;
	}

	/**
	 * @return the companyRegDate
	 */
	public String getCompanyRegDate() {
		return companyRegDate;
	}

	/**
	 * @param companyRegDate
	 *            the companyRegDate to set
	 */
	public void setCompanyRegDate(String companyRegDate) {
		this.companyRegDate = companyRegDate;
	}

	/**
	 * @return the legalPersonName
	 */
	public String getLegalPersonName() {
		return legalPersonName;
	}

	/**
	 * @param legalPersonName
	 *            the legalPersonName to set
	 */
	public void setLegalPersonName(String legalPersonName) {
		this.legalPersonName = legalPersonName;
	}

	/**
	 * @return the regFund
	 */
	public String getRegFund() {
		return regFund;
	}

	/**
	 * @param regFund
	 *            the regFund to set
	 */
	public void setRegFund(String regFund) {
		this.regFund = regFund;
	}

	/**
	 * @return the industry
	 */
	public String getIndustry() {
		return industry;
	}

	/**
	 * @param industry
	 *            the industry to set
	 */
	public void setIndustry(String industry) {
		this.industry = industry;
	}

	/**
	 * @return the contactPerson
	 */
	public String getContactPerson() {
		return contactPerson;
	}

	/**
	 * @param contactPerson
	 *            the contactPerson to set
	 */
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	/**
	 * @return the contactTel
	 */
	public String getContactTel() {
		return contactTel;
	}

	/**
	 * @param contactTel
	 *            the contactTel to set
	 */
	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}

	/**
	 * @return the memberName
	 */
	public String getMemberName() {
		return memberName;
	}

	/**
	 * @param memberName
	 *            the memberName to set
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	/**
	 * @return the regDate
	 */
	public String getRegDate() {
		return regDate;
	}

	/**
	 * @param regDate
	 *            the regDate to set
	 */
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	/**
	 * @return the authenticationDate
	 */
	public String getAuthenticationDate() {
		return authenticationDate;
	}

	/**
	 * @param authenticationDate
	 *            the authenticationDate to set
	 */
	public void setAuthenticationDate(String authenticationDate) {
		this.authenticationDate = authenticationDate;
	}

	/**
	 * @return the authenticationStatus
	 */
	public String getAuthenticationStatus() {
		return authenticationStatus;
	}

	/**
	 * @param authenticationStatus
	 *            the authenticationStatus to set
	 */
	public void setAuthenticationStatus(String authenticationStatus) {
		this.authenticationStatus = authenticationStatus;
	}

	/**
	 * @return the authenticationType
	 */
	public String getAuthenticationType() {
		return authenticationType;
	}

	/**
	 * @param authenticationType
	 *            the authenticationType to set
	 */
	public void setAuthenticationType(String authenticationType) {
		this.authenticationType = authenticationType;
	}

	/**
	 * @return the legalPersonID
	 */
	public String getLegalPersonID() {
		return legalPersonID;
	}

	/**
	 * @param legalPersonID the legalPersonID to set
	 */
	public void setLegalPersonID(String legalPersonID) {
		this.legalPersonID = legalPersonID;
	}

	/**
	 * @return the legalPersonTel
	 */
	public String getLegalPersonTel() {
		return legalPersonTel;
	}

	/**
	 * @param legalPersonTel the legalPersonTel to set
	 */
	public void setLegalPersonTel(String legalPersonTel) {
		this.legalPersonTel = legalPersonTel;
	}

	/**
	 * @return the registerAddress
	 */
	public String getRegisterAddress() {
		return registerAddress;
	}

	/**
	 * @param registerAddress the registerAddress to set
	 */
	public void setRegisterAddress(String registerAddress) {
		this.registerAddress = registerAddress;
	}

	/**
	 * @return the contactSex
	 */
	public int getContactSex() {
		return contactSex;
	}

	/**
	 * @param contactSex the contactSex to set
	 */
	public void setContactSex(int contactSex) {
		this.contactSex = contactSex;
	}

	/**
	 * @return the postCode
	 */
	public String getPostCode() {
		return postCode;
	}

	/**
	 * @param postCode the postCode to set
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	/**
	 * @return the contactAddress
	 */
	public String getContactAddress() {
		return contactAddress;
	}

	/**
	 * @param contactAddress the contactAddress to set
	 */
	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}

	/**
	 * @return the businessLicense
	 */
	public String getBusinessLicense() {
		return businessLicense;
	}

	/**
	 * @param businessLicense the businessLicense to set
	 */
	public void setBusinessLicense(String businessLicense) {
		this.businessLicense = businessLicense;
	}

	/**
	 * @return the taxRegistration
	 */
	public String getTaxRegistration() {
		return taxRegistration;
	}

	/**
	 * @param taxRegistration the taxRegistration to set
	 */
	public void setTaxRegistration(String taxRegistration) {
		this.taxRegistration = taxRegistration;
	}

	/**
	 * @return the organizationCode
	 */
	public String getOrganizationCode() {
		return organizationCode;
	}

	/**
	 * @param organizationCode the organizationCode to set
	 */
	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}

	/**
	 * @return the identityCarda
	 */
	public String getIdentityCarda() {
		return identityCarda;
	}

	/**
	 * @param identityCarda the identityCarda to set
	 */
	public void setIdentityCarda(String identityCarda) {
		this.identityCarda = identityCarda;
	}

	/**
	 * @return the identityCardn
	 */
	public String getIdentityCardn() {
		return identityCardn;
	}

	/**
	 * @param identityCardn the identityCardn to set
	 */
	public void setIdentityCardn(String identityCardn) {
		this.identityCardn = identityCardn;
	}

	/**
	 * @return the identityCardp
	 */
	public String getIdentityCardp() {
		return identityCardp;
	}

	/**
	 * @param identityCardp the identityCardp to set
	 */
	public void setIdentityCardp(String identityCardp) {
		this.identityCardp = identityCardp;
	}

	/**
	 * @return the messages
	 */
	public String getMessages() {
		return messages;
	}

	/**
	 * @param messages the messages to set
	 */
	public void setMessages(String messages) {
		this.messages = messages;
	}

	/**
	 * @return the contactEmail
	 */
	public String getContactEmail() {
		return contactEmail;
	}

	/**
	 * @param contactEmail the contactEmail to set
	 */
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

}
