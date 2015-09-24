package com.xinyue.manage.beans;

/**
 * 信贷经理详情-资金账户检索
 * @author MK)茅
 * @version v1.0
 * @date 创建时间：2015年9月7日
 */
public class SearchMoneyAccount {

	//开始日期
	private String timestart = "";
	
	//结束日期
	private String timeEnd = "";
	
	//选择类型-0:账户详情;1:消费记录;2:充值记录;3:奖励记录;4:提现记录
	private int selectType = 0;
	
	//页
	private int page = 1;
	
	private int index = 0;
	
	private String managerId = "";

	/**
	 * @return the timestart
	 */
	public String getTimestart() {
		return timestart;
	}

	/**
	 * @param timestart the timestart to set
	 */
	public void setTimestart(String timestart) {
		this.timestart = timestart;
	}

	/**
	 * @return the timeEnd
	 */
	public String getTimeEnd() {
		return timeEnd;
	}

	/**
	 * @param timeEnd the timeEnd to set
	 */
	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}

	/**
	 * @return the page
	 */
	public int getPage() {
		return page;
	}

	/**
	 * @param page the page to set
	 */
	public void setPage(int page) {
		this.page = page;
		this.index = page -1;
	}

	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * @return the selectType
	 */
	public int getSelectType() {
		return selectType;
	}

	/**
	 * @param selectType the selectType to set
	 */
	public void setSelectType(int selectType) {
		this.selectType = selectType;
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
