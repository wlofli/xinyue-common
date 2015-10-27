package com.xinyue.manage.beans;

import java.io.Serializable;

/**
 * 
 * @author wenhai.you
 * @2015年8月5日
 * @上午11:19:45
 */
public class QuestionBean implements Serializable {

	private int verify;//待审核
	private int fail;//审核失败
	private int pass;//审核通过
	private int total;//某个下的总记录数
	private int rate;//审核通过率
	private int today;//今日回答
	private int yesterday;//昨日回答
	private int rank;//今日排名
	
	//店铺查询条件
	private String timefrom;
	private String timeto;
	private String answerstatus;
	private String title;
	private String orgid;
	//店铺详情 
	private String questid;
	//分页条件
	private String topage;
	
	//回答列表的查询条件
	private String option;
	private String name;
	private String answerName;//提问者
	private String answerTime;//提问时间
	private String questType;//分类
	private String status;//审核状态
	private String memberid;
	
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAnswerName() {
		return answerName;
	}
	public void setAnswerName(String answerName) {
		this.answerName = answerName;
	}
	public String getAnswerTime() {
		return answerTime;
	}
	public void setAnswerTime(String answerTime) {
		this.answerTime = answerTime;
	}
	public String getQuestType() {
		return questType;
	}
	public void setQuestType(String questType) {
		this.questType = questType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOrgid() {
		return orgid;
	}
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}
	public String getQuestid() {
		return questid;
	}
	public void setQuestid(String questid) {
		this.questid = questid;
	}
	public String getTopage() {
		return topage;
	}
	public void setTopage(String topage) {
		this.topage = topage;
	}
	public String getTimefrom() {
		return timefrom;
	}
	public void setTimefrom(String timefrom) {
		this.timefrom = timefrom;
	}
	public String getTimeto() {
		return timeto;
	}
	public void setTimeto(String timeto) {
		this.timeto = timeto;
	}
	public String getAnswerstatus() {
		return answerstatus;
	}
	public void setAnswerstatus(String answerstatus) {
		this.answerstatus = answerstatus;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getVerify() {
		return verify;
	}
	public void setVerify(int verify) {
		this.verify = verify;
	}
	public int getFail() {
		return fail;
	}
	public void setFail(int fail) {
		this.fail = fail;
	}
	public int getPass() {
		return pass;
	}
	public void setPass(int pass) {
		this.pass = pass;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public int getToday() {
		return today;
	}
	public void setToday(int today) {
		this.today = today;
	}
	public int getYesterday() {
		return yesterday;
	}
	public void setYesterday(int yesterday) {
		this.yesterday = yesterday;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "QuestionBean [verify=" + verify + ", fail=" + fail + ", pass="
				+ pass + ", total=" + total + ", rate=" + rate + ", today="
				+ today + ", yesterday=" + yesterday + ", rank=" + rank
				+ ", timefrom=" + timefrom + ", timeto=" + timeto
				+ ", answerstatus=" + answerstatus + ", title=" + title
				+ ", orgid=" + orgid + ", questid=" + questid + ", topage="
				+ topage + ", option=" + option + ", name=" + name
				+ ", answerName=" + answerName + ", answerTime=" + answerTime
				+ ", questType=" + questType + ", status=" + status
				+ ", memberid=" + memberid + "]";
	}
		
}
