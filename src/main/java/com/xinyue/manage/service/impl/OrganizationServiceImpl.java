package com.xinyue.manage.service.impl;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.xinyue.manage.beans.OrganizationInfo;
import com.xinyue.manage.beans.PageData;
import com.xinyue.manage.beans.SelectInfo;
import com.xinyue.manage.dao.CityStationDao;
import com.xinyue.manage.dao.OrganizationDao;
import com.xinyue.manage.dao.OrganizationTypeDao;
import com.xinyue.manage.dao.ProductTypeDao;
import com.xinyue.manage.model.LinkMan;
import com.xinyue.manage.model.Organization;
import com.xinyue.manage.model.OrganizationType;
import com.xinyue.manage.model.ProductType;
import com.xinyue.manage.model.SubStation;
import com.xinyue.manage.service.OrganizationService;
import com.xinyue.manage.util.GlobalConstant;
import com.xinyue.manage.util.PinYin;

/**
 * 
 * @author wenhai.you
 * @2015年5月16日
 * @下午2:26:07
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {

	
	@Autowired
	private OrganizationDao orgDao;
	
	private Logger logger = Logger.getLogger(OrganizationServiceImpl.class);

	
	@Override
	public boolean updateDisable(List<String> list, String modifyUser) {
		// TODO Auto-generated method stub
		try {
			orgDao.updateDisable(list, modifyUser);
			logger.info("机构禁用成功,操作者为:"+modifyUser);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("机构禁用失败,操作者为:"+modifyUser, e);
			return false;
		}
	}
	
	@Override
	public boolean updateEnable(List<String> list, String modifyUser) {
		// TODO Auto-generated method stub
		try {
			orgDao.updateEnable(list, modifyUser);
			logger.info("机构启用成功,操作者为:"+modifyUser);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("机构启用失败,操作者为:"+modifyUser, e);
			return false;
		}
	}
	@Override
	public boolean updateMarker(List<String> list, String modifyUser) {
		// TODO Auto-generated method stub
		try {
			orgDao.updateMarker(list, modifyUser);
			logger.info("机构删除成功 ,操作者为:"+modifyUser);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("机构删除失败,操作者为:"+modifyUser, e);
			return false;
		}
	}
	
	
	@Override
	public boolean saveOrg(String orgedit, String loginName) {
		// TODO Auto-generated method stub
		try {
			JSONObject jsonObj = JSONObject.fromObject(orgedit);
			Map<String, Class> map = new HashMap<String, Class>();
			map.put("linkman", LinkMan.class);
			Organization org = (Organization)JSONObject.toBean(jsonObj	, Organization.class , map);
			org.setPinyin(PinYin.spellTone(org.getName()));
			if(!GlobalConstant.isNull(org.getId())){
				//修改机构人信息
				orgDao.updateOrg(org, loginName);
				logger.info("修改机构人信息 , 修改者为:"+loginName);
			}else{
				//添加机构人信息
				SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssms");
				String code = new StringBuffer(df.format(new java.sql.Date(System.currentTimeMillis()))).toString();
				org.setNumber(code);
				orgDao.addOrg(org, loginName);
				logger.info("添加机构人信息 , 添加者为:"+loginName);
			}
			//添加 或修改机构联系人信息
			List<LinkMan> linkman = org.getLinkman();
			for (LinkMan lk : linkman) {
				if(GlobalConstant.isNull(lk.getId()) || 0==lk.getId()){
					lk.setOrgid(org.getId());
					orgDao.addOrgLinkMan(lk);
					logger.info("添加机构联系人信息,添加者为:"+loginName);
				}else{
					orgDao.updateOrgLinkMan(lk);
					logger.info("修改机构联系人信息,修改者为:"+loginName);
				}
			}
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException("添加或修改机构信息和添加或修改联系人信息失败", e);
		}
		
	}
	

	
	@Override
	public List<Organization> findOrgNameByPinying(String pinying) {
		// TODO Auto-generated method stub
		return orgDao.findOrgNameByPinying(pinying);
	}

	@Override
	public List<SelectInfo> getOrganizations() {
		return orgDao.getOrganizations();
	}
	
	@Override
	public Organization findShop(String orgid) {
		// TODO Auto-generated method stub
		return orgDao.findShop(orgid);
	}
	
	@Resource
	private CityStationDao cdao;
	
	@Override
	public List<SubStation> findAll() {
		// TODO Auto-generated method stub
		return cdao.findAll();
	}
	
	@Resource
	private ProductTypeDao pdao;
	
	@Override
	public List<ProductType> findProductTypeByList() {
		// TODO Auto-generated method stub
		return pdao.findProductTypeByList();
	}
	
	
	//2015-09-07
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
				String code = new StringBuffer(df.format(new java.sql.Date(System.currentTimeMillis()))).toString();
				MultipartFile file = multiRequest.getFile(fileName);
				
				File uploadFile = new File(TEMP_PATH+code+"."+suffix);
								
				try {
					FileCopyUtils.copy(file.getBytes(), uploadFile);
					String retPath = DOWN_PATH+code+"."+suffix;
					
					return "{'name':'"+code+"."+suffix+"','path':'"+_filterStr(retPath)+"'}";
				} catch (Exception e) {
					logger.error("上传机构图片失败", e);
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
	
	@Override
	public boolean checkDomain(String orgid ,String domain) {
		// TODO Auto-generated method stub
		Organization org = orgDao.checkOrgNameOrDomain(orgid ,domain, null);
		if(GlobalConstant.isNull(org)){
			return true;
		}
		return false;
	}
	@Override
	public boolean saveShop(Organization org, String loginName) {
		// TODO Auto-generated method stub
		try {
			//删除业务区域
			orgDao.delOrgStation(org.getId());
			//添加业务区域
			List<String> stat = org.getStatid();
			if(!GlobalConstant.isNull(stat)){
				orgDao.addOrgStation(org.getId(), stat);
			}
			
			//删除擅长业务
			orgDao.delOrgProType(org.getId());
			//添加擅长业务
			List<String> ptype = org.getPtypeid();
			if(!GlobalConstant.isNull(ptype)){
				orgDao.addOrgProType(org.getId(), ptype);
			}
			
			String image = org.getImage();
			String tempImg = TEMP_PATH + image;
			String realImg = REAL_PATH + "org/" + image;
			File pathFile = new File(REAL_PATH + "org/");
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
			orgDao.updateOrg(org, loginName);
			logger.info("机构店铺信息修改成功 ,编辑者为:"+loginName);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("机构店铺信息修改失败,编辑者为:"+loginName, e);
			throw new RuntimeException("机构店铺信息修改失败  回滚  ", e);
		}
		
	}
	
	@Override
	public boolean saveShopcontent(Organization org, String loginName) {
		// TODO Auto-generated method stub
		try {
			orgDao.updateOrg(org, loginName);
			logger.info("机构店铺内容信息修改成功 ,编辑者为:"+loginName);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("机构店铺内容信息修改失败,编辑者为:"+loginName, e);
			return false;
		}
	}
	
	@Resource
	private OrganizationTypeDao otdao;
	@Override
	public List<OrganizationType> findOrgTypeAll() {
		// TODO Auto-generated method stub
		return otdao.findTypes();
	}
	
	@Override
	public PageData<Organization> findPageData(OrganizationInfo orgInfo) {
		// TODO Auto-generated method stub
		int total = orgDao.getOrgCount(orgInfo);
		String topage = orgInfo.getTopage();
		int currentPage = (GlobalConstant.isNull(topage) || "0".equals(topage))?1:Integer.valueOf(topage);
		int start = (currentPage-1)*GlobalConstant.PAGE_SIZE;
		return new PageData<Organization>(orgDao.findOrgList(orgInfo , start , GlobalConstant.PAGE_SIZE ), total, currentPage);
	}

}
