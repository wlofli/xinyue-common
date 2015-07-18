package com.xinyue.manage.service;

import java.util.List;

import com.xinyue.manage.beans.SelectInfo;
import com.xinyue.manage.model.HelpType;
import com.xinyue.manage.model.Helper;

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
	
}
