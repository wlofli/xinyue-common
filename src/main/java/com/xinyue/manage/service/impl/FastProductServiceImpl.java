package com.xinyue.manage.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.xinyue.manage.beans.SelectInfo;
import com.xinyue.manage.dao.FastProductDAO;
import com.xinyue.manage.model.FastProduct;
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
			logger.info(e.toString());
			throw new RuntimeException();
		}
		
		
	}

}
