package com.xinyue.manage.service.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.xinyue.manage.beans.PageData;
import com.xinyue.manage.beans.SuccessCaseSearch;
import com.xinyue.manage.dao.SuccessCaseDAO;
import com.xinyue.manage.model.SuccessCase;
import com.xinyue.manage.service.SuccessCaseService;

@Service
public class SuccessCaseServiceImpl implements SuccessCaseService {

	@Resource
	private SuccessCaseDAO successCaseDAO;
	
	private Logger log = Logger.getLogger(SuccessCaseServiceImpl.class);
	
	@Override
	public List<SuccessCase> findSuccessCasesByManagerId(String managerId) {
		
		DecimalFormat df = new DecimalFormat("######0");
		List<SuccessCase> result = null;
		
		List<SuccessCase> cases = successCaseDAO.findSuccessCasesByManagerId(managerId);
		
		//数据整理
		if (cases != null && cases.size() > 0) {
			result = new ArrayList<SuccessCase>();
			for (SuccessCase successCase : cases) {
				successCase.setLoanAmount(df.format(Double.parseDouble(successCase.getLoanAmount())));
				result.add(successCase);
			}
		}
		
		return result;
	}

	@Override
	public PageData<SuccessCase> findSuccessCaseList(SuccessCaseSearch search) {
		
		PageData<SuccessCase> data = null;
		try {
			//总条数
			int allCount = successCaseDAO.getCountByManagerId(search);
			
			//记录
			search.setIndex(search.getIndex()*10);
			List<SuccessCase> cases = successCaseDAO.getSuccessCaseList(search);
			
			data = new PageData<>(cases, allCount, search.getIndex()+1);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
		return data;
	}

	@Override
	public boolean deleteCaseById(String caseIds,String managerId) {
		try {
			String[] temps = caseIds.split("~");
			
			List<String> ids = new ArrayList<>();
			for (int i = 0; i < temps.length; i++) {
				ids.add(temps[i]);
			}
			
			int result = successCaseDAO.deleteCaseById(ids,managerId);
			
			if (result > 0) {
				return true;
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return false;
	}

	@Override
	public SuccessCase getSuccessCaseByCaseId(String caseId) {
		
		return successCaseDAO.getSuccessCaseByCaseId(caseId);
	}

	@Override
	public boolean saveCase(SuccessCase caseInfo) {
		
		int result = 0;
		try {
			if (caseInfo.getId().equals("")) {
				//新增
				String id = UUID.randomUUID().toString().replace("-", "");
				caseInfo.setId(id);
				result = successCaseDAO.addCase(caseInfo);
			}else {
				//更新
				result = successCaseDAO.updateCase(caseInfo);
			}
			
			if (result > 0) {
				return true;
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return false;
	}

}
