package com.xinyue.authe;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class OptionInfo {
	
	/**
	 * 判断用户是否有权限
	 * @param uid  用户 id
	 * @param gid  用户组id 列表   gid = -999  为管理员
	 * @return
	 */
	public boolean checkAuthe(int uid,int[] gid){
		if (isPublic)
			return true;
		if (gid!=null){
			boolean gre = false;
			for (int i=0;i<gid.length;i++){
				int re = chkGroup(gid[i]);
				if (re==-1)
					return false;
				else if (re==1)
					gre = true;
			}
			if (gre)
				return true;
		}
		
		return chkUser(uid)==1;
	}
	
	/**
	 * 添加权限记录到数据库
	 * @throws Exception
	 */
	public void add()throws Exception{
		if (optionId==null||optionId.equals(""))
			throw new Exception("optionid is null");
		
		int iPage = 0;
		if (isPage == true)
			iPage = 1;
		
		SqlSessionFactory sessionFactory =   AutheManage.getSqlSession();
		SqlSession session = sessionFactory.openSession();
		AutheMapper mapper = session.getMapper(AutheMapper.class);
		int re = mapper.saveOption(optionId, iPage);
		session.close();
	}
	
	/**
	 * 保存权限信息到数据库
	 * @throws Exception
	 */
	public void save()throws Exception{
		if (optionId==null||optionId.equals(""))
			throw new Exception("optionid is null");
		
		String aUserList = "";
		String aGroupList = "";
		String rUserList = "";
		String rGroupList = "";
		
		if (allowUserList!=null){
			for (int i=0;i<allowUserList.length;i++){
				if (i>0)
					aUserList += ",";
				aUserList += allowUserList[i];
			}
		}
		
		if (allowGroupList != null){
			for (int i=0;i<allowGroupList.length;i++){
				if (i>0)
					aGroupList += ",";
				aGroupList += allowGroupList[i];
			}
		}
		
		if (refuseUserList!=null){
			for (int i=0;i<refuseUserList.length;i++){
				if (i>0)
					rUserList += ",";
				rUserList += refuseUserList[i];
			}
		}
		
		if (refuseGroupList!=null){
			for (int i=0;i<refuseGroupList.length;i++){
				if (i>0)
					rGroupList += ",";
				rGroupList += refuseGroupList[i];
			}
		}
		
		SqlSessionFactory sessionFactory =   AutheManage.getSqlSession();
		SqlSession session = sessionFactory.openSession();
		AutheMapper mapper = session.getMapper(AutheMapper.class);
		int re = mapper.updateOption(optionId, aUserList, aGroupList, rUserList, rGroupList);
		session.close();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOptionId() {
		return optionId;
	}
	public void setOptionId(String optionId) {
		this.optionId = optionId;
	}
	public boolean isPage() {
		return isPage;
	}
	public void setPage(boolean isPage) {
		this.isPage = isPage;
	}
	
	
	
	public boolean isPublic() {
		return isPublic;
	}

	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}

	public void autheOpid(boolean isAllow, boolean isGroup,boolean isAdd, int id)throws Exception{
		int[] srcList = null;
		int[] outList = null;
		if (isAllow){
			if (isGroup){
				srcList  = allowGroupList;
			}
			else{
				srcList = allowUserList;
			}
			
		}
		else{
			if (isGroup){
				srcList = refuseGroupList;
			}
			else{
				srcList = refuseUserList;
			}
		}
		
		boolean set = false;
		
		boolean rSet = false;
		
		if (isAdd){
			if (srcList == null){
				outList = new int[bufLen];
				for (int i= 0;i<outList.length;i++){
					outList[i] = -1;
				}
				outList[0] = id;
			}
			else{
				int lLen = srcList.length;
				for (int i = 0; i < lLen; i++) {
					if (srcList[i] == id){
						set = true;
						break;
					}

					if (srcList[i] == -1) {
						srcList[i] = id;
						set = true;
						break;
					}
				}
				
				if (!set) {
					outList = new int[bufLen + lLen];
					rSet = true;
					for (int i = 0; i < lLen + bufLen; i++) {
						if (i > lLen) {
							outList[i] = -1;
						} else if (lLen == i) {
							outList[i] = id;
						} else {
							outList[i] = srcList[i];
						}
					}
				}
			}
		}
		else{
			if (srcList == null)
				return;
			
			for (int i = 0;i<srcList.length;i++){
				if (srcList[i]==id){
					srcList[i] = -1; 
					set = true;					
					break;
				}
			}
		}
		if (isAllow){
			if (isGroup){
				allowGroupList  = rSet==true ? outList:srcList;
			}
			else{
				allowUserList = rSet==true ? outList:srcList;
			}
			
		}
		else{
			if (isGroup){
				refuseGroupList = rSet==true ? outList:srcList;
			}
			else{
				refuseUserList = rSet==true ? outList:srcList;
			}
		}
		
	
	}
	
	public void setAllowUserList(String allowUserList) {
		if (allowUserList==null || allowUserList.equals("")){
			this.allowUserList = null;
			return;
		}
		String[] list = allowUserList.split(",");
		int len = list.length;
		this.allowUserList = new int[len + 10];
		for (int i=0;i<len + bufLen;i++){
			if (i>=len){
				this.allowUserList[i] = -1;
			}
			else{
				this.allowUserList[i] = Integer.parseInt(list[i]);
			}
		}
	}
	
	public void setAllowGroupList(String allowGroupList) {
		if (allowGroupList==null || allowGroupList.equals("")){
			this.allowGroupList = null;
			return;
		}
		String[] list = allowGroupList.split(",");
		int len = list.length;
		this.allowUserList = new int[len];
		for (int i=0;i<len + bufLen;i++){
			if (i>=len){
				this.allowGroupList[i] = -1;
			}
			else{
				this.allowGroupList[i] = Integer.parseInt(list[i]);
			}
		}
	}
	
	public void setRefuseUserList(String refuseUserList) {
		if (refuseUserList==null || refuseUserList.equals("")){
			this.refuseUserList = null;
			return;
		}
		String[] list = refuseUserList.split(",");
		int len = list.length;
		this.refuseUserList = new int[len];
		for (int i=0;i<len + bufLen;i++){
			if (i>=len){
				this.refuseUserList[i] = -1;
			}
			else{
				this.refuseUserList[i] = Integer.parseInt(list[i]);
			}
		}
	}
	
	public void setRefuseGroupList(String refuseGroupList) {
		if (refuseGroupList==null || refuseGroupList.equals("")){
			this.refuseGroupList = null;
			return;
		}
		String[] list = refuseGroupList.split(",");
		int len = list.length;
		this.refuseGroupList = new int[len];
		for (int i=0;i<len + bufLen;i++){
			if (i>=len){
				this.refuseGroupList[i] = -1;
			}
			else{
				this.refuseGroupList[i] = Integer.parseInt(list[i]);
			}
		}
	}
	
	public int[] getAllowUserList() {
		return allowUserList;
	}

	public int[] getAllowGroupList() {
		return allowGroupList;
	}

	public int[] getRefuseUserList() {
		return refuseUserList;
	}

	public int[] getRefuseGroupList() {
		return refuseGroupList;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}


	private int id;
	/**
	 * 权限名称
	 */
	private String name;
	/**
	 * 权限id，页面时为url，否则为权限的名称（英文）
	 */
	private String optionId;
	/**
	 * 权限说明
	 */
	private String remark;
	/**
	 * 是否页面  true：页面 false：权限
	 */
	private boolean isPage;
	/**
	 * 是否公告页面
	 */
	private boolean isPublic;
	/**
	 * 菜单分类id
	 */
	private int	menuId;
	/**
	 * 允许的用户列表
	 */
	private int[] allowUserList;
	/**
	 * 允许的组列表
	 */
	private int[] allowGroupList;
	/**
	 * 拒绝的用户列表
	 */
	private int[] refuseUserList;
	/**
	 * 拒绝的组列表
	 */
	private int[] refuseGroupList;
	
	private String url;
	
	static int bufLen = 10;
	
	/**
	 * 判断是否有用户权限
	 * @param uid
	 * @return -1:拒绝 0：无权限 1：有权限
	 */
	private int chkUser(int uid){
		if (uid <=0)
			return 0;
		
		if (refuseUserList!=null){
			for (int i=0;i<refuseUserList.length;i++){
				if (refuseUserList[i]==uid)
					return -1;
			}
		}
		
		if (allowUserList==null)
			return 0;
		
		for (int i=0;i<allowUserList.length;i++){
			if (allowUserList[i]==uid)
				return 1;
		}
		return 0;
	}
	
	/**
	 * 判断是否有组权限
	 * @param gid
	 * @return -1:拒绝 0：无权限 1：有权限
	 */
	private int chkGroup(int gid){
		if (gid == -999)
			return 1;
		
		if (refuseGroupList!=null){
			for (int i=0;i<refuseGroupList.length;i++){
				if (refuseGroupList[i]==gid)
					return -1;
			}
		}
		
		if (allowGroupList==null)
			return 0;
		
		for (int i=0;i<allowGroupList.length;i++){
			if (allowGroupList[i]==gid)
				return 1;
		}
		return 0;
	}
}
