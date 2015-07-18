package com.xinyue.manage.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xinyue.manage.beans.ProductInfo;
import com.xinyue.manage.dao.ProductDao;
import com.xinyue.manage.dao.ProductFileDao;
import com.xinyue.manage.model.Product;
import com.xinyue.manage.model.ProductFile;
import com.xinyue.manage.service.ProductService;
import com.xinyue.manage.util.GlobalConstant;

/**
 * 
 * @author wenhai.you
 * @2015年5月22日
 * @下午6:30:18
 */
@Service("productService")
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao pdao;
	@Autowired
	private ProductFileDao pfdao;
	
	private Logger logger = Logger.getLogger(ProductServiceImpl.class);
	@Override
	public List<Product> findList(ProductInfo pinfo) {
		// TODO Auto-generated method stub
		return pdao.findList(pinfo);
	}
	
	
	@Override
	public int getCount(ProductInfo pinfo) {
		// TODO Auto-generated method stub
		return pdao.getCount(pinfo);
	}
	
	@Override
	public Product getProductById(String id) {
		// TODO Auto-generated method stub
		return pdao.getProductById(id);
	}
	
	@Override
	public boolean updateShelve(List<String> list, String modifyUser) {
		// TODO Auto-generated method stub
		try {
			pdao.updateShelve(list , modifyUser);
			logger.info("产品上架成功,数据为:"+list+",上架者为:"+modifyUser);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("产品上架失败,数据为:"+list+",上架者为:"+modifyUser, e);
			return false;
		}
	}
	
	@Override
	public boolean updateUnShelve(List<String> list, String modifyUser) {
		// TODO Auto-generated method stub
		try {
			pdao.updateUnShelve(list , modifyUser);
			logger.info("产品下架成功,数据为:"+list+",下架者为:"+modifyUser);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("产品下架失败,数据为:"+list+",下架者为:"+modifyUser, e);
			return false;
		}
	}
	

	
	public void saveProduct(Product pro , String user){
		try {
			if(GlobalConstant.isNull(pro.getId())){
				
				pro.setCreateUser(user);
				SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssms");
				String code = new StringBuffer(df.format(new java.sql.Date(System.currentTimeMillis()))).toString();
				
				pro.setCode(code);
				pdao.addProduct(pro);
				List<ProductFile> file = pro.getFile();
				for (int i = 0; i < file.size(); i++) {
					ProductFile pf = file.get(i);
					pf.setParentid(pro.getId());
					pf.setCreateUser(user);
					pfdao.addProductFile(pf);
					logger.info("添加产品成功,数据为:"+pro+",添加产品文件为"+pf+"保存者为:"+user);
				}
			}else{
				pro.setCreateUser(user);
				pdao.updateProduct(pro);
				List<ProductFile> file = pro.getFile();
				for (int i = 0; i < file.size(); i++) {
					ProductFile pf = file.get(i);
					pf.setParentid(pro.getId());
					pf.setCreateUser(user);
					pfdao.addProductFile(pf);
					logger.info("修改产品,数据为:"+pro+",添加产品文件为"+pf+"保存者为:"+user);
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("产品保存失败,数据为:"+pro+",保存者为:"+user, e);
			throw new RuntimeException("产品保存失败", e);
		}
	}


	@Override
	public List<Product> getListByRecommend(String Recommend) {
		// TODO Auto-generated method stub
		return pdao.getListByRecommend(Recommend);
	}
	
}
