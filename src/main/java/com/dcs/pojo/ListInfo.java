package com.dcs.pojo;


import com.dcs.pojo.request.Page;

public class ListInfo extends Page{

	private Integer id;

	private String excelName;

	private String title;

	private Integer listId;

	private Integer infoId;

	private Integer creator;

	private String createTime;

	private Integer reviser;

	private String reviseTime;

	private String userLevel;
	
	private String dataStatus;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getExcelName() {
		return excelName;
	}

	public void setExcelName(String excelName) {
		this.excelName = excelName == null ? null : excelName.trim();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	public Integer getListId() {
		return listId;
	}

	public void setListId(Integer listId) {
		this.listId = listId;
	}

	public Integer getInfoId() {
		return infoId;
	}

	public void setInfoId(Integer infoId) {
		this.infoId = infoId;
	}

	public Integer getCreator() {
		return creator;
	}

	public void setCreator(Integer creator) {
		this.creator = creator;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Integer getReviser() {
		return reviser;
	}

	public void setReviser(Integer reviser) {
		this.reviser = reviser;
	}

	public String getReviseTime() {
		return reviseTime;
	}

	public void setReviseTime(String reviseTime) {
		this.reviseTime = reviseTime;
	}

	public String getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel == null ? null : userLevel.trim();
	}
	
	public String getDataStatus() {
		return dataStatus;
	}

	public void setDataStatus(String dataStatus) {
		this.dataStatus = dataStatus;
	}

	@Override
	public String toString() {
		return "ListInfo [id=" + id + ", excelName=" + excelName + ", title=" + title + ", listId=" + listId
				+ ", infoId=" + infoId + ", creator=" + creator + ", createTime=" + createTime + ", reviser=" + reviser
				+ ", reviseTime=" + reviseTime + ", userLevel=" + userLevel + "]";
	}

}