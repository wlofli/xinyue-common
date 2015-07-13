package com.xinyue.authe;

/**
 * 附加用户信息
 * @author goto
 *
 */
public class UserExtendInfo {
	
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
	}
	/**
	 * userinfo id
	 */
	private int uid;
	/**
	 * 职位
	 */
	private String position;
	/**
	 * m
	 */
	private int organizationId;
}
