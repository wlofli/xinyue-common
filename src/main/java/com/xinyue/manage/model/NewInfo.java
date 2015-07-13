package com.xinyue.manage.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
/**
 * 
 * @author lzc
 * @date 2015年6月26日上午10:56:08
 */
public class NewInfo implements Serializable{
	
	
	private static final long serialVersionUID = -1242719513788445310L;
	private String id;
	private String title;
	@DateTimeFormat(pattern = "yyyy-MM-dd" )
	private Date sendDate;
	private int top;
	private int status;
	private String imageUrl;
	private String type;
	private String newType;//newType id
	private String author;
	private String compositionSource;
	private String sourceUrl;
	private String fileName;
	private String fileDir;
	private String newMainContent;
	private String newContent;
	private int deleted;
	private Date createdTime;
	private String createdId;
	private Date modifiedTime;
	private String modifiedId;
	private String showTitle;
	private String newsKeywords;
	private String newsDescription;
	private String contentTemp;
	private String publish;
	private List<String> substationList;
	
	public String getPublish() {
		return publish;
	}
	public void setPublish(String publish) {
		this.publish = publish;
	}
	
	public List<String> getSubstationList() {
		return substationList;
	}
	public void setSubstationList(List<String> substationList) {
		this.substationList = substationList;
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
	public Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	public int getTop() {
		return top;
	}
	public void setTop(int top) {
		this.top = top;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNewType() {
		return newType;
	}
	public void setNewType(String newType) {
		this.newType = newType;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCompositionSource() {
		return compositionSource;
	}
	public void setCompositionSource(String compositionSource) {
		this.compositionSource = compositionSource;
	}
	public String getSourceUrl() {
		return sourceUrl;
	}
	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileDir() {
		return fileDir;
	}
	public void setFileDir(String fileDir) {
		this.fileDir = fileDir;
	}
	public String getNewMainContent() {
		return newMainContent;
	}
	public void setNewMainContent(String newMainContent) {
		this.newMainContent = newMainContent;
	}
	public String getNewContent() {
		return newContent;
	}
	public void setNewContent(String newContent) {
		this.newContent = newContent;
	}
	public int getDeleted() {
		return deleted;
	}
	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public String getCreatedId() {
		return createdId;
	}
	public void setCreatedId(String createdId) {
		this.createdId = createdId;
	}
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public String getModifiedId() {
		return modifiedId;
	}
	public void setModifiedId(String modifiedId) {
		this.modifiedId = modifiedId;
	}
	public String getShowTitle() {
		return showTitle;
	}
	public void setShowTitle(String showTitle) {
		this.showTitle = showTitle;
	}
	public String getNewsKeywords() {
		return newsKeywords;
	}
	public void setNewsKeywords(String newsKeywords) {
		this.newsKeywords = newsKeywords;
	}
	public String getNewsDescription() {
		return newsDescription;
	}
	public void setNewsDescription(String newsDescription) {
		this.newsDescription = newsDescription;
	}
	public String getContentTemp() {
		return contentTemp;
	}
	public void setContentTemp(String contentTemp) {
		this.contentTemp = contentTemp;
	}
	
	

}
