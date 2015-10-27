package com.xinyue.manage.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.xinyue.manage.beans.CheckboxInfo;
import com.xinyue.manage.beans.SelectInfo;
import com.xinyue.manage.dao.NewSubstationDAO;
import com.xinyue.manage.service.NewSubstationService;
/**
 * 
 * @author lzc
 * @date 2015年6月26日上午10:56:55
 */
@Service
public class NewSubstationServiceImpl implements NewSubstationService{

	@Resource
	private NewSubstationDAO newSubstationDAO;
	
	Logger log = Logger.getLogger(getClass());
	@Override
	public boolean addNewSubstation(List<String> substationList, String value) {
		// TODO Auto-generated method stub
		try {
			newSubstationDAO.addNewSubstation(substationList,value);
		} catch (Exception e) {
			// TODO: handle exception
			log.info(e.toString());
			throw new RuntimeException();
		}
		return true;
	}
	@Override
	public boolean updateNewSubstation(List<String> substationList, String value) {
		// TODO Auto-generated method stub
		if(substationList == null ) return false;
		try {
			newSubstationDAO.deleteNewSubstation(value);
			newSubstationDAO.addNewSubstation(substationList,value);
		} catch (Exception e) {
			// TODO: handle exception
			log.info(e.toString());
			throw new RuntimeException();
		}
		return true;
	}
	
	
	@Override
	public List<String> getSubstationList(String id) {
		// TODO Auto-generated method stub
		return newSubstationDAO.getNewSubstationList(id);
	}
	@Override
	public List<CheckboxInfo> getCheckBoxEmptyList(List<SelectInfo> all) {
		// TODO Auto-generated method stub
		List<CheckboxInfo> list = new ArrayList<CheckboxInfo>();
		for(SelectInfo i : all){
			CheckboxInfo checkboxInfo = new CheckboxInfo();
			checkboxInfo.setKey(i.getKey());
			checkboxInfo.setValue(i.getValue());
			checkboxInfo.setChecked(false);
			list.add(checkboxInfo);
		}
		return list;
	}
	@Override
	public List<String> getNewSubstationListName(String id) {
		// TODO Auto-generated method stub
		return newSubstationDAO.getNewSubstationListName(id);
	}
	@Override
	public List<CheckboxInfo> getCheckBoxListByName(List<SelectInfo> all,
			List<String> part) {
		// TODO Auto-generated method stub
		List<CheckboxInfo> list = new ArrayList<CheckboxInfo>();
		for(SelectInfo i : all){
			boolean x = false;
			for(String j : part){
				if(i.getValue().equals(j)){
					CheckboxInfo checkboxInfo = new CheckboxInfo();
					checkboxInfo.setKey(i.getKey());
					checkboxInfo.setValue(i.getValue());
					checkboxInfo.setChecked(true);
					list.add(checkboxInfo);
					x = true;
					break;
				}
			}
			if(x == false){
				CheckboxInfo checkboxInfo = new CheckboxInfo();
				checkboxInfo.setKey(i.getKey());
				checkboxInfo.setValue(i.getValue());
				checkboxInfo.setChecked(false);
				list.add(checkboxInfo);
			}
		}
		return list;
	}
	
	@Override
	public List<CheckboxInfo> getCheckBoxListById(List<SelectInfo> all,
			List<String> part) {
		// TODO Auto-generated method stub
		List<CheckboxInfo> list = new ArrayList<CheckboxInfo>();
		for(SelectInfo i : all){
			boolean x = false;
			for(String j : part){
				if(i.getKey().equals(j)){
					CheckboxInfo checkboxInfo = new CheckboxInfo();
					checkboxInfo.setKey(i.getKey());
					checkboxInfo.setValue(i.getValue());
					checkboxInfo.setChecked(true);
					list.add(checkboxInfo);
					x = true;
					break;
				}
			}
			if(x == false){
				CheckboxInfo checkboxInfo = new CheckboxInfo();
				checkboxInfo.setKey(i.getKey());
				checkboxInfo.setValue(i.getValue());
				checkboxInfo.setChecked(false);
				list.add(checkboxInfo);
			}
		}
		return list;
	}

}
