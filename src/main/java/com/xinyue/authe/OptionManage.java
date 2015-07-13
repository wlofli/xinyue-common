package com.xinyue.authe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.alibaba.druid.sql.dialect.oracle.ast.stmt.OracleIfStatement.Else;

import java.util.List;

class SortByMeunId implements Comparator {
	public int compare(Object o1, Object o2) {
		OptionInfo s1 = (OptionInfo) o1;
		OptionInfo s2 = (OptionInfo) o2;
		int m1 = s1.getMenuId();
		int m2 = s2.getMenuId();
		if (m1 > m2)
			return 1;
		else if (m1==m2)
			return 0;
		else
			return -1;
	}
}

public class OptionManage {
	private static Hashtable<String, OptionInfo> optionList = null;
	
	public static ArrayList<OptionInfo> getMenuList(){
		if (optionList==null)
			init();
		
		ArrayList<OptionInfo> reList = new ArrayList<OptionInfo>();
		Collection<OptionInfo> oplist = optionList.values();
		Iterator it = oplist.iterator(); // 获得一个迭代子  
		while(it.hasNext())   
		{  
			OptionInfo obj = (OptionInfo)it.next(); // 得到下一个元素  
			if (obj.isPage()&&!obj.isPublic())
				reList.add(obj);
		} 
        
		if (reList.size()>0){
			SortByMeunId sort = new SortByMeunId();
			Collections.sort(reList, sort);
		}
		
		return reList;
	}
	
	/**
	 * 设置允许和拒绝的用户或组
	 * @param optionId 权限id
	 * @param isAllow true：设置允许 false：设置拒绝
	 * @param isGroup true：设置 组权健  false：设置用户权限
	 * @param isAdd true:添加 false：删除
	 * @param id 组权限id或用户id
	 * @throws Exception
	 */
	public synchronized void SetAllowOrSetRefuse(String optionId,boolean isAllow, boolean isGroup,boolean isAdd, int id)throws Exception{
		if (optionId==null || optionId.equals(""))
			throw new Exception("optionId 为空");
		
		OptionInfo opInfo = optionList.get(optionId);
		
		if (opInfo == null){
			throw new Exception("获取权限对象为空");
		}
		
		opInfo.autheOpid(isAllow, isGroup, isAdd, id);
		opInfo.save();
	}
	
	
	public synchronized static void init(){
		if (optionList!=null)
			return;
		
		try{
			SqlSessionFactory sessionFactory =   AutheManage.getSqlSession();
			SqlSession session = sessionFactory.openSession();
			AutheMapper mapper = session.getMapper(AutheMapper.class);
			List<OptionInfo> opList = mapper.getOptionList();
			session.close();
			optionList = new Hashtable<String, OptionInfo>();
			for (int i =0 ;i<opList.size();i++){
				OptionInfo op = opList.get(i);
				optionList.put(op.getOptionId(), op);
			}
			MenuManage.init();
			

		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public static boolean isPublic(String optionId){
		if (optionList==null)
			init();
		
		if (optionId==null||optionId.equals("")){
			return false;
		}
		
		if(!optionList.containsKey(optionId))
		{
			return addOptionInfo(optionId,true,true);
		}
		
		OptionInfo opInfo = optionList.get(optionId);
		return opInfo.isPublic();
	}
	
	public static boolean chkAuthe(String optionId,boolean isPage,int uid,int[] gid,boolean isAdmin){
		if (optionList == null)
			init();
		
		if (optionId==null||optionId.equals("")){
			return false;
		}
		
		if(!optionList.containsKey(optionId))
		{
			return addOptionInfo(optionId,isPage,isAdmin);
		}
		
		OptionInfo opInfo = optionList.get(optionId);
		return opInfo.checkAuthe(uid, gid);
	}
	
	
	private synchronized static boolean addOptionInfo(String optionId,boolean isPage,boolean isAdmin){
		if (optionId==null || optionId.equals(""))
			return false;
		
		if (optionList.containsKey(optionId)){
			return true;
		}
		
		OptionInfo opInfo = new OptionInfo();
		opInfo.setOptionId(optionId);
		opInfo.setPage(isPage);
		optionList.put(optionId, opInfo);
		try{
			opInfo.add();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return isAdmin;
	}
	
	
}
