package com.xinyue.manage.beans;

import java.io.Serializable;

/**
 * 
 * @author wenhai.you
 * @2015年8月11日
 * @下午5:19:03
 */
public class ShowAnswer implements Serializable {

	private String id;
	private String title;
	private String content;
	private String qtype;
	private String address;
	private String qtime;
	private String acontent;
	private String atime;
	private String anum;
	private String mcreateName;
	private String ccreateName;
	private String oname;
	private String atype;
	
	
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
