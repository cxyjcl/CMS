package com.dcs.pojo;

import java.util.Date;

import com.dcs.util.AttributeBuildExcel;

public class ChangeInfo {
	private Integer id;

	private Integer infoId;

	@AttributeBuildExcel(order=1,excelColumName="姓名")
	private String name;

	@AttributeBuildExcel(order=2,excelColumName="学号")
	private Integer studentId;

	@AttributeBuildExcel(order=3,excelColumName="班级")
	private String classroom;

	@AttributeBuildExcel(order=4,excelColumName="异动原因")
	private String changeReason;

	@AttributeBuildExcel(order=5,excelColumName="异动时间")
	private String changeTime;

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

	public String getChangeReason() {
		return changeReason;
	}

	public void setChangeReason(String changeReason) {
		this.changeReason = changeReason == null ? null : changeReason.trim();
	}

	public String getChangeTime() {
		return changeTime;
	}

	public void setChangeTime(String changeTime) {
		this.changeTime = changeTime;
	}

	@Override
	public String toString() {
		return "{name=姓名,studentId=学号,classroom=班级,changeReason=异动原因,"
				+"changeTime=异动时间}";
		}
}