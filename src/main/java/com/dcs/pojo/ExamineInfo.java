package com.dcs.pojo;

public class ExamineInfo {
	private Integer id;

	private Integer infoId;

	private String counselor;

	private Double dailyExamine;

	private Double studentExamine;

	private Double evaluationExamine;
	
	private Double totalExamine;

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

	public Double getEvaluationExamine() {
		return evaluationExamine;
	}

	public void setEvaluationExamine(Double evaluationExamine) {
		this.evaluationExamine = evaluationExamine;
	}

	@Override
	public String toString() {
		return "{counselor=辅导员,dailyExamine=日常考核（100分）,studentExamine=学生测评（100分）,evaluationExamine=绩效考核（100分）,totalExamine=综合得分}";
	}

}