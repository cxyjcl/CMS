package com.dcs.dto;

import java.util.Date;
import java.util.HashMap;

import com.dcs.pojo.request.Page;

/**
 * 
 * ClassName: ListInfoVo
 * @Description: TODO
 * @author pohoulong
 * @date 2017年3月24日 下午5:55:45
 */
public class ListInfoDto{
	
	private String excelName;
	
	private Integer listId;
	
	private Integer infoId;
	
	private String creator;

	private Date createTime;
	
	private Integer reviser;
	
	private Date reviseTime;
	
	private String dataStatus;
	
	private String userLevel;

	public String getExcelName() {
		return excelName;
	}

	public void setExcelName(String excelName) {
		this.excelName = excelName;
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

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getReviser() {
		return reviser;
	}

	public void setReviser(Integer reviser) {
		this.reviser = reviser;
	}

	public Date getReviseTime() {
		return reviseTime;
	}

	public void setReviseTime(Date reviseTime) {
		this.reviseTime = reviseTime;
	}

	public String getDataStatus() {
		return dataStatus;
	}

	public void setDataStatus(String dataStatus) {
		this.dataStatus = dataStatus;
	}

	public String getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}

	@Override
	public String toString() {
		return "ListInfoDto [excelName=" + excelName + ", listId=" + listId
				+ ", infoId=" + infoId + ", creator=" + creator
				+ ", createTime=" + createTime + ", reviser=" + reviser
				+ ", reviseTime=" + reviseTime + ", dataStatus=" + dataStatus
				+ ", userLevel=" + userLevel + "]";
	}
	
	
}
