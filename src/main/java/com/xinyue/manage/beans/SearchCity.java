package com.xinyue.manage.beans;

/**
 * 城市分站搜索
 * @author MK)茅
 *
 */
public class SearchCity {

	private String searchName;
	
	private String searchLetter;
	
	private String searchProvince;
	
	private String searchCity;
	
	private String searchZone;
	
	private String searchCityHid;
	
	private String searchZoneHid;
	
	private int searchPage;
	
	private int start;
	
	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	/**
	 * @return the searchName
	 */
	public String getSearchName() {
		return searchName;
	}

	/**
	 * @param searchName the searchName to set
	 */
	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	/**
	 * @return the searchLetter
	 */
	public String getSearchLetter() {
		return searchLetter;
	}

	/**
	 * @param searchLetter the searchLetter to set
	 */
	public void setSearchLetter(String searchLetter) {
		this.searchLetter = searchLetter;
	}

	/**
	 * @return the searchProvince
	 */
	public String getSearchProvince() {
		return searchProvince;
	}

	/**
	 * @param searchProvince the searchProvince to set
	 */
	public void setSearchProvince(String searchProvince) {
		this.searchProvince = searchProvince;
	}

	/**
	 * @return the searchCity
	 */
	public String getSearchCity() {
		return searchCity;
	}

	/**
	 * @param searchCity the searchCity to set
	 */
	public void setSearchCity(String searchCity) {
		this.searchCity = searchCity;
	}

	/**
	 * @return the searchZone
	 */
	public String getSearchZone() {
		return searchZone;
	}

	/**
	 * @param searchZone the searchZone to set
	 */
	public void setSearchZone(String searchZone) {
		this.searchZone = searchZone;
	}

	/**
	 * @return the searchCityHid
	 */
	public String getSearchCityHid() {
		return searchCityHid;
	}

	/**
	 * @param searchCityHid the searchCityHid to set
	 */
	public void setSearchCityHid(String searchCityHid) {
		this.searchCityHid = searchCityHid;
	}

	/**
	 * @return the searchZoneHid
	 */
	public String getSearchZoneHid() {
		return searchZoneHid;
	}

	/**
	 * @param searchZoneHid the searchZoneHid to set
	 */
	public void setSearchZoneHid(String searchZoneHid) {
		this.searchZoneHid = searchZoneHid;
	}

	/**
	 * @return the searchPage
	 */
	public int getSearchPage() {
		return searchPage;
	}

	/**
	 * @param searchPage the searchPage to set
	 */
	public void setSearchPage(int searchPage) {
		this.searchPage = searchPage;
	}

}
