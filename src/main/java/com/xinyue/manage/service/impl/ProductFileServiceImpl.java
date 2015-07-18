package com.xinyue.manage.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xinyue.manage.dao.ProductFileDao;
import com.xinyue.manage.model.ProductFile;
import com.xinyue.manage.service.ProductFileService;

/**
 * 
 * @author wenhai.you
 * @2015年5月27日
 * @下午3:52:27
 */
@Service("productFileService")
public class ProductFileServiceImpl implements ProductFileService {

	@Autowired
	private ProductFileDao pfdao;
	private Logger logger = Logger.getLogger(ProductFileServiceImpl.class);
	@Override
	public boolean addProductFile(ProductFile pfile) {
		// TODO Auto-generated method stub
		try {
			pfdao.addProductFile(pfile);
			logger.info("添加产品文件成功,数据为:"+pfile);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("添加失败,数据为:"+pfile, e);
			return false;
		}
	}

	

	@Override
	public boolean delProductFile(String id , String modifyUser) {
		// TODO Auto-generated method stub
		try {
			pfdao.delProductFile(id,modifyUser);
			logger.info("删除产品文件成功,id:"+id+",删除者为"+modifyUser);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("删除失败,id:"+id+",删除者为"+modifyUser, e);
			return false;
		}
	}

}
