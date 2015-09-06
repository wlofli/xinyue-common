package com.xinyue.manage.model;
/**
 * 
 * @author wenhai.you
 * @2015年8月6日
 * @下午2:00:13
 */
public class Question {

	private String id;
	private String title;
	private String content;
	private String createtime;
	private int answerNum;
	private String questType;
	private String answerContent;
	private String answerCreatetime;
	
	private String createid;
	private String cityid;//用于提交
	private String city;
	private String province;
	private String provinceid;//用于提交
	private String email;
	private String telphone;
	private String questionerType;
	private String orgid;
	
	public String getOrgid() {
		return orgid;
	}
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}
	public String getQuestionerType() {
		return questionerType;
	}
	public void setQuestionerType(String questionerType) {
		this.questionerType = questionerType;
	}
	public String getCreateid() {
		return createid;
	}
	public void setCreateid(String createid) {
		this.createid = createid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getCityid() {
		return cityid;
	}
	public void setCityid(String cityid) {
		this.cityid = cityid;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getProvinceid() {
		return provinceid;
	}
	public void setProvinceid(String provinceid) {
		this.provinceid = provinceid;
	}
	public String getAnswerCreatetime() {
		return answerCreatetime;
	}
	public void setAnswerCreatetime(String answerCreatetime) {
		this.answerCreatetime = answerCreatetime;
	}
	public String getAnswerContent() {
		return answerContent;
	}
	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public int getAnswerNum() {
		return answerNum;
	}
	public void setAnswerNum(int answerNum) {
		this.answerNum = answerNum;
	}
	public String getQuestType() {
		return questType;
	}
	public void setQuestType(String questType) {
		this.questType = questType;
	}
	@Override
	public String toString() {
		return "Question [id=" + id + ", title=" + title + ", content="
				+ content + ", createtime=" + createtime + ", answerNum="
				+ answerNum + ", questType=" + questType + ", answerContent="
				+ answerContent + ", answerCreatetime=" + answerCreatetime
				+ ", createid=" + createid + ", cityid=" + cityid + ", city="
				+ city + ", province=" + province + ", provinceid="
				+ provinceid + ", email=" + email + ", telphone=" + telphone
				+ ", questionerType=" + questionerType + ", orgid=" + orgid
				+ "]";
	}
	
}
