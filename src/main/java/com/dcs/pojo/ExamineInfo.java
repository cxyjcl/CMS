package com.dcs.pojo;

import com.dcs.util.AttributeBuildExcel;

public class ExamineInfo {
	private Integer id;

	private Integer infoId;

	@AttributeBuildExcel(order=1,excelColumName="辅导员")
	private String counselor;

	@AttributeBuildExcel(order=2,excelColumName="日常考核（100分）")
	private Double dailyExamine;

	@AttributeBuildExcel(order=3,excelColumName="学生测评（100分）")
	private Double studentExamine;

	@AttributeBuildExcel(order=4,excelColumName="绩效考核（100分）")
	private Double evaluationExamine;
	
	@AttributeBuildExcel(order=5,excelColumName="综合得分")
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