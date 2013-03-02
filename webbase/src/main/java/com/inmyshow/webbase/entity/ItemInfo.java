package com.inmyshow.webbase.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name = "item_info")
public class ItemInfo extends BaseEntity{

	private static final long serialVersionUID = 1L;

	/** 物品名字 */
	private String itemName;

	/** 物品类型 */
	private Integer itemType;
	
	/** 物品注释*/
	private String itemComment;

	/** 使用性别 0:通用1:男2：女 */
	private Integer sexLimit;

	/** 出售的商店 */
	private String shopKey;

	/** 货币类型 */
	private String priceType;

	/** 售价 */
	private String priceNum;
	/**老物件id*/
	private Long oldId;
	/**最后操作时间*/
	private Date lastOptTime;
	/**上传的原文件名*/
	private String uploadFileName;
	/**上传时间*/
	private Date uploadTime;
	/**上传人*/
	private String uploadPeople;
	/**新文件名*/
	private String newFileName;
	/**新文件路径*/
	private String newFilePath;
	/**老配置folder*/
	private String oldFolder;
	/**老配置loadType*/
	private String loadType;

	@Column(name = "item_name")
	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	@Column(name = "item_type")
	public Integer getItemType() {
		return itemType;
	}

	@Column(name = "sex_limit")
	public Integer getSexLimit() {
		return sexLimit;
	}


	@Column(name = "shop_key")
	public String getShopKey() {
		return shopKey;
	}


	public void setShopKey(String shopKey) {
		this.shopKey = shopKey;
	}

	@Column(name = "price_type")
	public String getPriceType() {
		return priceType;
	}


	public void setPriceType(String priceType) {
		this.priceType = priceType;
	}

	@Column(name = "price_num")
	public String getPriceNum() {
		return priceNum;
	}


	public void setPriceNum(String priceNum) {
		this.priceNum = priceNum;
	}
	
	
	

	@Column(name = "old_id")
	public Long getOldId() {
		return oldId;
	}


	public void setOldId(Long oldId) {
		this.oldId = oldId;
	}
	
	

	@Column(name = "last_opt_time")
	public Date getLastOptTime() {
		return lastOptTime;
	}


	public void setLastOptTime(Date lastOptTime) {
		this.lastOptTime = lastOptTime;
	}

	@Column(name = "item_comment")
	public String getItemComment() {
		return itemComment;
	}


	public void setItemComment(String itemComment) {
		this.itemComment = itemComment;
	}

	@Column(name = "upload_file_name")
	public String getUploadFileName() {
		return uploadFileName;
	}


	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	@Column(name = "new_file_name")
	public String getNewFileName() {
		return newFileName;
	}


	public void setNewFileName(String newFileName) {
		this.newFileName = newFileName;
	}

	@Column(name = "new_file_path")
	public String getNewFilePath() {
		return newFilePath;
	}


	public void setNewFilePath(String newFilePath) {
		this.newFilePath = newFilePath;
	}

	@Column(name = "old_folder")
	public String getOldFolder() {
		return oldFolder;
	}


	public void setOldFolder(String oldFolder) {
		this.oldFolder = oldFolder;
	}


	public void setItemType(Integer itemType) {
		this.itemType = itemType;
	}


	public void setSexLimit(Integer sexLimit) {
		this.sexLimit = sexLimit;
	}

	@Column(name = "load_type")
	public String getLoadType() {
		return loadType;
	}


	public void setLoadType(String loadType) {
		this.loadType = loadType;
	}

	@Column(name = "upload_time")
	public Date getUploadTime() {
		return uploadTime;
	}


	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}

	@Column(name = "upload_people")
	public String getUploadPeople() {
		return uploadPeople;
	}


	public void setUploadPeople(String uploadPeople) {
		this.uploadPeople = uploadPeople;
	}


	@Override
	public String toString() {
		return "ItemInfo [itemName=" + itemName + ", itemType=" + itemType
				+ ", itemComment=" + itemComment + ", sexLimit=" + sexLimit
				+ ", shopKey=" + shopKey + ", priceType=" + priceType
				+ ", priceNum=" + priceNum + ", oldId=" + oldId
				+ ", lastOptTime=" + lastOptTime + ", uploadFileName="
				+ uploadFileName + ", newFileName=" + newFileName
				+ ", newFilePath=" + newFilePath + ", oldFolder=" + oldFolder
				+ ", loadType=" + loadType + "]";
	}



}
