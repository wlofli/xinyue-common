package com.xinyue.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xinyue.manage.beans.SearchReward;
import com.xinyue.manage.model.RewardOutLine;
import com.xinyue.manage.model.RewardReward;
import com.xinyue.manage.model.RewardWithdraw;

/**
 * author lzc
 */
public interface RewardDAO {
	public void addOutline(RewardOutLine outLine);
	
	public void addWithdraw(RewardWithdraw withdraw);
	
	public void addReward(RewardReward reward);
	
	public void updateOutline(@Param("userId")String userId, @Param("modifiedId")String modifiedId, int operation, float money);
	
	public float getTotalRecord(String userId);
	
	public RewardOutLine getRewardOutLine(String userId);
	
	public List<RewardReward> getRewardList(@Param("userId")String userId, @Param("pageNo")int pageNo,
			@Param("pageSize")int pageSize, @Param("searchReward")SearchReward searchReward,@Param("typeCode")String typeCode);
	
	public List<RewardWithdraw> getWithdrawList(@Param("userId")String userId, @Param("pageNo")int pageNo,
			@Param("pageSize")int pageSize, @Param("searchReward")SearchReward searchReward,@Param("typeCode")String typeCode);
	
	
	
	
	
	
	
	//undone
	public void updateRewardStatus();
	
}
