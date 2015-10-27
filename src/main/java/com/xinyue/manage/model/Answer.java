package com.xinyue.manage.model;
/**
 * 回答信息
 * @author wenhai.you
 * @2015年8月6日
 * @下午2:25:28
 */
public class Answer {

	private String acontent;//内容
	private String createid;//当前登录者 若匿名则为0
	private String questid;//被回答id
	private String type = "c";//回答是谁c 为信贷经理
	
	//admin 用于回答
	private String provinceid;
	private String cityid;
	private String orgid;
	
	public String getOrgid() {
		return orgid;
	}
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}
	public String getProvinceid() {
		return provinceid;
	}
	public void setProvinceid(String provinceid) {
		this.provinceid = provinceid;
	}
	public String getCityid() {
		return cityid;
	}
	public void setCityid(String cityid) {
		this.cityid = cityid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getQuestid() {
		return questid;
	}
	public void setQuestid(String questid) {
		this.questid = questid;
	}
	public String getAcontent() {
		return acontent;
	}
	public void setAcontent(String acontent) {
		this.acontent = acontent;
	}
	public String getCreateid() {
		return createid;
	}
	public void setCreateid(String createid) {
		this.createid = createid;
	}
	public Answer(String createid) {
		super();
		this.createid = createid;
	}
	public Answer() {
		super();
	}
	@Override
	public String toString() {
		return "Answer [acontent=" + acontent + ", createid=" + createid
				+ ", questid=" + questid + ", type=" + type + ", provinceid="
				+ provinceid + ", cityid=" + cityid + "]";
	}
	
}
