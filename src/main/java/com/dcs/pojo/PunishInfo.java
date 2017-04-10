package com.dcs.pojo;

import com.dcs.util.AttributeBuildExcel;


public class PunishInfo {
	private Integer id;

	private Integer infoId;

	@AttributeBuildExcel(order=1,excelColumName="姓名")
	private String name;

	@AttributeBuildExcel(order=2,excelColumName="学号")
	private Integer studentId;

	@AttributeBuildExcel(order=3,excelColumName="班级")
	private String classroom;

	@AttributeBuildExcel(order=4,excelColumName="处分等级")
	private String punishGrade;

	@AttributeBuildExcel(order=5,excelColumName="处分原因")
	private String punishReason;

	@AttributeBuildExcel(order=6,excelColumName="处分时间")
	private String punishTime;

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

	public String getClassroom() {
		return classroom;
	}

	public void setClassroom(String classroom) {
		this.classroom = classroom == null ? null : classroom.trim();
	}

	public String getPunishGrade() {
		return punishGrade;
	}

	public void setPunishGrade(String punishGrade) {
		this.punishGrade = punishGrade == null ? null : punishGrade.trim();
	}

	public String getPunishReason() {
		return punishReason;
	}

	public void setPunishReason(String punishReason) {
		this.punishReason = punishReason == null ? null : punishReason.trim();
	}

	public String getPunishTime() {
		return punishTime;
	}

	public void setPunishTime(String punishTime) {
		this.punishTime = punishTime;
	}

	@Override
	public String toString() {
		return "{name=姓名,studentId=学号,classroom=班级,punishGrade=处分等级,"
				+"punishReason=处分原因,punishTime=处分时间}";
	}

}