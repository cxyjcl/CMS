package com.dcs.pojo;

public class ContestInfo {
	private Integer id;

	private Integer infoId;

	private String sponsor;

	private String contestName;

	private String contestGrade;

	private String workName;

	private String contestStudent;

	private String tutor;

	private String remark;

	private String dataStatus;
	
	public String getDataStatus() {
		return dataStatus;
	}

	public void setDataStatus(String dataStatus) {
		this.dataStatus = dataStatus;
	}
	
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

	public String getSponsor() {
		return sponsor;
	}

	public void setSponsor(String sponsor) {
		this.sponsor = sponsor == null ? null : sponsor.trim();
	}

	public String getContestName() {
		return contestName;
	}

	public void setContestName(String contestName) {
		this.contestName = contestName == null ? null : contestName.trim();
	}

	public String getContestGrade() {
		return contestGrade;
	}

	public void setContestGrade(String contestGrade) {
		this.contestGrade = contestGrade == null ? null : contestGrade.trim();
	}

	public String getWorkName() {
		return workName;
	}

	public void setWorkName(String workName) {
		this.workName = workName == null ? null : workName.trim();
	}

	public String getContestStudent() {
		return contestStudent;
	}

	public void setContestStudent(String contestStudent) {
		this.contestStudent = contestStudent == null ? null : contestStudent.trim();
	}

	public String getTutor() {
		return tutor;
	}

	public void setTutor(String tutor) {
		this.tutor = tutor == null ? null : tutor.trim();
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	@Override
	public String toString() {
		return "{sponsor=主办单位,contestName=比赛名称,contextGrade=获奖等级,workName=作品名称,"
				+"contestStudent=获奖学生,tutor=指导老师,remark=备注";
	}

}