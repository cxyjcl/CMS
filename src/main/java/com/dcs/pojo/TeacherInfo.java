package com.dcs.pojo;

public class TeacherInfo {
	private Integer id;

	private Integer infoId;

	private String classroom;

	private String teacher;

	private String sex;

	private String nativePlace;

	private String birthPlace;

	private String contacts;

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

	public String getClassroom() {
		return classroom;
	}

	public void setClassroom(String classroom) {
		this.classroom = classroom == null ? null : classroom.trim();
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher == null ? null : teacher.trim();
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex == null ? null : sex.trim();
	}

	public String getNativePlace() {
		return nativePlace;
	}

	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace == null ? null : nativePlace.trim();
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace == null ? null : birthPlace.trim();
	}

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts == null ? null : contacts.trim();
	}

	@Override
	public String toString() {
		return "TeacherInfo [id=" + id + ", infoId=" + infoId + ", classroom=" + classroom + ", teacher=" + teacher
				+ ", sex=" + sex + ", nativePlace=" + nativePlace + ", birthPlace=" + birthPlace + ", contacts="
				+ contacts + "]";
	}

}