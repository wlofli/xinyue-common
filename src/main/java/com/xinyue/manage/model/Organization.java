package com.xinyue.manage.model;

import java.io.Serializable;
import java.util.List;

/**
 * 机构管理
 * @author wenhai.you
 * @2015年5月16日
 * @下午1:09:10
 */
public class Organization implements Serializable {
	
	private String id;//主键
	private String name;//机构名称
	private String genre;//机构类型
	private String genreName;//机构类型名称
	private String number;//机构编号
	private String site;//详细地址
	private String address;//省 市 区 地址
	private String postcode;//邮编
	/**联系人名称列表展示使用*/
	private String linkName;//联系人
	private String sex;//性别
	private String position;//职位
	private String telphone;//手机
	private String fixed;//固定电话
	private String fax;//传值
	private String mail;//邮箱
	
	
	private List<LinkMan> linkman;//联系人
	private int status;//是否启用 0 启用 默认为启用
	private int deleted;//删除标记 默认为0 0为未删除
	private String pinyin;//拼音
	private String shortName;//简称
	private String domain;//域名
	private String capital;//注册资金
	private String regNum;//注册号
	private String pv;//浏览量
	private String introduce;//一句话介绍
	private String image;//机构图像
	private String notice;//店铺公告
	private String area;//业务区域
	private String scale;//规模
	private String scaleName;//规模内容
	private String establish;//成立时间
	private String business;//擅长业务
	private String orderNum;//
	private String description;//描述
	
	//用来显示省 市 区回显
	private String provinceid;
	private String cityid;
	private String cid;
	private String zoneid;
	private String zid;
	private List<SubStation> stat;
	private List<String> statid;//用来存储选择id
	private List<ProductType> ptype;
	private List<String> ptypeid;
	
	public String getScaleName() {
		return scaleName;
	}
	public void setScaleName(String scaleName) {
		this.scaleName = scaleName;
	}
	public String getLinkName() {
		return linkName;
	}
	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getFixed() {
		return fixed;
	}
	public void setFixed(String fixed) {
		this.fixed = fixed;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public List<String> getStatid() {
		return statid;
	}
	public void setStatid(List<String> statid) {
		this.statid = statid;
	}
	public List<String> getPtypeid() {
		return ptypeid;
	}
	public void setPtypeid(List<String> ptypeid) {
		this.ptypeid = ptypeid;
	}
	public List<ProductType> getPtype() {
		return ptype;
	}
	public void setPtype(List<ProductType> ptype) {
		this.ptype = ptype;
	}
	public List<SubStation> getStat() {
		return stat;
	}
	public void setStat(List<SubStation> stat) {
		this.stat = stat;
	}
	public String getGenreName() {
		return genreName;
	}
	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}
	public String getProvinceid() {
		return provinceid;
	}
	public void setProvinceid(String provinceid) {
		this.provinceid = provinceid;
	}
	public String getCityid() {
		return cityid;
	}
	public void setCityid(String cityid) {
		this.cityid = cityid;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getZoneid() {
		return zoneid;
	}
	public void setZoneid(String zoneid) {
		this.zoneid = zoneid;
	}
	public String getZid() {
		return zid;
	}
	public void setZid(String zid) {
		this.zid = zid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
	public List<LinkMan> getLinkman() {
		return linkman;
	}
	public void setLinkman(List<LinkMan> linkman) {
		this.linkman = linkman;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getDeleted() {
		return deleted;
	}
	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}
	public String getPinyin() {
		return pinyin;
	}
	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public String getRegNum() {
		return regNum;
	}
	public void setRegNum(String regNum) {
		this.regNum = regNum;
	}
	public String getPv() {
		return pv;
	}
	public void setPv(String pv) {
		this.pv = pv;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getScale() {
		return scale;
	}
	public void setScale(String scale) {
		this.scale = scale;
	}
	public String getEstablish() {
		return establish;
	}
	public void setEstablish(String establish) {
		this.establish = establish;
	}
	public String getBusiness() {
		return business;
	}
	public void setBusiness(String business) {
		this.business = business;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	@Override
	public String toString() {
		return "Organization [id=" + id + ", name=" + name + ", genre=" + genre
				+ ", genreName=" + genreName + ", number=" + number + ", site="
				+ site + ", address=" + address + ", postcode=" + postcode
				+ ", linkName=" + linkName + ", sex=" + sex + ", position="
				+ position + ", telphone=" + telphone + ", fixed=" + fixed
				+ ", fax=" + fax + ", mail=" + mail + ", linkman=" + linkman
				+ ", status=" + status + ", deleted=" + deleted + ", pinyin="
				+ pinyin + ", shortName=" + shortName + ", domain=" + domain
				+ ", capital=" + capital + ", regNum=" + regNum + ", pv=" + pv
				+ ", introduce=" + introduce + ", image=" + image + ", notice="
				+ notice + ", area=" + area + ", scale=" + scale
				+ ", scaleName=" + scaleName + ", establish=" + establish
				+ ", business=" + business + ", orderNum=" + orderNum
				+ ", description=" + description + ", provinceid=" + provinceid
				+ ", cityid=" + cityid + ", cid=" + cid + ", zoneid=" + zoneid
				+ ", zid=" + zid + ", stat=" + stat + ", statid=" + statid
				+ ", ptype=" + ptype + ", ptypeid=" + ptypeid + "]";
	}
	
}
