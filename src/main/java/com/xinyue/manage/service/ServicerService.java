package com.xinyue.manage.service;

import com.xinyue.manage.model.Servicer;

/**
 * author lzc
 */
public interface ServicerService {
	
	/**根据主键获取客服
	 * add by lzc     date: 2015年9月7日
	 * @param id
	 * @return
	 */
	public Servicer getServicerById(String id);

}
