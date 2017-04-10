package com.dcs.pojo;

import com.dcs.util.AttributeBuildExcel;


public class StudentReward {
	private Integer id;

	private Integer infoId;

	@AttributeBuildExcel(order=2,excelColumName="姓名")
	private String name;

	@AttributeBuildExcel(order=3,excelColumName="学号")
	private Integer studentId;

	@AttributeBuildExcel(order=4,excelColumName="年级")
	private String grade;

	@AttributeBuildExcel(order=5,excelColumName="班级")
	private String classroom;

	@AttributeBuildExcel(order=6,excelColumName="获奖名称")
	private String rewardName;

	@AttributeBuildExcel(order=7,excelColumName="获奖等级")
	private String rewardGrade;

	@AttributeBuildExcel(order=8,excelColumName="获奖时间")
	private String rewardTime;

	@AttributeBuildExcel(order=9,excelColumName="备注")
	private String remark;

	@AttributeBuildExcel(order=1,excelColumName="获奖性质")
	private String rewardNature;

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

	public String getRewardTime() {
		return rewardTime;
	}

	public void setRewardTime(String rewardTime) {
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
		return "{name=姓名,studentId=学号,grade=年级,classroom=班级,"
				+"rewardName=获奖名称,rewardGrade=获奖等级,rewardTime=获奖时间,remark=备注"
				+ ",rewardNature=获奖性质}";
	}

}