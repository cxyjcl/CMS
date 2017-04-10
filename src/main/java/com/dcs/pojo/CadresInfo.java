package com.dcs.pojo;

import com.dcs.util.AttributeBuildExcel;

public class CadresInfo {
	private Integer id;

	private Integer infoId;
	
	@AttributeBuildExcel(order=1,excelColumName="姓名（主席团）")
	private String nameChairman;

	@AttributeBuildExcel(order=2,excelColumName="职务")
	private String functionChairman;

	@AttributeBuildExcel(order=3,excelColumName="联系方式")
	private String contactsChairman;

	@AttributeBuildExcel(order=4,excelColumName="分管部门")
	private String departmentCharge;

	@AttributeBuildExcel(order=5,excelColumName="姓名（部长）")
	private String nameSecretary;

	@AttributeBuildExcel(order=6,excelColumName="职务")
	private String functionSecretary;

	@AttributeBuildExcel(order=7,excelColumName="联系方式")
	private String contactsSecretary;

	@AttributeBuildExcel(order=8,excelColumName="所在学生组织")
	private String studentOrganization;

	@AttributeBuildExcel(order=9,excelColumName="备注")
	private String remark;
	
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
		return "{nameChairman=姓名（主席团）,functionChairman=职务,contactsChairman=联系方式,departmentCharge=分管部门,"
				+"nameSecretary=姓名（部长）,functionSecretary=职务,contactsSecretary=联系方式,studentOrganization=所在学生组织"
				+ ",remark=备注}";
	}

}