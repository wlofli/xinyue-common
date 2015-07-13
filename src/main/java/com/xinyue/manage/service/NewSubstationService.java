package com.xinyue.manage.service;

import java.util.List;

import com.xinyue.manage.beans.CheckboxInfo;
import com.xinyue.manage.beans.SelectInfo;
/**
 * 
 * @author lzc
 * @date 2015年6月26日上午10:56:37
 */
public interface NewSubstationService {
	/**
	 * 
	 * add by lzc
	 * date: 2015年6月27日
	 * @param substationList ->substationid 
	 * @param value -> new id
	 * @return
	 */
	public boolean addNewSubstation(List<String> substationList, String value);
	
	public boolean updateNewSubstation(List<String> substationList, String value);
	
	/**
	 * 
	 * @param all 所有的选项
	 * @param part 部分选中的选项 String类型里存的是substation的id
	 * @return 返回一个 所有选项的checkbox,将part部分选中,其余部分不选中
	 */
	public List<CheckboxInfo> getCheckBoxListById(List<SelectInfo> all, List<String> part);
	
	
	/**
	 * 
	 * add by lzc
	 * date: 2015年6月12日
	 * @param all 所有的选项
	 * @param part 部分选中的选项 String类型里存的是substation的name
	 * @return 返回一个 所有选项的checkbox,将part部分选中,其余部分不选中
	 */
	public List<CheckboxInfo> getCheckBoxListByName(List<SelectInfo> all, List<String> part);
	
	public List<String> getSubstationList(String id);
	//根据新闻id获取对应的substationlist的id对应的城市名称
	public List<String> getNewSubstationListName(String id);
	
	
	public List<CheckboxInfo> getCheckBoxEmptyList(List<SelectInfo> all);

}
