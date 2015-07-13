package com.xinyue.manage.model;

/**
 * 评价信息
 * @author MK)茅
 *
 */
public class Rating {

	private String businessType = "";
	private String organization = "";
	private String applyCompany = "";
	private String applyperson = "";

	/**
	 * @return the businessType
	 */
	public String getBusinessType() {
		return businessType;
	}

	/**
	 * @param businessType
	 *            the businessType to set
	 */
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	/**
	 * @return the organization
	 */
	public String getOrganization() {
		return organization;
	}

	/**
	 * @param organization
	 *            the organization to set
	 */
	public void setOrganization(String organization) {
		this.organization = organization;
	}

	/**
	 * @return the applyCompany
	 */
	public String getApplyCompany() {
		return applyCompany;
	}

	/**
	 * @param applyCompany
	 *            the applyCompany to set
	 */
	public void setApplyCompany(String applyCompany) {
		this.applyCompany = applyCompany;
	}

	/**
	 * @return the applyperson
	 */
	public String getApplyperson() {
		return applyperson;
	}

	/**
	 * @param applyperson
	 *            the applyperson to set
	 */
	public void setApplyperson(String applyperson) {
		this.applyperson = applyperson;
	}
}
