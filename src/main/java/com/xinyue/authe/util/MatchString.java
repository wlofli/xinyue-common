package com.xinyue.authe.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchString {
	/**
	 * 验证邮箱正则表达式
	 */
	private static final String pEmail = "^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$";
	/**
	 * 验证手机号码正则表达式
	 */
	private static final String pPhone = "^((13[0-9])|(17[0-9])|(15[0-9])|(18[0-9]))\\d{8}$";
	
	/**
	 * 判断字符串是否为email地址
	 * @param str
	 * @return
	 */
	public static boolean isEmail(String str){
		if (str==null || str.equals(""))
			return false;
		Pattern pattern = Pattern.compile(pEmail,Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}
	
	/**
	 * 判断字符串是否为手机号码
	 * @param str
	 * @return
	 */
	public static boolean isMobile(String str){
		if (str==null || str.equals(""))
			return false;
		Pattern pattern = Pattern.compile(pPhone,Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}
}
