package com.xinyue.manage.util;

public class GlobalConstant {
	
	//登录相关常量
	public static final String USER_LOGIN = "user_login";//表示用户登录对象的；保存是登录的信息
	public static final String SESSION_USER_NAME = "session_user_name";//表示用户登录后的用户名
	public static final String SESSION_USER_LOGIN_TIME = "session_user_login_time"; //表示用户登录的时间；
	public static final String USER_LAST_LOGINED_TIME = "user_last_logined_time";  //表示上次登录的时间
	
	public static final String USER = "admin";

	public static final String TYPE_CITY = "tc";
	
	public static final String TYPE_ZONE = "tz";
	
	public static final String LINK_TYPE = "link_type";
	
	public static final String LINK_STATUS = "link_status";
	
	public static final String LINK_PUBLISH = "publish_type";
	
	public static final String RET_SUCCESS = "success";
	
	public static final String RET_FAIL = "fail";
	
	/**
	 * 未登陆或登陆超时
	 */
	public static final String URL_OVERDUE = "../errors/jump_overdue.html";
	
	//wenhai.you 2015-05-08 下午
	public static final int PAGE_SIZE = 10;
	
	/**wenhai.you 2015-05-08 下午
	 * 判断对象是否为空或者为空串
	 */
	public static boolean isNull(Object obj){
		return obj == null || obj.toString().trim().equals("");
	}
	
	public synchronized static int getCurrentPage(String topage ,int total){
		int totalPage = total/PAGE_SIZE;
		if(total%PAGE_SIZE != 0){
			totalPage++;
		}
		int c = (GlobalConstant.isNull(topage)|| topage.equals("0"))?1:Integer.valueOf(topage);
		if(c >totalPage){
			c = totalPage;
		}
		return c;
	}
	
	//mzj add 2015/05/20 实名认证导出相关
	public static final String AUTHENTICATION_EXCEL_NAME = "authentication_data.xls";
	public static final String AUTHENTICATION_SHEET_NAME = "认证企业资料";	
	public static final String AUTHENTICATION_TITLE_1 = "序号";
	public static final String AUTHENTICATION_TITLE_2 = "纳税识别号";
	public static final String AUTHENTICATION_TITLE_3 = "企业名称";
	public static final String AUTHENTICATION_TITLE_4 = "行政区划";
	public static final String AUTHENTICATION_TITLE_5 = "企业注册日期";
	public static final String AUTHENTICATION_TITLE_6 = "法人";
	public static final String AUTHENTICATION_TITLE_7 = "注册资金";
	public static final String AUTHENTICATION_TITLE_8 = "所属行业";
	public static final String AUTHENTICATION_TITLE_9 = "联系人";
	public static final String AUTHENTICATION_TITLE_10 = "手机号";
	public static final String AUTHENTICATION_TITLE_11 = "会员名";
	public static final String AUTHENTICATION_TITLE_12 = "注册会员时间";
	public static final String AUTHENTICATION_TITLE_13 = "实名认证时间";
	public static final String AUTHENTICATION_TITLE_14 = "企业认证状态";
	public static final String AUTHENTICATION_TITLE_15 = "认证类型";
	
	//mzj add 2015/05/20 企业信息导出相关
	public static final String COMPANYINFO_EXCEL_NAME = "company_info.xls";
	public static final String COMPANYINFO_SHEET_NAME = "企业资料";
	public static final String COMPANYINFO_TITLE_1 = "序号";
	public static final String COMPANYINFO_TITLE_2 = "纳税识别号";
	public static final String COMPANYINFO_TITLE_3 = "企业名称";
	public static final String COMPANYINFO_TITLE_4 = "行政区划";
	public static final String COMPANYINFO_TITLE_5 = "企业注册日期";
	public static final String COMPANYINFO_TITLE_6 = "法人";
	public static final String COMPANYINFO_TITLE_7 = "注册资金";
	public static final String COMPANYINFO_TITLE_8 = "所属行业";
	public static final String COMPANYINFO_TITLE_9 = "联系人";
	public static final String COMPANYINFO_TITLE_10 = "手机号";
	public static final String COMPANYINFO_TITLE_11 = "实名认证状态";
	public static final String COMPANYINFO_TITLE_12 = "贷款次数";
	public static final String COMPANYINFO_TITLE_13 = "会员名";
	public static final String COMPANYINFO_TITLE_14 = "注册会员时间";
	
	//mzj add 2015/05/30 企业信息相关下拉表
	/**
	 * 可接受最高利率
	 */
	public static final String COMPANY_MAX_RATE_TYPE = "maxrate_type";
	/**
	 * 还款方式
	 */
	public static final String COMPANY_REPAY_TYPE = "repay_type";
	/**
	 * 主要担保方式
	 */
	public static final String COMPANY_GUARANTEE_TYPE = "guarantee_type";
	/**
	 * 证件类型
	 */
	public static final String COMPANY_IDCARD_TYPE = "idcard_type";
	/**
	 * 资本类型
	 */
	public static final String COMPANY_CAPITAL_TYPE = "capital_type";
	/**
	 * 企业性质
	 */
	public static final String COMPANY_TYPE = "company_type";
	/**
	 * 机构类型
	 */
	public static final String COMPANY_AGENCY_TYPE = "agency_type";
	/**
	 * 工商等级类型
	 */
	public static final String COMPANY_BUSINESS_TYPE = "business_type";
	/**
	 * 控股方式
	 */
	public static final String COMPANY_HOLD_TYPE = "hold_type";
	/**
	 * 学历
	 */
	public static final String COMPANY_EDUCATION_TYPE = "education_type";
	/**
	 * 婚姻情况
	 */
	public static final String COMPANY_MARRIAGE_TYPE = "marriage_type";
	/**
	 * 产品销售区域
	 */
	public static final String COMPANY_BUSINESS_AREA = "business_area";
	/**
	 * 审计意见类型
	 */
	public static final String COMPANY_AUDIT_TYPE = "audit_type";
	/**
	 * 抵质押物情况
	 */
	public static final String COMPANY_COLLATERAL_TYPE = "collateral_type";
	
	
	
	
	/**
	 * add by lzc
	 * 2015年6月3日13:29:28 
	 */
	//快速信贷状态
//	public static final String FASTPRODUCT_STATUS = "fastproduct_status";//数据库中也有->m_select_info
	
	//订单状态
	public static final String ORDER_STATUS = "order_status";
	public static final String ORDER_STATUS_BLANK = "6";//等待机构审核
	public static final String ORDER_STATUS_PASS = "3";//新越网审核通过
	public static final String ORDER_STATUS_PASS_CHINESE = "新越网审核通过";//新越网审核通过
	public static final String ORDER_STATUS_PASS_SET = "4";//新越网审核通过设为推荐
	public static final String ORDER_STATUS_PASS_SET_CHINESE = "新越网审核通过设为推荐";//新越网审核通过设为推荐
	
	//特殊的三种订单审核状态
//	public static final String AUDITE_STATUS = "audite_status";//数据库中也有->m_select_info
	
	//搜索新闻条件
	public static final String SEARCH_NEW = "search_new";
	
	//订单审核的权限
	public static final String ORDER_AUDITE_NAME = "订单审批";//订单模块名称
	public static final String ORDER_AUDITE_UNCHECK = "audite_uncheck";//待审核
	public static final String ORDER_AUDITE_TAX = "audite_tax";//新越网审核通过
	public static final String ORDER_AUDITE_BLANK = "audite_blank";//机构审核中订单
	
	//订单客户值
	public static final int ORDER_CUSTOMER_TYPE = 1;
	public static final int FASUPRODUCT_CUSTOMER_TYPE = 2;
	public static final String ORDER_TABLENAME = "m_order_info";//订单表
	public static final String FASTPRODUCT_TABNAME_FAST = "m_product_fast_info";//快速申贷表
	public static final String ORDER_TABNAME_AUCTION = "c_order_auction";//竞拍表名
	public static final String ORDER_TABNAME_FIXED = "c_order_fixed";//立即领取表
	public static final String ORDER_TABNAME_LOWPRICE = "c_order_lowprice";//最低价表
	public static final String ORDER_TABNAME_APPOINTED = "c_order_appoint";//指定客户表
	public static final String ORDER_TYPE_FIXED = "1";//订单类型:立即领取
	public static final String ORDER_TYPE_FIXED_CHINESE = "立即领取";//订单类型:立即领取
	public static final String ORDER_TYPE_AUCTION = "2";//订单类型:竞拍
	public static final String ORDER_TYPE_AUCTION_CHINESE = "竞拍";//订单类型:竞拍
	public static final String ORDER_TYPE_LOWPRICE = "3";//订单类型:最低价
	public static final String ORDER_TYPE_LOWPRICE_CHINESE = "唯一低价";//订单类型:最低价
	public static final String ORDER_TYPE_APPOINTED = "4";//订单类型:指定客户
	public static final String ORDER_TYPE_APPOINTED_CHINESE = "指定推送";//订单类型:指定客户
	public static final String ORDER_TYPE_RESET = "5";//重置标识
	
	public static final String ORDER_TYPE = "order_type";//订单领取方式
	public static final String ORDER_GET_STATUS = "order_get_status";//订单领取状态
	
	public static final String ORDER_ORDERSTATUS_GET = "1";//已经领取
	public static final String ORDER_ORDERSTATUS_UNGET = "2";//未领取
	public static final String ORDER_ORDERSTATUS_NOGET = "3";//无人领取
	public static final String ORDER_ORDERSTATUS_NOSTART = "4";//未开始
	public static final String ORDER_ORDERSTATUS_RESET = "5";//重置标识
	
	//add by lzc 产品信息
	public static final String PRODUCT_RECOMMEND_ON = "1";//推荐
	public static final String PRODUCT_RECOMMEND_OFF = "0";//不推荐
	
	
	//2015/06/18 茅 权限名称追加 START
	//帮助中心权限
	public static final String AUTHORITY_HELP_ADD = "help_add";
	public static final String AUTHORITY_HELP_TYPE = "help_type";
	public static final String AUTHORITY_HELP_PUBLISH = "help_publish";
	public static final String AUTHORITY_HELP_DELETE = "help_delete";
	public static final String AUTHORITY_HELP_UPDATE = "help_update";
	
	//友情链接权限
	public static final String AUTHORITY_FRIENDSHIP_ADD = "friendship_add";
	public static final String AUTHORITY_FRIENDSHIP_UPDATE = "friendship_update";
	public static final String AUTHORITY_FRIENDSHIP_DELETE = "friendship_delete";
	public static final String AUTHORITY_FRIENDSHIP_PUBLISH = "friendship_publish";

	//合作机构权限
	public static final String AUTHORITY_COOPERATION_ADD = "cooperation_add";
	public static final String AUTHORITY_COOPERATION_UPDATE = "cooperation_update";
	public static final String AUTHORITY_COOPERATION_DELETE = "cooperation_delete";
	public static final String AUTHORITY_COOPERATION_PUBLISH = "cooperation_publish";
	
	//企业实名认证权限
	public static final String AUTHORITY_AUTHENTICATION_EXPORT = "authentication_export";
	public static final String AUTHORITY_AUTHENTICATION_DETAIL = "authentication_detail";

	//城市分站认证权限
	public static final String AUTHORITY_CITY_ADD = "city_add";
	public static final String AUTHORITY_CITY_UPDATE = "city_update";
	public static final String AUTHORITY_CITY_DELETE = "city_delete";
	
	//企业信息权限
	public static final String AUTHORITY_COMPANY_EXPORT = "company_export";
	public static final String AUTHORITY_COMPANY_DETAIL = "company_detail";
	public static final String AUTHORITY_COMPANY_PUBLISH = "company_publish";
	public static final String AUTHORITY_COMPANY_UPDATE = "company_update";
	public static final String AUTHORITY_COMPANY_DELETE = "company_delete";
	//2015/06/18 茅 权限名称追加 END
	
	//2015/06/19 游 权限名称追加 START
	public static final String ADVERT_HELP_ADD = "advert_add";
	public static final String ADVERT_HELP_SHIELD = "advert_shield";//屏蔽
	public static final String ADVERT_HELP_PUBLISH = "advert_publish";//发布
	public static final String ADVERT_HELP_DELETE = "advert_delete";
	public static final String ADVERT_HELP_UPDATE = "advert_update";
	
	public static final String MEMBER_HELP_ADD = "member_add";
	public static final String MEMBER_HELP_IMPORT = "member_import";
	public static final String MEMBER_HELP_ENABLE = "member_enable";
	public static final String MEMBER_HELP_DISABLE = "member_disable";
	public static final String MEMBER_HELP_DELETE = "member_delete";
	public static final String MEMBER_HELP_UPDATE = "member_update";
	
	
	public static final String ORGAN_HELP_ADD = "organ_add";
	public static final String ORGAN_HELP_ENABLE = "organ_enable";
	public static final String ORGAN_HELP_DISABLE = "organ_disable";
	public static final String ORGAN_HELP_DELETE = "organ_delete";
	public static final String ORGAN_HELP_UPDATE = "organ_update";
	
	public static final String ORGAN_TYPE_HELP_ADD = "organ_type_add";
	public static final String ORGAN_TYPE_HELP_DELETE = "organ_type_delete";
	public static final String ORGAN_TYPE_HELP_UPDATE = "organ_type_update";
	
	public static final String PRODUCT_HELP_ADD = "product_add";
	public static final String PRODUCT_HELP_DELETE = "product_delete";
	public static final String PRODUCT_HELP_UPDATE = "product_update";
	public static final String PRODUCT_HELP_SHELVE = "product_shelve";
	public static final String PRODUCT_HELP_UNSHELVE = "product_unshelve";
	
	public static final String PRODUCT_TYPE_HELP_ADD = "product_type_add";
	public static final String PRODUCT_TYPE_HELP_DELETE = "product_type_delete";
	public static final String PRODUCT_TYPE_HELP_UPDATE = "product_type_update";
	public static final String PRODUCT_TYPE_HELP_ENABLE = "product_type_enable";
	public static final String PRODUCT_TYPE_HELP_DISABLE = "product_type_disable";
	//2015/06/19 游 权限名称追加 END
}
