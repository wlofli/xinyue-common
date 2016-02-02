package com.xinyue.manage.service;

import java.util.List;

import com.xinyue.manage.beans.PageData;
import com.xinyue.manage.beans.SelectInfo;
import com.xinyue.manage.model.HelpType;
import com.xinyue.manage.model.Helper;

/**
 * 帮助中心服务层
 * @author MK)茅
 * @version v1.0
 * @date 创建时间：2015年7月1日
 */
public interface HelpService {

	List<Helper> getList(int index);

	int getCount();

	boolean publishHelperByCode(String enCode, String user);

	boolean forbidHelperByCode(String enCode, String user);

	boolean deleteHelperByCode(String enCode, String user);

	Helper getHelperByCode(String code);

	boolean addHelper(Helper helper, String user);

	boolean updateHelper(Helper helper, String user);

	boolean addHelpType(HelpType helpType);

	List<SelectInfo> getTypes();

	/**
	 * 根据序号取得所有帮助中心内容
	 * @return
	 */
	List<Helper> getAllListByIndex();
	
	
	//2015-11-19  start ywh
	public PageData<HelpType> findHelpType(String topage);
	
	public boolean updateHelpTypePublish(List<String> list , String user);
	
	public boolean delHelpType(List<String> list , String user);
	
	public HelpType findHelpTypeById(String id);
	// ywh over
}
