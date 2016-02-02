package com.xinyue.authe;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.xinyue.authe.util.IsChinese;
import com.xinyue.authe.util.MatchString;
import com.xinyue.authe.util.Md5;


/**
 * ywh修改于2015-11- 09 
 * 原因 前台点击启用无效
 * @author Administrator
 *
 */
public class UserInfo {
	
	public static UserInfo getUserInfo(String username){
		if (username == null || username.equals(""))
			return null;
		try{
			SqlSessionFactory sessionFactory =   AutheManage.getSqlSession();
			SqlSession session = sessionFactory.openSession();
			AutheMapper mapper = session.getMapper(AutheMapper.class);
			UserInfo uInfo = mapper.selectUserInfo(username);
			session.close();
			return uInfo;
		}
		catch(Exception e){
			return null;
		}
		
	}
	
	public boolean addUser(HttpServletRequest request)throws Exception{
		this.username = request.getParameter("username");
	//	username = "admin";
		this.password = request.getParameter("password");
	//	password = "123456";
		this.email = request.getParameter("email");
		this.phone = request.getParameter("phone");
	//	phone = "13512345678";
		this.remark = request.getParameter("remark");
		this.name = request.getParameter("name");
		this.ip = request.getRemoteAddr();
		String position = request.getParameter("position");
		String org = request.getParameter("orgid");
		String gid = request.getParameter("gid");
		if (gid==null)
			gid = "";
		
		/**
		String qy = request.getParameter("py");
		if (qy==null)
			qy = "";
		
		int status = 0;
		if (!qy.equals("true"))
			status = 1;
		*/
		//you start
		String qy = request.getParameter("qy");
		int status = 0;
		if ("1".equals(qy))
			status = 1;
		//you over
		int type;
		try{
			type = Integer.parseInt(request.getParameter("usertype"));
		}
		catch(Exception e){
			type = 0;
		}
		
	/*	HttpSession hSession = request.getSession();
		if (hSession==null || hSession.getAttribute("randcode")==null)
			throw new Exception("验证码错误，请刷新网页");*/
		
		
		if (!checkInsert())
			return false;
		SqlSessionFactory sessionFactory =   AutheManage.getSqlSession();
		SqlSession session = sessionFactory.openSession();
		AutheMapper mapper = session.getMapper(AutheMapper.class);
		int re = mapper.addUserInfo(username, password, phone, email,name , remark, ip,userId,type,gid,status);
		if (re<=0)
			throw new Exception("添加用户失败");
	//	UserInfo uInfo = mapper.selectUserInfo(username);
		
		re = mapper.insertUserExtendInfo(position, org);
		session.close(); 
		return re>0;
	}
	
	private boolean checkInsert() throws Exception{
		if (username == null )
			throw new Exception("用户名为空");
		
		if (username.indexOf(" ")>=0 || username.indexOf("　")>=0)
			throw new Exception("用户名中不能有空格");
		
		int len = username.length();
		
		int userLen = 0;
		for (int i=0;i<len;i++){
			char t = username.charAt(i);
			if (IsChinese.isChinese(t)){
				userLen += 2;
				continue;
			}
			userLen ++;
			
			if (!((t>=48&&t<=57)||(t>=65&&t<=90)||(t>=97&&t<=122))){
				throw new Exception("用户名中不能有英文符号");
			}
		}
		
		if (userLen<4)
			throw new Exception("用户名不得少于4个字符或2个中文");
		
		if (password==null || password.length()<6)
			throw new Exception("密码最少需要6位");
		
		password = Md5.encodeByMD5(password);
		
		if (phone==null)
			phone = "";
		
		if (!MatchString.isMobile(phone)){
			throw new Exception("手机号码错误");
			//phone = "";
		}
		
		if (email==null)
			email = "";
		
		if (!MatchString.isEmail(email))
			email = "";
			
		if (email.equals("")&&phone.equals("")){
			throw new Exception("电子邮件和电话号码必须输入一个");
		}
		
		if (remark==null)
			remark = "";
		
		createUserId();
		
		if (userId.equals(""))
			throw new Exception("生成userId错误");
		
		return true;
	}
	
	private String createUserId(){
		if (username == null || username.equals(""))
			return "";
		
		userId = Md5.encodeByMD5(username);
		java.util.Date now = new java.util.Date();
		SimpleDateFormat df=new SimpleDateFormat("yyyyMMddhhmmss");
		userId = userId + df.format(now);
		return userId;
	}
	
	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public void setIp(HttpServletRequest request){
		ip = request.getRemoteAddr();
	}
	
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public String getIp() {
		return ip;
	}

	public String getUserId() {
		return userId;
	}

	public String getRemark() {
		return remark;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	private int	id;
	private String username;
	private String password;
	private String phone;
	private String email;
	private String ip;
	private String groupId;
	private String userId;
	private String remark;
	private String name;

}
