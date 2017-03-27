package com.dcs.pojo;

public class ExamineInfo {
	private Integer id;

	private Integer infoId;

	private String counselor;

	private Double dailyExamine;

	private Double studentExamine;

	private Double totalExamine;

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

	public String getCounselor() {
		return counselor;
	}

	public void setCounselor(String counselor) {
		this.counselor = counselor == null ? null : counselor.trim();
	}

	public Double getDailyExamine() {
		return dailyExamine;
	}

	public void setDailyExamine(Double dailyExamine) {
		this.dailyExamine = dailyExamine;
	}

	public Double getStudentExamine() {
		return studentExamine;
	}

	public void setStudentExamine(Double studentExamine) {
		this.studentExamine = studentExamine;
	}

	public Double getTotalExamine() {
		return totalExamine;
	}

	public void setTotalExamine(Double totalExamine) {
		this.totalExamine = totalExamine;
	}

	@Override
	public String toString() {
		return "ExamineInfo [id=" + id + ", infoId=" + infoId + ", counselor=" + counselor + ", dailyExamine="
				+ dailyExamine + ", studentExamine=" + studentExamine + ", totalExamine=" + totalExamine + "]";
	}

}