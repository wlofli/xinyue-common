package com.xinyue.manage.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xinyue.manage.beans.MemberInfo;
import com.xinyue.manage.dao.MemberDao;
import com.xinyue.manage.model.Member;
import com.xinyue.manage.service.MemberService;
import com.xinyue.manage.util.CommonFunction;
import com.xinyue.manage.util.GlobalConstant;

/**
 * 
 * @author wenhai.you
 * @2015年6月9日
 * @下午4:28:06
 */
@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao memberDao;
	
	private Logger logger = Logger.getLogger(MemberServiceImpl.class);
	@Override
	public List<Member> findPageList(MemberInfo memberinfo) {
		// TODO Auto-generated method stub
		return memberDao.findPageList(memberinfo);
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
			logger.error("编辑会员失败 数据为:"+memberedit+"操作者为:"+modifyUser, e);
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
	public List<Member> findDisuiPage(MemberInfo memberinfo) {
		// TODO Auto-generated method stub
		return memberDao.findDisuiPage(memberinfo);
	}
	@Override
	public List<Member> findGuoPage(MemberInfo memberinfo) {
		// TODO Auto-generated method stub
		return memberDao.findGuoPage(memberinfo);
	}
	@Override
	public List<Member> findQQPage(MemberInfo memberinfo) {
		// TODO Auto-generated method stub
		return memberDao.findQQPage(memberinfo);
	}
	@Override
	public List<Member> findSuiwuPage(MemberInfo memberinfo) {
		// TODO Auto-generated method stub
		return memberDao.findSuiwuPage(memberinfo);
	}
	@Override
	public List<Member> findWeiboPage(MemberInfo memberinfo) {
		// TODO Auto-generated method stub
		return memberDao.findWeiboPage(memberinfo);
	}
	@Override
	public List<Member> findWeixinPage(MemberInfo memberinfo) {
		// TODO Auto-generated method stub
		return memberDao.findWeixinPage(memberinfo);
	}
	@Override
	public List<Member> findXinYuePage(MemberInfo memberinfo) {
		// TODO Auto-generated method stub
		return memberDao.findXinYuePage(memberinfo);
	}
	@Override
	public int getDisuiCount(MemberInfo memberinfo) {
		// TODO Auto-generated method stub
		return memberDao.getDisuiCount(memberinfo);
	}
	@Override
	public int getGuoCount(MemberInfo memberinfo) {
		// TODO Auto-generated method stub
		return memberDao.getGuoCount(memberinfo);
	}
	@Override
	public int getQQCount(MemberInfo memberinfo) {
		// TODO Auto-generated method stub
		return memberDao.getQQCount(memberinfo);
	}
	@Override
	public int getSuiwuCount(MemberInfo memberinfo) {
		// TODO Auto-generated method stub
		return memberDao.getSuiwuCount(memberinfo);
	}
	@Override
	public int getWeiboCount(MemberInfo memberinfo) {
		// TODO Auto-generated method stub
		return memberDao.getWeiboCount(memberinfo);
	}
	@Override
	public int getWeixinCount(MemberInfo memberinfo) {
		// TODO Auto-generated method stub
		return memberDao.getWeixinCount(memberinfo);
	}
	@Override
	public int getXinYueCount(MemberInfo memberinfo) {
		// TODO Auto-generated method stub
		return memberDao.getXinYueCount(memberinfo);
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
		try {
			if(GlobalConstant.isNull(type)){
				
				this.exprot(response, this.findPageList(memberinfo));
			}else{
				switch (type) {
					case "1":
						this.exprot(response, this.findQQPage(memberinfo));
						break;
					case "2":
						this.exprot(response, this.findXinYuePage(memberinfo));			
						break;
					case "3":
						this.exprot(response, this.findWeixinPage(memberinfo));
						break;
					case "4":
						this.exprot(response, this.findWeiboPage(memberinfo));
						break;
					case "5":
						this.exprot(response, this.findSuiwuPage(memberinfo));
						break;
					case "6":
						this.exprot(response, this.findDisuiPage(memberinfo));
						break;
					case "7":
						this.exprot(response, this.findGuoPage(memberinfo));
						break;
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("会员导出失败："+e);
		}
	}
}
