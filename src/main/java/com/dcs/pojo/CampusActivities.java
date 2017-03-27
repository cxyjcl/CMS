package com.dcs.pojo;

public class CampusActivities {
	private Integer id;

	private Integer infoId;

	private String contextName;

	private String project;

	private String contextGrade;

	private Integer studentId;

	private String reward;

	private String studentName;

	private String grade;

	private String classroom;

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
		return "CampusActivities [id=" + id + ", infoId=" + infoId + ", contextName=" + contextName + ", project="
				+ project + ", contextGrade=" + contextGrade + ", studentId=" + studentId + ", reward=" + reward
				+ ", studentName=" + studentName + ", grade=" + grade + ", classroom=" + classroom + ", remark="
				+ remark + "]";
	}

}