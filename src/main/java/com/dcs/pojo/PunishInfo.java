package com.dcs.pojo;

import java.util.Date;

public class PunishInfo {
	private Integer id;

	private Integer infoId;

	private String name;

	private Integer studentId;

	private String classroom;

	private String punishGrade;

	private String punishReason;

	private Date punishTime;

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

	public Date getPunishTime() {
		return punishTime;
	}

	public void setPunishTime(Date punishTime) {
		this.punishTime = punishTime;
	}

	@Override
	public String toString() {
		return "PunishInfo [id=" + id + ", infoId=" + infoId + ", name=" + name + ", studentId=" + studentId
				+ ", classroom=" + classroom + ", punishGrade=" + punishGrade + ", punishReason=" + punishReason
				+ ", punishTime=" + punishTime + "]";
	}

}