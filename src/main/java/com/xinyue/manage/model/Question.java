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
	
}
