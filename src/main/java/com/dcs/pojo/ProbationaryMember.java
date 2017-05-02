package com.dcs.pojo;

import com.dcs.util.AttributeBuildExcel;

public class ProbationaryMember {
    private Integer id;

    private Integer infoId;
    @AttributeBuildExcel(order=1,excelColumName="序号")
    private String code;
    @AttributeBuildExcel(order=2,excelColumName="姓名")
    private String name;
    @AttributeBuildExcel(order=3,excelColumName="性别")
    private String sex;
    @AttributeBuildExcel(order=4,excelColumName="民族")
    private String nation;
    @AttributeBuildExcel(order=5,excelColumName="出生年月")
    private String birthday;
    @AttributeBuildExcel(order=6,excelColumName="身份证号码")
    private String idCard;
    @AttributeBuildExcel(order=7,excelColumName="班级")
    private String classroom;
    @AttributeBuildExcel(order=8,excelColumName="专业")
    private String profession;
    @AttributeBuildExcel(order=9,excelColumName="学生层次")
    private String studentLevel;
    @AttributeBuildExcel(order=10,excelColumName="成为积极分子时间")
    private String applicationDate;
    @AttributeBuildExcel(order=11,excelColumName="党校期数")
    private String lectureNum;
    @AttributeBuildExcel(order=12,excelColumName="确认发展对象时间")
    private String probationaryDate;

    private String dataStatus;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
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

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom == null ? null : classroom.trim();
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession == null ? null : profession.trim();
    }

    public String getStudentLevel() {
        return studentLevel;
    }

    public void setStudentLevel(String studentLevel) {
        this.studentLevel = studentLevel == null ? null : studentLevel.trim();
    }

    public String getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(String applicationDate) {
        this.applicationDate = applicationDate == null ? null : applicationDate.trim();
    }

    public String getLectureNum() {
        return lectureNum;
    }

    public void setLectureNum(String lectureNum) {
        this.lectureNum = lectureNum == null ? null : lectureNum.trim();
    }

    public String getProbationaryDate() {
        return probationaryDate;
    }

    public void setProbationaryDate(String probationaryDate) {
        this.probationaryDate = probationaryDate == null ? null : probationaryDate.trim();
    }

    public String getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus == null ? null : dataStatus.trim();
    }
    
	public String toString() {
		return "{code=序号,name=姓名,sex=性别,nation=民族,birthday=出生年月,"
				+"idCard=身份证号码,classroom=班级,profession=专业,studentLevel=学生层次"
				+ ",applicationDate=成为积极分子时间,lectureNum=党校期数,probationaryDate=确认发展对象时间}";
	}
}