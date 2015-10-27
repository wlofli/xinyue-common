package com.xinyue.manage.model;
/**
 * 回答信息
 * @author wenhai.you
 * @2015年8月6日
 * @下午2:25:28
 */
public class AnswerType {

	private String id;
	private String name;
	private String parentid;
	private String status;
	private String deleted;
	
	public AnswerType() {
		super();
	}
	public AnswerType(String parentid) {
		super();
		this.parentid = parentid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParentid() {
		return parentid;
	}
	public void setParentid(String parentid) {
		this.parentid = parentid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDeleted() {
		return deleted;
	}
	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}
	
}
