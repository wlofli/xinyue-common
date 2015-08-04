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
	
	
	public OutLine getRewardOutLine(String userId);
	
	public List<Reward> getRewardList(@Param("userId")String userId, @Param("pageNo")int pageNo,
			@Param("pageSize")int pageSize, @Param("searchReward")SearchReward searchReward,@Param("typeCode")String typeCode);
	
	public List<WithdrawMoney> getWithdrawList(@Param("userId")String userId, @Param("pageNo")int pageNo,
			@Param("pageSize")int pageSize, @Param("searchReward")SearchReward searchReward);
	
	
	public int countRewardList(@Param("userId")String userId, @Param("searchReward")SearchReward searchReward);
	
	public int countWithdrawList(@Param("userId")String userId, @Param("searchReward")SearchReward searchReward);
	
	public void updateOutline(@Param("userId")String userId, @Param("modifiedId")String modifiedId, int operation, float money);
	
	public float getTotalRecord(String userId);
	
	
	
}
