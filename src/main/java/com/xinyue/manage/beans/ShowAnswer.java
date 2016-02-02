package com.xinyue.manage.beans;

import java.io.Serializable;

/**
 * 
 * @author wenhai.you
 * @2015年8月11日
 * @下午5:19:03
 */
public class ShowAnswer implements Serializable {

	private String id;//提出问题id
	private String title;//提出问题
	private String content;//提出问题内容
	private String qtype;//提出问题类型 普通会员 匿名者  管理员
	private String mqcreateName;//提出问题 普通会员名 匿名 管理员若为null则为匿名
	private String gcreateName;//提出问题为管理员
	private String qcid;//创建者id 0为匿名
	private String questTypeName;//问题分类 
	private String address;//所属地区
	private String qtime;//发布时间
	private String acontent;//回答内容
	private String atime;//回答时间
	private String anum;//
	private String mcreateName;//普通会员名
	private String ccreateName;//信贷经理名
	private String answerName;//回答者
	private String oname;//机构名
	private String atype;//回答者类型
	private String recommend;//推荐回答
	//后台添加属性
	private String telphone;
	private String questTypeid;
	private String status;//提问
	private String astatus;//回答
	
	public String getAnswerName() {
		return answerName;
	}
	public void setAnswerName(String answerName) {
		this.answerName = answerName;
	}
	public String getAstatus() {
		return astatus;
	}
	public void setAstatus(String astatus) {
		this.astatus = astatus;
	}
	private String aid;//回答id
	
	public String getRecommend() {
		return recommend;
	}
	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}
	public String getGcreateName() {
		return gcreateName;
	}
	public void setGcreateName(String gcreateName) {
		this.gcreateName = gcreateName;
	}
	public String getQcid() {
		return qcid;
	}
	public void setQcid(String qcid) {
		this.qcid = qcid;
	}
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getQuestTypeid() {
		return questTypeid;
	}
	public void setQuestTypeid(String questTypeid) {
		this.questTypeid = questTypeid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getQuestTypeName() {
		return questTypeName;
	}
	public void setQuestTypeName(String questTypeName) {
		this.questTypeName = questTypeName;
	}
	public String getMqcreateName() {
		return mqcreateName;
	}
	public void setMqcreateName(String mqcreateName) {
		this.mqcreateName = mqcreateName;
	}
	private String typeid;
	private String name;//提问者
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTypeid() {
		return typeid;
	}
	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}
	public String getOname() {
		return oname;
	}
	public void setOname(String oname) {
		this.oname = oname;
	}
	public String getAnum() {
		return anum;
	}
	public void setAnum(String anum) {
		this.anum = anum;
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
	public String getQtype() {
		return qtype;
	}
	public void setQtype(String qtype) {
		this.qtype = qtype;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getQtime() {
		return qtime;
	}
	public void setQtime(String qtime) {
		this.qtime = qtime;
	}
	public String getAcontent() {
		return acontent;
	}
	public void setAcontent(String acontent) {
		this.acontent = acontent;
	}
	public String getAtime() {
		return atime;
	}
	public void setAtime(String atime) {
		this.atime = atime;
	}
	public String getMcreateName() {
		return mcreateName;
	}
	public void setMcreateName(String mcreateName) {
		this.mcreateName = mcreateName;
	}
	public String getCcreateName() {
		return ccreateName;
	}
	public void setCcreateName(String ccreateName) {
		this.ccreateName = ccreateName;
	}
	public String getAtype() {
		return atype;
	}
	public void setAtype(String atype) {
		this.atype = atype;
	}
}
