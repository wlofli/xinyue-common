package com.xinyue.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xinyue.manage.beans.QuestionBean;
import com.xinyue.manage.beans.ShowAnswer;
import com.xinyue.manage.model.Answer;
import com.xinyue.manage.model.Question;

/**
 * 
 * @author wenhai.you
 * @2015年8月6日
 * @下午3:51:19
 */
public interface AnswerDao {

	
	//2015-09-19以后 修改的地方
	/**
	 * ywh 通用信息 我的回答
	 * @param createid
	 * @return
	 */
	public QuestionBean getMyAnswer(@Param("createid") String createid);
	
	/**
	 * ywh 通用信息 最近回答
	 * @param createid
	 * @return
	 */
	public QuestionBean getRecentlyAnswer(@Param("createid") String createid);
	
	/**
	 * ywh 新越网 少回答问题 
	 * @param start
	 * @param pageSize
	 * @return
	 */
	public List<Question> findXAbsenceAnswer(@Param("start")int start , @Param("pageSize")int pageSize);
	
	/**
	 * ywh 新越网少回答问题 记录数 
	 * @return
	 */
	public int getXAbsenceAnswerCount();
	
	/**
	 * ywh 新越网热门回答
	 * @param start
	 * @param pageSize
	 * @return
	 */
	public List<Question> findXPossAnswer(@Param("start")int start , @Param("pageSize")int pageSize);
	
	/**
	 * ywh 新越网热门回答
	 * @return
	 */
	public int getXPossAnswerCount();
	
	
	/**
	 * ywh 添加回答问题
	 * @param answer
	 * @return
	 */
	public int addAnswer(Answer answer);
	
	
	/**
	 * ywh 删除问题
	 * @param quests
	 * @param createUser
	 */
	public void delQuest(@Param("list")List<String> quests , @Param("createUser")String createUser);
	
	
	
	/**
	 * ywh 机构回答 待回答
	 * @param start
	 * @param pageSize
	 * @return
	 */
	public List<Question> findJAbsenceAnswer(@Param("start")int start , @Param("pageSize")int pageSize);
	
	/**
	 * ywh 机构回答 待回答 总记录数
	 * @return
	 */
	public int getJAbsenceAnswerCount();
	
	/**
	 * ywh 机构回答 已回答
	 * @param start
	 * @param pageSize
	 * @return
	 */
	public List<Question> findJPossAnswer(@Param("start")int start , @Param("pageSize")int pageSize);
	
	/**
	 * ywh 机构回答 已回答 记录数
	 * @return
	 */
	public int getJPossAnswerCount();
	
	
	/**
	 * ywh 机构回答 通过审核
	 * @param start
	 * @param pageSize
	 * @return
	 */
	public List<Question> findJPassAnswer(@Param("start")int start , @Param("pageSize")int pageSize);
	
	/**
	 * ywh 机构回答通过审核 记录数
	 * @return
	 */
	public int getJPassAnswerCount();
	
	
	/**
	 * ywh 新越网 机构 0回答
	 * @param questid
	 * @return
	 */
	public ShowAnswer showZeroAnswer(@Param("questid")String questid);
	
	
	/**
	 * ywh 新越网 机构 非0回答
	 * @param questid
	 * @param start
	 * @param pageSize
	 * @return
	 */
	public List<ShowAnswer> showAnswer(@Param("questid")String questid,@Param("start")int start , @Param("pageSize")int pageSize);
	
	
	/**
	 * ywh 新越网 机构 非0回答 记录数
	 * @param questid
	 * @return
	 */
	public int getShowAnswerCount(@Param("questid")String questid);
	
	/**
	 * ywh 我的回答
	 * @param createid
	 * @param start
	 * @param pageSize
	 * @return
	 */
	public List<Question> findMyAnswer(@Param("createid")String createid ,@Param("start")int start , @Param("pageSize")int pageSize);
	
	/**
	 * ywh 我的回答记录数
	 * @param createid
	 * @return
	 */
	public int findMyAnswerCount(@Param("createid")String createid);

	
	/**
	 * ywh 机构店铺设置  贷款咨询问题
	 * @param qb
	 * @param start
	 * @param pageSize
	 * @return
	 */
	public List<Question> findOrgQuest(@Param("qbean")QuestionBean qb , @Param("start")int start , @Param("pageSize")int pageSize);
	
	
	/**
	 * ywh 机构店铺设置  贷款咨询问题记录数
	 * @param qb
	 * @return
	 */
	public int getOrgQuestCount(@Param("qbean")QuestionBean qb);
	
	
	/**
	 * ywh 店铺问题详细
	 * @param questid
	 * @param start
	 * @param pageSize
	 * @return
	 */
	public List<ShowAnswer> showOrgAnswer(@Param("questid")String questid,@Param("start")int start , @Param("pageSize")int pageSize);
	
	
	/**
	 * ywh 店铺问题详细 记录数
	 * @param questid
	 * @return
	 */
	public int getOrgAnswerCount(@Param("questid")String questid);
	
	
	/**
	 * ywh 后台信贷经理 客户回答
	 * @param typeid
	 * @param creditid
	 * @param start
	 * @param pageSize
	 * @return
	 */
	public List<Question> findAdminXPossAnswer(@Param("typeid")String typeid , @Param("creditid")String creditid , @Param("start")int start , @Param("pageSize")int pageSize);
	
	/**
	 * ywh 后台信贷经理 客户回答记录数
	 * @param typeid
	 * @param creditid
	 * @return
	 */
	public int getAdminXPossAnswerCount(@Param("typeid")String typeid , @Param("creditid")String creditid);
	
	
	/**
	 * 后台
	 */
	/**
	 * ywh 问答列表
	 * @param qb
	 * @param start
	 * @param pageSize
	 * @return
	 */
	public List<Question> findQuestList(@Param("qb") QuestionBean qb ,@Param("start") int start ,@Param("pageSize") int pageSize);
	
	/**
	 * ywh 问答列表记录数
	 * @param qb
	 * @return
	 */
	public int getQuestListCount(QuestionBean qb );
	
	/**
	 * ywh 修改状态和问题类型
	 * @param status
	 * @param questtypeid
	 * @param id
	 */
	public void updateQuest(@Param("status") String status , @Param("questtypeid") String questtypeid , @Param("id") String id);
	
	
	/**
	 * ywh 修改回答状态 或者设置推荐 或者删除
	 * @param option
	 * @param aid
	 */
	public void updateAnswer(@Param("option") String option , @Param("aid") String aid);
	
	/**
	 * ywh　设置为都不推荐
	 * @param questid
	 */
	public void updateAnswerRecommend(String questid);
	
	/**
	 * ywh admin添加问题
	 * @param quest
	 */
	public void addQuest(Question quest);
	
	/**
	 * ywh admin修改问题
	 * @param quest
	 */
	public void updateAdminQuest(Question quest);
	
	/**
	 * ywh admin questid
	 * @param questid
	 * @return
	 */
	public Question findQuestById(String questid);
	
	/**
	 * ywh admin adminid
	 * @param userName
	 * @return
	 */
	public Question findUserByUserName(String userName);
	
	
	/**
	 * 发布
	 * @param list
	 */
	public void publishQuest(@Param("list")List<String> quests , @Param("createUser")String createUser);
	
	
	/**
	 * admin ywh 会员 
	 * @param memberid
	 * @param start
	 * @param pageSize
	 * @return
	 */
	public List<Question> findMemberQuest(@Param("memberid")String memberid ,@Param("start") int start ,@Param("pageSize") int pageSize);
	
	/**
	 * admin ywh 会员 
	 * @param memberid
	 * @return
	 */
	public int getMemberQuest(@Param("memberid")String memberid);
	
	/**
	 * 删除问题类型时 得清空问题对应问题类型外键
	 * @param list
	 */
	public void cleanForeignByQuestionType(@Param("list") List<String> list , @Param("createUser") String createUser);
}
