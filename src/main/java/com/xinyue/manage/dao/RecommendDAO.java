package com.xinyue.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xinyue.manage.beans.Recommend;

/**推荐
 * author lzc
 */
public interface RecommendDAO {
	
	
	/**获取推荐信贷经理列表
	 * add by lzc     date: 2015年10月10日
	 * @param recommend 搜索条件
	 * @return
	 * useless
	 */
	public List<Recommend> getRecommendCreditByCondition(@Param("search")Recommend recommend, 
			@Param("pageNo")int pageNo, @Param("pageSize")int pageSize);
	
	/**
	 * useless
	 */
	public int countRecommendCreditByCondition(@Param("search")Recommend recommend);
	
	
	/**获取推荐普通会员推广列表
	 * add by lzc     date: 2015年10月12日
	 * @param recommend 搜索条件
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * useless
	 */
	public List<Recommend> getRecommendMemberByCondition(@Param("search")Recommend recommend, @Param("pageNo")int pageNo, @Param("pageSize")int pageSize);
	
	
	/**
	 * add by lzc     date: 2015年10月21日
	 * useless
	 */
	public int countRecommendMemberByCondition(@Param("search")Recommend recommend);
	
	
	
	/**获取推荐信贷经理列表
	 * add by lzc     date: 2015年10月21日
	 * @param recommend
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<Recommend> getRecommendCreditByInvitedCode(@Param("search")Recommend recommend, 
			@Param("pageNo")int pageNo, @Param("pageSize")int pageSize);
	
	public int countRecommendCreditByInvitedCode(@Param("search")Recommend recommend);
	
	
	
	/**获取推荐普通会员推广列表
	 * add by lzc     date: 2015年10月21日
	 * @param recommend
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<Recommend> getRecommendMemberByInvitedCode(@Param("search")Recommend recommend, 
			@Param("pageNo")int pageNo, @Param("pageSize")int pageSize);
	
	public int countRecommendMemberByInvitedCode(@Param("search")Recommend recommend);
	
	

}
