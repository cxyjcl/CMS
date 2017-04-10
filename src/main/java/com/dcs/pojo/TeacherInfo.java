package com.dcs.pojo;

import com.dcs.util.AttributeBuildExcel;

public class TeacherInfo {
	private Integer id;

	private Integer infoId;

	@AttributeBuildExcel(order=1,excelColumName="班级")
	private String classroom;

	@AttributeBuildExcel(order=2,excelColumName="班主任")
	private String teacher;

	@AttributeBuildExcel(order=3,excelColumName="性别")
	private String sex;

	@AttributeBuildExcel(order=4,excelColumName="籍贯")
	private String nativePlace;

	@AttributeBuildExcel(order=5,excelColumName="出生地")
	private String birthPlace;

	@AttributeBuildExcel(order=6,excelColumName="联系方式")
	private String contacts;

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
		return "{classroom=班级,teacher=班主任,sex=性别,nativePlace=籍贯,"
				+"birthPlace=出生地,contacts=联系方式}";
	}

}