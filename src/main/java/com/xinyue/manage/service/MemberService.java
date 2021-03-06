package com.xinyue.manage.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.xinyue.manage.beans.MemberInfo;
import com.xinyue.manage.model.Member;

/**
 * 
 * @author wenhai.you
 * @2015年6月9日
 * @下午4:27:16
 */
public interface MemberService {

	public List<Member> findPageList(MemberInfo memberinfo);
	
	
	public int getCount(MemberInfo memberinfo);
	
	
	public boolean updateEnabled(List<String> id , String modifyUser);
	
	
	public boolean updateDisabled(List<String> id, String modifyUser);
	
	public boolean saveMember(Member memberedit, String modifyUser);
	
	public boolean delMember(List<String> id, String modifyUser);
	
	
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
	
	
	public void exprot(HttpServletResponse response, List<Member> list)throws Exception;
	
	public void exprotMember(HttpServletResponse response, String type);
	public static final String MEMBER_EXCEL_NAME = "member_info.xls";
	public static final String MEMBER_SHEET_NAME = "会员名称";
	public static final String MEMBER_TITLE_1 = "序号";
	public static final String MEMBER_TITLE_2 = "会员名";
	public static final String MEMBER_TITLE_3 = "会员类型";
	public static final String MEMBER_TITLE_4 = "企业名称";
	public static final String MEMBER_TITLE_5 = "所属地区";
	public static final String MEMBER_TITLE_6 = "合作账户名";
	public static final String MEMBER_TITLE_7 = "联系人";
	public static final String MEMBER_TITLE_8 = "手机号";
	public static final String MEMBER_TITLE_9 = "邮件地址";
	public static final String MEMBER_TITLE_10 = "贷款订单数";
	public static final String MEMBER_TITLE_11 = "注册日期";
	public static final String MEMBER_TITLE_12 = "最近登录时间";
	
	//2015/08/07 茅 追加 START
	public boolean findMemberByPhone(String contactPhone);
	//2015/08/07 茅 追加 END
}
