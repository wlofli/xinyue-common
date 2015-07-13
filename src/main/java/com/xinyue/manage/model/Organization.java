package com.xinyue.manage.model;

import java.io.Serializable;

/**
 * 机构管理
 * @author wenhai.you
 * @2015年5月16日
 * @下午1:09:10
 */
public class Organization implements Serializable {
	
	private String id;//主键
	private String name;//机构名称
	private String genre;//机构类型
	private String number;//机构编号
	private String site;//联系地址
	private String postcode;//邮编
	private String linkman;//联系人
	private String sex;//性别
	private String position;//职位
	private String telphone;//手机
	private String fixed;//固定电话
	private String fax;//传值
	private String mail;//邮箱
	private int status;//是否启用 0 启用 默认为启用
	private int deleted;//删除标记 默认为0 0为未删除
	private String pinyin;//拼音
	
	public String getPinyin() {
		return pinyin;
	}
	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
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
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getLinkman() {
		return linkman;
	}
	public void setLinkman(String linkman) {
		this.linkman = linkman;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public Organization() {
		super();
	}
	public int getDeleted() {
		return deleted;
	}
	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}
	@Override
	public String toString() {
		return "Organization [id=" + id + ", name=" + name + ", genre=" + genre
				+ ", number=" + number + ", site=" + site + ", postcode="
				+ postcode + ", linkman=" + linkman + ", sex=" + sex
				+ ", position=" + position + ", telphone=" + telphone
				+ ", fixed=" + fixed + ", fax=" + fax + ", mail=" + mail
				+ ", status=" + status + ", deleted=" + deleted + ", pinyin="
				+ pinyin + "]";
	}
	
}
