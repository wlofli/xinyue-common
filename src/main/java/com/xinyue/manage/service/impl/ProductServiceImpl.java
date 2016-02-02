package com.xinyue.manage.service.impl;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.xinyue.manage.beans.PageData;
import com.xinyue.manage.beans.ProductInfo;
import com.xinyue.manage.beans.SelectInfo;
import com.xinyue.manage.dao.OrganizationDao;
import com.xinyue.manage.dao.ProductDao;
import com.xinyue.manage.dao.ProductFileDao;
import com.xinyue.manage.model.Product;
import com.xinyue.manage.model.ProductContent;
import com.xinyue.manage.model.ProductFile;
import com.xinyue.manage.model.ProductType;
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
	public Product getProductById(String id) {
		// TODO Auto-generated method stub
		return pdao.getProductById(id);
	}
	
	@Override
	public boolean updateShelve(List<String> list, String modifyUser) {
		// TODO Auto-generated method stub
		try {
			pdao.updateShelve(list , modifyUser);
			logger.info("产品上架成功,上架者为:"+modifyUser);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("产品上架失败,上架者为:"+modifyUser, e);
			return false;
		}
	}
	
	@Override
	public boolean updateUnShelve(List<String> list, String modifyUser) {
		// TODO Auto-generated method stub
		try {
			pdao.updateUnShelve(list , modifyUser);
			logger.info("产品下架成功,下架者为:"+modifyUser);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("产品下架失败,下架者为:"+modifyUser, e);
			return false;
		}
	}
	

	
	


	@Override
	public List<Product> getListByRecommend(String Recommend) {
		// TODO Auto-generated method stub
		return pdao.getListByRecommend(Recommend);
	}


	@Override
	public List<SelectInfo> findProductsManagerId(String managerId) {
		
		return pdao.findProductsManagerId(managerId);
	}


	@Override
	public List<Product> getProductsByManagerId(String managerId,int page) {
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("managerId", managerId);
		map.put("index", page-1);
		
		return pdao.getProductsByManagerId(map);
	}


	@Override
	public int getProductsCountByManagerId(String managerId) {
		
		return pdao.getProductsCountByManagerId(managerId);
	}
	
	
	// ywh 2015-09-13
	@Override
	public PageData<Product> findPageData(ProductInfo pinfo) {
		// TODO Auto-generated method stub
		String topage = pinfo.getTopage();
		int currentPage = (GlobalConstant.isNull(topage)|| topage.equals("0"))?1:Integer.valueOf(topage);
		pinfo.setStart((currentPage-1)*GlobalConstant.PAGE_SIZE);
		return new PageData<Product>(pdao.findProList(pinfo), pdao.getProCount(pinfo), currentPage);
	}
	
	@Override
	public int getCount(ProductInfo pinfo) {
		// TODO Auto-generated method stub
		return pdao.getProCount(pinfo);
	}
	
	@Resource
	private OrganizationDao odao;
	@Override
	public List<SelectInfo> getOrgs() {
		// TODO Auto-generated method stub
		return odao.getOrgs();
	}
	
	
	@Override
	public ProductContent findOptionByProductid(String productid) {
		// TODO Auto-generated method stub
		return pdao.findOptionByProductid(productid);
	}
	
	
	@Override
	public boolean saveOption(ProductContent pc , String loginName) {
		// TODO Auto-generated method stub
		
		ProductContent p = pdao.findOptionByProductid(pc.getProductcode());
		if(GlobalConstant.isNull(p)){
			try {
				pdao.saveOption(pc);
				logger.info("产品选项添加成功,添加者为:"+loginName);
				return true;
			} catch (Exception e) {
				// TODO: handle exception
				logger.error("产品选项添加失败 ,添加者为:"+loginName, e);
				return false;
			}
		}else{
			try {
				pdao.updateOption(pc);
				logger.info("产品选项修改成功,修改者为:"+loginName);
				return true;
			} catch (Exception e) {
				// TODO: handle exception
				logger.error("产品选项修改失败 ,修改者为:"+loginName, e);
				return false;
			}
		}
	}
	
	
	@Override
	public String upload(String suffix, HttpServletRequest req) {
		// TODO Auto-generated method stub
		File dir = new File(TEMP_PATH);
		if(!dir.exists()){
			dir.mkdirs();
		}
		CommonsMultipartResolver resolver = new CommonsMultipartResolver(req.getServletContext());
		
		if (resolver.isMultipart(req)) {
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) req;
			
			Iterator<String> iter = multiRequest.getFileNames();

			while (iter.hasNext()) {
				String fileName = iter.next();
				SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssms");
				String code = df.format(new java.sql.Date(System.currentTimeMillis()));
				MultipartFile file = multiRequest.getFile(fileName);
				
				File uploadFile = new File(TEMP_PATH+code+"."+suffix);
								
				try {
					FileCopyUtils.copy(file.getBytes(), uploadFile);
					String retPath = DOWN_PATH+code+"."+suffix;
					
					return "{'name':'"+code+"."+suffix+"','path':'"+_filterStr(retPath)+"'}";
				} catch (Exception e) {
					logger.error("上传产品图片失败", e);
					return "fail";
				}
			}
		}
		return "fail";
	}
	
	private String _filterStr(String s) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {

			char c = s.charAt(i);
			switch (c) {
			case '\"':
				sb.append("\\\"");
				break;
			case '\\':
				sb.append("\\\\");
				break;
			case '/':
				sb.append("\\/");
				break;
			case '\b':
				sb.append("\\b");
				break;
			case '\f':
				sb.append("\\f");
				break;
			case '\n':
				sb.append("\\n");
				break;
			case '\r':
				sb.append("\\r");
				break;
			case '\t':
				sb.append("\\t");
				break;
			default:
				sb.append(c);
			}
		}
		return sb.toString();
	}
	
	
	public void saveProduct(Product pro , String user){
		try {
			if(GlobalConstant.isNull(pro.getId())){
				
				String image = pro.getLogo();
				String tempImg = TEMP_PATH + image;
				String realImg = REAL_PATH + "pro/" + image;
				File pathFile = new File(REAL_PATH + "pro/");
				if (!pathFile.exists()) {
					pathFile.mkdirs();
				}
				File tempFile =  new File(tempImg);
				File realFile =  new File(realImg);
				
				try {
					FileCopyUtils.copy(tempFile, realFile);
				} catch (IOException e) {
					logger.error(e.getMessage() ,e);
					e.printStackTrace();
				}
				
				pro.setCreateUser(user);
				SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssms");
				String code = df.format(new java.sql.Date(System.currentTimeMillis()));
				
				pro.setCode(code);
				pro.setCreateUser(user);
				pdao.addProduct(pro);
				List<ProductFile> file = pro.getFile();
				for (int i = 0; i < file.size(); i++) {
					ProductFile pf = file.get(i);
					pf.setParentid(pro.getId());
					pf.setCreateUser(user);
					pfdao.addProductFile(pf);
					
				}
				logger.info("添加产品和产品文件成功,保存者为:"+user);
			}else{
				pro.setCreateUser(user);
				pdao.updateProduct(pro);
				List<ProductFile> file = pro.getFile();
				for (int i = 0; i < file.size(); i++) {
					ProductFile pf = file.get(i);
					pf.setParentid(pro.getId());
					pf.setCreateUser(user);
					pfdao.addProductFile(pf);
					
				}
				logger.info("修改产品和产品文件成功,保存者为:"+user);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("产品和产品文件保存失败 ,保存者为:"+user, e);
			throw new RuntimeException("产品保存失败", e);
		}
	}
	
	@Override
	public boolean delPro(List<String> productid, String user) {
		// TODO Auto-generated method stub
		try {
			pdao.delPro(productid , user);
			logger.info("删除产品成功,删除者为:"+user);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("删除产品失败 ,删除者为:"+user, e);
			return false;
		}
	}
	
	@Override
	public PageData<Product> findProductPageByOrgid(ProductInfo pc) {
		// TODO Auto-generated method stub
		String topage = pc.getTopage();
		int currentPage = (GlobalConstant.isNull(topage) || "0".equals(topage))?1:Integer.valueOf(topage);
		int start = (currentPage-1)*GlobalConstant.PAGE_SIZE;
		pc.setStart(start);
		return new PageData<Product>(pdao.getProductByOrgid(pc), pdao.getProductByOrgidCount(pc), currentPage);
	}

	@Override
	public List<Product> getListByType(String typeId, String Recommend,
			int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return pdao.getListByType(typeId, Recommend, pageNo, pageSize);
	}
}
