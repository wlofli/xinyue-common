package com.xinyue.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xinyue.manage.beans.InvitationMemberInfo;
import com.xinyue.manage.beans.MemberInfo;
import com.xinyue.manage.beans.Recommend;
import com.xinyue.manage.beans.SearchReward;
import com.xinyue.manage.model.Member;
import com.xinyue.manage.model.Order;
import com.xinyue.manage.model.Reward;

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

	public int findMemberByPhone(String contactPhone);
	
	/**
	 * ywh gg 根据电话号码查询会员 信息
	 * @param contactPhone
	 * @return
	 */
	public Member getMemberByPhone(String contactPhone);
	
	//2015-10-20
	//推荐
	public List<InvitationMemberInfo> findRecommendMember(@Param("memberid") String memberid , @Param("start") int start , @Param("pageSize") int pageSize);
	public int getRecommendMemberCount(String memberid);
	
	public List<InvitationMemberInfo> findRecommendCredit(@Param("memberid") String memberid , @Param("start") int start , @Param("pageSize") int pageSize);
	public int getRecommendCredit(String memberid);
	
	//订单
	public List<Order> findMemberOrder(@Param("memberid") String memberid , @Param("start") int start , @Param("pageSize") int pageSize);
	public int getMemberOrderCount(String memberid);
	
	//提现
	public List<Reward> findMemberDraw(@Param("sc")SearchReward sc , @Param("start") int start , @Param("pageSize") int pageSize);
	public int getMemberDraw(@Param("sc")SearchReward sc);
	
	//奖励 
	public List<Reward> findMemberReword(@Param("sc")SearchReward sc , @Param("start") int start , @Param("pageSize") int pageSize);
	public int getMemberReword(@Param("sc")SearchReward sc);
}
