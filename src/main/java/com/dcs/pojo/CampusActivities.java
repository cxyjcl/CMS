package com.dcs.pojo;

import com.dcs.util.AttributeBuildExcel;

public class CampusActivities {
	private Integer id;

	private Integer infoId;

	@AttributeBuildExcel(order=1,excelColumName="比赛名称")
	private String contextName;

	@AttributeBuildExcel(order=2,excelColumName="项目")
	private String project;

	@AttributeBuildExcel(order=3,excelColumName="级别")
	private String contextGrade;

	@AttributeBuildExcel(order=4,excelColumName="获奖者学号")
	private Integer studentId;

	@AttributeBuildExcel(order=5,excelColumName="奖项")
	private String reward;

	@AttributeBuildExcel(order=6,excelColumName="获奖者")
	private String studentName;

	@AttributeBuildExcel(order=7,excelColumName="年级")
	private String grade;

	@AttributeBuildExcel(order=8,excelColumName="班级")
	private String classroom;

	@AttributeBuildExcel(order=9,excelColumName="备注")
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

	public String getContextName() {
		return contextName;
	}

	public void setContextName(String contextName) {
		this.contextName = contextName == null ? null : contextName.trim();
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project == null ? null : project.trim();
	}

	public String getContextGrade() {
		return contextGrade;
	}

	public void setContextGrade(String contextGrade) {
		this.contextGrade = contextGrade == null ? null : contextGrade.trim();
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getReward() {
		return reward;
	}

	public void setReward(String reward) {
		this.reward = reward == null ? null : reward.trim();
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName == null ? null : studentName.trim();
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade == null ? null : grade.trim();
	}

	public String getClassroom() {
		return classroom;
	}

	public void setClassroom(String classroom) {
		this.classroom = classroom == null ? null : classroom.trim();
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	@Override
	public String toString() {
		return "{contextName=比赛名称,project=项目,contextGrade=级别,studentId=获奖者学号,"
				+"reward=奖项,studentName=获奖者,grade=年级,classroom=班级"
				+ ",remark=备注}";
	}

}