package com.xinyue.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xinyue.manage.beans.MemberInfo;
import com.xinyue.manage.model.Member;

/**
 * 
 * @author wenhai.you
 * @2015年6月9日
 * @下午3:18:45
 */
public interface MemberDao {

	public List<Member> findPageList(MemberInfo memberinfo);
	
	public int getCount(MemberInfo memberinfo);
	
	public void updateEnabled(@Param("list") List<String> id , @Param("modifyUser") String modifyUser);
	
	public void updateDisabled(@Param("list") List<String> id, @Param("modifyUser") String modifyUser);
	
	public void updateMember(Member member);
	
	public void addMember(Member member);
	
	public void delMember(@Param("list") List<String> id, @Param("modifyUser") String modifyUser);
	
	public Member editMember(String id);
	
	public List<Member> findXinYuePage(MemberInfo memberinfo);
	public int getXinYueCount(MemberInfo memberinfo);
	
	
	public List<Member> findQQPage(MemberInfo memberinfo);
	public int getQQCount(MemberInfo memberinfo);
	
	
	public List<Member> findWeixinPage(MemberInfo memberinfo);
	public int getWeixinCount(MemberInfo memberinfo);
	
	
	public List<Member> findWeiboPage(MemberInfo memberinfo);
	public int getWeiboCount(MemberInfo memberinfo);
	
	
	public List<Member> findSuiwuPage(MemberInfo memberinfo);
	public int getSuiwuCount(MemberInfo memberinfo);
	
	
	public List<Member> findDisuiPage(MemberInfo memberinfo);
	public int getDisuiCount(MemberInfo memberinfo);
	
	
	public List<Member> findGuoPage(MemberInfo memberinfo);
	public int getGuoCount(MemberInfo memberinfo);
}
