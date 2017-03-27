package com.dcs.pojo;

public class MoneyInfo {
	private Integer id;

	private Integer infoId;

	private String moneyName;

	private String name;

	private Integer studentId;

	private String classroom;

	private String grade;

	private String money;

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

	public String getMoneyName() {
		return moneyName;
	}

	public void setMoneyName(String moneyName) {
		this.moneyName = moneyName == null ? null : moneyName.trim();
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

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade == null ? null : grade.trim();
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money == null ? null : money.trim();
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	@Override
	public String toString() {
		return "MoneyInfo [id=" + id + ", infoId=" + infoId + ", moneyName=" + moneyName + ", name=" + name
				+ ", studentId=" + studentId + ", classroom=" + classroom + ", grade=" + grade + ", money=" + money
				+ ", remark=" + remark + "]";
	}

}