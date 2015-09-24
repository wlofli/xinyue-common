package com.xinyue.manage.beans;

import java.io.Serializable;

/**
 * 
 * @author wenhai.you
 * @2015年5月16日
 * @下午2:10:59
 */
public class OrganizationInfo implements Serializable {

	private String name;
	private int genre;
	private String linkman;
	private String telphone;
	private String topage;
	private String status;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTopage() {
		return topage;
	}
	public void setTopage(String topage) {
		this.topage = topage;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGenre() {
		return genre;
	}
	public void setGenre(int genre) {
		this.genre = genre;
	}
	public String getLinkman() {
		return linkman;
	}
	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	@Override
	public String toString() {
		return "OrganizationInfo [name=" + name + ", genre=" + genre
				+ ", linkman=" + linkman + ", telphone=" + telphone
				+ ", topage=" + topage + ", status=" + status + "]";
	}
	
}
