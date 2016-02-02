package com.xinyue.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.poi.xslf.model.geom.Outline;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xinyue.manage.beans.SearchMoneyAccount;
import com.xinyue.manage.beans.SearchOrderCredit;
import com.xinyue.manage.beans.SearchReward;
import com.xinyue.manage.model.OutLine;
import com.xinyue.manage.model.Reward;
import com.xinyue.manage.model.WithdrawMoney;

/**
 * author lzc
 */
public interface RewardDAO {
	public void addOutline(OutLine outLine);
	
	/**初始化启动资金 设置为0
	 * add by lzc     date: 2015年11月30日
	 * @param outLine
	 */
	public void initOutline(OutLine outLine);
	
	public void addWithdraw(WithdrawMoney withdraw);
	
	public void addReward(Reward reward);
	/**用getRewardOutLineByuserId代替
	 * add by lzc     date: 2015年9月7日
	 */
	@Deprecated
	public OutLine getRewardOutLine(String userId);
	
	/**
	 * add by lzc     date: 2015年9月7日
	 * @param userId 
	 * @param userType (m:普通会员 c:信贷经理)
	 * @return
	 */
	public OutLine getRewardOutLineByuserId(@Param("userId")String userId, @Param("userType")String userType);
	
	
	/**返回总的奖励余额
	 * add by lzc     date: 2015年9月21日
	 * @return
	 */
	public Double getAllAwardRemain();
	
	/**返回总的奖励累计金额
	 * add by lzc     date: 2015年9月21日
	 * @return
	 */
	public Double getAllReward();
	
	/**返回总的提现累计金额
	 * add by lzc     date: 2015年9月21日
	 * @return
	 */
	public Double getAllWithdraw();
	
	/**获取userId对应的奖励列表
	 * add by lzc     date: 2015年9月18日
	 * @param searchReward
	 * @return
	 */
	public List<Reward> getRewardList(@Param("userId")String userId, @Param("pageNo")int pageNo,
			@Param("pageSize")int pageSize, @Param("searchReward")SearchReward searchReward,@Param("typeCode")String typeCode);
	
	public int countRewardList(@Param("userId")String userId, @Param("searchReward")SearchReward searchReward);
	
	public List<WithdrawMoney> getWithdrawList(@Param("userId")String userId, @Param("pageNo")int pageNo,
			@Param("pageSize")int pageSize, @Param("searchReward")SearchReward searchReward);
	
	public int countWithdrawList(@Param("userId")String userId, @Param("searchReward")SearchReward searchReward);
	
	
	/**获取selectInfo包含每个状态的数量
	 * add by lzc     date: 2015年9月23日
	 * @param statusList
	 * @return
	 */
	public List<SearchOrderCredit> getWithdrawInfoWithNum(@Param("list")int[] statusList);
	
	
	/**根据条件获取提现管理列表
	 * add by lzc     date: 2015年9月21日
	 * @return
	 */
	public List<WithdrawMoney> getWithdrawListByCondition(@Param("search")SearchReward searchReward, @Param("pageNo")int pageNo,
			@Param("pageSize")int pageSize);
	
	public int countWithdrawListByCondition(@Param("search")SearchReward searchReward);
	
	
	/**根据条件获取奖励列表
	 * add by lzc     date: 2015年9月18日
	 * @param searchReward
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<Reward> getRewardListByCondition(@Param("search")SearchReward searchReward,@Param("pageNo")int pageNo,
			@Param("pageSize")int pageSize);
	
	public int countRewardListByCondition(@Param("search")SearchReward searchReward);
	
	/**获取消费,充值,奖励总和类型  
	 * add by lzc     date: 2015年9月9日
	 */
	public List<OutLine> getDetailList(@Param("userId")String userId, @Param("userType")String userType, @Param("pageNo")int pageNo,
			@Param("pageSize")int pageSize, @Param("searchReward")SearchReward searchReward);
	
	
	
	public int countDetailList(@Param("userId")String userId, @Param("userType")String userType,
			@Param("searchReward")SearchReward searchReward);
	
	/**修改资金表
	 * add by lzc     date: 2015年9月14日
	 */
	public void updateOutline(OutLine outLine);
	
	/**根据订单获取取现详情
	 * add by lzc     date: 2015年9月22日
	 */
	public WithdrawMoney getWithdrawMoneyById(String id);
	
	/**更新提现详情
	 * add by lzc     date: 2015年9月22日
	 */
	public boolean updateWithdrawMoney(@Param("withdraw")WithdrawMoney withdrawMoney);
	
	
	public float getTotalRecord(String userId);

	/**
	 * 信贷经理管理-资金账户-奖励记录（后台）
	 * add by maozj 2015/9/9
	 * @param searchMoneyAccount
	 * @return
	 */
	public List<Reward> getRewardRecords(SearchMoneyAccount searchMoneyAccount);

	/**
	 * 信贷经理管理-资金账户-奖励记录数量（后台）
	 * add by maozj 2015/9/9
	 * @param searchMoneyAccount
	 * @return
	 */
	public int getRewardRecordsCount(SearchMoneyAccount searchMoneyAccount);

	/**
	 * 信贷经理管理-资金账户-提现记录（后台）
	 * add by maozj 2015/9/9
	 * @param searchMoneyAccount
	 * @return
	 */
	public List<WithdrawMoney> getWithdrawMoneyRecords(
			SearchMoneyAccount searchMoneyAccount);

	/**
	 * 信贷经理管理-资金账户-提现记录getRewardRecordsCount（后台）
	 * add by maozj 2015/9/9
	 * @param searchMoneyAccount
	 * @return
	 */
	public int getWithdrawMoneyRecordsCount(
			SearchMoneyAccount searchMoneyAccount);
	
	
	
	
}
