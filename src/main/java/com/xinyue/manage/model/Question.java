package com.xinyue.manage.model;
/**
 * 
 * @author wenhai.you
 * @2015年8月6日
 * @下午2:00:13
 */
public class Question {

	private String id;//标识符
	private String title;//标题
	private String content;//内容
	private String scontent;//修改之后的内容保存的地方
	private String createtime;//创建时间
	private int answerNum;//回答数量
	private String questType;//问题分类 
	private String answerContent;//回答内容
	private String answerCreatetime;//回答时间
	
	private String createid;
	private String createName;//提问者
	private String type;//大分类
	private String cityid;//用于提交
	private String city;
	private String province;
	private String provinceid;//用于提交
	private String address;//信贷经理 客户问答 地区
	private String status;//信贷经理 客户问答
	private String statusName;//状态名称 如 未通过 审核通过  待审核 
	private String creditName;//推荐回答者
	private String creditTel;//推荐回答的手机号码
	private String email;
	private String telphone;//提问者的手机号码
	private String questionerType;//发布者类型
	private String orgid;
	private String keyword;//关键字
	private String publish = "0";
	private String userName;//用户名
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getScontent() {
		return scontent;
	}
	public void setScontent(String scontent) {
		this.scontent = scontent;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPublish() {
		return publish;
	}
	public void setPublish(String publish) {
		this.publish = publish;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getCreateName() {
		return createName;
	}
	public void setCreateName(String createName) {
		this.createName = createName;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public String getCreditName() {
		return creditName;
	}
	public void setCreditName(String creditName) {
		this.creditName = creditName;
	}
	public String getCreditTel() {
		return creditTel;
	}
	public void setCreditTel(String creditTel) {
		this.creditTel = creditTel;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
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
				+ content + ", scontent=" + scontent + ", createtime="
				+ createtime + ", answerNum=" + answerNum + ", questType="
				+ questType + ", answerContent=" + answerContent
				+ ", answerCreatetime=" + answerCreatetime + ", createid="
				+ createid + ", createName=" + createName + ", cityid="
				+ cityid + ", city=" + city + ", province=" + province
				+ ", provinceid=" + provinceid + ", address=" + address
				+ ", status=" + status + ", statusName=" + statusName
				+ ", creditName=" + creditName + ", creditTel=" + creditTel
				+ ", email=" + email + ", telphone=" + telphone
				+ ", questionerType=" + questionerType + ", orgid=" + orgid
				+ ", keyword=" + keyword + ", publish=" + publish
				+ ", userName=" + userName + "]";
	}
	
}
