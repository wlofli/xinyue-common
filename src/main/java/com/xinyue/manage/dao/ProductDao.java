package com.xinyue.manage.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xinyue.manage.beans.ProductInfo;
import com.xinyue.manage.beans.SelectInfo;
import com.xinyue.manage.model.Product;
import com.xinyue.manage.model.ProductContent;
import com.xinyue.manage.model.ProductFile;
import com.xinyue.manage.model.ProductType;

/**
 * 
 * @author wenhai.you
 * @2015年5月22日
 * @下午6:25:51
 */
public interface ProductDao {

	
	
	
	
	/**
	 * 更新上架时间
	 * @param list
	 */
	public void updateShelve(@Param("list") List<String> list , @Param("modifyUser") String modifyUser);
	
	
	/**
	 * 更新下架时间
	 * @param list
	 */
	public void updateUnShelve(@Param("list") List<String> list, @Param("modifyUser") String modifyUser);
	
	public List<ProductFile> findProductFileList(@Param("id")String pid);
	
	
	
	
	
	
	
	/**
	 * 根据推荐标志获取产品信息
	 * add by lzc
	 * date: 2015年7月16日
	 * @param recommend 
	 * @return
	 */
	public List<Product> getListByRecommend(@Param("recommend")String recommend);

	/**
	 * 根据信贷经理查找产品(1)
	 * add by maozj
	 * @param managerId
	 * @return
	 */
	public List<SelectInfo> findProductsManagerId(String managerId);

	/**
	 * 根据信贷经理查找产品(2)
	 * add by maozj
	 * @param map
	 * @return
	 */
	public List<Product> getProductsByManagerId(HashMap<String,Object> map);

	/**
	 * 根据信贷经理id查询产品数量
	 * add by maozj
	 * @param managerId
	 * @return
	 */
	public int getProductsCountByManagerId(String managerId);
	
	
	
	//2015-09-11 ywh 以后 
	/**
	 * ywh 根据查询条件返回产品列表
	 * @param pinfo
	 * @return
	 */
	public List<Product> findProList(ProductInfo pinfo);
	
	/**
	 * ywh 根据查询条件返回记录数
	 * @param pinfo
	 * @return
	 */
	public int getProCount(ProductInfo pinfo);
	

	/**
	 * ywh 
	 * 根据产品标识符显示产品详情 后台
	 * @param id
	 * @return
	 */
	public Product getProductById(String id);
	
	
	/**
	 * ywh 后台 前台都可用根据产品标识符 加载选项设置
	 * @return
	 */
	public ProductContent findOptionByProductid(String productid);
	
	
	/**
	 * ywh 保存选项设置
	 * @param pc
	 */
	public void saveOption(ProductContent pc);
	
	
	
	/**
	 * ywh 修改选项设置
	 * @param pc
	 */
	public void updateOption(ProductContent pc);
	
	
	/**
	 * ywh 添加产品
	 * @param pro
	 */
	public void addProduct(Product pro);
	
	
	/**
	 * ywh 修改产品
	 * @param pro
	 */
	public void updateProduct(Product pro);
	
	
	/**
	 * ywh 自动更新产品状态  待上架   上架中   已下架
	 */
	public void updateStatus();
	
	/**
	 * ywh 删除产品 
	 * @param listproductid
	 * @param modifyUser
	 */
	public void delPro(@Param("list")List<String> listproductid , @Param("modifyUser")String modifyUser);
	
	
	/**
	 * ywh 机构管理 店铺设置产品列表
	 * @param pc
	 * @return
	 */
	public List<Product> getProductByOrgid(ProductInfo pc);
	
	/**
	 * ywh 机构管理 店铺设置产品列表
	 * @param pc
	 * @return
	 */
	public int getProductByOrgidCount(ProductInfo pc);
	
	
	/**
	 * ywh　前台使用产品详情　
	 * @param pid
	 * @return
	 */
	public Product findProductById(@Param("proid")String pid);
}
