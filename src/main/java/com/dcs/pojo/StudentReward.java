package com.dcs.pojo;

import java.util.Date;

public class StudentReward {
	private Integer id;

	private Integer infoId;

	private String name;

	private Integer studentId;

	private String grade;

	private String classroom;

	private String rewardName;

	private String rewardGrade;

	private Date rewardTime;

	private String remark;

	private String rewardNature;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
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

	public String getRewardName() {
		return rewardName;
	}

	public void setRewardName(String rewardName) {
		this.rewardName = rewardName == null ? null : rewardName.trim();
	}

	public String getRewardGrade() {
		return rewardGrade;
	}

	public void setRewardGrade(String rewardGrade) {
		this.rewardGrade = rewardGrade == null ? null : rewardGrade.trim();
	}

	public Date getRewardTime() {
		return rewardTime;
	}

	public void setRewardTime(Date rewardTime) {
		this.rewardTime = rewardTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	public String getRewardNature() {
		return rewardNature;
	}

	public void setRewardNature(String rewardNature) {
		this.rewardNature = rewardNature == null ? null : rewardNature.trim();
	}

	@Override
	public String toString() {
		return "StudentReward [id=" + id + ", infoId=" + infoId + ", name=" + name + ", studentId=" + studentId
				+ ", grade=" + grade + ", classroom=" + classroom + ", rewardName=" + rewardName + ", rewardGrade="
				+ rewardGrade + ", rewardTime=" + rewardTime + ", remark=" + remark + ", rewardNature=" + rewardNature
				+ "]";
	}

}