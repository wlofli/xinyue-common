package com.xinyue.manage.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xinyue.manage.beans.Recommend;
import com.xinyue.manage.dao.RecommendDAO;
import com.xinyue.manage.service.RecommendService;

/**
 * author lzc
 */
@Service
public class RecommendsServiceImpl implements RecommendService {
	
	@Resource
	private RecommendDAO recommendDAO;

	@Override
	public List<Recommend> getRecommendCreditByCondition(Recommend recommend,
			int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return recommendDAO.getRecommendCreditByInvitedCode(recommend, pageNo, pageSize);
	}

	@Override
	public int countRecommendCreditByCondition(Recommend recommend) {
		// TODO Auto-generated method stub
		return recommendDAO.countRecommendCreditByInvitedCode(recommend);
	}

	@Override
	public List<Recommend> getRecommendMemberByCondition(Recommend recommend,
			int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return recommendDAO.getRecommendMemberByInvitedCode(recommend, pageNo, pageSize);
	}

	@Override
	public int countRecommendMemberByCondition(Recommend recommend) {
		// TODO Auto-generated method stub
		return recommendDAO.countRecommendMemberByInvitedCode(recommend);
	}

}
