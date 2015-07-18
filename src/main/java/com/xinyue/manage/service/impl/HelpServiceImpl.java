package com.xinyue.manage.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.xinyue.manage.beans.SelectInfo;
import com.xinyue.manage.dao.HelperDAO;
import com.xinyue.manage.model.HelpType;
import com.xinyue.manage.model.Helper;
import com.xinyue.manage.service.HelpService;

/**
 * 帮助中心
 * @author MK)茅
 *
 */
@Service
public class HelpServiceImpl implements HelpService {

	@Resource
	private HelperDAO helperDAO;
	
	Logger log = Logger.getLogger(HelpServiceImpl.class);
	
	@Override
	public List<Helper> getList(int index) {
		
		return helperDAO.getList(index);
	}

	@Override
	public int getCount() {
		
		return helperDAO.getCount();
	}

	@Override
	public boolean publishHelperByCode(String enCode, String user) {
		List<String> codeList = new ArrayList<String>();
		String[] arrCode = enCode.split("~");
		
		for (int i = 0; i < arrCode.length; i++) {
			codeList.add(arrCode[i]);
		}
		
		try {
			int ret = helperDAO.publishHelperByCode(codeList,user);
			
			if (ret > 0) {
				return true;
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean forbidHelperByCode(String enCode, String user) {
		List<String> codeList = new ArrayList<String>();
		String[] arrCode = enCode.split("~");
		
		for (int i = 0; i < arrCode.length; i++) {
			codeList.add(arrCode[i]);
		}
		
		try {
			int ret = helperDAO.forbidHelperByCode(codeList,user);
			
			if (ret > 0) {
				return true;
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean deleteHelperByCode(String enCode, String user) {
		List<String> codeList = new ArrayList<String>();
		String[] arrCode = enCode.split("~");
		
		for (int i = 0; i < arrCode.length; i++) {
			codeList.add(arrCode[i]);
		}
		
		try {
			int ret = helperDAO.deleteHelperByCode(codeList,user);
			
			if (ret > 0) {
				return true;
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return false;
	}

	@Override
	public Helper getHelperByCode(String code) {
		Helper helper = helperDAO.getHelperByCode(code);
		
		if (helper != null && !helper.getStatus().equals("2")) {
			helper.setStatus("1");
		}
		return helper;
	}

	@Override
	public boolean addHelper(Helper helper, String user) {
		HashMap<String, Object> map = new HashMap<>();
		
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
		
		int res = 0;
		try {
			map.clear();
			//参数整理
			String code = "he_"+df.format(new Date());
			
			map.put("code", code);
			map.put("name", helper.getName());
			map.put("author", helper.getAuthor());
			map.put("status", helper.getStatus());
			map.put("date", helper.getDate());
			map.put("text", helper.getContent());
			map.put("user", user);
			map.put("type", helper.getType());
			
			res = helperDAO.addHelperByCode(map);
		} catch (Exception e) {
			log.error(e.toString());
			return false;
		}
		if (res > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateHelper(Helper helper, String user) {
		
		HashMap<String, Object> map = new HashMap<>();
		
		int res = 0;
		try {
			map.clear();
			//参数整理
			map.put("code", helper.getCode());
			map.put("name", helper.getName());
			map.put("author", helper.getAuthor());
			map.put("status", helper.getStatus());
			map.put("date", helper.getDate());
			map.put("text", helper.getContent());
			map.put("user", user);
			map.put("type", helper.getType());
			
			res = helperDAO.updateHelperByCode(map);
		} catch (Exception e) {
			log.error(e.toString());
			return false;
		}
		if (res > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean addHelpType(HelpType helpType) {
		
		try {
			int res = helperDAO.addHelpType(helpType);
			
			if (res > 0) {
				return true;
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			return false;
		}
		
		return false;
	}

	@Override
	public List<SelectInfo> getTypes() {
		
		List<SelectInfo> types = null;
		try {
			types = helperDAO.getTypes();
		} catch (Exception e) {
			log.error(e.getMessage());
			types = null;
		}
		return types;
	}

}
