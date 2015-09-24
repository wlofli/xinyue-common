package com.xinyue.manage.model;

import java.io.Serializable;

/**
 * 机构联系人信息
 * @author wenhai.you
 * @2015年9月9日
 * @上午9:50:52
 */
public class LinkMan implements Serializable {

	private int id;//
	private String name;
	private String sex;//性别key
	private String sexName;//性别内容
	private String position;
	private String telphone;
	private String fixed;//固话
	private String fax;//传真
	private String mail;//邮箱
	private String orgid;
	
	public String getOrgid() {
		return orgid;
	}
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}
	public String getSexName() {
		return sexName;
	}
	public void setSexName(String sexName) {
		this.sexName = sexName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getFixed() {
		return fixed;
	}
	public void setFixed(String fixed) {
		this.fixed = fixed;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	@Override
	public String toString() {
		return "LinkMan [id=" + id + ", name=" + name + ", sex=" + sex
				+ ", position=" + position + ", telphone=" + telphone
				+ ", fixed=" + fixed + ", fax=" + fax + ", mail=" + mail + "]";
	}
	
}
