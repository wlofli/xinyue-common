package com.xinyue.manage.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xinyue.manage.beans.ProductTypeInfo;
import com.xinyue.manage.dao.ProductTypeDao;
import com.xinyue.manage.model.ProductType;
import com.xinyue.manage.service.ProductTypeService;
import com.xinyue.manage.util.GlobalConstant;

/**
 * 
 * @author wenhai.you
 * @2015年5月23日
 * @下午2:22:55
 */
@Service("productTypeService")
public class ProductTypeServiceImpl implements ProductTypeService {

	@Autowired
	private ProductTypeDao ptdao;
	private Logger logger = Logger.getLogger(ProductTypeServiceImpl.class);
	@Override
	public List<ProductType> findProductTypeList() {
		// TODO Auto-generated method stub
		return ptdao.findProductTypeList();
	}

	@Override
	public List<ProductType> findTypeFirst(ProductTypeInfo pt) {
		// TODO Auto-generated method stub
		return ptdao.findTypeFirst(pt);
	}
	
	@Override
	public List<ProductType> findTypeSecond(ProductTypeInfo pt) {
		// TODO Auto-generated method stub
		return ptdao.findTypeSecond(pt);
	}
	
	@Override
	public int getTypeFirstCount() {
		// TODO Auto-generated method stub
		return ptdao.getTypeFirstCount();
	}
	
	@Override
	public int getTypeSecondCount() {
		// TODO Auto-generated method stub
		return ptdao.getTypeSecondCount();
	}
	
	
	@Override
	public void delProductType(String id , String modifyUser) {
		// TODO Auto-generated method stub
		try {
			ptdao.delProductType(id,modifyUser);
			ptdao.updateProductByType(id,modifyUser);
			logger.info("删除产品类型和更新产品成功 , 产品类型id:"+id+",删除者为:"+modifyUser);
		} catch (Exception e) {
			logger.error("删除产品类型和更新产品失败 , 产品类型id:"+id+",删除者为:"+modifyUser, e);
			throw new RuntimeException("删除产品类型失败", e);
		}
	}
	
	
	@Override
	public ProductType findTypeById(String id) {
		// TODO Auto-generated method stub
		return ptdao.findTypeById(id);
	}
	
	@Override
	public boolean enableProductType(String id, String modifyUser) {
		// TODO Auto-generated method stub
		try {
			ptdao.enableProductType(id,modifyUser);
			logger.info("产品类型启用成功, 产品类型id:"+id+",启用者为:"+modifyUser);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("产品类型启用失败, 产品类型id:"+id+",启用者为:"+modifyUser, e);
			return false;
		}
	}
	
	@Override
	public boolean unenableProductType(String id, String modifyUser) {
		// TODO Auto-generated method stub
		try {
			ptdao.unenableProductType(id,modifyUser);
			logger.info("产品类型禁用成功, 产品类型id:"+id+",启用者为:"+modifyUser);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("产品类型禁用失败, 产品类型id:"+id+",启用者为:"+modifyUser, e);
			return false;
		}
	}
	@Override
	public boolean saveProductType(ProductType ptype , String user) {
		// TODO Auto-generated method stub
		try {
			if(GlobalConstant.isNull(ptype.getId())){
				
				ptype.setCreateUser(user);
				ptdao.addTypeFirst(ptype);
				logger.info("添加产品类型成功"+ptype+", 添加者:"+user);
			}else{
				
				ptype.setModifyUser(user);
				ptdao.updateProductType(ptype);
				logger.info("修改产品类型成功"+ptype+", 修改者:"+user);
			}
			return true;
		} catch (Exception e) {
			logger.error("产品类型保存失败"+ptype+", 保存者:"+user, e);
			return false;
		}
		
	}
	
	@Override
	public List<ProductType> findTypeFirstList() {
		// TODO Auto-generated method stub
		return ptdao.findTypeFirstList();
	}
}