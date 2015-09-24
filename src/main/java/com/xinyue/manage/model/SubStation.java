package com.xinyue.manage.model;

public class SubStation {

	//youwh
	private int id;
	//youwh
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	String subName;
	
	String selectedP;
	
	String selectedC;
	
	String selectedZ;
	
	String selectedCHid;
	
	String selectedZHid;
	
	String firstLetter;
	
	boolean hot;
	
	String stationCode;

	/**
	 * @return the subName
	 */
	public String getSubName() {
		return subName;
	}

	/**
	 * @param subName the subName to set
	 */
	public void setSubName(String subName) {
		this.subName = subName;
	}

	/**
	 * @return the selectedP
	 */
	public String getSelectedP() {
		return selectedP;
	}

	/**
	 * @param selectedP the selectedP to set
	 */
	public void setSelectedP(String selectedP) {
		this.selectedP = selectedP;
	}

	/**
	 * @return the selectedC
	 */
	public String getSelectedC() {
		return selectedC;
	}

	/**
	 * @param selectedC the selectedC to set
	 */
	public void setSelectedC(String selectedC) {
		this.selectedC = selectedC;
	}

	/**
	 * @return the selectedZ
	 */
	public String getSelectedZ() {
		return selectedZ;
	}

	/**
	 * @param selectedZ the selectedZ to set
	 */
	public void setSelectedZ(String selectedZ) {
		this.selectedZ = selectedZ;
	}

	/**
	 * @return the firstLetter
	 */
	public String getFirstLetter() {
		return firstLetter;
	}

	/**
	 * @param firstLetter the firstLetter to set
	 */
	public void setFirstLetter(String firstLetter) {
		this.firstLetter = firstLetter;
	}

	/**
	 * @return the hot
	 */
	public boolean isHot() {
		return hot;
	}

	/**
	 * @param hot the hot to set
	 */
	public void setHot(boolean hot) {
		this.hot = hot;
	}

	/**
	 * @return the stationCode
	 */
	public String getStationCode() {
		return stationCode;
	}

	/**
	 * @param stationCode the stationCode to set
	 */
	public void setStationCode(String stationCode) {
		this.stationCode = stationCode;
	}

	/**
	 * @return the selectedCHid
	 */
	public String getSelectedCHid() {
		return selectedCHid;
	}

	/**
	 * @param selectedCHid the selectedCHid to set
	 */
	public void setSelectedCHid(String selectedCHid) {
		this.selectedCHid = selectedCHid;
	}

	/**
	 * @return the selectedZHid
	 */
	public String getSelectedZHid() {
		return selectedZHid;
	}

	/**
	 * @param selectedZHid the selectedZHid to set
	 */
	public void setSelectedZHid(String selectedZHid) {
		this.selectedZHid = selectedZHid;
	}

	@Override
	public String toString() {
		return "SubStation [id=" + id + ", subName=" + subName + ", selectedP="
				+ selectedP + ", selectedC=" + selectedC + ", selectedZ="
				+ selectedZ + ", selectedCHid=" + selectedCHid
				+ ", selectedZHid=" + selectedZHid + ", firstLetter="
				+ firstLetter + ", hot=" + hot + ", stationCode=" + stationCode
				+ "]";
	}
	
}
