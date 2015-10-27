package com.xinyue.manage.service;

import java.util.List;

import com.xinyue.manage.beans.Recommend;

/**推荐
 * author lzc
 */
public interface RecommendService {
	
	
	/**获取推荐信贷经理列表
	 * add by lzc     date: 2015年10月10日
	 * @param recommend 搜索条件
	 * @return
	 */
	public List<Recommend> getRecommendCreditByCondition(Recommend recommend, int pageNo, int pageSize);
	
	public int countRecommendCreditByCondition(Recommend recommend);
	
	
	/**获取推荐普通会员推广列表
	 * add by lzc     date: 2015年10月12日
	 * @param recommend 搜索条件
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<Recommend> getRecommendMemberByCondition(Recommend recommend, int pageNo, int pageSize);
	
	
	public int countRecommendMemberByCondition(Recommend recommend);
	

}
