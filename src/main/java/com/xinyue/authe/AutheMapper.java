package com.xinyue.authe;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.xinyue.manage.model.AdminInfo;

import java.util.List;

public interface AutheMapper {
	@Select("select * from passport_user_info where username=#{username} and status=0")
	UserInfo selectUserInfo(String username);
	
	@Update("update passport_user_info set password=#{param3} where userid=#{param1} and password=#{param2}")
	int changeUserPassword(String userId,String oldpwd,String newpwd);
	
	@Select("select * from passport_option_info order by id")
	List<OptionInfo> getOptionList();
	
	@Insert("insert into passport_option_info(optionId,ispage)values(#{param1},#{param2})")
	int saveOption(String optionId,int ispage);
	
	/**
	 * 保存权限信息
	 * @param optionId      操作id
	 * @param allowUserList 授权用户列表 使用“，”分割
	 * @param allowGroupList 授权 权限组列表 使用“，”分割
	 * @param refuseUserList 阻止用户列表 使用“，”分割
	 * @param refuseGroupList 阻止权限组列表 使用“，”分割
	 * @return
	 */
	@Update("update passport_option_info set allowUserList=#{param2},allowGroupList=#{param3},refuseUserList=#{param4},refuseGroupList=#{param5} where optionid=#{param1}")
	int updateOption(String optionId, String allowUserList,String allowGroupList,String refuseUserList,String refuseGroupList);
	
	@Insert("insert into passport_user_extend(uid,position,organizationid)values(@@IDENTITY,#{param1},#{param2})")
	int insertUserExtendInfo(String position,String org);
	
	/**
	 * 添加用户名称
	 * @param username
	 * @param password
	 * @param phone
	 * @param email
	 * @param remark
	 * @param name
	 * @param ip
	 * @param userId
	 * @param userType  用户类型，用于区分不同的用户类型
	 * @return
	 */
	@Insert("insert into passport_user_info(username,password,phone,email,name,remark,ip,userid,usertype,groupid,status)values(#{param1},#{param2},#{param3},#{param4},#{param5},#{param6},#{param7},#{param8},#{param9},#{param10},#{param11})")
	int addUserInfo(String username,String password,String phone,String email,String name,String remark,String ip,String userId,int userType,String groupId,int status);
	
	@Select("select * from passport_menu_item order by id")
	List<MenuItem> getMenuList();
	
	
	@Select("select * from passport_menu_item where parentid=#{parentId} and text=#{text}")
	MenuItem getMenu(int parentId,String text);
	
	/**
	 * 添加菜单项
	 * @param text  菜单文字
	 * @param parentid 
	 * @param remark 备注说明
	 * @return
	 */
	@Insert("insert into passport_menu_item (text,parentid,remark)values(#{text},#{parentid},#{remark})")
	int addMenu(String text,int parentid,String remark);
	/**
	 * 添加权限组
	 * @param name 组名称
	 * @param remark 备注说明
	 * @return
	 */
	@Insert("insert into passport_group_name(groupname,remark)values(#{param1},#{param2})")
	int addGroup(String name,String remark);
	
	@Select("select d.sl as totalcount,a.id,a.username,a.phone,a.name as name, a.status,b.position,c.name as orgname,c.number as orgcode from passport_user_info a left join passport_user_extend b on a.id=b.uid left join m_organization_info c on b.organizationid=c.id left join (select COUNT(*) as sl from passport_user_info  where status>=0 and groupid not LIKE '%-999%' ) as d on 1=1  where a.status>=0 and groupid not LIKE '%-999%'  order by a.createtime desc limit #{param1},#{param2}")
	List<AdminInfo> getAdminInfos(int start,int end);
	
	/**
	 * 通过id获取管理员信息
	 * @param id
	 * @return
	 */
	@Select("select 1 as totalcount,a.id,a.groupid,a.username,a.phone,a.name as name, a.status,b.position,c.name as orgname,c.number as orgcode from passport_user_info a left join passport_user_extend b on a.id=b.uid left join m_organization_info c on b.organizationid=c.id  where a.id=#{param1}")
	AdminInfo getAdminInfo(int id);
	
	@Update("update passport_user_info set name=#{param2},phone=#{param3},status=#{param4},groupid=#{param5} where id=#{param1}")
	int updateUserInfo(int id,String name,String phone,int status,String gid);
	
	@Update("update passport_user_extend set position=#{param2} where uid=#{param1}")
	int updatePosition(int id,String position);
	
	@Update("update passport_user_info set status=-1 where id=#{param1}")
	int deladmin(int id);
}
 