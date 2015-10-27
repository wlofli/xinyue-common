package com.xinyue.manage.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;

import com.xinyue.authe.UserInfo;
import com.xinyue.manage.beans.PageData;
import com.xinyue.manage.beans.QuestionBean;
import com.xinyue.manage.beans.SelectInfo;
import com.xinyue.manage.beans.ShowAnswer;
import com.xinyue.manage.dao.OrganizationDao;
import com.xinyue.manage.model.Answer;
import com.xinyue.manage.model.AnswerType;
import com.xinyue.manage.model.Question;

/**
 * 
 * @author wenhai.you
 * @2015年8月6日
 * @下午4:36:13
 */
public interface AnswerService {

	//2015-09-19
	/**
	 * ywh 通用信息 我的回答
	 * @param createid
	 * @return
	 */
	public QuestionBean getMyAnswer(String createid);
	
	/**
	 * ywh 通用信息 最近回答
	 * @param createid
	 * @return
	 */
	public QuestionBean getRecentlyAnswer(String createid);
	
	/**
	 * ywh 新越网 少回答问题 
	 * @param topage
	 * @return
	 */
	public PageData<Question> findXAbsenceAnswer(String topage);
	
	/**
	 * ywh 新越网 热门回答
	 * @param topage
	 * @return
	 */
	public PageData<Question> findXPossAnswer(String topage);
	
	/**
	 * ywh 添加回答问题
	 * @param answer
	 * @return
	 */
	public boolean addAnswer(Answer answer);
	
	/**
	 * ywh 机构回答 待回答
	 * @param topage
	 * @return
	 */
	public PageData<Question> findJAbsenceAnswer(String topage);
	
	/**
	 * ywh 机构回答 已回答
	 * @param topage
	 * @return
	 */
	public PageData<Question> findJPossAnswer(String topage);
	
	/**
	 * ywh 机构回答 通过审核
	 * @param topage
	 * @return
	 */
	public PageData<Question> findJPassAnswer(String topage);
	
	
	/**
	 * ywh 新越网 机构 非0回答
	 * @param questid
	 * @param topage
	 * @return
	 */
	public PageData<ShowAnswer> showAnswer(String questid , String topage);
	
	
	/**
	 * ywh 新越网 机构 非0回答记录数
	 * @param questid
	 * @return
	 */
	public ShowAnswer showZeroAnswer(String questid);
	
	
	/**
	 * ywh 我的回答
	 * @param topage
	 * @param createid
	 * @return
	 */
	public PageData<Question> findMyAnswer(String topage , String createid);
	
	
	/**
	 * ywh 后台信贷经理 客户回答
	 * @param credit
	 * @param typeid
	 * @param topage
	 * @return
	 */
	public PageData<Question> findAdminXPossAnswer(String credit , String typeid , String topage);
	
	/**
	 * 后台
	 */
	/**
	 * ywh 回答列表
	 * @param qb
	 * @return
	 */
	public PageData<Question> findAdminQuestion(QuestionBean qb);
	
	/**
	 * ywh 类型 二级列表
	 * @return
	 */
	public List<AnswerType> findSecond();
	
	/**
	 * ywh 修改问题状态和问题类型
	 * @param status
	 * @param questtypeid
	 * @param id
	 * @return
	 */
	public boolean updateQuest(String status , String questtypeid , String id);
	
	

	/**
	 * ywh 获取所有机构名称
	 * @return
	 */
	public List<SelectInfo> getOrgs();
	
	
	/**
	 * ywh 修改回答状态 或者设置推荐 或者删除
	 * @param option
	 * @param aid
	 */
	public boolean updateAnswer(String option ,String aid , String questid);
	
	
	/**
	 * ywh admin 修改问题状态和问题类型
	 * @param status
	 * @param questtypeid
	 * @param id
	 * @return
	 */
	public boolean updateQuest(Question question);
	
	
	/**
	 * ywh admin questid
	 * @param questid
	 * @return
	 */
	public Question findQuestById(String questid);
	
	
	/**
	 * ywh admin 发布
	 * @param list
	 * @return
	 */
	public boolean publishQuest(List<String> list , String createUser);
	
	
	/**
	 * admin member quest ywh
	 * @param qb
	 * @return
	 */
	public PageData<Question> findMemberQuest(QuestionBean qb);
}
