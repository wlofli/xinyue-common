package com.xinyue.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.poi.xslf.model.geom.Outline;

import com.xinyue.manage.beans.SearchReward;
import com.xinyue.manage.model.OutLine;
import com.xinyue.manage.model.Reward;
import com.xinyue.manage.model.WithdrawMoney;

/**
 * author lzc
 */
public interface RewardDAO {
	public void addOutline(Outline outLine);
	
	public void addWithdraw(WithdrawMoney withdraw);
	
	public void addReward(Reward reward);
	/**用getRewardOutLineByuserId(String userId, String userType)代替
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
	
	public List<Reward> getRewardList(@Param("userId")String userId, @Param("pageNo")int pageNo,
			@Param("pageSize")int pageSize, @Param("searchReward")SearchReward searchReward,@Param("typeCode")String typeCode);
	
	public List<WithdrawMoney> getWithdrawList(@Param("userId")String userId, @Param("pageNo")int pageNo,
			@Param("pageSize")int pageSize, @Param("searchReward")SearchReward searchReward);
	
	
	public int countRewardList(@Param("userId")String userId, @Param("searchReward")SearchReward searchReward);
	
	public int countWithdrawList(@Param("userId")String userId, @Param("searchReward")SearchReward searchReward);
	//以下方法未实现
	public void updateOutline(@Param("userId")String userId, @Param("modifiedId")String modifiedId, int operation, float money);
	
	public float getTotalRecord(String userId);
	
	
	
}
