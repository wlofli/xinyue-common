package com.xinyue.authe;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.xinyue.authe.util.Md5;

public class LoginUserInfo {
	public String getAuthcode(){
		String str = autheKey + key;
		return Md5.encodeByMD5(str);
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAutheKey() {
		return autheKey;
	}
	public void setAutheKey(String autheKey) {
		this.autheKey = autheKey;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}
	public Date getOverTime() {
		return overTime;
	}
	public void setOverTime(Date overTime) {
		this.overTime = overTime;
	}
	
	public int getUid(){
		return uId;
	}
	
	public int[] getGid(){
		return gid;
	}
	
	public boolean getAdmin(){
		return isAdmin;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public boolean isAdmin() {
		return isAdmin;
	}
	
	


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * 修改密码
	 * @param oldpwd
	 * @param newpwd
	 * @return
	 * @throws Exception
	 */
	public boolean changePassword(String oldpwd,String newpwd)throws Exception{
		if (oldpwd==null||oldpwd.equals(""))
			throw new Exception("原始密码为空");
		
		if (newpwd==null||newpwd.equals(""))
			throw new Exception("新密码位空");
		
		SqlSessionFactory sessionFactory =   AutheManage.getSqlSession();
		SqlSession session = sessionFactory.openSession();
		AutheMapper mapper = session.getMapper(AutheMapper.class);
		int re = mapper.changeUserPassword(userId, oldpwd, newpwd);
		session.close();
		return re>0;
	}

	public void setGid(String gidStr) {
		if (gidStr==null||gidStr.equals("")){
			this.gid = null;
			return;
		}
		
		String[] gidList = gidStr.split(",");
		int len = gidList.length;
		this.gid = new int[len];
		isAdmin = false;
		for (int i=0;i<len;i++){
			gid[i]= Integer.parseInt(gidList[i]); 
			if (gid[i]==-999)
				isAdmin = true;
		}
	}
	
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 用户id
	 */
	private String userId;
	/**
	 * 登录令牌
	 */
	private String autheKey;
	/**
	 * 秘钥
	 */
	private String key;
	/**
	 * 客户端ip
	 */
	private String ip;
	
	/**
	 * 登录时间
	 */
	private String loginTime;
	/**
	 * 登录失效时间
	 */
	private Date overTime;
	
	private int uId;
	
	private boolean isAdmin;
	
	private int[] gid;
}
