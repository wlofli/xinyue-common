/*
 * 杭州摩科商用设备有限公司
 * MOKO-Commercial Device Co.,Ltd
 * 
 * 新越网
 * 
 * 创建人：茅
 * 
 * 日期：2015/04/11
 * 
 * 版本v1.0.0
 * 
 * bug修改:
 * 
 * 
 */
package com.xinyue.manage.beans;

import java.io.Serializable;

public class SubCityInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3997924903563053876L;

	String province = "";
	
	String city = "";
	
	int selectedProvinceCode ;
	
	int selectedCityCode ;

	/**
	 * @return the province
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * @param province the province to set
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the selectedProvinceCode
	 */
	public int getSelectedProvinceCode() {
		return selectedProvinceCode;
	}

	/**
	 * @param selectedProvinceCode the selectedProvinceCode to set
	 */
	public void setSelectedProvinceCode(int selectedProvinceCode) {
		this.selectedProvinceCode = selectedProvinceCode;
	}

	/**
	 * @return the selectedCityCode
	 */
	public int getSelectedCityCode() {
		return selectedCityCode;
	}

	/**
	 * @param selectedCityCode the selectedCityCode to set
	 */
	public void setSelectedCityCode(int selectedCityCode) {
		this.selectedCityCode = selectedCityCode;
	}
}
