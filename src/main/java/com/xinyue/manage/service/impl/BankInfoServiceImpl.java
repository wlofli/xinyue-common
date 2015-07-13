package com.xinyue.manage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xinyue.manage.dao.BankInfoDao;
import com.xinyue.manage.model.BankInfo;
import com.xinyue.manage.service.BankInfoService;

/**
 * 
 * @author wenhai.you
 * @2015年5月23日
 * @下午2:09:34
 */
@Service("bankInfoService")
public class BankInfoServiceImpl implements BankInfoService {

	@Autowired
	private BankInfoDao bdao;
	@Override
	public List<BankInfo> findAllList() {
		// TODO Auto-generated method stub
		return bdao.findAllList();
	}

}
