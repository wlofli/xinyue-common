package com.xinyue.manage.beans;

import java.io.Serializable;

/**
 * 
 * @author wenhai.you
 * @2015年9月30日
 * @上午9:57:30
 */
public class AnswerTypeBean implements Serializable {

	private String ftopage;
	private String stopage;
	
	public AnswerTypeBean() {
		super();
	}
	public String getFtopage() {
		return ftopage;
	}
	public void setFtopage(String ftopage) {
		this.ftopage = ftopage;
	}
	public String getStopage() {
		return stopage;
	}
	public void setStopage(String stopage) {
		this.stopage = stopage;
	}
	
}
