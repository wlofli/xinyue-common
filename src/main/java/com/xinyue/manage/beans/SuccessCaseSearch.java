package com.xinyue.manage.beans;

/**
 * 成功案例检索条件
 * @author MK)茅
 * @version v1.0
 * @date 创建时间：2015年8月18日
 */
public class SuccessCaseSearch {

	private String managerId = "";
	
	private String productName ="";
	
	private String amountStart ="";
	
	private String amountEnd ="";
	
	private String dateStart ="";
	
	private String dateEnd ="";
	
	private int index = 0;

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the amountStart
	 */
	public String getAmountStart() {
		return amountStart;
	}

	/**
	 * @param amountStart the amountStart to set
	 */
	public void setAmountStart(String amountStart) {
		this.amountStart = amountStart;
	}

	/**
	 * @return the amountEnd
	 */
	public String getAmountEnd() {
		return amountEnd;
	}

	/**
	 * @param amountEnd the amountEnd to set
	 */
	public void setAmountEnd(String amountEnd) {
		this.amountEnd = amountEnd;
	}

	/**
	 * @return the dateStart
	 */
	public String getDateStart() {
		return dateStart;
	}

	/**
	 * @param dateStart the dateStart to set
	 */
	public void setDateStart(String dateStart) {
		this.dateStart = dateStart;
	}

	/**
	 * @return the dateEnd
	 */
	public String getDateEnd() {
		return dateEnd;
	}

	/**
	 * @param dateEnd the dateEnd to set
	 */
	public void setDateEnd(String dateEnd) {
		this.dateEnd = dateEnd;
	}

	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * @param index the index to set
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * @return the managerId
	 */
	public String getManagerId() {
		return managerId;
	}

	/**
	 * @param managerId the managerId to set
	 */
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	
}
