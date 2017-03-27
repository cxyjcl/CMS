package com.dcs.pojo;

public class CadresInfo {
	private Integer id;

	private Integer infoId;

	private String nameChairman;

	private String functionChairman;

	private String contactsChairman;

	private String departmentCharge;

	private String nameSecretary;

	private String functionSecretary;

	private String contactsSecretary;

	private String studentOrganization;

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

	public String getNameChairman() {
		return nameChairman;
	}

	public void setNameChairman(String nameChairman) {
		this.nameChairman = nameChairman == null ? null : nameChairman.trim();
	}

	public String getFunctionChairman() {
		return functionChairman;
	}

	public void setFunctionChairman(String functionChairman) {
		this.functionChairman = functionChairman == null ? null : functionChairman.trim();
	}

	public String getContactsChairman() {
		return contactsChairman;
	}

	public void setContactsChairman(String contactsChairman) {
		this.contactsChairman = contactsChairman == null ? null : contactsChairman.trim();
	}

	public String getDepartmentCharge() {
		return departmentCharge;
	}

	public void setDepartmentCharge(String departmentCharge) {
		this.departmentCharge = departmentCharge == null ? null : departmentCharge.trim();
	}

	public String getNameSecretary() {
		return nameSecretary;
	}

	public void setNameSecretary(String nameSecretary) {
		this.nameSecretary = nameSecretary == null ? null : nameSecretary.trim();
	}

	public String getFunctionSecretary() {
		return functionSecretary;
	}

	public void setFunctionSecretary(String functionSecretary) {
		this.functionSecretary = functionSecretary == null ? null : functionSecretary.trim();
	}

	public String getContactsSecretary() {
		return contactsSecretary;
	}

	public void setContactsSecretary(String contactsSecretary) {
		this.contactsSecretary = contactsSecretary == null ? null : contactsSecretary.trim();
	}

	public String getStudentOrganization() {
		return studentOrganization;
	}

	public void setStudentOrganization(String studentOrganization) {
		this.studentOrganization = studentOrganization == null ? null : studentOrganization.trim();
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	@Override
	public String toString() {
		return "CadresInfo [id=" + id + ", infoId=" + infoId + ", nameChairman=" + nameChairman + ", functionChairman="
				+ functionChairman + ", contactsChairman=" + contactsChairman + ", departmentCharge=" + departmentCharge
				+ ", nameSecretary=" + nameSecretary + ", functionSecretary=" + functionSecretary
				+ ", contactsSecretary=" + contactsSecretary + ", studentOrganization=" + studentOrganization
				+ ", remark=" + remark + "]";
	}

}