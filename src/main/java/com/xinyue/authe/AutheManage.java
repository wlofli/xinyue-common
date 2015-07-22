package com.xinyue.authe;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xinyue.authe.util.Md5;


/**
 * 权限管理
 * @author goto
 *
 */
public class AutheManage {
	private static Hashtable<String, LoginUserInfo> loginUserList = new Hashtable<String,LoginUserInfo>();
	
	/**
	 * url前需要过滤掉的字符串
	 */
	private final static String dirName = "/xinyue-manage";
	
	public static SqlSessionFactory getSqlSession()throws Exception{
		if (sqlFactory!=null)
			return sqlFactory;
		
		ctx = new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
		SqlSessionFactory sqlSessionFactory=(SqlSessionFactory) ctx.getBean("sqlSessionFactory");
		sqlSessionFactory.getConfiguration().addMapper(AutheMapper.class);
		sqlFactory = sqlSessionFactory;
		return sqlFactory;
	}
	
	private static SqlSessionFactory sqlFactory = null; 
	
	private static ApplicationContext ctx = null;
	
	/**
	 * 用户登录
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public static boolean login(HttpServletRequest request,HttpServletResponse response)throws Exception{
		String userName = request.getParameter("name");
		String password = request.getParameter("password");

//		HttpSession hSession = request.getSession();
//		if (hSession==null || hSession.getAttribute("randcode")==null)
//			throw new Exception("验证码错误，请刷新网页");
//		
//		String code = request.getParameter("imgcode");
//		if (code.equals(""))
//			throw new Exception("验证码为空");
//		
//		String rCode = hSession.getAttribute("randcode").toString();
//		
//		if (!rCode.equalsIgnoreCase(code))
//			throw new Exception("验证码错误");

		
		UserInfo userInfo = UserInfo.getUserInfo(userName);
		
		String ip = request.getRemoteAddr();
		
		if (userInfo == null)
			throw new Exception("用户名或密码错误");
		password = Md5.encodeByMD5(password);
		
		if (!password.equals(userInfo.getPassword()))
			throw new Exception("用户名或密码错误");
		
		LoginUserInfo loginInfo = createLoginUserInfo(userInfo, ip);
		
		loginUserList.put(loginInfo.getUserId(), loginInfo);
		
		Cookie cookieKeyId = new Cookie("keyid",loginInfo.getUserId()); 
		cookieKeyId.setMaxAge(60*60*8);
		Cookie cookieAuthecode = new Cookie("authecode",loginInfo.getAuthcode()); 
		cookieAuthecode.setMaxAge(60*60*8);
		response.addCookie(cookieKeyId);
		response.addCookie(cookieAuthecode);
		return true;
	}
	
	/**
	 * 修改密码
	 * @param request
	 * @throws Exception
	 */
	public static void changePwd(HttpServletRequest request)throws Exception{
		String oldPwd = request.getParameter("oldpwd");
		if (oldPwd==null || oldPwd.length()<6)
			throw new Exception("请输入最少6位的原始密码");
			
		String newPwd = request.getParameter("newpwd");
		if (newPwd==null || newPwd.length()<6)
			throw new Exception("请输入最少6位的新密码");
		
		String newPwd2 = request.getParameter("newpwd2");
		if (!newPwd.equals(newPwd2))
			throw new Exception("两次输入密码不一致");
		
		LoginUserInfo lUserInfo = getUser(request);
		if (lUserInfo == null)
			throw new Exception("没有登录，或者已超时退出");
		
		oldPwd = Md5.encodeByMD5(oldPwd);
		
		newPwd = Md5.encodeByMD5(newPwd);
		
		boolean re = lUserInfo.changePassword(oldPwd, newPwd);
		if (!re)
			throw new Exception("密码修改失败");
	}
	
	/**
	 * 退出登录
	 * @param request
	 * @param response
	 */
	public static void loginOut(HttpServletRequest request,HttpServletResponse response){
		Cookie[] cookies  = request.getCookies();
		if (cookies==null)
			return ;
		
		String keyId = "";
		String autheKey = "";
		
		for (int i=0;i<cookies.length;i++){
			Cookie cookie = cookies[i];
			if (cookie.getName().equals("keyid")){
				keyId = cookie.getValue();
				cookies[i].setMaxAge(0);
				response.addCookie(cookies[i]);
				continue;
			}
			
			if (cookie.getName().equals("authecode")){
				autheKey = cookie.getValue();
				cookies[i].setMaxAge(0);
				response.addCookie(cookies[i]);
			}
		}
		
		if (keyId==null || keyId.equals(""))
			return;
		
		if (autheKey == null || autheKey.equals(""))
			return;
		
		loginUserList.remove(keyId);
	}
	
	
	private static LoginUserInfo createLoginUserInfo(UserInfo uInfo,String ip) throws Exception{
		if (uInfo == null)
			throw new Exception("userinfo 对象为空");
		
		Date date = new Date();
		SimpleDateFormat simple = new java.text.SimpleDateFormat(); 
		simple.applyPattern("yyyyMMddHHmmss");
		
		SimpleDateFormat simple1 = new java.text.SimpleDateFormat(); 
		simple1.applyPattern("yyyy-MM-dd HH:mm:ss");
		
		String loginTime = simple1.format(date);
		String key = simple.format(date);
		String autoKey = key+ip + uInfo.getPassword();
		autoKey = Md5.encodeByMD5(autoKey);
		
		LoginUserInfo loginInfo = new LoginUserInfo();
		loginInfo.setUserId(uInfo.getUserId());
		loginInfo.setUsername(uInfo.getUsername());
		loginInfo.setAutheKey(autoKey);
		loginInfo.setIp(ip);
		loginInfo.setLoginTime(loginTime);
		String groupId = uInfo.getGroupId();
		loginInfo.setGid(groupId);
		loginInfo.setuId(uInfo.getId());
		return loginInfo;
	}
	
	/**
	 * 判断页面权限
	 * @param request
	 * @return -1：未登陆  0：没权限 1：有权限
	 */
	public static int chkAuthe(HttpServletRequest request){
		return chkAuthe(request,"");
	}
	
	/**
	 * 获取登录时间
	 * @param request
	 * @return
	 */
	public static String getLoginTime(HttpServletRequest request){
		LoginUserInfo lUserInfo = getUser(request);
		if (lUserInfo == null)
			return "";
		
		return lUserInfo.getLoginTime();
	}
	
	/**
	 * 获取登录用户名
	 * @param request
	 * @return
	 */
	public static String getUsername(HttpServletRequest request){
		LoginUserInfo lUserInfo = getUser(request);
		if (lUserInfo == null)
			return "";
		
		return lUserInfo.getUsername();
	}
	
	public static String getMenuJson(HttpServletRequest request){
		LoginUserInfo user = getUser(request);
		if (user==null)
			return "";
		
		return MenuManage.menuJson(user);
	}
	
	
	private static LoginUserInfo getUser(HttpServletRequest request){
		Cookie[] cookies  = request.getCookies();
		if (cookies==null)
			return null;
		
		String keyId = "";
		String autheKey = "";
		
		for (int i=0;i<cookies.length;i++){
			Cookie cookie = cookies[i];
			if (cookie.getName().equals("keyid")){
				keyId = cookie.getValue();
				continue;
			}
			
			if (cookie.getName().equals("authecode")){
				autheKey = cookie.getValue();
			}
		}
		if (keyId==null || keyId.equals(""))
			return null;
		
		return loginUserList.get(keyId);
	}
	
	public static boolean pageIsPublic(HttpServletRequest request){
		String opNameUrl = request.getRequestURI();
		if (opNameUrl.indexOf(dirName)==0)
			opNameUrl = opNameUrl.substring(dirName.length());
		
		return OptionManage.isPublic(opNameUrl);
	}
	
	
	/**
	 * 判断操作权限
	 * @param request
	 * @param opName 操作名称
	 * @return -1：未登陆  0：没权限 1：有权限
	 */
	public static int chkAuthe(HttpServletRequest request,String opName){
		Cookie[] cookies  = request.getCookies();
		if (cookies==null)
			return -1;
		
		String keyId = "";
		String autheKey = "";
		
		for (int i=0;i<cookies.length;i++){
			Cookie cookie = cookies[i];
			if (cookie.getName().equals("keyid")){
				keyId = cookie.getValue();
				continue;
			}
			
			if (cookie.getName().equals("authecode")){
				autheKey = cookie.getValue();
			}
		}
		if (keyId==null || keyId.equals(""))
			return -1;
		
		if (autheKey == null || autheKey.equals(""))
			return -1;
		
		if (!loginUserList.containsKey(keyId)){
			return -1;
		}
		
		String ip = request.getRemoteAddr();
		
		LoginUserInfo lUserInfo = loginUserList.get(keyId);
		
		if (!lUserInfo.getIp().equals(ip))
			return -1;
		
		if (!lUserInfo.getAuthcode().equals(autheKey)){
			return -1;
		}
		
		String opNameUrl = "";
		boolean isPage = false;
		if (opName==null || opName.equals("")){
			opNameUrl = request.getRequestURI();
			if (opNameUrl.indexOf(dirName)==0)
				opNameUrl = opNameUrl.substring(dirName.length());
			isPage = true;
		}
		else{
			opNameUrl = opName;
		}
		
		int uid = lUserInfo.getUid();
		int[] gid = lUserInfo.getGid();
		boolean isAdmin = lUserInfo.getAdmin();
		boolean re = OptionManage.chkAuthe(opNameUrl, isPage, uid, gid, isAdmin);
		if (re)
			return 1;
		else 
			return 0;
	}
	
	
}
