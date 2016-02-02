package com.xinyue.manage.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.xinyue.manage.beans.PageData;
import com.xinyue.manage.beans.ProductInfo;
import com.xinyue.manage.beans.SelectInfo;
import com.xinyue.manage.model.Product;
import com.xinyue.manage.model.ProductContent;
import com.xinyue.manage.model.ProductType;
import com.xinyue.manage.util.CommonFunction;

/**
 * 
 * @author wenhai.you
 * @2015年5月22日
 * @下午6:29:11
 */
public interface ProductService {

	/**
	 * ywh 目的是兼容前台 以后若修改请不要调用 这个方法 请把dao引用到自己业务类里去
	 * @param pinfo
	 * @return
	 */
	public int getCount(ProductInfo pinfo);
	
	
	/**
	 * 更新上架时间
	 * @param list
	 */
	public boolean updateShelve(List<String> list, String modifyUser);
	
	
	/**
	 * 更新下架时间
	 * @param list
	 */
	public boolean updateUnShelve(List<String> list, String modifyUser);
	
	
	/**
	 * ywh 根据id查寻
	 * @param id
	 * @return
	 */
	public Product getProductById(String id);
	
	
	
	
	/**
	 * 
	 * add by lzc
	 * date: 2015年7月16日
	 * @param Recommend value->0 || 1
	 * @return
	 */
	public List<Product> getListByRecommend(String Recommend);
	
	/**获取产品类型下面的产品
	 * add by lzc     date: 2015年12月2日
	 * @param typeId 如果为父产品类型id,则包括所有子产品类型
	 * @param Recommend
	 * @return
	 */
	public List<Product> getListByType(String typeId, String Recommend, int pageNo, int pageSize);
	
	
	/**
	 * 根据信贷经理id查询对应产品
	 * add by maozj
	 * @param managerId 信贷经理id
	 * @return 
	 */
	public List<SelectInfo> findProductsManagerId(String managerId);

	/**
	 * 根据信贷经理id查询产品
	 * add by maozj
	 * @param managerId
	 * @return
	 */
	public List<Product> getProductsByManagerId(String managerId,int page);

	/**
	 * 根据信贷经理id查询产品数量
	 * add by maozj
	 * @param managerId
	 * @return
	 */
	public int getProductsCountByManagerId(String managerId);
	
	//2015-09-11 ywh 以后
	
	/**
	 * ywh 返回产品列表
	 * @param pinfo
	 * @return
	 */
	public PageData<Product> findPageData(ProductInfo pinfo);
	
	/**
	 * ywh 供后台调用 所有 机构
	 * @return
	 */
	public List<SelectInfo> getOrgs();
	
	/**
	 * ywh 后台 前台都可用根据产品标识符 加载选项设置
	 * @return
	 */
	public ProductContent findOptionByProductid(String productid);
	
	
	/**
	 * ywh 保存选项设置
	 * @param pc
	 */
	public boolean saveOption(ProductContent pc ,String loginName);
	
	
	/**
	 * ywh 产品图片临时上传
	 * @param suffix
	 * @param req
	 * @return
	 */
	public String upload(String suffix , HttpServletRequest req);
	public final static String TEMP_PATH = (new StringBuffer(CommonFunction.getValue("upload.path")).append("pro/temp/")).toString();
	public final static String DOWN_PATH = (new StringBuffer(CommonFunction.getValue("down.path")).append("moko/images/pro/temp/")).toString();
	public final static String REAL_PATH = CommonFunction.getValue("upload.path");
	public final static String SHOW_PATH = CommonFunction.getValue("down.path")+"moko/images/";
	
	/**
	 * ywh 保存产品
	 * @param pro
	 * @param user
	 */
	public void saveProduct(Product pro , String user);
	
	/**
	 * ywh 删除产品
	 * @param productid
	 * @param user
	 * @return
	 */
	public boolean delPro(List<String> productid, String user);
	
	
	/**
	 * ywh 机构管理 店铺设置产品列表
	 * @param pc
	 * @return
	 */
	public PageData<Product> findProductPageByOrgid(ProductInfo pc);
}
