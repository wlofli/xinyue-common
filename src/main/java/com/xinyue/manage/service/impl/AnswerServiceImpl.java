package com.xinyue.manage.service.impl;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.xinyue.authe.UserInfo;
import com.xinyue.manage.beans.PageData;
import com.xinyue.manage.beans.QuestionBean;
import com.xinyue.manage.beans.SelectInfo;
import com.xinyue.manage.beans.ShowAnswer;
import com.xinyue.manage.dao.AnswerDao;
import com.xinyue.manage.dao.AnswerTypeDao;
import com.xinyue.manage.dao.OrganizationDao;
import com.xinyue.manage.model.Answer;
import com.xinyue.manage.model.AnswerType;
import com.xinyue.manage.model.Question;
import com.xinyue.manage.service.AnswerService;
import com.xinyue.manage.util.GlobalConstant;

/**
 * 
 * @author wenhai.you
 * @2015年8月6日
 * @下午5:14:13
 */
/**
 * lzc  2015年12月22日 getMyAnswer()格式化数字
 *
 */
@Service
public class AnswerServiceImpl implements AnswerService {

	@Resource
	private AnswerDao adao;
	private Logger logger = Logger.getLogger(AnswerServiceImpl.class);
	
//	add by lzc
	DecimalFormat df = new DecimalFormat("######0.00");
	
	@Override
	public QuestionBean getMyAnswer(String createid) {
		// TODO Auto-generated method stub
		QuestionBean qb = adao.getMyAnswer(createid);
		//modified by lzc
		//增加了qb判null条件
		if (qb != null) {
			int total = qb.getTotal();
			if(total !=0){
				//modified by lzc 2015年12月22日 格式化数字
				qb.setRate(Double.parseDouble(df.format((double)qb.getPass() * 100 /total)));
				//end
			}
		}
		
		
		return qb;
	}
	
	@Override
	public QuestionBean getRecentlyAnswer(String createid) {
		// TODO Auto-generated method stub
		return adao.getRecentlyAnswer(createid);
	}
	
	@Override
	public PageData<Question> findXAbsenceAnswer(String topage) {
		// TODO Auto-generated method stub
		int currentPage = GlobalConstant.isNull(topage)|| "0".equals(topage)?1:Integer.valueOf(topage);
		int start = (currentPage -1)*GlobalConstant.PAGE_SIZE;
		PageData<Question> pdata = new PageData<Question>(adao.findXAbsenceAnswer(start, GlobalConstant.PAGE_SIZE), adao.getXAbsenceAnswerCount(), currentPage);
		return pdata;
	}

	@Override
	public PageData<Question> findXPossAnswer(String topage) {
		// TODO Auto-generated method stub
		int currentPage = GlobalConstant.isNull(topage)|| "0".equals(topage)?1:Integer.valueOf(topage);
		int start = (currentPage -1)*GlobalConstant.PAGE_SIZE;
		PageData<Question> pdata = new PageData<Question>(adao.findXPossAnswer(start, GlobalConstant.PAGE_SIZE), adao.getXPossAnswerCount(), currentPage);
		return pdata;
	}

	@Override
	public PageData<Question> findJAbsenceAnswer(String topage) {
		// TODO Auto-generated method stub
		int currentPage = GlobalConstant.isNull(topage)|| "0".equals(topage)?1:Integer.valueOf(topage);
		int start = (currentPage -1)*GlobalConstant.PAGE_SIZE;
		PageData<Question> pdata = new PageData<Question>(adao.findJAbsenceAnswer(start, GlobalConstant.PAGE_SIZE), adao.getJAbsenceAnswerCount(), currentPage);
		return pdata;
	}

	@Override
	public PageData<Question> findJPossAnswer(String topage) {
		// TODO Auto-generated method stub
		int currentPage = GlobalConstant.isNull(topage)|| "0".equals(topage)?1:Integer.valueOf(topage);
		int start = (currentPage -1)*GlobalConstant.PAGE_SIZE;
		PageData<Question> pdata = new PageData<Question>(adao.findJPossAnswer(start, GlobalConstant.PAGE_SIZE), adao.getJPossAnswerCount(), currentPage);
		return pdata;
	}

	@Override
	public PageData<Question> findJPassAnswer(String topage) {
		// TODO Auto-generated method stub
		int currentPage = GlobalConstant.isNull(topage)|| "0".equals(topage)?1:Integer.valueOf(topage);
		int start = (currentPage -1)*GlobalConstant.PAGE_SIZE;
		PageData<Question> pdata = new PageData<Question>(adao.findJPassAnswer(start, GlobalConstant.PAGE_SIZE), adao.getJPassAnswerCount(), currentPage);
		return pdata;
	}

	@Override
	public PageData<Question> findMyAnswer(String topage, String createid) {
		// TODO Auto-generated method stub
		int currentPage = GlobalConstant.isNull(topage)|| "0".equals(topage)?1:Integer.valueOf(topage);
		int start = (currentPage -1)*GlobalConstant.PAGE_SIZE;
		PageData<Question> pdata = new PageData<Question>(adao.findMyAnswer(createid, start, GlobalConstant.PAGE_SIZE)
				, adao.findMyAnswerCount(createid)
				, currentPage);
		return pdata;
	}

	@Override
	public boolean addAnswer(Answer answer) {
		// TODO Auto-generated method stub
		try {
			if("0".equals(answer.getCreateid()) || GlobalConstant.isNull(answer.getCreateid())){
				answer.setCreateid("0");
				answer.setType("n");
			}
			adao.addAnswer(answer);
			logger.info("添加问题回答成功");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("添加问题回答失败" , e);
			return false;
		}
	}
	
	@Override
	public PageData<ShowAnswer> showAnswer(String questid , String topage) {
		// TODO Auto-generated method stub
		int currentPage = GlobalConstant.isNull(topage)|| "0".equals(topage)?1:Integer.valueOf(topage);
		int start = (currentPage -1)*GlobalConstant.PAGE_SIZE;
		
		return new PageData<ShowAnswer>(
				adao.showAnswer(questid , start , GlobalConstant.PAGE_SIZE), 
				adao.getShowAnswerCount(questid),
				currentPage
			);
	}
	
	@Override
	public ShowAnswer showZeroAnswer(String questid) {
		// TODO Auto-generated method stub
		return adao.showZeroAnswer(questid);
	}
	
	
	@Override
	public PageData<Question> findAdminXPossAnswer(String credit,
			String typeid, String topage) {
		// TODO Auto-generated method stub
		int currentPage = GlobalConstant.isNull(topage)|| "0".equals(topage)?1:Integer.valueOf(topage);
		int start = (currentPage -1)*GlobalConstant.PAGE_SIZE;
		PageData<Question> pdata = new PageData<Question>(
				adao.findAdminXPossAnswer(typeid , credit , start , GlobalConstant.PAGE_SIZE), 
				adao.getAdminXPossAnswerCount(typeid , credit), 
				currentPage);
		return pdata;
	}
	
	
	@Override
	public PageData<Question> findAdminQuestion(QuestionBean qb) {
		// TODO Auto-generated method stub
		String topage = qb.getTopage();
		int currentPage = GlobalConstant.isNull(topage)|| "0".equals(topage)?1:Integer.valueOf(topage);
		int start = (currentPage -1)*GlobalConstant.PAGE_SIZE;
		PageData<Question> pdata = new PageData<Question>(
				adao.findQuestList(qb, start, GlobalConstant.PAGE_SIZE), 
				adao.getQuestListCount(qb), 
				currentPage);
		return pdata;
	}
	
	@Resource
	private AnswerTypeDao atdao;
	@Override
	public List<AnswerType> findSecond() {
		// TODO Auto-generated method stub
		return atdao.findAanswerType(false);
	}
	
	
	public boolean updateQuest(String status , String questtypeid , String id){
		
		try {
			adao.updateQuest(status, questtypeid, id);
			logger.info("修改问题状态和问题类型成功");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("修改问题状态和问题类型失败" , e);
			return false;
		}
	}
	
	@Resource
	private OrganizationDao odao;
	@Override
	public List<SelectInfo> getOrgs() {
		// TODO Auto-generated method stub
		return odao.getOrgs();
	}
	
	@Override
	public boolean updateAnswer(String option, String aid, String questid) {
		// TODO Auto-generated method stub
		try {
			if("2".equals(option)){
				adao.updateAnswerRecommend(questid);
			}
			adao.updateAnswer(option, aid);
			logger.info("设置删除推荐审核成功");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("设置删除推荐审核失败" , e);
			throw new RuntimeException("设置删除推荐审核失败", e);
		}
		
	}
	
	@Override
	public boolean updateQuest(Question question) {
		// TODO Auto-generated method stub
		try {
			
			if(GlobalConstant.isNull(question.getId())){
				Question user = adao.findUserByUserName(question.getCreateName());
				question.setCreateid(String.valueOf(user.getId()));
				adao.addQuest(question);
				logger.info("添加问题成功");
				return true;
			}else{
				adao.updateAdminQuest(question);
				logger.info("修改问题成功");
				return true;
			}
				
		} catch (Exception e) {
			// TODO: handle exception
			if(GlobalConstant.isNull(question.getId())){
				logger.error("添加问题失败" , e);
			}else{
				logger.error("修改问题失败" , e);
			}
			return false;
		}
	}
	
	@Override
	public Question findQuestById(String questid) {
		// TODO Auto-generated method stub
		return adao.findQuestById(questid);
	}
	
	
	@Override
	public boolean publishQuest(List<String> list , String createUser) {
		// TODO Auto-generated method stub
		try {
			adao.publishQuest(list , createUser);
			logger.info("发布问题成功");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("发布问题失败" , e);
			return false;
		}
	}
	
	
	@Override
	public PageData<Question> findMemberQuest(QuestionBean qb) {
		// TODO Auto-generated method stub
		String topage = qb.getTopage();
		int currentPage = GlobalConstant.isNull(topage) || "0".equals(topage)?1:Integer.valueOf(topage);
		int start = (currentPage - 1)* GlobalConstant.PAGE_SIZE;
		return new PageData<Question>(adao.findMemberQuest(qb.getMemberid(), start, GlobalConstant.PAGE_SIZE), adao.getMemberQuest(qb.getMemberid()), currentPage);
	}
	
}
