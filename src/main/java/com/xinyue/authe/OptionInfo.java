package com.xinyue.authe;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class OptionInfo {
	
	/**
	 * 判断用户是否有权限 代码由金修改 ywh提交
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
			for (int i=0;i<a_allowUserList.length;i++){
				if (i>0)
					aUserList += ",";
				aUserList += a_allowUserList[i];
			}
		}
		
		if (allowGroupList != null){
			for (int i=0;i<a_allowGroupList.length;i++){
				if (i>0)
					aGroupList += ",";
				aGroupList += a_allowGroupList[i];
			}
		}
		
		if (refuseUserList!=null){
			for (int i=0;i<a_refuseUserList.length;i++){
				if (i>0)
					rUserList += ",";
				rUserList += a_refuseUserList[i];
			}
		}
		
		if (refuseGroupList!=null){
			for (int i=0;i<a_refuseGroupList.length;i++){
				if (i>0)
					rGroupList += ",";
				rGroupList += a_refuseGroupList[i];
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
				srcList  = a_allowGroupList;
			}
			else{
				srcList = a_allowUserList;
			}
			
		}
		else{
			if (isGroup){
				srcList = a_refuseGroupList;
			}
			else{
				srcList = a_refuseUserList;
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
				a_allowGroupList  = rSet==true ? outList:srcList;
			}
			else{
				a_allowUserList = rSet==true ? outList:srcList;
			}
			
		}
		else{
			if (isGroup){
				a_refuseGroupList = rSet==true ? outList:srcList;
			}
			else{
				a_refuseUserList = rSet==true ? outList:srcList;
			}
		}
		
	
	}
	
	public void setAllowUserList(String allowUserList) {
		if (allowUserList==null || allowUserList.equals("")){
			this.allowUserList = null;
			return;
		}
		this.allowUserList = allowUserList;
		String[] list = allowUserList.split(",");
		int len = list.length;
		this.a_allowUserList = new int[len + bufLen];
		for (int i=0;i<len;i++){
			if (i>=len){
				this.a_allowUserList[i] = -1;
			}
			else{
				this.a_allowUserList[i] = Integer.parseInt(list[i]);
			}
		}
	}
	
	public void setAllowGroupList(String allowGroupList) {
		if (allowGroupList==null || allowGroupList.equals("")){
			this.allowGroupList = null;
			return;
		}
		this.allowGroupList = allowGroupList;
		String[] list = allowGroupList.split(",");
		int len = list.length;
		this.a_allowGroupList = new int[len+ bufLen];
		for (int i=0;i<len ;i++){
			if (i>=len){
				this.a_allowGroupList[i] = -1;
			}
			else{
				this.a_allowGroupList[i] = Integer.parseInt(list[i]);
			}
		}
	}
	
	public void setRefuseUserList(String refuseUserList) {
		if (refuseUserList==null || refuseUserList.equals("")){
			this.refuseUserList = null;
			return;
		}
		this.refuseUserList = refuseUserList;
		String[] list = refuseUserList.split(",");
		int len = list.length;
		this.a_refuseUserList = new int[len+ bufLen];
		for (int i=0;i<len ;i++){
			if (i>=len){
				this.a_refuseUserList[i] = -1;
			}
			else{
				this.a_refuseUserList[i] = Integer.parseInt(list[i]);
			}
		}
	}
	
	public void setRefuseGroupList(String refuseGroupList) {
		if (refuseGroupList==null || refuseGroupList.equals("")){
			this.refuseGroupList = null;
			return;
		}
		
		this.refuseGroupList = refuseGroupList;
		String[] list = refuseGroupList.split(",");
		int len = list.length;
		this.a_refuseGroupList = new int[len+bufLen];
		for (int i=0;i<len ;i++){
			if (i>=len){
				this.a_refuseGroupList[i] = -1;
			}
			else{
				this.a_refuseGroupList[i] = Integer.parseInt(list[i]);
			}
		}
	}
	
	public String  getAllowUserList() {
		return allowUserList;
	}

	public String getAllowGroupList() {
		return allowGroupList;
	}

	public String getRefuseUserList() {
		return refuseUserList;
	}

	public String getRefuseGroupList() {
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
	private String allowUserList;
	/**
	 * 允许的组列表
	 */
	private String allowGroupList;
	/**
	 * 拒绝的用户列表
	 */
	private String refuseUserList;
	/**
	 * 拒绝的组列表
	 */
	private String refuseGroupList;
	
	private int[] a_allowUserList;
	/**
	 * 允许的组列表
	 */
	private int[] a_allowGroupList;
	/**
	 * 拒绝的用户列表
	 */
	private int[] a_refuseUserList;
	/**
	 * 拒绝的组列表
	 */
	private int[] a_refuseGroupList;
	
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
			for (int i=0;i<a_refuseUserList.length;i++){
				if (a_refuseUserList[i]==uid)
					return -1;
			}
		}
		
		if (allowUserList==null)
			return 0;
		
		for (int i=0;i<a_allowUserList.length;i++){
			if (a_allowUserList[i]==uid)
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
			for (int i=0;i<a_refuseGroupList.length;i++){
				if (a_refuseGroupList[i]==gid)
					return -1;
			}
		}
		
		if (allowGroupList==null)
			return 0;
		
		for (int i=0;i<a_allowGroupList.length;i++){
			if (a_allowGroupList[i]==gid)
				return 1;
		}
		return 0;
	}
}
