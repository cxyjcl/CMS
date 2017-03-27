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
		return "ContestInfo [id=" + id + ", infoId=" + infoId + ", sponsor=" + sponsor + ", contestName=" + contestName
				+ ", contestGrade=" + contestGrade + ", workName=" + workName + ", contestStudent=" + contestStudent
				+ ", tutor=" + tutor + ", remark=" + remark + "]";
	}

}