package com.xinyue.manage.beans;

import java.util.List;

import com.xinyue.manage.model.Organization;

/**
 * 用于机构编辑和添加 vo
 * @author wenhai.you
 * @2015年5月19日
 * @下午2:19:19
 */
public class OrgEditInfo {

	private List<Organization> orgedit;
	public List<Organization> getOrgedit() {
		return orgedit;
	}

	public void setOrgedit(List<Organization> orgedit) {
		this.orgedit = orgedit;
	}

	@Override
	public String toString() {
		return "OrgEditInfo [orgedit=" + orgedit + "]";
	}

	
}
