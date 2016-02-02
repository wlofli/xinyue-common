package com.xinyue.manage.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.xinyue.manage.beans.InvitationMemberInfo;
import com.xinyue.manage.beans.MemberInfo;
import com.xinyue.manage.beans.OrderInfo;
import com.xinyue.manage.beans.PageData;
import com.xinyue.manage.beans.Recommend;
import com.xinyue.manage.beans.SearchReward;
import com.xinyue.manage.model.Member;
import com.xinyue.manage.model.Order;
import com.xinyue.manage.model.Reward;

/**
 * 
 * @author wenhai.you
 * @2015年6月9日
 * @下午4:27:16
 */
public interface MemberService {

	public PageData<Member> findPageList(MemberInfo memberinfo);
	
	
	public int getCount(MemberInfo memberinfo);
	
	
	public boolean updateEnabled(List<String> id , String modifyUser);
	
	
	public boolean updateDisabled(List<String> id, String modifyUser);
	
	public boolean saveMember(Member memberedit, String modifyUser);
	
	public boolean delMember(List<String> id, String modifyUser);
	
	
	public Member editMember(String id);
	
	
	
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
	
	/**
	 * admin member recommendmember ywh 
	 * @param rec
	 * @return
	 */
	public PageData<InvitationMemberInfo> findRecommendMember(Recommend rec);
	/**
	 * admin member recommendcredit ywh
	 * @param rec
	 * @return
	 */
	public PageData<InvitationMemberInfo> findRecommendCredit(Recommend rec);
	
	/**
	 * admin member order ywh
	 * @param info
	 * @return
	 */
	public PageData<Order> findMemberOrder(OrderInfo info);
	
	
	/**
	 * 提现
	 * @param sc
	 * @return
	 */
	public PageData<Reward> findMemberDraw(SearchReward sc);
	
	
	/**
	 * 奖励 
	 * @param sc
	 * @return
	 */
	public PageData<Reward> findMemberReword(SearchReward sc);
}
