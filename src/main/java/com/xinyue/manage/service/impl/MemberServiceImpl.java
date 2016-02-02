package com.xinyue.manage.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xinyue.manage.beans.InvitationMemberInfo;
import com.xinyue.manage.beans.MemberInfo;
import com.xinyue.manage.beans.OrderInfo;
import com.xinyue.manage.beans.PageData;
import com.xinyue.manage.beans.Recommend;
import com.xinyue.manage.beans.SearchReward;
import com.xinyue.manage.dao.MemberDao;
import com.xinyue.manage.model.Member;
import com.xinyue.manage.model.Order;
import com.xinyue.manage.model.Reward;
import com.xinyue.manage.service.MemberService;
import com.xinyue.manage.util.CommonFunction;
import com.xinyue.manage.util.GlobalConstant;
import com.xinyue.manage.util.SecurityUtils;

/**
 * 
 * @author wenhai.you
 * @2015年6月9日
 * @下午4:28:06
 */
/**
 *  lzc findRecommendMember() 15-11-30 修改rank参数
 *  lzc	findRecommendCredit() 15-11-30 修改rank参数
 *
 */
@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao memberDao;
	
	private Logger logger = Logger.getLogger(MemberServiceImpl.class);
	@Override
	public PageData<Member> findPageList(MemberInfo memberinfo) {
		// TODO Auto-generated method stub
		String topage = memberinfo.getTopage();
		int currentPage = (GlobalConstant.isNull(topage) || topage.equals("0"))?1:Integer.valueOf(topage);
		memberinfo.setStart((currentPage-1)*GlobalConstant.PAGE_SIZE);
		return new PageData<Member>(memberDao.findPageList(memberinfo), memberDao.getCount(memberinfo), currentPage);
	}

	@Override
	public int getCount(MemberInfo memberinfo) {
		// TODO Auto-generated method stub
		return memberDao.getCount(memberinfo);
	}

	@Override
	public boolean updateEnabled(List<String> id, String modifyUser) {
		// TODO Auto-generated method stub
		try {
			memberDao.updateEnabled(id, modifyUser);
			logger.info("会员启用成功 id为:"+id+"操作者为:"+modifyUser);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("会员启用失败 id为:"+id+"操作者为:"+modifyUser, e);
			return false;
		}
	}

	@Override
	public boolean updateDisabled(List<String> id, String modifyUser) {
		// TODO Auto-generated method stub
		try {
			memberDao.updateDisabled(id, modifyUser);
			logger.info("会员禁用成功 id为:"+id+"操作者为:"+modifyUser);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("会员禁用失败 id为:"+id+"操作者为:"+modifyUser, e);
			return false;
		}
	}

	
	@Override
	public boolean saveMember(Member memberedit, String modifyUser) {
		// TODO Auto-generated method stub
		try {
			
			if(GlobalConstant.isNull(memberedit.getId())){
				memberedit.setCreateUser(modifyUser);
				memberedit.setInvitationCode(SecurityUtils.randomStr(6));
				memberDao.addMember(memberedit);
				logger.info("添加会员成功 数据为:"+memberedit+"操作者为:"+modifyUser);
			}else{
				memberedit.setModifyUser(modifyUser);
				memberDao.updateMember(memberedit);
				logger.info("修改会员成功 数据为:"+memberedit+"操作者为:"+modifyUser);
			}
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("编辑会员失败 数据为操作者为:"+modifyUser, e);
			return false;
		}
		
	}
	
	@Override
	public boolean delMember(List<String> id, String modifyUser) {
		// TODO Auto-generated method stub
		try {
			memberDao.delMember(id, modifyUser);
			logger.info("会员删除成功 id为:"+id+"操作者为:"+modifyUser);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("会员删除失败 id为:"+id+"操作者为:"+modifyUser, e);
			return false;
		}
	}

	@Override
	public Member editMember(String id) {
		// TODO Auto-generated method stub
		return memberDao.editMember(id);
	}
	
	
	
	
	
	@Override
	public void exprot(HttpServletResponse response, List<Member> list)throws Exception {
		// TODO Auto-generated method stub
		String sheetName = MEMBER_SHEET_NAME;
		String fileName = MEMBER_EXCEL_NAME;

		// 头部内容
		String[] header = new String[] { 
				MEMBER_TITLE_1,
				MEMBER_TITLE_2,
				MEMBER_TITLE_3,
				MEMBER_TITLE_4,
				MEMBER_TITLE_5,
				MEMBER_TITLE_6,
				MEMBER_TITLE_7,
				MEMBER_TITLE_8,
				MEMBER_TITLE_9,
				MEMBER_TITLE_10,
				MEMBER_TITLE_11,
				MEMBER_TITLE_12};
		
		// 实际内容
		List<String[]> dataList = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			Member temp = list.get(i);
			String[] arrayT = new String[] { 
					String.valueOf(i + 1),
					temp.getLoginName(),
					temp.getMemberName(), 
					temp.getCompany(),
					temp.getArea(), 
					temp.getMemberCount(),
					temp.getContactName(), 
					temp.getContactPhone(),
					temp.getEmail(), 
					temp.getOrderCount(),
					temp.getRegTime(), 
					temp.getLoginTime()};
			dataList.add(arrayT);
		}
		
		CommonFunction cf = new CommonFunction();
		//调用共通
		cf.exportDataToExcel(response, fileName, sheetName, header, dataList);
	}
	
	@Override
	public void exprotMember(HttpServletResponse response, String type) {
		// TODO Auto-generated method stub
		MemberInfo memberinfo = new MemberInfo();
		memberinfo.setPage(2);
		
		try {
			if(GlobalConstant.isNull(type)){
				
				this.exprot(response, memberDao.findPageList(memberinfo));
			}else{
				memberinfo.setType(type);
				switch (type) {
					case "1":
						this.exprot(response, memberDao.findPageList(memberinfo));
						break;
					case "2":
						this.exprot(response, memberDao.findPageList(memberinfo));			
						break;
					case "3":
						this.exprot(response, memberDao.findPageList(memberinfo));
						break;
					case "4":
						this.exprot(response, memberDao.findPageList(memberinfo));
						break;
					case "5":
						this.exprot(response, memberDao.findPageList(memberinfo));
						break;
					case "6":
						this.exprot(response, memberDao.findPageList(memberinfo));
						break;
					case "7":
						this.exprot(response, memberDao.findPageList(memberinfo));
						break;
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("会员导出失败："+e);
		}
	}

	@Override
	public boolean findMemberByPhone(String contactPhone) {
		
		int result = memberDao.findMemberByPhone(contactPhone);
		
		if (result > 0) {
			return true;
		}
		return false;
	}
	
	
	@Override
	public PageData<InvitationMemberInfo> findRecommendCredit(Recommend rec) {
		// TODO Auto-generated method stub
		String topage = rec.getCredittopage();
		int currentPage = GlobalConstant.isNull(topage) || "0".equals(topage)?1:Integer.valueOf(topage);
		int start = (currentPage - 1)*GlobalConstant.PAGE_SIZE;
		return new PageData<InvitationMemberInfo>(
				//modified by lzc
//				memberDao.findRecommendCredit(rec.getMemberid(), null ,start, GlobalConstant.PAGE_SIZE), 
				memberDao.findRecommendCredit(rec.getMemberid(), rec.getRank() ,start, GlobalConstant.PAGE_SIZE), 
				//end
				memberDao.getRecommendCredit(rec.getMemberid()), 
				currentPage);
	}
	
	
	@Override
	public PageData<InvitationMemberInfo> findRecommendMember(Recommend rec) {
		// TODO Auto-generated method stub
		String topage = rec.getMembertopage();
		int currentPage = GlobalConstant.isNull(topage) || "0".equals(topage)?1:Integer.valueOf(topage);
		int start = (currentPage - 1)*GlobalConstant.PAGE_SIZE;
		return new PageData<InvitationMemberInfo>(
				//modified by lzc
//				memberDao.findRecommendMember(rec.getMemberid(),null, start, GlobalConstant.PAGE_SIZE), 
				memberDao.findRecommendMember(rec.getMemberid(),rec.getRank(), start, GlobalConstant.PAGE_SIZE), 
				//end
				memberDao.getRecommendMemberCount(rec.getMemberid()), 
				currentPage);
	}
	
	@Override
	public PageData<Order> findMemberOrder(OrderInfo info) {
		// TODO Auto-generated method stub
		String topage = info.getTopage();
		int currentPage = GlobalConstant.isNull(topage) || "0".equals(topage)?1:Integer.valueOf(topage);
		int start = (currentPage - 1)*GlobalConstant.PAGE_SIZE;
		return new PageData<Order>(
				memberDao.findMemberOrder(info.getMemberid(), start, GlobalConstant.PAGE_SIZE), 
				memberDao.getMemberOrderCount(info.getMemberid()),
				currentPage);
	}
	
	@Override
	public PageData<Reward> findMemberDraw(SearchReward sc) {
		// TODO Auto-generated method stub
		String topage = sc.getTopage();
		int currentPage = GlobalConstant.isNull(topage) || "0".equals(topage)?1:Integer.valueOf(topage);
		int start = (currentPage - 1)*GlobalConstant.PAGE_SIZE;
		return new PageData<Reward>(
				memberDao.findMemberDraw(sc, start, GlobalConstant.PAGE_SIZE), 
				memberDao.getMemberDraw(sc), currentPage);
	}
	
	@Override
	public PageData<Reward> findMemberReword(SearchReward sc) {
		// TODO Auto-generated method stub
		String topage = sc.getTopage();
		int currentPage = GlobalConstant.isNull(topage) || "0".equals(topage)?1:Integer.valueOf(topage);
		int start = (currentPage - 1)*GlobalConstant.PAGE_SIZE;
		return new PageData<Reward>(
				memberDao.findMemberReword(sc, start, GlobalConstant.PAGE_SIZE), 
				memberDao.getMemberReword(sc), currentPage);
	}
}
