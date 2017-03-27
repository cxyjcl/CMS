package com.dcs.pojo;

public class ClassInfo {
	private Integer id;

	private Integer infoId;

	private Integer studentId;

	private String name;

	private String sex;

	private String nativePlace;

	private String birthPlace;

	private String idCard;

	private String contacts;

	private Boolean partyMember;

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

	public Boolean getPartyMember() {
		return partyMember;
	}

	public void setPartyMember(Boolean partyMember) {
		this.partyMember = partyMember;
	}

	@Override
	public String toString() {
		return "ClassInfo [id=" + id + ", infoId=" + infoId + ", studentId=" + studentId + ", name=" + name + ", sex="
				+ sex + ", nativePlace=" + nativePlace + ", birthPlace=" + birthPlace + ", idCard=" + idCard
				+ ", contacts=" + contacts + ", partyMember=" + partyMember + "]";
	}

}