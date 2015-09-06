package com.xinyue.manage.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * 产品表
 * @author wenhai.you
 * @2015年5月22日
 * @下午4:30:23
 */
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4343638966384719267L;
	private String id;//编号
	private String name;//产品名称
	private ProductType type;//产品类型
	private String productTypeName;
	private BankInfo bank;//所属银行-----------更改后台删掉
	private String orgName;//机构名称
	private String orgid;//机构id
	private String credit;//贷款额度 
	private int creditFrom;
	private int creditTo;
	

	private String content;//内容
	private String code;//产品编号
	private String area;//适用地区 
	private Boolean recommend;//推荐标志位
	private String logo;//缩略图
	private Date downTime;//下架时间
	private Date addTime;//上架时间
	private Boolean deleted;//删除标志位 0 默认为未删除
	private Select status;//状态 默认为1 未上架
	private Date createdTime;//创建时间
	private Date modifiedTime;//修改时间
	private String createUser;//创建者
	private String modifiedUser;//修改者
	private List<ProductFile> file;//对应文件申请资料
	private String typeName;

	public String getProductTypeName() {
		return productTypeName;
	}
	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public int getCreditFrom() {
		return creditFrom;
	}
	public void setCreditFrom(int creditFrom) {
		this.creditFrom = creditFrom;
	}
	public int getCreditTo() {
		return creditTo;
	}
	public void setCreditTo(int creditTo) {
		this.creditTo = creditTo;
	}
	public String getOrgid() {
		return orgid;
	}
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public Select getStatus() {
		return status;
	}
	public void setStatus(Select status) {
		this.status = status;
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
	public ProductType getType() {
		return type;
	}
	public void setType(ProductType type) {
		this.type = type;
	}
	public BankInfo getBank() {
		return bank;
	}
	public void setBank(BankInfo bank) {
		this.bank = bank;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public Boolean getRecommend() {
		return recommend;
	}
	public void setRecommend(Boolean recommend) {
		this.recommend = recommend;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public Date getDownTime() {
		return downTime;
	}
	public void setDownTime(Date downTime) {
		this.downTime = downTime;
	}
	public Boolean getDeleted() {
		return deleted;
	}
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public String getModifiedUser() {
		return modifiedUser;
	}
	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}
	public List<ProductFile> getFile() {
		return file;
	}
	public void setFile(List<ProductFile> file) {
		this.file = file;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	
	public Integer getState() {
		Integer status;
		if(addTime==null&&downTime==null){
			status=1;
		}else if(addTime==null&&downTime!=null&&(new Date(System.currentTimeMillis()).compareTo(downTime)>0)){
			status=3;
		}else if(addTime!=null&&(new Date(System.currentTimeMillis()).compareTo(addTime)<0)&&downTime==null){
			status=1;
		}else if(addTime!=null&&(new Date(System.currentTimeMillis()).compareTo(addTime)>=0)&&downTime==null){
			status=2;
		}else if(downTime!=null&&(new Date(System.currentTimeMillis()).compareTo(downTime)<=0)&&addTime==null){
			status=2;
		}else if(addTime!=null&&downTime!=null&&(new Date(System.currentTimeMillis()).compareTo(addTime)>=0)&&(new Date(System.currentTimeMillis()).compareTo(downTime)<=0)){
			status=2;
		}else{
			status=3;
		}
		
		return status;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", type=" + type
				+ ", productTypeName=" + productTypeName + ", bank=" + bank
				+ ", orgName=" + orgName + ", orgid=" + orgid + ", credit="
				+ credit + ", creditFrom=" + creditFrom + ", creditTo="
				+ creditTo + ", content=" + content + ", code=" + code
				+ ", area=" + area + ", recommend=" + recommend + ", logo="
				+ logo + ", downTime=" + downTime + ", addTime=" + addTime
				+ ", deleted=" + deleted + ", status=" + status
				+ ", createdTime=" + createdTime + ", modifiedTime="
				+ modifiedTime + ", createUser=" + createUser
				+ ", modifiedUser=" + modifiedUser + ", file=" + file
				+ ", typeName=" + typeName + "]";
	}
	
}
