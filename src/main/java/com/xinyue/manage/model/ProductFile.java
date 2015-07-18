package com.xinyue.manage.model;

import java.io.Serializable;
import java.sql.Date;

/**
 * 产品申请资料  对应数据表m_product_file_type
 * @author wenhai.you
 * @2015年5月22日
 * @下午4:59:36
 */
public class ProductFile implements Serializable {

	private String id;//
	private String fileName;//文件名
	private String fileType;//文件类型
	private Date createdTime;//创建时间
	private String parentid;//对应产品的类
	private Date modifiedTime;//修改时间
	private String createUser;//创建者
	private String modifyUser;//修改者
	
	public String getParentid() {
		return parentid;
	}
	public void setParentid(String parentid) {
		this.parentid = parentid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public String getModifyUser() {
		return modifyUser;
	}
	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser;
	}
	@Override
	public String toString() {
		return "ProductFile [id=" + id + ", fileName=" + fileName
				+ ", fileType=" + fileType + ", createdTime=" + createdTime
				+ ", modifiedTime=" + modifiedTime + ", createUser="
				+ createUser + ", modifyUser=" + modifyUser + "]";
	}
	
}
