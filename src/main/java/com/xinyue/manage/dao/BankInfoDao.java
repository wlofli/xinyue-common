package com.xinyue.manage.dao;

import java.util.List;

import com.xinyue.manage.model.BankInfo;

/**
 * 
 * @author wenhai.you
 * @2015年5月23日
 * @下午1:49:57
 */
public interface BankInfoDao {

	/**
	 * 获取所有银行或机构
	 * @return
	 */
	public List<BankInfo> findAllList();
}
