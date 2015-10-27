package com.xinyue.manage.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.xinyue.manage.beans.SelectInfo;
import com.xinyue.manage.dao.FastProductDAO;
import com.xinyue.manage.model.FastProduct;
import com.xinyue.manage.model.FastProductApplicant;
import com.xinyue.manage.model.FastProductCompany;
import com.xinyue.manage.service.FastProductService;
import com.xinyue.manage.util.GlobalConstant;
/**
 * 
 * @author lzc
 * @date 2015年6月26日
 */
@Service
public class FastProductServiceImpl implements FastProductService{
	@Resource
	private FastProductDAO fastProductDAO;
	
	Logger logger  = Logger.getLogger(getClass());
	
	@Override
	public List<FastProduct> getListByPage(FastProduct fastProduct, int pageNo,
			int pageSize) {
		// TODO Auto-generated method stub
		return fastProductDAO.getListByPage(fastProduct, pageNo * pageSize, pageSize, GlobalConstant.ORDER_STATUS);
	}

	@Override
	public FastProduct getFastProduct(String id) {
		// TODO Auto-generated method stub
		return fastProductDAO.getFastProduct(id, GlobalConstant.ORDER_STATUS);
	}

	@Override
	public int countFastProduct(FastProduct fastProduct) {
		// TODO Auto-generated method stub
		return fastProductDAO.countFastProduct(fastProduct);
	}

	@Override
	public List<SelectInfo> getStatus(String typeCode) {
		// TODO Auto-generated method stub
		return fastProductDAO.getStatus(typeCode);
	}
	/**
	 *
	 * 修改快速贷款状态
	 */
	@Override
	public boolean updateFastProductStatus(FastProduct fastProduct, String name) {
		// TODO Auto-generated method stub
		try {
			fastProductDAO.modifiedFastProductStatus(name, fastProduct);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.error(e.toString());
			throw new RuntimeException();
		}
	}

	@Override
	public boolean updateFastProductStatusList(List<String> idList,
			String status, String modifiedId) {
		// TODO Auto-generated method stub
		try {
			fastProductDAO.updateFastProductStatusList(idList, status, modifiedId);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException();
		}
		return true;
	}

	@Override
	public boolean saveFastOrder(FastProduct fastLoanInfo) {
		
		try {
			//生成订单号
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMddsss");
			String orderId = "2"+dateFormat.format(new Date());
			
			fastLoanInfo.setId(UUID.randomUUID().toString().replace("-", ""));
			fastLoanInfo.setCode(orderId);
			
			//add by lzc
			fastLoanInfo.setType("1");
			
			int result = fastProductDAO.saveFastOrder(fastLoanInfo);
			if (result > 0) {
				return true;
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return false;
	}

	@Override
	public List<FastProduct> getListWithProduct(FastProduct fastProduct,
			int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return fastProductDAO.getListWithProduct(fastProduct, pageNo, pageSize);
	}

	@Override
	public int countListWithProduct(FastProduct fastProduct) {
		// TODO Auto-generated method stub
		return fastProductDAO.countListWithProduct(fastProduct);
	}

	@Override
	public FastProductApplicant getApplicant(String id) {
		// TODO Auto-generated method stub
		return fastProductDAO.getApplicant(id);
	}

	@Override
	public FastProductCompany getCompany(String id) {
		// TODO Auto-generated method stub
		return fastProductDAO.getCompany(id);
	}


}
