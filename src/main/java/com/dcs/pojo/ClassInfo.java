package com.dcs.pojo;

import org.springframework.beans.factory.annotation.Autowired;

import com.dcs.util.AttributeBuildExcel;

public class ClassInfo {
	private Integer id;

	
	private Integer infoId;

	@AttributeBuildExcel(order=1,excelColumName="学号")
	private Integer studentId;

	@AttributeBuildExcel(order=2,excelColumName="姓名")
	private String name;
	
	@AttributeBuildExcel(order=3,excelColumName="性别")
	private String sex;

	@AttributeBuildExcel(order=4,excelColumName="籍贯")
	private String nativePlace;

	@AttributeBuildExcel(order=5,excelColumName="出生地")
	private String birthPlace;

	@AttributeBuildExcel(order=6,excelColumName="身份证号")
	private String idCard;

	@AttributeBuildExcel(order=7,excelColumName="联系方式")
	private String contacts;

	@AttributeBuildExcel(order=8,excelColumName="备注（党员Y/N）")
	private String partyMember;

	@AttributeBuildExcel(order=8,excelColumName="班级职务")
	private String duties;

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

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
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

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard == null ? null : idCard.trim();
	}

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts == null ? null : contacts.trim();
	}
	
	public String getPartyMember() {
		return partyMember;
	}

	public void setPartyMember(String partyMember) {
		this.partyMember = partyMember;
	}

	public String getDuties() {
		return duties;
	}

	public void setDuties(String duties) {
		this.duties = duties;
	}

	@Override
	public String toString() {
		return "{studentId=学号,name=姓名,sex=性别,nativePlace=籍贯,"
				+"birthPlace=出生地,idCard=身份证号,contacts=联系方式"
				+ ",partyMember=备注（党员√）,duties=班级职务}";
	}

}