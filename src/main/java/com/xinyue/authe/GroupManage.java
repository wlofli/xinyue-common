package com.xinyue.authe;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class GroupManage {
	public static boolean addGroup(String name,String remark)throws Exception{
		if (name == null || name.equals("")){
			throw new Exception("组名称不能为空");
		}
		
		if (remark == null)
			remark = "";
		
		SqlSessionFactory sessionFactory =   AutheManage.getSqlSession();
		SqlSession session = sessionFactory.openSession();
		AutheMapper mapper = session.getMapper(AutheMapper.class);
		int re = mapper.addGroup(name, remark);
		session.close();
		return re>0;
	}
}
