package com.xinyue.manage.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 广告
 * @author wenhai.you
 * @2015年5月5日
 * @下午3:14:04
 */
public class Advertising implements Serializable {

	private String id;//序列号
	private String title;//广告标题
	private String url;//链接
	private String thumbnail;//缩略图
	private String specifications;//规格
	private String directory;//目录
	private String type;//广告分类
	private Timestamp createTime;//创建时间
	private int deleted;//删除标志  0 未删除  1删除
	private String createUser;//创建者
	private Timestamp updateTime;//修改时间
	
	private String updateUser;//修改者
	private Timestamp releaseTime;//发布时间
	//private UserInfo releaseUser;//发布者
	
	private Date endTime;//屏蔽时间
	private String state;//状态
	
	public Date getEndTime() {
		return endTime;
	}
	
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCreateUser() {
		return createUser;
	}


	public String getDirectory() {
		return directory;
	}

	public void setDirectory(String directory) {
		this.directory = directory;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}
	
	public int getDeleted() {
		return deleted;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	
	public Timestamp getReleaseTime() {
		return releaseTime;
	}
	
	public void setReleaseTime(Timestamp releaseTime) {
		this.releaseTime = releaseTime;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getThumbnail() {
		return thumbnail;
	}
	
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	
	public String getSpecifications() {
		return specifications;
	}
	
	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}

	@Override
	public String toString() {
		return "Advertising [id=" + id + ", title=" + title + ", url=" + url
				+ ", thumbnail=" + thumbnail + ", specifications=" + specifications + ", directory="
				+ directory + ", type=" + type + ", createTime=" + createTime
				+ ", deleted=" + deleted + ", createUser=" + createUser
				+ ", updateTime=" + updateTime + ", updateUser=" + updateUser
				+ ", releaseTime=" + releaseTime + ", endTime=" + endTime
				+ ", state=" + state + "]";
	}

	
}
