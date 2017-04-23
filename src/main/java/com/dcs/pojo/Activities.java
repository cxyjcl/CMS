package com.dcs.pojo;

import com.dcs.util.AttributeBuildExcel;

public class Activities {
	
	private Integer id;

	private Integer infoId;
	
	@AttributeBuildExcel(order=1,excelColumName="序号")
	private String code;

	@AttributeBuildExcel(order=2,excelColumName="时间")
	private String time;

	@AttributeBuildExcel(order=3,excelColumName="地点")
	private String place;

	@AttributeBuildExcel(order=4,excelColumName="主办单位")
	private String sponsor;

	@AttributeBuildExcel(order=5,excelColumName="活动名称")
	private String name;

	@AttributeBuildExcel(order=6,excelColumName="活动简介")
	private String description;

	@AttributeBuildExcel(order=7,excelColumName="备注")
	private String remark;

	private String url;

	private String dataStatus;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getInfoId() {
		return infoId;
	}

	public void setInfoId(Integer infoId) {
		this.infoId = infoId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getSponsor() {
		return sponsor;
	}

	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDataStatus() {
		return dataStatus;
	}

	public void setDataStatus(String dataStatus) {
		this.dataStatus = dataStatus;
	}

	
	@Override
	public String toString() {
		return "{code=序号,time=时间,place=地点,sponsor=主办单位,"
				+"name=活动名称,description=活动简介,remark=备注,url=上传文件}";
	}
	
	
}
