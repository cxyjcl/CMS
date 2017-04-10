package com.dcs.pojo;

import com.dcs.util.AttributeBuildExcel;

public class MoneyInfo {
	private Integer id;

	private Integer infoId;

	@AttributeBuildExcel(order=1,excelColumName="奖、助学金性质")
	private String moneyName;

	@AttributeBuildExcel(order=2,excelColumName="姓名")
	private String name;

	@AttributeBuildExcel(order=3,excelColumName="学号")
	private Integer studentId;

	@AttributeBuildExcel(order=4,excelColumName="行政班级")
	private String classroom;

	@AttributeBuildExcel(order=5,excelColumName="等级")
	private String grade;

	@AttributeBuildExcel(order=6,excelColumName="金额")
	private String money;

	@AttributeBuildExcel(order=7,excelColumName="备注")
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
		return "{moneyName=性质,name=姓名,studentId=学号,classroom=行政班级,"
				+"grade=等级,money=金额,remark=备注}";
	}

}