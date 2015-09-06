package com.xinyue.manage.model;
/**
 * 
 * @author wenhai.you
 * @2015年8月6日
 * @下午2:25:28
 */
public class Answer {

	private String acontent;
	private String createid;
	private int questid;
	private String type = "c";
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getQuestid() {
		return questid;
	}
	public void setQuestid(int questid) {
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
				+ ", questid=" + questid + "]";
	}
	
}
