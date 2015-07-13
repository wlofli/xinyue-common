package com.xinyue.authe;


public class MenuItem {
	

	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	
	public void setMenu(boolean isMenu){
		this.isMenu = isMenu;
	}
	
	public boolean getMenu(){
		return isMenu;
	}
	
	public void setUrl(String url){
		this.url = url;
	}
	
	public String getUrl(){
		return url;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getExtend() {
		return extentText;
	}
	public void setExtend(String extend) {
		this.extentText = extend;
	}


	/**
	 * true:菜单目录 false:菜单操作
	 */
	private boolean isMenu = true;
	/**
	 * 页面地址
	 */
	private String url;

	/**
	 * 菜单id
	 */
	private int id;
	/*
	 * 菜单文字
	 */
	private String text;
	/**
	 * 父菜单id
	 */
	private int parentId = 0;
	/**
	 * 扩展属性
	 */
	private String extentText;

}
